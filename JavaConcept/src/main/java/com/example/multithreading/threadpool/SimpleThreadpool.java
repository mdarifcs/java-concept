package com.example.multithreading.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleThreadpool {
	private static AtomicInteger poolCount = new AtomicInteger(0);
	private Queue<Runnable> runnables;
	private AtomicBoolean execute;
	private List<SimpleThreadPoolThread> threads;

	public SimpleThreadpool(int threadCount) {
		poolCount.incrementAndGet();
		this.runnables = new ConcurrentLinkedQueue<Runnable>();
		this.execute = new AtomicBoolean(true);
		this.threads = new ArrayList<>();

		for (int threadIndex = 0; threadIndex < threadCount; threadIndex++) {
			SimpleThreadPoolThread thread = new SimpleThreadPoolThread(
					"SimpleThreadpool" + poolCount.get() + "Thread" + threadIndex, this.runnables, this.execute);
			thread.start();
			threads.add(thread);
		}
	}
	
	public static SimpleThreadpool getInstance() {
		return getInstance(Runtime.getRuntime().availableProcessors());
	}
	
	public static SimpleThreadpool getInstance(int threadCount) {
		return new SimpleThreadpool(threadCount);
	}
	
	public void execute(Runnable runnable) {
		if (this.execute.get()) 
			this.runnables.add(runnable);
		else 
			throw new IllegalStateException("Threadpool terminating, unable to execute runnable");
	}
	
	public void terminate() {
		runnables.clear();
		stop();
	}
	
	public void stop() {
		execute.set(false);
	}

	public void awaitTermination(long timeout) throws TimeoutException {
        if (this.execute.get()) {
            throw new IllegalStateException("Threadpool not terminated before awaiting termination");
        }
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime <= timeout) {
            boolean flag = true;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        throw new TimeoutException("Unable to terminate threadpool within the specified timeout (" + timeout + "ms)");
    }

    public void awaitTermination() throws TimeoutException {
        if (this.execute.get()) {
            throw new IllegalStateException("Threadpool not terminated before awaiting termination");
        }
        while (true) {
            boolean flag = true;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
	
	private class SimpleThreadPoolThread extends Thread {

		private Queue<Runnable> runnables = new ConcurrentLinkedQueue<Runnable>();
		private AtomicBoolean execute;

		public SimpleThreadPoolThread(String name, Queue<Runnable> runnables, AtomicBoolean execute) {
			super(name);
			this.runnables = runnables;
			this.execute = execute;
		}

		@Override
		public void run() {
			try {
				while (execute.get() || !runnables.isEmpty()) {
					Runnable runnable;
					while ((runnable = runnables.poll()) != null) {
						runnable.run();
					}
					Thread.sleep(10);
				}
			} catch (RuntimeException | InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
	

}

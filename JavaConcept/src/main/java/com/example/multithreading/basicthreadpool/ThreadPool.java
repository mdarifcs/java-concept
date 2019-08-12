package com.example.multithreading.basicthreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
	private BlockingQueue<Runnable> taskQueue = null;
	private List<PoolThread> threads = new ArrayList<>();
	private boolean isStopped = false;
	
	public ThreadPool(int noOfThread, int maxNoOfTasks) {
		this.taskQueue = new ArrayBlockingQueue<Runnable>(maxNoOfTasks);
		
		for (int i = 0; i < noOfThread; i++) {
			threads.add(new PoolThread(taskQueue));
		}
		
		for (PoolThread poolThread : threads) {
			poolThread.start();
		}
	}
	
	public synchronized void execute(Runnable task) {
		if (this.isStopped) throw new IllegalStateException("ThreadPool is stopped");
		this.taskQueue.add(task);
	}
	
	public synchronized void stop() {
		this.isStopped = true;
		for (PoolThread thread : threads) {
			thread.doStop();
		}
	}
}

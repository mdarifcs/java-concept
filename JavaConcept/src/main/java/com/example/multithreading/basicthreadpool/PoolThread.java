package com.example.multithreading.basicthreadpool;

import java.util.concurrent.BlockingQueue;

public class PoolThread extends Thread{

	private BlockingQueue<Runnable> taskQueue = null;
	private boolean isStopped = false;
	
	public PoolThread(BlockingQueue<Runnable> taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	@Override
	public void run() {
		while (!isStopped) {
			try {
				Runnable runnable = taskQueue.poll();
				runnable.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void doStop() {
		isStopped = true;
		this.isInterrupted();
	}
	
	public synchronized boolean isStopped() {
		return isStopped;
	}
}

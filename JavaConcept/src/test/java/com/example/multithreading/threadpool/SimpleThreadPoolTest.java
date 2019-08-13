package com.example.multithreading.threadpool;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class SimpleThreadPoolTest {

	 @Test
	    public void testSimpleThreadpool() throws Exception {
	        int runnableCount = 10;
	        SimpleThreadpool threadpool = SimpleThreadpool.getInstance();
	        final AtomicInteger count = new AtomicInteger(0);
	        Runnable r = new Runnable() {
	            @Override
	            public void run() {
	                count.getAndIncrement();
	            }
	        };
	        for (int i = 0; i < runnableCount; i++) {
	            threadpool.execute(r);
	        }
	        threadpool.stop();
	        threadpool.awaitTermination();
	        Assert.assertEquals("Runnables executed should be same as runnables sent to threadpool", runnableCount, count.get());
	    }

	    @Test
	    public void testSimpleThreadpoolCustomThreadcount() throws Exception {
	        int threadCount = 20;
	        SimpleThreadpool threadpool = SimpleThreadpool.getInstance(threadCount);
	        final AtomicInteger count = new AtomicInteger(0);
	        Runnable r = new Runnable() {
	            @Override
	            public void run() {
	                count.getAndIncrement();
	                try {
	                    Thread.sleep(200);
	                } catch (Exception e) {
	                    //Do nothing
	                }
	            }
	        };
	        for (int i = 0; i < threadCount; i++) {
	            threadpool.execute(r);
	        }
	        threadpool.stop();
	        // Threadpool should stop within 300ms as there are enough threads to handle all runnables
	        threadpool.awaitTermination(300);
	        Assert.assertEquals("All runnables must be executed", threadCount, count.get());
	    }

	    @Test
	    public void testAwaitTermination() throws Exception {
	        int runnableCount = 6;
	        SimpleThreadpool threadpool = SimpleThreadpool.getInstance(runnableCount / 2);
	        final AtomicInteger count = new AtomicInteger(0);
	        Runnable r = new Runnable() {
	            @Override
	            public void run() {
	                count.getAndIncrement();
	                try {
	                    Thread.sleep(100);
	                } catch (Exception e) {
	                    //Do nothing
	                }
	            }
	        };
	        for (int i = 0; i < runnableCount; i++) {
	            threadpool.execute(r);
	        }
	        threadpool.stop();
	        threadpool.awaitTermination();
	        Assert.assertEquals("Execution should await all runnables", runnableCount, count.get());
	    }

//	    @Test(expected = TimeoutException.class)
//	    public void testAwaitTerminationWithTimeout() throws Exception {
//	        int runnableCount = 10;
//	        SimpleThreadpool threadpool = SimpleThreadpool.getInstance(runnableCount / 2);
//	        final AtomicInteger count = new AtomicInteger(0);
//	        Runnable r = new Runnable() {
//	            @Override
//	            public void run() {
//	                count.getAndIncrement();
//	                try {
//	                    Thread.sleep(200);
//	                } catch (Exception e) {
//	                    //Do nothing
//	                }
//	            }
//	        };
//	        for (int i = 0; i < runnableCount; i++) {
//	            threadpool.execute(r);
//	        }
//	        threadpool.stop();
//	        // Threadpool should throw an exception here as the runnables cannot finish execution before the timeout
//	        threadpool.awaitTermination(300);
//	    }

	    @Test
	    public void testTerminate() throws Exception {
	        int runnableCount = 10;
	        SimpleThreadpool threadpool = SimpleThreadpool.getInstance(runnableCount / 2);
	        final AtomicInteger count = new AtomicInteger(0);
	        Runnable r = new Runnable() {
	            @Override
	            public void run() {
	                count.getAndIncrement();
	                try {
	                    Thread.sleep(200);
	                } catch (Exception e) {
	                    //Do nothing
	                }
	            }
	        };
	        for (int i = 0; i < runnableCount; i++) {
	            threadpool.execute(r);
	        }
	        threadpool.terminate();
	        // Threadpool should terminate before all runnables are executed
	        threadpool.awaitTermination(300);
	        Assert.assertFalse("Threadpool should terminate without executing pending runnables", runnableCount == count.get());
	    }

}

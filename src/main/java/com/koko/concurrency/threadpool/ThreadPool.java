package com.koko.concurrency.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	volatile boolean isRunning;
	private LinkedBlockingQueue<Runnable> blockingQueue;
	private WorkerThread[] workerThreads;

	public ThreadPool(int poolSize) {
		blockingQueue = new LinkedBlockingQueue<>(4);
		workerThreads = new WorkerThread[poolSize];

		// create worker threads
		for (int i = 0; i < poolSize; i++) {
			workerThreads[i] = new WorkerThread(i + "", blockingQueue);
		}

		// start all threads
		for (WorkerThread workerThread : workerThreads) {
			workerThread.start();
		}
	}

	public void execute(Runnable task) {
		synchronized (blockingQueue) {

			while (blockingQueue.size() == 4) {
				try {
					blockingQueue.wait();
				} catch (InterruptedException e) {
					System.out.println("An error occurred while queue is waiting: " + e.getMessage());
				}
			}

			blockingQueue.add(task);

			// notify all worker threads waiting for new task
			blockingQueue.notifyAll();
		}
	}
}

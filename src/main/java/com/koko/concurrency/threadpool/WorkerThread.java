package com.koko.concurrency.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class WorkerThread extends Thread {
	private LinkedBlockingQueue<Runnable> queue;

	public WorkerThread(String name, LinkedBlockingQueue<Runnable> queue) {
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {

		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						System.out.println("An error occurred while queue is waiting: " + e.getMessage());
					}
				}

				try {
					Runnable runnable = this.queue.poll();
					System.out.println(
							"worker " + Thread.currentThread().getName() + " executing thread " + runnable.toString());
					runnable.run();
					Thread.sleep(1000);

					// notify threads waiting to put task in queue
					queue.notifyAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

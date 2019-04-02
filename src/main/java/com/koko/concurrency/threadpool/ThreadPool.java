package com.koko.concurrency.threadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private LinkedBlockingQueue<Runnable> queue;


    public ThreadPool(int queueSize, int nThreads) {
        queue = new LinkedBlockingQueue<>(queueSize);

        // create worker threads
        for (int i = 0; i < nThreads; i++) {
            new WorkerThread(i + "", queue).start();
        }
    }

    public void execute(Runnable task) {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

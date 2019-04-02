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
        try {
            while (true) {
                String name = Thread.currentThread().getName();
                Runnable task = queue.take();
                System.out.println("Task Started by Thread :" + name);
                task.run();
                System.out.println("Task Finished by Thread :" + name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

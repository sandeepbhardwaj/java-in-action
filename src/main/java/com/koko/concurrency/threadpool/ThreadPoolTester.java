package com.koko.concurrency.threadpool;

public class ThreadPoolTester {

	public static void main(String[] args) {
		ThreadPool pool = new ThreadPool(2);

		for (int i = 0; i < 10; i++) {
			pool.execute(new Task(i + ""));
		}
	}

}

class Task implements Runnable {
	String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Task " + this.name + " is running");
	}

	@Override
	public String toString() {
		return this.name;
	}
}
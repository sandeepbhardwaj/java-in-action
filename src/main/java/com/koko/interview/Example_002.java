package com.koko.interview;

/**
 * TestOverloading
 */
public class Example_002 {
	public static void main(String[] args) {
		add(7, 2); // Integer
		add(7.0, 2.0); // Double
		add(7.0, 2); // Object
		add(7, 2.0); // Object



	}

	static void add(Integer a, Integer b) {
		System.out.println("Integer");
	}

	static void add(Double a, Double b) {
		System.out.println("Double");
	}

	static void add(Object a, Object b) {
		System.out.println("Object");
	}
}

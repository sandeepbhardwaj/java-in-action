package com.koko.interview;

import java.util.Collection;
import java.util.HashSet;

/**
 * Test overloading.
 * <p>
 * Which method will execute ??
 * output:- TestOverLoaded.take()
 * Explanation:- Reference type determine which overloaded version is selected at compile time.
 * Compiled class:- (new Example_001()).take((Collection)c);
 */
public class Example_001 {
	public void take(Collection c) {
		System.out.println("TestOverLoaded.take()");
	}

	public void take(HashSet c) {
		System.out.println("HashSet TestOverLoaded.take()");
	}

	public static void main(String[] args) {
		Collection c = new HashSet<>();
		new Example_001().take(c);
	}
}

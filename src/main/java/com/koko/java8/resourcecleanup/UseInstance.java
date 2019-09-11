package com.koko.java8.resourcecleanup;

@FunctionalInterface
public interface UseInstance<T, X extends Throwable> {
	void accept(T instance) throws X;
}
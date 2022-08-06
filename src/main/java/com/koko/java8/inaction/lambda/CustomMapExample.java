package com.koko.java8.inaction.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomMapExample {
	public static void main(String[] args) {

		List<String> names = Arrays.asList("CSS", "CSS3", "HTML", "Java", "Javascript", "Oracle", "MySQL");

		String name5 = names.stream().map(CustomMapExample::toUpperCase)
				.filter(CustomMapExample::greaterThanFive)
				.limit(2)
				.collect(Collectors.joining(" + "))
				.toString()
				+ " = WSM!!!";

		System.out.println(name5);
	}

	private static String toUpperCase(String s) {
		System.out.println("toUpperCase: " + s);
		return s.toUpperCase();
	}

	private static boolean greaterThanFive(String s) {
		System.out.println("greaterThanFive: " + s);
		return s.length() > 5;
	}
}

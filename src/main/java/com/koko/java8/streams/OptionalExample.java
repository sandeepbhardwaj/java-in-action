package com.koko.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.koko.java8.streams.model.Dish;
import com.koko.java8.streams.util.MenuProvider;

public class OptionalExample {

	public static void main(String[] args) {

		List<Dish> menu = MenuProvider.getMenu();
		Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();

		dish.ifPresent(System.out::println);

		List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
		Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream().map(x -> x * x).filter(x -> x % 3 == 0)
				.findFirst(); // 9

		System.out.println(firstSquareDivisibleByThree.get());
	}

}

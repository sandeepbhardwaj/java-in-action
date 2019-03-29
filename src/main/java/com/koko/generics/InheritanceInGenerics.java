package com.koko.generics;

import java.util.ArrayList;
import java.util.List;

class Fruit {
	@Override
	public String toString() {
		return "Fruit";
	}
}

class Banana extends Fruit {
	@Override
	public String toString() {
		return "Banana";
	}
}

class Orange extends Fruit {
	@Override
	public String toString() {
		return "Orange";
	}
}

public class InheritanceInGenerics {

	public static void useFruit(Fruit fruit) {
		System.out.println("received " + fruit);
	}

	public static void useFruitBasket(List<Fruit> fruits) {
		System.out.println("received " + fruits);

		// add another fruit after receiving basket
		fruits.add(new Orange());
	}

	public static void main(String[] args) {
		Banana banana = new Banana();
		Orange orange = new Orange();
		useFruit(banana);
		useFruit(orange);

		// 1. Collection of generic type
		List<Fruit> basketOfFruits = new ArrayList<Fruit>();
		basketOfFruits.add(banana);
		basketOfFruits.add(orange);
		useFruitBasket(basketOfFruits);

		// 2. Use basket of banana
		List<Banana> basketOfBanana = new ArrayList<>();
		basketOfBanana.add(banana);
		/*-
		 * useFruitBasket(List<Fruit>) in the type InheritanceInGenerics is not applicable for the arguments (List<Banana>)
		 * 
		 */
		// useFruitBasket(basketOfBanana); // will not compile

	}

}

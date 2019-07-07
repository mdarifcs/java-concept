package com.example.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		Predicate<Integer> evenPredicate = i -> i % 2 == 0;
		System.out.println(evenPredicate.test(11));
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
		list.stream().filter(e->e%2==0).forEach(e->System.out.print(e+" "));
	}

}

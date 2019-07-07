package com.example.functionalinterface;

import java.util.Arrays;
import java.util.List;

public class ConsumerDemo {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		// foreach use consumer as argument (Consumer<? super Integer> action)
		list.stream().forEach(i->System.out.print(i+" "));
	}
}

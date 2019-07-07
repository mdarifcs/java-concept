package com.example.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		Supplier<String> supplier = () -> "supplied";
		System.out.println(supplier.get());
		
		List<Object> list = Arrays.asList();
		Object result = list.stream().findAny().orElseGet(()->"not find any data in list");
		System.out.println(result);
	}
}

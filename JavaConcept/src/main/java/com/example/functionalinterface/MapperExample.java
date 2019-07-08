package com.example.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapperExample {

	public static void main(String[] args) {
		List<User> users = Arrays.asList(
				new User("Arif", 25, Arrays.asList(10,20,30)),
				new User("Kamal", 30, Arrays.asList(12,14,45)),
				new User("Rohit", 15, Arrays.asList(55,45,14)),
				new User("Sumit", 22, Arrays.asList(20,25,30))
				);
		
		Optional<Integer> result = users.stream()
				.map(user->user.getPhones().stream())
				.flatMap(stringStream->stringStream.filter(phone->phone==10))
				.findAny();
		result.ifPresent(e->System.out.println(e));
		
		Optional<User> found = users.stream()
			.filter(user->user.getPhones().contains(14))
			.findFirst();
		found.ifPresent(e->System.out.println(e));
	}
}

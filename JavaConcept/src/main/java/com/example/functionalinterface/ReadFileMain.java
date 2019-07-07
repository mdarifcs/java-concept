package com.example.functionalinterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFileMain {
	public static void main(String[] args) throws IOException {
		List<Employee> employees = Files.lines(Paths.get("C:\\Users\\mohammad.arif\\Desktop\\employee.csv"))
										.skip(1)
										.map(line->stringToEmployee(line))
										.filter(e->e!=null)
										.collect(Collectors.toList());
		
		employees.forEach(e->System.out.println(e));
	}
	
	public static Employee stringToEmployee(String line) {
		Employee emp = null;
		String[] arr = line.split("\\,");
		if (arr.length==3) 
			emp = new Employee(arr[0], Integer.valueOf(arr[1]), Double.valueOf(arr[2]));
		return emp;
	}
}

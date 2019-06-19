package com.example.clone;

public class TestCloning {
	public static void main(String[] args) throws CloneNotSupportedException {
		Department dept = new Department(1, "HR");
		Employee original = new Employee(100, "admin", dept);
		
		Employee cloned = (Employee) original.clone();
		System.out.println(cloned.getEmpId());
		System.out.println("reference: "+(original==cloned));
		
		cloned.getDepartment().setName("Finance");
		System.out.println("original: "+original.getDepartment().getName());
		System.out.println("cloned: "+cloned.getDepartment().getName());
	}
}

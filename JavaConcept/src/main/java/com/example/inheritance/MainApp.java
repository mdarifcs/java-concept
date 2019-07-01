package com.example.inheritance;

class A {
	public static void print() {
		System.out.println("parent called");
	}
}

class B extends A {
	
}

public class MainApp {
	public static void main(String[] args) {
		B.print();
		
		A a = new B();
		a.print();
		
		byte c1 = 1;
		byte c2 = 2;
		byte c3 = (byte)((int)c1+(int)c2);
	}
}

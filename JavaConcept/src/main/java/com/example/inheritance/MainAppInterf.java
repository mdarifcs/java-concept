package com.example.inheritance;

interface Parent {
	public static void doPrint() {
		System.out.println("interface: Parent");
	}
}

interface Parent2 extends Parent{
	
}

class Child implements Parent {

	public static void doPrint() {
		System.out.println("class: Child");
	}

}

public class MainAppInterf {

	public static void main(String[] args) {
		Child.doPrint();
		
	}

}

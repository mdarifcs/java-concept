package com.example.functionalinterface;

interface interf1 {
	int x = 20;
}

interface interf2 {
	int x = 10;
}

public class InterfaceConcept implements interf1, interf2{

	public static void main(String[] args) {
		//System.out.println(x); // ambiguity issue
		System.out.println(interf1.x);
		System.out.println(interf2.x);
	}

}

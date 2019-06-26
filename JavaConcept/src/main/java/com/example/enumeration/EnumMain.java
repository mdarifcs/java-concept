package com.example.enumeration;


public class EnumMain {

	public static void main(String[] args) {
		Level[] values = Level.values(); // get all defined enums
		for (Level level : values) {
			System.out.println(level);
		}
		
		System.out.println(Level.HIGH.getLevel());
		
		System.out.println(Level.LOW.normalize());
		System.out.println(Level.MEDIUM.normalize());
		System.out.println(Level.HIGH.normalize());
	}

}

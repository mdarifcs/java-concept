package com.example.enumeration;

import java.util.EnumMap;
import java.util.EnumSet;

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
		
		EnumSet<Level> enumSet = EnumSet.of(Level.LOW,Level.MEDIUM);
		System.out.println(enumSet);
		
		EnumMap<Level, String> enumMap = new EnumMap<Level, String>(Level.class);
		enumMap.put(Level.MEDIUM, "this is medium");
		enumMap.put(Level.HIGH, "this is high");
		System.out.println(enumMap);
	}

}

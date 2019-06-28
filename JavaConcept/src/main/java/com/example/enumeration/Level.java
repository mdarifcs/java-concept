package com.example.enumeration;

/**
 * @author mohammad.arif
 * Enum automatically extends java.lang.Enum, so we cannot extends other enum class
 */
public enum Level {
	LOW(1) {
		@Override
		public String normalize() {
			return "this is "+LOW+" with level "+LOW.getLevel();
		}
	},
	MEDIUM(2) {
		@Override
		public String normalize() {
			return "this is "+MEDIUM+" with level "+MEDIUM.getLevel();
		}
	},
	HIGH(3) {
		@Override
		public String normalize() {
			return "this is "+HIGH+" with level "+HIGH.getLevel();
		}
	};
	
	private int intVal;
	
	private Level(int intVal) {
		this.intVal = intVal;
	}
	
	public int getLevel() {
		return this.intVal;
	}
	
	public abstract String normalize();
		
}

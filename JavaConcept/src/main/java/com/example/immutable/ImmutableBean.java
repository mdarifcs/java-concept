package com.example.immutable;

public final class ImmutableBean {
	private final String name;
	
	public ImmutableBean(String name) {
		this.name = name;
		//this line prevent it form serialization and reflection
		System.setSecurityManager(new SecurityManager());
	}

	public String getName() {
		return name;
	}
}

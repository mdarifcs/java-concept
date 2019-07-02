package com.example.immutable;

import java.lang.reflect.Field;

public class ImmutableReflectionMain {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ImmutableBean bean = new ImmutableBean("Arif");
		System.out.printf("old value: %s%n", bean.getName());

		Field nameField = bean.getClass().getDeclaredField("name");
		nameField.setAccessible(true);
		nameField.set(bean, "Mohammad Arif");

		System.out.printf("new value: %s%n", bean.getName());

	}
	
}

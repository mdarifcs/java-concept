package com.example.clone;

/**
 * @author mohammad.arif Implementing Cloneable interface and overriding clone
 *         methods in deparment class only will not create separate copy
 *         department(deep copy) while creating clone object of employee class.
 *         To achieve deep copy (i.e. separate copy of department object) we
 *         have to modify clone object of employee class as well.
 */
public class Department implements Cloneable {
	private int id;
	private String name;

	public Department() {
	}

	
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

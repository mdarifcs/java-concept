package com.example.clone;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author mohammad.arif Implementing Cloneable interface and overriding clone
 *         methods in deparment class only will not create separate copy
 *         department(deep copy) while creating clone object of employee class.
 *         To achieve deep copy (i.e. separate copy of department object) we
 *         have to modify clone object of employee class as well.
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Department implements Cloneable {
	private int id;
	private String name;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

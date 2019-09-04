package com.example.clone;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author mohammad.arif
 * So deep cloning requires satisfaction of following rules –
 * 1. No need to separately copy primitives.
 * 2. All the member classes in original class should support cloning(i.e. implement cloneable interface)
 * and in clone method of original class in context should call super.clone() on all member classes.
 * 3. If any member class does not support cloning then in clone method, one must create a new instance
 * of that member class and copy all its attributes one by one to new member class object.
 * This new member class object will be set in cloned object. 
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Cloneable {
	private int empId;
	private String empName;
	private Department department;

	@Override
	protected Employee clone() throws CloneNotSupportedException {
		Employee cloned = new Employee();
		if (cloned instanceof Cloneable) 
			cloned =  (Employee) super.clone();
		
		Department dept = new Department();
		if (cloned!=null && dept instanceof Cloneable) 
			dept = (Department) cloned.getDepartment().clone();
				
		cloned.setDepartment(dept);
		return cloned;
	}
}

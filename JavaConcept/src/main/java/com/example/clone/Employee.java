package com.example.clone;

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
public class Employee implements Cloneable {
	private int empId;
	private String empName;
	private Department department;

	public Employee() {
	}
	
	public Employee(int empId, String empName, Department department) {
		this.empId = empId;
		this.empName = empName;
		this.department = department;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Employee cloned = new Employee();
		if (cloned instanceof Cloneable) 
			cloned =  (Employee) super.clone();
		
		Department dept = new Department();
		if (cloned!=null && dept instanceof Cloneable) 
			dept = (Department) cloned.getDepartment().clone();
				
		cloned.setDepartment(dept);
		return cloned;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", department=" + department + "]";
	}
}

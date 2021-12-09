package study.java.stream;

import java.time.LocalDate;

public class Employee {
	
	private int empId;
	
	private long salary;
	
	private LocalDate dob;
	
	private String name;
	
	private String dept;
	
	public Employee(int empId, long salary, LocalDate dob, String name, String dept) {
		super();
		this.empId = empId;
		this.salary = salary;
		this.dob = dob;
		this.name = name;
		this.dept = dept;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return this.empId;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!obj.getClass().equals(Employee.class))
			return false;
		Employee other = (Employee) obj;
		return this.empId == other.empId;
	}
	
	
	
}

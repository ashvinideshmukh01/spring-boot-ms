package study.java.stream;

import java.time.LocalDate;

public class Teacher {
	
	private int teacherId;
	private Long salary;
	private LocalDate doj;
	private String teacherName;
	private String dept;
	
	public Teacher(int teacherId, Long salary, LocalDate doj, String teacherName, String dept) {
		super();
		this.teacherId = teacherId;
		this.salary = salary;
		this.doj = doj;
		this.teacherName = teacherName;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId +"  teacherName="
				+ teacherName +"  Salary "+salary+  "]";
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public int hashCode() {
		
		return this.getTeacherId();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if((obj.getClass()).equals(Teacher.class))
			return false;
		Teacher otherObj = (Teacher) obj;
		return this.teacherId == otherObj.teacherId;
	}
	
	
	

}

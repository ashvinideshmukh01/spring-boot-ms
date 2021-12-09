package study.java.stream;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeRepository {
	
	
	
	public static ArrayList<Employee> getEmployees() {
		
		ArrayList<Employee> employess = new ArrayList<>();
		
		employess.add(new Employee(7416, Long.valueOf(35000), LocalDate.of(2016, 4, 07), "Rajveer", "COMP"));
		employess.add(new Employee(1592, Long.valueOf(80000), LocalDate.of(1991, 1, 05), "Ashvini", "COMP"));
		employess.add(new Employee(1591, Long.valueOf(80000), LocalDate.of(1991, 1, 05), "Ashvini","COMP"));
		employess.add(new Employee(2709, Long.valueOf(120000), LocalDate.of(1987,9, 27), "Ranjit","IT"));
		employess.add(new Employee(1412, Long.valueOf(50000), LocalDate.of(2018, 12, 14), "Shivtej", "IT"));
		employess.add(new Employee(3112, Long.valueOf(60000), LocalDate.of(1993, 12, 31),"Ganpa", "IT"));
		employess.add(new Employee(3108, Long.valueOf(40000), LocalDate.of(1991, 8, 31), "Jayam", "IT"));
		
		return employess;
	}
	
	 public static ArrayList<Teacher> getTeachers() {
		
		ArrayList<Teacher> teachers = new ArrayList<>();
		
		teachers.add(new Teacher(7416, Long.valueOf(35000), LocalDate.of(2021, 4, 07), "Rajveer", "COMP"));
		teachers.add(new Teacher(1592, Long.valueOf(80000), LocalDate.of(1991, 1, 05), "Ashvini", "COMP"));
		teachers.add(new Teacher(1591, Long.valueOf(80000), LocalDate.of(1991, 1, 05), "Ashvini","COMP"));
		teachers.add(new Teacher(2709, Long.valueOf(120000), LocalDate.of(1987,9, 27), "Ranjit","IT"));
		teachers.add(new Teacher(1412, Long.valueOf(50000), LocalDate.of(2020, 12, 14), "Shivtej", "IT"));
		teachers.add(new Teacher(3112, Long.valueOf(60000), LocalDate.of(1993, 12, 31),"Ganpa", "IT"));
		teachers.add(new Teacher(3108, Long.valueOf(40000), LocalDate.of(1991, 8, 31), "Jayam", "IT"));
		
		return teachers;
	}


}

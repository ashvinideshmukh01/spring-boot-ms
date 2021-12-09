package study.java.stream;

import java.util.ArrayList;
import java.util.List;

public class BackedCollectionTest {

	public static void main(String[] args) {
	
		ArrayList<Employee> employees =  EmployeeRepository.getEmployees();
		
		List<Employee> subList = employees.subList(2, 6);
		
		employees.forEach(emp -> System.out.println(emp));
		
		subList.get(0).setName("*******");
		
		System.out.println("AFTER ORIGINAL LIST MODIFICATION");
		employees.forEach(emp -> System.out.println(emp));
		
	}

}

package study.java.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class StreamPractice {

	public static void main(String[] args) {

		ArrayList<Employee> employess = EmployeeRepository.getEmployees();
		
		employess.forEach(emp -> System.out.println(emp));
		
		Iterator<Employee> empIterator = employess.iterator();
		
		while(empIterator.hasNext()) {
			Employee emp = empIterator.next();
			if(emp.getEmpId() == 1591)
				empIterator.remove();
		}
		
		System.out.println("______________________________________");
		employess.forEach(emp -> System.out.println(emp));
		
		
	}
}

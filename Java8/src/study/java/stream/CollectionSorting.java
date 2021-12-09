package study.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class CollectionSorting {

	public static void main(String[] args) {
		
		ArrayList<Employee> employees = EmployeeRepository.getEmployees();
		
		System.out.println("BEFORE");
		employees.forEach(emp -> System.out.println(emp));
		
		//Collections.sort(employees, Comparator.comparing(Employee::getName)
		//									  .thenComparing(Employee::getEmpId));
		
		//employees.stream().sorted(Comparator.comparing(Employee::getName)
		//    							    .thenComparing(Employee::getEmpId))
		//                  .collect(Collectors.toList());
		
		TreeSet<Employee> empSet = new TreeSet<Employee>(Comparator.comparing(Employee::getName)
				                   								   .thenComparing(Employee::getEmpId));
		empSet.addAll(employees);	    
		
		System.out.println("AFTER");
		empSet.forEach(emp -> System.out.println(emp));

	}

}

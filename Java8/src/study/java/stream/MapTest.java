package study.java.stream;

import java.time.LocalDate;
import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		
		HashMap<Employee, String> empCity = new HashMap<>();
		
		empCity.put(new Employee(7416, Long.valueOf(35000), LocalDate.of(2016, 4, 07), "Rajveer", "COMP"), "Pune");
		empCity.put(new Employee(7416, Long.valueOf(35000), LocalDate.of(2016, 4, 07), "Rajveer", "COMP"), "Hyderabad");
		
		System.out.println(empCity.get(new Employee(7416, Long.valueOf(35000), LocalDate.of(2016, 4, 07), "Rajveer", "COMP")));
		

	}

}

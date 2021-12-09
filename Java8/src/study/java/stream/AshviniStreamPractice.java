package study.java.stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

public class AshviniStreamPractice {

	public static void main(String[] args) {
		
		Comparator<Teacher> nameIDComparator = Comparator.comparing(Teacher::getTeacherName).thenComparing(Teacher::getTeacherId);
		
		ArrayList<Teacher> teachers = EmployeeRepository.getTeachers();
		System.out.println(teachers);
		
		LocalDate teachersJoinedbef2YearsBack = LocalDate.now().minusYears(2);
		
//		List<Teacher> listOfTeacher = teachers.stream()
//		        .filter(t -> t.getDoj().isBefore(teachersJoinedbef2YearsBack))
//		        .distinct()
//		        .map(t -> new Teacher(t.getTeacherId(), (long) (t.getSalary()*1.1), t.getDoj(), t.getTeacherName(), t.getDept()))
//		        .collect(Collectors.toList());
		
//		List<Teacher> listOfTeacher = teachers.stream()
//		        .filter(t -> t.getDoj().isBefore(teachersJoinedbef2YearsBack))
//		        .skip(1)     
//		        .map(t -> new Teacher(t.getTeacherId(), (long) (t.getSalary()*1.1), t.getDoj(), t.getTeacherName(), t.getDept()))
//		        .collect(Collectors.toList());
		
//		Teacher listOfTeacher = teachers.stream()
//		        .filter(t -> t.getDoj().isBefore(teachersJoinedbef2YearsBack))
//		        .findFirst()     
//		        .map(t -> new Teacher(t.getTeacherId(), (long) (t.getSalary()*1.1), t.getDoj(), t.getTeacherName(), t.getDept()))
//		        .get();
		
//		List<Teacher> listOfTeacher = teachers.stream()
//		        .filter(t -> t.getDoj().isBefore(teachersJoinedbef2YearsBack))
//		        .distinct()
//		        .sorted(nameIDComparator)
//		        .map(t -> new Teacher(t.getTeacherId(), (long) (t.getSalary()*1.1), t.getDoj(), t.getTeacherName(), t.getDept()))
//	        .collect(Collectors.toList());
		
//		 teachers.stream()
//		        .filter(t -> t.getDoj().isBefore(teachersJoinedbef2YearsBack))
//		        .forEach(t -> {t.setSalary((long) (t.getSalary()*1.1));});
//		             
//		 System.out.println(teachers);
		
		//System.out.println(listOfTeacher);
		
		  Map<String, Double> deptWiseList = teachers.stream().collect(Collectors.groupingBy(Teacher::getDept,Collectors.averagingLong(Teacher::getSalary)));
		  System.out.println(deptWiseList);
		  
		  LongSummaryStatistics summery = teachers.stream().collect(Collectors.summarizingLong(Teacher::getSalary));
			System.out.println(summery.getAverage());
			System.out.println(summery.getCount());	
			System.out.println(summery.getMax());	
			System.out.println(summery.getMin());	
			System.out.println(summery.getSum());	
		
		//Create Teacher list
		//Teacher id, salary, doj, name, dept
		
		//Filter all the teacher joined before 2 yeas and give salary hike of 10%
		//SELECT DISTINCT
		
		
		////Filter all the teacher joined before 2 yeas and give salary hike of 10%
		//SELECT FIRST EMPLOYEE
		
		//Filter all the teacher joined before 2 yeas and give salary hike of 10%
	    //SKIP FIRST EMPLOYEE
		
		
		
	}

}

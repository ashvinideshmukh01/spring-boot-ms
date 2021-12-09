package study.java.stream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class DateTimeAPI {

	public static void main(String[] args) {

		LocalDate ranjitDob = LocalDate.of(1991, 9, 13);
		LocalDate date30YesrsBefore = LocalDate.now().minusYears(30);
		
		System.out.println(ranjitDob.isBefore(date30YesrsBefore));//yyyy-mm-dd
		
		LocalTime time = LocalTime.of(15, 45, 30);
		System.out.println(time);
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
		 Predicate<String> isEmptyString            = s -> s.isEmpty();	
		   Function<String, Boolean> checkEmptyString = s -> s.isEmpty();
		   Consumer<String> consumerTest = s -> s.isEmpty();
		  	   
		   if(isEmptyString.test("R")) {
			   System.out.println(true);
		   }
		   
		   if(checkEmptyString.apply("R")) {
			   System.out.println(true);
		   }
			
		   Optional<String> s = Optional.empty();
		   if(s.isPresent()) {
			   System.out.println("Present");
		   }
		
	}

}

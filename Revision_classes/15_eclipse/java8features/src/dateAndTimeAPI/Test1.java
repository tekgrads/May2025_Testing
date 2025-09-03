package dateAndTimeAPI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Test1 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		int dd = date.getDayOfMonth();
		int mm = date.getMonthValue();
		int yyyy = date.getYear();
		System.out.println(dd + "/" + mm + "/" + yyyy );
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		int h = time.getHour();
		int m = time.getMinute();
		int s = time.getSecond();
		int n = time.getNano();
		System.out.println(h+ ":" + m + ":" + s + ":" + n);
		
		LocalDate birthday = LocalDate.of(1985, 9, 26);
		LocalDate today = LocalDate.now();
		Period p  =Period.between(birthday, today);
		System.out.println(p.getYears() + " " + p.getMonths() +" "+ p.getDays());
		
		
	}

}
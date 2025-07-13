package com.tekgrads;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Example24 {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.of(1995,05,28,12,45);
		System.out.println(ldt);
		
		System.out.println(ldt.plusDays(3));
		System.out.println(ldt.plusMonths(3));
		
		LocalDate birthDate = LocalDate.of(1995,05,28);
		LocalDate deathDate = LocalDate.now();
		
		Period r = Period.between(birthDate, deathDate);
		
		System.out.println(r.getYears());
		System.out.println(r.getMonths());
		System.out.println(r.getDays());
		
		Year y = Year.of(2024);
		System.out.println(y.isLeap());
		
		ZoneId zone = ZoneId.systemDefault();
		
		System.out.println(zone);
		
		ZoneId america = ZoneId.of("America/New_York");
		ZonedDateTime zdt = ZonedDateTime.now(america);
		
		System.out.println(zdt);
		
		
	}

}

package com.tekgrads;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Example23 {

	public static void main(String[] args) {
		LocalDate d = LocalDate.now();
		
		System.out.println(d);
		
		LocalTime lt = LocalTime.now();
		
		System.out.println(lt);
		
		int h = lt.getHour();
		int m = lt.getMinute();
		int s = lt.getSecond();
		System.out.println(h);
		System.out.println(m);
		System.out.println(s);
		
		int dd = d.getDayOfMonth();
		int mm = d.getMonthValue();
		int yyy = d.getYear();
		
		System.out.println(dd);
		System.out.println(mm);
		System.out.println(yyy);
		
		LocalDateTime dt = LocalDateTime.now();
		
		System.out.println(dt.getYear());
		System.out.println(dt.getHour());

	}

}

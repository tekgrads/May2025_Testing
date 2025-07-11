package com.tekgrads;
import java.util.Arrays;
import java.util.Comparator;


public class Example9 {

	public static void main(String[] args) {
		Employee [] employees = {
				new Employee("Ramesh", 28, 10000d, "HCL"),
				new Employee("Rakesh", 30, 20000d, "Accenture"),
				new Employee("Suresh", 31, 30000d, "Infosys"),
		};
		
		Arrays.sort(employees, (o1,o2)->{
			if(o1.salary>o2.salary) {
				return -1;
			} else if(o1.salary<o2.salary) {
				return 1;
			} else {
				return 0;
			}
		});
		System.out.println(Arrays.toString(employees));
		

	}

}



class MyEmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.salary>o2.salary) {
			return -1;
		} else if(o1.salary<o2.salary) {
			return 1;
		} else {
			return 0;
		}
	}
	
}

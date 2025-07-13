package com.tekgrads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example10 {

	 public static void main(String[] args) {
		 Employee_new emp = new Employee_new(102, "Suresh", 88000.00);

	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee_ext.dat"))) {
	            oos.writeObject(emp);
	            System.out.println("Employee object written using Externalization");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}

package com.tekgrads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example11 {

	 public static void main(String[] args) {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee_ext.dat"))) {
	        	Employee_new emp = (Employee_new) ois.readObject();
	            System.out.println("Read from file: " + emp);
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

}

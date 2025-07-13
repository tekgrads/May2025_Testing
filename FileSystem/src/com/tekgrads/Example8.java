package com.tekgrads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example8 {

	public static void main(String[] args) {
        Employee emp = new Employee("Rajesh", 10000, "HCL");

        try (FileOutputStream fos = new FileOutputStream("employee.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(emp);
            System.out.println("Employee object written to employee.dat");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.tekgrads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example9 {

	public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("employee.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Employee emp = (Employee) ois.readObject();
            System.out.println("Read from file: " + emp);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

package ioStreams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test9 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//creating student object 
		Student s1 = new Student();
		System.out.println(s1);
		
		//initializing student object
		s1.setSno(101);
		s1.setSname("Pqr");
		s1.setCourse("java");
		s1.setFee(10000);
		s1.setUsername("pqr");
		s1.setPassword("asdf");
		
		System.out.println(s1);
		
		//creating OOS object connecting 'object.ser' file
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.ser"));
		
		//writing s1 object state to the file (performing serialization)
		oos.writeObject(s1);  //object -> byte[] -> saving in the file
		
		System.out.println("student object data is saved");
		
		oos.close();
	
} 

}

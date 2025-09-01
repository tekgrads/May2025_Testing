package consumer;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Student{
	String name;
	int marks;
	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
}
public class Test2 {
	public static void main(String[] args) {
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student("Ram", 50));
		al.add(new Student("Ramya", 90));
		al.add(new Student("Ravi", 30));
		al.add(new Student("Swathi", 60));
		al.add(new Student("S", -60));
		Predicate<Student> p = s -> s.marks >=0;
		Function<Student, String> f = s -> {
			int marks = s.marks;
			if(marks >= 80) {
				return "A";
			}
			else if(marks >= 60) {
				return "B";
			}
			else if(marks >= 50) {
				return "C";
			}
			else if(marks >= 35) {
				return "D";
			}
			else  {
				return "F";
			}
			
		};
		Consumer<Student> c = s -> {System.out.println("name: " + s.name);
		                            System.out.println("marks: " + s.marks);
		                            System.out.println("Grade: " + f.apply(s) );
		                            System.out.println();
		};
		for(Student s : al) {     // for(datatype refvar: arrayname) { }
			if(p.test(s)) {
				c.accept(s);
			}
		}
	}
		

}

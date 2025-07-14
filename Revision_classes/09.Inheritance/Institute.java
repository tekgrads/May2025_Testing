class Person {
	
	static int eyes;
	static int ears;
	
	String name;
	double height;
	double weight;
	
	void eat() 	{ System.out.println(name + " is eating food"); }
	void sleep(){ System.out.println(name + " is Deep Sleeping");}
	void walk() { System.out.println(name + " is walking on road");}
	
}
class Student extends Person { 
	

	int sno;				  
	String course;
	double fee;
						
	void listen() { System.out.println(name + " is listening " + course); }
	void reply() { System.out.println(name + " is replying " + course + " questions");}
	void write() { System.out.println(name + " is writing " + course + " notes");}
	void read() { System.out.println(name + " is reading " + course + " notes");}
}

class Employee extends Person {
	double sal;  
	double exp;
}

class Faculty extends Employee {
	
	int fno;				
	String dept;
	
	void teach() { }
	void conductExam() { }
	
}
public class Institute { 
						
	public static void main(String[] args) {
		Person p ;
		p = new Student();
		p = new Faculty();
		
	/*	Student s1 = new Student();
		s1.name = "Ram";
		s1.course = "Core java";

		s1.eat();
		s1.listen();
		s1.read();
		s1.sleep();
	*/	
	    p .name = "Ram";
		p.eat();
		p.read();
	

	}
}
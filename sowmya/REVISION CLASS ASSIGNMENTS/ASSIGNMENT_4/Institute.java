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
	
	void teach() {System.out.println("teaching is: "+dept);}
	void conductExam() {	   	 System.out.println("facutlty number is: "+fno); }
	
}
public class Institute { 
						
	public static void main(String[] args) {
		Person p ;
		p = new Student();
		p .name = "sowmya";
		p.eyes=2;
		p.ears=2;
		p.eat();
	   p.sleep();
	   p.walk();
	   System.out.println("ears is: "+p.eyes);
	   	System.out.println("eyes is: "+p.eyes);
	System.out.println("-----------------------------------");
		Student s1 = new Student();
		s1.name = "sowmya";
		s1.course = "Core java";
		s1.sno=100;
		s1.fee=6000;
		s1.eyes=2;
		s1.ears=2;
		

		s1.eat();
		s1.listen();
		s1.read();
		s1.write();
		s1.reply();
		s1.sleep();
		s1.walk();
		 System.out.println("ears is: "+s1.ears);
	   	 System.out.println("eyes is: "+s1.eyes);
		 System.out.println("sno is: "+s1.sno);
	   	 System.out.println("fee is: "+s1.fee);
		 
		 
		 	System.out.println("-----------------------------------");
		 
		 Employee e= new Employee();

		e.eyes=2;
		e.ears=2;
		e .name = "sowmya";
		e.sal=50000.00;  
	    e.exp=2.00;

		e.eat();
		e.sleep();
		e.walk();
		 System.out.println("ears is: "+e.ears);
	   	 System.out.println("eyes is: "+e.eyes);
		  System.out.println("salary is: "+e.sal);
	   	 System.out.println("experience is: "+e.exp);
		
		 
		 
			System.out.println("-----------------------------------");
		 
		 Faculty f=new Faculty();
		 f.sal=50000.00;  
	    f.exp=2.00;
		 f.fno=200;				
		f.dept="IT";
	   f.teach();
	  f.conductExam();
	  System.out.println("salary is: "+f.sal);
	   	 System.out.println("experience is: "+f.exp);
		 System.out.println("facultyno is: "+f.sal);
	   	 System.out.println("department is: "+f.exp);
		
		
		 

	    
	}
}
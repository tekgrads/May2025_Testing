class Person
{
	int eyes = 2; 
}

class Student extends Person
{
	int sno = 101;
}

class Employee extends Person
{
	int eno = 777;
}

class Party
{
	static void eat(Person p) {         //   Person p = new Employee();
		                                                   // Person p = new Student();
		System.out.println(p.eyes);
	//	System.out.println(p.sno);
	
	//	System.out.println(p.eno);
	
		Student s1 = (Student) p;
	/*	System.out.println(s1.sno);
	*/	
	//  Employee e1 = (Employee)p;
	  
	//  System.out.println(e1.eno);
	
	}
}

class  Test
{
	public static void main(String[] args) 
	{
		Party.eat(new Student());
	//	Party.eat(new Employee());
	}
}

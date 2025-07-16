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
	static void eat(Person p) {
		System.out.println(p.eyes);
		
		if(p instanceof Student) {
		Student s1 = (Student) p;
		System.out.println(s1.sno);
		}
		
		if(p instanceof Employee) {
		Employee e1 = (Employee) p;
		System.out.println(e1.eno);
		}
		
	}
}

class  Test2
{
	public static void main(String[] args) 
	{
		Party.eat(new Student());
		Party.eat(new Employee());
	}
}

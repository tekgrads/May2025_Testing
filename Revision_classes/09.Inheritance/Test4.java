class  Person{
	int eyes;
}
class Student extends Person{
	String course;
}

class Test4{
	public static void main(String[] args) {
	/*	Person p1 = new Student();
		System.out.println("eyes: "+ p1.eyes); //
		
		p1.eyes = 2;
		System.out.println("eyes: "+ p1.eyes); //

		p1.course = "Java";
		System.out.println("course: "+p1.course); // 
	*/	
		Student p1 = new Student();
		System.out.println("eyes: "+ p1.eyes);
		
		p1.eyes = 2;
		System.out.println("eyes: "+ p1.eyes);

		p1.course = "Java";
		System.out.println("course: "+p1.course);

	}
}
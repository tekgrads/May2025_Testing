class Student
{
	int sno;
	String sname;
	
	public void setSno(int sno){
		this.sno = sno;
	}
	
public int getSno(){
		return sno;
	}
	public void setSname(String sname){
		this.sname = sname;
	}	
	public String getSname(){
		return sname;
	}
public 	void display(){
		System.out.println("Sno : " + sno + " Sname: "+ sname);
	}
}
	
class  Test
{
	public static void main(String[] args) 
	{
		Student s1 = new Student();
		s1.setSno(101);
		s1.setSname("Krishna");
		s1.getSno();
		s1.getSname();
		s1.display();
	}
}

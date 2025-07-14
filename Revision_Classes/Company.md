
class  Employee
{
	private int empno;
	private String empname;
	private double salary;
	private String dept;
	
	
	public void setEmpno(int empno){
		this.empno=empno;
	}
	public int getEmpno(){
		return empno;
	}
	
	
	
	public void setEmpname(String empname){
		this.empname=empname;
	}
	public String getEmpname(){
		return empname;
	}
	
	
	public void setSalary(double salary){
		this.salary=salary;
	}
	public double getSalary(){
		return salary;
	}
	
	
	public void setDept(String dept){
		this.dept=dept;
	}
	public String getDept(){
		return dept;
	}
	
	
	public void display(){
		System.out.println(empno+" "+empname+" "+salary+" "+dept);
	}
		
	
}


class Company
{

	public static void main(String[] args) 
	{
      Employee e1=new Employee();
	  
	  e1.setEmpno(10);
	  e1.setEmpname("sathvika");
	  e1.setSalary(150000);
	  e1.setDept("software developer");
	  e1.display();
	  double a;
	  double b;
	  a=e1.getSalary();
	  b=(a+(a*20/100));

	  System.out.println("after increasing the salary is: "+b);
	}
}

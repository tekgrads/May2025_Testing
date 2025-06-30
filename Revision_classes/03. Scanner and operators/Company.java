import java.util.Scanner;
class Company  
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		Employee e1 = new Employee ();
		System.out.println("Enter eno");
//		e1.eno = scn.nextInt(); 
		e1.eno = scn.nextInt(); scn.nextLine();
		System.out.println("Enter ename");
		e1.ename = scn.nextLine();
		System.out.println("Enter sal");
	//	e1.sal = scn.nextDouble();
		e1.sal = scn.nextDouble();scn.nextLine();
		System.out.println("Enter dept");
		e1.dept = scn.nextLine();
		System.out.println("Enter mobile");
	//	e1.mobile = scn.nextLong();
		e1.mobile = scn.nextLong();scn.nextLine();
		System.out.println("Enter email");
		e1.email = scn.nextLine();
		System.out.println("Enter gender");
		e1.gender = scn.next().charAt(0);
		System.out.println("employee details are: ");
		System.out.println("eno: " + e1.eno);	
		System.out.println("ename: " + e1.ename);	
		System.out.println("sal: " + e1.sal);	
		System.out.println("dept: " + e1.dept);	
		System.out.println("mobile: " + e1.mobile);	
		System.out.println("email: " + e1.email);	
		System.out.println("gender: " + e1.gender);	
	}
}

/*
Develop a project for BankAccount  with the fields 
bankName, branchName, ifsc, accNum, accHName, balance

You must read above values from the keyboard from the end-user(Customer)


*/
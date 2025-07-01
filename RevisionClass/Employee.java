import java.util.Scanner;

class Employee {
int eno;
String ename;
double sal;
String dept;

void readDetails(Scanner scanner) {
System.out.print("Enter Employee Number: ");
eno = scanner.nextInt();
scanner.nextLine();

System.out.print("Enter Employee Name: ");
ename = scanner.nextLine();

System.out.print("Enter Department: ");
dept = scanner.nextLine();

System.out.print("Enter Monthly Salary: ");
sal = scanner.nextDouble();
}

double annualSal() 
{
return sal * 12;
}

void increaseSal(double percent) 
{
sal += sal * (percent / 100);
}

void display() {
System.out.println("\n--- Employee Details ---");
System.out.println("Employee No    : " + eno);
System.out.println("Employee Name  : " + ename);
System.out.println("Department     : " + dept);
System.out.println("Monthly Salary : ₹" + sal);
System.out.println("Annual Salary  : ₹" + annualSal());
}
}

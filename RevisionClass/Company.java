import java.util.Scanner;

public class Company 
{
public static void main(String[] args) 
{
Scanner scanner = new Scanner(System.in);

Employee emp1 = new Employee();
Employee emp2 = new Employee();

System.out.println("Enter details for Employee 1:");
emp1.readDetails(scanner);

System.out.println("\nEnter details for Employee 2:");
emp2.readDetails(scanner);

emp1.increaseSal(10);
emp2.increaseSal(10);

emp1.display();
emp2.display();

scanner.close();
}
}

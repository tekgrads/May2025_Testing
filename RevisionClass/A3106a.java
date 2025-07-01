import java.util.Scanner;
public class As1
{
public static void main(String args[])
{
Scanner add = new Scanner(System.in);
System.out.println("enter 1st integer");
int n1 = add.nextInt();
System.out.println("enter 2nd integer");
int n2 = add.nextInt();
if (n1 > 0 && n2 > 0)
{
int sum = n1 + n2;
System.out.println("Sum = " + sum);
}
else 
{
System.out.println("Error: Both numbers must be positive. Negative values are not allowed.");
}
}
}
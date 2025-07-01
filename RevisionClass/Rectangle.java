import java.util.Scanner;

class Rectangle{
double length;
double breadth;

void readvalues(Scanner sc)
{
System.out.println("enter length");
length = sc.nextDouble();

System.out.println("enter breadth");
breadth = sc.nextDouble();
}

double findArea()
{
return length * breadth;
}

double findPerimeter()
{
return 2 * (length + breadth);
}

void display() 
{
System.out.println("\n--- Rectangle Details ---");
System.out.println("Length     : " + length);
System.out.println("Breadth    : " + breadth);
System.out.println("Area       : " + findArea());
System.out.println("Perimeter  : " + findPerimeter());
}
}

📌 1. Data Types
Data types define the kind of data a variable can hold.
In Java, data types are divided into two categories:

👉 a. Primitive Data Types
These are the most basic data types built into the language:

Type	Description	Example
int	Integer values	int x = 10;
float	Decimal values	float y = 3.14f;
double	Larger decimals	double z = 99.99;
char	Single character	char c = 'A';
boolean	True/False	boolean flag = true;
byte	Small integer	byte b = 127;
short	Small integer	short s = 32000;
long	Large integer	long l = 123456789L;

👉 b. Non-Primitive (Reference) Data Types
These refer to objects:

String, Array, Class, Interface, etc.

📌 2. Class
A class is a blueprint or template for creating objects.

➕ Example:
java
Copy
Edit
class Car {
    // attributes (fields)
    String color;
    int speed;

    // methods (behavior)
    void drive() {
        System.out.println("The car is driving");
    }
}
Here, Car is a class with attributes and methods.

📌 3. Object
An object is an instance of a class. It represents a real-world entity.

➕ Example:
java
Copy
Edit
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();  // object created
        myCar.color = "Red";
        myCar.drive();          // method called
    }
}
📌 4. Access Modifiers
Access modifiers define the scope or visibility of variables, methods, or classes.

Modifier	Access Level
public	Accessible from anywhere
private	Accessible only within the same class
protected	Accessible within the package and by subclasses
(default)	No keyword – accessible only within the same package

📌 5. Explanation of public static void main(String args[])
This is the entry point of every Java program.

✅ Breakdown:
Keyword	Meaning
public	The method is accessible from anywhere, even by the JVM.
static	No need to create an object to call the main method. JVM calls it directly using the class name.
void	Method does not return any value.
main	The main method name, called by JVM to start the program.
String[] args	It accepts command-line arguments as a String array.

➕ Example Program:
java
Copy
Edit
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
✅ Summary
Data Types: Defines kind of data (int, float, String, etc.)

Class: Blueprint of an object.

Object: Instance of a class.

Access Modifiers: Controls visibility (public, private, etc.)

public static void main(String[] args): Entry point for Java apps.
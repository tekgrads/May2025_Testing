🧮 Data Types in Java
To perform computations, we need placeholders to contain data such as numbers, decimals, characters, and strings.

Commonly Used Types
int

float

char

String

BigDecimal

Primitive Data Types
Type	Description
byte	8-bit integer
short	16-bit integer
int	32-bit integer
long	64-bit integer
float	Single-precision 32-bit float
double	Double-precision 64-bit float
char	16-bit Unicode character
boolean	true or false

🧱 Object-Oriented Programming (OOP) in Java
Java is an object-oriented language, meaning everything revolves around classes and objects.

Core Concepts
Class: Blueprint/prototype for objects.

Object: Real-world entity with state (attributes) and behavior (methods).

Four Pillars of OOP
Concept	Description
Abstraction	Hiding internal details and showing only essential features.
Inheritance	Mechanism where one class acquires properties of another.
Polymorphism	Ability to take many forms (static and dynamic).
Encapsulation	Wrapping data and code together as a single unit (data hiding).

Other Relationships
Association: A general connection between two classes.

Aggregation: A HAS-A relationship with shared ownership.

Composition: A strong HAS-A relationship with exclusive ownership.

🔧 Java Class Structure Example
java
Copy
Edit
class Employee {
    String name;
    int age;
    String companyName;
    int salary;
    String deptName;

    public void printEmployeeDetails() {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("companyName = " + companyName);
        System.out.println("salary = " + salary);
        System.out.println("deptName = " + deptName);
    }
}
📦 Encapsulation with Access Specifiers
java
Copy
Edit
public class Employee {
    private String name;
    private int age;
    private String companyName;
    private int salary;
    private String deptName;

    public void printEmployeeDetails() {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("companyName = " + companyName);
        System.out.println("salary = " + salary);
        System.out.println("deptName = " + deptName);
    }
}
Access Specifiers
Modifier	Scope
private	Accessible only within the class
default	Accessible within the package (no modifier specified)
protected	Accessible within the package and subclasses
public	Accessible from everywhere


🔁 Creating and Using Objects



Employee employee1 = new Employee();
employee1.name = "Suresh";
employee1.age = 22;
employee1.salary = 10000;
employee1.deptName = "HR";
Employee.companyName = "HCL";

Employee employee2 = new Employee();
employee2.name = "Ramesh";
employee2.age = 23;
employee2.salary = 20000;
employee2.deptName = "Software";
Employee.companyName = "ACCENTURE";
🧠 Functions in Java
Function Declaration and Calling
java
Copy
Edit
public int add(int a, int b) {
    int result = a + b;
    return result;
}

// Calling the function
int result = add(1, 2);
🧪 Sample Program with Command-Line Arguments
public class A {
    public static void main(String[] args) {
        System.out.println("Hello World " + args[0]);
        System.out.println("Hello World " + args[1]);
        System.out.println("Hello World " + args[2]);
    }
}
⚠️ Common Errors
ClassNotFoundException: Ensure the class is defined and available on the classpath.

ArrayIndexOutOfBoundsException: Make sure you're not accessing an array index that doesn't exist.

🔄 Static vs Non-Static
Type	Description
static	Belongs to the class, shared across all instances
non-static	Belongs to the object, each object has its own copy











1. Enums in Java
Definition:
Enums (short for enumerations) define a fixed set of constants. They are type-safe and can have fields, constructors, and methods.

Characteristics:
Type-safe

Constants are final and static

Can implement interfaces but cannot extend classes

Common methods:

values() → Returns array of enum constants

valueOf(String name) → Returns enum constant with the specified name

ordinal() → Returns the index of the constant

Example:
java
Copy
Edit
public enum Day {
    SUNDAY, MONDAY, TUESDAY
}

public class TestEnum {
    public static void main(String[] args) {
        for (Day d : Day.values()) {
            System.out.println(d + " - " + d.ordinal());
        }
    }
}
Interview Questions:
Q1: What is an enum in Java?
A: Enum is a special data type used to define collections of constants in a type-safe manner.

Q2: Can enums have methods and constructors?
A: Yes, enums can have both methods and constructors.

2. Wrapper Classes
Definition:
Wrapper classes provide a way to use primitive data types as objects.

Purpose:
Work with collections (like ArrayList)

Provide utility methods

Allow nulls where primitives can’t be used

Primitive to Wrapper Mapping:
Primitive	Wrapper
byte	Byte
short	Short
int	Integer
long	Long
float	Float
double	Double
char	Character
boolean	Boolean

Example:
java
Copy
Edit
int x = 10;
Integer obj = x; // Autoboxing
int y = obj;     // Unboxing
Interview Questions:
Q1: Why do we need wrapper classes?
A: Wrapper classes are needed when primitives must be treated as objects, especially in collections.

Q2: What is the difference between int and Integer?
A: int is a primitive type, while Integer is an object wrapper for int.

3. Autoboxing and Unboxing
Autoboxing:
Automatic conversion from primitive to wrapper type.

Unboxing:
Automatic conversion from wrapper type to primitive.

Example:
java
Copy
Edit
int num = 100;
Integer obj = num; // Autoboxing
int result = obj;  // Unboxing
Interview Questions:
Q1: What is autoboxing?
A: It is the automatic conversion of a primitive type to its corresponding wrapper class.

Q2: When does unboxing occur?
A: When an object of a wrapper class is assigned to a primitive type.

4. Upcasting
Definition:
Assigning a child class object to a parent class reference.

Example:
java
Copy
Edit
Integer a = 100;
Number n = a; // Upcasting
Purpose:
Generalize code

Use polymorphism

Interview Questions:
Q1: What is upcasting in Java?
A: Upcasting is assigning a subclass object to a superclass reference.

Q2: Why is upcasting used?
A: It allows for generalized handling of objects and enables polymorphism.

5. Autowidening
Definition:
Automatic promotion of smaller primitive types to larger types.

Widening Order:
byte → short → int → long → float → double

Example:
java
Copy
Edit
void test(long l) { ... }
byte b = 10;
test(b); // Autowidening from byte to long
Interview Questions:
Q1: What is autowidening?
A: Autowidening is the automatic conversion from a smaller to a larger primitive data type.

Q2: Is char to int widening possible?
A: Yes, since char has a numeric Unicode value.

6. Inner Classes
Definition:
Classes declared inside another class.

Types:
Member Inner Class

Static Nested Class

Local Inner Class

Anonymous Inner Class

Benefits:
Logical grouping

Better encapsulation

Access to outer class members

Example – Anonymous Inner Class:
java
Copy
Edit
abstract class A {
    abstract void m1();
}

public class Test {
    public static void main(String[] args) {
        A obj = new A() {
            void m1() {
                System.out.println("Anonymous Inner Class Method");
            }
        };
        obj.m1();
    }
}
Interview Questions:
Q1: What are inner classes in Java?
A: A class defined inside another class is called an inner class.

Q2: Can inner classes access private members of the outer class?
A: Yes, inner classes can access all members (including private) of the outer class.

7. parseInt() Method
Definition:
Integer.parseInt(String s) converts a String to an int.

Use Case:
Parsing numeric input from strings (e.g., from user or files)

Example:
java
Copy
Edit
String s = "123";
int num = Integer.parseInt(s);
Interview Questions:
Q1: What does Integer.parseInt() do?
A: It converts a string to an integer.

Q2: What happens if the string cannot be parsed?
A: It throws NumberFormatException.


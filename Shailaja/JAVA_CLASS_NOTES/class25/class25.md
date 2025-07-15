Abstract class:



An abstract class in Java 8 is a class that cannot be instantiated and is declared using the abstract keyword.

Can contain abstract methods (without implementation) and concrete methods (with implementation)
Can include constructors and member variables
Can contain static methods
Must be extended by a subclass to provide implementations for abstract methods
Default Method
A default method in Java 8 is a method in an interface that has a default implementation using the default keyword.

Allows interfaces to provide behavior without forcing all implementing classes to override it
Interface with Default Method
All variables inside an interface are implicitly public, static, and final
No instance variables, constructors, IIBs (Instance Initialization Blocks), or SIBs (Static Initialization Blocks)
Cannot override methods from Object class
Functional interfaces with default methods can be used with lambda expressions
Difference: Interface with Default Method vs Abstract Class
Interface with Default Method
Variables are always public static final
No instance variables
Cannot declare constructors, IIBs, SIBs
Cannot override Object class methods
Can refer to lambda expressions if functional interface
Abstract Class
Can have instance variables
Can declare constructors, IIBs, SIBs
Can override Object class methods
Cannot refer to lambda expressions
Example 1: Program Using Default Method
package com.tekgrads;

interface I1 {
    default void m1() {
        System.out.println("this is method1 on the interface");
    }
}

class Test3 implements I1 {
    public void m1() {
        System.out.println("this is a m1 on class test1");
    }
}

public class Example11 {
    public static void main(String[] args) {
        Test3 t = new Test3();
        t.m1();
    }
}
Output:

this is a m1 on class test1
Example 2: Default Methods in Two Interfaces
package com.tekgrads;

abstract class A {
    int a = 10;
    public void m1() {
        // implementation
    }
}

interface I2 {
    int a = 10;
    default void m1() {
        System.out.println("1st interface with m1 method");
    }
}

interface I3 {
    default void m1() {
        System.out.println("2nd interface with m1 method");
    }
}

class I4 implements I2, I3 {
    public void m1() {
        I3.super.m1();
    }
}

public class Example12 {
    public static void main(String[] args) {
        I4 i = new I4();
        i.m1();
    }
}
Output:

2nd interface with m1 method
Static Methods in Interfaces
We can use many static methods in interfaces.
Static methods can be called using the interface name.
No need to create an object in the main() method to call static methods.
Example 3: Program on Static Methods
package com.tekgrads;

interface I5 {
    public static void m1(int a) {
        System.out.println("The value of a in static method on interface is: " + a);
    }
}

class Test4 implements I5 {
    public static void m1(int a) {
        System.out.println("The value of a in static method on class is: " + a);
    }
}

public class Example13 {
    public static void main(String[] args) {
        I5.m1(10);
        Test4.m1(20);
    }
}
Output:

The value of a in static method on interface is: 10
The value of a in static method on class is: 20
Example 4: Interface with main() Method
package com.tekgrads;

public interface Example14 {
    public static void main(String[] args) {
        System.out.println("Interface with main method");
    }
}
Output:

Interface with main method
Lambda Expressions with Custom Objects
Example 5: Customize Employee Details Using Lambda Expression
Employee.java
package com.tekgrads;

class Employee implements Comparable<Employee> {
    String name;
    Integer age;
    Double salary;
    String companyName;

    public Employee(String name, Integer age, Double salary, String companyName) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", companyName=" + companyName + "]";
    }

    @Override
    public int compareTo(Employee o) {
        return this.salary.compareTo(o.salary);
    }
}
Example15.java
package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

public class Example15 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("shailaja", 28, 50000d, "HCL"),
            new Employee("ankitha", 26, 20000d, "Accenture"),
            new Employee("sadha", 30, 40000d, "Infosys"),
        };

        Arrays.sort(employees, (o1, o2) -> o1.salary > o2.salary ? -1 : (o1.salary < o2.salary ? 1 : 0));

        System.out.println(Arrays.toString(employees));
    }
}

class MyEmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.salary > o2.salary) {
            return -1;
        } else if (o1.salary < o2.salary) {
            return 1;
        } else {
            return 0;
        }
    }
}
Output:

[Employee [name=shailaja, age=28, salary=50000.0, companyName=HCL],
 Employee [name=ankitha, age=30, salary=40000.0, companyName=Infosys],
 Employee [name=sadha, age=26, salary=20000.0, companyName=Accenture]]
Predicate in Java
Predicate is one of the Functional Interfaces which has a Single Abstract Method (SAM) called test(). The return type is boolean. It will return either true or false. If we want to use any boolean condition, then we can use predicates.

Example 6: Program on Predicates
package com.tekgrads;

import java.util.function.Predicate;

public class Example16 {

	public static void main(String[] args) {
		Predicate<String> p1 = str -> str.length() > 10;
		
		System.out.println(p1.test("test"));
		System.out.println(p1.test("predicatefunctionjava8"));

		Predicate<String> p2 = Predicate.isEqual("predicate"); // checking the string is equal or not
		System.out.println(p2.test("pre"));
		System.out.println(p2.test("predicate"));

		Predicate<Integer> p3 = i -> i > 10;
		Predicate<Integer> p4 = i -> i % 2 == 0;

		System.out.println(p3.and(p4).test(40)); // true if both conditions are true
		System.out.println(p3.and(p4).test(10));

		System.out.println(p3.negate().test(11)); // opposite result

		Predicate<Integer> p5 = i -> i < 50;
		Predicate<Integer> p6 = i -> i % 2 == 0;

		System.out.println(p5.or(p6).test(101)); // true if either condition is true
		System.out.println(p5.or(p6).test(10));
	}
}
Output
false
true

false
true

true
false

false

false
true
Function in Java
Function is one of the Functional Interfaces. It has a Single Abstract Method (SAM) called apply(). The return type can be any type. It uses two generic types: one for input and one for output.

Syntax:

Function<Input, Output>
Example 7: Program on Function
package com.tekgrads;

import java.util.function.Function;

public class Example17 {

	public static void main(String[] args) {

		Function<String, Integer> f = s -> s.length();
		System.out.println(f.apply("function"));

		Function<Integer, Integer> f1 = i -> i * i;
		System.out.println(f1.apply(10));

		Function<String, Integer> f2 = s -> s.length() - s.replaceAll(" ", "").length();
		System.out.println(f2.apply("this is a fucntion1"));

		Function<String, String> f4 = s -> s.toUpperCase();
		Function<String, String> f5 = s -> s.substring(1, 7);
		System.out.println(f4.andThen(f5).apply("this is a fucntion2"));

		Function<String, String> f6 = s -> s.toLowerCase();
		System.out.println(f6.apply("THIS IS A FUNCTION3"));
	}
}
Output
8
100
3
HIS IS
this is a function3

Java 8 Features: Abstract Classes, Interfaces, Lambda Expressions, and Functional Interfaces
🔷 Abstract Class
Declared using the abstract keyword.

Cannot be instantiated directly.

Can contain:

Abstract methods (without implementation)

Concrete methods (with implementation)

Member variables

Constructors

Static methods

Must be extended by a subclass to implement abstract methods.

🔷 Default Method in Interfaces
Introduced in Java 8.

Declared using the default keyword in an interface.

Provides default behavior without forcing all implementing classes to override it.

🆚 Interface with Default Method vs Abstract Class
Feature	Interface (with Default Method)	Abstract Class
Variables	Always public static final	Can have instance variables
Constructors	❌ Not allowed	✅ Allowed
IIBs / SIBs	❌ Not allowed	✅ Allowed
Override Object methods	❌ Not allowed	✅ Allowed
Use with Lambda Expressions	✅ If functional interface	❌ Not applicable

📘 Example 1: Default Method in Interface
java
Copy
Edit
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

kotlin
Copy
Edit
this is a m1 on class test1
📘 Example 2: Default Methods in Two Interfaces
java
Copy
Edit
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

kotlin
Copy
Edit
2nd interface with m1 method
🔷 Static Methods in Interfaces
Static methods can be defined inside interfaces.

Called using the interface name.

No object creation is needed.

📘 Example 3: Static Methods in Interface
java
Copy
Edit
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

vbnet
Copy
Edit
The value of a in static method on interface is: 10
The value of a in static method on class is: 20
📘 Example 4: Interface with main() Method
java
Copy
Edit
package com.tekgrads;

public interface Example14 {
    public static void main(String[] args) {
        System.out.println("Interface with main method");
    }
}
Output:

sql
Copy
Edit
Interface with main method
🔷 Lambda Expressions with Custom Objects
📘 Example 5: Sorting Employees Using Lambda Expression
Employee.java
java
Copy
Edit
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
java
Copy
Edit
package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

public class Example15 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("sowmya", 28, 50000d, "HCL"),
            new Employee("navya", 26, 20000d, "Accenture"),
            new Employee("Sneha", 30, 40000d, "Infosys"),
        };

        Arrays.sort(employees, (o1, o2) -> o1.salary > o2.salary ? -1 : (o1.salary < o2.salary ? 1 : 0));

        System.out.println(Arrays.toString(employees));
    }
}
Output:

css
Copy
Edit
[Employee [name=sowmya, age=28, salary=50000.0, companyName=HCL],
 Employee [name=Sneha, age=30, salary=40000.0, companyName=Infosys],
 Employee [name=navya, age=26, salary=20000.0, companyName=Accenture]]
🔷 Predicate Functional Interface
Defined in java.util.function.Predicate.

Functional Interface with method boolean test(T t).

Used to evaluate a condition (returns true/false).

📘 Example 6: Predicates
java
Copy
Edit
package com.tekgrads;

import java.util.function.Predicate;

public class Example16 {

    public static void main(String[] args) {
        Predicate<String> p1 = str -> str.length() > 10;
        System.out.println(p1.test("test"));                     // false
        System.out.println(p1.test("predicatefunctionjava8"));   // true

        Predicate<String> p2 = Predicate.isEqual("predicate");
        System.out.println(p2.test("pre"));                      // false
        System.out.println(p2.test("predicate"));                // true

        Predicate<Integer> p3 = i -> i > 10;
        Predicate<Integer> p4 = i -> i % 2 == 0;
        System.out.println(p3.and(p4).test(40));                 // true
        System.out.println(p3.and(p4).test(10));                 // false
        System.out.println(p3.negate().test(11));                // false

        Predicate<Integer> p5 = i -> i < 50;
        Predicate<Integer> p6 = i -> i % 2 == 0;
        System.out.println(p5.or(p6).test(101));                 // false
        System.out.println(p5.or(p6).test(10));                  // true
    }
}
🔷 Function Functional Interface
Defined in java.util.function.Function.

Method: R apply(T t)

Takes an input and returns a result.

📘 Example 7: Function Interface
java
Copy
Edit
package com.tekgrads;

import java.util.function.Function;

public class Example17 {

    public static void main(String[] args) {
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("function"));                      // 8

        Function<Integer, Integer> f1 = i -> i * i;
        System.out.println(f1.apply(10));                             // 100

        Function<String, Integer> f2 = s -> s.length() - s.replaceAll(" ", "").length();
        System.out.println(f2.apply("this is a fucntion1"));          // 3

        Function<String, String> f4 = s -> s.toUpperCase();
        Function<String, String> f5 = s -> s.substring(1, 7);
        System.out.println(f4.andThen(f5).apply("this is a fucntion2")); // HIS IS

        Function<String, String> f6 = s -> s.toLowerCase();
        System.out.println(f6.apply("THIS IS A FUNCTION3"));          // this is a function3
    }
}
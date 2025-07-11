# Abstract Class in Java 8

An **abstract class** is a class that cannot be instantiated directly. It is declared using the `abstract` keyword.

### 🔹 Key Features

- Can contain **abstract methods** (no implementation) and **concrete methods** (with implementation)
- Can have **constructors** and **member variables**
- May define **static methods**
- Must be extended by a subclass to implement abstract methods

---

# Default Method in Java 8

A **default method** in an interface provides a standard implementation. It is declared using the `default` keyword.

### ✅ Why Use It?

- Allows you to add new methods to interfaces without breaking existing code

---

# Interface with Default Method – Rules

- Variables in interfaces are implicitly `public static final`
- Cannot declare:
  - Instance variables
  - Constructors
  - IIBs (Instance Initialization Blocks)
  - SIBs (Static Initialization Blocks)
- Cannot override methods from `Object` class
- Functional interfaces with default methods can be used in lambda expressions

---

# 🔄 Interface vs Abstract Class (with Default Methods)

| Feature                           | Interface (with default method) | Abstract Class                 |
|----------------------------------|----------------------------------|-------------------------------|
| Instance Variables               | ❌ Not Allowed                   | ✅ Allowed                    |
| Constructors                     | ❌ Not Allowed                   | ✅ Allowed                    |
| Default Implementation           | ✅ (via `default`)               | ✅ (normal methods)           |
| Lambda Support                   | ✅ (Functional Interface only)   | ❌ Not Supported              |
| Object class method override     | ❌ Not allowed                   | ✅ Allowed                    |

---

# 🧪 Example 1: Overriding Default Method

```java
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

🧪 Example 2: Handling Multiple Default Methods from Interfaces
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

 Static Methods in Interfaces
Defined using static keyword

Can be invoked via interface name

Object instantiation is not required

🧪 Example 3: Static Method in Interface and Class
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
🧪 Example 4: Interface with main() Method
package com.tekgrads;

public interface Example14 {
    public static void main(String[] args) {
        System.out.println("Interface with main method");
    }
}

🧠 Lambda Expression with Custom Objects
🧪 Example 5: Sorting Employees by Salary
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
            new Employee("Anu", 28, 50000d, "Amazon"),
            new Employee("Navvi", 26, 20000d, "Accenture"),
            new Employee("Siddhi", 30, 40000d, "Infosys"),
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

✅ Predicate Functional Interface
Predicate<T> is a functional interface that takes a value of type T and returns a boolean result.

📌 Useful Methods:
test(T t)

and(), or(), negate()

isEqual(Object obj)

🧪 Example 6: Predicate Usage
package com.tekgrads;

import java.util.function.Predicate;

public class Example16 {

	public static void main(String[] args) {
		Predicate<String> p1 = str -> str.length() > 10;
		
		System.out.println(p1.test("test"));
		System.out.println(p1.test("predicatefunctionjava8"));

		Predicate<String> p2 = Predicate.isEqual("predicate");
		System.out.println(p2.test("pre"));
		System.out.println(p2.test("predicate"));

		Predicate<Integer> p3 = i -> i > 10;
		Predicate<Integer> p4 = i -> i % 2 == 0;

		System.out.println(p3.and(p4).test(40));
		System.out.println(p3.and(p4).test(10));

		System.out.println(p3.negate().test(11));

		Predicate<Integer> p5 = i -> i < 50;
		Predicate<Integer> p6 = i -> i % 2 == 0;

		System.out.println(p5.or(p6).test(101));
		System.out.println(p5.or(p6).test(10));
	}
}
✅ Function Interface in Java
Function<T, R> is a functional interface that takes an input T and returns a result R.

📌 Key Method:
apply(T t)
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

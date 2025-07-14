
# Abstract Class
An abstract class in Java 8 is a class that **cannot be instantiated** and is declared using the `abstract` keyword.

- Can contain both **abstract methods** and **concrete methods**
- Can include **constructors** and **member variables**
- Can define **static methods**
- Must be **extended** by a subclass to provide implementations for abstract methods

---

# Default Methods in Interfaces
A `default` method allows interfaces to have methods with default implementation using the `default` keyword.

- Helps in providing backward compatibility
- Implementing classes **don’t need** to override default methods

---

# Interface with Default Method

- All variables are implicitly `public static final`
- Cannot have instance variables, constructors, IIBs, or SIBs
- Cannot override methods from `Object` class
- Can use lambda expressions if it is a **functional interface**

---

# Interface vs Abstract Class (with Default Methods)

## Interface with Default Method
- Variables are `public static final`
- No instance-level features like constructors
- Can't override `Object` methods
- Can be used with lambdas if functional

## Abstract Class
- Can contain instance variables and constructors
- Can override `Object` class methods
- Cannot be used directly with lambda expressions

---

# Example 1: Default Method in Interface
```java
interface I1 {
    default void m1() {
        System.out.println("Interface method m1");
    }
}

class Test3 implements I1 {
    public void m1() {
        System.out.println("Class implementation of m1");
    }
}

public class Example11 {
    public static void main(String[] args) {
        new Test3().m1();
    }
}
```
**Output:**
```
Class implementation of m1
```
...
## Customize Employee Details Using Lambda Expression

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

## Prediacte in java:
Predicate is one of the Functional Interfaces which has a Single Abstract Method (SAM) called test(). 
 
 ## Example:
 import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;

        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(7));  // false
    }
}

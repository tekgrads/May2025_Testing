
# Java Constructors

In Java, a **constructor** is a special method used to create objects. It has the same name as the class and doesn't have any return type. It runs automatically when an object is created.



## 1. Constructor Example

```java
class Student {
    String name;
    int age;

    // Constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Amit", 21);
        s.display();
    }
}
````



## 2. Constructor Overloading

Constructor overloading means having **multiple constructors** in a class with different parameters. It helps to create objects in different ways.

```java
class Employee {
    String name;
    int id;

    // Constructor 1
    Employee() {
        name = "Unknown";
        id = 0;
    }

    // Constructor 2
    Employee(String n) {
        name = n;
        id = 0;
    }

    // Constructor 3
    Employee(String n, int i) {
        name = n;
        id = i;
    }

    void show() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

public class Test {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("Ravi");
        Employee e3 = new Employee("Sneha", 101);

        e1.show();
        e2.show();
        e3.show();
    }
}
```



## 3. Constructor Overriding (Clarification)

In Java, **constructor overriding is NOT allowed**. Constructors are not inherited, so they **can’t be overridden** like methods.


### Example:

```java
class Animal {
    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {
    Dog() {
        super();  // calling parent constructor
        System.out.println("Dog constructor");
    }
}

public class Demo {
    public static void main(String[] args) {
        Dog d = new Dog();
    }
}
```

### Output:

```
Animal constructor
Dog constructor
```

So, we **don't override** constructors, but we **can reuse** the parent constructor using `super()`.


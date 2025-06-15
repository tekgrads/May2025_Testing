# Day 5: Core Java

## Constructors

- A **constructor** is a special method used to initialize objects.
- It is executed **only when an object is created**.
- The constructor must have the **same name as the class**.
- A class can have multiple constructors with different parameter lists (constructor overloading).

---

### Default Constructor

- A default constructor has **no parameters**.
- Syntax:

```java
class Student {
    Student() {
        System.out.println("Default constructor executed");
    }

    public static void main(String[] args) {
        Student s1 = new Student();
    }
}

###Parameterized Constructor
-A parameterized constructor contains parameters to initialize values.
class Student {
    String name;
    int age;

    Student(String n, int a) {
        name = n;
        age = a;
    }

    public void display() {
        System.out.println(name + "  " + age);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Cherry", 20);
        s1.display();
    }
}

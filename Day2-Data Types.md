# Day 2 - Java

## Data Types

There are 8 types of data types in Java which act as containers for storing the data:

- **Number**
- **Decimal**
- **Characters**
- **Strings**: Group of characters

### Primitive Data Types:

1. `byte` – 1 byte  
2. `short` – 2 bytes  
3. `int` – 4 bytes  
4. `long` – 8 bytes  
5. `float` – 4 bytes  
6. `double` – 8 bytes  
7. `char` – 2 bytes  
8. `boolean` – JVM dependent size  

---

## OOPS Concepts

- **Class**: Blueprint for creating objects  
- **Object**: An instance representing a real-world entity  
- **Abstraction**  
- **Polymorphism**  
- **Encapsulation**  
- **Inheritance**

---

## Java Program Using Function Method

```java
class Student {
    String name;
    int age;
    int rollno;
    String deptname;

    void studentDetails() {
        System.out.println("This is " + name + " and belongs to " + deptname);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Charitha";
        s1.deptname = "IT";
        s1.studentDetails();
    }
}

##Access Specifiers
private: Accessible only within the same class

public: Accessible from everywhere in the program

default: Accessible only within the same package

protected: Accessible within the same package and subclasses
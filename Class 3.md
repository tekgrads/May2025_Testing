# 🧑‍💻 Java Class 3 Notes (06/06/2025)

---

## 🔁 Java Compilation and Execution

| Step       | Command            | Description                               |
|------------|--------------------|-------------------------------------------|
| Compile    | `javac A.java`     | Converts `.java` file to bytecode         |
| Run        | `java A`           | JVM converts bytecode to machine code     |

- **Compiler**: Platform-independent (produces bytecode)  
- **Interpreter**: Platform-dependent (executes bytecode on JVM)

---

## 🧮 Data Types in Java

### ➤ Types of Data:
- Numbers  
- Decimals  
- Characters  
- Strings (group of characters)

### ➤ Primitive Data Types:

| Data Type | Size    | Description                  |
|-----------|---------|------------------------------|
| `byte`    | 1 byte  | Whole numbers (-128 to 127)  |
| `short`   | 2 bytes | Short integers               |
| `int`     | 4 bytes | Integer numbers              |
| `long`    | 8 bytes | Large integer numbers        |
| `float`   | 4 bytes | Decimal (less precision)     |
| `double`  | 8 bytes | Decimal (more precision)     |
| `char`    | 2 bytes | Single Unicode character     |
| `boolean` | 1 bit   | `true` or `false` (JVM-specific) |

> Primitive types are used to store **simple values**.

---

## 🔧 Object-Oriented Programming (OOP)

Java is based on **OOP Principles**:

### 🔑 Key Concepts:

1. **Class** – Blueprint of an object  
2. **Object** – Instance of a class  
3. **Abstraction** – Hiding internal details  
4. **Inheritance** – Reusing code via parent-child classes  
5. **Polymorphism** – Many forms (method overloading/overriding)  
6. **Encapsulation** – Hiding data using private members and methods  
7. **Association, Aggregation, Composition** – Class relationships

> 🔹 In Java, everything is written inside a **class**.

---

## 🏗️ Defining Class and Object

### ✅ Basic Structure

```java
class Employee {
    String name;
    int age;
    int salary;
}
```

### ✅ Object Usage

```java
Employee emp = new Employee();
emp.name = "John";
emp.age = 25;
emp.salary = 50000;
```

---

## 🔐 Access Specifiers in Java

| Specifier   | Access Level                         |
|-------------|--------------------------------------|
| `public`    | Accessible everywhere                |
| `private`   | Accessible only inside the class     |
| *(default)* | Accessible within the same package   |
| `protected` | Same package + subclasses            |

---

## 💡 Static vs Non-Static

- **Static**: Belongs to the class, shared among all instances  
- **Non-Static**: Belongs to each object individually

---

## 🧾 Example with Access Specifiers

```java
public class Employee {
    private String name;
    private int age;
    private int salary;

    public void printEmployeeDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }
}
```

---

## 👋 Basic Java Program (Hello World)

```java
public class A {
    public static void main(String[] args) {
        System.out.println("Hello world! " + args[0]);
        System.out.println("Hello world! " + args[1]);
        System.out.println("Hello world! " + args[2]);
    }
}
```

> ✔ `args[]` is used to take **command-line inputs**.

---

📘 **End of Class 3 Notes**

# Java Basics Summary

## 1. Data Types in Java
Java has two types of data types:

### a. Primitive Data Types:
- **byte**: 1 byte, range: -128 to 127
- **short**: 2 bytes, range: -32,768 to 32,767
- **int**: 4 bytes, range: -2^31 to 2^31-1
- **long**: 8 bytes, range: -2^63 to 2^63-1
- **float**: 4 bytes, decimal values (single precision)
- **double**: 8 bytes, decimal values (double precision)
- **char**: 2 bytes, holds a single character (Unicode)
- **boolean**: 1 bit, holds true or false

### b. Non-Primitive Data Types:
- **String**
- **Arrays**
- **Classes**
- **Interfaces**

## 2. Operators in Java
Operators are symbols that perform operations on variables and values.

### a. Arithmetic Operators:
`+`, `-`, `*`, `/`, `%`

### b. Relational (Comparison) Operators:
`==`, `!=`, `>`, `<`, `>=`, `<=`

### c. Logical Operators:
`&&`, `||`, `!`

### d. Assignment Operators:
`=`, `+=`, `-=`, `*=`, `/=`, `%=`, etc.

### e. Unary Operators:
`+`, `-`, `++`, `--`, `!`

### f. Bitwise Operators:
`&`, `|`, `^`, `~`, `<<`, `>>`, `>>>`

## 3. Concepts in Java

### a. Object-Oriented Programming (OOP):
- **Class**: Blueprint for objects
- **Object**: Instance of a class
- **Inheritance**: One class acquires properties of another
- **Polymorphism**: One method behaves differently in different contexts
- **Encapsulation**: Wrapping data and code into a single unit
- **Abstraction**: Hiding complex details and showing only essentials

### b. Constructor:
Used to initialize objects. Has the same name as the class.

### c. Interface:
A reference type that can contain constants and abstract methods.

## 4. Access Specifiers in Java
Access specifiers (or modifiers) define the scope or visibility of variables, methods, classes, etc.

### a. **public**:
Accessible from anywhere.

### b. **private**:
Accessible only within the same class.

### c. **protected**:
Accessible within the same package or subclasses in other packages.

### d. **default** (no modifier):
Accessible only within the same package.

## 5. Static and Non-Static in Java

### a. **Static**:
- Belongs to the class rather than instances.
- Can be called without creating an object.
- Example: `static int count;`

### b. **Non-Static**:
- Belongs to instances (objects) of the class.
- Each object has its own copy.
- Example: `int age;`

### Example:
```java
class MyClass {
    static int staticVar = 10;
    int nonStaticVar = 20;

    static void staticMethod() {
        System.out.println("Static Method");
    }

    void nonStaticMethod() {
        System.out.println("Non-Static Method");
    }
}

public class Test {
    public static void main(String[] args) {
        MyClass.staticMethod(); // No need to create object

        MyClass obj = new MyClass();
        obj.nonStaticMethod(); // Needs object to call
    }
}
```

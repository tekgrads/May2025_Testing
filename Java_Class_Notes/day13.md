# Java Exception Handling – Detailed Explanation with Examples

Exception handling in Java is a **powerful mechanism** that allows a program to detect and manage runtime errors, ensuring normal flow of execution is maintained even after problems occur.

---

##  What is an Exception?

An **exception** is an unwanted or unexpected event that disrupts the normal flow of the program.

Example:
```java
int a = 10 / 0; // ArithmeticException: division by zero
```

---

##  Types of Exceptions

1. **Checked Exceptions** (Compile-time):
   - Must be handled using try-catch or declared using `throws`.
   - Examples: `IOException`, `SQLException`

2. **Unchecked Exceptions** (Runtime):
   - Occur at runtime and are not checked during compilation.
   - Examples: `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`

---

##  Basic Exception Handling

```java
public class Example {
    public static void main(String[] args) {
        try {
            int num = 50 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
        System.out.println("Program continues...");
    }
}
```

---

##  try-catch-finally Block

- **try** – contains code that might throw an exception.
- **catch** – handles the exception.
- **finally** – always executes, used to close resources.

```java
try {
    int[] arr = {1, 2};
    System.out.println(arr[3]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Index error: " + e);
} finally {
    System.out.println("This will always execute.");
}
```

---

##  Multiple Catch Blocks

```java
try {
    String str = null;
    System.out.println(str.length());
} catch (ArithmeticException e) {
    System.out.println("Arithmetic Error");
} catch (NullPointerException e) {
    System.out.println("Null reference error");
}
```

---

##  Nested try Blocks

```java
try {
    try {
        int b = 100 / 0;
    } catch (ArithmeticException e) {
        System.out.println("Division error");
    }
    int[] a = new int[5];
    a[10] = 4;
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index error");
}
```

---

##  Throw Keyword

Used to throw a specific exception.

```java
public class ThrowExample {
    static void validate(int age) {
        if (age < 18)
            throw new ArithmeticException("Not eligible to vote");
        else
            System.out.println("Eligible to vote");
    }

    public static void main(String[] args) {
        validate(15);
    }
}
```

---

##  Throws Keyword

Used in method signatures to declare exceptions.

```java
public class ThrowsExample {
    static void method() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        method();
        System.out.println("Done sleeping.");
    }
}
```

---

##  Custom Exception

You can define your own exception by extending `Exception` class.

```java
class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

public class Test {
    static void check(int value) throws MyException {
        if (value < 0)
            throw new MyException("Negative number not allowed");
    }

    public static void main(String[] args) {
        try {
            check(-5);
        } catch (MyException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
```

---

## Table

| Keyword     | Purpose                                    |
|-------------|--------------------------------------------|
| `try`       | Defines block of code to test for errors   |
| `catch`     | Handles the error                          |
| `finally`   | Executes code after try-catch (always)     |
| `throw`     | Throws a single exception manually         |
| `throws`    | Declares possible exceptions in method     |

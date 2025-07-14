# Exception Handling in Java

## What is Exception Handling?

**Exception Handling** in Java is a mechanism to handle runtime errors, so the normal flow of the application can be maintained.

An **exception** is an unwanted or unexpected event that disrupts the normal flow of the program.

---

## Types of Exceptions

### 1. **Checked Exceptions**

* Exceptions that are checked at compile-time.
* Must be handled using try-catch or declared using `throws`.
* Example: `IOException`, `SQLException`

### 2. **Unchecked Exceptions**

* Exceptions that occur at runtime.
* Not checked by the compiler.
* Example: `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`

---

## Exception Hierarchy

```
Object
 └── Throwable
     ├── Error (serious problems, not handled by programs)
     └── Exception
         ├── IOException (checked)
         └── RuntimeException (unchecked)
```

---

## Keywords Used in Exception Handling

### 1. `try`

Block of code that might throw an exception.

### 2. `catch`

Block of code that handles the exception.

### 3. `finally`

Block that always executes, used to clean up resources.

### 4. `throw`

Used to explicitly throw an exception.

### 5. `throws`

Used to declare exceptions.

---

## Basic Syntax

```java
try {
    // code that may throw an exception
} catch (ExceptionType e) {
    // code to handle the exception
} finally {
    // cleanup code (optional)
}
```

---

## Example:

```java
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;  // will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            System.out.println("This block always executes");
        }
    }
}
```

---

## Multiple Catch Blocks

```java
try {
    int arr[] = new int[5];
    arr[10] = 50; // may throw exception
} catch (ArithmeticException e) {
    System.out.println("Arithmetic Exception occurred");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array Index is Out Of Bounds");
} catch (Exception e) {
    System.out.println("Parent Exception occurs");
}
```

---

## Throw Keyword

```java
public class ThrowExample {
    static void validate(int age) {
        if (age < 18)
            throw new ArithmeticException("Not eligible to vote");
        else
            System.out.println("Eligible to vote");
    }

    public static void main(String[] args) {
        validate(16);
    }
}
```

---

## Throws Keyword

```java
import java.io.*;

public class ThrowsExample {
    void readFile() throws IOException {
        FileReader fr = new FileReader("file.txt");
        BufferedReader br = new BufferedReader(fr);
    }

    public static void main(String[] args) throws IOException {
        ThrowsExample obj = new ThrowsExample();
        obj.readFile();
    }
}
```

---

## Custom Exceptions

You can create your own exception class by extending `Exception` class.

```java
class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

public class TestCustomException {
    public static void main(String[] args) throws MyException {
        throw new MyException("This is a custom exception");
    }
}
```

---


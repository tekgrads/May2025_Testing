
# Exception Handling in Java

## What is an Exception?
- An **exception** is an unwanted or unexpected event that occurs during the execution of a program.
- It disrupts the normal flow of the program.
- In Java, exceptions are objects that represent the occurrence of an abnormal condition.

## Types of Exceptions
1. **Checked Exceptions**: Known to the compiler, must be handled using try-catch or throws.
   - Example: IOException, SQLException
2. **Unchecked Exceptions**: Not checked at compile time.
   - Example: ArithmeticException, NullPointerException

## Exception Hierarchy
```
java.lang.Object
   ↳ java.lang.Throwable
       ↳ java.lang.Exception
           ↳ java.lang.RuntimeException
       ↳ java.lang.Error
```

## Exception Handling Keywords
- `try`: Encloses code that might throw an exception.
- `catch`: Catches and handles exceptions.
- `finally`: Block that executes regardless of whether an exception occurred.
- `throw`: Used to explicitly throw an exception.
- `throws`: Declares exceptions in method signature.

## Syntax Example:
```java
try {
    // risky code
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Arithmetic Exception: " + e.getMessage());
} finally {
    System.out.println("This block always executes");
}
```

## Custom Exception
You can create your own exception by extending the `Exception` class.

```java
class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

public class Test {
    public static void main(String[] args) {
        try {
            throw new MyException("Custom error occurred");
        } catch (MyException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
```

## Multiple Catch Blocks
```java
try {
    int[] arr = new int[5];
    arr[10] = 50;
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Index out of bounds");
} catch (Exception e) {
    System.out.println("General exception caught");
}
```

## Nested try blocks
```java
try {
    try {
        int num = 10 / 0;
    } catch (ArithmeticException e) {
        System.out.println("Inner catch: Division by zero");
    }
} catch (Exception e) {
    System.out.println("Outer catch: General exception");
}
```

## Use of `throws`
```java
void readFile() throws IOException {
    FileReader file = new FileReader("data.txt");
    file.read();
}
```

## Best Practices
- Handle specific exceptions before general ones.
- Always close resources in `finally` or use try-with-resources.
- Avoid catching `Throwable` unless absolutely necessary.

---

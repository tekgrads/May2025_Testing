
# 📘 Java Notes: Exception Handling 

---

## 🔹 What is Exception Handling?

Exception Handling is Java’s way to **manage unexpected situations** (errors) during program execution, without crashing the entire application.

---

## 🔹 Core Blocks in Exception Handling

| Keyword  | Role                                                       |
|----------|------------------------------------------------------------|
| `try`    | Code that might throw an exception goes here               |
| `catch`  | Handles specific exceptions that occur in the `try` block  |
| `finally`| Executes regardless of exception (used for cleanup)        |
| `throw`  | Used to manually throw an exception                        |
| `throws` | Declares exception possibility in method signature         |

---

## 🔹 Exception Hierarchy (Flow Chart Style)

```plaintext
            Throwable
           /         \
      Exception     Error
       /     \
  Checked  Unchecked
           (RuntimeException)
```

✅ **Checked**: Caught at compile time (`IOException`, `SQLException`)  
❌ **Unchecked**: Occur at runtime (`NullPointerException`, `ArithmeticException`)  
❗ **Errors**: Serious system issues (`OutOfMemoryError`, `StackOverflowError`)

---

## 🔹 Example 1: Basic Try-Catch

```java
public class Example1 {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero: " + e.getMessage());
        }
    }
}
```

🧾 Output:
```
Can't divide by zero: / by zero
```

---

## 🔹 Example 2: Null Pointer Exception

```java
public class Example2 {
    public static void main(String[] args) {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Null reference error");
        }
    }
}
```

---

## 🔹 Example 3: Multiple Catch Blocks

```java
public class MultiCatch {
    public static void main(String[] args) {
        try {
            int[] a = new int[3];
            System.out.println(a[5]);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of range");
        } catch (Exception e) {
            System.out.println("General exception");
        }
    }
}
```

---

## 🔹 Example 4: Finally Block

```java
public class FinallyDemo {
    public static void main(String[] args) {
        try {
            int x = 5 / 0;
        } catch (Exception e) {
            System.out.println("Exception handled");
        } finally {
            System.out.println("Cleanup in finally block");
        }
    }
}
```

---

## 🔹 Example 5: Using `throw`

```java
public class ThrowDemo {
    public static void main(String[] args) {
        int age = 16;
        if (age < 18) {
            throw new ArithmeticException("Not eligible for voting");
        }
    }
}
```

🧾 Output:
```
Exception in thread "main" java.lang.ArithmeticException: Not eligible for voting
```

---

## 🔹 Example 6: Using `throws`

```java
public class ThrowsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Sleeping...");
        Thread.sleep(2000); // May throw InterruptedException
        System.out.println("Woke up");
    }
}
```

---

## 🔹 Example 7: Custom Exception

```java
class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}

public class CustomDemo {
    public static void main(String[] args) throws InvalidAgeException {
        int age = 15;
        if (age < 18) {
            throw new InvalidAgeException("Underage for license");
        }
    }
}
```

🧾 Output:
```
Exception in thread "main" InvalidAgeException: Underage for license
```

---

## 🧠 Summary

- Java uses `try`, `catch`, `finally` for structured error handling
- `throw` is used to raise exceptions manually
- `throws` tells that a method may cause exceptions
- Exceptions are categorized as **checked**, **unchecked**, and **errors**

---

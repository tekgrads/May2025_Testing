
# 📘 Exception Handling in Java (Simplified)

## ✅ What is Exception Handling?
Exception handling is a way to manage errors during a program’s execution so it doesn’t crash. It helps your program continue running even when something goes wrong.

---

## 🔑 Key Concepts

### 1. Exception
An **error** that happens during the execution of a program. In Java, exceptions are objects from the `Throwable` class.

### 2. try block
Code that might cause an exception is put inside the `try` block.

### 3. catch block
Catches and handles the error that occurred in the `try` block.

### 4. finally block
This block always runs, whether an exception occurred or not. Used for cleanup, like closing files.

---

## 🧩 Important Keywords

### `throw`
Used to **manually raise** an exception.

### `throws`
Used in method declaration to say that this method might **cause an exception**.

---

## 🧪 Types of Exceptions

### I. Checked Exceptions
These are checked during **compilation**. Example: `IOException`, `SQLException`.

### II. Unchecked Exceptions
These happen during **runtime**. Example: `NullPointerException`, `ArrayIndexOutOfBoundsException`.

---

## ⚠️ Errors
Serious issues that are **not meant to be handled**, like `OutOfMemoryError`.

---

## 💻 Java Program Examples

### Example 1: Try-Catch
```java
try {
    int i = 1 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

### Example 2: NullPointerException
```java
String str = null;
try {
    System.out.println(str.length());
} catch (NullPointerException e) {
    System.out.println("Null error: " + e.getMessage());
}
```

---

### Example 3: NumberFormatException
```java
String str = "abc";
try {
    int num = Integer.parseInt(str);
} catch (NumberFormatException e) {
    System.out.println("Invalid number: " + e.getMessage());
}
```

---

### Example 4: ArrayIndexOutOfBoundsException
```java
int[] arr = new int[3];
try {
    System.out.println(arr[5]);
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array error: " + e.getMessage());
}
```

---

### Example 5: One Try, Multiple Catches
```java
try {
    String str = null;
    System.out.println(str.length());
} catch (NullPointerException e) {
    System.out.println("Null error: " + e.getMessage());
} catch (Exception e) {
    System.out.println("General error: " + e.getMessage());
}
```

---

### Example 6: One Catch for Multiple Exceptions
```java
try {
    int i = 1 / 0;
    int num = Integer.parseInt("abc");
} catch (ArithmeticException | NumberFormatException e) {
    System.out.println("Caught an error: " + e.getMessage());
}
```

---

### Example 7: Try-Catch-Finally
```java
try {
    int a = 1 / 0;
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    System.out.println("This block always runs.");
}
```

---

### Example 8: Checked Exception with Thread.sleep
```java
try {
    Thread.sleep(3000);
} catch (InterruptedException e) {
    System.out.println("Sleep interrupted: " + e.getMessage());
}
```

---

### Example 9: Exception in Static Method
```java
static void test() {
    int i = 1 / 0;
}

public static void main(String[] args) {
    try {
        test();
    } catch (ArithmeticException e) {
        System.out.println("Static method error: " + e.getMessage());
    }
}
```

---

### Example 10: Using `throws`
```java
static void test() throws InterruptedException {
    Thread.sleep(3000);
}
```

---

### Example 11: Inheritance and Exceptions
```java
class B {
    void add(String x, String y) throws NumberFormatException {
        int a = Integer.parseInt(x);
        int b = Integer.parseInt(y);
        System.out.println("Sum: " + (a + b));
    }
}

class C {
    void div(int x, int y) throws ArithmeticException {
        int c = x / y;
        System.out.println("Div: " + c);
    }
}
```

---

## 🧠 Summary
- Use `try-catch` to handle exceptions.
- `finally` runs no matter what.
- Checked = compile-time, Unchecked = runtime.
- Use `throw` to create exceptions manually.
- Use `throws` to declare that a method may cause an exception.

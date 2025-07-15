# Java Concepts: Exception Handling

---

### Exception Handling

**Definition:**
Exception handling is the mechanism to handle runtime errors so the program can continue its normal flow.
**Use:** Prevents abrupt termination of programs and handles errors gracefully.

---

### Try and Catch

**Definition:**
`try-catch` blocks are used to handle exceptions during program execution.
**Use:** Allows specific code to be tried and if an exception occurs, it is caught in the `catch` block.

```java
class Main2 {
    public static void main(String[] args) {
        System.out.println("using try and 1 catch block");
        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("an exception is raised " + e.getMessage());
        }
        System.out.println("end of try catch");
    }
}
```

---

### NullPointerException

**Definition:**
Occurs when calling a method or accessing a property on a null object.
**Use:** Helps identify logic issues in object references.

```java
class Main4 {
    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println("String length: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
        System.out.println("program completed");
    }
}
```

---

### NumberFormatException

**Definition:**
Occurs when trying to convert a string to a number that is not a valid format.
**Use:** Helps validate input and ensure type correctness.

```java
public class Main5 {
    public static void main(String[] args) {
        String str1 = "hello";
        try {
            int number = Integer.parseInt(str1);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Number format exception is " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught General Exception: " + e.getMessage());
        }
        System.out.println("program completed");
    }
}
```

---

### ArrayIndexOutOfBoundsException

**Definition:**
Occurs when accessing an array with an index that is out of range.
**Use:** Prevents accessing invalid array indices.

```java
public class Main6 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        try {
            System.out.println("Array element: " + arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        System.out.println("program completed");
    }
}
```

---

### Multiple Catch Blocks

**Definition:**
Allows handling of different exceptions with separate `catch` blocks.
**Use:** Enables fine-grained error handling for multiple types.

```java
public class Main3 {
    public static void main(String[] args) {
        String str = null;
        int[] arr = new int[3];
        String str1 = "hello";

        try {
            System.out.println("String length: " + str.length());
            System.out.println("Array element: " + arr[5]);
            int number = Integer.parseInt(str1);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Number format exception is " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught General Exception: " + e.getMessage());
        }
        System.out.println("program completed");
    }
}
```

---

### Finally Block

**Definition:**
`finally` block always executes, whether or not an exception is thrown.
**Use:** Used to release resources like files, database connections.

```java
class Main8 {
    public static void main(String[] args) {
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            System.out.println("Exception is: " + e.getMessage());
        } finally {
            System.out.println("this is a final block");
        }
        System.out.println("programs stops");
    }
}
```

---

### Checked Exception (Thread Sleep Example)

**Definition:**
Checked exceptions are verified by the compiler and must be handled or declared.
**Use:** Used for handling external or predictable errors like file or thread operations.

```java
class Main9 {
    public static void main(String[] args) {
        System.out.println("main starts");
        System.out.println("Program will pause for 3 seconds");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("thread sleeps");
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("program stops");
    }
}
```

---

### Try Catch with Static Method

**Definition:**
Exceptions inside static methods can be caught by calling methods within try-catch blocks.
**Use:** Useful when dividing logic into reusable static functions.

```java
public class Main10 {
    public static void main(String[] args) {
        System.out.println("Main method Started");
        try {
            test();
        } catch (ArithmeticException e) {
            System.out.println("Exception is " + e.getMessage());
        }
        System.out.println("Main method Ended");
    }

    static void test() {
        System.out.println("Test method Started");
        int i = 1 / 0;
        System.out.println("Test Method Ended");
    }
}
```

---

### Throws Keyword

**Definition:**
`throws` is used to declare an exception that a method might throw.
**Use:** Shifts responsibility of handling the exception to the calling method.

```java
class Main11 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");
        test();
        System.out.println("main ends");
    }

    static void test() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("program pause for 3 seconds");
    }
}
```

---

### Inheritance with Exception Handling

**Definition:**
Exception handling can be applied in subclass methods as per the specific logic.
**Use:** Helps handle exceptions in different inherited methods separately.

```java
class A {
    public void m1() {
        System.out.println("method 1 on class A");
    }
}

class B extends A {
    public void add(String x, String y) throws NumberFormatException {
        int a1 = Integer.parseInt(x);
        int b1 = Integer.parseInt(y);
        int c1 = a1 + b1;
        System.out.println("addition is: " + c1);
    }
}

class C extends A {
    public void div(int x, int y) throws ArithmeticException {
        int c1 = x / y;
        System.out.println("division is: " + c1);
    }
}

public class Main12 {
    public static void main(String[] args) {
        B b = new B();
        try {
            b.add("10", "20");
            b.add("abc", "5");
        } catch (NumberFormatException e) {
            System.out.println("Addition Error: " + e.getMessage());
        }

        C c = new C();
        try {
            c.div(10, 5);
            c.div(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Division error: " + e.getMessage());
        }

        System.out.println("program stops");
    }
}
```

---

### Custom Exception using Throw

**Definition:**
Custom exceptions are user-defined exceptions using `throw` keyword.
**Use:** Helps in business rule validations like age limit, balance check.

```java
class AgeInvalidException extends Exception {
    public AgeInvalidException() {}

    public AgeInvalidException(String message) {
        super(message);
    }
}

public class Main14 {
    public static void main(String[] args) throws AgeInvalidException {
        int age = 17;
        if (age < 18) {
            throw new AgeInvalidException("Age is less than 18, not eligible for voting");
        } else {
            System.out.println("You are eligible for Voting");
        }
    }
}
```




# Java Exception Handling

Exception Handling is the process of responding to the occurrence of exceptions – anomalous or exceptional conditions requiring special processing.

---

## 🔹 Compile-time Error
> Errors caused by external factors that stop the program at compile time.

## 🔹 Exceptions
> Conditions that occur during the execution of a program, disrupting the normal flow.

---

## 📌 Example 1: ArithmeticException

```java
public class Example1 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        int i = 1 / 0; // Causes ArithmeticException
        System.out.println("End Of program");
    }
}
```

**Output:**
```
Started the program
Arithmetic Exception
```

---

## 📌 Example 2: NumberFormatException

```java
public class Example2 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        String age = "test"; // String age = "25";
        Integer num = Integer.parseInt(age);
        System.out.println("End Of program");
    }
}
```

**Output:**
```
Started the program
Number format Exception
```

---

## 📌 Example 3: Try-Catch Block

```java
public class Example3 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        try {
            int i = 1 / 0;
            System.out.println("This line will not be executed");
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        }
        System.out.println("End Of program");
    }
}
```

**Output:**
```
Started the program
Caught an ArithmeticException: / by zero
End of program
```

---

## 📌 Example 4: NullPointerException

```java
public class Example4 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        try {
            String str = null;
            System.out.println("Length of string: " + str.length());
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Caught a NumberFormatException: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException: " + e.getMessage());
        }
        System.out.println("End Of program");
    }
}
```

**Output:**
```
Started the program
Caught a NullPointerException: null
End of program
```

---

## 📌 Example 5: Multi-Catch Block

```java
public class Example5 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        try {
            String age = "test";
            Integer num = Integer.parseInt(age);
            String str = null;
            System.out.println("Length of string: " + str.length());
        } catch (ArithmeticException | NumberFormatException | NullPointerException e) {
            System.out.println("Caught an: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("End Of program");
    }
}
```

---

## 📌 Example 6: Finally Block

```java
public class Example6 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        int k = 1 / 0;
        try {
            System.out.println("Start of try");
            int i = 1 / 0;
        } finally {
            System.out.println("Finally block executed");
        }
        System.out.println("End of Program");
    }
}
```

**Output:**
```
Started the program
ArithmeticException
```

---

## 📌 Example 7: Checked Exception

```java
public class Example7 {
    public static void main(String[] args) {
        try {
            Thread.sleep(1000); // Checked exception
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted!");
        }
    }
}
```

---

## 📌 Example 8: Static Method with Exception

```java
public class Example8 {
    public static void main(String[] args) {
        System.out.println("Main method Started");
        try {
            test();
        } catch (ArithmeticException e) {
            e.printStackTrace();
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

**Output:**
```
Main method Started
Test method Started
ArithmeticException: / by zero
Main method Ended
```

---

## 📌 Example 9: `throws` Keyword

```java
public class Example9 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main method Started");
        test();
        System.out.println("Main method Ended");
    }

    static void test() throws InterruptedException {
        System.out.println("Test method Started");
        Thread.sleep(100);
        System.out.println("Test Method Ended");
    }
}
```

---

## 📌 Example 10: Exception with Inheritance

```java
class A {
    void test1() throws InterruptedException {}
    void test2() throws Exception {}
}

class B extends A {
    void test1() {}  // Valid - no exception
    void test2() {}  // Valid - no exception
}

class C extends A {
    void test1() throws InterruptedException {}
    void test2() throws InterruptedException {}
}

class D extends A {
    void test1() throws Exception {}
}

public class Example10 {
    public static void main(String[] args) {
        System.out.println("main");
    }
}
```

---

## 📌 Example 11: Call with `throws`

```java
class A {
    void test1() throws InterruptedException {}
}

public class Example11 {
    public static void main(String[] args) throws Exception {
        A a1 = new A();
        a1.test1();
    }
}
```

---

## 📌 Example 12: Custom Exception

```java
class AgeInvalidException extends Exception {
    public AgeInvalidException() {}
    public AgeInvalidException(String message) {
        super(message);
    }
}

public class Example12 {
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

**Output:**
```
Exception in thread "main" AgeInvalidException: Age is less than 18, not eligible for voting
```

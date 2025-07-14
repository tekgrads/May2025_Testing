# Class 25 (11/7/25)

## ASCII Values
- ASCII value of char `'a'` is 97, `'b'` is 98, ..., `'z'` is 122.
- You can't change the values of variables inside Lambda Expressions (LE).

---

## Difference Between Anonymous Inner Class (AIC) and Lambda Expressions (LE)

| AIC                                             | LE                                                   |
|--------------------------------------------------|--------------------------------------------------------|
| Class without name                              | Method without name                                  |
| Can extend abstract and concrete classes        | Can only implement interface with SAM (FI)           |
| Can implement interface with non-abstract methods| Cannot implement interface with multiple methods     |
| Can be instantiated                             | Cannot be instantiated                               |
| Can declare instance variables                  | Cannot declare instance variables                    |
| `this` refers to current AIC object             | `this` refers to outside (enclosing) class object    |
| Best choice to handle null methods              | Best choice to handle SAM                            |

---

## Default and Static Methods

### Example 1: Overriding Default Method

```java
package com.tekgrads;

interface I {
    default void m1() {
        System.out.println("Default Method");
    }
}

class TestI implements I {
    public void m1() {
        System.out.println("Overridden Method");
    }
}

public class Example5 {
    public static void main(String[] args) {
        TestI i = new TestI();
        i.m1();
    }
}
```

---

### Example 2: Default Method Conflict Resolution

```java
package com.tekgrads;

abstract class ABS {
    int a = 10;
    public void m1() {}
}

interface Left {
    int a = 10;
    default void m1() {
        System.out.println("left DM");
    }
}

interface Right {
    default void m1() {
        System.out.println("Right RM");
    }
}

class TestLR implements Left, Right {
    public void m1() {
        Right.super.m1();
    }
}

public class Example6 {
    public static void main(String[] args) {
        TestLR tlr = new TestLR();
        tlr.m1();
    }
}
```

---

## Differences Between Interfaces and Abstract Classes

- In interfaces, any field (e.g., `int a = 10`) is `public static final` by default.
- In abstract classes, fields are instance variables.
- Interfaces **don't talk about state**; abstract classes **do**.
- Interfaces cannot contain non-static instance members.
- Interfaces cannot override `Object` class methods; abstract classes can.
- Abstract classes can have **IIB (Instance Initialization Block)** and **SIB (Static Initialization Block)**.
- Abstract methods **do not** support Lambda Expressions.

---

## Static Methods in Interfaces

- No need to create an object to access.
- Interfaces support static methods.
- They **don't** support static instance members.

### Example:

```java
package com.tekgrads;

interface J {
    static void m1() {
        System.out.println("interface static method");
    }
}

class TestS implements J {
    public static void m1() {
        // Static method in implementing class
    }
}

public class Example7 {
    public static void main(String[] args) {
        J.m1();
        TestS ts = new TestS();
        // ts.m1(); // Not allowed
    }
}
```

> Note: Interfaces can have `main()` method directly.

---

## Predefined Functional Interfaces (PFI)

- Examples: `Runnable`, `Comparable`

### Lambda Comparator with Employee Example

```java
package com.tekgrads;
import java.util.Arrays;
import java.util.Comparator;

public class Example9 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Ramesh", 28, 10000d, "HCL"),
            new Employee("Rakesh", 30, 20000d, "Accenture"),
            new Employee("Suresh", 31, 30000d, "Infosys"),
        };

        Arrays.sort(employees, (o1, o2) -> {
            if (o1.salary > o2.salary) return -1;
            else if (o1.salary < o2.salary) return 1;
            else return 0;
        });

        System.out.println(Arrays.toString(employees));
    }
}

class MyEmployeeComparator implements Comparator<Employee> {
    public int compare(Employee o1, Employee o2) {
        if (o1.salary > o2.salary) return -1;
        else if (o1.salary < o2.salary) return 1;
        else return 0;
    }
}
```

---

## Common Predefined Functional Interfaces

1. **Predicate**
2. **Function**
3. **Consumer**
4. **Supplier**

---

## Predicate

- SAM: `test(T t)`
- Return type: `boolean`
- Used to evaluate boolean conditions.

### Example:

```java
package com.tekgrads;
import java.util.function.Predicate;

public class Example10 {
    public static void main(String[] args) {
        Predicate<String> p1 = str -> str.length() > 10;
        System.out.println(p1.test("test"));
        System.out.println(p1.test("test12345679010"));

        Predicate<String> p2 = Predicate.isEqual("Testing");
        System.out.println(p2.test("test"));
        System.out.println(p2.test("Testing"));

        Predicate<Integer> p3 = i -> i > 10;
        Predicate<Integer> p4 = i -> i % 2 == 0;
        System.out.println(p3.and(p4).test(20)); // true
        System.out.println(p3.and(p4).test(4));  // false
        System.out.println(p3.negate().test(11)); // false
    }
}
```

---

## Function

- SAM: `apply(T t)`
- Takes input, performs an operation, and returns result.

### Example:

```java
package com.tekgrads;
import java.util.function.Function;

public class Example11 {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("test")); // 4

        Function<Integer, Integer> f1 = i -> i * i;
        System.out.println(f1.apply(10)); // 100

        Function<String, Integer> f2 = s -> s.length() - s.replaceAll(" ", "").length();
        System.out.println(f2.apply("hi this is a function")); // count of spaces

        Function<String, String> f4 = s -> s.toUpperCase();
        Function<String, String> f5 = s -> s.substring(0, 9);
        System.out.println(f4.andThen(f5).apply("hi this is a function"));
    }
}
```

---

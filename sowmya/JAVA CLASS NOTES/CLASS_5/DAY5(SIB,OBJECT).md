# Static Initialization Blocks (SIB)

---

## 1. What is a Static Initialization Block (SIB)?

A **SIB** in Java is a block of code declared using the `static` keyword. It executes **only once** when the class is first loaded into memory by the JVM, before any object creation or static method call.

* Declared using `static {}`
* Executes in the order of appearance
* Has access to static members (even private ones)
* Cannot access non-static members
* If a program has only static blocks but no `main()` method, it throws an error

```java
public class A {
    static {
        System.out.println("SIB block");
    }
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
```

* SIB is not stored in heap memory

## 2. Multiple Static Blocks Execution Order

```java
public class A {
    static {
        System.out.println("SIB1");
    }
    public static void main(String[] args) {
        System.out.println("hello");
    }
    static {
        System.out.println("SIB2");
    }
}
```

## 3. Accessing Static Variables

Static variables are accessed using the class name:

```java
public class A {
    static int i;
    static int j = 10;

    static {
        A.i = 100;
        A.j = 200;
        System.out.println("i value is: " + i + ", j value is: " + j);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
```

## 4. Declaring Static as Global Variable

```java
public class A {
    static int i = 90;

    static {
        i = 100;
        System.out.println("SIB1");
    }

    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("value of i is: " + i);
    }

    static {
        System.out.println("SIB2");
    }
}
```

## 5. Two Classes with Main Methods

```java
class A {
    public static void main(String[] args) {
        System.out.println("hello");
    }
}

class B {
    public static void main(String[] args) {
        System.out.println("hii");
    }
}
```

> Output: hello (if class A is executed)

## 6. Accessing Variables Across Classes

```java
class F {
    static int i = 1000;
}

class G {
    static int i = 10;
    public static void main(String[] args) {
        System.out.println("hii");
        System.out.println("value of i from class F is: " + F.i);
        System.out.println("value of i from G class is: " + i);
    }
}
```

## 7. Multiple Classes with Multiple SIBs

```java
class A {
    static int i = 90;
    static {
        System.out.println("SIB1 in A class");
    }
    static {
        System.out.println("SIB2 in A class");
    }
}

class B {
    static int i = 10;
    static {
        System.out.println("SIB1 in B class");
    }
    public static void main(String[] args) {
        System.out.println("B class");
        System.out.println("value of i from class A is: " + A.i);
        System.out.println("value of i from B class is: " + i);
    }
    static {
        System.out.println("SIB2 in B class");
    }
}
```

> **Output:**

```
SIB1 in B class
SIB2 in B class
B class
SIB1 in A class
SIB2 in A class
value of i from class A is: 90
value of i from B class is: 10
```

---

# Object Creation

## Using `new` Keyword

```java
public class L {
    int i;

    public static void main(String[] args) {
        L l1 = new L();
        System.out.println("hello L");
        System.out.println("Value of i from l1: " + l1.i);
        l1.i = 10;
        System.out.println("Value of i from l1 after assignment: " + l1.i);

        L l2 = new L();
        l2.i = 20;
        System.out.println("Value of i from l2 after assignment: " + l2.i);

        L l3 = new L();
        l3.i = 30;
        System.out.println("Value of i from l3 after assignment: " + l3.i);
    }
}
```

## Orphan Objects

* Objects no longer referenced are called **orphan objects**.
* `l1`, `l2`, and `l3` become orphan after execution.
* JVM’s Garbage Collector removes these.

---

# Out of Memory Error

Occurs due to:

* Excessive memory usage
* Infinite object creation

**Solution:** Fix logic to avoid uncontrolled memory usage.
Increasing heap/stack size is only a temporary fix.

# 📘 Java Class 20 Notes (04/07/2025)

---

## 🔍 Reflection API
- Part of `java.lang.reflect` package.
- Used to inspect and manipulate **classes, methods, fields, and constructors at runtime** even if they are private.

### Full Name
- Class name along with package.

---

## 🧠 Object Class
- Holds all the metadata of a class.
- In each class in heap memory, an object of class `Object` is loaded, which holds all the metadata.

---

## 🌴 Island Objects
- A group of objects that reference each other but are **no longer reachable** from the application.
- Prevents memory leaks from cyclic references.
- Helps understand how Java Garbage Collector is smarter than simple reference counting.

### Example Code:
```java
class P {
    P p1;
    public static void main(String[] args) {
        P p1 = new P();
        P p2 = new P();
        P p3 = new P();

        p1.p1 = p2;
        p2.p1 = p3;
        p3.p1 = p1;

        p1 = p2 = p3 = null; // All references disconnected
        // Now p1, p2, p3 are orphaned (eligible for GC)
    }
}
```

---

## 📚 Strings
- A **collection or group of characters**.

### Example Code:
```java
public class Ex1 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);        // true
        System.out.println(s1.equals(s2));   // true
        System.out.println(s1.hashCode());   // 96354
        System.out.println(s2.hashCode());   // 96354
    }
}
```

---

### Constant Pool
- **No duplicates allowed**.
- Reuses the same string object if already present.

### Non-Constant Pool
- Always creates **new objects**.

---

### 🔗 String Concatenation
```java
String s1 = "ja";
String s2 = "va";
String s3 = "java";
String s4 = s1 + s2;
System.out.println(s3 == s4); // false (s3 in constant pool, s4 in heap)
```

---

### 📌 String Methods
```java
String s1 = "abcc";
System.out.println(s1.length());           // 4
System.out.println(s1.charAt(1));          // b
System.out.println(s1.indexOf('b'));       // 1
System.out.println(s1.lastIndexOf('c'));   // 3
System.out.println(s1.substring(1));       // bcc
System.out.println(s1.substring(1, 3));    // bc
System.out.println(s1.toUpperCase());      // ABCC
System.out.println(new StringBuilder(s1).reverse()); // ccba
```

---

### ✂️ Split Method
```java
String names = "apple,cat,dog";
String[] nameArray = names.split(",");
for (String name : nameArray) {
    System.out.println(name);
}
```

---

## 🔄 StringBuffer
- **Mutable**
- **Thread-safe** (methods are synchronized)

```java
StringBuffer s1 = new StringBuffer("abc");
System.out.println(s1);       // abc
s1.append("123");
System.out.println(s1);       // abc123
```

```java
StringBuffer s1 = new StringBuffer("abc");
StringBuffer s2 = new StringBuffer("abc");
System.out.println(s1 == s2);          // false
System.out.println(s1.equals(s2));     // false (hashCode not overridden)
```

---

## 🔄 StringBuilder
- **Mutable**
- **Not synchronized** (not thread-safe)
- Faster in single-threaded environments.

---

## 📦 Arrays
- Container object that holds **fixed number of values** of the **same data type**.

### Key Features:
- Stores elements of same type.
- Fixed size.
- Indexed.
- Can be single or multi-dimensional.

---

### 🧪 Array Example
```java
import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) {
        int x[] = new int[10];
        for (int i = 0; i < x.length; i++) {
            x[i] = i;
        }

        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]); // 0 to 9
        }

        for (int value : x) {
            System.out.println(value); // 0 to 9
        }

        System.out.println(x); // prints hashcode
        System.out.println(Arrays.toString(x)); // [0, 1, ..., 9]
    }
}
```

---

### 🔢 Array Sorting
```java
import java.util.Arrays;

public class SortExample {
    public static void main(String[] args) {
        int[] x = {100, 1, 1000, 10, 10000};
        Arrays.sort(x);
        System.out.println(Arrays.toString(x)); // ascending order
    }
}
```

---

## 🧑‍💼 Storing Employee Data
```java
class Employee {
    String name;
    Integer age;
    Double salary;
    String companyName;

    public Employee(String name, Integer age, Double salary, String companyName) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + salary + " " + companyName;
    }
}

public class Ex4 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Suresh", 28, 90000d, "Google")
        };

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
```

---

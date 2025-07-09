# 📘 Java Class 20 Notes

---

## 🔍 1. Reflection API

* **Reflection** allows you to **inspect and modify classes, methods, fields** at runtime.
* Part of `java.lang.reflect` package.

### ✅ Example:

```java
import java.lang.reflect.*;

class Robot {
    public void greet() {
        System.out.println("Hello, human!");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Robot");
        Method method = clazz.getMethod("greet");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        method.invoke(obj); // Hello, human!
    }
}
```

---

## 🌴 2. Island Objects

* **Island objects** are a group of objects that reference each other but are **unreachable from the application**.
* Eligible for **Garbage Collection**.

### ✅ Example:

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

        p1 = p2 = p3 = null;
    }
}
```

---

## 💬 3. Strings & String Pool

* **String**: Sequence of characters (immutable).
* **String Pool**: Special memory region for string literals (avoids duplication).

### ✅ Example:

```java
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");

System.out.println(s1 == s2); // true (pool)
System.out.println(s1 == s3); // false (heap)
```

### 🔗 Concatenation

```java
String a = "ja";
String b = "va";
String c = "java";
String d = a + b;

System.out.println(c == d); // false
```

### 📌 Common Methods:

```java
String s = "abcc";
s.length();                // 4
s.charAt(1);               // b
s.indexOf('b');            // 1
s.lastIndexOf('c');        // 3
s.substring(1);            // bcc
s.toUpperCase();           // ABCC
new StringBuilder(s).reverse(); // ccba
```

### ✂️ Split Example:

```java
String names = "apple,cat,dog";
String[] arr = names.split(",");
for (String n : arr) {
    System.out.println(n);
}
```

---

## 🔄 4. StringBuffer

* **Mutable** and **Thread-safe**
* Uses **synchronized** methods

### ✅ Example:

```java
StringBuffer s1 = new StringBuffer("abc");
s1.append("123");
System.out.println(s1); // abc123

StringBuffer s2 = new StringBuffer("abc");
System.out.println(s1 == s2); // false
System.out.println(s1.equals(s2)); // false
```

---

## 🚀 5. StringBuilder

* **Mutable**, but **not thread-safe**
* Faster in single-threaded environments

```java
StringBuilder sb = new StringBuilder("xyz");
sb.append("123");
System.out.println(sb); // xyz123
```

---

## 📦 6. Arrays

* Container that holds **fixed-size** collection of **same-type** elements

### ✅ Basic Example:

```java
int[] arr = new int[5];
arr[0] = 10;
System.out.println(arr[0]); // 10
```

### ✅ Enhanced For Loop:

```java
for (int val : arr) {
    System.out.println(val);
}
```

### ✅ Print Full Array:

```java
import java.util.Arrays;
System.out.println(Arrays.toString(arr));
```

---

## 📏 7. Array Sorting

```java
int[] nums = {42, 5, 7, 100, 1};
Arrays.sort(nums);
System.out.println(Arrays.toString(nums)); // [1, 5, 7, 42, 100]
```

---

## 👨‍💼 8. Employee Example

### ✅ Store Employee Details:

```java
class Employee {
    String name;
    Integer age;
    Double salary;
    String company;

    public Employee(String name, Integer age, Double salary, String company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
    }

    public String toString() {
        return name + " " + age + " " + salary + " " + company;
    }
}

public class Ex4 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Suresh", 28, 90000d, "Google"),
            new Employee("Meena", 24, 85000d, "Amazon")
        };

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
```

💾 Output:

```
Suresh 28 90000.0 Google  
Meena 24 85000.0 Amazon
```

---

## 🧠 Recap Table

| Concept        | Key Point                                      |
| -------------- | ---------------------------------------------- |
| Reflection API | Inspect and modify class metadata at runtime   |
| Island Objects | Objects referencing each other but unreachable |
| String Pool    | Stores string literals, avoids duplication     |
| StringBuffer   | Mutable & thread-safe                          |
| StringBuilder  | Mutable & fast (non-thread-safe)               |
| Arrays         | Fixed-size collection of same type             |
| Employee Array | Example of array of objects                    |

---


# 📘 Java Concepts: Arrays and Custom Sorting

---

## 📦 1. Arrays in Java

An **array** in Java is a container object that holds a fixed number of elements of the same data type.

### 🔧 Declaration and Initialization
```java
int[] numbers = new int[5];             // Declaration with size
int[] values = {10, 20, 30, 40, 50};    // Initialization with values
```

### 📌 Key Points:
- Index starts from `0`.
- Fixed size once declared.
- Can be single or multi-dimensional.

### 🔁 Example: Iterating through an Array
```java
for (int i = 0; i < values.length; i++) {
    System.out.println(values[i]);
}
```

### 📊 Multidimensional Array
```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
System.out.println(matrix[1][2]); // Output: 6
```

---

## 🔽 2. Custom Sorting in Java

**Custom sorting** allows you to sort objects based on your own logic instead of natural ordering.

### 🔧 Using `Comparator` Interface

The `Comparator` interface allows custom sorting logic externally.

### 📘 Example:
```java
import java.util.*;

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class AgeComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.age - s2.age;  // Ascending order by age
    }
}

public class CustomSortExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 18));

        Collections.sort(students, new AgeComparator());

        for (Student s : students) {
            System.out.println(s.name + " - " + s.age);
        }
    }
}
```

### 🧠 Using Lambda for Simpler Syntax
```java
Collections.sort(students, (s1, s2) -> s1.name.compareTo(s2.name));
```

---

## 🧠 Summary Table

| Concept         | Description                                      | Example/Usage                            |
|------------------|--------------------------------------------------|------------------------------------------|
| Arrays           | Fixed-size container for same data type         | `int[] arr = new int[5];`                |
| Multidimensional | Array of arrays                                 | `int[][] matrix = new int[3][3];`        |
| Custom Sorting   | Sort objects with custom logic                  | `Comparator`, `Collections.sort()`       |
| Lambda Sort      | Shorthand way of writing custom comparators     | `(a, b) -> a.age - b.age`                |


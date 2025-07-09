
# Java Arrays: Creation, Printing, Sorting, Custom Comparator, Comparable vs Comparator

---

##  1. Creating and Printing Arrays

###  Declare and Print Array (3 ways)
```java
public class ArrayPrint {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};

        // Using loop
        for (int i : arr) System.out.print(i + " ");
        System.out.println();

        // Using Arrays.toString()
        System.out.println(java.util.Arrays.toString(arr));

        // Using for loop
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
    }
}
````

#### Output:

```
10 20 30 
[10, 20, 30]
10 20 30 
```

---

##  2. Using `Arrays.sort()`

```java
import java.util.Arrays;

public class SortExample {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
```

#### Output:

```
[1, 2, 3, 4]
```

---

##  3. Custom Comparator (Descending Order)

```java
import java.util.Arrays;
import java.util.Collections;

public class DescSort {
    public static void main(String[] args) {
        Integer[] arr = {10, 40, 20};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
```

#### Output:

```
[40, 20, 10]
```

---

## 4. Custom Sorting using Comparator

```java
import java.util.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " - " + marks;
    }
}

class SortByMarks implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return b.marks - a.marks;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Asha", 85),
            new Student("Ravi", 95),
            new Student("Lila", 75)
        };

        Arrays.sort(students, new SortByMarks());
        for (Student s : students) System.out.println(s);
    }
}
```

#### Output:

```
Ravi - 95
Asha - 85
Lila - 75
```

---

##  5. Custom Sorting using Comparable

```java
import java.util.*;

class Employee implements Comparable<Employee> {
    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int compareTo(Employee e) {
        return this.salary - e.salary; // ascending
    }

    public String toString() {
        return name + " - " + salary;
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        Employee[] emp = {
            new Employee("Ajay", 50000),
            new Employee("Vikram", 40000),
            new Employee("Sita", 60000)
        };

        Arrays.sort(emp);
        for (Employee e : emp) System.out.println(e);
    }
}
```

#### Output:

```
Vikram - 40000
Ajay - 50000
Sita - 60000
```

---

##  6. Difference: Comparator vs Comparable

| Feature          | Comparable            | Comparator                      |
| ---------------- | --------------------- | ------------------------------- |
| Package          | java.lang             | java.util                       |
| Interface Method | `compareTo(Object o)` | `compare(Object o1, Object o2)` |
| Modifies         | Current class         | External class                  |
| Use              | Natural sorting       | Custom, multiple sort criteria  |


```

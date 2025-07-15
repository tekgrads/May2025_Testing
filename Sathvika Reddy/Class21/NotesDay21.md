
# Java Notes – Arrays and Sorting

---

### 1. Arrays Basics

**Definition:**
An array is a fixed-size container that stores elements of the same type in contiguous memory.
**Use:**
Used for storing and accessing multiple values efficiently using indexing.

```java
package com.tekgrads;

import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {
        // Creating an array
        int a[] = new int[10];

        // Use for loop to assign values
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        // 1st way: Print values using for loop
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        System.out.println("------------------------");

        // 2nd way: Enhanced for loop
        for (int i : a) {
            System.out.println(i);
        }

        System.out.println("------------------------");

        // 3rd way: Using built-in method toString()
        System.out.println(Arrays.toString(a));
    }
}
```

---

### 2. Arrays.sort()

**Definition:**
`Arrays.sort()` is a utility method that sorts arrays in ascending order using dual-pivot quicksort for primitives.
**Use:**
Efficiently sorts data for processing or searching.

```java
package com.tekgrads;

import java.util.Arrays;

public class Example3 {
    public static void main(String[] args) {
        int a[] = {1000, 2, 800, 70, 3000, 4, 50};

        System.out.println("Array before sorting: " + Arrays.toString(a));

        Arrays.sort(a);

        System.out.println("Array after sorting: " + Arrays.toString(a));
    }
}
```

---

### 3. Employee Array Example

**Use:**
Storing custom objects like Employee and printing them using `Arrays.toString()`.

```java
package com.tekgrads;

import java.util.Arrays;

class Employee {
    String name;
    Integer age;
    Double salary;
    String CompanyName;

    public Employee(String name, Integer age, Double salary, String companyName) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.CompanyName = companyName;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", CompanyName=" + CompanyName + "]";
    }
}

public class Example4 {
    public static void main(String[] args) {
        Employee[] emp = {
            new Employee("sathvika", 25, 50000d, "cognizant"),
            new Employee("kavith", 26, 40000d, "hcl"),
            new Employee("sai", 27, 80000d, "Ibm"),
            new Employee("Rohitha", 25, 40000d, "cognizant"),
            new Employee("sri", 24, 45000d, "accenture")
        };

        System.out.println(Arrays.toString(emp));
    }
}
```

---

### 4. Sort Array in Descending Using Comparator

**Use:**
Customize sorting using `Comparator` to achieve descending or complex orders.

```java
package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

public class Example5 {
    public static void main(String[] args) {
        Integer[] a = {1000, 2, 800, 70, 3000, 4, 50};
        System.out.println("Arrays before sorting: " + Arrays.toString(a));

        Arrays.sort(a);
        System.out.println("Arrays after default sorting: " + Arrays.toString(a));

        Arrays.sort(a, new MyComparator());
        System.out.println("Arrays after custom descending sort: " + Arrays.toString(a));
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1); // descending order
    }
}
```

---

### 5. Sort Employees by Salary Using Comparable

**Use:**
Use `Comparable` for natural sorting logic (e.g., ascending by salary).

```java
package com.tekgrads;

import java.util.Arrays;

class Employee implements Comparable<Employee> {
    String name;
    Integer age;
    Double salary;
    String companyName;

    public Employee(String name, Integer age, Double salary, String companyName) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", companyName=" + companyName + "]";
    }

    @Override
    public int compareTo(Employee o) {
        return this.salary.compareTo(o.salary);
    }
}

public class Example6 {
    public static void main(String[] args) {
        Employee[] emp = {
            new Employee("sathvika", 25, 50000d, "cognizant"),
            new Employee("kavith", 26, 42000d, "hcl"),
            new Employee("shreya", 27, 80000d, "ibm"),
            new Employee("ruchi", 25, 40000d, "cognizant"),
            new Employee("hari", 24, 45000d, "accenture")
        };

        System.out.println("Before sorting: " + Arrays.toString(emp));
        Arrays.sort(emp);
        System.out.println("After sorting by salary: " + Arrays.toString(emp));
    }
}
```

---

### 6. Sort Students by Marks Using Comparable

```java
package com.tekgrads;

import java.util.Arrays;

class Student implements Comparable<Student> {
    String name;
    Integer id;
    Double marks;
    String schoolName;
    Integer age;

    public Student(String name, Integer id, Double marks, String schoolName, Integer age) {
        this.name = name;
        this.id = id;
        this.marks = marks;
        this.schoolName = schoolName;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", " + id + ", " + marks + ", " + schoolName + ", " + age;
    }

    @Override
    public int compareTo(Student s) {
        return this.marks.compareTo(s.marks);
    }
}

public class Example7 {
    public static void main(String[] args) {
        Student[] s = {
            new Student("sathvika", 200, 80d, "gayatri", 20),
            new Student("sai", 201, 85d, "narayana", 21),
            new Student("shiva", 203, 70d, "chaitanya", 20),
            new Student("ashu", 204, 76d, "gayatri", 22),
            new Student("sri", 202, 70d, "narayana", 19)
        };

        System.out.println("Before sorting by marks: " + Arrays.toString(s));
        Arrays.sort(s);
        System.out.println("After sorting by marks: " + Arrays.toString(s));
    }
}
```

---

### 7. Sort Employees by Salary Using Comparator

```java
package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

public class Example9 {
    public static void main(String[] args) {
        Employee[] emp = {
            new Employee("sathvika", 25, 50000d, "cognizant"),
            new Employee("ashu", 26, 42000d, "hcl"),
            new Employee("ruchi", 27, 80000d, "Ibm"),
            new Employee("Rohitha", 25, 40000d, "cognizant"),
            new Employee("shiva", 24, 45000d, "accenture")
        };

        System.out.println("Original array: " + Arrays.toString(emp));

        Arrays.sort(emp);
        System.out.println("Sorted in ascending order: " + Arrays.toString(emp));

        Arrays.sort(emp, new MyEmployeeComparator());
        System.out.println("Sorted in descending order: " + Arrays.toString(emp));
    }
}

class MyEmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.salary.compareTo(o1.salary); // descending
    }
}
```

---

### 8. Sort Students by Marks Using Comparator

```java
package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

public class Example10 {
    public static void main(String[] args) {
        Student[] s = {
            new Student("sathvika", 200, 80d, "gayatri", 20),
            new Student("ram", 201, 85d, "narayana", 21),
            new Student("swethik", 203, 70d, "chaitinaya", 20),
            new Student("sai", 204, 76d, "gayatri", 22),
            new Student("shiva", 202, 70d, "narayana", 19)
        };

        System.out.println("Original student array: " + Arrays.toString(s));

        Arrays.sort(s);
        System.out.println("Sorted in ascending order: " + Arrays.toString(s));

        Arrays.sort(s, new MyStudentComparator());
        System.out.println("Sorted in descending order: " + Arrays.toString(s));
    }
}

class MyStudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.marks.compareTo(o1.marks); // descending
    }
}
```

---

### 9. Comparator vs Comparable

**Comparable**:

* Interface in `java.lang`
* Used for natural/default sorting
* Implement `compareTo()` inside the class
* Example: `Arrays.sort(emp)` if `Employee` implements `Comparable`

**Comparator**:

* Interface in `java.util`
* Used for customized sorting
* Implement `compare()` externally
* Example: `Arrays.sort(emp, new MyEmployeeComparator())`



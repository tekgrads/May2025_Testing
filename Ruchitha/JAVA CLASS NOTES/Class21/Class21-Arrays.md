
# Arrays in Java

## What is an Array?

An **array** is a collection of elements of the same data type stored in a fixed-size container.

---

## Example 1: Initialization of Array

```java
package com.tekgrads;

import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {
        int x[] = new int[10];

        for (int i = 0; i < x.length; i++) {
            x[i] = i;
        }

        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }

        System.out.println("----------------------");
        for (int i : x) {
            System.out.println(x[i]);
        }

        System.out.println(x);

        System.out.println(Arrays.toString(x));
    }
}
```

---

## Example 2: Array Initialization with Values

```java
package com.tekgrads;

public class Example2 {
    public static void main(String[] args) {
        int x[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i : x) {
            System.out.println(i);
        }
    }
}
```

---

## Sorting an Array

Use `Arrays.sort()` to sort the array.

### Example 3:

```java
package com.tekgrads;

import java.util.Arrays;

public class Example3 {
    public static void main(String[] args) {
        int x[] = {100, 1, 200, 1000, 20, 1500, 2};
        System.out.println(Arrays.toString(x));
        Arrays.sort(x);
        System.out.println(Arrays.toString(x));
    }
}
```

---

## Example 4: Array with Employee Details

```java
package com.tekgrads;

import java.util.Arrays;

class Employee {
    String name;
    Integer age;
    Double salary;
    String CompanyName;

    public Employee(String name, Integer age, Double salary, String companyName) {
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
            new Employee("Ramesh", 25, 50000d, "Cognizant"),
            new Employee("Suresh", 26, 40000d, "HCL"),
            new Employee("Rajesh", 27, 80000d, "IBM"),
            new Employee("Sandeep", 25, 40000d, "Cognizant"),
            new Employee("Rakesh", 24, 45000d, "Accenture")
        };

        System.out.println(Arrays.toString(emp));
    }
}
```

---

## Customized Sorting

### Comparator:

- `compare()` method compares two objects.
- Logic:
  - `o1 > o2` → return `-1`
  - `o1 < o2` → return `1`
  - `o1 == o2` → return `0`

---

### Example 5: Reverse Sorting using Comparator

```java
package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

public class Example5 {
    public static void main(String[] args) {
        Integer x[] = {100, 1, 200, 1000, 20, 1500, 2};
        System.out.println(Arrays.toString(x));
        Arrays.sort(x);
        System.out.println(Arrays.toString(x));
        Arrays.sort(x, new MyComparator());
        System.out.println(Arrays.toString(x));
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) return -1;
        else if (o1 < o2) return 1;
        else return 0;
    }
}
```

**Output:**

```
[100, 1, 200, 1000, 20, 1500, 2]
[1, 2, 20, 100, 200, 1000, 1500]
[1500, 1000, 200, 100, 20, 2, 1]
```

---

## Example 6: Sorting Employee using Comparable

```java
package com.tekgrads;

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
```

---

## Example 7: Sorting Employees using Comparator

```java
package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

public class Example7 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Ramesh", 28, 20000d, "HCL"),
            new Employee("Rakesh", 30, 4000d, "Accenture"),
            new Employee("Suresh", 31, 1000d, "Infosys"),
            new Employee("Harish", 31, 100000d, "Cognizant"),
            new Employee("Chandan", 31, 10000d, "Persistent"),
            new Employee("Ravi", 31, 50000d, "Flipkart")
        };

        System.out.println(Arrays.toString(employees));
        Arrays.sort(employees); // Comparable
        System.out.println(Arrays.toString(employees));
        Arrays.sort(employees, new MyEmployeeComparator()); // Comparator
        System.out.println(Arrays.toString(employees));
    }
}

class MyEmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.salary > o2.salary) return -1;
        else if (o1.salary < o2.salary) return 1;
        else return 0;
    }
}
```

---

## Difference Between `Comparator` and `Comparable`

| Feature       | Comparable | Comparator |
|---------------|------------|------------|
| Method        | `compareTo`| `compare`  |
| Interface     | `java.lang.Comparable` | `java.util.Comparator` |
| Used For      | Natural order | Custom order |
| Sorting logic | Inside the class | Outside the class |

---

## Limitations of Arrays

- Arrays are fixed in size.
- Memory is not efficiently used.
- Arrays are homogeneous (same data type).
- Can hold both primitives and object types.
- No underlying data structures like in collections.

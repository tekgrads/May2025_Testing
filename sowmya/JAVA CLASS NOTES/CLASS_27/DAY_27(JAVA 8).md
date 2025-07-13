
## Example 1: Printing Employees with Salary > 30000

**Employee.java**

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

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
}
```

**Example27.java**

```java
package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example27 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("kavya", 28, 10000d, "HCL"));
        employeeList.add(new Employee("Ramya", 29, 20000d, "Accenture"));
        employeeList.add(new Employee("sravanthi", 30, 30000d, "Infosys"));
        employeeList.add(new Employee("navya", 31, 40000d, "HCL"));
        employeeList.add(new Employee("sneha", 32, 50000d, "Accenture"));
        employeeList.add(new Employee("sowmya", 33, 60000d, "Infosys"));

        List<String> names = employeeList.stream()
            .filter(e -> e.salary > 30000)
            .map(e -> e.name)
            .collect(Collectors.toList());

        System.out.println(names);
    }
}
```

**Output:**

```
[navya, sneha, sowmya]
```

---

## flatMap()

The `flatMap()` method is used to flatten a stream of nested collections (e.g., List of Lists) into a single stream.

## Example 2: Using flatMap()



```java
package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example28 {
    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(4);
        secondList.add(5);
        secondList.add(6);

        List<Integer> thirdList = new ArrayList<>();
        thirdList.add(7);
        thirdList.add(8);
        thirdList.add(9);

        l.add(firstList);
        l.add(secondList);
        l.add(thirdList);

        System.out.println(l);

        List<Integer> result = l.stream()
            .flatMap(p -> p.stream())
            .collect(Collectors.toList());

        System.out.println(result);
    }
}
```

**Output:**

```
[[1, 2, 3], [4, 5, 6], [7, 8, 9]]
[1, 2, 3, 4, 5, 6, 7, 8, 9]
```

---



##groupingBy()

* **groupingBy()**: Used to group objects based on a property.

  * Returns a Map\<K, List<V>> where `K` is the key and `V` is the list of grouped items.

---

## Example 3: Grouping and Sorting Employees by Company and Salary

```java
package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example29 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("kavya", 28, 10000d, "HCL"));
        employees.add(new Employee("Ramya", 29, 20000d, "Accenture"));
        employees.add(new Employee("sravanthi", 30, 30000d, "Infosys"));
        employees.add(new Employee("navya", 31, 40000d, "HCL"));
        employees.add(new Employee("sneha", 32, 50000d, "Accenture"));
        employees.add(new Employee("sowmya", 33, 60000d, "Infosys"));

        // Grouping by company name
        Map<String, List<Employee>> group = employees.stream()
            .collect(Collectors.groupingBy(Employee::getCompanyName));
        System.out.println(group);

        // Sorting by salary in descending order
        List<Employee> employeeSortedList = employees.stream()
            .sorted((o1, o2) -> o2.salary.compareTo(o1.salary))
            .collect(Collectors.toList());

        System.out.println(employeeSortedList);
    }
}
```

### Sample Output

```text
{HCL=[Employee [name=kavya, age=28, salary=10000.0, companyName=HCL], Employee [name=navya, age=31, salary=40000.0, companyName=HCL]],
 Infosys=[Employee [name=sravanthi, age=30, salary=30000.0, companyName=Infosys], Employee [name=sowmya, age=33, salary=60000.0, companyName=Infosys]],
 Accenture=[Employee [name=Ramya, age=29, salary=20000.0, companyName=Accenture], Employee [name=sneha, age=32, salary=50000.0, companyName=Accenture]]}

[Employee [name=sowmya, age=33, salary=60000.0, companyName=Infosys],
 Employee [name=sneha, age=32, salary=50000.0, companyName=Accenture],
 Employee [name=navya, age=31, salary=40000.0, companyName=HCL],
 Employee [name=sravanthi, age=30, salary=30000.0, companyName=Infosys],
 Employee [name=Ramya, age=29, salary=20000.0, companyName=Accenture],
 Employee [name=kavya, age=28, salary=10000.0, companyName=HCL]]
```

---



### What is Optional?

`Optional` is a container object which may or may not contain a non-null value. It is used to avoid `NullPointerException`.

### isPresent()

Returns `true` if the value is present, otherwise `false`.

### Example 4:program  Using Optional

```java
package com.tekgrads;

import java.util.Optional;

public class Example30 {
    public static void main(String[] args) {
        Optional<String> str = Optional.of("one");

        if (str.isPresent()) {
            System.out.println(str.get());
        }

        String str2 = null;
        Optional<String> answer = Optional.ofNullable(str2);

        answer.ifPresentOrElse(
            s -> System.out.println(s),
            () -> System.out.println("the string is not there")
        );
    }
}
```

### Output

```
one
the string is not there
```

---



## Example 5: Using `LocalDate`, `LocalTime`, `LocalDateTime`

```java
package com.tekgrads;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Example31 {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println("LocalDate: " + ld);

        LocalTime lt = LocalTime.now();
        System.out.println("LocalTime: " + lt);

        int h = lt.getHour();
        int m = lt.getMinute();
        int s = lt.getSecond();

        System.out.println("Hour: " + h);
        System.out.println("Minute: " + m);
        System.out.println("Second: " + s);

        int dd = ld.getDayOfMonth();
        int mm = ld.getMonthValue();
        int yyy = ld.getYear();

        System.out.println("Day: " + dd);
        System.out.println("Month: " + mm);
        System.out.println("Year: " + yyy);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println("Current Year: " + dt.getYear());
        System.out.println("Current Hour: " + dt.getHour());
    }
}
```

### Sample Output

```
LocalDate: 2025-07-13
LocalTime: 15:18:50.725884600
Hour: 15
Minute: 18
Second: 50
Day: 13
Month: 7
Year: 2025
Current Year: 2025
Current Hour: 15
```

---

## Example 6: Working with `Period`, `Year`, and `ZonedDateTime`

```java
package com.tekgrads;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Example32 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.of(1995, 5, 28, 12, 45);
        System.out.println("LocalDateTime: " + ldt);

        System.out.println("Adding 3 days: " + ldt.plusDays(3));
        System.out.println("Adding 3 months: " + ldt.plusMonths(3));

        LocalDate birthDate = LocalDate.of(1988, 11, 28);
        LocalDate presentDate = LocalDate.now();

        Period p = Period.between(birthDate, presentDate);
        System.out.println("Years: " + p.getYears());
        System.out.println("Months: " + p.getMonths());
        System.out.println("Days: " + p.getDays());

        Year y = Year.of(2000);
        System.out.println("Is Leap Year (2000): " + y.isLeap());

        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println("Default Zone: " + defaultZone);

        ZoneId america = ZoneId.of("America/New_York");
        ZonedDateTime zdt = ZonedDateTime.now(america);
        System.out.println("New York Time: " + zdt);
    }
}
```

### Sample Output

```
LocalDateTime: 1995-05-28T12:45
Adding 3 days: 1995-05-31T12:45
Adding 3 months: 1995-08-28T12:45
Years: 36
Months: 7
Days: 15
Is Leap Year (2000): true
Default Zone: Asia/Calcutta
New York Time: 2025-07-13T05:55:01.971560600-04:00[America/New_York]
```

---

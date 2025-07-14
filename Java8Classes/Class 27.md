# Class 27: (13/07/2025)

---

## 🔎 Filtering

> **Definition:** Filter or get data based on condition (e.g., get employees with salary > 30k)

### Example:

```java
import java.util.*;
import java.util.stream.Collectors;

public class Example19 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ramesh", 28, 10000d, "HCL"));
        employeeList.add(new Employee("Rakesh", 30, 20000d, "Accenture"));
        employeeList.add(new Employee("Suresh", 31, 30000d, "Infosys"));
        employeeList.add(new Employee("Harish", 32, 40000d, "CTS"));
        employeeList.add(new Employee("Ankit", 34, 50000d, "Persistent"));
        employeeList.add(new Employee("Likit", 37, 60000d, "JPMC"));

        List<String> names = employeeList.stream()
            .filter(e -> e.salary > 30000)
            .map(e -> e.name)
            .collect(Collectors.toList());

        System.out.println(names);
    }
}
```

---

## 🔄 FlatMap

> Used to **flatten** nested lists (e.g., `List<List<Integer>>` → `List<Integer>`)

### Example:

```java
import java.util.*;
import java.util.stream.Collectors;

public class Example20 {
    public static void main(String[] args) {
        List<List<Integer>> listOfIntegerList = new ArrayList<>();

        listOfIntegerList.add(Arrays.asList(1, 2, 3));
        listOfIntegerList.add(Arrays.asList(4, 5, 6));
        listOfIntegerList.add(Arrays.asList(7, 8, 9));

        System.out.println(listOfIntegerList);

        List<Integer> result = listOfIntegerList.stream()
            .flatMap(p -> p.stream())
            .collect(Collectors.toList());

        System.out.println(result);
    }
}
```

---

## 🧾 Grouping

> Group employees based on **company name** using `groupingBy()` (requires getter method)

### Example:

```java
import java.util.*;
import java.util.stream.Collectors;

public class Example21 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ramesh", 28, 10000d, "HCL"));
        employeeList.add(new Employee("Rakesh", 30, 20000d, "HCL"));
        employeeList.add(new Employee("Suresh", 31, 30000d, "Infosys"));
        employeeList.add(new Employee("Harish", 32, 40000d, "Infosys"));
        employeeList.add(new Employee("Ankit", 34, 50000d, "Persistent"));
        employeeList.add(new Employee("Likit", 37, 60000d, "Persistent"));

        Map<String, List<Employee>> group = employeeList.stream()
            .collect(Collectors.groupingBy(Employee::getCompanyName));

        System.out.println(group);

        List<Employee> employeeSortedList = employeeList.stream()
            .sorted((o1, o2) -> Double.compare(o2.salary, o1.salary))
            .collect(Collectors.toList());

        System.out.println(employeeSortedList);
    }
}
```

---

## ❔ Optional

> Helps avoid `NullPointerException` by wrapping values that **may be null**.

### Example:

```java
import java.util.Optional;

public class Example22 {
    public static void main(String[] args) {
        Optional<String> gender = Optional.of("MALE");

        if (gender.isPresent()) {
            System.out.println(gender.get());
        }

        String str2 = null;
        Optional<String> answer = Optional.ofNullable(str2);

        answer.ifPresentOrElse(
            s -> System.out.println(s),
            () -> System.out.println("Not Present")
        );
    }
}
```

---

## 📅 Joda-Time / java.time API

### ✅ Local Date and Time

```java
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Example23 {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        System.out.println(d);

        LocalTime lt = LocalTime.now();
        System.out.println(lt);

        int h = lt.getHour();
        int m = lt.getMinute();
        int s = lt.getSecond();
        System.out.println(h);
        System.out.println(m);
        System.out.println(s);

        int dd = d.getDayOfMonth();
        int mm = d.getMonthValue();
        int yyyy = d.getYear();
        System.out.println(dd);
        System.out.println(mm);
        System.out.println(yyyy);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getHour());
    }
}
```

---

### 📆 Periods, Zones, Leap Year

```java
import java.time.*;

public class Example24 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.of(1995, 5, 28, 12, 45);
        System.out.println(ldt);

        System.out.println(ldt.plusDays(3));
        System.out.println(ldt.plusMonths(3));

        LocalDate birthDate = LocalDate.of(1995, 5, 28);
        LocalDate deathDate = LocalDate.now();

        Period r = Period.between(birthDate, deathDate);
        System.out.println(r.getYears());
        System.out.println(r.getMonths());
        System.out.println(r.getDays());

        Year y = Year.of(2024);
        System.out.println(y.isLeap());

        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);

        ZoneId america = ZoneId.of("America/New_York");
        ZonedDateTime zdt = ZonedDateTime.now(america);
        System.out.println(zdt);
    }
}
```

---


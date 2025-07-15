

# Java 8 – Advanced Concepts (Lambda, Predicates, Functions, Interfaces)

---

##  Difference: Anonymous Inner Class vs Lambda Expressions

| Feature         | Anonymous Inner Class (AIC) | Lambda Expression (LE)                 |
| --------------- | --------------------------- | -------------------------------------- |
| Syntax          | Verbose                     | Concise (arrow `->`)                   |
| Object Creation | Creates an anonymous object | No object creation                     |
| `this` Keyword  | Refers to AIC               | Refers to enclosing class              |
| Performance     | Slightly slower             | More efficient (bytecode optimization) |
| Suitable For    | Multiple methods, fields    | Single-method interfaces               |
| Requires        | Any interface/class         | Functional interfaces only             |

---

##  Interface with Default Method vs Abstract Class

| Feature               | Interface with Default Method      | Abstract Class                    |
| --------------------- | ---------------------------------- | --------------------------------- |
| Method Implementation | Default methods allowed            | Can have both concrete & abstract |
| Multiple Inheritance  | Yes (interfaces can be multiple)   | No (only one class inheritance)   |
| Constructor Support   | No                                 | Yes                               |
| Fields                | Only `public static final`         | Instance variables allowed        |
| Use Case              | When methods share only signatures | When logic sharing is also needed |

---

##  Default and Static Methods in Interface

```java
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

**Explanation:**

* Default methods provide backward compatibility.
* Can be overridden in implementing class.

---

##  Lambda Expressions with Custom Objects

### Employee.java

```java
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

    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", companyName=" + companyName + "]";
    }

    public int compareTo(Employee o) {
        return this.salary.compareTo(o.salary);
    }
}
```

### Example15.java

```java
import java.util.Arrays;
import java.util.Comparator;

public class Example15 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("sowmya", 28, 50000d, "HCL"),
            new Employee("navya", 26, 20000d, "Accenture"),
            new Employee("Sneha", 30, 40000d, "Infosys")
        };

        Arrays.sort(employees, (o1, o2) -> o1.salary > o2.salary ? -1 : (o1.salary < o2.salary ? 1 : 0));

        System.out.println(Arrays.toString(employees));
    }
}
```

---

##  Predicates

```java
import java.util.function.Predicate;

public class Example16 {
    public static void main(String[] args) {
        Predicate<String> p1 = str -> str.length() > 10;
        System.out.println(p1.test("test")); // false
        System.out.println(p1.test("predicatefunctionjava8")); // true

        Predicate<String> p2 = Predicate.isEqual("predicate");
        System.out.println(p2.test("pre"));      // false
        System.out.println(p2.test("predicate"));// true

        Predicate<Integer> p3 = i -> i > 10;
        Predicate<Integer> p4 = i -> i % 2 == 0;

        System.out.println(p3.and(p4).test(40)); // true
        System.out.println(p3.and(p4).test(10)); // false

        System.out.println(p3.negate().test(11)); // false

        Predicate<Integer> p5 = i -> i < 50;
        Predicate<Integer> p6 = i -> i % 2 == 0;

        System.out.println(p5.or(p6).test(101)); // false
        System.out.println(p5.or(p6).test(10));  // true
    }
}
```

**Explanation:**

* **Predicate<T>** is used for testing conditions.
* Supports chaining using `.and()`, `.or()`, `.negate()`.

---

##  Functions

```java
import java.util.function.Function;

public class Example17 {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("function")); // 8

        Function<Integer, Integer> f1 = i -> i * i;
        System.out.println(f1.apply(10)); // 100

        Function<String, Integer> f2 = s -> s.length() - s.replaceAll(" ", "").length();
        System.out.println(f2.apply("this is a fucntion1")); // 3

        Function<String, String> f4 = s -> s.toUpperCase();
        Function<String, String> f5 = s -> s.substring(1, 7);
        System.out.println(f4.andThen(f5).apply("this is a fucntion2")); // HIS IS

        Function<String, String> f6 = s -> s.toLowerCase();
        System.out.println(f6.apply("THIS IS A FUNCTION3")); // this is a function3
    }
}
```


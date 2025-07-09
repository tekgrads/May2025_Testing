# Arrays.sort with Comparator & Difference Between Array and Collection

---

## 🔄 Arrays.sort() with Comparator

`Arrays.sort()` can be used not just for primitive arrays, but also for **object arrays** by using a **Comparator**.

### ✅ Syntax:

```java
Arrays.sort(array, Comparator);
```

### 🔹 Example: Sorting Strings in Descending Order

```java
import java.util.*;

public class SortStrings {
    public static void main(String[] args) {
        String[] names = {"Suresh", "Anil", "Zara", "Bhanu"};

        Arrays.sort(names, (a, b) -> b.compareTo(a)); // Descending

        System.out.println(Arrays.toString(names));
    }
}
```

### 🔹 Example: Sorting Custom Objects

```java
import java.util.*;

class Employee {
    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " - " + age;
    }
}

public class SortEmployee {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Suresh", 28),
            new Employee("Meena", 24),
            new Employee("Raj", 30)
        };

        Arrays.sort(employees, (e1, e2) -> Integer.compare(e1.age, e2.age)); // Ascending by age

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
```

---

## 📄 Difference Between Array and Collection

| Feature         | Array                          | Collection Framework                 |
| --------------- | ------------------------------ | ------------------------------------ |
| Size            | Fixed                          | Growable                             |
| Type            | Can store primitives & objects | Stores only objects (not primitives) |
| Performance     | Fast (less overhead)           | Slightly slower due to abstraction   |
| Type Safety     | No generics (prior to Java 5)  | Type-safe with Generics              |
| Utility Methods | Limited (length, index access) | Many methods (add, remove, sort)     |
| Data Structure  | Homogeneous                    | Heterogeneous possible               |
| Traversal       | For loop                       | Iterator, for-each loop              |

---

## 🎭 Real-Life Analogy

* **Array**: Fixed egg tray – 6 eggs max.
* **Collection**: Flexible egg box – can hold 6, then 10, then 20 eggs. Can even remove or replace eggs easily.

---

## 🔹 Key Takeaways:

* Use `Arrays.sort(array, comparator)` for **custom sorting logic**.
* Prefer Collections when working with dynamic-sized data.
* Use Generics with Collections for **type safety**.
* Arrays are faster and simpler for fixed-size, homogeneous data.

---

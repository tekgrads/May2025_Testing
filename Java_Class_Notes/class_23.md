 Java Collections: TreeSet, HashMap, TreeMap with Employee Example


##  1. TreeSet

- Implements `NavigableSet`, sorted in natural order.
- No duplicates, null only allowed once.

###  Example:
```java
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(30);
        set.add(10);
        set.add(20);

        System.out.println(set);
    }
}
````

####  Output:

```
[10, 20, 30]
```

---

##  2. HashMap

* Stores data in key-value pairs.
* Unordered, allows one `null` key and multiple `null` values.

###  Example:

```java
import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        System.out.println(map);
    }
}
```

####  Output (order may vary):

```
{1=Apple, 2=Banana, 3=Cherry}
```

---

##  3. TreeMap

* Sorted map using natural ordering or custom Comparator.
* Doesn’t allow `null` keys.

###  Example:

```java
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Zebra", 5);
        map.put("Apple", 2);
        map.put("Mango", 8);

        System.out.println(map);
    }
}
```

####  Output:

```
{Apple=2, Mango=8, Zebra=5}
```

---

##  4. Employee Example using TreeSet (with Comparable)

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
        return this.salary - e.salary;
    }

    public String toString() {
        return name + " - " + salary;
    }
}

public class EmployeeTreeSet {
    public static void main(String[] args) {
        TreeSet<Employee> set = new TreeSet<>();
        set.add(new Employee("Sita", 50000));
        set.add(new Employee("Ram", 60000));
        set.add(new Employee("Geeta", 45000));

        for (Employee e : set) System.out.println(e);
    }
}
```

####  Output:

```
Geeta - 45000
Sita - 50000
Ram - 60000
```

---

##  5. Employee Example using HashMap

```java
import java.util.*;

class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return id + " - " + name;
    }
}

public class EmployeeHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Employee> map = new HashMap<>();
        map.put(101, new Employee("Ravi", 101));
        map.put(102, new Employee("Kiran", 102));

        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
```

####  Output:

```
101 -> 101 - Ravi
102 -> 102 - Kiran
```

---

## 6. Employee Example using TreeMap (Sorting by Key)

```java
import java.util.*;

class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return name + " - " + id;
    }
}

public class EmployeeTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, Employee> map = new TreeMap<>();
        map.put(3, new Employee("Zara", 3));
        map.put(1, new Employee("Amit", 1));
        map.put(2, new Employee("Lata", 2));

        for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
```

####  Output:

```
1 -> Amit - 1
2 -> Lata - 2
3 -> Zara - 3
```


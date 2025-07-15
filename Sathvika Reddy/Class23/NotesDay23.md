

# Java Notes – Collections & Generics

---

## 1. **TreeSet**

**Definition:**
`TreeSet` is a part of `java.util` and implements the `SortedSet` interface. It stores elements in **sorted (ascending)** order and does **not allow duplicates**.

**Key Points:**

* Uses **Red-Black Tree** internally.
* Automatically sorts elements.
* Not thread-safe.

```java
TreeSet<String> set = new TreeSet<>();
set.add("B");
set.add("A");
set.add("C");
System.out.println(set); // Output: [A, B, C]
```

---

## 2. **HashMap**

**Definition:**
`HashMap` stores **key-value** pairs and allows one `null` key and multiple `null` values.

**Key Points:**

* **Unordered**
* Fast retrieval via hashing
* Allows duplicate values but not duplicate keys

```java
package com.tekgrads;

import java.util.HashMap;
import java.util.Map.Entry;

public class Example3 {
    public static void main(String[] args) {
        Map<Integer, String> hm = new HashMap<>();

        hm.put(1, "Ramya");
        hm.put(5, "Sowmya");
        hm.put(3, "Kavya");
        hm.put(2, "Swetha");
        hm.put(4, "Navya");

        System.out.println(hm);

        for (Entry<Integer, String> entry : hm.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
```

---

## 3. **TreeMap**

**Definition:**
`TreeMap` is similar to `HashMap` but stores keys in **sorted (ascending)** order.

**Key Points:**

* Ordered by **keys**
* No `null` keys allowed
* Uses **Red-Black Tree**

```java
TreeMap<Integer, String> tm = new TreeMap<>();
tm.put(3, "Three");
tm.put(1, "One");
tm.put(2, "Two");
System.out.println(tm); // Output: {1=One, 2=Two, 3=Three}
```

---

## 4. **Generics**

**Definition:**
Generics allow **type safety** in classes and methods. They let you write code that works with any data type.

**Example:**

```java
package com.tekgrads;

public class Example1 {
    public static void main(String[] args) {
        Test<Integer, String, Integer> t = new Test<>(1, "Test");
        t.checkDataType();
        System.out.println(t.returnAnyDataType("Integer"));

        Test<String, String, String> t2 = new Test<>("One", "Two");
        t2.checkDataType();
        System.out.println(t.returnAnyDataType("String"));

        Test<String, Integer, String> t3 = new Test<>("hii", 1);
        t3.checkDataType();
        System.out.println(t.returnAnyDataType("String"));

        Test<String, String, Integer> t4 = new Test<>("hii", "hello");
        t4.checkDataType();
        System.out.println(t.returnAnyDataType("Integer"));
    }
}

class Test<A, B, C> {
    A i;
    B j;

    public Test(A i, B j) {
        this.i = i;
        this.j = j;
    }

    void checkDataType() {
        System.out.println("i type is " + i.getClass().getTypeName());
        System.out.println("j type is " + j.getClass().getTypeName());
    }

    C returnAnyDataType(String type) {
        if (type.equals("Integer")) {
            return (C) Integer.valueOf(1);
        } else if (type.equals("String")) {
            return (C) "abc";
        }
        return null;
    }
}
```

---

## 5. **Wildcard Generics**

**Definition:**
Wildcards (`?`) allow more flexible code when working with generics.

**Types:**

* `? extends T`: accepts any subtype of T
* `? super T`: accepts T or any supertype of T

```java
package com.tekgrads;

import java.util.ArrayList;
import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(9);
        l.add(7);
        l.add(10);
        l.add(15);
        System.out.println("The list elements are: " + l);

        // wildcard generics
        List<? super Number> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2.0);
        l1.add(20.00);
        l1.add(15);
        System.out.println("Elements on list2: " + l1);

        List<? super Object> l2 = new ArrayList();
        l2.add(100);
        l2.add("one");
        l2.add(10.0);
        l2.add(90.00);
        l2.add('a');
        System.out.println("Elements on list3: " + l2);
    }
}
```

---

### Summary Table

| Feature       | TreeSet            | HashMap                 | TreeMap          |
| ------------- | ------------------ | ----------------------- | ---------------- |
| Order         | Sorted (ascending) | Unordered               | Sorted by keys   |
| Duplicates    | Not allowed        | Keys not allowed        | Keys not allowed |
| Null Support  | One null allowed   | 1 null key, many values | No null keys     |
| Thread-Safety | No                 | No                      | No               |
| Internal DS   | Red-Black Tree     | Hashing                 | Red-Black Tree   |

---


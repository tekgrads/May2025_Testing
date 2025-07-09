
# Java Collections: TreeSet, HashMap, and TreeMap

Java Collections Framework provides data structures to store, retrieve, and manipulate data efficiently. Among them, **TreeSet**, **HashMap**, and **TreeMap** are widely used.

---

## 1. TreeSet

### Overview:
- `TreeSet` is a part of the `java.util` package and implements the `NavigableSet` interface.
- It stores elements in a **sorted** and **ascending** order (natural ordering or based on a comparator).
- **No duplicate elements** are allowed.

### Key Characteristics:
- Backed by a **TreeMap**.
- Sorted in natural order by default (or via a custom comparator).
- **Time complexity:** O(log n) for basic operations (add, remove, contains).

### Example:
```java
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Apple"); // Duplicate, won't be added

        for (String fruit : set) {
            System.out.println(fruit);
        }
    }
}
```

---

## 2. HashMap

### Overview:
- `HashMap` is a part of `java.util` package and implements the `Map` interface.
- Stores data in **key-value** pairs.
- Allows **one null key** and **multiple null values**.
- **Not ordered** and **not sorted**.

### Key Characteristics:
- Based on **hashing**.
- **Time complexity:** O(1) average time for get/put operations.
- Not synchronized.

### Example:
```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        for (Integer key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
        }
    }
}
```

---

## 3. TreeMap

### Overview:
- `TreeMap` implements the `NavigableMap` interface.
- Stores key-value pairs in **sorted order of keys** (natural ordering or using a comparator).

### Key Characteristics:
- Based on **Red-Black Tree**.
- **Time complexity:** O(log n) for insertion, deletion, and lookup.
- Doesn’t allow **null keys**, but allows multiple **null values**.

### Example:
```java
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Mango", 5);

        for (String key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
        }
    }
}
```

---

## Comparison Table

| Feature           | TreeSet        | HashMap         | TreeMap         |
|------------------|----------------|------------------|------------------|
| Interface        | Set            | Map              | Map              |
| Ordering         | Sorted         | Unordered         | Sorted by keys   |
| Null Elements    | No nulls       | One null key, many null values | No null keys, many null values |
| Duplicates       | Not allowed    | Keys unique       | Keys unique       |
| Performance      | O(log n)       | O(1)              | O(log n)         |
| Backed by        | TreeMap        | Hash Table        | Red-Black Tree    |

---

## Conclusion

Each collection type serves specific use-cases:
- **TreeSet**: When you need a sorted set without duplicates.
- **HashMap**: For fast lookup with unique keys.
- **TreeMap**: When key order matters in map operations.

Use them based on your requirements for sorting, performance, and null handling.

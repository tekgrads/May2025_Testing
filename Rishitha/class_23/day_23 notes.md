
---

## 🌳 **TreeSet**

* A **Sorted Set** (part of `java.util`).
* **Implements**: `NavigableSet`, `SortedSet`, `Set`
* Internally uses a **Red-Black Tree**.
* **Does not allow duplicates**.
* **Sorted in ascending order by default**.

### ✅ Key Features:

* **No duplicates**
* **Sorted order**
* **Null not allowed (for non-empty TreeSet)**

### 🔹 Example:

```java
import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(20);
        ts.add(10);
        ts.add(30);
        ts.add(10); // Duplicate, won't be added

        System.out.println(ts); // Output: [10, 20, 30]
    }
}
```

---

## 🧠 **HashMap**

* Used to store **key-value pairs**.
* **Implements**: `Map` interface.
* **Unordered** – does **not maintain insertion or sorting order**.
* Allows:

  * One `null` key
  * Multiple `null` values

### ✅ Key Features:

* Fast access using key (like a dictionary)
* Duplicate keys not allowed (last one replaces)
* Not synchronized

### 🔹 Example:

```java
import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(101, "Ravi");
        map.put(102, "Sita");
        map.put(103, "Ravi"); // duplicate value allowed
        map.put(101, "Krishna"); // replaces "Ravi"

        System.out.println(map); // {101=Krishna, 102=Sita, 103=Ravi}
    }
}
```

---

## 🌲 **TreeMap**

* A **Sorted Map**.
* Implements: `NavigableMap`, `SortedMap`, `Map`
* Stores keys in **ascending sorted order** (by default).
* **No null keys allowed**, but **null values allowed**.

### ✅ Key Features:

* Sorted by keys
* Faster than HashMap for sorted retrieval
* Cannot have null keys (throws `NullPointerException`)

### 🔹 Example:

```java
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(200, "Apple");
        map.put(100, "Banana");
        map.put(300, "Cherry");

        System.out.println(map); // {100=Banana, 200=Apple, 300=Cherry}
    }
}
```

---

## 📊 **HashMap vs TreeMap**

| Feature     | HashMap                  | TreeMap               |
| ----------- | ------------------------ | --------------------- |
| Ordering    | No order                 | Sorted by key (asc)   |
| Null Keys   | 1 allowed                | Not allowed           |
| Performance | Faster (O(1) operations) | Slower (O(log n))     |
| Use Case    | Fast lookup              | Sorted data retrieval |

---

## 📊 **TreeSet vs HashSet vs LinkedHashSet**

| Feature       | HashSet   | LinkedHashSet       | TreeSet              |
| ------------- | --------- | ------------------- | -------------------- |
| Ordering      | No order  | Maintains insertion | Sorted (ascending)   |
| Duplicates    | ❌ No      | ❌ No                | ❌ No                 |
| Null Elements | ✅ Allowed | ✅ Allowed           | ❌ Only if it's empty |

---

## 🎯 Real-Life Analogies:

* **TreeSet** – Guest list sorted alphabetically (no duplicates).
* **HashMap** – Phonebook with random order, but fast search by name.
* **TreeMap** – Phonebook sorted by name automatically.

---

## 📝 Summary Table

| Collection Type | Key Feature                  | Allows Null Key     | Sorted? |
| --------------- | ---------------------------- | ------------------- | ------- |
| `HashMap`       | Key-value, fast lookup       | ✅ One               | ❌ No    |
| `TreeMap`       | Key-value, sorted by key     | ❌ No                | ✅ Yes   |
| `TreeSet`       | Sorted unique elements (Set) | ❌ No (if not empty) | ✅ Yes   |

---


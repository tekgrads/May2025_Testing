# Class 22: (06/07/2025)

## 31. ArrayList Constructors

1. `ArrayList al = new ArrayList(int initialCapacity);`
2. `ArrayList al = new ArrayList(Collection c);`

---

## 32. Example Code
```java
import java.util.*;

class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        l.add("A");
        l.add(10);
        l.add("A");
        l.add(null);
        System.out.println(l);

        l.remove(2);
        System.out.println(l);

        l.add("2");
        l.add("m");
        l.add("N");
        System.out.println(l);
    }
}
```

---

## 33. Collections and Interfaces

- Collections are often used to **store and transfer** objects.
- To support this, most collections implement:
  - `Serializable`
  - `Cloneable`

### 🧬 Cloneable Interface
- Indicates that an object can be duplicated (cloned).
- Contains **no methods**.
- Considered **unsafe** or not reliable in many cases.

### 🧬 Serializable Interface
- Allows an object to be **converted to a byte stream**.
- Useful for **saving to a file** or **transmitting over a network**.
- Also contains **no methods**.
- Considered **unsafe** in certain contexts.

---

## 34 & 35. RandomAccess Interface

- Present in `java.util` package.
- A **marker interface** (no methods).
- Implemented by:
  - `ArrayList`
  - `Vector`
- Not implemented by:
  - `LinkedList`
- Best suited for **fast retrieval operations**.

---

## 36. Type Checking with Interfaces

```java
ArrayList l1 = new ArrayList();
LinkedList l2 = new LinkedList();

System.out.println(l1 instanceof Serializable); // true
System.out.println(l2 instanceof Cloneable);    // true
System.out.println(l1 instanceof RandomAccess); // true
System.out.println(l2 instanceof RandomAccess); // false
```

---

## 37. ArrayList Notes

- ✅ Best for frequent **retrieval** operations.
- ❌ Worst for frequent **insertion** and **deletion**.

---

## 38. Difference Between ArrayList & Vector

| Feature | ArrayList | Vector |
|--------|-----------|--------|
| Synchronization | Non-synchronized | Synchronized |
| Thread Safety | Not thread-safe | Thread-safe |
| Performance | Faster (no waiting) | Slower (waiting) |
| Legacy | No (introduced in 1.2) | Yes (exists since 1.0) |

---

## 39-41. Synchronized ArrayList

### By default:
- ArrayList is **not synchronized**.

### To get a synchronized version:
```java
List syncList = Collections.synchronizedList(list);
```

### For other collections:

```java
public static Set synchronizedSet(Set s);
public static Map synchronizedMap(Map m);
```

---

## 42-43. LinkedList Overview

- Underlying structure: **Doubly Linked List**
- Insertion order is preserved.
- Allows **duplicates**.
- Allows **heterogeneous objects**.
- **Null** insertion is possible.
- Implements:
  - `Serializable`
  - `Cloneable`
- ❌ Does **not implement** `RandomAccess`
- ✅ Best for **frequent insertion/deletion**
- ❌ Worst for **retrieval**

---

## 44. LinkedList Special Methods

```java
void addFirst();
void addLast();
Object getFirst();
Object getLast();
Object removeFirst();
Object removeLast();
```

---

## Memory Representation of LinkedList

```
 _________   _________   ____________
| data |ref |→| data |ref |→| data |ref |
|______|____| |______|____| |______|____|
```

- Each node holds a reference to the next node.
- Nodes are **not stored contiguously** in memory.
- Unlike ArrayList, **does not support fast index-based access**.

---

## Summary

- Use **ArrayList** for fast access (read-heavy).
- Use **LinkedList** for frequent add/remove operations.
- Use **synchronized wrappers** when working with multiple threads.


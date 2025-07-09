# Class 21: (05/07/2025)

## Sorting in Descending Order

- To sort in descending order, we use a **Comparator**.
- Comparator has a method called `compare()`.

### Example Code:
```java
import java.util.*;

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return -1;
        } else if (o1 < o2) {
            return 1;
        } else {
            return 0;
        }
    }
}
```

#### Comparator Rules:
- If `o1 > o2`, return negative value
- If `o1 < o2`, return positive value
- If `o1 == o2`, return 0

### For Employees:
```java
@Override
public int compareTo(Employee o) {
    return this.salary.compareTo(o.salary);
}
```

---

## What is the Difference Between Comparator and Comparable? (Important for Interviews)

| Comparator | Comparable |
|------------|------------|
| Present in `java.util` | Present in `java.lang` |
| Used for customized sorting | Used for natural sorting |
| Defines `compare()` method | Defines `compareTo()` method |
| Can sort objects of different classes | Can sort only objects of the same class |
| Doesn’t modify original class | Must modify the class to implement Comparable |

- Use Comparator when you want **custom sorting** without modifying the class.

---

## Difference Between Arrays and Collections

### Arrays:
1. Fixed in size.
2. Not memory efficient.
3. Good for performance.
4. Hold only homogeneous data types.
5. Can store both primitives and objects.

### Collections:
1. Growable in nature (dynamic size).
2. More memory-efficient.
3. Slower than arrays in performance.
4. Can store both homogeneous and heterogeneous elements.
5. Can only store object types (not primitives).

---

## 1. Collections:
- Group of heterogeneous entities like Integer, String, Double.
- Framework that provides architecture to store and manipulate group of objects.
- Includes utility classes for List, Set, Queue, and Map.

## 2. Need for Collections:
- Array is a fixed-size structure to store similar data.
- Collections improve **reusability** and **flexibility**.

## 3. What is a Collection?
- Group of individual objects represented as a single unit.

## 4. What is Collections Framework?
- Set of classes and interfaces to handle a group of objects.

## 5. Java vs C++:
| Java | C++ |
|------|-----|
| Collection | Container |
| Collections Framework | STL (Standard Template Library) |

## 6. Key Interfaces:
- Use Collection when you want to group objects.

## 7. Difference: Collection vs Collections
- `Collection`: Interface to represent a group of objects.
- `Collections`: Utility class in `java.util` with helper methods.

---

## 8. List Interface
- Child of Collection.
- Ordered collection (insertion order preserved).
- Allows duplicates.
- Follows LIFO (Last-In, First-Out).
- Classes: ArrayList, LinkedList

## 9. Key Interfaces Hierarchy
```
Collection
  └── List
      ├── ArrayList
      ├── LinkedList
      └── Vector
          └── Stack
```

---

## 10. Set Interface
- Child of Collection.
- Does NOT allow duplicates.
- Insertion order not preserved.

## 11. Set Hierarchy
```
Collection
  └── Set
      ├── HashSet
      └── LinkedHashSet
```

---

## 12. Difference Between List & Set

| List | Set |
|------|-----|
| Allows duplicates | Does not allow duplicates |
| Insertion order preserved | Not preserved |

---

## 13. SortedSet
- Child of Set.
- Maintains elements in sorted order.

## 14. NavigableSet
- Child of SortedSet.
- Provides navigation methods.

## 15. Set Key Interface Hierarchy
```
Collection
  └── Set
      └── SortedSet
          └── NavigableSet
              └── TreeSet
```

---

## 16. Queue Interface
- Child of Collection.
- Follows FIFO (First-In-First-Out).
- Example: Ticket Booking Queue

## 17. Queue Hierarchy
```
Collection
  └── Queue
      ├── PriorityQueue
      └── BlockingQueue
          ├── LinkedBlockingQueue
          └── PriorityBlockingQueue
```

---

## 18. Collection vs Map
- Collection, List, Set, Queue: For individual objects.
- Map: For key-value pairs.

## 19. Map Interface
- Not a child of Collection.
- Keys must be unique; values can be duplicate or null.

## 20. Map Hierarchy
```
Map
  ├── HashMap
  │   └── LinkedHashMap
  ├── WeakHashMap
  ├── IdentityHashMap
  └── Hashtable
      └── Properties
```

## 21. SortedMap
- Child of Map.
- Maintains sorted keys.

## 22. NavigableMap
- Child of SortedMap.
- Supports navigation operations.
```
Map
  └── SortedMap
      └── NavigableMap
          └── TreeMap
```

---

## 23. Collections (Graphical Overview)
- [Refer diagram in textbook or class note]

## 24. Map (Graphical Overview)
- [Refer diagram in textbook or class note]

---

## 25. Collection Interface
- Used to represent group of individual objects as one entity.
- Root interface of Collection framework.

## 26. Important Methods in Collection Interface

| Method | Description |
|--------|-------------|
| `boolean add(Object o)` | Adds an object |
| `boolean addAll(Collection c)` | Adds all elements of a collection |
| `boolean remove(Object o)` | Removes an object |
| `boolean removeAll(Collection c)` | Removes all matching objects |
| `boolean retainAll(Collection c)` | Retains only matching elements |
| `void clear()` | Empties the collection |
| `boolean contains(Object o)` | Checks for presence |
| `boolean containsAll(Collection c)` | Checks if all elements exist |
| `boolean isEmpty()` | Checks if collection is empty |
| `int size()` | Returns number of elements |
| `Object[] toArray()` | Converts to array |
| `Iterator iterator()` | Returns an iterator |

---

## 27. List Interface Specific Methods

| Method | Explanation |
|--------|-------------|
| `void add(int index, Object o)` | Inserts an element at the specified position. |
| `boolean addAll(int index, Collection c)` | Inserts a collection starting at a specific position. |
| `Object get(int index)` | Retrieves element at index. |
| `Object remove(int index)` | Removes element at index. |
| `Object set(int index, Object new)` | Replaces element at index with a new one. |
| `int indexOf(Object o)` | Returns first index of the object. |
| `int lastIndexOf(Object o)` | Returns last index of the object. |
| `ListIterator listIterator()` | Iterates list elements in both directions. |

---

## 28. ArrayList

- Duplicates are allowed.
- Insertion order is preserved.
- Heterogeneous objects allowed (except in TreeSet and TreeMap).
- Null insertion is allowed.

---

## 29. ArrayList Constructors

```java
ArrayList al = new ArrayList();
```
- Creates an empty ArrayList with default capacity 10.
- When capacity is exceeded, new capacity = `(current * 3/2) + 1`.

### Other Constructors:
```java
ArrayList al = new ArrayList(int initialCapacity);
ArrayList al = new ArrayList(Collection c);
```

---

## 30. Example Program

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

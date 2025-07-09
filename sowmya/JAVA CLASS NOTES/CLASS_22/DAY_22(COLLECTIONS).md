# COLLECTIONS

---

## What is a Collection?

* A **Collection** is a group of individual objects stored together and treated as a single unit.
* It is based on an **underlying data structure** and provides **ready-made methods**.
* Collections can hold only **object types**, not **primitive data types**.

---

## Why Use Collections?

1. Store **multiple values**.
2. Collections are **growable** (can increase or decrease in size).
3. Provide **built-in methods** for searching, sorting, adding, deleting, etc.
4. Handle **large amounts of data** easily.
5. Collections are **reusable**.
6. Can hold **heterogeneous (different)** or **homogeneous (same)** data types.
7. More **memory efficient** than arrays in many use cases.

---

## Collection Framework

The **Collection Framework** defines several classes and interfaces to represent a group of objects as a single entity.

There are **9 key interfaces** in the Collection Framework:

---

## 1. `Collection` Interface

* Root interface of the Collection Framework.
* Defines the most common methods (e.g., `insert()`, `delete()`).
* No direct implementation class.

---

### 🔸 Difference Between `Collection` and `Collections`

| Collection                                | Collections                                     |
| ----------------------------------------- | ----------------------------------------------- |
| Interface to represent a group of objects | Utility class in `java.util`                    |
| Root of the Collection Framework          | Provides static methods like sorting, searching |

---

## 2. `List` Interface

* Child interface of `Collection`
* **Ordered collection** that **preserves insertion order**
* **Allows duplicate values**
* Follows **LIFO** (Last-In-First-Out)
* Classes: `ArrayList`, `LinkedList`

---

## 3. `Set` Interface

* Child interface of `Collection`
* **Does not allow duplicate values**
* **Insertion order is not preserved**
* Classes: `HashSet`, `LinkedHashSet`

---

### 🔸 Difference Between `List` and `Set`

| List                      | Set                       |
| ------------------------- | ------------------------- |
| Preserves insertion order | Does not preserve order   |
| Allows duplicates         | Does not allow duplicates |

---

## 4. `SortedSet` Interface

* Child interface of `Set`
* Maintains elements in **sorted order** (ascending or descending)

---

## 5. `NavigableSet` Interface

* Extends `SortedSet`
* Adds navigation methods: `floor()`, `ceiling()`, `lower()`, etc.

---

## 6. `Queue` Interface

* Child interface of `Collection`
* Follows **FIFO** (First-In-First-Out)
* Example: Ticket booking queue
* Classes: `PriorityQueue`, `BlockingQueue`

---

## 7. `Map` Interface

* Map a child of `Collection`.
* Stores data in **key-value pairs**
* **Keys must be unique and non-null**
* **Values can be duplicate or null**
* Classes: `HashMap`, `LinkedHashMap`

---

## 8. `SortedMap` Interface

* Child of `Map`
* Stores key-value pairs in a **sorted order of keys** (ascending/descending)

---

## 9. `NavigableMap` Interface

* Child of `SortedMap`
* Adds navigation and utility methods

---







---

## 📚 1. Important Methods for `Collection` Interface

| Method                              | Description                                                 |
| ----------------------------------- | ----------------------------------------------------------- |
| `boolean add(Object o)`             | Adds an object                                              |
| `boolean addAll(Collection c)`      | Adds one collection to another collection                   |
| `boolean remove(Object o)`          | Removes an object                                           |
| `boolean removeAll(Collection c)`   | Removes all matching objects of one collection from another |
| `boolean retainAll(Collection c)`   | Retains only matching elements, removes others              |
| `void clear()`                      | Clears the entire collection                                |
| `boolean contains(Object o)`        | Checks if the object exists                                 |
| `boolean containsAll(Collection c)` | Checks if all elements exist in the collection              |
| `boolean isEmpty()`                 | Checks if the collection is empty                           |
| `int size()`                        | Returns the size of the collection                          |
| `Object[] toArray()`                | Converts the collection to an array                         |
| `Iterator iterator()`               | Returns an iterator to traverse elements                    |

> 🔹 **Note:** The `Collection` interface does **not** contain any method to retrieve elements by index directly.

---

## 📚 2. Important Methods for `List` Interface

| Method                                    | Description                                   |
| ----------------------------------------- | --------------------------------------------- |
| `void add(int index, Object o)`           | Adds element at a specific index              |
| `boolean addAll(int index, Collection c)` | Adds a collection starting at specified index |
| `Object get(int index)`                   | Retrieves element at index                    |
| `Object remove(int index)`                | Removes element at index                      |
| `Object set(int index, Object new)`       | Replaces element at index with a new one      |
| `int indexOf(Object o)`                   | Returns first index of the object             |
| `int lastIndexOf(Object o)`               | Returns last index of the object              |
| `ListIterator listIterator()`             | Iterates list elements                        |

---

			# 📌 ArrayList in Java

---

### ✅ Features

* `List` is the parent interface of `ArrayList`
* **Duplicates are allowed**
* **Insertion order is preserved**
* Follows **FIFO (First-In-First-Out)**
* Supports **heterogeneous data types**
* Can **grow or shrink** dynamically
* **Null values** are allowed

---

		### 🏗️ ArrayList Constructors

```java
// 1. Default Constructor
ArrayList a1 = new ArrayList();
```

* Default capacity is **10**
* If size exceeds 10, capacity increases as:
  `newCapacity = (currentCapacity * 3 / 2) + 1`

```java
// 2. Constructor with Initial Capacity
ArrayList a1 = new ArrayList(int initialCapacity);

// 3. Constructor using another collection
ArrayList a1 = new ArrayList(Collection c);
```

---




---

## ✅ Example 1: Program on Different Methods in ArrayList

```java
package com.tekgrads;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add(100);
        a1.add("sowmya");
        a1.add(90.0);
        a1.add('p');
        a1.add(null);

        System.out.println(a1);

        a1.remove(3);
        System.out.println(a1);

        a1.add(0, 80);
        System.out.println(a1);

        System.out.println(a1.get(4));
        System.out.println(a1.contains(90.0));

        List a2 = new ArrayList();
        a2.add("hii");
        a2.add(100);
        a2.add("sowmya");

        System.out.println(a1.containsAll(a2));

        a2.add(3);
        System.out.println(a1);
        System.out.println(a2);

        a2.remove("hii");
        System.out.println(a2);
    }
}
```

### 🔹 Output:

```
[100, sowmya, 90.0, p, null]
[100, sowmya, 90.0, null]
[80, 100, sowmya, 90.0, null]
null
true
false
[80, 100, sowmya, 90.0, null]
[hii, 100, sowmya, 3]
[100, sowmya, 3]
```

---

## 📌 Marker Interfaces

### 🧬 Cloneable Interface

* Indicates that objects can be **cloned (copied)**.
* No methods.
* Considered **insecure**.

### 🧬 Serializable Interface

* Allows object to be converted into a **byte stream**.
* Useful for saving objects to a file or transferring over a network.
* No methods.
* Considered **insecure**.

### 🧬 RandomAccess Interface

* Indicates that a list can be **accessed quickly** using an index.
* No methods.
* Implemented by `ArrayList`, `Vector`.
* Makes **searching operations faster**.

---

## ✅ Example 2: Program Using Cloneable, Serializable, and RandomAccess

```java
package com.tekgrads;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.RandomAccess;
import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        List l1 = new ArrayList();
        LinkedList l2 = new LinkedList();

        System.out.println(l1 instanceof Serializable); // true
        System.out.println(l2 instanceof Cloneable);    // true
        System.out.println(l1 instanceof RandomAccess); // true
        System.out.println(l2 instanceof RandomAccess); // false

        List l = Collections.synchronizedList(l1);
    }
}
```

### 🔹 Output:

```
true
true
true
false
```

---
## LinkedList 

## 🧩 Overview

* `List` is the parent interface for `LinkedList`.
* A `LinkedList` consists of **nodes**:

  * Each node has **data** and a **reference to the next node**.
* **Insertion order is preserved**, follows **LIFO** (Last-In-First-Out).
* **Duplicates** are allowed.
* **Heterogeneous data types** are allowed.
* **Null values** are allowed.

### 📌 Memory Representation

```
  _________   _________   ____________
 |node|addr|→|node|addr|→ |node |addr|
 |____|____| |____|____|  |____|_____|
```

* The address of the 1st node points to the 2nd node.
* Memory is **not contiguous**.
* `LinkedList` does **not implement** `RandomAccess` interface.
* Best suited for **frequent insertion/deletion operations**.

---

## 🔗 Types of LinkedList

### ➤ Singly Linked List

* Each node stores data and a **link to the next** node.

### ➤ Doubly Linked List

* Each node stores data, **link to next and previous** nodes.
* Allows traversal in **both directions**.

---

## ✅ Example 3: LinkedList Using List Methods

```java
// Program on List methods using LinkedList
package com.tekgrads;

import java.util.LinkedList;
import java.util.List;

public class Example3 {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();

        l1.add('a');
        l1.add('b');
        l1.add('c');
        l1.add('d');
        System.out.println(l1);

        l1.addFirst(0);
        l1.addLast(5);
        System.out.println(l1);

        l1.add("sowmya");
        l1.add(10);
        l1.add(null);
        l1.add("kavya");
        System.out.println(l1);

        l1.set(0, "sneha");
        System.out.println(l1);

        l1.add(0, "hii");
        System.out.println(l1);

        l1.addFirst("gm");
        System.out.println(l1);
    }
}
```

### 🔹 Output:

```
[a, b, c, d]
[0, a, b, c, d, 5]
[0, a, b, c, d, 5, sowmya, 10, null, kavya]
[sneha, a, b, c, d, 5, sowmya, 10, null, kavya]
[hii, sneha, a, b, c, d, 5, sowmya, 10, null, kavya]
[gm, hii, sneha, a, b, c, d, 5, sowmya, 10, null, kavya]
```

---



## Difference between ArrayList and Vector

### ArrayList

* Every method present in ArrayList is **non-synchronized**
* Multiple threads are allowed to operate simultaneously
* Threads are **not required to wait**
* ArrayList is **not** a legacy class

**Note:**
If we call `Collections.synchronizedList(List l)`, the ArrayList becomes synchronized.

---

## Vector

* Every method present in Vector is **synchronized**
* At a time, **only one thread** can operate on a Vector object
* Threads are **required to wait**
* Vector **is** a legacy class

---

## Example 4: Program on Vector

```java
package com.tekgrads;

import java.util.Vector;

public class Example5 {
    public static void main(String[] args) {
        Vector v = new Vector();

        System.out.println(v.capacity()); // Initial capacity

        for (int i = 0; i < 10; ++i) {
            v.addElement(i);
        }

        System.out.println(v.capacity());

        v.addElement(1); // Adding 11th element

        System.out.println(v.capacity()); // Capacity doubles

        System.out.println(v);
    }
}
```

### Output:

```
10
10
20
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1]
```

> **Note:**
> The initial capacity of a Vector is **10**. If more space is needed, capacity becomes **originalCapacity \* 2**.

---

# STACK

A `Stack<E>` is a generic class that stores elements in **LIFO** (Last-In-First-Out) order.
stack stores in a preserved order
stack allows duplicate values


## Stack Operations:

* `push(item)` – Adds item to the top
* `pop()` – Removes and returns top item
* `peek()` – Returns top item without removing it
* `isEmpty()` – Checks if stack is empty
* `search(item)` – Searches for an element in the stack

---

## Example 5: Program on Stack

```java
package com.tekgrads;

import java.util.Stack;

public class Example6 {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("stack is: " + s);

        s.pop();
        System.out.println("stack is: " + s);

        s.peek();
        System.out.println("stack is: " + s);

        System.out.println(s.search(11));
        System.out.println(s.search(10));
    }
}
```

### Output:

```
stack is: [10, 20, 30]
stack is: [10, 20]
stack is: [10, 20]
-1
2
```

---





## Enumerator in Java

An **Enumerator** is an interface used to traverse elements of legacy collection classes like `Vector` and `Hashtable`.

It provides methods to read elements one by one, similar to an `Iterator`.

### 🧩 Methods in Enumerator

* `hasMoreElements()` – Checks if more elements are available.
* `nextElement()` – Returns the next element.

---

## ✅ Example 6: Program Using Enumerator

```java
package com.tekgrads;

import java.util.Enumeration;
import java.util.Vector;

public class Example7 {
    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 10; i++) {
            v.addElement(i);
        }

        System.out.println("vector is: " + v);

        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            Integer i = (Integer) e.nextElement();
            if (i % 2 == 0) {
                System.out.println("even numbers on enumerator are: " + i);
            }
        }
    }
}
```

### 🔹 Output

```
vector is: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
even numbers on enumerator are: 0
even numbers on enumerator are: 2
even numbers on enumerator are: 4
even numbers on enumerator are: 6
even numbers on enumerator are: 8
```

---

## Iterator in Java

An **Iterator** is an interface used to traverse elements in collections like `ArrayList`, `HashSet`, etc.

It allows you to **safely access and remove elements** during iteration.

### 🧩 Methods in Iterator

* `hasNext()` – Returns `true` if there are more elements.
* `next()` – Returns the next element.
* `remove()` – Removes the current element (optional).

---

## ✅ Example 7: Program Using Iterator

```java
package com.tekgrads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example8 {
    public static void main(String[] args) {
        List l = new ArrayList();
        for (int i = 0; i <= 10; i++) {
            l.add(i);
        }

        System.out.println("list elements are: " + l);

        Iterator itr = l.iterator();
        while (itr.hasNext()) {
            Integer i = (Integer) itr.next();
            if (i % 2 == 0) {
                System.out.println("even numbers on the iterator are: " + i);
                itr.remove();
            }
        }
    }
}
```

### 🔹 Output

```
list elements are: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
even numbers on the iterator are: 0
even numbers on the iterator are: 2
even numbers on the iterator are: 4
even numbers on the iterator are: 6
even numbers on the iterator are: 8
even numbers on the iterator are: 10
```

---

# ListIterator in Java

The **ListIterator** interface allows **bidirectional traversal** of a list (forward and backward).

It supports `set()` and `previous()` methods in addition to those in `Iterator`.

---

## ✅ Example 8: Program Using ListIterator

```java
package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Example9 {
    public static void main(String[] args) {
        List l = new ArrayList();

        for (int i = 0; i < 10; i++) {
            l.add(i);
        }

        System.out.println(l); // [0, 1, 2, ..., 9]

        ListIterator ltr = l.listIterator();
        while (ltr.hasNext()) {
            Integer i = (Integer) ltr.next();
            if (i % 2 == 0) {
                System.out.println("even numbers on the list iterator: " + i);
                ltr.set(50);
            }
        }

        System.out.println(l);

        while (ltr.hasPrevious()) {
            Integer i = (Integer) ltr.previous();
            System.out.println(i);
        }
    }
}
```

### 🔹 Output

```
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
even numbers on the list iterator: 0
even numbers on the list iterator: 2
even numbers on the list iterator: 4
even numbers on the list iterator: 6
even numbers on the list iterator: 8
[50, 1, 50, 3, 50, 5, 50, 7, 50, 9]
9
50
7
50
5
50
3
50
1
50
```

---




## HashSet 

## ✅ Overview

* `HashSet` stores a group of **unique elements**.
* It does **not maintain insertion order**.
* Parent interface: `Set`
* **Duplicates are not allowed**.
* Operations like add, remove, and search are **very fast** due to hash-based storage.

---

## 🔸 Example 9: HashSet Program

```java
package com.tekgrads;

import java.util.HashSet;
import java.util.Set;

public class Example10 {
    public static void main(String[] args) {
        Set hs = new HashSet();
        hs.add(10);
        hs.add(20);
        hs.add(30);
        hs.add(5);
        hs.add(15);
        hs.add(25);

        System.out.println("HashSet elements are: " + hs);

        hs.remove(15);
        System.out.println("HashSet after removal: " + hs);

        System.out.println("Is HashSet empty? " + hs.isEmpty());
        System.out.println("Final HashSet: " + hs);
    }
}
```

### 🔹 Output

```
HashSet elements are: [20, 5, 25, 10, 30, 15]
HashSet after removal: [20, 5, 25, 10, 30]
Is HashSet empty? false
Final HashSet: [20, 5, 25, 10, 30]
```

---

## TreeSet 

## ✅ Overview

* Parent interface: `SortedSet`
* Stores only **unique values** (no duplicates)
* Elements are sorted in **ascending order** by default
* Allows **null** only once and only if the set is empty
* Common methods: `add()`, `remove()`, `isEmpty()`, `size()`, `clear()`

---

## 🔸 Example 10: TreeSet Program

```java
package com.tekgrads;

import java.util.Set;
import java.util.TreeSet;

public class Example10 {
    public static void main(String[] args) {
        Set ts = new TreeSet();
        ts.add(10);
        ts.add(20);
        ts.add(3);
        ts.add(5);
        ts.add(15);
        ts.add(25);

        System.out.println("TreeSet elements: " + ts);

        ts.remove(15);
        System.out.println("TreeSet after removal: " + ts);

        System.out.println("Is TreeSet empty? " + ts.isEmpty());
        System.out.println("Final TreeSet: " + ts);
        System.out.println("Size of TreeSet: " + ts.size());
    }
}
```

### 🔹 Output

```
TreeSet elements: [3, 5, 10, 15, 20, 25]
TreeSet after removal: [3, 5, 10, 20, 25]
Is TreeSet empty? false
Final TreeSet: [3, 5, 10, 20, 25]
Size of TreeSet: 5
```

---

## 🔸 Example 11: TreeSet Using Custom Comparator

```java
package com.tekgrads;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Example12 {
    public static void main(String[] args) {
        Set ts = new TreeSet(new MyComparator());
        ts.add(100);
        ts.add(170);
        ts.add(203);
        ts.add(250);
        ts.add(315);
        ts.add(375);

        System.out.println("TreeSet elements: " + ts);

        ts.remove(315);
        System.out.println("After removal: " + ts);

        System.out.println("Is TreeSet empty? " + ts.isEmpty());
        System.out.println("Final TreeSet: " + ts);
        System.out.println("Size of TreeSet: " + ts.size());
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) return -1;
        else if (o1 < o2) return 1;
        else return 0;
    }
}
```

### 🔹 Output

```
TreeSet elements: [375, 315, 250, 203, 170, 100]
After removal: [375, 250, 203, 170, 100]
Is TreeSet empty? false
Final TreeSet: [375, 250, 203, 170, 100]
Size of TreeSet: 5
```

---





---

### ✅ Example 12: Printing Employee Details using TreeSet (Comparable)

```java
// By default, TreeSet prints in ascending order
package com.tekgrads;

import java.util.Set;
import java.util.TreeSet;

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
}

public class Example13 {
    public static void main(String[] args) {
        Set ts = new TreeSet();
        ts.add(new Employee("ramya", 25, 50000d, "cognizant"));
        ts.add(new Employee("kavya", 26, 70000d, "hcl"));
        ts.add(new Employee("sowmya", 27, 80000d, "Ibm"));
        ts.add(new Employee("ruchitha", 25, 40000d, "cognizant"));
        ts.add(new Employee("harika", 24, 45000d, "accenture"));

        System.out.println(ts);
    }
}
```

### 🔹 Output

```
[
 Employee [name=ruchitha, age=25, salary=40000.0, companyName=cognizant],
 Employee [name=harika, age=24, salary=45000.0, companyName=accenture],
 Employee [name=ramya, age=25, salary=50000.0, companyName=cognizant],
 Employee [name=kavya, age=26, salary=70000.0, companyName=hcl],
 Employee [name=sowmya, age=27, salary=80000.0, companyName=Ibm]
]
```

---

## ✅ Example 13: TreeSet with Comparator

```java
package com.tekgrads;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Example14 {
    public static void main(String[] args) {
        Set ts = new TreeSet(new MyEmployeeComparator());

        ts.add(new Employee("ramya", 25, 50000d, "cognizant"));
        ts.add(new Employee("kavya", 26, 70000d, "hcl"));
        ts.add(new Employee("sowmya", 27, 80000d, "Ibm"));
        ts.add(new Employee("ruchitha", 25, 40000d, "cognizant"));
        ts.add(new Employee("harika", 24, 45000d, "accenture"));

        System.out.println(ts);
    }
}

class MyEmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.salary.compareTo(o1.salary); // descending order
    }
}
```

### 🔹 Output

```
[
 Employee [name=sowmya, age=27, salary=80000.0, companyName=Ibm],
 Employee [name=kavya, age=26, salary=70000.0, companyName=hcl],
 Employee [name=ramya, age=25, salary=50000.0, companyName=cognizant],
 Employee [name=harika, age=24, salary=45000.0, companyName=accenture],
 Employee [name=ruchitha, age=25, salary=40000.0, companyName=cognizant]
]
```

---

## ✅ Example 14: HashSet with Comparable

```java
package com.tekgrads;

import java.util.HashSet;
import java.util.Set;
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
}

public class Example15 {
    public static void main(String[] args) {
        Set hs = new HashSet();

        hs.add(new Employee("ramya", 25, 50000d, "cognizant"));
        hs.add(new Employee("kavya", 26, 70000d, "hcl"));
        hs.add(new Employee("sowmya", 27, 80000d, "Ibm"));
        hs.add(new Employee("ruchitha", 25, 40000d, "cognizant"));
        hs.add(new Employee("harika", 24, 45000d, "accenture"));

        System.out.println(hs);
    }
}
```

### 🔹 Output

```
[
 Employee [name=kavya, age=26, salary=70000.0, companyName=hcl],
 Employee [name=sowmya, age=27, salary=80000.0, companyName=Ibm],
 Employee [name=harika, age=24, salary=45000.0, companyName=accenture],
 Employee [name=ramya, age=25, salary=50000.0, companyName=cognizant],
 Employee [name=ruchitha, age=25, salary=40000.0, companyName=cognizant]
]
```

---





## 🧩 HashMap

* `Map` is the parent interface of `HashMap`
* Stores **key-value** pairs
* **Keys must be unique**, values can be duplicates
* Part of `java.util` package
* Allows **null keys** and **null values**
* **Insertion order is not preserved**

### 🔹 Common Methods

```java
put(K key, V value)         // Adds or updates a key-value pair
get(Object key)             // Returns value for given key
remove(Object key)          // Removes entry for given key
containsKey(Object key)     // Checks if key exists
containsValue(Object value) // Checks if value exists
isEmpty()                   // Checks if map is empty
size()                      // Returns number of entries
clear()                     // Removes all entries
```

---

## ✅ Example 15: HashMap with Basic Methods

```java
package com.tekgrads;

import java.util.HashMap;
import java.util.Map;

public class Example16 {
    public static void main(String[] args) {
        Map hm = new HashMap();

        hm.put(1, "Sowmya");
        hm.put(2, "Ramya");
        hm.put(3, "Kavya");
        hm.put(4, "Swetha");
        hm.put(5, null);
        hm.put(null, "Hello");
        hm.put(4, "Navya"); // Overwrites value for key 4

        System.out.println(hm);
        System.out.println(hm.get(1));
        System.out.println(hm.get(null));
        System.out.println(hm.remove(null));
        System.out.println(hm.containsKey(2));
        System.out.println(hm.containsValue("Navya"));
        System.out.println(hm.isEmpty());
        System.out.println(hm.size());
    }
}
```

### 🔹 Output

```
{null=Hello, 1=Sowmya, 2=Ramya, 3=Kavya, 4=Navya, 5=null}
Sowmya
Hello
Hello
true
true
false
5
```

---

## ✅ Example 16: HashMap with Employee Objects

```java
package com.tekgrads;

import java.util.HashMap;
import java.util.Map;

public class Example18 {
    public static void main(String[] args) {
        Map hm = new HashMap();

        hm.put(2, new Employee("Ramya", 25, 50000d, "Cognizant"));
        hm.put(4, new Employee("Kavya", 26, 70000d, "HCL"));
        hm.put(5, new Employee("Sowmya", 27, 80000d, "IBM"));
        hm.put(3, new Employee("Ruchitha", 25, 40000d, "Aspire Systems"));
        hm.put(1, new Employee("Harika", 24, 45000d, "Accenture"));

        System.out.println(hm);
    }
}
```

### 🔹 Output

```
{1=Employee [name=Harika, age=24, salary=45000.0, companyName=Accenture],
 2=Employee [name=Ramya, age=25, salary=50000.0, companyName=Cognizant],
 3=Employee [name=Ruchitha, age=25, salary=40000.0, companyName=Aspire Systems],
 4=Employee [name=Kavya, age=26, salary=70000.0, companyName=HCL],
 5=Employee [name=Sowmya, age=27, salary=80000.0, companyName=IBM]}
```

---

## 🌳 TreeMap

* `SortedMap` is the parent interface of `TreeMap`
* Entries are sorted **based on keys** in **ascending order**
* **Null keys are not allowed**, but values can be null
* Slower than `HashMap` due to sorting

### 🔹 TreeMap inherits all HashMap methods

### 🔹 Additional TreeMap Methods

```java
firstKey()        // Returns the lowest key
lastKey()         // Returns the highest key
higherKey(K key)  // Returns next higher key
lowerKey(K key)   // Returns next lower key
```

---

## ✅ Example 17: TreeMap with Employee Objects

```java
package com.tekgrads;

import java.util.Map;
import java.util.TreeMap;

public class Example17 {
    public static void main(String[] args) {
        Map tm = new TreeMap();

        tm.put(2, new Employee("Ramya", 25, 50000d, "Cognizant"));
        tm.put(4, new Employee("Kavya", 26, 70000d, "HCL"));
        tm.put(5, new Employee("Sowmya", 27, 80000d, "IBM"));
        tm.put(3, new Employee("Ruchitha", 25, 40000d, "Aspire Systems"));
        tm.put(1, new Employee("Harika", 24, 45000d, "Accenture"));

        System.out.println(tm);
        System.out.println(tm.get(1));
        System.out.println(tm.remove(2));
        System.out.println(tm.containsKey(3));
        System.out.println(tm.containsValue("Harika"));
        System.out.println(tm.isEmpty());
        System.out.println(tm.size());
    }
}
```

### 🔹 Output

```
{1=Employee [name=Harika, age=24, salary=45000.0, companyName=Accenture],
 2=Employee [name=Ramya, age=25, salary=50000.0, companyName=Cognizant],
 3=Employee [name=Ruchitha, age=25, salary=40000.0, companyName=Aspire Systems],
 4=Employee [name=Kavya, age=26, salary=70000.0, companyName=HCL],
 5=Employee [name=Sowmya, age=27, salary=80000.0, companyName=IBM]}

Employee [name=Harika, age=24, salary=45000.0, companyName=Accenture]
Employee [name=Ramya, age=25, salary=50000.0, companyName=Cognizant]
true
false
false
4
```

---



# Example 18: Program on HashMap Using Generics (Java)

```java
package com.tekgrads;

import java.util.HashMap;
import java.util.Map.Entry;

public class Example19 {
    public static void main(String[] args) {
        Map<Integer, String> hm = new HashMap<>();

        hm.put(1, "Ramya");
        hm.put(5, "sowmya");
        hm.put(3, "kavya");
        hm.put(2, "swetha");
        hm.put(4, "navya");

        System.out.println(hm);

        for (Entry<Integer, String> entry : hm.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
```

### ✅ Output

```
{1=Ramya, 2=swetha, 3=kavya, 4=navya, 5=sowmya}
Key = 1, Value = Ramya
Key = 2, Value = swetha
Key = 3, Value = kavya
Key = 4, Value = navya
Key = 5, Value = sowmya
```

---



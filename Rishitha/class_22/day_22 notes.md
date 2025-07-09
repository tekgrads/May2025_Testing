
---
## 📚 Collections Framework Overview

* **Java Collections Framework** is a unified architecture to store, retrieve, and manipulate groups of objects.
* Located in **`java.util`** package.

### 🔹 Main Interfaces:

| Interface | Description                              |
| --------- | ---------------------------------------- |
| `List`    | Ordered, allows duplicates               |
| `Set`     | Unordered, unique elements only          |
| `Map`     | Key-value pairs (not part of Collection) |

---

## 🔁 **ArrayList vs LinkedList**

| Feature       | ArrayList              | LinkedList                      |
| ------------- | ---------------------- | ------------------------------- |
| Access Speed  | Fast (uses index)      | Slow (sequential access)        |
| Insert/Delete | Slow (due to shifting) | Fast (no shifting, just links)  |
| Memory        | Less memory            | More memory (due to node links) |
| Underlying DS | Dynamic array          | Doubly linked list              |

---

## 🧠 **Comparator vs Comparable**

| Feature        | Comparable            | Comparator               |
| -------------- | --------------------- | ------------------------ |
| Package        | `java.lang`           | `java.util`              |
| Method         | `compareTo(Object o)` | `compare(Object o1, o2)` |
| Where to Write | Inside the class      | Outside the class        |
| Flexibility    | Less flexible         | More flexible            |

### ✅ Example:

```java
// Comparable
class Student implements Comparable<Student> {
    int marks;
    public int compareTo(Student s) {
        return this.marks - s.marks;
    }
}

// Comparator
Comparator<Student> byMarksDesc = (s1, s2) -> s2.marks - s1.marks;
```

---

## 📦 **ArrayList Constructors**

* `ArrayList()` → default
* `ArrayList(int capacity)` → with initial capacity
* `ArrayList(Collection c)` → copies from another collection

---

## 🚀 **RandomAccess Interface**

* Marker interface in `java.util`.
* Indicates that a class (like `ArrayList`) supports **fast random access**.

> 🎭 Think of it like Netflix: instantly jumping to a specific episode.

---

## 🧮 **Vector**

* Legacy class from Java 1.0.
* **Thread-safe** (synchronized).
* Slower than `ArrayList` in single-threaded apps.

---

## 🧱 **Stack**

* Subclass of `Vector`.
* **LIFO (Last-In-First-Out)** structure.

### ✅ Common Methods:

* `push(E item)`
* `pop()`
* `peek()`
* `empty()`

---

## 🧭 **Java Cursors**

| Cursor Type    | Used For              | Key Methods                          |
| -------------- | --------------------- | ------------------------------------ |
| `Iterator`     | All collections       | `hasNext()`, `next()`, `remove()`    |
| `ListIterator` | Only List types       | `hasPrevious()`, `add()`, `remove()` |
| `Enumeration`  | Legacy (e.g., Vector) | `hasMoreElements()`, `nextElement()` |

---

## 🔍 Real-Life Analogies:

* **ArrayList** → Shelf with boxes (indexed, fast lookup)
* **LinkedList** → People in a line (easy to insert/remove)
* **Comparator** → External rules for sorting (e.g., by name, marks)
* **Stack** → Pile of plates (take the top first)

---

## 📝 Summary Table

| Concept     | Notes                                 |
| ----------- | ------------------------------------- |
| Collections | Store group of objects                |
| ArrayList   | Fast access, slow insert/delete       |
| LinkedList  | Slow access, fast insert/delete       |
| Vector      | Synchronized version of ArrayList     |
| Stack       | LIFO, extends Vector                  |
| Comparable  | Inside class for natural sorting      |
| Comparator  | External class for custom sorting     |
| Cursors     | Traverse collections (Iterator, etc.) |

---


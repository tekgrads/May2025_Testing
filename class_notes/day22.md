# 📘 Java Collections Framework (JCF)

---

## 🧱 What is Java Collections Framework?

Java Collections Framework is a **set of classes and interfaces** that implement commonly reusable **data structures** such as lists, sets, queues, and maps.

### 📦 Benefits:
- Provides built-in data structures.
- Simplifies data manipulation (sorting, searching, etc.).
- Improves code reusability and efficiency.

---

## 📂 Main Interfaces in Collections

| Interface | Description                          | Common Implementations        |
|-----------|--------------------------------------|-------------------------------|
| List      | Ordered collection with duplicates   | `ArrayList`, `LinkedList`     |
| Set       | Unordered collection without duplicates | `HashSet`, `TreeSet`       |
| Queue     | Holds elements for processing        | `PriorityQueue`, `LinkedList` |
| Map       | Key-value pairs                      | `HashMap`, `TreeMap`, `Hashtable` |

---

## 🧾 List Interface

### ✅ Features:
- Maintains insertion order.
- Allows duplicate elements.
- Elements accessed by index.

### 🧪 Example:
```java
import java.util.*;

List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Apple");

System.out.println(list);  // Output: [Apple, Banana, Apple]
 Set Interface
✅ Features:
No duplicates allowed.

Unordered (in HashSet).

🧪 Example:
java
Copy
Edit
Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple");

System.out.println(set);  // Output: [Apple, Banana] (no duplicates)
⏳ Queue Interface
✅ Features:
Used for processing in FIFO (First In First Out) order.

Used in tasks like job scheduling, buffering.

🧪 Example:
java
Copy
Edit
Queue<String> queue = new LinkedList<>();
queue.add("A");
queue.add("B");
queue.poll();  // Removes "A"

System.out.println(queue);  // Output: [B]
🔑 Map Interface
✅ Features:
Stores data in key-value pairs.

Keys are unique, values can be duplicated.

🧪 Example:
java
Copy
Edit
Map<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");

System.out.println(map.get(1));  // Output: One
🔄 Utility Class: Collections
Java provides a Collections utility class with static methods like:

sort()

reverse()

shuffle()

max(), min()

🧪 Example:
java
Copy
Edit
Collections.sort(list);     // Sorts a list
Collections.reverse(list);  // Reverses the list order
🧠 Summary Table
Type	Allows Duplicates	Maintains Order	Key-Value?	Example Use
List	Yes	Yes	No	Ordered data like names
Set	No	No (HashSet)	No	Unique items like IDs
Queue	Yes	Yes (FIFO)	No	Task scheduling
Map	No (keys)	Depends on type	Yes	Storing user data by ID

✅ When to Use What?
List: When order matters and duplicates are allowed.

Set: When uniqueness is required.

Queue: For processing elements in order.

Map: When data must be accessed using a key.
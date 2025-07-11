
# 📚 Collections in Java

Java Collections Framework (JCF) is a **unified architecture** for representing and manipulating groups of objects. It includes **interfaces, classes, and algorithms** to store, retrieve, and manipulate data efficiently.

---

## 🔑 Core Interfaces

| Interface     | Description                                       | Implementations                             |
|---------------|---------------------------------------------------|----------------------------------------------|
| `Collection`  | Root of the collection hierarchy                  | `List`, `Set`, `Queue`                       |
| `List`        | Ordered collection with duplicates                | `ArrayList`, `LinkedList`, `Vector`, `Stack` |
| `Set`         | Unordered collection without duplicates           | `HashSet`, `LinkedHashSet`, `TreeSet`        |
| `Queue`       | FIFO data structure                               | `LinkedList`, `PriorityQueue`, `Deque`       |
| `Map`         | Key-value pairs (not part of Collection hierarchy)| `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable` |

---

## 📦 Important Classes

| Class            | Type     | Description                                                             |
|------------------|----------|-------------------------------------------------------------------------|
| `ArrayList`      | List     | Resizable array, fast for search                                        |
| `LinkedList`     | List     | Doubly linked list, fast for insert/delete                              |
| `HashSet`        | Set      | Unordered, unique elements, uses hashing                               |
| `LinkedHashSet`  | Set      | Maintains insertion order                                               |
| `TreeSet`        | Set      | Sorted set (natural ordering or custom comparator)                      |
| `HashMap`        | Map      | Key-value pairs, unordered, allows null keys/values                     |
| `LinkedHashMap`  | Map      | Maintains insertion order of keys                                       |
| `TreeMap`        | Map      | Sorted map based on keys                                                |
| `PriorityQueue`  | Queue    | Elements ordered by natural order or comparator                         |
| `Stack`          | List     | LIFO (Last-In-First-Out) structure using Vector                         |

---

## 🔧 Utility Class: `Collections`

The `java.util.Collections` class provides **static utility methods** to operate on or return collections.

### 🔹 Common Methods:

- `Collections.sort(list)`
- `Collections.reverse(list)`
- `Collections.shuffle(list)`
- `Collections.max(list)`
- `Collections.min(list)`
- `Collections.frequency(list, element)`

---

## 🔐 Synchronization

Collections like `ArrayList`, `HashMap`, etc. are **not thread-safe**.

To make them thread-safe:
```java
List<String> syncList = Collections.synchronizedList(new ArrayList<>());
Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());

🚀 Example: Using List and Map
import java.util.*;

public class CollectionExample {
	public static void main(String[] args) {
		// List Example
		List<String> fruits = new ArrayList<>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Mango");
		System.out.println(fruits);

		// Set Example
		Set<Integer> numbers = new HashSet<>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(10); // Duplicate, will not be added
		System.out.println(numbers);

		// Map Example
		Map<String, Integer> scores = new HashMap<>();
		scores.put("Alice", 90);
		scores.put("Bob", 85);
		scores.put("Alice", 95); // Overwrites previous value
		System.out.println(scores);
	}
}

🔹 List Interface
Ordered collection, preserves insertion order

Allows duplicates

Follows LIFO

Implemented by ArrayList, LinkedList

🔹 Set Interface
Unordered, no duplicates

Implemented by HashSet, LinkedHashSet

🔹 Queue Interface
Follows FIFO

Examples: PriorityQueue, BlockingQueue

🔹 Map Interface
Key-value pair store

Keys must be unique

Implemented by HashMap, TreeMap

🔹 Important List Methods
add(), get(), remove(), set(), contains(), indexOf(), lastIndexOf()

✅ ArrayList Features
Preserves order

Allows duplicates and nulls

Dynamic size

Implements RandomAccess (fast search)
package com.tekgrads;

import java.util.ArrayList;
import java.util.List;

public class Example {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(1);
		al.add("test");
		System.out.println(al);

		List<String> list = new ArrayList<>();

		list.add("Test");
		list.add("Test2");
		// list.add(1);
		System.out.println(list);

		List<?> list2 = new ArrayList<>();

//		list2.add("Test");
//		list2.add(1);
		
		
		List<? extends Number> list3 = new ArrayList<>();
		
		//list3.add(1);
		
		List<? super Number> list4 = new ArrayList<>();
		list4.add(1);
		list4.add(2.0);
		
		System.out.println(list4);
		
		

	}

}

🔹 HashMap
Key-value store

Allows one null key, multiple null values

No order maintained

package com.tekgrads;

import java.util.HashMap;
import java.util.Map.Entry;

public class Employee {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap();
		map.put(1, "Anusha");
		map.put(6, "Harshi");
		map.put(3, "Arch");
		map.put(2, "Shrav");
		map.put(4, "Simran");
		
		System.out.println(map);
		
		 for (Entry<Integer, String> entry : map.entrySet()) {
	            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	        }

	}

}

🔹 TreeMap
Sorted based on keys

No null keys

Slower than HashMap
package com.tekgrads;

import java.util.HashMap;
import java.util.TreeMap;

public class Example {

	public static void main(String[] args) {
		TreeMap map = new TreeMap();
		
		
		map.put(6, new Employee("Anu", 31, 50000d, "Amazon"));
		map.put(1, new Employee("Harshi", 28, 20000d, "Honeywell"));			
		map.put(4, new Employee("Arch", 31, 100000d, "Cognizant"));
		map.put(5, new Employee("Shrey", 31, 10000d, "IBM"));
		map.put(2, new Employee("Navi", 30, 4000d, "Accenture"));
		map.put(3, new Employee("Yog", 31, 1000d, "Infosys"));
	
		
		System.out.println(map);
				
		

	}

}

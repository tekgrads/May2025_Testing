☕ Day-22 – Java Collections


1️⃣ What is Java Collections Framework?

Java Collections Framework provides architecture to store and manipulate a group of objects using interfaces, implementations (classes), and algorithms.

 🔗 Core Interfaces:
- List
- Set
- Queue
- Map

🧱 Common Implementations:

| Interface | Implementations               |
|-----------|-------------------------------|
| List      | ArrayList, LinkedList, Vector |
| Set       | HashSet, LinkedHashSet        |
| Map       | HashMap, TreeMap              |
| Queue     | PriorityQueue, ArrayDeque     |


2️⃣ Disadvantages of Comparator

| Disadvantage                  | Explanation                             |
|------------------------------|-----------------------------------------|
| Verbose Code                 | External class required for custom sorting |
| Inflexibility for Single Use | Needs class even if used once           |
| Can’t be used with natural ordering | Must always specify manually      |
| Extra class/method overhead  | More boilerplate code                   |


3️⃣ Comparator vs Comparable

| Feature          | Comparable           | Comparator                  |
|------------------|----------------------|-----------------------------|
| Package          | java.lang            | java.util                   |
| Interface Method | compareTo(Object o)  | compare(Object o1, Object o2) |
| Modifies         | Current class        | External class              |
| Use              | Natural sorting      | Custom, multiple sort criteria |
| Used with        | Arrays.sort(), Collections.sort() | Same         |


4️⃣ ArrayList Constructors


ArrayList<E> list1 = new ArrayList<>();            // Default capacity (10)
ArrayList<E> list2 = new ArrayList<>(20);          // Custom initial capacity
ArrayList<E> list3 = new ArrayList<>(otherList);   // Copy from another collection


5️⃣ RandomAccess Interface

- Marker interface (no methods)
- Implemented by classes like ArrayList
- JVM uses it to identify fast, indexed access capability


if (list instanceof RandomAccess) {
    System.out.println("Supports fast access");
}


6️⃣ LinkedList as Array

Example:

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        System.out.println(list);
    }
}

 7️⃣ Difference: ArrayList vs LinkedList

| Feature        | ArrayList             | LinkedList             |
|----------------|------------------------|-------------------------|
| Backed by      | Array                  | Doubly Linked List     |
| Access speed   | Fast (index-based)     | Slow (traverse from start) |
| Insert/delete  | Slow (resizing/shifting) | Fast (no shifting)   |
| Memory usage   | Less                   | More                   |
| Implements     | RandomAccess           | Not RandomAccess       |



 8️⃣ Vector

- Legacy class from Java 1.0
- Synchronized (thread-safe)
- Grows by doubling size

Vector<Integer> v = new Vector<>();
v.add(10);
v.add(20);
System.out.println(v);


9️⃣ Stack

- Subclass of Vector
- LIFO (Last-In-First-Out)

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        System.out.println(stack.pop()); // B
    }
}


🔟 Three Cursors in Java

| Cursor       | Used with       | Package     | Methods                                |
|--------------|------------------|-------------|----------------------------------------|
| Enumeration  | Legacy classes   | java.util   | hasMoreElements(), nextElement()       |
| Iterator     | All collections  | java.util   | hasNext(), next(), remove()            |
| ListIterator | List only (both ways) | java.util | hasNext(), previous(), add() etc.      |

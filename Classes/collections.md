Collections Framework, Comparator, ArrayList, LinkedList & More
1. Collections and Its Framework
The Collections Framework in Java is a set of classes and interfaces used to store and manipulate groups of data.

Major Interfaces:
List – ordered collection (e.g., ArrayList, LinkedList)
Set – no duplicates allowed (e.g., HashSet)
Map – key-value pairs (e.g., HashMap)
Funny Example:
Collections are like a kitchen shelf – jars (lists), spice boxes (sets), and recipe books with page numbers (maps).

2. Disadvantages of Comparator
More code: You need to create a separate class or anonymous function.
Slower: Slightly slower than Comparable due to extra object creation.
External: Comparison logic is outside the object class.
Funny Example:
Comparator is like your friend who always gives suggestions about your looks. It's not from you – it's external and noisy.

3. Comparator vs Comparable
Feature	Comparable	Comparator
Package	java.lang	java.util
Method	compareTo(Object o)	compare(Object o1, Object o2)
Logic inside	Class itself	Separate class
Flexibility	Less flexible	More flexible
Example:
Comparable is like students sorting themselves by marks. Comparator is like a teacher rearranging them based on behavior.

4. ArrayList Constructors
ArrayList() – default constructor.
ArrayList(int capacity) – with initial capacity.
ArrayList(Collection c) – copy another collection.
5. RandomAccess Interface
It is a marker interface used by classes like ArrayList to indicate fast access using index.

Funny Example:
It’s like Netflix – you can jump to any episode instantly. Not like LinkedList where you have to press "Next" again and again.

6. LinkedList vs Array
LinkedList is dynamic, Array is fixed-size.
LinkedList allows faster insertions/deletions.
Array is faster for random access.
7. ArrayList vs LinkedList
Feature	ArrayList	LinkedList
Access speed	Fast (uses index)	Slow (go node by node)
Insert/delete	Slow (shift elements)	Fast (just change links)
Memory	Less memory	More memory (stores links)
8. Vector
Legacy class, synchronized.
Slower than ArrayList in single-threaded use.
Grows 2x in size when full.
Funny Example:
Vector is like a grandparent – slow but safe and reliable.

9. Stack
Extends Vector.
Follows LIFO (Last In First Out).
Main Methods:
push(), pop(), peek(), empty()
10. Three Cursors of Java
Cursor	Used With	Methods
Iterator	All collections	hasNext(), next(), remove()
ListIterator	List only	next(), previous(), add(), remove()
Enumeration	Legacy (Vector)	hasMoreElements(), nextElement()
Funny Example:
Iterator is like a TV remote – you can go forward.
ListIterator is like a music player – you can go next and back.
Enumeration is like a cassette player – old school and forward only.

Java Collections: TreeSet, HashMap, and TreeMap
1. TreeSet
A TreeSet is a collection that stores elements in a sorted and ascending order.
It does not allow duplicates.
Example:
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("Banana");
        set.add("Apple");
        set.add("Mango");
        set.add("Apple"); // duplicate, will be ignored

        System.out.println("TreeSet elements:");
        for (String fruit : set) {
            System.out.println(fruit);
        }
    }
}
Output:

Apple
Banana
Mango
2. HashMap
A HashMap stores key-value pairs.
It allows one null key and multiple null values.
The order is not guaranteed.
Example:
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(2, "Duplicate"); // overwrites value for key 2

        System.out.println("HashMap elements:");
        for (Integer key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
        }
    }
}
Output:

1 => One
2 => Duplicate
3 => Three
3. TreeMap
A TreeMap stores key-value pairs in sorted order of keys.
Does not allow null keys, but allows null values.
Example:
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Banana", 3);
        map.put("Apple", 5);
        map.put("Mango", 2);

        System.out.println("TreeMap elements:");
        for (String key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
        }
    }
}
Output:

Apple => 5
Banana => 3
Mango => 2
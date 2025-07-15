 ☕ Day-23 – Java Collections: TreeSet, HashMap, and TreeMap

🌳 1. TreeSet

- A TreeSet is a collection that stores elements in a sorted and ascending order.
- It does not allow duplicates.
✅ Example:

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

🔑 2. HashMap

- A HashMap stores key-value pairs.
- It allows one null key and multiple null values.
- The order is not guaranteed.

 ✅ Example:

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


🌲 3. TreeMap

- A TreeMap stores key-value pairs in sorted order of keys.
- Does not allow null keys, but allows null values.

✅ Example:

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

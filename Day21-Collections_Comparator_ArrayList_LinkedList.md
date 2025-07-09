
# Java Collections Framework

## What is Collections Framework?
- The **Collections Framework** is a unified architecture for storing and manipulating groups of objects.
- It includes interfaces, implementations (classes), and algorithms.
- It helps in managing data in dynamic and efficient ways.

## Key Interfaces in Collections Framework:
- `Collection`
- `List`
- `Set`
- `Queue`
- `Map`

## Benefits of Collections Framework:
- Reduces programming effort.
- Provides interoperability between unrelated APIs.
- Increases program speed and quality.

---

## Comparator Interface

- `Comparator` is used to define custom ordering for objects.
- It is part of `java.util` package.
- It overrides the `compare()` method.

### Example:
```java
import java.util.*;

class Student {
    int rollno;
    String name;

    Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }
}

class NameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

public class Test {
    public static void main(String args[]) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(101, "Zara"));
        list.add(new Student(102, "Mira"));
        list.add(new Student(103, "Ava"));

        Collections.sort(list, new NameComparator());

        for (Student s : list) {
            System.out.println(s.rollno + " " + s.name);
        }
    }
}
```

---

## ArrayList

- `ArrayList` is a **resizable array** implementation of the `List` interface.
- Allows duplicate elements.
- Maintains insertion order.
- Provides random access to elements.

### Example:
```java
import java.util.*;

public class Example {
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println(list.get(1)); // Output: Banana

        list.remove("Banana");

        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}
```

## Common ArrayList Methods:
| Method         | Description                        |
|----------------|------------------------------------|
| `add()`        | Adds an element                    |
| `remove()`     | Removes an element                 |
| `get()`        | Retrieves an element by index      |
| `size()`       | Returns the number of elements     |
| `clear()`      | Removes all elements               |
| `contains()`   | Checks if element exists           |

---

## LinkedList

- `LinkedList` implements both `List` and `Deque` interfaces.
- Allows duplicate elements.
- Maintains insertion order.
- Good for frequent addition/removal of elements.

### Example:
```java
import java.util.*;

public class Example {
    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Dog");
        list.add("Cat");
        list.add("Horse");

        list.addFirst("Cow");
        list.addLast("Sheep");

        list.remove("Cat");

        for (String animal : list) {
            System.out.println(animal);
        }
    }
}
```

## ArrayList vs LinkedList

| Feature                | ArrayList                 | LinkedList                 |
|------------------------|---------------------------|----------------------------|
| Data Structure         | Dynamic Array             | Doubly Linked List         |
| Access Time            | Fast random access        | Slow random access         |
| Insertion/Deletion     | Slow (shifting required)  | Fast (no shifting)         |
| Memory                 | Less memory overhead      | More memory (node pointers)|

---

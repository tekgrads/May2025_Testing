
# Java Initialization and Memory Errors

## 1. Static Initialization Blocks (SIB)

Static Initialization Blocks in Java are used to initialize static variables. They run once when the class is loaded – **even before the `main()` method** is executed.

### Syntax:
```java
class StaticExample {
    static int value;

    static {
        System.out.println("Static block running!");
        value = 42;
    }

    public static void main(String[] args) {
        System.out.println("Main method running!");
        System.out.println("Value: " + value);
    }
}
```
### Output:
```
Static block running!
Main method running!
Value: 42
```

### Funny Analogy:
Imagine you're entering a theme park (`main()`), but the management (`static block`) has already cleaned and decorated everything **before** the first guest arrives! 🎢✨

---

## 2. Out of Memory Error

An `OutOfMemoryError` in Java happens when the JVM can't allocate memory for an object because:
- Heap is full.
- Too many objects created without cleanup.
- Infinite recursion or very large data structures.

### Example of Heap Overflow:
```java
import java.util.ArrayList;

public class OOMExample {
    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        while (true) {
            list.add(new int[1000000]); // Continuously allocates memory
        }
    }
}
```
This code keeps eating up memory like an endlessly hungry cookie monster 🍪 until the JVM says, "ENOUGH!" and throws:
```
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
```

### Funny Analogy:
Think of the JVM like a bus 🚌. It can only take a certain number of passengers (objects). If everyone in the city tries to board at once, the bus driver throws an `OutOfMemoryError` and stops the ride.

---

### How to Fix:
- Increase heap size using `-Xmx` JVM option.
- Remove unnecessary object references.
- Use proper data structures.
- Always close resources and connections.


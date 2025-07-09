
#  Reflection API, Island Objects, and Arrays in Java

##  1. Reflection API

The Reflection API in Java allows inspection and manipulation of classes, methods, fields, and constructors at runtime.

###  Example: Getting class metadata
```java
import java.lang.reflect.*;

class Sample {
    public int x;
    private String y;

    public void display() { System.out.println("Hello Reflection!"); }
}

public class ReflectDemo {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("Sample");
            System.out.println("Class Name: " + cls.getName());

            Method[] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println("Method: " + m.getName());
            }

            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                System.out.println("Field: " + f.getName());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
```
####  Output:
```
Class Name: Sample
Method: display
Field: x
Field: y
```

---

##  2. Island Objects

Island objects are groups of objects that reference each other but are no longer referenced by any active part of the program. These objects become unreachable and eligible for garbage collection.

### Example:
```java
class Island {
    Island i;
    public static void main(String[] args) {
        Island a = new Island();
        Island b = new Island();

        a.i = b;
        b.i = a;

        a = null;
        b = null;

        // Both objects are unreachable and ready for GC
        System.gc();
        System.out.println("Island objects are eligible for GC.");
    }
}
```
####  Output:
```
Island objects are eligible for GC.
```

> Note: You can't force GC, but the objects become collectible.

---

##  3. Arrays in Java

###  Declaration and Initialization
```java
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
```
####  Output:
```
10
20
30
40
```

###  Multi-Dimensional Array
```java
public class MultiArray {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2},
            {3, 4}
        };
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```
####  Output:
```
1 2
3 4
```

---

##  4. Sorting Arrays in Java

Java provides `Arrays.sort()` to sort array elements.

### Example: Sorting Integers
```java
import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
```
####  Output:
```
[1, 2, 5, 9]
```

###  Example: Sorting Strings
```java
import java.util.Arrays;

public class SortStrings {
    public static void main(String[] args) {
        String[] names = {"Zara", "Amit", "John"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));
    }
}
```
####  Output:
```
[Amit, John, Zara]
```

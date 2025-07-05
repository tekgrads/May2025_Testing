
# Advanced Java Concepts 



## 1. Reflection API

Reflection in Java allows you to inspect and modify classes, methods, and fields at runtime.

> "It's like asking an object — 'Tell me all your secrets!' And Java actually answers."

```java
import java.lang.reflect.*;

class Robot {
    public void greet() {
        System.out.println("Hello, human!");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Robot");
        Method method = clazz.getMethod("greet");
        Object obj = clazz.getDeclaredConstructor().newInstance();
        method.invoke(obj); // Outputs: Hello, human!
    }
}
```

---

## 2. Island Objects

Island objects are unreachable objects that reference each other, forming a group that's no longer reachable from any active part of the program.

> "Imagine a group of friends stranded on an island — they talk to each other, but no one else knows they exist."

Garbage collector will eventually clean them up.

```java
class A {
    B b;
}

class B {
    A a;
}



## 3. Strings, String Pool

Strings are **immutable**, and Java optimizes memory by storing literal strings in a **String Pool**.

> "Why create a new pizza if one with the same toppings is already in the fridge?"

```java
String a = "Java";
String b = "Java";
System.out.println(a == b); // true - both refer to the same object in pool

String c = new String("Java");
System.out.println(a == c); // false - 'c' is outside the pool
```

Use `.equals()` to compare contents and `==` to compare references.

---

## 4. Arrays in Java

Arrays are containers that hold multiple values of the same type.

> "Like an egg carton, but for variables."

```java
int[] eggs = new int[6];
eggs[0] = 1;
System.out.println(eggs[0]); // 1
```

### Array Declaration Styles

```java
int[] arr1 = new int[5]; // preferred
int arr2[] = new int[5]; // also valid
```

### Multidimensional Arrays

```java
int[][] matrix = new int[3][3];
matrix[0][1] = 9;
```

---

## 5. Array Sorting in Java

Java provides utility methods in the `Arrays` class to sort arrays easily.

> "Why manually arrange your clothes when you can hire a butler?"

```java
import java.util.Arrays;

int[] numbers = {42, 12, 67, 3};
Arrays.sort(numbers);
System.out.println(Arrays.toString(numbers)); // [3, 12, 42, 67]
```

You can also sort strings and custom objects using comparators.

```java
String[] fruits = {"Banana", "Apple", "Mango"};
Arrays.sort(fruits);
System.out.println(Arrays.toString(fruits)); // [Apple, Banana, Mango]
```


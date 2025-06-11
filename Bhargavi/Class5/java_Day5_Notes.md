
# ☕ Java Notes - Class 5 (08/06/2025)

## 🔷 Static Initialization Blocks (SIB)

- A `static` block is used to initialize static variables.
- **Executed automatically by JVM** when the class is loaded.
- Runs **before** the `main()` method.
- **Multiple static blocks** are executed in the order they appear in the code.
- Only **static members** can be accessed within static blocks.

### ✅ Syntax:
java
static {
    // initialization code
}


### ✅ Example:
java
public class A {
    static int i;
    static int j = 10;

    static {
        i = 5;
        j = 20;
        System.out.println("Static block in A executed. i: " + i + ", j: " + j);
    }

    public static void main(String[] args) {
        System.out.println("Hello from A!");
    }
}
```

### ❓What if there's only a static block and no `main()`?
- ❌ Error: JVM needs a `main()` method to start execution.

---

## 🧠 Local vs Global Variables

| Type            | Declared Where?              | Scope                                                 | Example                         |
|-----------------|------------------------------|--------------------------------------------------------|---------------------------------|
| Local Variable  | Inside a method/block        | Only within that method/block                         | `int age = 25;` inside a method |
| Global Variable | Outside method, inside class | Accessible across methods (via objects or class name) | `String name = "Alex";`         |

> 🔹 Local variables take **priority** if names conflict.

---

## 🏷 Accessing Variables Across Classes

### Accessing **static** variables:
```java
class F {
    static int i = 100;
}

class G {
    static int i = 200;

    public static void main(String[] args) {
        System.out.println(G.i);   // Access within same class
        System.out.println(F.i);   // Access from another class
    }
}
```

> ✅ Only the class containing `main()` is executed unless another class is referenced.

---

## 🧰 Memory Diagram: Classes F and G

1. Java process starts → enters **stack memory**.
2. JVM loads class `G` into **heap memory**.
3. Static block executes → variable `i` updated.
4. `main()` enters stack memory.
5. Class `F` is pulled in when referenced.

---

## 🔨 Object Creation in Java

```java
public class L {
    int i;

    public static void main(String[] args) {
        L l1 = new L();
        System.out.println("l1.i = " + l1.i);
        l1.i = 10;

        L l2 = new L();
        l2.i = 20;

        L l3 = new L();
        l3.i = 30;

        System.out.println("l2.i = " + l2.i);
        System.out.println("l3.i = " + l3.i);
    }
}
```

- Each object (`l1`, `l2`, `l3`) has its own **copy of instance variable `i`**.

---

## 🧹 Orphan Objects & Garbage Collection

### 🧍 Orphan Objects:
- Objects without any reference pointing to them.

```java
Person p = new Person();
p = null;  // Object is now orphan
```

### ♻ Garbage Collector:
- **Automatically removes** orphan objects to free memory.
- Java doesn't require manual deletion like in C/C++.

---

## 🚫 OutOfMemoryError

### Causes:
- Excessive object creation.
- Infinite loops creating new objects.

### Example:
```java
while (true) {
    new Person();  // Will eventually cause OutOfMemoryError
}
```

### ❗ Fix:
- Optimize code logic.
- Avoid infinite object creation.
- Increasing memory size is a **temporary fix**.

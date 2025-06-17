# ☕ Java Notes - Class 5 (08/06/2025)

---

## 🔷 Static Initialization Blocks (SIB)

- `static` is a **block**, not a method or class.
- **Purpose**: Performs the **third round** of initialization.
- Called by the **JVM automatically** (not manually).
- All `static` blocks are executed **before** the `main()` method.
- Execution happens **in the order** they are written, regardless of position in code.
- Only **static members** can be accessed inside `static` blocks.

### ❓ What if we have only SIBs?
- No `main()` method present → ❌ **Error**
- JVM cannot start execution → **Execution will not happen**

### ✅ Example Code: Static Initialization Block

```java
public class A {
    static int i;
    static int j = 10;

    static {
        A.i = 100;
        A.j = 200;
    }
}
```

---

## 🧠 Local vs Global Variables

- **Local variables** always have **higher preference** over global variables.
- If you declare a class as `public`, then the **class name must match the file name**.

---

## 🏷 Accessing Variables from Another Class

- Access static variable `i` from class `F` inside class `G`:
  ```java
  F.i;
  ```
- If accessing from within the same class:
  ```java
  i;
  ```

---

## 🧰 Memory Diagram Explanation for 2 Classes (F and G)

1. `java` process enters **stack memory**.
2. JVM pulls **class G** into heap.
3. Static variable `i` initialized as `0`.
4. Then `i` updated to `200` (from static block or assignment).
5. `main()` method enters **stack memory**.
6. `i` in class F initialized to `0`, then set to `100`.

---

## 🔨 Creating Objects in Java

### ✅ Example Code: Creating Objects

```java
public class L {
    int i;

    public static void main(String[] args) {
        L l1 = new L();
        System.out.println("hello L");
        System.out.println("Value of i from class L from l1: " + l1.i);
        l1.i = 10;
        System.out.println("Value of i from class L after assignment (l1): " + l1.i);

        L l2 = new L();
        l2.i = 20;
        System.out.println("Value of i from class L after assignment (l2): " + l2.i);

        L l3 = new L();
        l3.i = 30;
        System.out.println("Value of i from class L after assignment (l3): " + l3.i);
    }
}
```

---

## 🧹 Orphan Objects & Garbage Collection

### 🧍 Orphan Objects
- After execution, `l1`, `l2`, `l3` **no longer referenced**.
- These are called **orphan objects**.

### ♻️ Garbage Collector
- JVM's **Garbage Collector** is responsible for cleaning up these **orphan objects**.

---

## 🚫 Out of Memory Error

- Occurs due to excessive memory usage or **infinite object creation**.
- ✅ Increasing heap/stack memory is **not a permanent solution**.
- 🧠 **Fix the logic** in code to prevent infinite loops or uncontrolled object creation.

---

_End of Class 5 Notes_

# Java: Static Initialization, Object Creation, Garbage Collection, and Heap Dump

---

## 1. Static Initialization Blocks in Java

### 🔹 What is a Static Block?

A **static block** is used to initialize static variables in a class. It executes **once** when the class is loaded into memory, even before the `main()` method.

### 🔸 Syntax:
```java
class Example {
    static int value;

    static {
        value = 10;
        System.out.println("Static block executed.");
    }

    public static void main(String[] args) {
        System.out.println("Main method: " + value);
    }
}
```

### 🔸 Key Points:
- Executes only once per class loading.
- Useful for complex static variable initialization.

---

## 2. Object Creation in Java

### 🔹 Ways to Create Objects:

1. **Using `new` keyword**  
   ```java
   MyClass obj = new MyClass();
   ```

2. **Using `Class.forName()`**  
   ```java
   Class.forName("MyClass"); // Loads the class
   ```

3. **Using `clone()` method**  
   ```java
   MyClass obj2 = (MyClass) obj1.clone();
   ```

4. **Using Serialization/Deserialization**

5. **Using Reflection**

---

## 3. Orphan Objects in Java

### 🔹 What is an Orphan Object?

An **orphan object** is an object that is no longer referenced by any variable and becomes unreachable.

### 🔸 Example:
```java
MyClass obj = new MyClass();
obj = null; // Old object becomes orphan
```

Such objects are **eligible for garbage collection**.

---

## 4. Garbage Collection (GC) in Java

### 🔹 What is Garbage Collection?

Garbage Collection is the **automatic process** by the JVM to reclaim memory by deleting **unreachable (orphan) objects**.

### 🔸 Key Points:
- JVM uses GC to free heap memory.
- Can be requested using:
  ```java
  System.gc();
  ```

### 🔸 Common GC Algorithms:
- Mark and Sweep
- Generational GC (Young, Old, Metaspace)

---

## 5. Heap Dump

### 🔹 What is a Heap Dump?

A **heap dump** is a snapshot of the **heap memory** at a specific point in time. It contains all the objects and references present in memory.

### 🔸 Uses:
- Analyze memory leaks
- Debug `OutOfMemoryError`
- Performance optimization

### 🔸 How to Generate:
- Using JVM option:
  ```bash
  -XX:+HeapDumpOnOutOfMemoryError
  ```
- Tools:
  - `jmap`
  - `jvisualvm`
  - Eclipse Memory Analyzer (MAT)

---

## ✅ Summary Table

| Concept               | Description                                               |
|------------------------|-----------------------------------------------------------|
| Static Block           | Initializes static variables when class loads             |
| Object Creation        | Done via new, reflection, clone, etc.                     |
| Orphan Object          | Unused/unreferenced object eligible for GC                |
| Garbage Collection     | JVM-managed memory cleanup process                        |
| Heap Dump              | Snapshot of heap for analysis and debugging               |

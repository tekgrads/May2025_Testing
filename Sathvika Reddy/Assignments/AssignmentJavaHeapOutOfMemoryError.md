
# TG Assignment: Java Heap OutOfMemoryError - Causes and Fixes (08/06/25)

## 🔍 What is Java Heap Memory?
In Java, Heap Memory is the area where all class instances and arrays are allocated. It is managed by the Java Virtual Machine (JVM), and memory from this region is automatically reclaimed by the Garbage Collector.

> Think of the Heap like your room — you keep adding things (objects), and if you don't clean up (collect garbage), one day your room will be full and you can’t put anything more. That's when you get...

## 💣 What is `java.lang.OutOfMemoryError: Java heap space`?
This error occurs when the JVM runs out of heap memory and is unable to allocate memory for a new object.

```
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
```

## 🧠 Understanding the Heap: Diagram
```
+---------------------+
|     Java Heap       |  <- Where objects live
|  -----------------  |
| | Eden Space      | |  <- New objects
| |-----------------| |
| | Survivor Space  | |  <- Recently used
| |-----------------| |
| | Old Generation  | |  <- Long-living objects
+---------------------+
```
If this whole box gets filled, and GC can't clean it... 💥 Boom!

## 🎯 Common Causes and Fixes

### 1. ❌ Memory Leak:
- **Cause:** Objects are referenced but never used again. GC can't remove them.
- **Example:** Large collections (List, Map) keep growing without being cleared.
- **Fix:**
  - Use profilers like VisualVM, JProfiler, or Eclipse MAT to detect memory leaks.
  - Clear unused collections:
    ```java
    myList.clear();
    ```
  - Avoid static references to large objects.

### 2. 📸 Large Objects Creation:
- **Cause:** Creating huge arrays or large file buffers in one go.
    ```java
    int[] hugeArray = new int[Integer.MAX_VALUE];
    ```
- **Fix:**
  - Break large objects into chunks.
  - Use streaming (e.g., `BufferedReader`) for reading large files instead of loading everything at once.

### 3. 🌀 Infinite Object Creation (Bad Loop):
- **Cause:** Unintended infinite loops or recursion that keep creating objects.
    ```java
    while (true) {
        list.add(new Object());
    }
    ```
- **Fix:**
  - Always add loop/recursion exit conditions.
  - Use tools to monitor object creation rate.

### 4. ⚙️ Improper JVM Heap Size:
- **Cause:** JVM has very small heap allocated.
- **Fix:** Increase heap memory using VM options:
    ```bash
    java -Xms512m -Xmx2048m MyApp
    ```
  - `-Xms`: Initial heap size
  - `-Xmx`: Maximum heap size

### 5. 🏃 High Object Retention Time:
- **Cause:** Long-lived objects stay in Old Generation, and GC can’t reclaim fast enough.
- **Fix:**
  - Tune GC algorithms (use G1GC, ZGC for modern apps).
  - Analyze object lifetimes and reduce longevity where possible.

### 6. 📦 Too Many Classes / ClassLoaders:
- **Cause:** Apps (like web servers) dynamically load classes and never unload them.
- **Fix:**
  - Ensure proper unloading of classes in frameworks.
  - Use the same classloader instance wherever possible.
  - In web apps, cleanly stop/redeploy applications.

## 🧪 Real-World Example:
**Code:**
```java
import java.util.*;
public class MemoryEater {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        while (true) {
            list.add(new int[1000000]);  // ~4MB per array
        }
    }
}
```

**Output:**
```
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
```

**Fix:**
- Limit heap size or stop infinite loop.

## 🎁 Tips to Avoid It:
✅ Keep your collections clean  
✅ Don’t hold unused object references  
✅ Use the right JVM options  

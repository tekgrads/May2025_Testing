# Java Heap OutOfMemoryError - Causes and Fixes

## What is OutOfMemoryError in Java?
The `java.lang.OutOfMemoryError: Java heap space` is a runtime error that occurs when the Java Virtual Machine (JVM) cannot allocate an object because it is out of memory and no more heap memory can be made available by the garbage collector.

---

## Causes of OutOfMemoryError

### 1. **Memory Leak**
- When objects are no longer needed but are still referenced.
- Common with static collections (like `List`, `Map`).

### 2. **Large Data Structures**
- Loading large amounts of data in memory (e.g., reading large files or DB results).

### 3. **Infinite Loop Creating Objects**
- Uncontrolled object creation without releasing memory.

### 4. **Improper JVM Heap Settings**
- Inadequate memory allocated via `-Xmx` and `-Xms`.

### 5. **Third-party Libraries or Frameworks**
- Using poorly managed libraries that retain unnecessary references.

---

## Fixes and Solutions

### 1. **Increase Heap Size**
Use JVM options to increase heap memory:
```bash
java -Xms512m -Xmx1024m MyApp
```

### 2. **Analyze Heap Dump**
Use tools like:
- Eclipse MAT (Memory Analyzer Tool)
- VisualVM
- JConsole

### 3. **Fix Memory Leaks**
- Remove unnecessary object references.
- Use WeakReference for cache-like structures.
- Close all resources (DB connections, streams).

### 4. **Use Efficient Data Structures**
- Replace heavy objects or collections with lightweight ones.

### 5. **Limit Scope of Object References**
- Declare variables in the smallest possible scope.

### 6. **Code Optimization**
- Avoid unnecessary object creation.
- Reuse existing objects.

### 7. **Garbage Collection Tuning**
- Tune GC algorithms using JVM options like `-XX:+UseG1GC`, `-XX:+UseConcMarkSweepGC`.

---

## Monitoring Tools
- **JVisualVM**: Monitors heap usage and GC activity.
- **JConsole**: Tracks memory and thread usage.
- **YourKit**, **JProfiler**: Commercial profilers with heap analysis.

---

## Example
```java
List<String> list = new ArrayList<>();
while (true) {
    list.add(UUID.randomUUID().toString());
}
```
> This will eventually cause `OutOfMemoryError` as the list keeps growing without limit.

---

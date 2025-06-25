 Java Heap Memory & OutOfMemoryError: Complete Interview Notes
🔷 What is Java Heap Memory?
Heap Memory is a part of the JVM memory where:

All objects (created with new) are stored

Instance variables and class-level variables (if part of objects) reside

JVM Garbage Collector (GC) works to reclaim unused memory

🔹 Key Characteristics of Heap Memory
Property	Description
Used for	Dynamic memory allocation (new keyword)
Scope	Shared among all threads
Managed by	Garbage Collector
Division	Divided into Young Generation and Old Generation
Storage	Object instances, arrays, collections
Lifetime	As long as objects are referenced
Error if exhausted	java.lang.OutOfMemoryError: Java heap space

🔹 Heap Structure (Generational Model)
sql
Copy
Edit
+--------------------------+
|         Heap             |
|--------------------------|
| Young Generation         | → Short-lived objects (frequent GC)
|   - Eden Space           |
|   - Survivor Space       |
|--------------------------|
| Old (Tenured) Generation| → Long-lived objects (rare GC)
+--------------------------+
⚠️ What is OutOfMemoryError?
It’s a runtime exception thrown when the JVM can’t allocate memory for new objects and garbage collection fails to reclaim enough space.

Error Example:

java
Copy
Edit
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
🔹 Common Causes of Heap OutOfMemoryError
Cause	Description
🔸 Memory Leaks	Objects are unintentionally retained (e.g., in collections or caches)
🔸 Large Data Structures	Big arrays, maps, lists held in memory
🔸 Heavy Object Creation	Inside loops or recursion without cleanup
🔸 Improper Use of Static	Static maps/lists grow unbounded
🔸 Finalizer Delay	Objects with finalize() may delay GC
🔸 Dynamic Class Loading	e.g., via Reflection or frameworks
🔸 Holding references	to objects that are no longer needed

🔧 How to Fix OutOfMemoryError?
✅ JVM Heap Settings
Increase memory size (temporary fix):

bash
Copy
Edit
java -Xms512m -Xmx2048m MyApp
-Xms: Initial heap size

-Xmx: Maximum heap size

✅ Best Practices to Avoid
Tip	Why it helps
✅ Use primitive types	Lower memory than wrapper classes
✅ Avoid string concatenation in loops	Use StringBuilder
✅ Use efficient collections	Prefer ArrayList over LinkedList, use proper initial capacity
✅ Nullify unused references	Helps GC reclaim memory
✅ Don’t use static fields for temporary data	Prevents object eligibility for GC

✅ Memory Leak Detection Tools
Tool	Purpose
🔍 VisualVM	Monitor memory usage and perform heap dumps
🔍 JProfiler	Deep memory profiling
🔍 Eclipse MAT	Analyze memory dumps for leak suspects
🔍 Java Flight Recorder (JFR)	Lightweight profiling tool from Oracle

✅ Garbage Collection Tuning
Customize JVM GC behavior with flags like:

bash
Copy
Edit
-XX:+UseG1GC
-XX:MaxGCPauseMillis=200
-XX:+HeapDumpOnOutOfMemoryError
-XX:HeapDumpPath=./heapdump.hprof
🧠 What is a Heap Dump?
A heap dump is a snapshot of JVM memory at a specific time. It captures:

All object instances

References between objects

Memory consumption details

Use: Analyze to detect memory leaks or high usage areas.

🔁 Real-Life Scenario Example
java
Copy
Edit
import java.util.ArrayList;
public class MemoryTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            list.add("Memory Leak " + System.nanoTime());
        }
    }
}
Result: This causes OutOfMemoryError because memory is never released.
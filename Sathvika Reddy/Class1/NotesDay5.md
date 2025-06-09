#TG Notes Day5 - 8/6/25
# 🧹 Garbage Collection in Java

Garbage Collection (GC) in Java is the process by which the Java Virtual Machine (JVM) automatically removes objects that are no longer in use to free up memory.

---

## 📘 Description

In Java, memory is allocated dynamically to objects. As your program runs, it creates many objects—some are needed, and some become obsolete. Rather than having the programmer track which objects are no longer needed and manually delete them, Java provides an automatic process called **Garbage Collection**.

Think of it like this: you're in your room coding, and whenever you finish eating chips or drinking soda, you just throw the wrappers on the floor. Eventually, a robot cleaner (aka Garbage Collector) comes by and removes all the trash you don't need anymore—while you keep coding without interruption.

---

## 😂 Funny Example

```java
class PizzaBox {
    public void finalize() {
        System.out.println("PizzaBox cleaned up! 🍕🧹");
    }
}

public class HungryCoder {
    public static void main(String[] args) {
        PizzaBox box1 = new PizzaBox();
        PizzaBox box2 = new PizzaBox();

        // Done with boxes after eating pizza
        box1 = null;
        box2 = null;

        // Call the cleaner
        System.gc();

        System.out.println("Back to coding... 🍕➡️💻");
    }
}
```

**Output might be:**
```
PizzaBox cleaned up! 🍕🧹
PizzaBox cleaned up! 🍕🧹
Back to coding... 🍕➡️💻
```

---

## 🧠 How It Works – Diagrammatic Representation

```text
+--------------------+         +----------------------+
|    Active Object   | ----->  |  Reference Variable  |
+--------------------+         +----------------------+

           ⬇                If reference is removed:
           X

+--------------------+         +----------------------+
| Unreachable Object |     ->  |     Garbage Heap     |
+--------------------+         +----------------------+

           ⬇
     [Garbage Collector]
           ⬇
    Object Memory Reclaimed
```

---

## ✅ Why Garbage Collection?

- **Automatic memory management**
- **Avoids memory leaks**
- **Improves performance**
- **Reduces developer burden**

---

## 🔄 How It Works

JVM keeps track of references to objects. When an object is no longer reachable from any live thread or static reference, it becomes **eligible for garbage collection**.

---

## 🔥 Types of Garbage Collectors

1. **Serial GC**
2. **Parallel GC**
3. **CMS (Concurrent Mark Sweep) GC**
4. **G1 (Garbage First) GC**
5. **ZGC & Shenandoah** (for low pause time)

---

## 🚫 Finalization

Java provides a `finalize()` method which can be overridden to perform cleanup before object is collected. But it's **deprecated** in latest versions due to unpredictability.

---

## 📦 Example Code: Basic Garbage Collection

```java
class GarbageExample {
    int objId;

    GarbageExample(int id) {
        this.objId = id;
    }

    protected void finalize() throws Throwable {
        System.out.println("Garbage collected object with id: " + objId);
    }

    public static void main(String[] args) {
        GarbageExample g1 = new GarbageExample(1);
        GarbageExample g2 = new GarbageExample(2);

        g1 = null;  // Eligible for GC
        g2 = null;  // Eligible for GC

        // Suggest JVM to run GC
        System.gc();

        System.out.println("End of main method");
    }
}
```

---



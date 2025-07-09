
### 📘 Java Class 19 – Object Class in Java

---

## 🔷 What is `Object` Class?

* The `Object` class is the **superclass of all Java classes**.
* Every class in Java **implicitly extends** the `Object` class, even if you don’t mention it.
* It contains methods that are **common to all Java objects**.

---

## 🧬 Key Methods of Object Class

| Method              | Purpose                        | Funny Analogy                        |
| ------------------- | ------------------------------ | ------------------------------------ |
| `toString()`        | Gives string form of object    | "Introduce yourself"                 |
| `equals(Object)`    | Compares two objects logically | "Are we twins or strangers?"         |
| `hashCode()`        | Unique integer for each object | "Secret agent number"                |
| `getClass()`        | Returns runtime class          | "Tell me who you really are!"        |
| `clone()`           | Makes a copy of object         | "Ctrl+C in real life"                |
| `finalize()`        | Cleanup before destruction     | "One last goodbye before you die"    |
| `wait() / notify()` | Used in thread communication   | "Sleep and wake signals for threads" |

---

## 🔹 1. `toString()` – Object to String

📌 **Purpose**: Prints meaningful object data instead of memory address
📌 **Default**: `ClassName@HashCode`

```java
class Bird {
    public String toString() {
        return "Tweet tweet, I’m a Bird!";
    }
}
```

🧾 Output:

```
Tweet tweet, I’m a Bird!
```

---

## 🔹 2. `equals(Object obj)` – Check for equality

📌 Default behavior: compares **memory addresses**
📌 Common use: override to compare object content

```java
String s1 = new String("Apple");
String s2 = new String("Apple");

System.out.println(s1 == s2);       // false
System.out.println(s1.equals(s2));  // true
```

---

## 🔹 3. `hashCode()` – Unique Integer

📌 Used in `HashMap`, `HashSet`, etc.
📌 If `equals()` is overridden, `hashCode()` must be too!

```java
System.out.println("Dog".hashCode()); // Ex: 67907
```

---

## 🔹 4. `getClass()` – Runtime Type Check

📌 Returns runtime class of the object

```java
Dog d = new Dog();
System.out.println(d.getClass()); // class Dog
```

---

## 🔹 5. `clone()` – Copy of Object

📌 Creates a shallow copy
📌 Must implement `Cloneable`
📌 Use `super.clone()`

```java
class Sheep implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```

---

## 🔹 6. `finalize()` – Before Garbage Collection

📌 Called by Garbage Collector before object is destroyed

```java
protected void finalize() throws Throwable {
    System.out.println("Cleanup done!");
}
```

✅ Rarely used now; discouraged in modern Java.

---

## 🔹 7. `wait()`, `notify()`, `notifyAll()` – Thread Communication

📌 Used to coordinate between multiple threads on same object
📌 Must be used inside `synchronized` blocks

```java
synchronized(obj) {
    obj.wait();
    obj.notify();
}
```

---

## 🧪 Full Example with `toString()` and `equals()`

```java
class Student {
    int roll;

    Student(int roll) {
        this.roll = roll;
    }

    public String toString() {
        return "Roll: " + roll;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return this.roll == s.roll;
    }
}

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student(101);
        Student s2 = new Student(101);

        System.out.println(s1);                 // Roll: 101
        System.out.println(s1.equals(s2));      // true
    }
}
```

---

## 📌 Summary Table

| Method        | Used For               | Must Override?                |
| ------------- | ---------------------- | ----------------------------- |
| `toString()`  | String output          | ✅ Yes (often)                 |
| `equals()`    | Logical equality check | ✅ Yes                         |
| `hashCode()`  | Hash-based collections | ✅ If equals is done           |
| `clone()`     | Duplicate object       | ☑️ Optional (needs interface) |
| `getClass()`  | Type inspection        | ❌ No need                     |
| `wait/notify` | Thread control         | ☑️ If using threads           |

---


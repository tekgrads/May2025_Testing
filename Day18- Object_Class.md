
# Object Class in Java

The `Object` class in Java is the **root class** of the Java class hierarchy. Every class in Java implicitly inherits from `Object` if no other superclass is specified.

---

##  Why is Object class important?

- Provides default implementations of basic methods
- Enables polymorphism and upcasting
- Forms the foundation for all Java classes

---

##  Key Methods in Object Class

| Method                | Description |
|------------------------|-------------|
| `toString()`           | Returns a string representation of the object |
| `equals(Object obj)`   | Compares two objects for equality |
| `hashCode()`           | Returns the hash code value for the object |
| `getClass()`           | Returns the runtime class of the object |
| `clone()`              | Creates and returns a copy of the object |
| `finalize()`           | Called by the garbage collector before object is removed |
| `wait(), notify(), notifyAll()` | Used for inter-thread communication |

---

##  Example: Using Object Methods

```java
public class MyClass {
    int id;

    MyClass(int id) {
        this.id = id;
    }

    public String toString() {
        return "MyClass ID: " + id;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyClass)) return false;
        MyClass other = (MyClass) obj;
        return this.id == other.id;
    }

    public static void main(String[] args) {
        MyClass obj1 = new MyClass(1);
        MyClass obj2 = new MyClass(1);
        System.out.println(obj1.toString());
        System.out.println(obj1.equals(obj2)); // true
    }
}
```

---

##Different Ways to Create Objects in Java

### 1. Using `new` Keyword
```java
MyClass obj = new MyClass();
```

### 2. Using Class `newInstance()` Method (Deprecated in newer versions)
```java
MyClass obj = MyClass.class.newInstance();
```

### 3. Using `Constructor` class from Reflection
```java
Constructor<MyClass> constructor = MyClass.class.getConstructor();
MyClass obj = constructor.newInstance();

```

---

## Summary

- `Object` class is the superclass of all classes in Java.
- It defines core methods like `toString()`, `equals()`, and `hashCode()`.
- Java supports various ways to instantiate objects including reflection, cloning, and deserialization.



# Object Class in Java

The `Object` class is the **mother of all classes** in Java. Every class in Java directly or indirectly inherits from the `Object` class.

Imagine `Object` as the grandmother who passes down stories (methods) to every Java class in the family tree.

---

## Methods of the Object Class (with Funny Examples)

### 1. `public final Class<?> getClass()`

Returns the runtime class of the object.

> "I don't care what you pretend to be, tell me what class you *really* are!"

```java
Dog d = new Dog();
System.out.println(d.getClass()); // Outputs: class Dog
```

### 2. `public int hashCode()`

Returns a hash code value for the object. Useful in hash-based collections.

> "Every object has a secret code. Like spies, but nerdier."

```java
System.out.println("Cat".hashCode()); // Prints a number like 67890
```

### 3. `public boolean equals(Object obj)`

Compares two objects for equality.

> "Are you my twin, or just a random stranger?"

```java
String a = new String("Apple");
String b = new String("Apple");
System.out.println(a.equals(b)); // true
```

### 4. `protected Object clone() throws CloneNotSupportedException`

Creates and returns a copy of the object.

> "Ctrl + C for objects!"

```java
class Sheep implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```

### 5. `public String toString()`

Returns a string representation of the object.

> "Introduce yourself, please."

```java
class Bird {
    public String toString() {
        return "Tweet tweet, I’m a Bird!";
    }
}
```

### 6. `public void notify()`

Wakes up a single thread that's waiting on this object's monitor.

> "Hey you! Wake up!"

### 7. `public void notifyAll()`

Wakes up all threads that are waiting on this object's monitor.

> "Party’s over, everyone wake up!"

### 8. `public void wait()`
### 9. `public void wait(long timeout)`
### 10. `public void wait(long timeout, int nanos)`

Causes the current thread to wait until it's awakened.

> "I'm just going to nap until someone pokes me."

```java
synchronized(obj) {
    obj.wait();
}
```



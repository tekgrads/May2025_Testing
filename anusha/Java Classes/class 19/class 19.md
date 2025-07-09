
# Java Class 19 Notes – 🧱 Object Class in Java

## 🔎 What is the `Object` Class?

- Root class of all Java classes.
- Every class implicitly extends it (unless specified otherwise).
- Defined in `java.lang` package.

---

## 📦 Common Methods in `Object` Class

| Method                         | Description                                                   |
|--------------------------------|---------------------------------------------------------------|
| `toString()`                   | String representation of the object                          |
| `equals(Object obj)`          | Compares objects logically                                    |
| `hashCode()`                  | Returns hash code (used in collections)                      |
| `getClass()`                  | Returns runtime class                                         |
| `clone()`                     | Performs shallow copy (requires `Cloneable`)                 |
| `finalize()`                  | Called by GC before object destruction                       |
| `wait()`, `notify()`, `notifyAll()` | Thread communication methods                              |

---

## ✅ `toString()` Example

```java
@Override
public String toString() {
    return "Employee[id=" + id + ", name=" + name + "]";
}
```

---

## ✅ `equals(Object obj)` Example

```java
@Override
public boolean equals(Object obj) {
    if (!(obj instanceof C)) return false;
    return this.i == ((C)obj).i;
}
```

---

## ✅ `hashCode()` Example

```java
@Override
public int hashCode() {
    return Integer.toString(i).hashCode() + Integer.toString(j).hashCode();
}
```

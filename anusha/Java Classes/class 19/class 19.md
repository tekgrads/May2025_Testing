# Java Class 20 Notes – 🧱 Object Class in Java

## 🔎 What is the `Object` Class?

- The `Object` class is the **root class** of the Java class hierarchy.
- Every class in Java **implicitly extends** the `Object` class (unless another class is explicitly extended).
- It is defined in the `java.lang` package.

> ✅ All classes in Java inherit from `Object` either directly or indirectly.

---

## 🧩 Why is it Important?

- Provides **default behavior** for all Java objects.
- Allows Java to treat all classes as objects in a **polymorphic** and **generic** way.
- Essential for features like:
  - Collections
  - Reflection
  - Object comparison
  - Cloning
  - Multithreading (via `wait()` and `notify()`)

---

## 📦 Common Methods in `Object` Class

| Method                         | Description                                                                 |
|--------------------------------|-----------------------------------------------------------------------------|
| `toString()`                   | Returns a string representation of the object                              |
| `equals(Object obj)`          | Compares two objects for equality                                          |
| `hashCode()`                  | Returns an integer hash code                                               |
| `getClass()`                  | Returns runtime class of the object (`Class<?>`)                           |
| `clone()`                     | Creates a shallow copy of the object (implements `Cloneable` interface)     |
| `finalize()`                  | Called by the garbage collector before object is removed from memory       |
| `wait()`, `notify()`, `notifyAll()` | Used for inter-thread communication (must be called within synchronized block) |

---

## 🔍 Important Method Details

### 1. `toString()`

- Default: returns string like `ClassName@HashCode`
- Override to print meaningful object info

```java
@Override
public String toString() {
    return "Employee[id=" + id + ", name=" + name + "]";
}

Example:

package com.tekgrads;

class A {
    int i;
}

class Example1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.i);
        System.out.println(a);        
    }
}
2. toString() – Object to String

package com.tekgrads;

class B {
    int i, j;

    B(int i, int j) {
        this.i = i;
        this.j = j;
    }

//    public String toString() {
//        return "i=" + i + ", " + "j=" + j;
//    }
}

public class Example2 {
    public static void main(String[] args) {
        B b1 = new B(1, 2);
        System.out.println(b1);

        B b2 = new B(10, 20);
        System.out.println(b2);
    }
}

3. equals(Object obj)
Default: compares memory addresses (==)

Override to compare values logically


package com.tekgrads;

class C {
    int i;
    C(int i) {
        this.i = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C)) {
            return false;
        }
        return this.i == ((C) obj).i;
    }
}

public class Example3 {
    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        C c1 = new C(1);
        C c2 = new C(1);
        System.out.println(c1 == c2);       // false
        System.out.println(i == j);         // true
        System.out.println(c1.equals(c2));  // true
    }
}
4. hashCode() – Unique Integer

package com.tekgrads;

class E {
    int i;
    int j;

    E(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int hashCode() {
        return Integer.toString(i).hashCode() + Integer.toString(j).hashCode();
    }
}

public class Example5 {
    public static void main(String[] args) {
        E e1 = new E(1, 2);
        E e2 = new E(1, 3);
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}
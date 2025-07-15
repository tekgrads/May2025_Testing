
# Java Notes – Reflection API and Island Objects

---

### Reflection API

**Definition:**
Reflection is a feature in Java that allows inspection and manipulation of classes, methods, and fields at runtime.
**Use:**
It is used to dynamically load classes, call methods, and access fields even if their names are unknown at compile time.

```java
// Package declaration
package com.tekgrads;

// Import the Reflection API (Method class used here)
import java.lang.reflect.Method;

// Class with some methods
class A {
    public void m1() {
        System.out.println("It is the 1st method with no parameters");
    }

    public void m2(int i) {
        System.out.println("It is the 2nd method having parameters, and the value is " + i);
    }
}

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException {
        String className = "com.tekgrads.A"; // This is the class name using package

        Class c1 = Class.forName(className);

        Method[] m = c1.getDeclaredMethods(); // Declaring some methods

        for (Method m1 : m) {
            // Getting the method names using getName() in the for loop
            System.out.println(m1.getName());
        }
    }
}
```

---

### Island Objects

**Definition:**
Island objects are a group of objects that reference each other but are not referenced by any active thread.
**Use:**
Although they are internally connected, they become unreachable from the application and are eligible for garbage collection.

```java
package com.tekgrads;

class C {
    C c1;
}

public class IslandObjects {
    public static void main(String[] args) {
        C c1 = new C();
        C c2 = new C();
        C c3 = new C();

        c1.c1 = c2;
        c2.c1 = c3;
        c3.c1 = c1;

        c1 = c2 = c3 = null;

        System.out.println("The Island object process is completed");
    }
}
```



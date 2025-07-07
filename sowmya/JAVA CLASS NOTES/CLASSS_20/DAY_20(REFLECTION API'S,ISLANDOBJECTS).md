							# Reflection API

---

Reflection is a feature in the Java programming language. It allows an executing Java program to examine or "introspect" upon itself,
and manipulate internal properties of the program. For example, it's possible for a Java class to obtain the names of all its members and display them.

It is part of the `java.lang.reflect` package.

In Reflection API, the class name is used along with its package, as shown below.

---

### Example 1:

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

### Creating objects in `main` and accessing methods using reflection

This example demonstrates how to:

* Create a class name dynamically
* Load the class at runtime using reflection
* Instantiate an object
* Access and invoke methods using the `Method` class

---

### Example 2:

```java
// Creating objects in main and accessing the methods using objects
package com.tekgrads;
//importing the packages
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class B {
    public void m1() {
        System.out.println("this is 1st method");
    }
    public void m2() {
        System.out.println("this is 2nd method");
    }
}

public class Example2 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {

        String className = "com.tekgrads.B"; // Creating a class name
        loadClass(className); // Loading the class and invoking methods
    }

    private static void loadClass(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {

        Class c1 = Class.forName(className); // Calling the class

        Method[] methods = c1.getDeclaredMethods(); // Getting declared methods

        Object obj = c1.newInstance(); // Creating an instance

        for (Method m : methods) {
            System.out.println("Method name is " + m.getName());
            m.invoke(obj); // Invoking method on object
        }
    }
}
```

---








					# ISLANDOBJECTS

---

A group of objects that reference each other but are no longer reachable from the rest of the application.

Even though these objects are interconnected and still reference each other,
they are considered unreachable from any active part of the program — meaning no active thread or variable can access them.

These "islands" become eligible for garbage collection because they are logically unreachable, even if internally connected on the heap memory.

---

## Example Program

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


        c1=c2=c3=null;

        System.out.println("The Island object process is completed");
    }
}
```

---

### Output

```
The Island object process is completed
```



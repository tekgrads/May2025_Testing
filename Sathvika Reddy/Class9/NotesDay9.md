# Java: Packages and Access Modifiers:

---

##  What is a Package in Java?

A **package** in Java is a namespace that organizes a set of related classes and interfaces. Think of it like a folder in your file system that helps you group logically related Java files together. Packages help **avoid name conflicts**, enable **modular development**, and make it easier to maintain code. Java provides **built-in packages** (like `java.util`, `java.io`) and also allows you to create your **own custom packages** using the `package` keyword at the top of the Java file. When you use packages, the file location should match the package structure (e.g., `com.tekgrads.Main1` should be in `com/tekgrads/Main1.java`).

---

##  Access Modifiers in Java

**Access modifiers** are keywords used to define the **visibility/scope of classes, methods, and variables**. They control which parts of your code can access other parts.

- `public`: The member is accessible **from any other class** in any package.
- `protected`: The member is accessible **within the same package** and by subclasses in other packages.
- `default` (no modifier): The member is accessible **only within the same package**.
- `private`: The member is accessible **only within the same class** where it is declared.

Access modifiers help in **encapsulation** by restricting or exposing functionality and data according to the intended design.

---

# Java Package Program Examples

---

##  com.tekgrads Package

```java
package com.tekgrads;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside tekgrads");
    }
}
````

---

##  com.rst Package

```java
package com.rst;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside rst");
    }
}
```

---

##  com Package

```java
package com;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside main method");
    }
}
```

---

##  com.tekgrads Package (Repeated)

```java
package com.tekgrads;

class Main1 {
    public static void main(String[] args) {
        System.out.println("inside tekgrads");
    }
}
```



# Java: Packages, Access Specifiers, and File Structures

## 📁 Keeping `.java` and `.class` Files in Different Folders

You can compile Java files and output the `.class` files into a different directory using:

```bash
javac -d bin src/com/example/MyClass.java
```

- `src` folder holds your `.java` files.
- `bin` is where `.class` files will be stored.
- This keeps your source and compiled files separated.

---

## 📦 Packages in Java

A **package** is a namespace that organizes classes and interfaces.

### Declaring a Package
```java
package com.example;
public class MyClass {
    // ...
}
```

### Compiling a Class with a Package
```bash
javac -d bin src/com/example/MyClass.java
```

---

## 🗂️ Packages in Multiple Folder Structure

Java uses a folder hierarchy to represent packages:

Example:
```text
src/com/example/util/MyClass.java
```

```java
package com.example.util;
public class MyClass {
    // ...
}
```

To compile:
```bash
javac -d bin src/com/example/util/MyClass.java
```

Compiled file:
```
bin/com/example/util/MyClass.class
```

---

## 🔐 Access Specifiers in Java

| Access Modifier | Class | Package | Subclass (Same Pkg) | Subclass (Diff Pkg) | Other |
|------------------|--------|----------|------------------------|-------------------------|--------|
| `private`        | ✅     | ❌       | ❌                     | ❌                      | ❌     |
| *(default)*      | ✅     | ✅       | ✅                     | ❌                      | ❌     |
| `protected`      | ✅     | ✅       | ✅                     | ✅                      | ❌     |
| `public`         | ✅     | ✅       | ✅                     | ✅                      | ✅     |

---

## ⚙️ Default Access (No Modifier)

If no access specifier is provided, the member/class has **default/package-private** access.

```java
class MyClass {
    int value;           // default access
    void display() {}    // default method
}
```

Accessible only within the same package.

---

## 📥 Accessing and Inheriting Access Specifiers

- `public`: Accessible and inheritable from anywhere.
- `protected`: Accessible within the same package or via subclass (even in different packages).
- *(default)*: Accessible only within the same package; not accessible or inheritable outside.
- `private`: Not accessible outside its own class; not inheritable.

---

## ✅ Summary

- Use `javac -d` to separate `.class` and `.java` files.
- Use proper folder structure to match package declarations.
- Choose access modifiers wisely based on visibility needs.
- Default (no modifier) = package-private access.

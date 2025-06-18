
# 📘 Java - Class 9 Notes  

---

## 📂 JAVA PACKAGES - Overview

### ❓ What is a Package?

* A **package** is a mechanism to encapsulate a group of related classes and interfaces.
* It behaves like a **directory/folder** and helps in managing large codebases efficiently.

---

### 🎯 Why Use Packages?

* Organize code systematically.
* Prevent class name conflicts.
* Enable proper access control via access modifiers.
* Simplify project builds and deployment.

---

## 🧱 How to Compile Java Files to a Target Directory

When you want to place `.class` files into a different directory than `.java` files:

### ✅ Example 1: Direct compilation into a custom folder

```bash
javac -d ../bin MainProgram.java
```

Explanation:

* `-d` is used to define where `.class` files are placed.
* `../bin` is the destination folder for compiled files.

---

### ✅ Example 2: Package Structure Compilation

Assume you have classes in `org/devteam`, use:

```bash
javac -d ../bin org/devteam/*.java
```

It creates this structure:

```
../bin/
└── org/
    └── devteam/
        └── YourClass.class
```

---

## ▶️ Executing a Class from Custom Folder

To run compiled class files:

```bash
java -cp ../bin org.devteam.YourClass
```

* `-cp` or `-classpath` tells JVM where to find the `.class` files.
* Use full name including the package path.

---

## 🧩 Setting Permanent CLASSPATH (Windows)

To avoid setting `-cp` each time:

1. Open **This PC > Properties**
2. Click **Advanced system settings > Environment Variables**
3. Create new system variable:

   * Name: `CLASSPATH`
   * Value: `C:\Users\YourName\bin`
4. Click OK and restart CMD.

---

## 🔐 ACCESS MODIFIERS in Java

They define **visibility scope** of classes, methods, and variables.

| Modifier    | Same Class | Same Package | Subclass (Other Pkg)     | Other Classes |
| ----------- | ---------- | ------------ | ------------------------ | ------------- |
| `private`   | ✅          | ❌            | ❌                        | ❌             |
| *(default)* | ✅          | ✅            | ❌                        | ❌             |
| `protected` | ✅          | ✅            | ✅ (only via inheritance) | ❌             |
| `public`    | ✅          | ✅            | ✅                        | ✅             |

---

### 📖 Modifier Explanation:

#### 🔸 private

* Member is accessible **only inside** its own class.

#### 🔸 default (no keyword)

* Visible to classes **within the same package**.
* Cannot be accessed from outside packages.

#### 🔸 protected

* Accessible within **same package** and from **subclasses in other packages** (only if inherited).

#### 🔸 public

* **Accessible globally** — from any class or package.

---

## 💻 Example - Custom Package and Modifier Use

### 📄 File: `org/devteam/Employee.java`

```java
package org.devteam;

public class Employee {
    public void showInfo() {
        System.out.println("Employee class in org.devteam package");
    }
}
```

### 📄 File: `LaunchApp.java` (outside package)

```java
import org.devteam.Employee;

public class LaunchApp {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.showInfo(); // Accessible because it's public
    }
}
```

---

## 🧳 Real-Time Git Format: Nested Folder Structure

Example for e-commerce project:

```
amazon/
├── customer/
│   └── Profile.java
├── cart/
│   └── Cart.java
└── orders/
    └── OrderHistory.java

flipkart/
├── users/
├── products/
└── transactions/
```

* Use `javac -d bin flipkart/users/*.java` to compile.
* Run: `java -cp bin flipkart.users.UserMain`

---

## ✅ Summary Table

| Topic                | Description                                             |
| -------------------- | ------------------------------------------------------- |
| Packages             | Structure to organize classes logically                 |
| `javac -d`           | Compile to specific folder preserving package structure |
| `java -cp`           | Run class using custom classpath                        |
| Environment Variable | Set permanent CLASSPATH for convenience                 |
| Access Specifiers    | Define who can access what (visibility)                 |

---

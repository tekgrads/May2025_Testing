
# 📦 Java Day 9 – Packages & Access Modifiers 🧩

## 1. What Are Packages in Java?
A **package** is a namespace that organizes a set of related classes and interfaces into a single unit.

### 🎯 Why Use Packages?
- Prevent naming conflicts  
- Provide access control  
- Make code modular and maintainable  
- Help with deployment and organization  

---

## ⚙️ 2. Compiling Java Files into Specific Folders

To compile `.java` files and store `.class` files in a separate directory:

```bash
javac -d ../classes YourClass.java
```

Folder structure:
```
../classes/
└── YourClass.class
```

If using packages:

```bash
javac -d ../classes com/tekgrads/*.java
```

Folder structure:
```
../classes/
└── com/
    └── tekgrads/
        └── YourClass.class
```

---

## ▶️ 3. Running Java Programs from Custom Directories

Use the `-cp` (classpath) option to run compiled `.class` files:

```bash
java -cp ../classes pack.YourClass
```

Replace `pack.YourClass` with your fully qualified class name.

---

## 💡 4. Setting Permanent Classpath (Windows)

To avoid typing `-cp` every time:

1. Go to **This PC > Properties**
2. Click **Advanced system settings**
3. Under **Environment Variables**, click **New**
4. Add:
    - Variable Name: `CLASSPATH`
    - Variable Value: `C:\your\folder\path`
5. Restart terminal

---

## 🔐 5. Access Modifiers in Java

Java has **four access modifiers** that define visibility levels:

| Access Specifier | Usage | Inheritance |
|------------------|-------|-------------|
| `private`        | Within the same class only | ❌ Not inheritable |
| _default_        | Within the same package    | ✅ Inheritable within the package |
| `public`         | Anywhere                   | ✅ Inheritable everywhere |
| `protected`      | Same package, subclasses in other packages | ✅ Inheritable to subclasses only |

### 📝 Detailed Explanation
- **private**: Accessible only within the same class. Not inherited.
- **default (no keyword)**: Accessible only within the same package.
- **protected**: Accessible in the same package and via inheritance in other packages.
- **public**: Fully accessible everywhere.

---

## 📁 6. Practical Examples with Packages

### 📄 File: `com/tekgrads/Manager.java`
```java
package com.tekgrads;
public class Manager {
    public void display() {
        System.out.println("Manager class in com.tekgrads package");
    }
}
```

### 📄 File: `TestMain.java` (outside package)
```java
import com.tekgrads.Manager;

public class TestMain {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.display(); // Works because display() is public
    }
}
```

---

## 📂 7. Nested Folder Structure (Git Style)

Example for an e-commerce project:

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

### 🔧 Compile:
```bash
javac -d bin flipkart/users/*.java
```

### 🔍 Run:
```bash
java -cp bin flipkart.users.UserMain
```

---

## 🧪 8. Access Modifiers in Practice

### 📌 Private Access
```java
class TestPrivate {
    private int j = 20;
}

class PrivateAccess {
    public static void main(String[] args) {
        TestPrivate t = new TestPrivate();
        // System.out.println(t.j); // ❌ Error
    }
}
```

✅ Fix: Use getter methods inside the class.

---

### 🌐 Public Access
```java
public class TestPublic {
    public void print() {
        System.out.println("Public method");
    }
}
```

✅ Can be used across packages.

---

### 🔒 Protected Access

#### File: `main1/SuperClass.java`
```java
package main1;
public class SuperClass {
    protected void display() {
        System.out.println("Protected method");
    }
}
```

#### File: `sub1/SubClass.java`
```java
package sub1;
import main1.SuperClass;

public class SubClass extends SuperClass {
    public void callDisplay() {
        display(); // ✅ Allowed via inheritance
    }
}
```

❌ Cannot call directly via object in different package.

---

### 🏠 Default (Package-Private)
```java
// In package main1
class DefaultClass {
    void showMessage() {
        System.out.println("Default method");
    }
}
```

❌ Cannot be accessed from another package.

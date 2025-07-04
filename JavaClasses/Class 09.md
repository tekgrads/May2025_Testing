# 📦 Java - Class 9 Notes (15/09/2025)

---

## 📁 PACKAGES in Java

### ❓ What are Packages?

- A **package** is a namespace that organizes a set of related classes and interfaces.
- Think of it like a **folder** for your Java classes — it helps keep your code **modular and organized**.

---

### 🎯 Purpose of Packages

- Group related `.java` or `.class` files together.
- Avoid name conflicts (e.g., two classes with the same name in different packages).
- Control access using **access specifiers**.
- Make it easier to **maintain and deploy** applications.

---

## 🛠️ Compiling Java Files into a Specific Folder

To store the `.class` files (compiled bytecode) in a **separate folder** from your `.java` files:

### ✅ Example 1: Compile into `../classes` folder

```bash
javac -d ../classes m1.java
```

Explanation:
- `-d` tells the compiler where to place the generated `.class` files.
- `../classes` is the target directory.
- `m1.java` is your source file.

---

### ✅ Example 2: Compile using a package structure

If your file is inside a package like `com.tekgrads`, compile using:

```bash
javac -d ../classes com/tekgrads/*.java
```

This will create a folder structure like:

```
../classes/
└── com/
    └── tekgrads/
        └── YourClass.class
```

---

## ⚙️ Running Class Files from a Different Directory

To run a `.class` file from a custom directory:

```bash
java -cp ../classes pack.YourClass
```

- `-cp` specifies the **classpath**, i.e., where the JVM should look for the `.class` file.
- Use the fully qualified name with package: `pack.YourClass`.

---

## 💡 Setting Classpath Permanently

To avoid giving the classpath every time:

1. **Right-click** on **This PC > Properties**
2. Go to **Advanced system settings**
3. Click on **Environment Variables**
4. Create a **new variable**:
   - Name: `CLASSPATH`
   - Value: `<your-folder-path>` (e.g., `C:\Users\YourName\classes`)
5. Click **OK** and restart the terminal.

This ensures Java knows where to look for `.class` files.

---

## 🔐 ACCESS SPECIFIERS in Java

Access specifiers define **who can access** classes, methods, and variables. Java provides **four types**:

| Specifier  | Accessible Within Same Class | Same Package | Subclass (Same/Diff Pkg) | Any Class Anywhere |
|------------|-------------------------------|--------------|---------------------------|---------------------|
| `private`  | ✅ Yes                         | ❌ No         | ❌ No                     | ❌ No               |
| `default`  | ✅ Yes                         | ✅ Yes        | ❌ No (outside package)   | ❌ No               |
| `protected`| ✅ Yes                         | ✅ Yes        | ✅ Yes (if inherited)     | ❌ No (direct use)  |
| `public`   | ✅ Yes                         | ✅ Yes        | ✅ Yes                    | ✅ Yes              |

---

### 🔍 Detailed Explanation:

#### 1. `private`

- Members declared as `private` are **accessible only within the same class**.
- Cannot be inherited or accessed by any other class, even subclasses.

#### 2. `default` (no keyword)

- If no access modifier is specified, it's `default`.
- Accessible only within the **same package**.
- Not accessible outside the package (even for subclasses).

#### 3. `protected`

- Accessible within the **same package**.
- Also accessible in **subclasses outside the package**, but **only via inheritance**.
- Cannot be accessed directly outside the subclass.

#### 4. `public`

- **Fully accessible** from **any class** in **any package**.
- Suitable for APIs and utility methods that need global access.

---

## 👩‍💻 Example: Package and Access Modifier Use Case

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

## ✅ Summary

| Concept             | Explanation |
|---------------------|-------------|
| Packages            | Organize related classes, avoid naming conflicts |
| `javac -d`          | Compile Java files and store `.class` files in custom directories |
| `java -cp`          | Run Java classes by specifying custom classpath |
| Environment Variable| CLASSPATH can be set permanently to avoid repeating `-cp` |
| Access Specifiers   | Control visibility of class members (private, default, protected, public) |

---

Let me know if you'd like the same in `.pdf` or `.md` format for download.

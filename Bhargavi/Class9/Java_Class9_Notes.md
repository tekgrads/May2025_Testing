# 📘 Java Notes - Class 9(15/06/2025)

## 📦 Java Packages
- A **package** is a folder-like structure that groups related classes.
- Helps organize code and avoid naming conflicts.

## 🎯 Why Use Packages?
- Code organization  
- Prevent class name collisions  
- Access control  
- Easy deployment

## 🛠 Compile & Run with Packages
### Compile to folder:
```bash
javac -d bin src/com/example/Test.java
```

### Run from folder:
```bash
java -cp bin com.example.Test
```

## ⚙️ Set CLASSPATH Permanently (Windows)
- Add a system variable:  
  - Name: `CLASSPATH`  
  - Value: path to `bin` folder

---

## 🔐 Access Modifiers

| Modifier   | Same Class | Same Package | Subclass (Other Pkg) | Other Classes |
|------------|------------|--------------|-----------------------|----------------|
| `private`  | ✅         | ❌           | ❌                    | ❌             |
| default    | ✅         | ✅           | ❌                    | ❌             |
| `protected`| ✅         | ✅           | ✅                    | ❌             |
| `public`   | ✅         | ✅           | ✅                    | ✅             |

---

## 🧪 Quick Code Example

### `package + public` class
```java
package com.office;

public class Employee {
    public void show() {
        System.out.println("From Employee class");
    }
}
```

### Access in another file
```java
import com.office.Employee;

public class Main {
    public static void main(String[] args) {
        new Employee().show();
    }
}
```

---

## 🐾 Fun Analogy
- **Package** = Folder  
- **public** = Everyone allowed  
- **private** = Just me  
- **protected** = Family only  
- **default** = Same neighborhood

---

✅ **Done: Class 9 – Java Packages & Access Modifiers**

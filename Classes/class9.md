## 🔹 What is a Package?

A **package** in Java is a way to **group related classes and interfaces** together.

### ✅ Why use packages?
- Keeps code **organized** and clean
- Helps **reuse code**
- Prevents **naming conflicts**
- Supports **modularity** and **encapsulation**

---

## 📂 Types of Packages

| Type            | Description                                      | Examples                      |
|-----------------|--------------------------------------------------|-------------------------------|
| Built-in        | Comes with Java                                  | `java.util`, `java.io`, etc. |
| User-defined    | Created by you to organize your own classes      | e.g., `mypack`, `bankapp.*`  |

---

## 🛠 Creating and Using a Package

### ✅ Step 1: Create a package and class

**File: `mypack/MyClass.java`**

```java
package mypack;

public class MyClass {
    public void greet() {
        System.out.println("Hello from MyClass");
    }
}
✅ Step 2: Use the package in another file
File: Main.java

java
Copy
Edit
import mypack.MyClass;

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.greet();
    }
}
⚙️ Compiling with Packages
Use the following command to compile while maintaining package structure:

bash
Copy
Edit
javac -d . MyClass.java
This creates folders according to the package name (mypack in this case).

🔐 Access Specifiers in Java
Access specifiers control where your variables, methods, and classes can be accessed.

Modifier	Same Class	Same Package	Subclass	Other Packages
public	✅	✅	✅	✅
protected	✅	✅	✅	❌
(default)	✅	✅	❌	❌
private	✅	❌	❌	❌

🧪 Access Specifier Example
File: mypack/Animal.java
java
Copy
Edit
package mypack;

public class Animal {
    public String name = "Lion";
    protected int age = 3;
    String color = "Golden";      // default
    private double weight = 190.5;

    public void showInfo() {
        System.out.println(name + ", " + age + ", " + color + ", " + weight);
    }
}
File: otherpackage/TestAnimal.java
java
Copy
Edit
package otherpackage;
import mypack.Animal;

public class TestAnimal {
    public static void main(String[] args) {
        Animal a = new Animal();
        System.out.println(a.name);      // ✅ public - accessible
        // System.out.println(a.age);    // ❌ protected - not accessible here
        // System.out.println(a.color);  // ❌ default - not accessible outside package
        // System.out.println(a.weight); // ❌ private - never accessible outside class
    }
}
🗂 Folder Structure
css
Copy
Edit
project/
├── mypack/
│   └── Animal.java
├── otherpackage/
│   └── TestAnimal.java
└── Main.java
📌 Summary
Packages help organize code and avoid name clashes.

Access specifiers control where members of a class can be used.

Use javac -d . filename.java to compile Java files into their package directories.

Follow best practices for modular and secure code.

css
Copy
Edit

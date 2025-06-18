Day 9

📦 Java Class Notes – Packages & Access Modifiers
🧩 1. What Are Packages in Java?
A package is a namespace that organizes a set of related classes and interfaces into a single unit.

🎯 Why Use Packages?
Prevent naming conflicts
Provide access control
Make code modular and maintainable
Help with deployment and organization
⚙️ 2. Compiling Java Files into Specific Folders
To compile .java files and store .class files in a separate directory:

🔧 Example:
javac -d ../classes YourClass.java
This will create a folder structure like:

../classes/
└── YourClass.class
If using packages:
javac -d ../classes com/tekgrads/*.java
Folder structure:
../classes/
└── com/
    └── tekgrads/
        └── YourClass.class
▶️ 3. Running Java Programs from Custom Directories
Use the -cp (classpath) option to run compiled .class files:

🔧 Example:
java -cp ../classes pack.YourClass
Replace pack.YourClass with your fully qualified class name including package. 

💡 4. Setting Permanent Classpath (Windows)
To avoid typing -cp every time:

Go to This PC > Properties
Click Advanced system settings
Under Environment Variables , click New
Add:
Variable Name: CLASSPATH
Variable Value: C:\your\folder\path
Restart terminal after setting this up.

🔐 5. Access Modifiers in Java
Java has four access modifiers that define visibility levels:

# 📦 Accessing and Inheriting Access Modifiers in Packages

| Access Specifier | Usage                                                 | Inheritance                                                    |
| ---------------- | ----------------------------------------------------- | -------------------------------------------------------------- |
| `private`        | Within the **same class** only                        | ❌ Not inheritable                                              |
| *default*        | Within the **same package**                           | ✅ Inheritable within the package                               |
| `public`         | Anywhere                                              | ✅ Inheritable everywhere                                       |
| `protected`      | Within **same package**, subclasses in other packages | ✅ Inheritable to subclasses; use restricted to subclass itself |


📝 Detailed Explanation
private
Only accessible within the same class.
Not inherited by subclasses.
default (no keyword)
Accessible only within the same package.
Not visible outside the package.
protected
Accessible in:
Same package
Subclasses in other packages (only via inheritance)
public
Fully accessible everywhere — no restrictions.
📁 6. Practical Examples with Packages
📄 File: com/tekgrads/Manager.java
package com.tekgrads;
public class Manager {
    public void display() {
        System.out.println("Manager class in com.tekgrads package");
    }
}
📄 File: TestMain.java (outside package)

import com.tekgrads.Manager;
public class TestMain {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.display(); // Works because display() is public
    }
}
📂 7. Nested Folder Structure (Git Style)
Example for an e-commerce project:

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

🔧 Compile:

javac -d bin flipkart/users/*.java
🔍 Run:
java -cp bin flipkart.users.UserMain

🧪 8. Access Modifiers in Practice
📌 Private Access
Only accessible within the same class.
class TestPrivate {
    private int j = 20;
}

class PrivateAccess {
    public static void main(String[] args) {
        TestPrivate t = new TestPrivate();
        // ❌ System.out.println(t.j); // Error!
    }
}
✅ Fix: Use getter methods inside the class.

🌐 Public Access
Accessible anywhere.
public class TestPublic {
    public void print() {
        System.out.println("Public method");
    }
}
✅ Can be used across packages.

🔒 Protected Access
Available within same package and via inheritance in other packages.
package main1;
public class SuperClass {
    protected void display() {
        System.out.println("Protected method");
    }
}

package sub1;
import main1.SuperClass;

public class SubClass extends SuperClass {
    public void callDisplay() {
        display(); // ✅ Allowed via inheritance
    }
}
❌ Cannot call directly via object in different package.

🏠 Default (Package-Private)
Visible only within the same package.

// In package main1
class DefaultClass {
    void showMessage() {
        System.out.println("Default method");
    }
}
❌ Cannot be accessed from another package.



📦 Java Packages & Access Specifiers
📚 What are Packages?
Packages in Java are a way to group related classes and interfaces. They function like directories, helping organize code, prevent naming conflicts, and control class visibility.

✅ Key Features
Organization: Group related classes together for easier maintenance.

Namespace Management: Prevent class name collisions.

Access Control: Control visibility of classes/members using access modifiers.

Modularity: Promote reusable and modular code structures.

🗂️ Types of Packages
1. Built-in Packages
Java provides many standard packages like:

java.lang

java.util

java.io

java.sql

2. User-defined Packages
Created by developers to organize custom classes and interfaces.

🛠️ Using Packages
📄 Declaration
Use the package keyword at the top of the file:

package pack1;
📦 Importing
Use the import keyword to use classes from other packages:

import pack1.Test;
✨ Example: Basic Package
// File: Manager.java
package pack1;

class Manager {
    public static void main(String[] args) {
        System.out.println("Inside pack1 Manager...");
    }
}
🔐 Access Specifiers
Modifier	Class	Package	Subclass	World
private		✅	❌	❌		❌
(default)	✅	✅	❌		❌
protected	✅	✅	✅		❌
public		✅	✅	✅		✅
private: Accessible only within the same class.

default (no modifier): Accessible within the same package.

protected: Accessible in the same package and subclasses.

public: Accessible from everywhere.

🧪 Example: Access Specifiers in Use
File: Test.java (in pack1)
package pack1;

public class Test {
    protected static int i = 10;
    protected int j = 20;

    static void printIValue() {
        System.out.println("I value is " + i);
    }

    void printJValue() {
        System.out.println("J value is " + this.j);
    }
}
File: Manager_Access_Levels.java (in pack1)
package pack1;

class Manager_Access_Levels {
    public static void main(String[] args) {
        Test t = new Test();
        Test.printIValue();
        t.printJValue();
    }
}
File: Test2.java (in pack1)
package pack1;

public class Test2 {
    protected static int i = 100;
    protected int j = 200;

    static void printIValueInTest2() {
        System.out.println("I value in Test2 is " + i);
    }

    void printJValueInTest2() {
        System.out.println("J value in Test2 is " + this.j);
    }
}
File: Manager_Access_Levels_T2.java (in pack1)
package pack1;

class Manager_Access_Levels_T2 {
    public static void main(String[] args) {
        Test2 t2 = new Test2();
        Test2.printIValueInTest2();
        t2.printJValueInTest2();
    }
}
👨‍👩‍👧 Inheritance Across Packages
File: Manager_Access_Levels.java (in pack2)
package pack2;

import pack1.Test2;

class Manager_Access_Levels extends Test2 {
    public static void main(String[] args) {
        Test2 t2 = new Test2();
        Test2.printIValueInTest2();
        t2.printJValueInTest2();

        // Access protected members through inheritance
        System.out.println("I value outside pack1 in pack2 is " + i);
        System.out.println("J value outside pack1 in pack2 is " + j);
    }
}

✅ Summary
Packages in Java enhance organization, modularity, and access control.

Java supports built-in and user-defined packages.

Use access specifiers (private, default, protected, public) to control visibility.

Protected members can be accessed in subclasses even if they’re in different packages.

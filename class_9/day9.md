# Java Packages and Access Specifiers

## 1. What is a Package in Java?

A **package** in Java is a namespace that organizes classes and interfaces. Conceptually, it's like a folder in a file directory.

Packages help:
- Avoid name conflicts
- Control access with access specifiers
- Make code modular and maintainable

**Syntax to declare a package:**

package mypackage;
Syntax to import a package:

import mypackage.ClassName;
import mypackage.*; // imports all classes in the package
2. Types of Packages
Built-in packages: Provided by Java (e.g., java.util, java.io)

User-defined packages: Created by developers

Example of Using a Built-in Package

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name);
    }
}
Example of Creating and Using a User-Defined Package

File: mypackage/Message.java
package mypackage;

public class Message {
    public void display() {
        System.out.println("Hello from mypackage!");
    }
}
File: Main.java

import mypackage.Message;

public class Main {
    public static void main(String[] args) {
        Message m = new Message();
        m.display();
    }
}
To compile: javac mypackage/Message.java Main.java
To run: java Main

3. Access Specifiers in Packages
Modifier	Class	Package	Subclass	World
public	Yes	Yes	Yes	Yes
protected	Yes	Yes	Yes	No
(default)	Yes	Yes	No	No
private	Yes	No	No	No

a) public Access
Accessible everywhere.

package mypackage;

public class A {
    public void msg() {
        System.out.println("Hello from A");
    }
}

import mypackage.A;

public class Test {
    public static void main(String[] args) {
        A obj = new A();
        obj.msg();  // Accessible
    }
}
b) default Access (No modifier)
Accessible only within the same package.


package mypackage;

class B {
    void msg() {
        System.out.println("Hello from B");
    }
}

import mypackage.B; // Compile-time error

public class Test {
    public static void main(String[] args) {
        B obj = new B();  // Not accessible outside package
        obj.msg();
    }
}
c) protected Access
Accessible within the same package and by subclasses in other packages.


package mypackage;

public class C {
    protected void msg() {
        System.out.println("Hello from C");
    }
}

package anotherpackage;

import mypackage.C;

class D extends C {
    void show() {
        msg();  // Accessible through inheritance
    }
}

public class Test {
    public static void main(String[] args) {
        D obj = new D();
        obj.show();
    }
}
d) private Access
Accessible only within the same class.

package mypackage;

public class E {
    private void msg() {
        System.out.println("Hello from E");
    }

    public void accessMsg() {
        msg();  // Allowed here
    }
}

public class Test {
    public static void main(String[] args) {
        E obj = new E();
        // obj.msg();  // Compile-time error
        obj.accessMsg();  // Indirect access
    }
}

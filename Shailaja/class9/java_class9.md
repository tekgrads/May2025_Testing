 Java Packages & Access Modifiers – Interview Notes
✅ What Are Packages in Java?
A package is a namespace that organizes related classes and interfaces.

🎯 Benefits:
📁 Organization: Groups related files.

🛡️ Access Control: Works with access modifiers.

🔄 Reusability: Use classes across applications.

🚫 Naming Conflicts: Avoids duplication of class names.

📦 Modularization: Helps maintain large applications.

🛠️ Types of Packages
Type	Example	Description
Built-in	java.util.*	Provided by JDK
User-defined	package mypkg;	Created by developers

📌 Declaring and Using Packages
Example:
java
Copy
Edit
package mypackage;

public class MyClass {
    public void show() {
        System.out.println("Hello from MyClass");
    }
}
Compile and Run:
bash
Copy
Edit
javac -d . MyClass.java
java mypackage.MyClass
📂 Nested Packages
Example:

css
Copy
Edit
com/
 └── company/
      └── Main.java (package com.company;)
🔐 Java Access Modifiers
Access modifiers control visibility of classes, methods, and variables.

Modifier	Package Access	Subclass (diff pkg)	World
private	❌	❌	❌
default	✅	❌	❌
protected	✅	✅	❌
public	✅	✅	✅

✅ Access Modifier Details
🔒 private
Accessible only inside the class.

java
Copy
Edit
private int age;
🌐 public
Accessible from anywhere.

java
Copy
Edit
public int age;
🔐 protected
Accessible within package + in subclasses (even outside package).

java
Copy
Edit
protected int age;
📦 default (no modifier)
Accessible only in the same package.

✅ Where Can You Use Access Modifiers?
Element	Allowed Modifiers
Class	public, default
Method	private, default, protected, public
Variable	private, default, protected, public
Constructor	All four

🧪 Common Access Modifier Scenarios
❌ private Fields Access Error
java
Copy
Edit
class Test {
    private int a = 10;
}
public class Demo {
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.a);  // ❌ Compile Error
    }
}
✅ public Access
java
Copy
Edit
public class Test {
    public int a = 10;
}
✅ protected Inheritance Across Packages
java
Copy
Edit
// mainpkg/Super.java
package mainpkg;
public class Super {
    protected void show() {
        System.out.println("Protected method");
    }
}

// subpkg/Sub.java
package subpkg;
import mainpkg.Super;
public class Sub extends Super {
    public void callShow() {
        show();
    }
}
❓ Top 10 Java Interview Questions on Packages & Access Modifiers
1. What is a package in Java?
Answer:
A package is a namespace that organizes related Java classes and interfaces. It avoids class name conflicts and helps modularize code.

2. How do you compile and run a class inside a package?
Answer:

bash
Copy
Edit
javac -d . MyClass.java
java packagename.MyClass
3. What is the difference between public, protected, private, and default access?
Modifier	Same Class	Same Package	Subclass (diff pkg)	Everywhere
private      	✅	         ❌	              ❌	             ❌
default	        ✅	         ✅	              ❌	             ❌
protected	    ✅	         ✅               ✅               	❌
public	        ✅         	✅	              ✅             	✅

4. Can we declare a top-level class as private in Java?
Answer:
❌ No. Top-level classes can only be public or default. private is not allowed.

5. What is the use of access modifiers in packages?
Answer:
They define scope of visibility:

Control class member access across packages, classes, and subclasses.

Promote encapsulation and modularity.

6. What’s the default access modifier for a class in Java?
Answer:
If no modifier is specified, a class has package-private (default) access, i.e., accessible only within its own package.

7. How is protected different from default access?
Answer:

Both allow access in the same package.

protected also allows access in subclasses across packages, default does not.

8. Can we access protected members outside the package without inheritance?
Answer:
❌ No. You must inherit the class in another package to access protected members.

9. Why are packages useful in Java?
Answer:

Prevent class name conflicts

Support logical grouping of classes

Improve readability and reusability

Facilitate access control

10. Can we have multiple public classes in one Java file?
Answer:
❌ No. A .java file can have only one public class, and its name must match the filename.


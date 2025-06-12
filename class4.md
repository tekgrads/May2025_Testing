☕ Java Notes: Variables, Operators, Memory & More
📦 Packages
A package is a group of related classes.
Think of it like a folder that helps you organize your code.
🔁 Variables in Java
🧠 Types of Variables:
Type	Where it's declared	Example
Global	Inside a class, outside methods	int i; (at class level)
Local	Inside a method	int i = 0;
⚠️ Local variables must be initialized before use.

➕ Increment Operators
Operator	Meaning	Example
i++	Post-increment (use then add 1)	int j = i++;
++i	Pre-increment (add 1 then use)	int j = ++i;
📘 Example 1:
int i = 0;
int j = i++;   // j = 0, i becomes 1
int k = ++i;   // i becomes 2, k = 2
📘 Example 2 (Same variable):
java
Copy
Edit
int i = 0;
i = i++;       // i stays 0
System.out.println(i); // 0
++i;
System.out.println(i); // 1
🖥️ Java Setup in Visual Studio Code
✅ Steps:
Install VS Code

Open your Java folder

Install these Extensions:

Java Extension Pack

Code Runner

Prettier

Live Preview

Enable Mouse Wheel Zoom

Create a .java file and start coding!

🧩 Static Method Example
java
Copy
Edit
public class A {
    public static void main(String[] args) {
        System.out.println("Hello from A!");
        methodA();
    }

    public static void methodA() {
        System.out.println("Method A in class A");
    }
}
🧠 Java Memory: Stack vs Heap
Memory Part	Stores What
Stack	Method calls and local variables
Heap	Objects and instance (global) variables

🧵 Stack Memory Example
java
Copy
Edit
public class A {
    public static void main(String[] args) {
        int i = 0;
        methodA(i);
        System.out.println("i after methodA: " + i);  // i is still 0
    }

    public static void methodA(int i) {
        i = 100;  // This change is local to methodA
    }
}
i inside main() and i inside methodA() are two different copies. Stack memory keeps them separate.

🧮 Static Variable Shadowing
java
Copy
Edit
public class A {
    static int i = 10; // Global static variable

    public static void main(String[] args) {
        System.out.println("Global i: " + i);

        int i = 0; // Local variable shadows global i
        System.out.println("Local i: " + i);

        methodA(i);
    }

    public static void methodA(int i) {
        i = 100;
        System.out.println("Updated i in methodA: " + i);
    }
}
Local int i = 0; hides or shadows the global static i.

💥 StackOverflowError
Happens when you have infinite recursion (a method keeps calling itself forever).

java
Copy
Edit
public class A {
    public static void recurse() {
        recurse(); // keeps calling itself — no end
    }

    public static void main(String[] args) {
        recurse(); // causes StackOverflowError
    }
}
✅ Summary
Concept	Key Point
Package	Group of classes (like a folder)
Variable Types	Global (class level) vs Local (method level)
Increment Operators	i++ uses value then increments, ++i does the reverse
Memory (Stack/Heap)	Stack = temporary, Heap = objects/long-term
VS Code Setup	Install extensions, start coding in .java files
Static & Shadowing	Local variables can hide static/global ones
StackOverflowError	Happens due to endless recursio
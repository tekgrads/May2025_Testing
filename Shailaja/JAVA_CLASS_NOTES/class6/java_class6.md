1. Instance Initialization Blocks (IIBs)
What: Non-static blocks that run when an object is created.

When: Executed after super() call and before the constructor.

Why: To write common initialization logic shared across constructors.

🔑 Key Points:
Runs for each object creation.

Can have multiple blocks — executed in the order of declaration.

Compiler inserts IIB code into every constructor after super().

2. Constructors
🏗️ Default Constructor
Created by the compiler if no constructor is written.

Initializes instance variables to default values.

🔧 Parameterized Constructor
Constructor with parameters to initialize variables dynamically.

java
Copy
Edit
class Example {
   int x;
   Example() {
      x = 10;
   }
   Example(int value) {
      this.x = value;
   }
}
⚠️ Note: If any parameterized constructor is defined, the default constructor won't be created by the compiler.

3. this Keyword
📌 Purpose:
Refers to the current class object.

Commonly used to differentiate between instance variables and parameters.

java
Copy
Edit
class Demo {
   int a;
   Demo(int a) {
      this.a = a;
   }
}
🚫 Cannot be used in static context.

4. Static & Instance Initialization, SIBs vs IIBs
java
Copy
Edit
class Example {
   int x = 1;           // instance variable
   static int y = 2;    // static variable

   // Static block (SIB)
   static {
      y = 20;
      System.out.println("Static block executed");
   }

   // Instance block (IIB)
   {
      x = 10;
      System.out.println("Instance block executed");
   }

   Example() {
      System.out.println("Constructor called");
   }
}
🔍 Order of Execution:
Static blocks (only once at class load time)

Instance blocks (every object creation)

Constructor

5. Constructor Overloading
🧬 Definition:
Multiple constructors with different parameter lists in the same class.

java
Copy
Edit
class A {
   A() {
      System.out.println("Default");
   }
   A(int x) {
      System.out.println("Parameterized");
   }
}
💡 Use Case: Allows flexibility in object creation.

6. Constructor Chaining & Polymorphism
🎯 Constructor Chaining:
Using this() to call one constructor from another in the same class.

java
Copy
Edit
class B {
   B() {
      this(10);
      System.out.println("No-arg constructor");
   }
   B(int x) {
      System.out.println("Parameterized constructor");
   }
}
🔁 this() must be the first statement in the constructor.

🔟 Most Common Interview Questions
markdown
Copy
Edit
### Top 10 Interview Questions Based on These Concepts

1. **What is the difference between IIB (Instance Initialization Block) and Constructor?**
2. **When do static blocks (SIB) and instance blocks (IIB) execute in Java?**
3. **How does constructor overloading work in Java? Can you give a real-time example?**
4. **What happens if you define a parameterized constructor but not a default constructor?**
5. **What is the role of the `this` keyword in Java? When is it necessary to use it?**
6. **Can we use `this()` and `super()` together in a constructor?**
7. **What is the order of execution among static block, instance block, and constructor?**
8. **Why should we use constructor chaining? What are the benefits?**
9. **What is the difference between static and instance variables? How are they initialized?**
10. **How do multiple IIBs execute if present in a class? In what order?**
✅ Tips for Interviews:

Be clear on execution flow: SIB → IIB → Constructor.

Practice with multiple constructor examples.

Understand when the compiler adds default constructors and when it doesn’t.

Always remember: this() must be first in a constructor call chain.
✅ Top 10 Frequently Asked Questions with Answers
1. What is the difference between IIB (Instance Initialization Block) and Constructor?
Answer:

Feature	IIB	Constructor
Purpose	Initializes instance variables	Initializes object (instance)
Execution	Runs before constructor	Runs after IIB
Frequency	Runs on every object creation	Called every time object is created
Use Case	Common logic shared by all constructors	Object-specific initialization

java
Copy
Edit
{
   // IIB
   System.out.println("IIB");
}
2. When do static blocks (SIB) and instance blocks (IIB) execute in Java?
Answer:

Static Block (SIB): Executes once when the class is loaded into memory (before main() or object creation).

Instance Block (IIB): Executes every time an object is created, just before the constructor.

java
Copy
Edit
static { System.out.println("SIB"); }
{ System.out.println("IIB"); }
Order of Execution:

SIB (once)

IIB (every object)

Constructor (every object)

3. How does constructor overloading work in Java? Can you give a real-time example?
Answer:

Constructor Overloading: Defining multiple constructors with different parameter lists in the same class.

java
Copy
Edit
class Student {
   Student() { System.out.println("Default"); }
   Student(String name) { System.out.println("Name: " + name); }
   Student(int id, String name) { System.out.println("ID: " + id + ", Name: " + name); }
}
✅ Use Case: Flexibility to create objects with or without initial values.

4. What happens if you define a parameterized constructor but not a default constructor?
Answer:

If a parameterized constructor is defined, Java will NOT provide a default constructor automatically. You must define it manually if needed.

java
Copy
Edit
class A {
   A(int x) {} // Only parameterized constructor
   // A() {} → Must be added if you want default
}
❌ Trying to create an object with new A() will cause a compile-time error if default constructor is missing.

5. What is the role of the this keyword in Java? When is it necessary to use it?
Answer:

this refers to the current object of the class.

Used to differentiate between instance variables and parameters when names are the same.

java
Copy
Edit
class Test {
   int a;
   Test(int a) {
      this.a = a; // 'this.a' refers to instance variable
   }
}
Also used to call:

Another constructor: this()

Current object: this.variable

6. Can we use this() and super() together in a constructor?
Answer:

🚫 No, both this() and super() must be the first line in a constructor. Therefore, they cannot be used together directly.

If needed, constructor chaining should be carefully structured to avoid calling both in the same place.

7. What is the order of execution among static block, instance block, and constructor?
Answer:

Execution Order:

Static block (SIB) → Executes once when the class is loaded.

Instance block (IIB) → Executes every time an object is created.

Constructor → Executes after IIB during object creation.

java
Copy
Edit
static { System.out.println("SIB"); }
{ System.out.println("IIB"); }
Constructor() { System.out.println("Constructor"); }
8. Why should we use constructor chaining? What are the benefits?
Answer:

Constructor chaining is used to:

Avoid code duplication

Simplify object creation logic

Allow reuse of logic from one constructor in another

java
Copy
Edit
class A {
   A() {
      this(10); // calls parameterized constructor
      System.out.println("Default constructor");
   }
   A(int x) {
      System.out.println("Parameterized constructor: " + x);
   }
}
🧠 Helps manage complex initialization sequences.

9. What is the difference between static and instance variables? How are they initialized?
Answer:

Feature	Static Variable	Instance Variable
Belongs to	Class (shared among objects)	Each object
Memory Location	Method Area	Heap
Access	Via class name or object	Only via object
Initialization	When class loads (SIB)	When object is created (IIB)

10. How do multiple IIBs execute if present in a class? In what order?
Answer:

If there are multiple IIBs, they execute in the order they are declared in the class, before the constructor is executed.

java
Copy
Edit
{
   System.out.println("IIB 1");
}
{
   System.out.println("IIB 2");
}
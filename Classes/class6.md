🔹 1. Constructor
A constructor is a special method that runs when you create an object. It is used to initialize the object.

✅ Example:
java
Copy
Edit
class Person {
    String name;

    // Constructor
    Person(String name) {
        this.name = name;
    }

    void show() {
        System.out.println("Name: " + name);
    }
}
When you write Person p = new Person("John");, the constructor sets name to "John".

🔹 2. this Keyword
The this keyword refers to the current object. It is used when local variables (like method parameters) have the same names as instance variables.

✅ Example:
java
Copy
Edit
class Student {
    int id;

    Student(int id) {
        this.id = id;  // refers to the instance variable
    }
}
🔹 3. super Keyword
The super keyword refers to the parent class. It is used to call parent class constructors or methods.

✅ Example:
java
Copy
Edit
class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }
}

class Dog extends Animal {
    Dog() {
        super(); // calls Animal constructor
        System.out.println("Dog constructor called");
    }
}
🔹 4. IIB (Instance Initialization Block)
An Instance Initialization Block (IIB) is a block of code inside a class that runs before the constructor when an object is created.

✅ Example:
java
Copy
Edit
class Example {
    {
        System.out.println("IIB block executed");
    }

    Example() {
        System.out.println("Constructor executed");
    }
}
Output:

scss
Copy
Edit
IIB block executed
Constructor executed
🔹 5. Constructor Overloading
Constructor overloading means having more than one constructor in the same class with different parameter lists.

✅ Example:
java
Copy
Edit
class OverloadExample {
    int x;
    String y;

    OverloadExample() {
        x = 0;
        y = "Default";
    }

    OverloadExample(int x) {
        this.x = x;
        y = "Given";
    }

    OverloadExample(int x, String y) {
        this.x = x;
        this.y = y;
    }
}
You can create objects like:

java
Copy
Edit
new OverloadExample();
new OverloadExample(5);
new OverloadExample(10, "Hello");

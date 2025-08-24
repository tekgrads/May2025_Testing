

## Local and Global Variables in Java

In Java, variables are classified based on where they are declared. This helps manage scope and lifetime of the variables.

### Local Variables
- Defined within methods or blocks.
- Exist only while the method or block is executing.
- Must be initialized before use.

**Example:**
public void showMessage() {
    String message = "Hello!"; // Local variable
    System.out.println(message);
}


### Global Variables (Instance and Static Variables)
- Declared inside the class but outside methods.
- Instance variables are tied to objects, while static variables belong to the class.

**Example:**
public class User {
    String name; // Instance variable
    static int count = 0; // Static variable
}


## Increment and Decrement Operators

These operators adjust values by 1 and are commonly used in loops or counters.

### Pre-Increment and Pre-Decrement
The value is changed before it is used.


int x = 5;
int y = ++x; // x becomes 6, then y is assigned 6

### Post-Increment and Post-Decrement
The original value is used before it is changed.


int x = 5;
int y = x++; // y is assigned 5, then x becomes 6

These operators can simplify code but should be used carefully to maintain readability.

## Setting Up Java in Visual Studio Code

To begin Java development in VS Code, follow these steps:

1. **Install JDK**: Download the Java Development Kit from the official site and install it.
2. **Install VS Code**: Download and install Visual Studio Code from Microsoft's site.
3. **Install Java Extensions**:
   - Open VS Code and go to the Extensions view.
   - Install the "Java Extension Pack".
4. **Configure Environment Variables** (for Windows/macOS/Linux):
   - Set `JAVA_HOME` to the JDK path.
   - Add the `bin` folder to your system `PATH`.
5. **Create and Run Java Programs**:
   - Open a folder in VS Code.
   - Create a `.java` file.
   - Write a class with a `main` method.
   - Use the Run button or Terminal to compile and run:
     javac MyApp.java
     java MyApp
     
6. **Use Built-In Debugging Tools**: The Java debugger helps you step through your code.

## Stack Unwinding in Java

This is a behavior during exception handling. When an exception is thrown, Java goes backward through the call stack until it finds a block that can handle the exception.

**Example:**
public void methodA() {
    methodB();
}

public void methodB() {
    int x = 5 / 0; // Triggers exception
}


Here, if `methodB` causes an error and does not handle it, control goes back to `methodA`. This process of moving back is known as stack unwinding.

## Stack Overflow Error

This error happens when the program runs out of stack space. It is usually due to excessive or infinite recursive method calls.

**Example:**
public void callMe() {
    callMe(); // No stopping condition
}


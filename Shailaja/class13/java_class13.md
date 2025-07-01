Exception Handling in Java
What is Exception Handling?
Exception handling in Java is a mechanism that allows the program to detect and handle runtime errors to maintain the normal flow of execution.

Core Concepts
Keyword	Description
try	Encloses code that may throw an exception
catch	Handles exceptions of a specific type
finally	Executes after try-catch, whether exception occurs or not
throw	Used to explicitly throw an exception
throws	Declares exceptions that a method can throw

Exception Hierarchy
scss
Copy
Edit
Object
 └── Throwable
      ├── Exception (Checked & Unchecked)
      │     ├── IOException (Checked)
      │     └── RuntimeException (Unchecked)
      │           ├── ArithmeticException
      │           ├── NullPointerException
      │           └── ArrayIndexOutOfBoundsException
      └── Error (Unrecoverable)
Types of Exceptions
1. Checked Exceptions
Handled at compile-time.
Examples: IOException, SQLException, InterruptedException

2. Unchecked Exceptions (Runtime Exceptions)
Occur at runtime, not checked by the compiler.
Examples: ArithmeticException, NullPointerException, NumberFormatException, ArrayIndexOutOfBoundsException

3. Errors
Severe problems that are usually not handled.
Examples: OutOfMemoryError, StackOverflowError

Common Patterns
Try-Catch
java
Copy
Edit
try {
    int a = 1 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
}
Try-Catch-Finally
java
Copy
Edit
try {
    int a = 10 / 0;
} catch (Exception e) {
    System.out.println("Exception: " + e);
} finally {
    System.out.println("Cleanup code in finally block");
}
Multiple Catch Blocks
java
Copy
Edit
try {
    String s = null;
    System.out.println(s.length());
} catch (NullPointerException e) {
    System.out.println("Null pointer exception");
} catch (Exception e) {
    System.out.println("General exception");
}
Multi-Catch (Java 7+)
java
Copy
Edit
try {
    int num = Integer.parseInt("abc");
} catch (NumberFormatException | NullPointerException e) {
    System.out.println("Caught: " + e.getClass().getSimpleName());
}
Using throws
java
Copy
Edit
public void pause() throws InterruptedException {
    Thread.sleep(2000);
}
Using throw
java
Copy
Edit
public void checkAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Not eligible");
    }
}
Sample Output-Based Questions
Q: What happens when an exception is not caught?
A: The program will terminate and print a stack trace.

Q: Will finally block execute even after return?
A: Yes, the finally block will still execute.

Interview Questions and Answers
Q1: What is the difference between throw and throws?
A:

throw is used to explicitly throw an exception.

throws is used to declare the exception in method signature.

Q2: What is the difference between checked and unchecked exceptions?
A:

Checked exceptions are checked at compile-time and must be handled.

Unchecked exceptions are checked at runtime and can be ignored.

Q3: Can a method have multiple catch blocks?
A: Yes, each catch block handles a specific exception type.

Q4: What is the purpose of the finally block?
A: It is used to write cleanup code that must execute regardless of exception occurrence.

Q5: Can we catch multiple exceptions in one catch block?
A: Yes, using multi-catch syntax (catch (Exception1 | Exception2 e)).

Q6: Can we have a try block without a catch block?
A: Yes, but only if a finally block is present.

Q7: Can you handle exceptions in inheritance?
A: Yes. A subclass can override a method and declare the same or fewer exceptions.


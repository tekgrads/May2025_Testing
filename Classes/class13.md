📘 Exceptional Handling in Java
What is Exception Handling?
Exception handling in Java is a robust mechanism to manage runtime errors and maintain the normal flow of an application. It involves identifying and responding to unexpected events (exceptions) that occur during program execution.

🔑 Key Concepts of Exception Handling
I) Exception
An event that disrupts the normal flow of a program. In Java, exceptions are objects of classes that inherit from java.lang.Throwable.

II) try block
Encloses the code that might throw an exception.

III) catch block
Follows a try block and handles a specific type of exception thrown within the try block. Multiple catch blocks can be used to handle different exception types.

IV) finally block
An optional block that always executes, regardless of whether an exception occurred or was handled. It is typically used for cleanup operations like closing resources.

🧩 Keywords of Exception Handling
I) throw keyword
Used to explicitly throw an exception object. This can be a predefined or a custom (user-defined) exception.

II) throws keyword
Used in a method signature to declare that a method might throw one or more checked exceptions. This forces the caller to either handle or re-declare them.

🧪 Types of Exceptions
I) Checked Exceptions
Exceptions checked at compile-time. The compiler enforces handling or declaration of these exceptions (e.g., IOException, SQLException).

II) Unchecked Exceptions (Runtime Exceptions)
Exceptions that occur at runtime and are not checked at compile-time (e.g., NullPointerException, ArrayIndexOutOfBoundsException). These typically indicate programming errors.

⚠️ Errors
Serious, usually unrecoverable problems indicating system-level issues (e.g., OutOfMemoryError). Errors are also considered unchecked.

💻 Java Programs
Example 1: Try and Catch Block
class Main2 {
    public static void main(String[] args) {
        System.out.println("using try and 1 catch block");
        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            System.out.println("an exception is raised " + e.getMessage());
        }
        System.out.println("end of try catch");
    }
}
Output:

using try and 1 catch block
an exception is raised / by zero
end of try catch
Example 2: Null Pointer Exception
class Main4 {
    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println("String length: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
        System.out.println("program completed");
    }
}
Output:

Caught NullPointerException: Cannot invoke "String.length()" because "<local1>" is null
program completed
Example 3: Number Format Exception
public class Main5 {
    public static void main(String[] args) {
        String str1 = "hello";
        try {
            int number = Integer.parseInt(str1);
            System.out.println("Converted number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Number format exception is " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught General Exception: " + e.getMessage());
        }
        System.out.println("program completed");
    }
}
Output:

Number format exception is For input string: "hello"
program completed
Example 4: Array Index Out of Bound Exception
public class Main6 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        try {
            System.out.println("Array element: " + arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        System.out.println("program completed");
    }
}
Output:

Caught ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
program completed
Example 5: One Try and Multiple Catch Blocks
// One try and multiple catches
public class Main3 {
    public static void main(String[] args) {
        String str = null;
        int[] arr = new int[3];
        String str1 = "hello";

        try {
            // Null pointer exception
            System.out.println("String length: " + str.length());

            // Array index out of bounds exception
            System.out.println("Array element: " + arr[5]);

            // Number format exception
            int number = Integer.parseInt(str1);
            System.out.println("Converted number: " + number);

        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Number format exception is " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught General Exception: " + e.getMessage());
        }
        System.out.println("program completed");
    }
}
Output:

Caught NullPointerException: Cannot invoke "String.length()" because "<local1>" is null
program completed
Example 6: One Catch Handling Multiple Exceptions
public class Main7 {
    public static void main(String[] args) {

        try {
            System.out.println("try starts");
            int i = 1 / 0;
            String age = "hello";
            Integer num = Integer.parseInt(age);
            String str = null;
            int[] arr = new int[3];

            System.out.println("try end");

        } catch (ArithmeticException | NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an : " + e.getMessage());
            System.out.println("catch ends");
        }
        System.out.println("program stops");
    }
}
Output:

try starts
Caught an : / by zero
catch ends
program stops
Example 7: Try-Catch-Finally Block
class Main8 {
    public static void main(String[] args) {
        try {
            int a = 1 / 0;
            String b = null;
            int[] c = new int[3];

        } catch (Exception e) {
            System.out.println("Exception is: " + e.getMessage());
        } finally {
            System.out.println("this is a final block");
        }
        System.out.println("programs stops");
    }
}
Output:

Exception is: / by zero
this is a final block
programs stops
II) Unchecked Exceptions (Runtime Exceptions)
Exceptions that occur at runtime and are not checked at compile-time (e.g., NullPointerException, ArrayIndexOutOfBoundsException). These typically indicate programming errors.

Example 8: Simple Program for Checked Exception
class Main9 {
    public static void main(String[] args) {
        System.out.println("main starts");
        System.out.println("Program will pause for 3 seconds");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("thread sleeps");
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("program stops");
    }
}
Output:

main starts
Program will pause for 3 seconds
program stops
Example 9: Use Try, Catch Blocks and Static Method
public class Main10 {
    public static void main(String[] args) {
        System.out.println("Main method Started");
        try {
            test();
        } catch (ArithmeticException e) {
            System.out.println("Exception is " + e.getMessage());
        }
        System.out.println("Main method Ended");
    }

    static void test() {
        System.out.println("Test method Started");
        int i = 1 / 0;
        System.out.println("Test Method Ended");
    }
}
Output:

Main method Started
Test method Started
Exception is / by zero
Main method Ended
🧩 Keywords of Exceptional Handling
I) throw keyword
Used to explicitly throw an exception object. This can be a predefined exception or a custom (user-defined) exception.

II) throws keyword
Used in a method signature to declare that a method might throw one or more checked exceptions. This forces the caller to either handle the declared exception(s) or re-declare them.

Example 10: Program Using throws Keyword and Handling Exception
class Main11 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");
        test();
        System.out.println("main ends");
    }

    static void test() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("program pause for 3 seconds");
    }
}
Output:

main starts
program pause for 3 seconds
main ends
Example 11: Hierarchical Inheritance + Exception Handling using throws
class A {
    public void m1() {
        System.out.println("method 1 on class A");
    }
}

class B extends A {
    public void add(String x, String y) throws NumberFormatException {
        int a1 = Integer.parseInt(x);
        int b1 = Integer.parseInt(y);
        int c1 = a1 + b1;
        System.out.println("addition is: " + c1);
    }
}

class C extends A {
    public void div(int x, int y) throws ArithmeticException {
        int c1 = x / y;
        System.out.println("division is: " + c1);
    }
}

public class Main12 {
    public static void main(String[] args) {
        B b = new B();
        try {
            b.add("10", "20");       // Valid
            b.add("abc", "5");       // Will throw NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("Addition Error: " + e.getMessage());
        }

        C c = new C();
        try {
            c.div(10, 5);
            c.div(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Division error" + e.getMessage());
        }

        System.out.println("program stops");
    }
}
Output:

addition is: 30
Addition Error: For input string: "abc"
division is: 2
Division error/ by zero
program stops
Example 12: Simple Checked Exception Program using throws
class A {
    void m1() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("program pause for 4 seconds");
        System.out.println("method 1 on class A");
    }
}

public class Main13 {
    public static void main(String[] args) throws Exception {
        A a1 = new A();
        a1.m1();
    }
}
Output:

program pause for 4 seconds
method 1 on class A
Example 13: Creating a New Exception using throw Keyword
class AgeInvalidException extends Exception {
    public AgeInvalidException() {}

    public AgeInvalidException(String message) {
        super(message);
    }
}

public class Main14 {
    public static void main(String[] args) throws AgeInvalidException {
        int age = 17;
        if (age < 18) {
            throw new AgeInvalidException("Age is less than 18, not eligible for voting");
        } else {
            System.out.println("You are eligible for Voting");
        }
    }
}
Output:

Exception in thread "main" AgeInvalidException: Age is less than 18, not eligible for voting
	at Main14.main(Main14.java:18)
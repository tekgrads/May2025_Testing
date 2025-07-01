Java Exception Handling

What is Exception Handling?

Compile Time Error: Errors detected during compilation.

Exception: External/internal problems causing the program to terminate abnormally.

Example 1: Arithmetic Exception

public class Example1 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        int i = 1/0; // Causes ArithmeticException
        System.out.println("End Of program");
    }
}

Output:

Started the program
ArithmeticException


Example 2: NumberFormatException

public class Example2 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        String age = "test";  // Try "25" to avoid exception
        Integer num = Integer.parseInt(age);
        System.out.println("End Of program");
    }
}
Output:

Started the program
NumberFormatException


Example 3: Try-Catch Block

public class Example3 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        try {
            int i = 1 / 0;
            System.out.println("This line will not be executed.");
        } catch (ArithmeticException e) {
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        }
        System.out.println("End Of program");
    }
}
Output:

Started the program
Caught an ArithmeticException: / by zero
End Of program


Example 4: NullPointerException

public class Example4 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        try {
            String str = null;
            System.out.println("Length: " + str.length());
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException");
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
        System.out.println("End Of program");
    }
}
Output:

Started the program
Caught NullPointerException
End Of program


Example 5: Multi-Catch Block

public class Example5 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        try {
            String age = "test";
            Integer num = Integer.parseInt(age);
            String str = null;
            System.out.println("Length: " + str.length());
        } catch (ArithmeticException | NumberFormatException | NullPointerException e) {
            System.out.println("Caught: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("End Of program");
    }
}


Example 6: Finally Block

public class Example6 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        try {
            System.out.println("Start of try");
            int i = 1 / 0;
        } finally {
            System.out.println("Finally block executed");
        }
        System.out.println("End of Program");
    }
}
Output:

Started the program
ArithmeticException


Example 7: Checked Exception (Thread Sleep)

public class Example7 {
    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted!");
        }
    }
}


Example 8: Static Method Exception Propagation

public class Example8 {
    public static void main(String[] args) {
        System.out.println("Main method Started");
        try {
            test();
        } catch (ArithmeticException e) {
            e.printStackTrace();
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
ArithmeticException: / by zero
Main method Ended


Example 9: Throws Keyword

public class Example9 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main method Started");
        test();
        System.out.println("Main method Ended");
    }

    static void test() throws InterruptedException {
        System.out.println("Test method Started");
        Thread.sleep(100);
        System.out.println("Test Method Ended");
    }
}


Example 10: Inheritance and Exceptions


class A {
    void test1() throws InterruptedException {}
    void test2() throws Exception {}
}

class B extends A {
    void test1() {}
    void test2() {}
}

class C extends A {
    void test1() throws InterruptedException {}
    void test2() throws InterruptedException {}
}

class D extends A {
    void test1() throws Exception {}
}

public class Example10 {
    public static void main(String[] args) {
        System.out.println("main");
    }
}


Example 11: Checked Exception with Custom Class

class A {
    void test1() throws InterruptedException {}
}

public class Example11 {
    public static void main(String[] args) throws Exception {
        A a1 = new A();
        a1.test1();
    }
}


Example 12: Custom Exception Class

class AgeInvalidException extends Exception {
    public AgeInvalidException() {}
    public AgeInvalidException(String message) {
        super(message);
    }
}

public class Example12 {
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



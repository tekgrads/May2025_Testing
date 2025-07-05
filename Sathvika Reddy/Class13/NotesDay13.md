
# Exception Handling in Java 

Exception handling in Java allows you to handle runtime errors, so your program doesn’t crash abruptly. Java provides two types of exceptions:

## 1. **Checked Exceptions** 
These are the exceptions that are checked at compile time. Imagine you're trying to go on a trip, but your mom (compiler) stops you and says: "Did you pack your bags properly?"

### Example:
```java
import java.io.*;

public class CheckedExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("funny_story.txt"); // File may not exist
            BufferedReader fileInput = new BufferedReader(file);

            for (int counter = 0; counter < 3; counter++) 
                System.out.println(fileInput.readLine());

            fileInput.close();
        } catch (IOException e) {
            System.out.println("Oops! The file ran away to Goa without telling you! 🌴");
        }
    }
}
```

## 2. **Unchecked Exceptions** 🕶️
These are not checked at compile time. Think of it like walking confidently on a banana peel. You won’t know you’re slipping until you’ve already fallen.

### Example:
```java
public class UncheckedExample {
    public static void main(String[] args) {
        try {
            int number = 10 / 0; // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("Divide by zero? That's mathematically illegal! 🚔");
        }

        try {
            String text = null;
            System.out.println(text.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Null pointer? Did your brain just take a break? 😵");
        }
    }
}
```



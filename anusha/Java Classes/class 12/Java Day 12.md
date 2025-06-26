📘 Enums in Java
Enums (short for Enumerations ) are a special data type that enables a variable to be a set of predefined constants. They are used when you have a fixed list of values that a variable can take.

✅ Key Points About Enums
Defined using the enum keyword.
Each enum constant is a public, static, and final instance of the enum type.
Enums can contain:
Fields
Constructors
Methods
Enums can implement interfaces but cannot extend classes.
🔹 1. Enum for Days
💡 Example: Enum with Days of the Week
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class Main {
    public static void main(String[] args) {
        Day today = Day.FRIDAY;
        System.out.println("Today is " + today);
    }
}
✅ Output:

Today is FRIDAY


🔹 2. Enum with Properties
Enums can also have fields, constructors, and methods.

💡 Example: Enum with Properties (Level)
enum Level {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int levelCode;

    Level(int levelCode) {
        this.levelCode = levelCode;
    }

    public int getLevelCode() {
        return levelCode;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Level myVar = Level.HIGH;
        System.out.println("Selected Level: " + myVar);
        System.out.println("Level Code: " + myVar.getLevelCode());
    }
}
✅ Output:
Selected Level: HIGH
Level Code: 3

🔹 3. Wrapper Classes
Wrapper classes allow primitive types to be used as objects.

int
Integer
char
Character
boolean
Boolean
double
Double

💡 Example:
public class WrapperExample {
    public static void main(String[] args) {
        int i = 50;
        Integer obj = Integer.valueOf(i); // Boxing
        int j = obj.intValue(); // Unboxing
        System.out.println("Value: " + j);
    }
}


🔹 4. Autoboxing & Unboxing
Autoboxing: Automatically converts primitive types to their wrapper classes.
Unboxing: Automatically extracts value from a wrapper object.

💡 Example:
public class AutoBoxing {
    public static void main(String[] args) {
        Integer num = 100; // Autoboxing
        int val = num;     // Unboxing
        System.out.println("Value: " + val);
    }
}
✅ Output:
Value: 100


🔹 5. Upcasting
Upcasting refers to casting a subclass reference to a superclass reference.

💡 Example:
class Animal {}
class Dog extends Animal {}

public class UpcastingExample {
    public static void main(String[] args) {
        Animal a = new Dog(); // Upcasting
        System.out.println("Upcasting successful");
    }
}
✅ Output:
Upcasting successful


🔹 6. Combined Wrapper Example
Using wrapper classes in collections like ArrayList.

💡 Example:
import java.util.ArrayList;

public class WrapperList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10); // Autoboxing
        list.add(20);

        for (Integer num : list) {
            System.out.println(num);
        }
    }
}
✅ Output:
10
20


🔹 7. Autowidening
Widening conversion happens automatically when assigning a smaller data type to a larger one.

💡 Example:
public class AutoWidening {
    public static void main(String[] args) {
        int i = 100;
        double d = i; // Autowidening
        System.out.println("Double value: " + d);
    }
}
✅ Output:
Double value: 100.0


🔹 8. Inner Classes
An inner class is defined inside another class and has access to all members of the outer class.

💡 Example:
public class Outer {
    private String msg = "Hello from Inner Class!";

    class Inner {
        void print() {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print();
    }
}
✅ Output:
Hello from Inner Class!


🔹 9. Parse Methods
Parse methods convert strings to primitives.

💡 Example:
public class ParseExample {
    public static void main(String[] args) {
        String strNum = "123";
        int num = Integer.parseInt(strNum);
        System.out.println("Number: " + (num + 1));
    }
}
✅ Output:
Number: 124
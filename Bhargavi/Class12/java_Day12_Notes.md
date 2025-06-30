🔷 1. ENUMS
Enums in Java are special data types used to define collections of constants using the enum keyword.

✅ Features
Fixed Set of Constants (e.g., days, months)
Enum constants are UPPERCASE
Type-safe
Implements interfaces
Provides:
.values() → returns array of enum constants
.valueOf("NAME") → returns enum constant by name
.ordinal() → gives index/position
📦 Use Cases:
Days of the week
Months of the year
Cardinal directions
Status indicators
State machines
📌 Example: Enum for Days
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumDemo {
    public static void main(String[] args) {
        for (Day d : Day.values()) {
            System.out.println(d);
        }
    }
}
📌 Example: Enum with Properties
enum Country {
    INDIA("IN", "India"),
    JAPAN("JP", "Japan");

    String code, name;
    Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    String getCode() { return code; }
    String getName() { return name; }
}
🔷 2. WRAPPER CLASSES
Wrapper classes convert primitive types into objects. Useful for collections and null handling.
📌 Purpose:
Use primitives in collections
Provide utility methods
Allow nulls where primitives can’t
🔁 Primitive to Wrapper Types:
Primitive	Wrapper
int	Integer
byte	Byte
short	Short
long	Long
float	Float
double	Double
char	Character
boolean	Boolean
📌 Example:
int a = 5;
Integer obj = a; // autoboxing
System.out.println(obj);
🔷 3. AUTOBOXING & UNBOXING
Autoboxing: Converting primitive to wrapper
Unboxing: Converting wrapper to primitive
📌 Example:
int x = 100;
Integer obj = x; // Autoboxing
int y = obj;     // Unboxing
System.out.println("Autoboxed: " + obj);
System.out.println("Unboxed: " + y);
🔷 4. UPCASTING
Upcasting means assigning a subclass reference to a superclass type.

Integer a = 100;
Number n = a; // Upcasting to Number
System.out.println(n);
🔷 5. COMBINED WRAPPER EXAMPLE
int a = 10;
Integer objA = new Integer(a);
int unboxed = objA.intValue();
Integer objB = 20;
Number num = objB;
🔷 6. AUTOWIDENING
Autowidening is converting a smaller data type into a larger one automatically.

🔄 Widening Order:
byte → short → int → long → float → double

📌 Example:
byte b = 10;
int i = b; // byte to int (widening)
System.out.println("int: " + i);
🔷 7. INNER CLASSES
✅ Definition:
A class defined inside another class.

Java supports nested classes:

Member Inner Class
Static Nested Class
Local Inner Class
Anonymous Inner Class
📌 Example: Anonymous Inner Class
abstract class A {
    abstract void m1();
}

public class Test {
    public static void main(String[] args) {
        A obj = new A() {
            void m1() {
                System.out.println("Anonymous Inner Class Method");
            }
        };
        obj.m1();
    }
}
🔷 8. PARSE METHODS
✅ Purpose:
Used to convert a String into an int.

📌 Example: parseInt()
String str = "90";
int number = Integer.parseInt(str);
System.out.println(number);
Used to convert a string number into its equivalent primitive type.
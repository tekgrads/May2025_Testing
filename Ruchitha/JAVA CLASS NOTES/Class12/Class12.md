
## ENUM in Java

**Definition:**  
`enum` is a group of constants under one category. It is declared like a class.

---

### ✅ Example 1: Days of the Week

```java
public class EnumExample {
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        for (Day day : Day.values()) {
            System.out.println(day);
        }
    }
}

Output:

SUNDAY
MONDAY
TUESDAY
WEDNESDAY
THURSDAY
FRIDAY
SATURDAY


✅ Example 2: Using Constants Without Enum

class Country {
    public static final String INDIA = "IND";
    public static final String UNITED_STATES = "US";
}

public class Enum_Ex1 {
    public static void main(String[] args) {
        String country = "IND";

        if (country == "IND") {
            System.out.println("Capital is Delhi 1");
        }

        if (country == "IND") {
            System.out.println("India Capital is Delhi 2");
        }

        if (country == Country.INDIA) {
            System.out.println("Capital is Delhi 3");
        }

        if (country == Country.INDIA) {
            System.out.println("Capital is Delhi 4");
        }

        if (country == Country.UNITED_STATES) {
            System.out.println("United States Capital is Washington DC");
        }
    }
}
✅ Example 3: Enum with Code and Name

enum Country {
    INDIA("IND", "BHARAT"),
    UNITED_STATES("US", "United States"),
    UNITED_KINGDOM("GB", "United Kingdom"),
    CANADA("CA", "Canada"),
    AUSTRALIA("AU", "Australia"),
    GERMANY("DE", "Germany"),
    FRANCE("FR", "France"),
    JAPAN("JP", "Japan"),
    CHINA("CN", "China"),
    BRAZIL("BR", "Brazil");

    private final String code;
    private final String name;

    Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
public class Enum_Ex2 {
    public static void main(String[] args) {
        String userInput = "IND";
        if (userInput == Country.INDIA.getCode()) {
            System.out.println(Country.INDIA.getName() + " Capital is New Delhi");
        } else if (userInput == Country.UNITED_STATES.getCode()) {
            System.out.println(Country.UNITED_STATES.getName() + " Capital is Washington, D.C.");
        }
    }
}
INNER CLASSES

Definition:

A class declared inside another class.

Types of Inner Classes:

Static Inner Classes

Non-Static Inner Classes

Local Inner Classes

✅ Example: Inner Classes


class InnerClasses {
    int a = 10;
    static int b = 20;

    class A {
        static int c = 30;
        int d = 40;

        void display() {
            System.out.println("Outer class variable a: " + a);
            System.out.println("Outer class static variable b: " + b);
        }
    }

    static class B {
        static int e = 30;
        int f = 40;

        void display() {
            System.out.println("Outer class static variable b: " + b);
        }
    }

    public static void main(String[] args) {
        System.out.println("InnerClasses.main() called");
        System.out.println("Outer class static variable b: " + b);
    }
}


ANONYMOUS INNER CLASSES


abstract class A {
    public abstract void m1();
}

class B extends A {
    @Override
    public void m1() {
        System.out.println("B.m1");
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        B b1 = new B();
        b1.m1();

        A a1 = new A() {
            @Override
            public void m1() {
                System.out.println("Anonymous Inner Class m1");
            }
        };

        a1.m1();
    }
}


WRAPPER CLASSES

Primitive Type		Wrapper Class
int			Integer
long			Long
byte			Byte
double			Double


🧠 Concepts:


Boxing: Converting a primitive into a wrapper object

Unboxing: Converting a wrapper object into a primitive

Auto-Boxing: Automatic conversion by Java

Auto-Unboxing: Automatic unwrapping by Java

✅ Example: Manual and Auto Boxing

class Wrapper_Ex {
    public static void main(String[] args) {
        int a = 10;
        System.out.println("Primitive int a: " + a);

        Integer wrapperA = new Integer(a);
        System.out.println("Wrapped Integer: " + wrapperA);

        int againPrimitiveA = wrapperA.intValue();
        System.out.println("againPrimitiveA Integer: " + againPrimitiveA);

        int b = 10;
        Integer wrapperB = b;
        System.out.println("wrapperB: " + wrapperB);

        int againPrimitiveB = wrapperB;
        System.out.println("againPrimitiveB Integer: " + againPrimitiveB);

        Integer wrapperC = 20;
        Number num = (Number) wrapperC;
        System.out.println("wrapperC: " + num);

        Byte byteWrapper = 10;
        Integer intWrapper = (Integer) (Number) byteWrapper;
    }
}
Output:

Primitive int a: 10
Wrapped Integer: 10
againPrimitiveA Integer: 10
Primitive b: 10
wrapperB: 10
againPrimitiveB Integer: 10
wrapperC: 20

✅ Example: Method Overloading with Wrapper Classes

public class Example1 {
    static void test(Integer d) {
        System.out.println("Integer: " + d);
    }

    public static void main(String[] args) {
        test(10);
    }
}
Output:

Integer: 10


✅ Example: Byte Overloading with Varargs

public class Example2 {
    static void test(Integer d) {
        System.out.println("Integer: " + d);
    }

    static void test(byte... d) {
        System.out.println("varargs byte: " + d);
    }

    public static void main(String[] args) {
        byte b = 10;
        test(b);
    }
}

✅ Example: Varargs with Strings

public class Example3 {
    static void test(String... strings) {
        for (String s : strings) {
            System.out.println("String: " + s);
        }
    }

    public static void main(String[] args) {
        test("Hello", "World", "Java", "Programming");
    }
}
Output:

String: Hello
String: World
String: Java
String: Programming




#  Java Concepts-Enums, Wrapper Class, Autoboxing, Upcasting, Auto widening, Inner class, parseInt():

---

###  Enums

**Definition:**
Enums define a fixed set of constants, making the code more readable and type-safe.
**Use:** Used when predefined constant values are required (e.g., days, directions, status codes).

**Example 1: Enum Weekdays**

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
```

**Example 2: Enum Countries**

```java
public class CountryEnumExample {
    public enum Country {
        USA("US", "USA"),
        CANADA("CA", "CANADA"),
        MEXICO("MX", "MEXICO"),
        GERMANY("DE", "GERMANY"),
        FRANCE("FR", "FRANCE"),
        JAPAN("JP", "JAPAN"),
        AUSTRALIA("AU", "AUSTRALIA");

        private final String code;
        private final String name;

        Country(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() { return code; }
        public String getName() { return name; }
    }

    public static void main(String[] args) {
        System.out.println("List of Countries and their Codes:");
        for (Country country : Country.values()) {
            System.out.println("Country name is: " + country.getName() + ", Code: " + country.getCode());
        }
    }
}
```

---

###  Wrapper Classes

**Definition:**
Wrapper classes convert primitive types into objects.
**Use:** Helpful in collections like `ArrayList` that store objects only.

**Example 1: Simple Wrapper**

```java
class Wrapper {
    public static void main(String[] args) {
        int a = 10;
        Integer b = a;
        System.out.println("Primitive: " + a);
        System.out.println("Wrapper: " + b);
    }
}
```

**Example 2: Multiple Wrappers**

```java
class Wrapper1 {
    public static void main(String[] args) {
        byte a = 10;
        Byte b = a;
        System.out.println("byte: " + b);

        short s = 15;
        Short S = s;
        System.out.println("short: " + S);

        double d = 20;
        Double D = d;
        System.out.println("double: " + D);

        long l = 30;
        Long L = l;
        System.out.println("long: " + L);
    }
}
```

---

###  Autoboxing and Unboxing

**Definition:**
Autoboxing automatically converts primitive to wrapper. Unboxing does the reverse.
**Use:** Allows mixing of primitives and objects easily.

**Autoboxing Example**

```java
class Autoboxing {
    public static void main(String[] args) {
        int num = 100;
        Integer a = num;
        System.out.println("Primitive: " + num);
        System.out.println("Autoboxed: " + a);
    }
}
```

**Unboxing Example**

```java
class Unboxing {
    public static void main(String[] args) {
        Integer num = 100;
        int a = num;
        System.out.println("Wrapper: " + num);
        System.out.println("Unboxed: " + a);
    }
}
```

---

### Upcasting

**Definition:**
Upcasting is assigning a subclass object to a superclass reference.
**Use:** Provides flexibility by allowing polymorphism.

**Example:**

```java
class UpcastExample {
    public static void main(String[] args) {
        Integer a = 100;
        Number n1 = a; // upcasting
        System.out.println("Upcasted: " + n1);
    }
}
```

---

###  Combined Wrapper Class Example

**Use:** Demonstrates boxing, unboxing, autoboxing, auto-unboxing, and upcasting.

```java
class WrapperExample {
    public static void main(String[] args) {
        int a = 10;
        Integer wrapperA = new Integer(a); // Boxing
        int unboxA = wrapperA.intValue();  // Unboxing

        Integer wrapperB = 20; // Autoboxing
        int b = wrapperB;      // Auto-unboxing

        Integer wrapperC = 30;
        Number num = wrapperC; // Upcasting

        System.out.println("wrapperA: " + wrapperA);
        System.out.println("unboxA: " + unboxA);
        System.out.println("wrapperB: " + wrapperB);
        System.out.println("wrapperC: " + num);
    }
}
```

---

###  Autowidening

**Definition:**
Autowidening automatically promotes smaller data types to larger compatible types.
**Use:** Helps method overloading resolve which version to call.

**Example:**

```java
public class Widening {
    static void test(int d) { System.out.println("int: " + d); }
    static void test(Integer d) { System.out.println("Integer: " + d); }
    static void test(Byte d) { System.out.println("Byte: " + d); }
    static void test(Number d) { System.out.println("Number: " + d); }
    static void test(Object d) { System.out.println("Object: " + d); }
    static void test(byte ...d) { System.out.println("varargs: " + d); }
    static void test(byte d) { System.out.println("byte: " + d); }

    public static void main(String[] args) {
        byte b = 10;
        test(b);
    }
}
```

---

###  Inner Classes (Anonymous)

**Definition:**
Inner classes are defined within another class. Anonymous inner classes don’t have a name.
**Use:** Used for overriding methods or quick implementations of abstract/interface types.

**Example:**

```java
abstract class A {
    public abstract void m1();
}

class B extends A {
    public void m1() {
        System.out.println("Method in class B");
    }
}

public class Innerclass {
    public static void main(String[] args) {
        B b1 = new B();
        b1.m1();

        A a1 = new A() {
            public void m1() {
                System.out.println("Anonymous Inner Class m1");
            }
        };
        a1.m1();
    }
}
```

---

###  `parseInt()`

**Definition:**
`parseInt()` converts a `String` to a primitive `int`.
**Use:** Used when user input (String) needs to be processed as a number.

**Example:**

```java
public class Main1 {
    public static void main(String[] args) {
        System.out.println("Strted the program");
        String age = "90";  
        Integer num = Integer.parseInt(age);
        System.out.println(+num);
        System.out.println("End Of program");
    } 
}
```


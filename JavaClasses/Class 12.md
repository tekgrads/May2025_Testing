# ☕ Java Concepts: Enums, Wrapper Classes, Autoboxing, Upcasting, Autowidening, Inner Classes, parseInt()

---

## 🔹 1. ENUMS

### ✅ Definition:
An `enum` (short for *enumeration*) is a special data type that represents a fixed set of named constants.

### 📌 Characteristics:
- Fixed Set of Constants (e.g., days, months)
- Enum constants are **UPPERCASE**
- Type-safe
- Implements interfaces
- Provides:
  - `.values()` → returns array of enum constants
  - `.valueOf("NAME")` → returns enum constant by name
  - `.ordinal()` → gives index/position

### 📦 Use Cases:
- Days of the week
- Months of the year
- Cardinal directions
- Status indicators
- State machines

### ✨ Example 1: Days of the Week
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

#### Output:
```
SUNDAY
MONDAY
TUESDAY
WEDNESDAY
THURSDAY
FRIDAY
SATURDAY
```

### ✨ Example 2: Country Enum with Fields
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

#### Output:
```
Country name is: USA, Code: US
Country name is: CANADA, Code: CA
Country name is: MEXICO, Code: MX
Country name is: GERMANY, Code: DE
Country name is: FRANCE, Code: FR
Country name is: JAPAN, Code: JP
Country name is: AUSTRALIA, Code: AU
```

---

## 🔹 2. WRAPPER CLASSES

### ✅ Definition:
Wrapper classes convert **primitive types** into **objects**.

### 📌 Purpose:
- Use primitives in collections
- Provide utility methods
- Allow nulls where primitives can’t

### 🔁 Primitive to Wrapper Types:

| Primitive | Wrapper    |
|-----------|------------|
| byte      | Byte       |
| short     | Short      |
| int       | Integer    |
| long      | Long       |
| float     | Float      |
| double    | Double     |
| char      | Character  |
| boolean   | Boolean    |

### ✨ Example 1:
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

### ✨ Example 2:
```java
class Wrapper1 {
    public static void main(String[] args) {
        byte a = 10; Byte b = a;
        short s = 15; Short S = s;
        double d = 20; Double D = d;
        long l = 30; Long L = l;

        System.out.println("byte: " + b);
        System.out.println("short: " + S);
        System.out.println("double: " + D);
        System.out.println("long: " + L);
    }
}
```

---

## 🔹 3. AUTOBOXING & UNBOXING

### ✅ Autoboxing:
Automatically converts **primitive → wrapper**.

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

### ✅ Unboxing:
Automatically converts **wrapper → primitive**.

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

## 🔹 4. UPCASTING

### ✅ Definition:
Assigning a **subclass object to a superclass reference**.

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

## 🔹 5. COMBINED WRAPPER EXAMPLE

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

## 🔹 6. AUTOWIDENING

### ✅ Definition:
Automatic conversion from a smaller primitive type to a larger one.

### 🔁 Widening Order:
```
byte → short → int → long → float → double
```

### ✨ Example:
```java
public class Widening {
    static void test(int d) { System.out.println("int: " + d); }
    static void test(Integer d) { System.out.println("Integer: " + d); }
    static void test(Byte d) { System.out.println("Byte: " + d); }
    static void test(Number d) { System.out.println("Number: " + d); }
    static void test(Object d) { System.out.println("Object: " + d); }
    static void test(byte... d) { System.out.println("varargs: " + d); }
    static void test(byte d) { System.out.println("byte: " + d); }

    public static void main(String[] args) {
        byte b = 10;
        test(b); // Matches the most specific method first
    }
}
```

---

## 🔹 7. INNER CLASSES

### ✅ Definition:
A class defined **inside another class**.

### 📌 Types:
- **Member Inner Class**
- **Local Inner Class**
- **Anonymous Inner Class**
- **Static Nested Class**

### ✅ Benefits:
- Logical grouping
- Better encapsulation
- Can access outer class members

### ✨ Example: Anonymous Inner Class
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

## 🔹 8. `parseInt()` Method

### ✅ Purpose:
Used to **convert a String into an int**.

### ✨ Example:
```java
public class Main1 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        String age = "90";
        Integer num = Integer.parseInt(age);
        System.out.println(num);
        System.out.println("End Of program");
    }
}
```

#### Output:
```
Started the program
90
End Of program
```

---

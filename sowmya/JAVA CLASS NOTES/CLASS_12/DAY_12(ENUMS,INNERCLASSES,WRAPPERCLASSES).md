# Java Concepts: Enums, Wrapper Classes, Autoboxing, Upcasting, Autowidening, Inner Classes

---

## 1. ENUMS

In Java, an `enum` (short for enumeration) is a special data type that represents a fixed set of named constants. Enums are introduced using the `enum` keyword.

### Characteristics

* **Fixed Set of Constants**
* **Enum Constants**: Written in uppercase.
* **Type Safety**
* **Iteration**: Use `.values()` method.
* **valueOf(String name)**: Retrieve enum constant by name.
* **ordinal()**: Returns position in declaration.
* **Can Implement Interfaces**

### Use Cases

* Days of the week
* Months of the year
* Cardinal directions
* State machines
* Status indicators

### Example 1: Days of the Week

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

output


```
Days of the week:
SUNDAY
MONDAY
TUESDAY
WEDNESDAY
THURSDAY
FRIDAY
SATURDAY
```


### Example 2: Country Enum

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


output

```
List of Countries and their Codes:
Country name is: USA, Code: US
Country name is: CANADA, Code: CA
Country name is: MEXICO, Code: MX
Country name is: GERMANY, Code: DE
Country name is: FRANCE, Code: FR
Country name is: JAPAN, Code: JP
Country name is: AUSTRALIA, Code: AU

```

---

## 2. WRAPPER CLASSES

Java wrapper classes convert primitive types into objects.

### Purpose

* Treat primitives as objects (e.g., in collections)
* Provide utility methods
* Support `null` values

### Wrapper Types

| Primitive | Wrapper   |
| --------- | --------- |
| byte      | Byte      |
| short     | Short     |
| int       | Integer   |
| long      | Long      |
| float     | Float     |
| double    | Double    |
| char      | Character |
| boolean   | Boolean   |

### Example 1

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

output
```
primitive type value is: 10
wrapper type value is: 10

```

### Example 2

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

output
```
primitive type value is: 10
wrapper type value is: 10


primitive type value is: 15
wrapper type value is: 15


primitive type value is: 20.0
wrapper type value is: 20.0


primitive type value is30
Wrapper type value is: 30

```

---

## 3. AUTOBOXING & UNBOXING

### Autoboxing

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

output
```
Primitive int: 100
Autoboxed Integer: 100


```

### Unboxing

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

output
```
Primitive int: 100
Unboxed Integer: 100


```

---

## 4. UPCASTING

Upcasting is treating a subclass object as its superclass.

```java
class UpcastExample {
    public static void main(String[] args) {
        Integer a = 100;
        Number n1 = a; // upcasting
        System.out.println("Upcasted: " + n1);
    }
}
```

output
```

primitive int: 100
Autoboxed Integer: 100
upcasting value is: 100

```


---

## 5. COMBINED EXAMPLE

```java
class WrapperExample {
    public static void main(String[] args) {
        int a = 10;
        Integer wrapperA = new Integer(a);
        int unboxA = wrapperA.intValue();

        Integer wrapperB = 20; // autobox
        int b = wrapperB; // unbox

        Integer wrapperC = 30;
        Number num = wrapperC; // upcast

        System.out.println("wrapperA: " + wrapperA);
        System.out.println("unboxA: " + unboxA);
        System.out.println("wrapperB: " + wrapperB);
        System.out.println("wrapperC: " + num);
    }
}
```


output
```
Primitive int a: 10
Wrapped Integer: 10
againPrimitiveA Integer: 10
primitve b: 20
wrapperB : 20
againPrimitiveB Integer: 20
wrapperC: 30
```




---

## 6. AUTOWIDENING

Autowidening converts smaller primitives to larger types.

### Widening Order

`byte → short → int → long → float → double`

### Example

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
output
```
byte: 10
```
after byte->int->Byte->Number->Object->varargs this is the order will get executed

---

## 7. INNER CLASSES

Inner classes are classes defined within other classes.

### Types

* **Member Inner Class**
* **Local Inner Class**
* **Anonymous Inner Class**
* **Static Nested Class**

### Advantages

* Better encapsulation
* Logical grouping
* Improved readability

### Example

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

output
```
method1 on b class
Anonymous Inner Class m1

```
## 8.use of parseInt


###example program


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


output
```
Strted the program
90
End Of program

```

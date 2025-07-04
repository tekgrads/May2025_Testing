#  Enums, Wrapper Classes, Autoboxing/Unboxing, Autowidening, Inner Classes, and Parse Methods


---

##  Enums
Enums represent a fixed set of constants (like days, colors, directions).


enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
}

public class EnumDemo {
    public static void main(String[] args) {
        Day today = Day.MONDAY;
        System.out.println("Today is: " + today);
    }
}
```

- Type-safe constant values
- Can include methods and constructors

---

##  Wrapper Classes
Java provides wrapper classes to use primitive types as objects:
- int → `Integer`
- char → `Character`
- double → `Double`, etc.

```java
int num = 10;
Integer obj = Integer.valueOf(num); // wrapping manually
System.out.println("Wrapped Integer: " + obj);
```

---

##  Autoboxing & Unboxing
### Autoboxing: Primitive → Wrapper automatically
### Unboxing: Wrapper → Primitive automatically

```java
int x = 5;
Integer a = x;  // Autoboxing
int y = a;      // Unboxing
System.out.println("a: " + a + ", y: " + y);
```

---

##  Autowidening
Java automatically converts smaller types to larger compatible types.

```java
int a = 100;
long b = a; // int widened to long
float c = b; // long widened to float
System.out.println("b: " + b + ", c: " + c);
```

>  Happens implicitly in method calls or assignments.

---

##  Inner Classes
Java allows classes within classes (nested classes).

### 1. **Member Inner Class**
```java
class Outer {
    class Inner {
        void show() {
            System.out.println("Inside Inner class");
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Outer.Inner obj = new Outer().new Inner();
        obj.show();
    }
}
```

### 2. **Static Nested Class**
```java
class Outer {
    static class Inner {
        void display() {
            System.out.println("Static Inner class");
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        Outer.Inner obj = new Outer.Inner();
        obj.display();
    }
}
```

### 3. **Local Inner Class** (inside method)
```java
class Outer {
    void outerMethod() {
        class Inner {
            void msg() {
                System.out.println("Inside local inner class");
            }
        }
        Inner obj = new Inner();
        obj.msg();
    }
}
```

---

##  Parse Methods
Used to convert `String` to a primitive type.

```java
String str = "123";
int num = Integer.parseInt(str);
double d = Double.parseDouble("45.67");
System.out.println("Integer: " + num);
System.out.println("Double: " + d);
```

###  Common Parse Methods:
- `Integer.parseInt(String)`
- `Double.parseDouble(String)`
- `Boolean.parseBoolean(String)`

---



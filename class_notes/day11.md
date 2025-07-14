# Java Concepts: Enum, Wrapper Classes, Autoboxing, and Upcasting

## 1. Enum in Java

### What is an Enum?

An **enum** (short for enumeration) is a special Java type used to define collections of constants.

### Syntax:

```java
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

### Features:

* Enum constants are implicitly `public`, `static`, and `final`.
* Enums can have fields, constructors, and methods.
* Used to create a variable that can only take one out of a small set of possible values.

### Example:

```java
enum Color {
    RED, GREEN, BLUE;

    public void display() {
        System.out.println("Color is: " + this);
    }
}

public class TestEnum {
    public static void main(String[] args) {
        Color c = Color.RED;
        c.display();
    }
}
```

---

## 2. Wrapper Classes

### What is a Wrapper Class?

Java provides **wrapper classes** for all primitive data types. Wrapper classes convert primitive data types into objects.

### Primitive to Wrapper Mapping:

| Primitive | Wrapper Class |
| --------- | ------------- |
| byte      | Byte          |
| short     | Short         |
| int       | Integer       |
| long      | Long          |
| float     | Float         |
| double    | Double        |
| char      | Character     |
| boolean   | Boolean       |

### Example:

```java
int a = 5;
Integer obj = Integer.valueOf(a);  // Boxing
int b = obj.intValue();            // Unboxing
```

---

## 3. Autoboxing and Unboxing

### Autoboxing:

Automatic conversion of a primitive type to its corresponding wrapper class.

```java
int a = 10;
Integer obj = a;  // Autoboxing
```

### Unboxing:

Automatic conversion of a wrapper class object to its corresponding primitive type.

```java
Integer obj = 15;
int b = obj;  // Unboxing
```

### Why Needed?

* To use primitives in collections like `ArrayList`, which store objects only.

### Example:

```java
import java.util.*;
public class AutoBoxingDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100); // Autoboxing
        int num = list.get(0); // Unboxing
        System.out.println(num);
    }
}
```

---

## 4. Upcasting in Java

### What is Upcasting?

Upcasting is the process of converting a subclass type to a superclass type.

* Happens implicitly.
* Safe and no explicit casting required.

### Why Use Upcasting?

* To achieve **runtime polymorphism**.
* To write more generic and reusable code.

### Example:

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}

public class UpcastingDemo {
    public static void main(String[] args) {
        Animal a = new Dog();  // Upcasting
        a.sound();             // Output: Dog barks
    }
}
```

### Notes:

* The object still behaves as the actual object (`Dog`) even though it is referenced by a superclass (`Animal`).

---


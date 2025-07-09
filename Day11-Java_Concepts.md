
# Java Concepts

## 1. Enums
- An enum is a special Java type used to define collections of constants.
- Useful when a variable can only take one out of a small set of possible values.

### Example:
```java
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}
```

## 2. Wrapper Classes
- Java provides wrapper classes for all primitive types.
- They allow primitives to be treated as objects.

### Example:
| Primitive | Wrapper Class |
|-----------|----------------|
| int       | Integer        |
| char      | Character      |
| boolean   | Boolean        |
| byte      | Byte           |
| short     | Short          |
| long      | Long           |
| float     | Float          |
| double    | Double         |

## 3. Autoboxing
- Automatic conversion of primitive types to their corresponding wrapper classes.

### Example:
```java
int num = 10;
Integer obj = num; // Autoboxing
```

## 4. Upcasting
- Upcasting is the process of converting a subclass type to a superclass type.
- It is done implicitly.

### Example:
```java
class Animal {}
class Dog extends Animal {}

Animal a = new Dog(); // Upcasting
```

## 5. Autowidening
- Autowidening is the automatic conversion of a smaller primitive type to a larger primitive type.

### Example:
```java
int i = 100;
long l = i; // Autowidening from int to long
```

## 6. Inner Classes
- A class declared within another class is called an inner class.

### Types of Inner Classes:
- Non-static inner class
- Static nested class
- Local inner class
- Anonymous inner class

### Example:
```java
class Outer {
    class Inner {
        void display() {
            System.out.println("Inner class method");
        }
    }
}
```

## 7. parseInt()
- `parseInt()` is a method in the `Integer` class used to convert a string to an integer.

### Example:
```java
String s = "123";
int num = Integer.parseInt(s); // num = 123
```

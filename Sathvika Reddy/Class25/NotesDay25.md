
# Anonymous Inner Class vs Lambda Expression & Interface with Main Method

---

## 1. Anonymous Inner Class vs Lambda Expression

### a. Anonymous Inner Class

Used to create a subclass or implement an interface **on the spot**.

```java
interface Speaker {
    void speak();
}

public class AnonymousDemo {
    public static void main(String[] args) {
        Speaker s = new Speaker() {
            public void speak() {
                System.out.println("Hello from anonymous class");
            }
        };
        s.speak();
    }
}
```

### b. Lambda Expression

Shorter syntax used only for **functional interfaces** (interfaces with one abstract method).

```java
interface Speaker {
    void speak();
}

public class LambdaDemo {
    public static void main(String[] args) {
        Speaker s = () -> System.out.println("Hello from lambda expression");
        s.speak();
    }
}
```

### Comparison Table:

| Feature                     | Anonymous Inner Class          | Lambda Expression                    |
|----------------------------|----------------------------------|--------------------------------------|
| Syntax                     | Verbose                          | Concise                              |
| Use case                   | Any interface or class           | Only functional interfaces           |
| `this` keyword             | Refers to anonymous class object | Refers to enclosing class            |
| Overhead                   | Creates separate class file      | Lightweight                          |

---

## 2. Interface with Main Method

Since Java 8, interfaces can have a `main` method – though it’s rare, it's legal.

### Example:

```java
interface Hello {
    static void main(String[] args) {
        System.out.println("Main method inside interface!");
    }
}
```

### Output:

```
Main method inside interface!
```


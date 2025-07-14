

##  Consumer Interface

### ➤ Description
`Consumer<T>` is a functional interface that accepts a single input argument and returns no result. Used primarily for performing operations like printing, modifying, etc.

### ➤ Functional Method
```java
void accept(T t);
````

### ➤ Example

```java
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> printer = s -> System.out.println("Hello " + s);
        printer.accept("Java 8");
    }
}
```

---

##  Supplier Interface

### ➤ Description

`Supplier<T>` is a functional interface that takes no arguments and returns a result.

### ➤ Functional Method

```java
T get();
```

### ➤ Example

```java
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Supplied value";
        System.out.println(supplier.get());
    }
}
```

---

##  Method Reference (`::` Operator)

### ➤ Description

Method reference is a shorthand notation of a lambda expression to call a method.

### ➤ Syntax Forms

* `ClassName::staticMethod`
* `instance::instanceMethod`
* `ClassName::new` (Constructor reference)

### ➤ Examples

#### 1. Static Method Reference

```java
class Utils {
    public static void printMessage(String msg) {
        System.out.println(msg);
    }
}

Consumer<String> consumer = Utils::printMessage;
consumer.accept("Hello from static method");
```

#### 2. Instance Method Reference

```java
class Greeter {
    public void greet(String name) {
        System.out.println("Hello " + name);
    }
}

Greeter greeter = new Greeter();
Consumer<String> c = greeter::greet;
c.accept("World");
```

#### 3. Constructor Reference

```java
class Message {
    Message(String msg) {
        System.out.println(msg);
    }
}

Supplier<Message> s = () -> new Message("Hello Constructor");
// OR
Supplier<Message> s2 = () -> new Message("Hello");
s.get();
s2.get();
```

---

##  Stream API

### ➤ Description

The **Stream API** in Java 8 is used to process collections of objects in a functional style.

### ➤ Common Operations

* `filter()` – filters elements
* `map()` – transforms elements
* `sorted()` – sorts elements
* `collect()` – terminal operation to convert to list/set/etc.
* `forEach()` – terminal operation to loop over elements



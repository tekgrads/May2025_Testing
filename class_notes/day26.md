 Java 8: Consumer, Supplier, Double Colon (::), and Streams

---

## 🔹 1. Consumer (java.util.function.Consumer)

### 📘 What is it?
- A **functional interface** that accepts a single input argument and **returns no result**.
- Method: `void accept(T t)`

### 🧪 Example:
```java
import java.util.function.Consumer;

Consumer<String> printer = s -> System.out.println("Hello " + s);
printer.accept("World"); // Output: Hello World
✅ Use Cases:
Iterating and performing actions on each element.

Logging or printing operations.

🔹 2. Supplier (java.util.function.Supplier)
📘 What is it?
A functional interface that supplies results without taking any input.

Method: T get()

🧪 Example:
java
Copy
Edit
import java.util.function.Supplier;

Supplier<String> message = () -> "Java 8 is awesome!";
System.out.println(message.get()); // Output: Java 8 is awesome!
✅ Use Cases:
Lazy initialization.

Generating random values or system time.

🔸 3. Double Colon (::) Operator
📘 What is it?
Also known as the method reference operator.

Used to call a method by referencing it with its class or object.

✅ Types of Method References:
Static method → ClassName::staticMethod

Instance method → object::instanceMethod

Constructor → ClassName::new

🧪 Examples:
java
Copy
Edit
// Static method
Function<String, Integer> strToInt = Integer::parseInt;

// Instance method
String msg = "hello";
Supplier<Integer> length = msg::length;

// Constructor reference
Supplier<StringBuilder> sb = StringBuilder::new;
🔹 4. Streams (java.util.stream)
📘 What is it?
A new API to process collections of objects in a functional style.

Allows filtering, mapping, reducing, and collecting data easily.

✅ Features:
Lazy evaluation

Parallel processing

Pipeline operations

🧪 Example:
java
Copy
Edit
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.stream()
             .filter(name -> name.startsWith("C"))
             .forEach(System.out::println); // Output: Charlie
    }
}
🧰 Common Methods:
Method	Description
filter()	Filters elements based on condition
map()	Transforms elements
collect()	Collects result into list/set/etc
forEach()	Performs an action for each element
sorted()	Sorts the elements
count()	Counts the elements
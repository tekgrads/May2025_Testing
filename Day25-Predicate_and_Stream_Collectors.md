
# Predicate and Stream Collectors in Java

## Predicate in Java

###  What is Predicate?
A **Predicate** is a functional interface introduced in Java 8. It represents a **boolean-valued function** of one argument.

### Syntax
```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```

###  Example 1: Predicate with Integer
```java
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(4));  // true
        System.out.println(isEven.test(5));  // false
    }
}
```

---

##  Stream Collectors in Java

###  What is a Collector?
Collectors are part of the `java.util.stream` package. They are used to **gather the elements of a stream into a collection or summary result**.

###  Commonly Used Collectors

#### 1. toList()
```java
List<String> list = Stream.of("A", "B", "C")
                          .collect(Collectors.toList());
```

#### 2. toSet()
```java
Set<String> set = Stream.of("A", "B", "A")
                        .collect(Collectors.toSet());
```

#### 3. joining()
```java
String result = Stream.of("Java", "8")
                      .collect(Collectors.joining(" "));
// Output: "Java 8"
```

#### 4. toMap()
```java
Map<Integer, String> map = Stream.of("a", "bb", "ccc")
    .collect(Collectors.toMap(String::length, s -> s, (s1, s2) -> s1));
```

#### 5. groupingBy()
```java
Map<Integer, List<String>> grouped = Stream.of("a", "bb", "cc", "d")
    .collect(Collectors.groupingBy(String::length));
```

#### 6. summarizingInt()
```java
IntSummaryStatistics stats = Stream.of(1, 2, 3, 4, 5)
    .collect(Collectors.summarizingInt(Integer::intValue));
```

---

## 🔹 Summary

| Feature        | Interface/Method         | Use Case                          |
|----------------|---------------------------|-----------------------------------|
| Predicate      | `Predicate<T>`            | Filtering with condition          |
| Collectors     | `Collectors.toList()`     | Collect elements into list        |
|                | `Collectors.toMap()`      | Convert stream to map             |
|                | `Collectors.groupingBy()` | Group elements by property        |
|                | `Collectors.joining()`    | Concatenate stream strings        |

---

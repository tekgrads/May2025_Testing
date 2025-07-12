
# Predicate and Stream Collectors in Java

## 1. Predicate

Predicate is a functional interface that represents a condition or test. It returns `true` or `false`. Think of it as a bouncer at a club: only lets certain people (elements) in.

### Common Predicate Methods
- `test(T t)` — Tests the given condition.
- `and()`, `or()`, `negate()` — Combine or reverse conditions.

### Example: Bouncer Filtering People
```java
import java.util.function.Predicate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class PredicateExample {
    public static void main(String[] args) {
        List<String> guests = Arrays.asList("Alice", "Bob", "Charlie", "Andrew", "Amanda");

        Predicate<String> startsWithA = name -> name.startsWith("A");
        Predicate<String> longName = name -> name.length() > 5;

        List<String> filteredGuests = guests.stream()
            .filter(startsWithA.and(longName))
            .collect(Collectors.toList());

        System.out.println("People allowed in the VIP lounge: " + filteredGuests);
    }
}
```

## 2. Stream Collectors

Collectors are used to gather the result of stream operations into a container like List, Set, Map, or even a custom object.

### Common Collector Methods (All used below)
- `toList()` — Collects elements into a List.
- `toSet()` — Collects elements into a Set.
- `joining()` — Joins elements into a single string.
- `counting()` — Counts number of elements.
- `groupingBy()` — Groups elements by a classifier.
- `partitioningBy()` — Splits elements into two groups based on a predicate.
- `mapping()` — Transforms and collects values.

### Example: Classifying Fruits in a Fruit Shop
```java
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class CollectorExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Avocado", "Blueberry", "Blackberry", "Apricot", "Mango");

        // 1. toList and toSet
        List<String> fruitList = fruits.stream().collect(toList());
        Set<String> fruitSet = fruits.stream().collect(toSet());

        // 2. joining
        String allFruits = fruits.stream().collect(joining(", "));

        // 3. counting
        long count = fruits.stream().collect(counting());

        // 4. groupingBy - Group by first letter
        Map<Character, List<String>> grouped = fruits.stream().collect(groupingBy(f -> f.charAt(0)));

        // 5. partitioningBy - Partition fruits that start with 'A'
        Map<Boolean, List<String>> partitioned = fruits.stream().collect(partitioningBy(f -> f.startsWith("A")));

        // 6. mapping - Uppercase the fruits grouped by length
        Map<Integer, List<String>> mapped = fruits.stream().collect(groupingBy(
            String::length,
            mapping(String::toUpperCase, toList())
        ));

        System.out.println("Fruit List: " + fruitList);
        System.out.println("Fruit Set: " + fruitSet);
        System.out.println("Joined Fruits: " + allFruits);
        System.out.println("Total Fruits: " + count);
        System.out.println("Grouped by First Letter: " + grouped);
        System.out.println("Partitioned by Start with A: " + partitioned);
        System.out.println("Mapped (Grouped by Length, Uppercase): " + mapped);
    }
}
```



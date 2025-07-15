

#  Java 8 – Functional Interfaces & Stream API

---

##  Consumer Interface

```java
import java.util.function.Consumer;

public class Example18 {
    public static void main(String[] args) {
        Consumer<Integer> c1 = c -> System.out.println("consumer1: " + c);
        c1.accept(10);

        Consumer<Integer> c2 = c -> System.out.println("consumer2: " + c);
        Consumer<Integer> c3 = c -> System.out.println("consumer3: " + c);
        Consumer<Integer> c4 = c -> System.out.println("consumer4: " + c);
        Consumer<Integer> c5 = c -> System.out.println("consumer5: " + c);

        c1.andThen(c2).andThen(c3).andThen(c4).andThen(c5).accept(30);
    }
}
```



---

## Supplier Interface

```java
import java.util.function.Supplier;

public class Example19 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> {
            int a = 100;
            System.out.println("Supplying value...");
            return a;
        };
        System.out.println("Value: " + s.get());
    }
}
```


---

##  Double Colon Operator (Method Reference)

```java
interface DoubleColon {
    public void m1();
}

class Test5 {
    public static void m2() {
        System.out.println("Static method reference");
    }

    public void m3() {
        System.out.println("Instance method reference");
    }
}

public class Example21 {
    public static void main(String[] args) {
        DoubleColon dc = () -> System.out.println("Lambda version");
        dc.m1();

        DoubleColon dc1 = Test5::m2;
        dc1.m1();

        Test5 t = new Test5();
        DoubleColon dc2 = t::m3;
        dc2.m1();
    }
}
```



---

##  Constructor Reference

```java
class C1 {
    C1() {
        System.out.println("Default constructor called");
    }
}

interface IntCon {
    public C1 get();
}

public class Example22 {
    public static void main(String[] args) {
        IntCon i1 = () -> new C1(); // Lambda
        i1.get();

        IntCon i2 = C1::new; // Constructor reference
        i2.get();
    }
}
```



---

##  Stream API (with Numbers)

```java
import java.util.*;
import java.util.stream.*;

public class Example24 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 100; i++) list.add(i);

        System.out.println("Total count: " + list.stream().count());
        System.out.println("Sum (1-99): " + IntStream.range(1, 100).sum());
        System.out.println("Average (1-99): " + IntStream.range(1, 100).average());

        List<Integer> evens = list.stream()
            .filter(i -> i % 2 == 0)
            .collect(Collectors.toList());

        System.out.println("Even numbers: " + evens);
    }
}
```



---

##  Stream API (with Strings)

```java
import java.util.*;
import java.util.stream.*;

public class Example25 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Test", "abc", "apple", "almond", "suresh", "ramesh");

        List<String> result = list.stream()
            .filter(p -> p.startsWith("a"))
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println("Filtered result: " + result);

        list.stream()
            .filter(p -> p.startsWith("a"))
            .map(String::toUpperCase)
            .forEach(System.out::println);

        System.out.println("Any start with a? " + list.stream().anyMatch(p -> p.startsWith("a")));
        System.out.println("All start with a? " + list.stream().allMatch(p -> p.startsWith("a")));
        System.out.println("None start with a? " + list.stream().noneMatch(p -> p.startsWith("a")));
    }
}
```



---

##  Reduce Operation

```java
import java.util.*;

public class Example26 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three", "four", "five", "six");

        Optional<String> reduced = list.stream()
            .reduce((s1, s2) -> s1 + "#" + s2);

        System.out.println("Reduced: " + reduced.get());
    }
}
```


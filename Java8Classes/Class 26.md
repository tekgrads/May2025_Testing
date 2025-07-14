# Class 26: (12-07-2025)

---

## Consumer
- Takes **one input**.
- Accepts and processes it.
- **Returns nothing**.

### Example:
```java
import java.util.function.Consumer;

public class Ex12 {
    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println("consumer c1 " + s);
        Consumer<String> c2 = s -> System.out.println("consumer c2 " + s);
        Consumer<String> c3 = s -> System.out.println("consumer c3 " + s);

        c1.andThen(c2).andThen(c3).accept("testing");
    }
}
```

---

## Supplier
- Takes **nothing**.
- Returns a value (supplies it).

### Example:
```java
import java.util.function.Supplier;
import java.util.Date;

public class Ex13 {
    public static void main(String[] args) {
        Supplier<Date> s = () -> new Date();
        System.out.println(s.get());
    }
}
```

---

## Double Colon Operator `::` (Method Reference)

Used to pass a method reference (instead of lambda) to a functional interface.

```java
package com.tekgrads;

interface Intf {
    void m1();
}

class TestIntf {
    public static void m2() {
        System.out.println("In TestIntf m2 method");
    }

    public void m3() {
        System.out.println("In TestIntf m3 method");
    }
}

public class Example14 {
    public static void main(String[] args) {
        Intf f = () -> System.out.println("lambda of m1 in intf");
        f.m1();

        Intf f2 = TestIntf::m2;
        f2.m1();

        TestIntf test = new TestIntf();
        Intf f3 = test::m3;
        f3.m1();
    }
}
```

---

## Constructor Reference

If you want to pass a constructor reference to a functional interface (e.g., `Supplier`).

```java
package com.tekgrads;

class A {
    A() {
        System.out.println("In A constructor");
    }
}

interface IA {
    A get();
}

public class Example15 {
    public static void main(String[] args) {
        IA i = () -> new A();
        i.get();

        IA i2 = A::new;
        i2.get();
    }
}
```

---

## Streams

> If you want to **process data from collections**, use **Streams API**.

### Terminology:
- **Intermediate Operations**: Transforms the stream (e.g., `filter`, `map`)
- **Terminal Operations**: Ends the stream pipeline (e.g., `collect`, `count`)

---

### Example with Numbers:

```java
package com.tekgrads;

import java.util.*;
import java.util.stream.*;

public class Example16 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 4);
        Stream<Integer> stream2 = Stream.of(new Integer[]{1, 2, 3, 4});

        System.out.println(stream2.count());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            list.add(i);
        }

        Stream<Integer> stream3 = list.stream();
        System.out.println(stream3.count());

        System.out.println(IntStream.range(1, 100).sum());
        System.out.println(IntStream.range(1, 100).average());

        List<Integer> evens = IntStream.range(1, 100)
            .filter(i -> i % 2 == 0)
            .boxed()
            .collect(Collectors.toList());
        System.out.println(evens);

        List<Integer> evens2 = list.stream()
            .filter(i -> i % 2 == 0)
            .collect(Collectors.toList());
        System.out.println(evens2);
    }
}
```

---

### Example with Strings:

```java
package com.tekgrads;

import java.util.*;
import java.util.stream.*;

public class Example17 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Test", "abc", "apple", "almond", "suresh", "ramesh");

        List<String> result = list.stream()
            .filter(p -> p.startsWith("a"))
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println(result);
        System.out.println("--------------------");

        list.stream()
            .filter(p -> p.startsWith("a"))
            .map(String::toUpperCase)
            .forEach(System.out::println);

        System.out.println(list.stream().anyMatch(p -> p.startsWith("a"))); // true/false
        System.out.println(list.stream().allMatch(p -> p.startsWith("a"))); // true/false
        System.out.println(list.stream().noneMatch(p -> p.startsWith("a"))); // true/false
    }
}
```

### Terminal Operators:
- `anyMatch()`
- `allMatch()`
- `noneMatch()`

> All return `boolean` and **terminate** the stream.

---

## BiFunction

- Takes **two parameters**.
- Returns a single value.

---

## Reduce Operation

Used to **combine all elements** into a single result (e.g., concatenation, sum).

```java
package com.tekgrads;

import java.util.*;

public class Example18 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Test", "abc", "apple", "almond", "suresh", "ramesh");

        Optional<String> reduce = list.stream()
            .reduce((s1, s2) -> s1 + "#" + s2);

        reduce.ifPresent(r -> System.out.println(r));
        reduce.ifPresentOrElse(
            r -> System.out.println(r),
            () -> System.out.println("No Value Present")
        );
    }
}
```

#### Sample Output:
```
Test#abc#apple#almond#suresh#ramesh
```

---

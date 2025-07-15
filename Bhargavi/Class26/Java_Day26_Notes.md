 ☕ Java Notes – Consumer, Supplier, Method Reference, and Streams
 1. Consumer
A Consumer is a Functional Interface with a Single Abstract Method: `accept()`
It takes a value but does not return anything.
Example 1: Program on Consumer


import java.util.function.Consumer;

public class Example18 {
    public static void main(String[] args) {
        Consumer<Integer> c1 = c -> System.out.println("the integer in consumer1 is: " + c);
        c1.accept(10);

        Consumer<Integer> c2 = c -> System.out.println("the integer in consumer2 is: " + c);
        Consumer<Integer> c3 = c -> System.out.println("the integer in consumer3 is: " + c);
        Consumer<Integer> c4 = c -> System.out.println("the integer in consumer4 is: " + c);
        Consumer<Integer> c5 = c -> System.out.println("the integer in consumer5 is: " + c);

        c2.accept(20);
        c1.andThen(c2).andThen(c3).andThen(c4).andThen(c5).accept(30);
    }
}

2. Supplier
A Supplier is a Functional Interface with a Single Abstract Method: `get()`
It returns a value but does not take any input.
Example 2: Program on Supplier

import java.util.function.Supplier;

public class Example19 {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> {
            int a = 100;
            System.out.println("The value on method1 supplier is " + a);
            return a;
        };
        System.out.println("the value is: " + s.get());
    }
}

Example 3: Another Program on Supplier


import java.util.Date;
import java.util.function.*;

public class Example20 {
    public static void main(String[] args) {
        Supplier<Date> s1 = () -> new Date();
        System.out.println(s1.get());
    }
}

3. Double Colon `::` Operator

The double colon operator `::` is used to refer to methods or constructors by name.
It is a shorthand for a lambda expression that calls a method.

Example 4: Method Reference with `::`


interface DoubleColon {
    public void m1();
}

class Test5 {
    public static void m2() {
        System.out.println("this is a m2 static method on class");
    }
    public void m3() {
        System.out.println("this is a m3 non-static method on class");
    }
}

public class Example21 {
    public static void main(String[] args) {
        DoubleColon dc = () -> System.out.println("this is a lambda expression");
        dc.m1();

        DoubleColon dc1 = Test5::m2;
        dc1.m1();

        Test5 t1 = new Test5();
        DoubleColon dc3 = t1::m3;
        dc3.m1();
    }
}

Example 5: Constructor Reference with `::`

class C1 {
    C1() {
        System.out.println("this is a default constructor");
    }
}

interface IntCon {
    public C1 get();
}

public class Example22 {
    public static void main(String[] args) {
        IntCon i = () -> new C1();
        i.get();

        IntCon i1 = C1::new;
        i1.get();
    }
}

4. Streams

A Stream is a sequence of elements that supports aggregate operations (like filter, map, reduce, etc.)
to process data from collections (like List, Set) without modifying the original data source.

Stream Operations

1. Intermediate Operations

Performed between the start of the stream and the terminal operation.
Examples: `map()`, `filter()`, `distinct()`, `sorted()`, `limit()`

2. Terminal Operations

These end the stream pipeline.
Examples: `forEach()`, `collect()`, `reduce()`, `count()`


Example Flow:


oper1 -> oper2 -> oper3 -> oper4 -> terminal()


 `filter()`

The `filter()` method is used to select elements from a stream based on a given condition (predicate).
It returns a new stream with only matching elements.

 Example 6: Program on Streams with Basic Operations


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example24 {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 4);
        Stream<Integer> stream2 = Stream.of(new Integer[]{1, 2, 3, 4});
        System.out.println(stream2.count());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 50; i++) {
            list.add(i);
        }

        Stream<Integer> stream3 = list.stream();
        System.out.println(stream3.count());

        System.out.println(IntStream.range(1, 50).sum());
        System.out.println(IntStream.range(1, 50).average());

        List<Integer> evens = IntStream.range(1, 50)
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

Note: Once you operate a stream, it cannot be reused.


`map()`

The `map()` method is used to transform each element of a stream.
It applies a function to every element and returns a new stream with transformed values.



 Example 7: Streams with Default Methods Using Lists



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example25 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("thirty");
        list.add("thityone");

        List<String> l = list.stream()
            .filter(p -> p.startsWith("t"))
            .map(p -> p.toUpperCase())
            .collect(Collectors.toList());
        System.out.println(l);

        list.stream()
            .filter(p -> p.startsWith("t"))
            .map(p -> p.toUpperCase())
            .forEach(System.out::println);

        System.out.println(list.stream().anyMatch(p -> p.startsWith("t")));
        System.out.println(list.stream().allMatch(p -> p.startsWith("t")));
        System.out.println(list.stream().noneMatch(p -> p.startsWith("t")));
    }
}

`reduce()`

`reduce()` is a terminal operation in Java Streams.
It combines all elements into a single result using a `BinaryOperator`.


 Example 8: Program on `reduce()`


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Example26 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");

        Optional<String> reduce = list.stream()
            .reduce((s1, s2) -> s1 + "#" + s2);

        System.out.println(reduce.get());
    }
}

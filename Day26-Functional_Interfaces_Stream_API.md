a c
# Functional Interfaces & Stream API – Detailed Notes

---

## Functional Interfaces

A **Functional Interface** in Java is an interface that contains **only one abstract method**. These interfaces are used primarily for **lambda expressions** and **method references**.

###  Characteristics:
- Has only **one abstract method** (SAM - Single Abstract Method).
- Can have **default and static methods**.
- Annotated with `@FunctionalInterface` (optional but recommended).

###  Examples:
```java
@FunctionalInterface
interface MyFunctionalInterface {
    void execute(); // only one abstract method
}
```

###  Common Functional Interfaces in `java.util.function`:
| Interface       | Method     | Description |
|----------------|------------|-------------|
| `Predicate<T>` | `test(T t)`| Returns true/false based on input |
| `Consumer<T>`  | `accept(T t)`| Performs an action on input |
| `Supplier<T>`  | `get()`    | Returns a result of type T |
| `Function<T,R>`| `apply(T t)`| Takes input of type T and returns R |
| `BiFunction<T,U,R>`| `apply(T t, U u)`| Two inputs, one output |

### Use with Lambda Expressions:
```java
MyFunctionalInterface f = () -> System.out.println("Lambda Executed");
f.execute();
```

---

##  Stream API

The **Stream API** (introduced in Java 8) allows processing collections of data in a **functional style**.

### Key Features:
- **Functional-style operations** on collections.
- Supports operations like `filter`, `map`, `reduce`, etc.
- Does **not modify the original data**.
- **Lazy evaluation** of intermediate operations.

###  Stream Operations:

**1. Creation:**
```java
List<Integer> list = Arrays.asList(1, 2, 3, 4);
Stream<Integer> stream = list.stream();
```

**2. Intermediate Operations:**
- `filter(Predicate)` – Filters elements.
- `map(Function)` – Transforms elements.
- `sorted()` – Sorts elements.

**3. Terminal Operations:**
- `collect(Collectors.toList())` – Collects results into a list.
- `forEach(Consumer)` – Performs an action on each element.
- `count()` – Returns number of elements.
- `reduce()` – Combines elements.

### Example:
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

List<String> result = names.stream()
    .filter(name -> name.startsWith("A"))
    .map(String::toUpperCase)
    .collect(Collectors.toList());

System.out.println(result); // [ALICE]
```

---

## Benefits of Functional Interfaces & Streams:
- Enables **clean and readable** code.
- Promotes **declarative programming**.
- Facilitates **parallel execution** (using `.parallelStream()`).
- Reduces **boilerplate code**.

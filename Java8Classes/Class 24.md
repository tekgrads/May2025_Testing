# Class 24: (10/7/25)

## JAVA 8:
- Brought many changes to the way of programming.
- There are 3 languages:
  1. Scripting
  2. Procedural
  3. OOPL
- In procedural language, we write code at a place and reuse or collect them wherever required.

**Before Java 8**, Sun Microsystems focused only on objects, but in version 1.8, Oracle gave importance to **functional programming** aspects.

---

## JAVA 8 New Features:
1. Lambda Expressions  
2. Functional Interfaces  
3. Default Methods  
4. Predicates  
5. Functions  
6. Double Colon Operator `(::)`  
7. Stream API  
8. Date and Time API, etc.

---

## Lambda Expressions (LE):

- Lambda calculus was a big change in mathematics (introduced in 1930).
- Due to its benefits, it slowly entered the programming world.
- **LISP** was the first language that used lambda expressions.
- Other languages that use LE:
  1. C#.NET
  2. C
  3. C++
  4. Python
  5. Ruby
  6. Java (since Java 8)

### **Main objective of LE**:  
> Bring functional programming benefits into Java.

### **What is a Lambda Expression?**
- It is just an **anonymous (nameless)** function.
- Means: no name, no return type, no access modifier.
- Also known as **anonymous functions** or **closures**.

---

### **No Parameters Example:**

```java
@FunctionalInterface
interface A {
    void m1();
}

public class Example1 {
    public static void main(String[] args) {
        A a = () -> System.out.println("lambda example");
        a.m1();
    }
}
```

---

### **With Parameters Example:**

```java
@FunctionalInterface
interface B {
    void add(int x, int y);
}

public class Ex2 {
    public static void main(String[] args) {
        B b = (x, y) -> System.out.println(x + y + " is the result");
        b.add(10, 20);
        b.add(30, 80);
    }
}
```

#### Output:
```
30 is the result  
110 is the result
```

---

### 🔹 Lambda Expressions Can:
- Have zero or more parameters
- Skip type declarations (Type Inference)
- Omit `{}` for single-line expressions

#### Examples:
```java
() -> System.out.println("Hi")
(a) -> System.out.println(a)
(a, b) -> a + b
```

---

### Java Method vs Lambda:

```java
// Java Method:
public String(String str) {
    return str;
}

// Lambda:
(str) -> str
```

---

### **Conclusion on LE:**
1. A lambda expression can have 0 or more parameters.  
   Example:
   ```java
   () -> System.out.println("hi");
   (int a) -> System.out.println(a);
   (int a, int b) -> { return a + b; }
   ```
2. Type is optional; compiler uses **context-based inference**.
3. Multiple parameters: use commas `,`.
4. No parameters: use `()`.
5. One parameter: parentheses `()` are optional.
6. Multiple statements: use `{}`.
7. Lambda expression behaves like a method and can be invoked.

---

## Functional Interfaces (FI):

- An interface with only **one abstract method** is called a Functional Interface.
- That method is called **Functional Method** or **SAM (Single Abstract Method)**.

### Examples of Functional Interfaces:
- `Runnable` – run()
- `Comparable` – compareTo()
- `Comparator` – compare()
- `ActionListener` – actionPerformed()
- `Callable` – call()

### Functional Interface Can Also Contain:
- Any number of `default` methods
- Any number of `static` methods

#### Example:
```java
interface Interf1 {
    void m1(); // SAM

    default void m2() {
        System.out.println("Hello");
    }
}
```

---

### Using `@FunctionalInterface` Annotation:

```java
package com.tekgrads;

@FunctionalInterface
interface D {
    void m1();

    default void m2() {
        System.out.println("this is a default method on functional interface");
    }

    static void m3() {
        System.out.println("this is a static method on functional interface");
    }
}

public class Example4 {
    public static void main(String[] args) {
        D d = () -> System.out.println("this is an abstract method");
        d.m1();
        d.m2();
        D.m3(); // static method accessed via interface name
    }
}
```

> Only one abstract method allowed in FI. More than one results in **compile-time error**.

---

## Functional Interface Inheritance:

1. If child interface **doesn't** define any new abstract method, it is also a **Functional Interface**.
```java
@FunctionalInterface
interface A {
    void m1();
}

@FunctionalInterface
interface B extends A {
    // No new abstract method
}
```

2. Cannot define a **new abstract method** in child:
```java
@FunctionalInterface
interface A {
    void m1();
}

@FunctionalInterface
interface B extends A {
    void m2(); // ❌ Compile-time error
}
```

> Restriction is **only** on abstract methods.

---

## Functional Interface vs Lambda Expression:

| Functional Interface              | Lambda Expression                |
|----------------------------------|----------------------------------|
| Follows single abstract method   | Function without name            |
| Interface reference is needed    | Can be used directly             |
| Compiler uses **type inference** | Allows type omission             |
| Needed to reference Lambda       | Defines actual functionality     |

---

## Anonymous Inner Class using Functional Interface:

```java
package com.tekgrads;

interface Interf3 {
    public void m1();
    // public void m2(); // Not allowed for lambda
}

public class Example3 {
    public static void main(String[] args) {
        Interf3 i = () -> System.out.println("in lambda Expression m1 method");
        i.m1();
    }
}
```

---

## Advantages of Lambda Expressions:

1. Reduced code length  
2. Improved readability  
3. Avoids complexity of anonymous inner classes (AIC)  
4. Can be used in place of object (for Functional Interface)

---

## Notes:
1. Anonymous Inner Class can:
   - Extend concrete/abstract class
   - Implement interface with multiple methods
2. Lambda Expressions can:
   - Implement only **Functional Interfaces**
3. AIC != LE
4. AIC can declare instance variables
5. In AIC, `this` refers to current class object

---

## Example: `this` keyword in AIC vs LE

```java
package com.tekgrads;

interface Interf4 {
    public void m1();
}

class Test3 {
    int x = 888;

    public void m2() {
        Interf4 i = new Interf4() {
            int x = 999;

            @Override
            public void m1() {
                System.out.println(this.x); // 999 (AIC context)
            }
        };
        i.m1();
    }
}

class Test4 {
    int x = 888;

    public void m2() {
        int y = 20;

        Interf4 i2 = () -> {
            int x = 999;
            // y = 200; // Error: lambda captures local variable y
            System.out.println(this.x); // 888 (outer class context)
            System.out.println(y);     // 20
        };
        i2.m1();
    }
}

public class Example4 {
    public static void main(String[] args) {
        Test3 t3 = new Test3();
        t3.m2();

        Test4 t4 = new Test4();
        t4.m2();
    }
}
```

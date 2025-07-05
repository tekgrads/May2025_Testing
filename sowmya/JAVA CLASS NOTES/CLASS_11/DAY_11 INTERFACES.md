

---

## Interfaces

To avoid multiple inheritance, we can use interfaces in Java.

An interface defines a set of abstract methods that a class must implement if it declares to implement that interface. Interfaces are declared using the `interface` keyword.

### Characteristics of Interfaces

1. **Abstraction**: Defines what a class should do, without specifying how.
2. **Abstract Methods**:

   * Prior to Java 8: only abstract methods and static final constants allowed.
   * From Java 8: default and static methods also allowed.
3. **No Instantiation**: Cannot create objects of interfaces.
4. **Implementation**: Classes use `implements` to adhere to an interface's contract.
5. **Multiple Inheritance**: A class can implement multiple interfaces.

---

## Example 1: Basic Interface Implementation

```java
interface A {
    public abstract void m1();
    int x = 10;
    void m2();
    abstract void m3();
}

class B implements A {
    public void m1() {
        System.out.println("method1 on class B");
    }
    public void m2() {
        System.out.println("method2 on class B");
    }
    public void m3() {
        System.out.println("method3 on class B");
    }
}

class Main1 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
        b.m3();
        System.out.println("value of x is :" + A.x);
    }
}
```

### Output

```
method1 on class B
method2 on class B
method3 on class B
value of x is :10
```

---

## Example 2: Multiple Interfaces

```java
interface A {
    void m1();
    void m2();
}

interface B {
    void m3();
    void m4();
}

class C implements A, B {
    public void m1() {
        System.out.println("method1 on class C");
    }
    public void m2() {
        System.out.println("method2 on class C");
    }
    public void m3() {
        System.out.println("method3 on class C");
    }
    public void m4() {
        System.out.println("method4 on class C");
    }
}

class Main2 {
    public static void main(String[] args) {
        C c = new C();
        c.m1();
        c.m2();
        c.m3();
        c.m4();
    }
}
```

### Output

```
method1 on class C
method2 on class C
method3 on class C
method4 on class C
```

---

## Example 3: Interface Extending Another Interface

```java
interface A {
    public void m1();
    static void m2() {
        System.out.println("the method2 on interface A");
    }
}

interface B extends A {
    public void m3();
    static void m4() {
        System.out.println("the static method on interface B");
    }
}

class C implements A, B {
    public void m1() {
        System.out.println("method1 on class C");
    }
    public void m3() {
        System.out.println("method3 on class C");
    }
    static void m2() {
        System.out.println("the method2 on class C");
    }
    static void m4() {
        System.out.println("the method4 on class C");
    }
}

class Main3 {
    public static void main(String[] args) {
        C c = new C();
        c.m1();
        c.m3();
        A.m2();
        B.m4();
    }
}
```

### Output

```
method1 on class C
method3 on class C
the method2 on interface A
the static method on interface B
```

---

## Example 4: Interface Inheritance Chain

```java
interface A {
    public void m1();
    public void m2();
}

interface B extends A {
    public void m3();
}

class C implements B {
    public void m1() {
        System.out.println("method1 on class C");
    }
    public void m2() {
        System.out.println("method2 on class C");
    }
    public void m3() {
        System.out.println("method3 on class C");
    }
}

class Main4 {
    public static void main(String[] args) {
        C c = new C();
        c.m1();
        c.m2();
        c.m3();
    }
}
```

### Output

```
method1 on class C
method2 on class C
method3 on class C
```

---

## Example 5: Class + Multiple Interfaces

```java
class A {
    void m1() {
        System.out.println("method1 on class A");
    }
}

interface B {
    void m2();
}

interface C {
    void m3();
}

class D extends A implements B, C {
    public void m1() {
        System.out.println("method1 on class D");
    }
    public void m2() {
        System.out.println("method2 on class D");
    }
    public void m3() {
        System.out.println("method3 on class D");
    }
}

class Main5 {
    public static void main(String[] args) {
        D d = new D();
        d.m1();
        d.m2();
        d.m3();
        A a = new A();
        a.m1();
    }
}
```

### Output

```
method1 on class D
method2 on class D
method3 on class D
method1 on class A
```

---

## Example 6: One Class, One Interface

```java
class A {
    void m1() {
        System.out.println("method1 on class A");
    }
}

interface B {
    void m2();
    public void m3();
}

class C extends A implements B {
    void m1() {
        System.out.println("method1 on class C");
    }
    public void m2() {
        System.out.println("method2 on class C");
    }
    public void m3() {
        System.out.println("method3 on class C");
    }
}

class Main6 {
    public static void main(String[] args) {
        C c = new C();
        c.m1();
        c.m2();
        c.m3();
        A a = new A();
        a.m1();
    }
}
```

### Output

```
method1 on class C
method2 on class C
method3 on class C
method1 on class A
```

---

## Example 7: Abstract Class and Interface

```java
abstract class A {
    public abstract void m1();
}

interface B {
    void m2();
}

class C extends A implements B {
    public void m1() {
        System.out.println("method1 on class C");
    }
    public void m2() {
        System.out.println("method2 on class C");
    }
}

class Main7 {
    public static void main(String[] args) {
        C c = new C();
        c.m1();
        c.m2();
    }
}
```

### Output

```
method1 on class C
method2 on class C
```

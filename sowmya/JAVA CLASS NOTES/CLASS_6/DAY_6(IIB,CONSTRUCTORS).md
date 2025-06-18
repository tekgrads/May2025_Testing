# Java Concepts: Markdown for GitHub

---

## 1. Instance Initialization Blocks (IIBs)

Instance Initialization Blocks (IIBs) in Java are code blocks that run every time an object is created. They help initialize instance variables and perform common setup code.

**Characteristics:**

* **Execution Time:** After superclass constructor and before current class constructor.
* **Multiple Blocks:** Executed in the order they appear.
* **Common Logic:** Avoid duplication across constructors.
* **Compilation:** Copied into all constructors after the `super()` call.

---

## 2. Constructors

Constructors initialize objects when created with the `new` keyword. They have the same name as the class and no return type.

**Types of Constructors:**

* **Default Constructor:** Provided by the compiler if none is written. Initializes values to defaults.
* **Parameterized Constructor:** Accepts arguments to initialize variables.

**Example: Default Constructor**

```java
public class F {
   int i;
   F() {
       i = 10;
   }
   public static void main(String[] args) {
       F f = new F();
       System.out.println("value of i is: " + f.i);
   }
}
```

**Output:**

```
value of i is: 10
```

**Example: Parameterized Constructor**

```java
public class P {
   int i;
   P() {
       System.out.println("default constructor value");
       i = 10;
   }
   P(int i) {
       System.out.println("parameterized constructor i value is:");
       this.i = i;
   }
   public static void main(String[] args) {
       P p = new P();
       System.out.println("value of i using default constructor is " + p.i);
       P p1 = new P(15);
       System.out.println("value of i using parameterized constructor is " + p1.i);
       P p2 = new P(90);
       System.out.println("value of i using parameterized constructor is " + p2.i);
   }
}
```

**Note:** If you define a parameterized constructor, Java will **not** provide a default constructor.

---

## 3. `this` Keyword

The `this` keyword refers to the current object.

**Key Points:**

* Not used in static methods.
* Reserved keyword.
* Refers to the current instance.

**Example:**

```java
public class T {
   int x;
   public T(int x) {
       this.x = x;
   }
   public static void main(String[] args) {
       T t = new T(10);
       System.out.println("the value of t is: " + t.x);
   }
}
```

**Output:**

```
the value of t is: 10
```

---

## 4. Combination of SIBs, IIBs, Static and Non-Static Variables, Constructors

```java
public class C {
  int i = 2;
  static int j = 3;

  // IIB
  {
    System.out.println("IIB-BLOCK");
    i = 20;
    System.out.println("value of i in IIB BLOCK is " + i);
  }

  // SIB
  static {
    System.out.println("SIB-BLOCK");
    j = 30;
    System.out.println("value of j in SIB BLOCK is " + j);
  }

  // Constructors
  C() {
    System.out.println("the default constructor value is ");
    i = 10;
  }
  C(int i) {
    System.out.println("parameterized constructor value is ");
    this.i = i;
  }

  public static void main(String[] args) {
    C c = new C();
    System.out.println("Value of i is: " + c.i);
    C c1 = new C(35);
    System.out.println("value of i in parameterized constructor is: " + c1.i);
    C c2 = new C(40);
    System.out.println("value of i in parameterized constructor is: " + c2.i);
    System.out.println("Value of j in SIB block is: " + C.j);
  }
}
```

---

## 5. Constructor Overloading

Constructor overloading allows multiple constructors with different parameter lists.

**Example:**

```java
public class H {
  int i;
  H() {
    System.out.println("Non-parameterized constructor ");
    i = 10;
    System.out.println("Instance variable i initialized to: " + i);
  }
  H(int i) {
    this.i = i;
    System.out.println("Parameterized constructor ");
    System.out.println("Instance variable i initialized to: " + this.i);
  }
  {
    System.out.println("IIB BLOCK-1");
  }
  {
    System.out.println("IIB BLOCK-2");
    System.out.println();
  }
  public static void main(String[] args) {
    H h1 = new H();
    System.out.println("Value of i: " + h1.i);
    H h2 = new H(20);
    System.out.println("Value of i: " + h2.i);
    H h3 = new H(30);
    System.out.println("Value of i: " + h3.i);
  }
}
```

---

## 6. Polymorphism

Polymorphism means the same method or constructor name behaving differently based on arguments.

**Example:**

```java
public class I {
  int i;
  I(int i) {
    System.out.println("Parameterized constructor called ");
    this.i = i;
    System.out.println("Instance variable i initialized to: " + this.i);
  }
  I() {
    this(10);
    System.out.println("Non-parameterized constructor");
    System.out.println("Instance variable i initialized to: " + this.i);
  }
  {
    System.out.println("IIB BLOCK-1");
  }
  {
    System.out.println("IIB BLOCK-2");
    System.out.println();
  }
  public static void main(String[] args) {
    I i1 = new I();
    System.out.println("Value of i: " + i1.i);
    I i2 = new I(20);
    System.out.println("Value of i: " + i2.i);
    I i3 = new I(30);
    System.out.println("Value of i: " + i3.i);
  }
}
```

---

### Notes

* Always use `this()` as the first line in a constructor when calling another constructor.
* If not, the instance initialization block executes first.
* Constructor overloading enables flexible object creation.

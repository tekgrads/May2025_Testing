
**Java Notes: IIBs, Constructors, this Keyword, SIBs, Variables, Constructor Overloading, and Polymorphism**

---

### 1. **Instance Initialization Block (IIB)**

**Definition:**
An Instance Initialization Block is a block that is executed **each time an object is created**, *before the constructor is called*. It is written inside the class but **outside any method or constructor**.

**Syntax:**

```java
{
    // your code
}
```

**Use:** Commonly used to initialize instance variables.

**Example:** `Class G`, `Class H`, and `Class I` contain IIBs.

---

### 2. **Constructors**

**Definition:**
A constructor is a special method that gets called when an object is created. It **initializes** the object.

**Types:**

- **Non-parameterized Constructor** – No arguments.
- **Parameterized Constructor** – Takes parameters.

**Syntax:**

```java
ClassName() { ... }             // Non-parameterized
ClassName(type var) { ... }     // Parameterized
```

**Examples:** All 4 classes (`F`, `G`, `H`, `I`) show both types.

---

### 3. **this Keyword**

**Definition:**
`this` is a reference variable that refers to the **current object**. Used when instance variable names clash with constructor parameters.

**Syntax:**

```java
this.i = i;
```

**Use Case:** Helps in differentiating between class variables and local parameters.

**Examples:** Used in constructors in `F`, `G`, `H`, `I` classes.

---

### 4. **Static Initialization Block (SIB)**

**Definition:**
Static blocks are executed **once**, when the class is loaded.

**Syntax:**

```java
static {
    // code
}
```

**Use:** Used to initialize **static variables**.

**Example:** `Class G` has a SIB to initialize `j`.

---

### 5. **Variables in Java**

- **Instance Variables** – Declared inside a class but outside methods.
- **Static Variables** – Declared with the `static` keyword, shared among all objects.

**Examples:**

- `int i` → instance variable in all classes.
- `static int j` → static variable in class `G`.

---

### 6. **Constructor Overloading**

**Definition:**
Constructor overloading means creating multiple constructors with **different parameter lists** in the same class.

**Use Case:** To allow object initialization in different ways.

**Examples:** Seen in all 4 classes.

---

### 7. **Polymorphism (Compile-Time)**

**Definition:**
Polymorphism means the ability to take many forms. Compile-time polymorphism is achieved through **method or constructor overloading**.

**Example:**

```java
F() {}
F(int i) {}
```

This is an example of **constructor overloading** (compile-time polymorphism).

---

### ✔️ CODE EXAMPLES

#### ✅ Class F (Constructor Overloading with `this` keyword)

```java
public class F {
    int i;

    F() {
        System.out.println("Non-parameterized constructor called F()");
        i = 10;
    }

    F(int i) {
        System.out.println("Parameterized constructor called F(int i)");
        this.i = i;
    }

    public static void main(String[] args) {
        F f = new F();
        System.out.println("Value of i: " + f.i);
        F f2 = new F(20);
        System.out.println("Value of i: " + f2.i);
        F f3 = new F(30);
        System.out.println("Value of i: " + f3.i);
    }
}
```

#### ✅ Class G (With SIB, IIB, and instance/static vars)

```java
public class G {
    int i = 5;
    static int j = 20;

    G() {
        System.out.println("Non-parameterized constructor called G()");
        i = 10;
    }

    G(int i) {
        System.out.println("Parameterized constructor called G(int i)");
        this.i = i;
    }

    {
        System.out.println("Instance initializer block called");
        i = 15;
        System.out.println("Instance variable i initialized to: " + i);
    }

    static {
        System.out.println("Static initializer block called");
        j = 30;
        System.out.println("Static variable j initialized to: " + j);
    }

    public static void main(String[] args) {
        G g = new G();
        System.out.println("Value of i: " + g.i);
        G g2 = new G(20);
        System.out.println("Value of i: " + g2.i);
        G g3 = new G(30);
        System.out.println("Value of i: " + g3.i);
        System.out.println("Value of j: " + G.j);
    }
}
```

#### ✅ Class H (Multiple IIBs, Constructor Overloading)

```java
public class H {
    int i;

    H() {
        System.out.println("Non-parameterized constructor called H()");
        i = 10;
        System.out.println("Instance variable i initialized to: " + i);
    }

    H(int i) {
        System.out.println("Parameterized constructor called H(int i)");
        this.i = i;
        System.out.println("Instance variable i initialized to: " + this.i);
    }

    {
        System.out.println("Instance initializer block-1 called");
    }

    {
        System.out.println("Instance initializer block-2 called");
    }

    public static void main(String[] args) {
        H h = new H();
        System.out.println("Value of i: " + h.i);
        H h2 = new H(20);
        System.out.println("Value of i: " + h2.i);
        H h3 = new H(30);
        System.out.println("Value of i: " + h3.i);
    }
}
```

#### ✅ Class I (Constructor Chaining using `this()`)

```java
public class I {
    int i;

    I(int i) {
        System.out.println("Parameterized constructor called I(int i)");
        this.i = i;
        System.out.println("Instance variable i initialized to: " + this.i);
    }

    I() {
        this(10); // Constructor chaining
        System.out.println("Non-parameterized constructor called I()");
        System.out.println("Instance variable i initialized to: " + this.i);
    }

    {
        System.out.println("Instance initializer block-1 called");
    }

    {
        System.out.println("Instance initializer block-2 called");
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

# INHERITANCE, METHOD OVERRIDING, MULTILEVEL INHERITANCE, ACCESSING STATIC AND NON-STATIC VARIABLES ON SUPER CLASSES, SUPER KEYWORD

---

## INHERITANCE

### 1. What is Inheritance?

In Java, inheritance allows one class to acquire the properties (fields) and functionalities (methods) of another. We classify this concept into:

* **Subclass (Child)**: Inherits from another class.
* **Superclass (Parent)**: The class being inherited from.

Use the `extends` keyword to inherit from a class.

#### How It Works:

When a subclass extends a superclass, it can access public and protected members. This enables:

* **Code reuse**
* **Method overriding**
* **Extending functionality**

#### Benefits of Inheritance:

* **Code Reusability**: Avoids redundancy.
* **Polymorphism**: Enables uniform interface.
* **Code Modularity**: Encourages clean structure.
* **Extensibility**: Easy to add new features.

---

### 2. Types of Inheritance

#### 1. Single Inheritance

One child class inherits from one parent class.

```
|---------------|
|   class A     |
|---------------|
       |
|---------------|
|   class B     |
|---------------|
```

#### 2. Multilevel Inheritance

A chain of inheritance.

```
|---------------|
|   class A     |
|---------------|
       |
|---------------|
|   class B     |
|---------------|
       |
|---------------|
|   class C     |
|---------------|
```

#### 3. Multiple Inheritance (via interfaces only in Java)

One class inherits from more than one class/interface.

```
|---------------|       |---------------|
|   class A     |       |   class B     |
|---------------|       |---------------|
       \               /
    |-----------------------|
    |       class C         |
    |-----------------------|
```

#### 4. Hierarchical Inheritance

Multiple classes inherit from one superclass.

```
|-----------------|
|    class A      |
|-----------------|
   /    |     \
|--|  |--|  |--|
|B |  |C |  |D |
|--|  |--|  |--|
```

#### 5. Hybrid Inheritance

Combination of multiple types (achieved via interfaces in Java).

```
|----------------|
|   class A      |
|----------------|
     /     \
|--|       |--|
|B |       |C |
|--|       |--|
     \     /
   |------------|
   |   class D  |
   |------------|
```

---

### Example: Single Inheritance

```java
class S {
    int i;
}

class P extends S {
    int j;
}

public class Main {
    public static void main(String[] args) {
        S s1 = new S();
        P p1 = new P();
        s1.i = 10;
        p1.i = 20;
        p1.j = 30;

        System.out.println("Value of i in S: " + s1.i);
        System.out.println("Value of i in P: " + p1.i);
        System.out.println("Value of j in P: " + p1.j);
    }
}
```

**Output:**

```
Value of i in S: 10
Value of i in P: 20
Value of j in P: 30
```

---

### Example: Multilevel Inheritance

```java
class M {
    M() {
        System.out.println("Default constructor in class M");
    }
    {
        System.out.println("IIB block in M");
    }
    static {
        System.out.println("SIB block in M");
    }
}

class C extends M {
    C() {
        System.out.println("Default constructor in class C");
    }
    {
        System.out.println("IIB block in C");
    }
    static {
        System.out.println("SIB block in C");
    }
}

class G extends C {
    G() {
        System.out.println("Default constructor in class G");
    }
    {
        System.out.println("IIB block in G");
    }
    static {
        System.out.println("SIB block in G");
    }
}

public class Main1 {
    public static void main(String[] args) {
        System.out.println("Creating instance of M:");
        M m = new M();

        System.out.println("Creating instance of C:");
        C c = new C();

        System.out.println("Creating instance of G:");
        G g = new G();
    }
}
```

**Output:** *(order due to static and instance blocks)*

```
Creating instance of M:
SIB block in M
IIB block in M
Default constructor in class M
Creating instance of C:
SIB block in C
IIB block in M
Default constructor in class M
IIB block in C
Default constructor in class C
Creating instance of G:
SIB block in G
IIB block in M
Default constructor in class M
IIB block in C
Default constructor in class C
IIB block in G
Default constructor in class G
```

---

### Example: Hierarchical Inheritance

```java
class H {
    H() {
        System.out.println("Default constructor in class H");
    }
    {
        System.out.println("IIB block in H");
    }
    static {
        System.out.println("SIB block in H");
    }
}

class C1 extends H {
    C1() {
        System.out.println("Default constructor in class C1");
    }
    {
        System.out.println("IIB block in C1");
    }
    static {
        System.out.println("SIB block in C1");
    }
}

class C2 extends H {
    C2() {
        System.out.println("Default constructor in class C2");
    }
    {
        System.out.println("IIB block in C2");
    }
    static {
        System.out.println("SIB block in C2");
    }
}

class C3 extends H {
    C3() {
        System.out.println("Default constructor in class C3");
    }
    {
        System.out.println("IIB block in C3");
    }
    static {
        System.out.println("SIB block in C3");
    }
}

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Creating instance of child1:");
        C1 a = new C1();

        System.out.println("\nCreating instance of child2:");
        C2 b = new C2();

        System.out.println("\nCreating instance of child3:");
        C3 c = new C3();
    }
}
```

**Output:**

```
Creating instance of child1:
SIB block in H
SIB block in C1
IIB block in H
Default constructor in class H
IIB block in C1
Default constructor in class C1

Creating instance of child2:
SIB block in C2
IIB block in H
Default constructor in class H
IIB block in C2
Default constructor in class C2

Creating instance of child3:
SIB block in C3
IIB block in H
Default constructor in class H
IIB block in C3
Default constructor in class C3
```

---

### Note

> Java does **not support multiple inheritance** with classes to avoid ambiguity. However, it does support multiple inheritance using \*\*interfaces




# Method Overriding

**Method Overriding:**

Overriding is a feature that allows a subclass or child class to provide a specific implementation of a method that is already provided by one of its superclasses or parent classes.

### Characteristics and Rules

1. **Inheritance**: Method overriding can only occur within an inheritance hierarchy, meaning a subclass overrides a method of its superclass.
2. **Same Signature**: The overriding method in the subclass must have the exact same method signature (name, number, and type of parameters) as the method in the superclass.
3. **Same or Covariant Return Type**: The return type of the overriding method must be the same as, or a covariant subtype of, the return type of the overridden method in the superclass.
4. **Access Modifier**: The access modifier of the overriding method cannot be more restrictive than the overridden method's access level.

   * Example: if the superclass method is `protected`, the overriding method can be `protected` or `public`, but not `private`.
5. **Exceptions**: The overriding method can throw the same checked exceptions, a subclass of those exceptions, or no checked exceptions at all. It cannot throw new checked exceptions that are broader than those declared in the superclass method.
6. **@Override Annotation**: Good practice to help the compiler verify that a method is indeed overriding a superclass method.

### Program Example

```java
// Method Overriding
class O {
    int i = 10;
    void show() {
        System.out.println("this is in super class");
    }
}

class A extends O {
    int j = 20;
    @Override
    void show() {
        System.out.println("this is a sub class");
    }
}

class Main4 {
    public static void main(String[] args) {
        O o = new O();
        A a = new A();
        System.out.println("the value of i is " + o.i);
        System.out.println("the value of i in subclass is " + a.i);
        System.out.println("the value of j in sub class is " + a.j);
    }
}
```

**Output:**

```
the value of i is 10
the value of i in subclass is 10
the value of j in sub class is 20
```

---

# Accessing Static and Non-Static Variables on Super Classes

Static variables can be accessed using the class name: `A.i`
Non-static variables are accessed using an object reference: `a.i`

### Program Example

```java
class J {
    int i;
    static int j;

    static {
        System.out.println("J SIB BLOCK");
    }

    J() {
        System.out.println("J constructor");
    }

    {
        System.out.println("J IIB -BLOCK");
    }
}

class K extends J {
    int k;
    static int l;

    K() {
        this(10);
        System.out.println("K constructor");
    }

    K(int k) {
        this.k = k;
        System.out.println("K's constructor with parameter: " + k);
    }

    static {
        System.out.println("K SIB-BLOCK");
    }

    {
        System.out.println("K IIB-BLOCK");
    }
}

class Main5 {
    public static void main(String[] args) {
        System.out.println("Creating instance of J:");
        J j = new J();
        System.out.println("J class instance variable i: " + j.i + ", static variable j: " + J.j);

        System.out.println("\nCreating instance of K:");
        K k = new K();
        System.out.println("K class instance variable k: " + k.k + ", static variable l: " + K.l);
        System.out.println("J class instance variable i: " + k.i);
        System.out.println("J class Static variable j accessing using K: " + K.j);

        K.j = 10;
        System.out.println("J class Static variable j after modification: " + J.j);
    }
}
```

**Output:**

```
Creating instance of J:
J SIB BLOCK
J IIB -BLOCK
J constructor
J class instance variable i: 0, static variable j: 0

Creating instance of K:
K SIB-BLOCK
J IIB -BLOCK
J constructor
K IIB-BLOCK
K's constructor with parameter: 10
K constructor
K class instance variable k: 10, static variable l: 0
J class instance variable i: 0
J class Static variable j accessing using K: 0
J class Static variable j after modification: 10
```

---

# Super Keyword

The `super` keyword in Java is used within a subclass to refer to the immediate parent class.

### Uses of `super`:

1. **Calling Superclass Constructor**

   * `super()` must be the first statement in the subclass constructor.
2. **Accessing Superclass Methods**

   * Call overridden methods using `super.methodName()`.
3. **Accessing Superclass Variables**

   * Use `super.variableName` to refer to superclass variables when hidden by subclass variables.

### Program Example

```java
class K {
    int i = 5;
    K() {
        System.out.println("default constructor in super class");
    }

    void print() {
        System.out.println("This is super class");
    }
}

class L extends K {
    int i = 10;
    L() {
        System.out.println("default constructor in L");
    }

    @Override
    void print() {
        System.out.println("this is subclass");
    }

    public void display() {
        System.out.println("Subclass value is : " + this.i);
        System.out.println("Superclass value is : " + super.i);
    }
}

class Main6 {
    public static void main(String[] args) {
        L l = new L();
        l.print();
        l.display();
    }
}
```

**Output:**

```
default constructor in super class
default constructor in L
this is subclass
Subclass value is : 10
Superclass value is : 5
```

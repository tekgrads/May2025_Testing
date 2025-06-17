
# Day 7 – Java Notes

## INHERITANCE

### 1. What is Inheritance?

In Java, inheritance allows one class to acquire the properties (fields) and functionalities (methods) of another.

- **Subclass (Child)**: Inherits from another class.
- **Superclass (Parent)**: The class being inherited from.
- Use the `extends` keyword to inherit from a class.

#### Benefits:
- Code Reusability
- Polymorphism
- Code Modularity
- Extensibility

### 2. Types of Inheritance

- **Single Inheritance**
- **Multilevel Inheritance**
- **Multiple Inheritance** (via interfaces)
- **Hierarchical Inheritance**
- **Hybrid Inheritance** (via interfaces)

#### Example: Single Inheritance
```java
class S {
    int i;
}
class P extends S {
    int j;
}
```

#### Example: Multilevel Inheritance
```java
class M {
    M() { System.out.println("Default constructor in class M"); }
}
class C extends M {
    C() { System.out.println("Default constructor in class C"); }
}
class G extends C {
    G() { System.out.println("Default constructor in class G"); }
}
```

#### Example: Hierarchical Inheritance
```java
class H {}
class C1 extends H {}
class C2 extends H {}
class C3 extends H {}
```

## METHOD OVERRIDING

### What is Method Overriding?

A subclass provides a specific implementation of a method already provided by its superclass.

### Rules:

- Must have the same signature
- Return type must be same or covariant
- Access modifier should not be more restrictive
- @Override is optional but recommended

#### Example:
```java
class O {
    void show() { System.out.println("super class"); }
}
class A extends O {
    @Override
    void show() { System.out.println("sub class"); }
}
```

## ACCESSING STATIC AND NON-STATIC VARIABLES ON SUPER CLASSES

- Static variables: `ClassName.variable`
- Non-static variables: `object.variable`

#### Example:
```java
class J {
    int i;
    static int j;
}
class K extends J {
    int k;
    static int l;
}
```

## SUPER KEYWORD

Used to refer to immediate parent class.

### Uses:
- `super()` to call parent constructor
- `super.method()` to call parent method
- `super.variable` to access hidden variables

#### Example:
```java
class K {
    int i = 5;
}
class L extends K {
    int i = 10;
    void display() {
        System.out.println(super.i);
    }
}
```

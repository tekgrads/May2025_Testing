
# 📚 Abstract Classes & Interfaces in Java

## 🔷 Abstract Classes

### ✅ What is an Abstract Class?
An abstract class is declared using the `abstract` keyword. It cannot be instantiated directly and may contain both:

- Abstract methods (no implementation)
- Concrete methods (with implementation)

### 💡 Example 1: Abstract + Concrete Methods
```java
abstract class A {
    abstract void m1(); 
    void m2() {
        System.out.println("method2 on abstract method");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("method1 is calling on subclass");
    }
}

class Main1 {
    public static void main(String[] args) {
        B b = new B();
        b.m1();
        b.m2();
    }
}
```
✅ **Output:**
```
method1 is calling on subclass  
method2 on abstract method
```

### 💡 Example 2: Multiple Abstract Methods
```java
abstract class A {
    abstract void m1();
    abstract void m2();
    public void m3() {
        System.out.println("method 3 is calling on abstract");
    }
    public void m4() {
        System.out.println("method 4 is calling on abstract");
    }
}

class B extends A {
    @Override
    void m1() { System.out.println("method1 is calling on subclass B"); }
    @Override
    void m2() { System.out.println("method 2 is calling on subclass"); }
}
```
✅ **Output:**
```
method1 is calling on subclass B  
method 2 is calling on subclass  
method 3 is calling on abstract  
method 4 is calling on abstract
```

### 💡 Example 3: Two Abstract Classes
```java
abstract class A {
    abstract void m1();
    void m2() {
        System.out.println("method on class A");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("method1 on subclass");
    }
}

abstract class C {
    void m1_C() {
        System.out.println("Abstract method on class C");
    }
    void m2_C() {
        System.out.println("abstract method on class C");
    }
}

class D extends C {
    @Override
    void m1_C() {
        System.out.println("method1 on C class");
    }

    @Override
    void m2_C() {
        System.out.println("method 2 on c class");
    }
}
```
✅ **Output:**
```
method1 on subclass  
method on class A  
method1 on C class  
method 2 on c class
```

### 💡 Example 4: Static and Instance Members
```java
abstract class A {
    static int y = 10;
    int x = 20;

    abstract void m1();
    void m2() {
        System.out.println("method2 on class A");
    }
    static void m3() {
        System.out.println("method 3 on static");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("method1 is calling in subclass");
    }
}
```
✅ **Output:**
```
method1 is calling in subclass  
method2 on class A  
method 3 on static  
The instance variable value is :20  
the static variable value is :10
```

### 💡 Example 5 & 6: Hierarchical Inheritance
```java
abstract class A {
    abstract void m1();
    abstract void m2();
    void m3() { System.out.println("method3 on abstract class"); }
    void m4() { System.out.println("method4 on abstract class"); }
}

abstract class B extends A {
    @Override
    void m1() {
        System.out.println("method1 on class B");
    }
}

abstract class C extends A {
    @Override
    void m2() {
        System.out.println("method2 on class c");
    }
}

class D extends B {
    @Override
    void m2() {
        System.out.println("method2 on class c");
    }
}

class E extends D {}
```
✅ **Output:**
```
method1 on class B  
method2 on class c  
method3 on abstract class  
method4 on abstract class
```

### 💡 Example 7: Static Methods in Child Class
```java
abstract class A {
    abstract void m1();
    static void m2() {
        System.out.println("the static method2 on abstract class");
    }
    void m3() {
        System.out.println("the concrete method on abstract class");
    }
}

class B extends A {
    @Override
    void m1() {
        System.out.println("the method1 on class B");
    }

    static void m2() {
        System.out.println("the static method on class B");
    }

    @Override
    void m3() {
        System.out.println("the concrete method on class B");
    }
}
```
✅ **Output:**
```
the method1 on class B  
the static method2 on abstract class  
the static method on class B  
the concrete method on class B
```

## 🔷 Interfaces

### ✅ What is an Interface?
An interface defines a contract that implementing classes must follow.  
Java interfaces can contain:

- Abstract methods (always public abstract)
- `public static final` variables
- Default methods (Java 8+)
- Static methods (Java 8+)

### 💡 Example: Interface Implementation
```java
interface A {
    void m1();
    int x = 10;
    void m2();
    void m3();
}

class B implements A {
    @Override
    public void m1() {
        System.out.println("method1 on class B");
    }

    @Override
    public void m2() {
        System.out.println("method2 on class B");
    }

    @Override
    public void m3() {
        System.out.println("method3 on class B");
    }
}
```
✅ **Output:**
```
method1 on class B  
method2 on class B  
method3 on class B  
value of x is :10
```

# Java Notes: Static Initialization Blocks, Object Creation, Memory Concepts & Variable Access

---

## 1. Static Initialization Block (SIB)
- Static blocks are executed **only once** when the class is **loaded into memory**.
- Used to **initialize static variables**.
- Syntax:
```java
class Example {
    static int a;
    static {
        a = 10;
        System.out.println("Static Block Executed");
    }
}
```
- **Multiple static blocks** execute **in order of appearance**.

---

## 2. Object Creation
- Object is an instance of a class.
- Created using `new` keyword:
```java
ClassName obj = new ClassName();
```
- Memory for object is allocated in the **heap**.
- Constructor is called after memory is allocated.

---

## 3. Out of Memory Error (OOM)
- Occurs when JVM runs out of heap space.
- Common causes:
  - Creating too many objects without freeing them.
  - Memory leaks.
- Error:
```java
java.lang.OutOfMemoryError: Java heap space
```

---

## 4. Execution Order of Multiple Static Blocks
```java
class Demo {
    static {
        System.out.println("Static Block 1");
    }
    static {
        System.out.println("Static Block 2");
    }
    public static void main(String[] args) {
        System.out.println("Main Method");
    }
}
```
**Output:**
```
Static Block 1
Static Block 2
Main Method
```

---

## 5. Accessing Local and Global Variables
- **Local variable:** Declared inside method, accessible only within that method.
- **Global variable (instance/static):** Declared outside methods but inside class.
```java
class Example {
    int globalVar = 100; // global

    void method() {
        int localVar = 50; // local
        System.out.println(localVar);  // ✅ Accessible
        System.out.println(globalVar); // ✅ Accessible
    }
}
```

---

## 6. Orphan Objects
- An object without any reference variable.
- Will be garbage collected.
```java
new Example(); // orphan object
```
- These objects are eligible for **GC (Garbage Collection)**.

---

## 7. Accessing Variables Across Classes
- Using **object reference**:
```java
class A {
    int x = 20;
}

class B {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.x);  // Access variable of class A
    }
}
```
- Or if variable is `static`, you can access directly using class name:
```java
class A {
    static int x = 100;
}

class B {
    public static void main(String[] args) {
        System.out.println(A.x);
    }
}
```

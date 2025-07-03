# 📘 Class 19: (03/07/2025)

## 🔷 OBJECT CLASS IN JAVA

- In Java, every class implicitly inherits from the `Object` class, which is the **root superclass** of all classes.
- It provides **common methods** that all Java objects inherit.

---

## 🧪 Example Code:

```java
public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.toString()); // Inherited from Object class
        System.out.println(s1); // Prints memory location (by default)
    }
}
```

---

## 🔹 Object Class Methods

### 1. `toString()`
- Automatically inherited from the Object class.
- Overriding `toString()` allows objects to print **meaningful output** instead of memory address.

#### ✅ Example:

```java
class B {
    int i, j;

    B(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public String toString() {
        return "i = " + i + ", j = " + j;
    }
}

public class Ex2 {
    public static void main(String[] args) {
        B b1 = new B(1, 2);
        System.out.println(b1);
    }
}
```

🧾 **Output:**
```
i = 1, j = 2
```

---

### 2. `equals(Object obj)`
- Default `equals()` checks memory location (same as `==`).
- To compare object contents, we **override** it.

#### ✅ Example:

```java
class C {
    int i;

    C(int i) {
        this.i = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C)) return false;
        return this.i == ((C) obj).i;
    }
}

public class Test {
    public static void main(String[] args) {
        C c1 = new C(1);
        C c2 = new C(1);

        System.out.println(c1 == c2);         // false
        System.out.println(c1.equals(c2));    // true
    }
}
```

---

### 3. `hashCode()`
- Returns an **integer hash value**.
- Used in: `HashMap`, `HashSet`, `Hashtable`.
- If `equals()` is overridden, **`hashCode()` must also be overridden**.

#### ✅ Example:

```java
class E {
    int i;

    E(int i) {
        this.i = i;
    }

    public int hashCode() {
        return Integer.toString(i).hashCode();
    }
}

public class Test {
    public static void main(String[] args) {
        E e1 = new E(10);
        System.out.println(e1.hashCode());
    }
}
```

---

### 4. `clone()`
- Creates a **copy** of an object (**shallow copy** by default).
- Class must:
  - Implement `Cloneable` interface.
  - Override `clone()` method.
- `Cloneable` is a **marker interface** (no methods).

---

### 📦 Example Code:

```java
class A implements Cloneable {
    int age = 25;

    A(int age) {
        this.age = age;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }
}

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a1 = new A(30);
        A a2 = (A) a1.clone();

        System.out.println("Original: " + a1.age);
        System.out.println("Cloned: " + a2.age);
    }
}
```

---

## 🔄 Insecure Operations
- Some operations like cloning sensitive data require **special permission** (e.g., OTP, etc.).

## 📦 Related Interfaces
- `Cloneable`: For enabling object cloning.
- `Serializable`: For passing objects over **network streams**.

---

## 🔄 Pass-by Concepts

### ✅ Pass-by-Value
- Java is **always pass-by-value**.
- A **copy of the variable's value** is passed to methods.
- Used with **primitive types**.
- Changes inside method do **not affect** original.

---

### 🚫 Pass-by-Reference (Not in Java)
- Means passing the **actual reference** (memory address).
- Java does **not support** true pass-by-reference.
- But objects seem like pass-by-reference due to reference copy behavior.

---

### 📋 Shallow Copy
- Copies the object and its fields.
- Does **not copy nested objects** (only references are copied).

```java
Object copy = original.clone(); // shallow copy
```

---

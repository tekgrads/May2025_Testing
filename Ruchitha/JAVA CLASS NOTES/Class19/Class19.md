
# Object Class in Java

The `Object` class is the superclass for all classes in Java. It provides several important methods, including:

## Key Methods in Object Class

1. `toString()`
2. `equals(Object obj)`
3. `hashCode()`
4. `clone()`

---

## `toString()` Method

- Automatically invoked when an object is printed.
- Defined in the `Object` class.

### Example 1: Default `toString()`

```java
package com.tekgrads;

class A {
    int i;
}

class Example1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.i);
        System.out.println(a); // Prints memory location
    }
}
```

### Example 2: Custom `toString()`

```java
package com.tekgrads;

class B {
    int i, j;

    B(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public String toString() {
        return "i=" + i + ", j=" + j;
    }
}

public class Example2 {
    public static void main(String[] args) {
        B b1 = new B(1, 2);
        System.out.println(b1);

        B b2 = new B(10, 20);
        System.out.println(b2);
    }
}
```

---

## `equals()` Method

### Example 3: Overriding equals

```java
package com.tekgrads;

class C {
    int i;
    C(int i) {
        this.i = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C)) {
            return false;
        }
        return this.i == ((C) obj).i;
    }
}

public class Example3 {
    public static void main(String[] args) {
        C c1 = new C(1);
        C c2 = new C(1);
        System.out.println(c1 == c2);       // false
        System.out.println(c1.equals(c2));  // true
    }
}
```

### Example 4: `equals()` and `toString()` Together

```java
package com.tekgrads;

class D {
    int i, j;

    D(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "D [i=" + i + ", j=" + j + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof D)) return false;
        return this.i == ((D) obj).i && this.j == ((D) obj).j;
    }
}

public class Example4 {
    public static void main(String[] args) {
        D d1 = new D(1, 2);
        D d2 = new D(1, 3);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1.equals(d2));  // false
    }
}
```

---

## `hashCode()` Method

### Example 5: Custom hashCode

```java
package com.tekgrads;

class E {
    int i, j;

    E(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int hashCode() {
        return Integer.toString(i).hashCode() + Integer.toString(j).hashCode();
    }
}

public class Example5 {
    public static void main(String[] args) {
        E e1 = new E(1, 2);
        E e2 = new E(1, 3);
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}
```

---

## `clone()` Method

- Produces a replica of the object.
- `Cloneable` is a marker interface.
- `clone()` is a protected method.

### Example 6: Basic Cloning

```java
package com.tekgrads;

class F implements Cloneable {
    int i;

    F(int i) {
        this.i = i;
    }

    public F cloneMyObj() throws CloneNotSupportedException {
        return (F) this.clone();
    }

    @Override
    public String toString() {
        return "F [i=" + i + "]";
    }
}

public class Example6 {
    public static void main(String[] args) throws CloneNotSupportedException {
        F f = new F(1);
        F f2 = f.cloneMyObj();
        System.out.println(f);
        System.out.println(f2);
    }
}
```

---

## Deep Copy

- Changes in one object do **not** affect the other.

### Example 7

```java
package com.tekgrads;

class G implements Cloneable {
    int i, j;

    G(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public G cloneMyObj() throws CloneNotSupportedException {
        return (G) this.clone();
    }

    @Override
    public String toString() {
        return "G [i=" + i + ", j=" + j + "]";
    }
}

public class Example7 {
    public static void main(String[] args) throws CloneNotSupportedException {
        G g1 = new G(1, 2);
        G g2 = g1.cloneMyObj();
        g2.i = 10;
        System.out.println(g1);
        System.out.println(g2);

        G g3 = g1;
        g3.i = 100;
        System.out.println(g1);
        System.out.println(g3);
    }
}
```

### Example 8: Value Modification and Primitive Type

```java
package com.tekgrads;

class H implements Cloneable {
    int i, j;

    H(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public H cloneMyObj() throws CloneNotSupportedException {
        return (H) this.clone();
    }

    @Override
    public String toString() {
        return "H [i=" + i + ", j=" + j + "]";
    }
}

public class Example8 {
    public static void main(String[] args) throws CloneNotSupportedException {
        H h1 = new H(1, 2);
        System.out.println(h1);
        chageHValues(h1);
        System.out.println("After executing chageHValues");
        System.out.println(h1);

        int i = 100;
        System.out.println("i =" + i);
        chagePrimitive(i);
        System.out.println("After executing chagePrimitive");
        System.out.println("i =" + i);
    }

    public static void chageHValues(H h2) {
        h2.i = 100;
        h2.j = 1000;
    }

    public static void chagePrimitive(int i) {
        i = 1000;
    }
}
```

---

## Shallow Copy

- Changes in one object **can** affect the other if they share references.

### Example 9

```java
package com.tekgrads;

class I implements Cloneable {
    int a;

    I(int a) {
        this.a = a;
    }

    public I cloneMyObj() throws CloneNotSupportedException {
        return (I) this.clone();
    }

    @Override
    public String toString() {
        return "I [a=" + a + "]";
    }
}

class J implements Cloneable {
    int b;
    I i;

    J(int b, I i) {
        this.b = b;
        this.i = i;
    }

    public J cloneMyObj() throws CloneNotSupportedException {
        return (J) this.clone();
    }

    @Override
    public String toString() {
        return "J [b=" + b + ", i=" + i + "]";
    }
}

public class Example9 {
    public static void main(String[] args) throws CloneNotSupportedException {
        I i1 = new I(1);
        I i2 = i1.cloneMyObj();
        i2.a = 100;

        J j1 = new J(2, i1);
        System.out.println("j1= " + j1);

        J j2 = j1.cloneMyObj();
        j2.i.a = 100;
        System.out.println("j1= " + j1);
        System.out.println("j2= " + j2);
    }
}
```

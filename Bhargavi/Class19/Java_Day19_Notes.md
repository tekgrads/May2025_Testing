☕ Day-19 – Object Class in Java

Object Class Overview

* `Object` class is the **superclass of all classes in Java.
* It acts as the **root class** for any Java class.

🔑Common Methods of Object Class

| Method               | Description                                   |
| -------------------- | --------------------------------------------- |
|  toString()          | Returns a string representation of the object |
|  equals(Object obj)  | Compares two objects for equality             |
|  hashCode()          | Returns the object's hash code                |
|  getClass()          | Returns the runtime class of the object       |
|  clone()             | Creates a copy of the object                  |


1️⃣toString() Method

* Automatically called when an object is printed.
* Override to print meaningful string instead of memory address.

 ✅ Example 1: Default `toString()` behavior

class A {
    int i;
}

public class Example1 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("The value of i is: " + a.i);
        System.out.println("The value of a is: " + a);
    }
}


✅ Example 2: Overriding `toString()`

class B {
    int i, j;
    B(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public String toString() {
        return "i=" + i + " and j=" + j;
    }
}

public class Example2 {
    public static void main(String[] args) {
        B a = new B(10, 20);
        System.out.println(a);
        B b = new B(20, 30);
        System.out.println(b);
    }
}

2️⃣ equals() Method

* Compares two objects for logical equality.
* Use `==` for reference comparison, `equals()` for content comparison (if overridden).

 ✅ Example 3: Overriding `.equals()`

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

public class Example3 {
    public static void main(String[] args) {
        C c1 = new C(10);
        C c2 = new C(10);
        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));
    }
}


 ✅ Example 4: Using `toString()` and `equals()`

class D {
    int i, j;
    D(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public String toString() {
        return "D [i=" + i + ", j=" + j + "]";
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof D)) return false;
        return this.i == ((D) obj).i && this.j == ((D) obj).j;
    }
}

public class Example4 {
    public static void main(String[] args) {
        D d1 = new D(100, 200);
        D d2 = new D(100, 200);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));
    }
}

3️⃣ hashCode() Method

* Returns an integer representation of the object's hash value.
* If two objects are equal, their hash codes must also be equal.

✅ Example 5: Custom `hashCode()`

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
        E e1 = new E(10, 25);
        E e2 = new E(10, 25);
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
    }
}

4️⃣ clone() Method

* Creates a copy of an object.
* Must implement `Cloneable` and override `clone()`.

✅ Example 6: Using `clone()`

class F implements Cloneable {
    int i;
    F(int i) {
        this.i = i;
    }
    public F cloneMyobj() throws CloneNotSupportedException {
        return (F) this.clone();
    }
    public String toString() {
        return "i=" + i;
    }
}

public class Example6 {
    public static void main(String[] args) throws CloneNotSupportedException {
        F a = new F(100);
        F b = a.cloneMyobj();
        System.out.println(a);
        System.out.println(b);
    }
}

Deep Copy

* Changing one object does not affect the other (independent values).



✅ Example 7: Deep Copy

class G implements Cloneable {
    int i;
    int j;

    G(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public G cloneMyObj() throws CloneNotSupportedException {
        return (G) this.clone();
    }

    @Override
    public String toString() {
        return "i=" + i + ", j=" + j;
    }
}

public class Example7 {
    public static void main(String[] args) throws CloneNotSupportedException {
        G g1 = new G(10, 20);
        G g2 = g1.cloneMyObj();
        System.out.println(g2);
        System.out.println(g1);

        g2.i = 30;
        System.out.println("After Changing g2 i value");
        System.out.println(g1);
        System.out.println(g2);

        G g3 = g1; // shallow copy (reference copy)
        g3.i = 40;

        System.out.println("After changing g3 i value");
        System.out.println(g1);
        System.out.println(g3);
    }
}

Pass by Reference

* Passes the actual object reference to a method.

✅ Example 8: Pass by Reference

class H implements Cloneable {
    int i;
    int j;

    H(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public H cloneMyObj() throws CloneNotSupportedException {
        return (H) this.clone();
    }

    @Override
    public String toString() {
        return "i=" + i + ", j=" + j;
    }
}

public class Example8 {
    public static void main(String[] args) throws CloneNotSupportedException {
        H h1 = new H(1, 2);
        System.out.println(h1);

        changeHValues(h1);

        System.out.println("After executing changeHValues");
        System.out.println(h1);
    }

    public static void changeHValues(H h2) {
        System.out.println("Entered in changeHValues");
        h2.i = 10;
        h2.j = 20;
        System.out.println("Exited from changeHValues");
    }
}

Pass by Value

* In Java, method arguments are passed by value.

✅ Example 9: Pass by Value

class I implements Cloneable {
    int i;
    int j;

    I(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public I cloneMyObj() throws CloneNotSupportedException {
        return (I) this.clone();
    }

    @Override
    public String toString() {
        return "i=" + i + ", j=" + j;
    }
}

public class Example9 {
    public static void main(String[] args) {
        I i1 = new I(10, 20);
        System.out.println(i1);

        int i = 100;
        System.out.println("i =" + i);
        changePrimitive(i);
        System.out.println("After executing changePrimitive");
        System.out.println("i =" + i);
    }

    public static void changePrimitive(int i) {
        System.out.println("Entered in changePrimitive");
        i = 1000;
        System.out.println("Exited from changePrimitive");
    }
}

Shallow Copy

* Cloned object shares reference to same inner objects.
* Changes in one affect the other.


✅ Example 10: Shallow Copy

class J implements Cloneable {
    int a;

    J(int a) {
        this.a = a;
    }

    public J cloneMyObj() throws CloneNotSupportedException {
        return (J) this.clone();
    }

    @Override
    public String toString() {
        return "a=" + a;
    }
}

class K implements Cloneable {
    int b;
    J i;

    K(int b, J i) {
        this.b = b;
        this.i = i;
    }

    public K cloneMyObj() throws CloneNotSupportedException {
        return (K) this.clone();
    }

    @Override
    public String toString() {
        return "b=" + b + ", i=" + i;
    }
}

public class Example10 {
    public static void main(String[] args) throws CloneNotSupportedException {
        J j1 = new J(10);
        J j2 = j1.cloneMyObj();
        j2.a = 100;

        K k1 = new K(20, j1);
        System.out.println("k1= " + k1);
        K k2 = k1.cloneMyObj();
        System.out.println("k2= " + k2);

        k2.i.a = 100;
        System.out.println("\nAfter modifying k2.i.a = 100");
        System.out.println("k1= " + k1);
        System.out.println("k2= " + k2);
    }
}




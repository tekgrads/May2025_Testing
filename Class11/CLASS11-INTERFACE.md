
# Java Interfaces

In Java, an **interface** is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types.

---

## 🔸 Key Points

- By default, interface members are `public` and `abstract`.
- Interfaces use the keyword `implements`.
- A class that implements an interface must provide implementations for all its methods.
- Variables declared in an interface are implicitly `public`, `static`, and `final`.

---

## 🔹 Example 1: Basic Interface Implementation

```java
interface A {
    int x = 10; // implicitly public static final
    void test1();
    abstract void test2();
    public abstract void test3();
}

class B implements A {
    @Override
    public void test1() {
        System.out.println("B.test1");
    }

    @Override
    public void test2() {
        System.out.println("B.test2");
    }

    @Override
    public void test3() {
        System.out.println("B.test3");
    }
}

public class Manager {
    public static void main(String[] args) {
        B b = new B();
        b.test1();
        b.test2();
        b.test3();
        System.out.println("Static variable x: " + A.x);

        System.out.println("Manager.main() completed successfully.");
    }
}
✅ Output:
B.test1
B.test2
B.test3
Static variable x: 10
Manager.main() completed successfully.
🔹 Example 2: Multiple Inheritance Using Interfaces
interface A {
    public void m1();
}

interface B {
    public void m2();
}

class C implements A, B {
    public void m1() {
        System.out.println("C.m1");
    }

    public void m2() {
        System.out.println("C.m2");
    }
}

public class Manager2 {
    public static void main(String[] args) {
        C c = new C();
        c.m1();
        c.m2();
        System.out.println("Manager2.main() completed successfully.");
    }
}
✅ Output:
C.m1
C.m2
Manager2.main() completed successfully.
🔹 Example 3: Interface with Class Inheritance
class O {
    void test1() {
        System.out.println("O.test1");
    }
}

interface P {
    void test2();
}

interface Q {
    void test3();
}

class R extends O implements P, Q {
    @Override
    public void test2() {
        System.out.println("R.test2");
    }

    @Override
    public void test3() {
        System.out.println("R.test3");
    }
}

public class Manager4 {
    public static void main(String[] args) {
        O o = new O();
        o.test1();

        R r = new R();
        r.test1();
        r.test2();
        r.test3();

        System.out.println("Manager4.main() completed successfully.");
    }
}
✅ Output:
O.test1
O.test1
R.test2
R.test3
Manager4.main() completed successfully.
🔹 Example 4: Inheritance + Interface
interface S {
    void test1();
}

class T {
    void test1() {
        System.out.println("T.test1");
    }
}

class U extends T implements S {
    @Override
    public void test1() {
        System.out.println("U.test1");
    }
}

public class Manager5 {
    public static void main(String[] args) {
        T t = new T();
        t.test1();

        U u = new U();
        u.test1();

        System.out.println("Manager5.main() completed successfully.");
    }
}
✅ Output:
T.test1
U.test1
Manager5.main() completed successfully.
🔹 Example 5: Interface + Abstract Class
interface V {
    void test1();
}

abstract class W {
    public abstract void test1();
}

class X extends W implements V {
    @Override
    public void test1() {
        System.out.println("X.test1");
    }
}

public class Manager6 {
    public static void main(String[] args) {
        X x = new X();
        x.test1();
        System.out.println("Manager6.main() completed successfully.");
    }
}
✅ Output:
X.test1
Manager6.main() completed successfully.
✅ Summary
Java doesn't support multiple inheritance with classes, but it can be achieved using interfaces.

Interfaces are ideal for defining a contract that other classes can implement.

Interfaces can work in combination with abstract classes to enhance flexibility.


Let me know if you’d like this saved as a `README.md` file.



No file chosenNo file chosen
ChatGPT can make mistakes. Check important info. See Cookie Preferences.

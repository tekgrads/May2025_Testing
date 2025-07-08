
# Java Notes: Duplicate Variable, LPA (Local Preference Algorithm), Variable Shadowing

---

## 1. Duplicate Variable

Two variables with the same name in the **same scope** will give a compilation error.

### Example:

```java
public class DuplicateVariableExample {
    public static void main(String[] args) {
        int x = 10;
        // int x = 20; // Error: variable x is already defined in the scope
        System.out.println(x);
    }
}
```

---

## 2. LPA – Local Preference Algorithm (used in networking, mainly BGP)

This is a **network routing concept** used to prefer routes within an autonomous system. Here's a simplified logic example.

### Example:

```java
class Route {
    String name;
    int localPref;

    public Route(String name, int localPref) {
        this.name = name;
        this.localPref = localPref;
    }
}

public class LPAExample {
    public static void main(String[] args) {
        Route r1 = new Route("PathA", 100);
        Route r2 = new Route("PathB", 200);

        Route preferred = (r1.localPref > r2.localPref) ? r1 : r2;
        System.out.println("Preferred Route: " + preferred.name);
    }
}
```

---

## 3. Variable Shadowing

When a **local variable** or **parameter** has the same name as an instance variable, it hides or "shadows" the instance variable.

### Example:

```java
public class ShadowExample {
    int x = 5; // instance variable

    void show(int x) { // parameter shadows the instance variable
        System.out.println("Parameter x = " + x);
        System.out.println("Instance x = " + this.x);
    }

    public static void main(String[] args) {
        ShadowExample obj = new ShadowExample();
        obj.show(10);
    }
}
```

### Output:
```
Parameter x = 10
Instance x = 5
```




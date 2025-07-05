
# Java Concepts: Enums, Wrapper Classes, Autoboxing, Upcasting, Autowidening, Inner Classes, parseInt()



## 1. Enums

Enums are used to define a fixed set of constants.

```java
enum CircusRole {
    JUGGLER, CLOWN, MAGICIAN, ANIMAL_TRAINER
}

public class EnumExample {
    public static void main(String[] args) {
        CircusRole r = CircusRole.JUGGLER;
        System.out.println("Today's star performer is: " + r);
    }
}
```

*Funny Context:* The circus has fixed roles, no one becomes a programmer by mistake.

---

## 2. Wrapper Classes

They wrap primitive types into objects.

```java
public class WrapperExample {
    public static void main(String[] args) {
        int ticket = 100;
        Integer boxedTicket = Integer.valueOf(ticket);
        System.out.println("Ticket price wrapped as object: " + boxedTicket);
    }
}
```



## 3. Autoboxing

Java automatically converts primitives to their wrapper objects.

```java
public class AutoboxingExample {
    public static void main(String[] args) {
        Integer popcorn = 50; // int to Integer
        System.out.println("Popcorn cost object: " + popcorn);
    }
}
```



## 4. Upcasting

Casting a subclass object to its superclass reference.

```java
class Performer {
    void act() {
        System.out.println("Performer is on stage");
    }
}

class Clown extends Performer {
    void juggle() {
        System.out.println("Clown juggles 5 bananas");
    }
}

public class UpcastingExample {
    public static void main(String[] args) {
        Performer p = new Clown(); // Upcasting
        p.act();
        // p.juggle(); // Not accessible
    }
}
```



## 5. Autowidening

Automatically converting a smaller type to a larger type.

```java
public class AutowideningExample {
    public static void main(String[] args) {
        int peanuts = 25;
        double dPeanuts = peanuts; // int to double
        System.out.println("Total peanuts weight: " + dPeanuts + " grams");
    }
}
```



## 6. Inner Classes

A class defined inside another class.

```java
class Tent {
    String tentName = "Main Tent";

    class Performer {
        void display() {
            System.out.println("Performing inside " + tentName);
        }
    }
}

public class InnerClassExample {
    public static void main(String[] args) {
        Tent t = new Tent();
        Tent.Performer p = t.new Performer();
        p.display();
    }
}
```



## 7. parseInt()

Converts a String to an integer.

```java
public class ParseIntExample {
    public static void main(String[] args) {
        String snacks = "15";
        int count = Integer.parseInt(snacks);
        System.out.println("Number of candy bars sold: " + count);
    }
}
```


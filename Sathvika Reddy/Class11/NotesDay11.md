
# Polymorphism and Its Types in Java

## What is Polymorphism?

Polymorphism in Java allows objects to take many forms. It enables one interface to be used for a general class of actions.

---

## Types of Polymorphism:

| Type                    | Description |
|-------------------------|-------------|
| Compile-time (Static)   | Method overloading |
| Runtime (Dynamic)       | Method overriding |

---

## 1. Compile-time Polymorphism (Method Overloading)

```java
class Painter {
    void draw() {
        System.out.println("Drawing a circle");
    }

    void draw(String shape) {
        System.out.println("Drawing a " + shape);
    }

    void draw(String shape, int size) {
        System.out.println("Drawing a " + shape + " of size " + size);
    }
}
```




## 2. Runtime Polymorphism (Method Overriding)

```java
class Artist {
    void paint() {
        System.out.println("Artist paints in general");
    }
}

class WaterColorArtist extends Artist {
    @Override
    void paint() {
        System.out.println("WaterColorArtist paints using water colors");
    }
}

class OilPaintArtist extends Artist {
    @Override
    void paint() {
        System.out.println("OilPaintArtist paints using oil paints");
    }
}
```


## Runner Example: Demonstrating Both Types

```java
public class PolymorphismDemo {
    public static void main(String[] args) {
        // Compile-time polymorphism
        Painter p = new Painter();
        p.draw();
        p.draw("Square");
        p.draw("Rectangle", 5);

        // Runtime polymorphism
        Artist a1 = new WaterColorArtist();
        Artist a2 = new OilPaintArtist();

        a1.paint();  // WaterColorArtist version
        a2.paint();  // OilPaintArtist version
    }
}
```


# Java Concepts: Reflection API, Island Objects, and Arrays

## 1. Reflection API in Java

Reflection allows examining or modifying runtime behavior of applications running in JVM.

```java
import java.lang.reflect.*;

class MyClass {
    private String name;
    
    public MyClass() { this.name = "Default"; }
    public MyClass(String name) { this.name = name; }
    
    private void display() {
        System.out.println("Name: " + name);
    }
}

public class ReflectionDemo {
    public static void main(String[] args) throws Exception {
        // Get Class object
        Class<?> cls = Class.forName("MyClass");
        
        // Create instance using constructor
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object obj = constructor.newInstance("John");
        
        // Access private field
        Field field = cls.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println("Field value: " + field.get(obj));
        
        // Invoke private method
        Method method = cls.getDeclaredMethod("display");
        method.setAccessible(true);
        method.invoke(obj);
    }
}

2. Island of Isolation (Memory Management)
An island of isolation occurs when objects reference each other but are no longer referenced by any active part of the application.
class Island {
    Island i;
    
    public static void main(String[] args) {
        Island obj1 = new Island();
        Island obj2 = new Island();
        
        // Create references between objects
        obj1.i = obj2;
        obj2.i = obj1;
        
        // Nullify external references
        obj1 = null;
        obj2 = null;
        
        // Now both objects form an island of isolation
        // and are eligible for garbage collection
    }
}

3. Arrays in Java
Arrays are objects that store multiple variables of the same type.
public class ArrayExamples {
    public static void main(String[] args) {
        // Primitive array
        int[] numbers = new int[5];
        numbers[0] = 10;
        
        // Object array
        String[] names = {"Alice", "Bob", "Charlie"};
        
        // Multi-dimensional array
        int[][] matrix = {{1, 2}, {3, 4}};
        
        // Array operations
        System.out.println("Length: " + names.length);
        System.out.println("First element: " + names[0]);
        
        // Array iteration
        for (String name : names) {
            System.out.println(name);
        }
    }
}
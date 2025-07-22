# 📘 Java Generics

---

## 🧠 What are Generics?

**Generics** allow you to create classes, interfaces, and methods that operate on **typed parameters**. This means you can write code that works with **any data type** while maintaining **type safety**.

---

## 🎯 Why Use Generics?

- ✅ Type safety: Catches errors at compile-time.
- ✅ Code reusability: Write a single class/method that works with different types.
- ✅ No need for casting: Avoids `ClassCastException`.

---

## 📦 Syntax of Generics

```java
class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
Here, T is a type parameter.

🧪 Example Usage:
java
Copy
Edit
Box<Integer> intBox = new Box<>();
intBox.set(100);
System.out.println(intBox.get());  // Output: 100

Box<String> strBox = new Box<>();
strBox.set("Hello");
System.out.println(strBox.get());  // Output: Hello
🔧 Generic Methods
You can create methods that accept or return generic types.

java
Copy
Edit
public class Utility {
    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.println(item);
        }
    }
}
🧩 Bounded Type Parameters
Use bounded types to restrict what types can be used.

java
Copy
Edit
class Numbers<T extends Number> {
    T num;

    Numbers(T num) {
        this.num = num;
    }

    void display() {
        System.out.println(num.doubleValue());
    }
}
T extends Number: T must be a subclass of Number.

🔄 Wildcards in Generics
Wildcards represent unknown types.

🔹 <?> — Unknown type
java
Copy
Edit
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
🔸 <? extends T> — Upper bounded wildcard
Accepts T or any subtype of T.

🔸 <? super T> — Lower bounded wildcard
Accepts T or any supertype of T.
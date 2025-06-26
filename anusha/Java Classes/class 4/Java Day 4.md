
# Java Day 4 🧮

## Variables in Java

### 🔹 Local Variables
- Variables declared **inside a method**.
- They must be **initialized before use**.

### 🔹 Global Variables
- Variables declared **outside any method** (typically inside a class but outside methods).
- They have **class-level scope** and can be accessed by all methods of the class.

---

## 🔁 Increment Operators in Java

Java provides two types of increment operators that increase a variable's value by 1.

### ➕ Pre-Increment (`++x`)
- Increases first, then uses the updated value.

```java
int x = 5;
int y = ++x; // x becomes 6, then y is assigned 6
// Result: x = 6, y = 6
```

### ➕ Post-Increment (`x++`)
- Uses current value first, then increases it.

```java
int x = 5;
int y = x++; // y is assigned 5, then x becomes 6
// Result: x = 6, y = 5
```

---

## ➖ Decrement Operators in Java

Java also provides two decrement operators to decrease a variable’s value by 1.

### ➖ Pre-Decrement (`--x`)
- Decreases first, then uses the updated value.

```java
int x = 5;
int y = --x; // x becomes 4, then y is assigned 4
// Result: x = 4, y = 4
```

### ➖ Post-Decrement (`x--`)
- Uses current value first, then decreases it.

```java
int x = 5;
int y = x--; // y is assigned 5, then x becomes 4
// Result: x = 4, y = 5
```

---

## 💻 Code Example

```java
public class A {
    public static void main(String args[]) {
        int i = 0;

        int j = i++; // post-increment
        System.out.println("j = " + j);
        System.out.println("i = " + i);

        int k = i++; // post-increment again
        System.out.println("i = " + i);
        System.out.println("k = " + k);

        int l = i--; // post-decrement
        System.out.println("l = " + l);
        System.out.println("i = " + i);
    }
}
```

### 📝 Output:
```
j = 0
i = 1
i = 2
k = 1
l = 2
i = 1
```

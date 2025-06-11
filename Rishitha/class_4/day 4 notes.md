**Java Notes: Pre/Post Increment, Stack Overflow, and Stack Unwinding**

---

### 1. **Pre-Increment (`++i`) and Post-Increment (`i++`)**

#### **Pre-Increment (`++i`)**

* First **increments** the value of `i`, then **uses** it.

```java
int i = 5;
int result = ++i; // i becomes 6, then result = 6
```

#### **Post-Increment (`i++`)**

* First **uses** the current value of `i`, then **increments** it.

```java
int i = 5;
int result = i++; // result = 5, then i becomes 6
```

#### **Example Comparison:**

```java
int i = 10;
System.out.println(++i); // 11
System.out.println(i++); // 11 (but i becomes 12 after this line)
```

---

### 2. **Stack Memory**

* Stack is a part of memory used to store **method calls**, **local variables**, and **execution flow**.
* Follows **LIFO** (Last In, First Out) principle.
* Each method call creates a **stack frame**.
* Once the method finishes, the frame is **popped** off.

---

### 3. **Heap Memory**

* Used to store **objects** and **instance variables**.
* Objects created using `new` keyword go to heap.
* Garbage Collector cleans unused heap memory.

---

### 4. **Stack Overflow**

* Happens when **too many method calls** are pushed into the stack.
* Typically caused by **infinite or deep recursion**.

#### Example:

```java
public class OverflowExample {
    public static void recursiveMethod() {
        recursiveMethod();
    }
    public static void main(String[] args) {
        recursiveMethod();
    }
}
```

**Output:**

```
Exception in thread "main" java.lang.StackOverflowError
```

---

### 5. **Stack Unwinding**

* Happens when an **exception** occurs and the control is passed **backwards** through the call stack.
* Each method is popped off the stack **until** the exception is caught or program terminates.

#### Example:

```java
public class StackUnwindingExample {
    static void method1() {
        method2();
    }

    static void method2() {
        method3();
    }

    static void method3() {
        int a = 5 / 0; // ArithmeticException
    }

    public static void main(String[] args) {
        try {
            method1();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in main: " + e);
        }
    }
}
```

**Output (Unwinding Order):**

```
Exception caught in main: java.lang.ArithmeticException: / by zero
```

* Execution unwinds back from `method3 → method2 → method1 → main`.


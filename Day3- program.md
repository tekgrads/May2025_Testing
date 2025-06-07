# Day 3
---

## Post and Pre Increment

### Pre Increment
- In pre-increment, the value is first incremented and then assigned to the variable.

### Post Increment
- In post-increment, the variable is first assigned to another variable and then incremented.

```java
class Main {
    public static void main(String[] args) {
        int i = 0; // i value is initialized
        System.out.println("i value before increment = " + i);

        int j = i++; // post increment: first i value is assigned to j and then incremented
        System.out.println("j value = " + j);
        System.out.println("i value = " + i);

        int k = ++j; // pre increment: first value gets incremented and then assigned
        System.out.println("K value = " + k);
    }
}

Stack levels refer to the layers of method calls (also called stack frames) maintained during program execution. Each level represents a method call, and together they form the call stack.

1)Main Method Level (Base Level):
This is where execution starts (main() in Java).

2)Method Calls Inside Main:
Each time a method is called, a new stack frame is created and pushed onto the stack.

3)Nested Method Calls:
If a method calls another method, the stack grows deeper with each call.

4)Return from Methods (Stack Unwinding):
When a method finishes, its stack frame is popped off, and control returns to the previous level.
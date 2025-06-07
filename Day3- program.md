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

###Stack and Heap
Stack is used for the execution of programs.

Heap is mainly for storage and is used for storing objects referenced from the stack.

###Stack Unwinding
Stack unwinding is a pop operation that starts from the topmost part of the stack.
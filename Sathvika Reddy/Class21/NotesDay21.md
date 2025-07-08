
# Java Notes: Arrays.sort with Comparator & Difference Between Array and Collection

## 1. Using `Arrays.sort()` with Comparator

You can sort arrays in Java using `Arrays.sort()`. If you want to sort objects or apply custom sorting logic, you can use a **Comparator**.

### Example:

```java
import java.util.Arrays;
import java.util.Comparator;

public class StudentSorter {
    public static void main(String[] args) {
        String[] students = { "Ravi", "Anu", "Zara", "Balu" };

        // Sort names in reverse order using a Comparator
        Arrays.sort(students, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.compareTo(s1); // Reverse alphabetical order
            }
        });

        System.out.println(Arrays.toString(students));
    }
}
```

---

## 2. Difference Between Array and Collection in Java

| Feature        | Array                                | Collection                            |
|----------------|---------------------------------------|----------------------------------------|
| Size           | Fixed (once created, can’t change)    | Growable (like a magic bag)            |
| Type           | Can store primitives and objects      | Only objects (no primitives)           |
| Performance    | Faster (less features, more speed)    | Slightly slower (more flexible)        |
| Utilities      | Limited (only some methods)           | Rich set of methods (add, remove, etc.)|
| Part of        | Language core                         | java.util framework                    |


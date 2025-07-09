# Java Arrays: Sorting, Comparisons, and Functions
---------------------------------------------------------------------
## 1. Arrays.sort() with Comparator

The `Arrays.sort()` method can sort arrays using custom sorting logic via Comparators.

### Example:
```java
import java.util.Arrays;
import java.util.Comparator;

public class SortExample {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Orange", "Banana", "Grape"};
        
        // Sort by natural order (alphabetical)
        Arrays.sort(fruits);
        System.out.println("Natural order: " + Arrays.toString(fruits));
        
        // Sort by length using Comparator
        Arrays.sort(fruits, Comparator.comparingInt(String::length));
        System.out.println("By length: " + Arrays.toString(fruits));
        
        // Custom reverse order Comparator
        Arrays.sort(fruits, (a, b) -> b.compareTo(a));
        System.out.println("Reverse order: " + Arrays.toString(fruits));
    }
}

Comparisons between the Arrays and Collections
----------------------------------------------------------------
1. Size Flexibility
int[] arr = new int[5];  // Fixed size (cannot add 6th element)
Collections:
List<Integer> list = new ArrayList<>(); 
list.add(10);  // Expands dynamically

2. Type Safety
Arrays: Allow primitives and objects.
int[] nums = {1, 2, 3};  // Primitives
String[] names = {"Alice", "Bob"};  // Objects
Collections: Only objects (autoboxing handles primitives).
List<Integer> list = Arrays.asList(1, 2, 3);  // Autoboxed to Integer

3. Functionality
Arrays: Limited functionality (use Arrays utility class for sorting/searching).
Arrays.sort(arr);  // Static method
Collections
list.sort(Comparator.naturalOrder());  // Instance method
list.removeIf(n -> n > 10);           // Lambda support

4. Multidimensional Support
Arrays: Native support.
int[][] matrix = new int[3][3];
Collections: Use nested collections
List<List<Integer>> matrix = new ArrayList<>();

When to Use Which?
Use Arrays when:
You need primitive types for performance.
The size is fixed and known in advance.
Working with low-level APIs (e.g., JNI).

Use Collections when:
You need dynamic sizing.
Require high-level operations (e.g., filtering, sorting).
Working with object-only data.

Common Array Operations and Functions
1. Length of an Array
Use the .length property to get the size of the array.
int[] arr = {10, 20, 30};
System.out.println(arr.length); // Output: 3

2. Traversing an Array
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

// Enhanced for loop
for (int num : arr) {
    System.out.println(num);
}


3. Sorting an Array
Use Arrays.sort() to sort the array in ascending order.
import java.util.Arrays;
int[] arr = {5, 1, 4, 2, 3};
Arrays.sort(arr);
System.out.println(Arrays.toString(arr)); // Output: [1, 2, 3, 4, 5]

4. Searching an Array
import java.util.Arrays;
int[] arr = {1, 2, 3, 4, 5};
int index = Arrays.binarySearch(arr, 3);
System.out.println("Index of 3: " + index); // Output: 2

5. Copying an Array
Use Arrays.copyOf() or Arrays.copyOfRange().
import java.util.Arrays;
int[] original = {1, 2, 3};
int[] copy = Arrays.copyOf(original, 5);
System.out.println(Arrays.toString(copy)); // Output: [1, 2, 3, 0, 0]

6. Comparing Arrays
Use Arrays.equals() to compare arrays for equality.
import java.util.Arrays;
int[] a = {1, 2, 3};
int[] b = {1, 2, 3};
System.out.println(Arrays.equals(a, b)); // Output: true

7. Filling an Array
Use Arrays.fill() to set all elements to a single value.
import java.util.Arrays;
int[] arr = new int[5];
Arrays.fill(arr, 7);
System.out.println(Arrays.toString(arr)); // Output: [7, 7, 7, 7, 7]

8. Multidimensional Arrays

int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};





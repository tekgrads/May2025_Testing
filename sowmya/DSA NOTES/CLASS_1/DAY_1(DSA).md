# Data Structures and Algorithms

---
#####Topics->Data Structures and Algorithms,TimeComplexity,SpaceComplexity,LinearSearch,BinarySearch
## Data Structures

**Definition:** Organized ways to store and manage data efficiently.

**Examples:**
* Arrays,LinkedLists,Trees,Stacks,Queues

## Algorithms

**Definition:** Step-by-step methods to solve problems or perform tasks.

**Examples:**
* Searching,Sorting,Traversal

---

### Real-Time Analogy

* **Cooking Materials = Data Structures**
* **Cooking Process = Algorithm**

---

## Goal While Solving DSA Problems

* Use minimal resources
* Save time

---

## Time Complexity

**Definition:** Time taken by an algorithm based on input size.

**Used To:** Measure performance

**Notation (Big O):**

* O(1)
* O(n)
* O(n²)

**Example:**
If a loop runs `n` times → Time Complexity = **O(n)**

---

## Space Complexity

**Definition:** Memory consumed by an algorithm based on input size.

**Includes:**

* Variables,Function calls,Data structures

---

### Time vs Space Complexity

| Time Complexity         | Space Complexity      |
| ----------------------- | --------------------- |
| Measures execution time | Measures memory usage |
| Aim: Minimize runtime   | Aim: Minimize memory  |
| Speed of code           | Memory occupies for code|

---

## Linear Search

**Definition:**
On LinearSearch we search the element one by one until the element found

**Also Known As:** Sequential Search

### Time Complexity

* **Best Case:** O(1) → Element at the beginning
* **Average Case:** O(n)
* **Worst Case:** O(n) → Element at the end or not present

### Space Complexity

* **O(1)** → Constant memory

---

## Binary Search

**Definition:**
Requires sorted array. Repeatedly divides search range in half to find the target.

**Steps:**

1. Check middle element.
2. If target < middle → Search left half.
3. If target > middle → Search right half.
4. Repeat until found.

### Time Complexity

* **Best Case:** O(1) → Found at middle
* **Average Case:** O(log n)
* **Worst Case:** O(log n)

### Space Complexity

* **O(1)** → Iterative version
* **O(log n)** → Recursive version

---



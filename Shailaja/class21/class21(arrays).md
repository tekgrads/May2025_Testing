Arrays in Java
An array in Java is a collection of elements (values) of the same data type, stored in a fixed-size container.

Key Points
Stores multiple values in one variable.
Each element is accessed using an index starting from 0. The last index is length - 1.
The size is fixed when the array is created.
Example 1: Creating and Printing Arrays
package com.tekgrads;

import java.util.Arrays;

public class Example1 {

    public static void main(String[] args) {
        // Creating an array
        int a[] = new int[10];

        // Use for loop to assign values
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        // 1st way: Print values using for loop
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        System.out.println("------------------------");

        // 2nd way: Enhanced for loop
        for (int i : a) {
            System.out.println(i);
        }

        System.out.println("------------------------");

        // 3rd way: Using built-in method toString()
        System.out.println(Arrays.toString(a));
    }
}
Output
0
1
2
3
4
5
6
7
8
9
------------------------
0
1
2
3
4
5
6
7
8
9
------------------------
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Example 2: Declaring values directly and printing in different ways
package com.tekgrads;

import java.util.Arrays;

public class Example2 {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9,10};

        // 1st way: Using for loop
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        System.out.println("-------------------------------------");

        // 2nd way: Using enhanced for loop
        for (int i : a) {
            System.out.println(i);
        }

        System.out.println("-------------------------------------");

        // 3rd way: Using Arrays.toString()
        System.out.println(Arrays.toString(a));
    }
}
Output:
1
2
3
4
5
6
7
8
9
10
-------------------------------------
1
2
3
4
5
6
7
8
9
10
-------------------------------------
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Sorting an Array
We can sort an array using the sort() method from the Arrays class.

It arranges the array elements in ascending (increasing) order.
Example 3: Sort the array using Arrays.sort()
package com.tekgrads;

import java.util.Arrays;

public class Example3 {
    public static void main(String[] args) {
        int a[] = {1000, 2, 800, 70, 3000, 4, 50};

        System.out.println("Array before sorting: " + Arrays.toString(a));

        Arrays.sort(a);

        System.out.println("Array after sorting: " + Arrays.toString(a));
    }
}
Output:
Array before sorting: [1000, 2, 800, 70, 3000, 4, 50]
Array after sorting: [2, 4, 50, 70, 800, 1000, 3000]
Example 4: Creating an Array for Employee Details
package com.tekgrads;

import java.util.Arrays;

class Employee {
    String name;
    Integer age;
    Double salary;
    String CompanyName;

    public Employee(String name, Integer age, Double salary, String companyName) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.CompanyName = companyName;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", CompanyName=" + CompanyName + "]";
    }
}

public class Example4 {

    public static void main(String[] args) {
        Employee[] emp = {
            new Employee("ramya", 25, 50000d, "cognizant"),
            new Employee("kavya", 26, 40000d, "hcl"),
            new Employee("sowmya", 27, 80000d, "Ibm"),
            new Employee("ruchitha", 25, 40000d, "cognizant"),
            new Employee("harika", 24, 45000d, "accenture")
        };

        System.out.println(Arrays.toString(emp));
    }
}
Output
[Employee [name=ramya, age=25, salary=50000.0, CompanyName=cognizant],
 Employee [name=kavya, age=26, salary=40000.0, CompanyName=hcl],
 Employee [name=sowmya, age=27, salary=80000.0, CompanyName=Ibm],
 Employee [name=ruchitha, age=25, salary=40000.0, CompanyName=cognizant],
 Employee [name=harika, age=24, salary=45000.0, CompanyName=accenture]]
Customized Comparator
A customized comparator allows you to define custom sorting logic using the Comparator interface. You override the compare() method to specify how two objects should be compared.

When to Use
Sorting students by marks
Sorting employees by salary
Sorting strings by length
Example 5: Sort Array in Descending Order using Custom Comparator
package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

public class Example5 {
    public static void main(String[] args) {
        Integer[] a = {1000, 2, 800, 70, 3000, 4, 50};
        System.out.println("Arrays before sorting: " + Arrays.toString(a));

        Arrays.sort(a);
        System.out.println("Arrays after default sorting: " + Arrays.toString(a));

        Arrays.sort(a, new MyComparator());
        System.out.println("Arrays after custom descending sort: " + Arrays.toString(a));
    }
}

class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1); // descending order
    }
}
Output
Arrays before sorting: [1000, 2, 800, 70, 3000, 4, 50]
Arrays after default sorting: [2, 4, 50, 70, 800, 1000, 3000]
Arrays after custom descending sort: [3000, 1000, 800, 70, 50, 4, 2]
Example 6: Custom Sorting Employees by Salary
package com.tekgrads;

import java.util.Arrays;

class Employee implements Comparable<Employee> {
    String name;
    Integer age;
    Double salary;
    String companyName;

    public Employee(String name, Integer age, Double salary, String companyName) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", companyName=" + companyName + "]";
    }

    @Override
    public int compareTo(Employee o) {
        return this.salary.compareTo(o.salary);
    }
}

public class Example6 {
    public static void main(String[] args) {
        Employee[] emp = {
            new Employee("ramya", 25, 50000d, "cognizant"),
            new Employee("kavya", 26, 42000d, "hcl"),
            new Employee("sowmya", 27, 80000d, "ibm"),
            new Employee("ruchitha", 25, 40000d, "cognizant"),
            new Employee("harika", 24, 45000d, "accenture")
        };

        System.out.println("Before sorting: " + Arrays.toString(emp));
        Arrays.sort(emp);
        System.out.println("After sorting by salary: " + Arrays.toString(emp));
    }
}
Output
Before sorting: [Employee [name=ramya, age=25, salary=50000.0, companyName=cognizant], ...]
After sorting by salary: [Employee [name=ruchitha, age=25, salary=40000.0, ...], ..., Employee [name=sowmya, age=27, salary=80000.0, ...]]
Example 7: Sorting Students by Marks using Comparable
package com.tekgrads;

import java.util.Arrays;

class Student implements Comparable<Student> {
    String name;
    Integer id;
    Double marks;
    String schoolName;
    Integer age;

    public Student(String name, Integer id, Double marks, String schoolName, Integer age) {
        this.name = name;
        this.id = id;
        this.marks = marks;
        this.schoolName = schoolName;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", " + id + ", " + marks + ", " + schoolName + ", " + age;
    }

    @Override
    public int compareTo(Student s) {
        return this.marks.compareTo(s.marks);
    }
}

public class Example7 {
    public static void main(String[] args) {
        Student[] s = {
            new Student("sowmya", 200, 80d, "gayatri", 20),
            new Student("ramya", 201, 85d, "narayana", 21),
            new Student("swetha", 203, 70d, "chaitanya", 20),
            new Student("kavya", 204, 76d, "gayatri", 22),
            new Student("sneha", 202, 70d, "narayana", 19)
        };

        System.out.println("Before sorting by marks: " + Arrays.toString(s));
        Arrays.sort(s);
        System.out.println("After sorting by marks: " + Arrays.toString(s));
    }
}
Output
student deatils before there marks sorting 
[sowmya ,200 ,80.0 ,gayatri ,20, 
ramya ,201 ,85.0 ,narayana ,21, 
swetha ,203 ,70.0 ,chaitinaya ,20, 
kavya ,204 ,76.0 ,gayatri ,22, 
sneha ,202 ,70.0 ,narayana ,19]
student deatils after there marks sorting 
[swetha ,203 ,70.0 ,chaitinaya ,20, 
sneha ,202 ,70.0 ,narayana ,19, 
kavya ,204 ,76.0 ,gayatri ,22, 
sowmya ,200 ,80.0 ,gayatri ,20, 
ramya ,201 ,85.0 ,narayana ,21]
Example 8: Sorting Employees Using Comparator
package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

public class Example9 {
    public static void main(String[] args) {
        Employee[] emp = {
            new Employee("ramya", 25, 50000d, "cognizant"),
            new Employee("kavya", 26, 42000d, "hcl"),
            new Employee("sowmya", 27, 80000d, "Ibm"),
            new Employee("ruchitha", 25, 40000d, "cognizant"),
            new Employee("harika", 24, 45000d, "accenture")
        };

        System.out.println("Original array: " + Arrays.toString(emp));

        Arrays.sort(emp);
        System.out.println("Sorted in ascending order: " + Arrays.toString(emp));

        Arrays.sort(emp, new MyEmployeeComparator());
        System.out.println("Sorted in descending order: " + Arrays.toString(emp));
    }
}

class MyEmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o2.salary.compareTo(o1.salary); // descending
    }
}
Output
Original array: [Employee [name=ramya, age=25, salary=50000.0, companyName=cognizant], ...]
Sorted in ascending order: [Employee [name=ruchitha, age=25, salary=40000.0, ...], ..., Employee [name=sowmya, age=27, salary=80000.0, ...]]
Sorted in descending order: [Employee [name=sowmya, age=27, salary=80000.0, ...], ..., Employee [name=ruchitha, age=25, salary=40000.0, ...]]
Example 9: Sorting Students Using Comparator
package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

public class Example10 {
    public static void main(String[] args) {
        Student[] s = {
            new Student("sowmya", 200, 80d, "gayatri", 20),
            new Student("ramya", 201, 85d, "narayana", 21),
            new Student("swetha", 203, 70d, "chaitinaya", 20),
            new Student("kavya", 204, 76d, "gayatri", 22),
            new Student("sneha", 202, 70d, "narayana", 19)
        };

        System.out.println("Original student array: " + Arrays.toString(s));

        Arrays.sort(s);
        System.out.println("Sorted in ascending order: " + Arrays.toString(s));

        Arrays.sort(s, new MyStudentComparator());
        System.out.println("Sorted in descending order: " + Arrays.toString(s));
    }
}

class MyStudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.marks.compareTo(o1.marks); // descending
    }
}
Output
Original student array: [sowmya, 200, 80.0, gayatri, 20, ..., sneha, 202, 70.0, narayana, 19]
Sorted in ascending order: [swetha, 203, 70.0, ..., ramya, 201, 85.0]
Sorted in descending order: [ramya, 201, 85.0, ..., sneha, 202, 70.0]
Difference Between Comparable and Comparator
Comparable	Comparator
Used to define natural ordering	Used to define custom ordering
Located in java.lang package	Located in java.util package
Must implement compareTo(Object o)	Must implement compare(Object o1, o2)
Defines sorting inside the class	Defines sorting outside the class
Affects only the current class	Can be used to sort multiple classes
Example Logic for Comparator:
if (o1 > o2) return -1;
else if (o1 < o2) return +1;
else return 0;
Important Points On Arrays
Arrays are fixed in size
Arrays can hold only homogeneous (same) data types
Arrays can store primitive and object types
Arrays cannot grow or shrink dynamically → not memory efficient
Arrays are not underlying datastructure readymade method support are not available
Arrays provide good performance for basic operations
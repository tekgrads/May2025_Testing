Day 27
Example 1: Printing Employees with Salary > 30000
Employee.java

package com.tekgrads;

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

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
}

Example19.java

package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example19 {

 	public static void main(String[] args) {
 		List<Employee> employeeList = new ArrayList<>();
 		employeeList.add(new Employee("Kavya", 28, 10000d, "HCL"));
 		employeeList.add(new Employee("Sravanthi", 30, 20000d, "Accenture"));
 		employeeList.add(new Employee("Sneha", 31, 30000d, "Infosys"));
 		employeeList.add(new Employee("Harshitha", 32, 40000d, "CTS"));
 		employeeList.add(new Employee("Ankitha", 34, 50000d, "Persistent"));
 		employeeList.add(new Employee("Likitha", 37, 60000d, "JPMC"));
 
 		List<String> names = employeeList.stream().filter(e->e.salary>30000)
 		.map(e->e.name)
 		.collect(Collectors.toList());
 
 		System.out.println(names);

 	}

}
Output:

[Harshitha, Ankitha, Likitha]

flatMap()
The flatMap() method is used to flatten a stream of nested collections (e.g., List of Lists) into a single stream.

Example 2: Using flatMap()
package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example20 {

 	public static void main(String[] args) {
 		List<List<Integer>> listOfIntegerList = new ArrayList<>();
 		List<Integer> firstList = new ArrayList<>();
 		firstList.add(1);
 		firstList.add(2);
 		firstList.add(3);
 		List<Integer> secondList = new ArrayList<>();
 		secondList.add(4);
 		secondList.add(5);
 		secondList.add(6);
 		List<Integer> thirdList = new ArrayList<>();
 		thirdList.add(7);
 		thirdList.add(8);
 		thirdList.add(9);
 		listOfIntegerList.add(firstList);
 		listOfIntegerList.add(secondList);
 		listOfIntegerList.add(thirdList);
 
 		System.out.println(listOfIntegerList);
 
 		List<Integer> result = listOfIntegerList.stream()
 				.flatMap(p->p.stream())
 				.collect(Collectors.toList());
 		System.out.println(result);

 	}

}

Output:

[[1, 2, 3], [4, 5, 6], [7, 8, 9]]
[1, 2, 3, 4, 5, 6, 7, 8, 9]

##groupingBy()

groupingBy(): Used to group objects based on a property.

Returns a Map<K, List> where K is the key and V is the list of grouped items.
Example 3: Grouping and Sorting Employees by Company and Salary

package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example21 {

 	public static void main(String[] args) {
 		List<Employee> employeeList = new ArrayList<>();
 		employeeList.add(new Employee("Kavya", 28, 10000d, "HCL"));
 		employeeList.add(new Employee("Sravanthi", 30, 20000d, "HCL"));
 		employeeList.add(new Employee("Sneha", 31, 30000d, "Infosys"));
 		employeeList.add(new Employee("Harshitha", 32, 40000d, "Infosys"));
 		employeeList.add(new Employee("Ankitha", 34, 50000d, "Persistent"));
 		employeeList.add(new Employee("Likitha", 37, 60000d, "Persistent"));
 
 		Map<String, List<Employee>> group = employeeList.stream()
 				.collect(Collectors.groupingBy(Employee::getCompanyName));
 		System.out.println(group);
 
 		List<Employee> employeeSortedList = employeeList.stream().sorted((o1,o2)->{
 			if(o1.salary>o2.salary) {
 				return -1;
 			} else if(o1.salary<o2.salary) {
 				return 1;
 			} else {
 				return 0;
 			}
 		}).collect(Collectors.toList());
 
 		System.out.println(employeeSortedList);

 	}

}

Output:
{HCL=[Employee [name=Kavya, age=28, salary=10000.0, companyName=HCL], Employee [name=Sravanthi, age=30, salary=20000.0, companyName=HCL]], Infosys=[Employee [name=Sneha, age=31, salary=30000.0, companyName=Infosys], Employee [name=Harshitha, age=32, salary=40000.0, companyName=Infosys]], Persistent=[Employee [name=Ankitha, age=34, salary=50000.0, companyName=Persistent], Employee [name=Likitha, age=37, salary=60000.0, companyName=Persistent]]}
[Employee [name=Likitha, age=37, salary=60000.0, companyName=Persistent], Employee [name=Ankitha, age=34, salary=50000.0, companyName=Persistent], Employee [name=Harshitha, age=32, salary=40000.0, companyName=Infosys], Employee [name=Sneha, age=31, salary=30000.0, companyName=Infosys], Employee [name=Sravanthi, age=30, salary=20000.0, companyName=HCL], Employee [name=Kavya, age=28, salary=10000.0, companyName=HCL]]

What is Optional?
Optional is a container object which may or may not contain a non-null value. It is used to avoid NullPointerException.

isPresent()
Returns true if the value is present, otherwise false.

Example 4:program Using Optional
package com.tekgrads;

import java.lang.StackWalker.Option;
import java.util.Optional;

public class Example22 {

 	public static void main(String[] args) {
 		Optional<String> gender = Optional.of("MALE");
 
 		if(gender.isPresent()) {
 			System.out.println(gender.get());
 		}
 
 		String str = "Yes";
 		String str2 = null;
 
 		Optional<String> answer = Optional.ofNullable(str2);
 
 		answer.ifPresentOrElse(s->System.out.println(s),()->System.out.println("Not Present"));

 	}

}

Output:
MALE
Not Present


Example 5: Using LocalDate, LocalTime, LocalDateTime
package com.tekgrads;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Example23 {

 	public static void main(String[] args) {
 		LocalDate d = LocalDate.now();
 
 		System.out.println(d);
 
 		LocalTime lt = LocalTime.now();
 
 		System.out.println(lt);
 
 		int h = lt.getHour();
 		int m = lt.getMinute();
 		int s = lt.getSecond();
 		System.out.println("Hour: " + h);
 		System.out.println("Minute: " + m);
 		System.out.println("Second: " +s);
 
 		int dd = d.getDayOfMonth();
 		int mm = d.getMonthValue();
 		int yyy = d.getYear();
 
 		System.out.println("Day: " + dd);
 		System.out.println("Month: " + mm);
 		System.out.println("Year: " + yyy);
 
 		LocalDateTime dt = LocalDateTime.now();
 
 		System.out.println("Current Year: " + dt.getYear());
 		System.out.println("Current Hour: " + dt.getHour());

 	}

}

Output:
2025-08-18
00:27:58.244628400
Hour: 0
Minute: 27
Second: 58
Day: 18
Month: 8
Year: 2025
Current Year: 2025
Current Hour: 0

Example 6: Working with Period, Year, and ZonedDateTime
package com.tekgrads;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Example24 {

 	public static void main(String[] args) {
 		LocalDateTime ldt = LocalDateTime.of(1995,05,28,12,45);
 		System.out.println("LocalDateTime:" + ldt);
 
 		System.out.println("Adding 3 days: " + ldt.plusDays(3));
 		System.out.println("Adding 3 month: " + ldt.plusMonths(3));
 
 		LocalDate birthDate = LocalDate.of(1995,05,28);
 		LocalDate deathDate = LocalDate.now();
 
 		Period r = Period.between(birthDate, deathDate);
 
 		System.out.println("Years: " + r.getYears());
 		System.out.println("Months: " + r.getMonths());
 		System.out.println("Days: " + r.getDays());
 
 		Year y = Year.of(2025);
 		System.out.println("Is Leap Year (2025): " + y.isLeap());
 
 		ZoneId zone = ZoneId.systemDefault();
 
 		System.out.println("Default Zone: " +zone);
 
 		ZoneId america = ZoneId.of("America/New_York");
 		ZonedDateTime zdt = ZonedDateTime.now(america);
 
 		System.out.println("New York Time: " + zdt);
 
 
 	}

}

Output:
LocalDateTime:1995-05-28T12:45
Adding 3 days: 1995-05-31T12:45
Adding 3 month: 1995-08-28T12:45
Years: 30
Months: 2
Days: 21
Is Leap Year (2025): false
Default Zone: Asia/Calcutta
New York Time: 2025-08-17T15:09:16.788198400-04:00[America/New_York]



FILEHANDLING

File
A File in Java is an object that represents the path to a file or directory on your computer. It is used to create, read, write, delete, or check the properties of files and folders. It is a part of java.io package. All IO are checked exceptions, and we include try-catch blocks.

Example : Create a Directory
package com.tekgrads;

import java.io.File;

public class Example1 {

 	public static void main(String[] args) {
 		File f = new File("test");
 		f.mkdir();
 		System.out.println("done");

 	}
 
}


Example : Creating a File

package com.tekgrads;

import java.io.File;
import java.io.IOException;

public class Example2 {

 	public static void main(String[] args) {
 		File f = new File("test.txt");
 		try {
 			f.createNewFile();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}

 	}

}
FILE-WRITER
FileWriter is used to write characters to a file. finally block is always executed. We must close the connection using flush() and close() methods. It is a type of checked Exception.

Example : FileWriter Program
package com.tekgrads;

import java.io.FileWriter;
import java.io.IOException;

public class Example3 {

 	public static void main(String[] args) {
 		FileWriter out =null;
 	try {
 		 out = new FileWriter("test.txt");
 		out.write("Hello");
 	} catch (IOException e) {
 		e.printStackTrace();
 	}finally {
 		try {
 			if(out != null) {
 			out.flush();
 			out.close();
 			}
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 
 
 	}
 

 	}

}


FILE-READER
FileReader is used to read data (characters) from a file, one character at a time.

Example : FileReader Program
package com.tekgrads;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Example5 {

    public static void main(String[] args) {
        File file = new File("abc.txt");

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("abc");
            bw.newLine();
            bw.write("this is next line");
            bw.newLine();
            bw.write("this is last line");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

BUFFEREDWRITER
BufferedWriter is used to write text to a file efficiently by buffering characters before writing them. OutputStreamWriter converts characters into bytes and writes them to an output stream (e.g., file).

Example: Program using BufferedWriter
package com.tekgrads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example6 {
    public static void main(String[] args) {
        File file = new File("abc_new.txt");

        // Writing to the file using OutputStream
        try (FileOutputStream fos = new FileOutputStream(file)) {
            String content = "this is a 1st line\nthis is 2nd line\nthis is 3rd line";
            byte[] bytes = content.getBytes();
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading from the file using InputStream
        try (FileInputStream fis = new FileInputStream(file)) {
            int ch;
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch); // cast byte to char
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
BUFFEREDREADER
BufferedReader is used to read text from a character-based input stream efficiently, by buffering characters. InputStreamReader converts byte streams into character streams. It acts as a bridge between byte-based input (like FileInputStream) and character-based reading.

Example: Program using BufferedReader
package com.tekgrads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example7 {
    public static void main(String[] args) {
        Employee emp = new Employee("Sweatha", 50000, "HCL");

        try (FileOutputStream fos = new FileOutputStream("employee.data");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(emp);
            System.out.println("Employee object written to employee.data");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


SERIALIZATION & DESERIALIZATION
Serialization is the process of converting an object into a byte stream so that it can be easily saved to a file or transmitted over a network. This byte stream can later be deserialized to recreate the original object.

Example: Serialization
package com.tekgrads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example7 {
    public static void main(String[] args) {
        Employee emp = new Employee("sneha", 50000, "HCL");

        try (FileOutputStream fos = new FileOutputStream("employee.data");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(emp);
            System.out.println("Employee object written to employee.data");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

Example: Deserialization

package com.tekgrads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example8 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("employee.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Employee emp = (Employee) ois.readObject();
            System.out.println("Read from file: " + emp);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

Example 8: Read the file and print the objects

package com.tekgrads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example8 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("employee.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Employee emp = (Employee) ois.readObject();
            System.out.println("Read from file: " + emp);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


Transient Keyword

The transient keyword is used in file handling with serialization to prevent a field from being serialized. Even though we assign a value to a variable, if it's marked transient, the serialized output will not contain that value — it will be null or default.

Externalization

Externalization is a process in Java file handling where the programmer manually controls how an object is written to and read from a file, using the Externalizable interface. Unlike Serializable, it is not a marker interface and contains two methods:

writeExternal() – specify what data to write
readExternal() – specify what data to read

Example 9: Externalization Write Program
Employee_new.java

package com.tekgrads;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee_new implements Externalizable {

    private int id;
    private String name;
    private double salary;

    // Mandatory public no-arg constructor
    public Employee_new() {
    }

    public Employee_new(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeUTF(name);
        out.writeDouble(salary);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = in.readUTF();
        salary = in.readDouble();
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}

Example9.java - Writing Object

package com.tekgrads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Example9 {
    public static void main(String[] args) {
        Employee_new emp = new Employee_new(105, "kavya", 78000.00);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee_ext.dat"))) {
            oos.writeObject(emp);
            System.out.println("Employee object written using Externalization");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

Example 10: Read Externalized Object

package com.tekgrads;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Example10 {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee_ext.dat"))) {
            Employee_new emp = (Employee_new) ois.readObject();
            System.out.println("Read from file: " + emp);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

Final, Finally, Finalize Keywords in Java

final
final is a keyword used to declare constants.

It can be applied to variables, methods, or classes to prevent modification.

Final variable: cannot be reassigned.
Final method: cannot be overridden.
Final class: cannot be extended.
finally
finally is a block that always executes after a try-catch block.
It runs whether or not an exception occurs.
If an exception occurs before the try block, the finally block will not be executed.
finalize
finalize() is a method invoked by the Garbage Collector before destroying the object.
It is used to perform cleanup operations before the object is removed from memory.
Example 11: Program on final, finally, and finalize keywords
package com.tekgrads;

public class Final {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() method called for object: " + this);
    }

    public static void main(String[] args) {
        final int a = 100;
        System.out.println("The final variable value is: " + a);

        try {
            System.out.println("Inside try block");
            int result = 50 / 10;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught an exception: " + e);
        } finally {
            System.out.println("This is the finally block. It always executes.");
        }

        Final obj1 = new Final();
        Final obj2 = new Final();

        obj1 = null;
        obj2 = null;

        // Suggest to JVM to run Garbage Collector
        System.gc();

        System.out.println("End of main method");
    }
}

##### **What are diff types of members we can create inside a class?**



###### **Static members    and        non-static members**

**===========================================================**



1. ###### **static variable          non-static variable**

###### **2. static block             non- static block**

###### **3. static method            non- static method**

###### **4. main method              constructor**

###### **5. static inner class       non- static inner class**



**To store values and execute          To store values and execute**

**logic common to all objs             logic specific to one obj**







**Among all these JVM executes only SV, SB, MM automatically.**

**JVM executes SM only when we invoke it**

**JVM executes NSM only when we create object**



**Order of execution of Static members**

**=====================================**



 class Ex{

         sv1

         sv2

 

         sb1

         sb2

 

         sm1

         sm2



         mm



         SIC1

         SIC2

}





When a class is loaded into JVM

 1. JVM allocates memory to static variables with default values from top to bottom.

2\. Static variables assignment and static block logic are executed in the order they are defined from top to bottom

3\. Finally main method is executed

4\. SM and SIC are executed only when they are invoked explicitly.





How many ways a class can be loaded into JVM?

&nbsp;        Two ways

&nbsp;           1. by java command

&nbsp;           2. by accessing static variables or methods from other classes

 

###### 



























###### 


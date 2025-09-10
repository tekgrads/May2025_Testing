**Non-static Members execution with inheritance:-**

**==============================================**

  **When we create sub class object, all its super classes non static variables memory is allocated in this subclass object and execute non static blocks and constructors in the below order:**



 **When we create an object to current class,**

   **-> All non static variables memory allocated with default values**

   **-> new keyword invokes current class constructor, and current class constructor invokes parent class constructor by using super() call**

   **-> in parent class first non static variables assignment and non static block logic is executed in the order they are defined from top to bottom. Then parent class constructor is executed.**

   **-> In current class also first non static variables assignment and non static block logic is executed and constructor logic is executed.**

   **-> After that control returns to main method** 






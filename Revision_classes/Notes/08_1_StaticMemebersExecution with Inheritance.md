**Order of execution of static members with inheritance:-**

**======================================================**



          **When a subclass is loaded into JVM, all its super classes are also loaded into JVM. Then JVM will run static members from all its super classes in the order from the ROOT super class to Current sub class**



      **-> static variables memory is allocated with default values from Super to current sub class.**

      **-> static variables initialization and static block logic is executed**

**from Super to current sub class in the order they are defined.**

      **-> Finally main method is executed from current sub class , if main is not available in current sub class, it is executed from its super class.**

       **-> static method is executed only if we call.**





**Ex: Test3**



     **If we access sub class SV in supoer class we will get its default value, but not its assigned value.**

      **We cannot access sub class members in super class directly by their name, compiler will throw error, because from super class compiler cannot find sub class.**

     **For accessing subclass members in super class we must use sub class reference either class name or subclass obj referenced variable**


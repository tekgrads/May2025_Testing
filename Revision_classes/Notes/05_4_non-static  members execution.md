Non-static members:
===================



     A member that is created inside a class and outside of all methods , constructors, blocks without using static keyword is called as non-static member.



             class Ex{

                int x;

                void m1(){

                }

             }



         **Here x and m1 are non static members**



   Non-static members are used for providing separate copy of memory in every objects instance for storing values specific to that object. 



-> We can create non static members only inside a class. If we create inside a method then it is called as local members to this method.



                class Ex{

                 int x; 

                void m1(){
                  int x;
                }

            
Java supports 5 non-static members

1. non-static variable

2. non- static block

3. non- static method

4. constructor

5. non- static inner class





**When we create a object then all the above members got executed by JVM**





                         

   


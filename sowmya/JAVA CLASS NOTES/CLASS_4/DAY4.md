			LOCAL AND GLOBAL VARIABLES
	--------------------------------------------------------------------------
1.LOCAL VARIABLES:In Java, a local variable is a variable that is declared inside a method or block of code. 
It is only accessible within that specific block of code, and its lifetime is limited to the execution of that block.
example:
  public class LocalVariable {
    public static void main(String[] args) {
        int number = 10;// Declaring and initializing a local variable
        System.out.println("The number is: " + number);
          }

    public void someOtherMethod() {
       System.out.println(number);//error will come because the number is a local variable
    }
}

2.GLOBAL VARIABLES:Java does not support global variables in the traditional sense,
where a variable is declared outside of any class and accessible from anywhere in the program.
However, Java provides mechanisms to achieve similar functionality using static variables.






				PRE INCREMENT AND POST INCREMENT
			--------------------------------------------------------------
3.PRE INCREMENT:pre-increment increments the value of the variable before its value is used in the expression. 
4.POST-INCREMENT: post-increment increments the value of the variable after its value is used in the expression.
ple:
	public class Increment {
  	  public static void main(String[] args) {
       			 int a = 5;
       			 int b = 5;

        // Post-increment: a will be used first, then incremented
        System.out.println("Post-increment:");
        System.out.println("a = " + a);  // Outputs 5 (before increment)
        System.out.println("a++ = " + a++);  // Outputs 5 (post-increment happens after the value is used)
        System.out.println("After post-increment, a = " + a);  // Outputs 6

        // Pre-increment: b will be incremented first, then used
        System.out.println("Pre-increment:");
        System.out.println("b = " + b);  // Outputs 5 (before increment)
        System.out.println("++b = " + ++b);  // Outputs 6 (pre-increment happens before the value is used)
        System.out.println("After pre-increment, b = " + b);  // Outputs 6
    }
}




		PRE-DECREMENT AND POST DECREMENT
           ---------------------------------------------------------
5.PRE-DECREMENT:The pre-decrement decrements the value of the variable before its value is used in the expression.

6.POST-DECREMENT:The pre-decrement decrements the value of the variable after its value is used in the expression.
example:
		public class Decrement{
			public static void main(String[] args){
				int a=5;
				int b=5;

        // Post-decrement: a will be used first, then decremented
        System.out.println("Post-decrement:");
        System.out.println("a = " + a);  // Outputs 5 (before decrement)
        System.out.println("a-- = " + a--);  // Outputs 5 (post-decrement happens after the value is used)
        System.out.println("After post-decrement, a = " + a);  // Outputs 4

        // Pre-increment: b will be decremented first, then used
        System.out.println("Pre-decrement:");
        System.out.println("b = " + b);  // Outputs 5 (before decrement)
        System.out.println("--b = " + --b);  // Outputs 4 (pre-decrement happens before the value is used)
        System.out.println("After pre-increment, b = " + b);  // Outputs 4
    }
}







				HARD DISK AND RAM
		------------------------------------------------------------------
7.HARD DISK:In Java, when you want to work with the hard disk, you typically deal with file systems and file operations. 
Java provides built-in classes in the java.io package and java.nio package that allow you to interact with the file system, read and write files,
and perform file manipulations.
8.RAM:In Java,  by using RAM (Random Access Memory) understand how Java programs use it.
How Java Uses RAM
-----------------------------------
I). Heap Memory Stores Objects and class instances and Managed by Garbage Collector.
Memory is allocated when objects are created and deallocated when objects are no longer referenced.Heap memory is larger compare to Stack Memory.
If the heap memory is full, an OutOfMemoryError occurs.HeapMeomory is used for Dynamic memory allocation.


II). Stack Memory Stores Method calls, local variables, references and it follows LIFO (Last-In-First-Out)order.Memoery is allocated and deallocated when methods are
invoked and completed.Stack memory is limited in size.If the stack memory is full then a StackOverFlowError will occur.
static memory is used allocation and method execution.






			stack unwinding operations
		---------------------------------------------------------------
9.Stack unwinding in Java is the mechanism the JVM uses to handle exceptions. 
When an exception is thrown, the JVM searches up the call stack for a matching catch block. 
This process of searching up the stack is known as stack unwinding.









			STACKS AND QUEUES
		----------------------------------------------------
10.STACK:In java a stack is a data structure that follows LIFO order(Last In First Out)
eg:we are placing bricks on order when we want to remove the first brick which is placed last
                |--------------------------------------|
                |        brick3                        |
                |--------------------------------------|
                |--------------------------------------|
                |        brick2                        |
                |--------------------------------------|
		|--------------------------------------|
                |        brick1                        |
                |--------------------------------------|

here while placing the bricks we place brick1 1st and brick2 2nd and brick3 last 
while removing the bricks brick3 1st and brick2 2nd and brick1at last.
->The last element added to the stack is the first one to be removed. 
we can perform push(adding an element) ,pop(removing an element) and isEmpty(checking the stack is empty or not) operations on stack 




11.QUEUE:In java queue is a data structure that follows FIFO(First In First Out)order.
eg:we buying a ticket on theater there we follow a line who comes first they go first.
		
		|-----------------|	
	        | 5| 4 | 3 | 2| 1 | here 1 is coming after 2,3,4,5 in the same sequence they will go out
                |-----------------|
->Elements are processed in the order they were added.
we can perform operations like add(for adding element),remove(removes the element),offer(it returns False if the queue is full else it will insert an element)









					STACKOVERFLOWERROR
			--------------------------------------------------
12.STACKOVERFLOWERROR:In java a StackOverflowError will occur when the call stack have more local variables,methods,parameters more than the stack limit.
This happen due to more times because of that where a method call itself repeatedly without a proper termination condition that causes a stack fill.
To prevent the StackOverflowErrow we have to put a proper terminatination, avoid deep recursions,increase the stack size.




	

				ClassNotFoundException
			----------------------------------------------------
13.ClassNotFoundException: In java ClassNotFoundException is a checked exception that occurs when the JVM attempts to load a class but cannot find its
defination in classpath. this commonly causes due to incorrectpath,dependency issues and so on
To overcome that we have to verify the classpath,inspect the dependencies






				STATIC(VARIABLES,METHODS)CONCEPT
			------------------------------------------------------
14.STATIC:In java static keyword is a non-acess modifier used to define the variables,methods,blocks.When a member is declared static
it belongs to the class rather than instances of the class. The static keyword is mainly used or memory management.
static members are acessed using the class name.
static members can only acess other static members
example:
		public class A{
			public static void main(String[] args){
				System.Out.Println("Hello");
			   	int i=10;
				method A(i);
				System.Out.Println("updated i value is"+i);
			}
			public static void methodA(int i){
				System.Out.Println("method A in class A");
				System.Out.Println("value of i is",+i);
				i=100;
				System.Out.Println("new i value is" +i);
			}
		}

15.STATIC VARIABLES: static variables can be declared by using static keyword. A static variable is also known as class variable that is associated
with the class itself.
for static variables Memory is allocated only once when the class is loaded into memory.
They can be accessed directly using the class name, without creating an instance of the class.
example:
		public class Var {
			static int i=10;
				public static void main(String [] args) {	
					System.out.println("value of i is "+i);
				}

			}
16.STATIC METHODS:A static method in Java is a method associated with the class itself 
rather than with any specific instance (object) of the class. It is declared using the static keyword.
static methods Can be called directly using the class name, without creating an object. 
static methods Can only access static members (variables and other static methods) of the class. they Cannot access instance variables or methods.
example:
		class Statmethod{
   			public static int show(int i){
				return i;
    			}
  			public static int show1(int j){
     				 return j;
   			}
		}
	public class Main{
  	 public static void main(String [] args){
   	   int a=Statmethod.show(8);
    	  int b=Statmethod.show1(10);
    	  System.out.println("a value is "+a);
     	 System.out.println("b value is "+b);
	}
      }









				STACK MEMORY AREA
			---------------------------------------------------------
15.STACK MEMORY AREA:In java the stack memory area is a part of JVM(Java Virtual Machine) that handles method execution and local variable storage.
the main purpose of stack memory area is method execution (the stack tracks the execution of methods, creating a new stack frame for each method call,
local variables and control flow.
stack memory area works on 
I)LIFO Structure meansThe stack operates on a Last-In-First-Out (LIFO) principle. 
The last method called is the first one to finish.
II)Stack Frames means
When a method is called, a new stack frame is pushed onto the stack. This frame contains the method's local variables, parameters, and return address. 
III)Method Completion:
When a method finishes, its stack frame is popped off the stack, freeing up memory. 

the Stack Memory Area  Stores
I)Local Variables: Variables declared within methods.
II)Method Parameters: Values passed to a method.
III)Return Addresses: Addresses where the program should resume after a method call.
IV)Reference Variables: References to objects that are stored in the heap.


the stack memory area in Java is essential for managing the execution of methods and storing local data. 
Its LIFO structure and thread-specific nature make it efficient for handling method calls, 
but its limited size requires careful consideration when designing complex or recursive code.













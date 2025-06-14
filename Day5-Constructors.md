Day5: Core Java
===============
Constructors:
It is a special method used to initialize the objects which is executed only when the object is created 
constructors are the same name as the class name
class can have the different constructors but with different parameters

Default Constructor:  class name and the constructor name should be same with no parameters
class student{
student(){
System.out.printn("Default constructor executed");
}
public static void main(string[] arg){
student s1=new student();
}
}

Parameterized constructor : which contains the parameters
class student{
string name;
int age;
student(string n ,int a){
 name=n;
age=a;
}
public void display(){
System.out.println(name+"  "+age);
}
public static void main(string[] args){
student s1=new student("cherry",20);
s1.display();
}
}


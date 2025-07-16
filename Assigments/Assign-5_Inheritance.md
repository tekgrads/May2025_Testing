Assignment on the Inheritance using the setters and getter
----------------------------------------------------------------------------
Problem:  Develop inheritance between Person and Student objects.
In Person define only parameterized constructor to initialize its properties name, height, weight.
In Student define no-param and param constructors to initialized its properites sno, course, fee with default values and argument values.
Define setter, getter and display methods in both super class and sub class to set, get and display their properties.
Create two objects from student with no-param and param constructors.


class Person{
private String name;
private int height;
private int weight;

public Person(String name, int height, int weight)                       //parameterized constructors
{
   this.name=name;
   this.height=height;
   this.weight=weight;
 }
 
//setters
public void setName(String name){
     this.name=name;
}

public void setHeight(int height){
     this.height=height;
}
public void setWeight(int weight){
    this.weight=weight;
}

//getters
public String getName(){
   return name;
}
public int getHeight(){
    return height;
}
public int getWeight(){
 return weight;
}

public void Show(){
System.out.println("Name:"+name);
System.out.println("Height:"+height+"cms");
System.out.println("Weight:"+weight+"kgs");
}
}

class Student extends Person{
private int sno;
private String course;
private int fee;
public  Student(){
           super("default name",153,60);
           this.sno=101;
           this.course="BTECH";
           this.fee=60000;
}
public Student(String name, int height, int weight,int sno, String course, int fee){
super(name, height, weight);
        this.sno = sno;
        this.course = course;
        this.fee = fee;
}
//setters
public void setSno(int sno){
this.sno=sno;
}
public void setCourse(String course){
this.course=course;
}
public void setFee(int fee){
this.fee=fee;
}

//getters
public int getSno(){
return sno;
}
public String getCourse(){
   return course;
}
public int getFee(){
return fee;
}


public void display(){
System.out.println("Student number:"+sno);
System.out.println("Course Name:"+course);
System.out.println("Fee:"+fee);
}
}

public class Inheritance{
public  static void main(String[] args){
Student s1=new Student();
System.out.println("Student1- non parametrized constructor");
s1.display();
System.out.println();
Student s2=new Student("Charitha",153,55,1,"Btech",46000);
System.out.println("Student2-parametrized constructor");
s2.display();
}
}

	




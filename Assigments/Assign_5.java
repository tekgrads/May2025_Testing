class Person{
private string name;
private int height;
private int weight;

public person(string name, int height, int weight)                       //parameterized constructors
{
   this.name=name;
   this.height=height;
   this.weight=weight;
 }
 
//setters
public void setName(string name){
     this.name=name;
}

public void setHeight(int height){
     this.height=height;
}
public void setWeight(int weight){
    this.weight=weight;
}

//getters
public string getName(string name){
   return name;
}
public int getHeight(int height){
    return height;
}
public int getWeight(int weight){
 return weight;
}

public show(){
System.out.println("Name:"+name);
System.out.println("Height:"+height+"cms");
System.out.println("Weight:"+weight+"kgs");
}

class Student extends Person{
private int sno;
private string course;
private int fee;
public  Student(){
           super("default name",153,60);
           this.sno=101;
           this.course="BTECH";
           this.fee=60000;
}
Public Student(string name, int height, int weight,int sno, string course, int fee){
super(name, height, weight);
        this.sno = sno;
        this.course = course;
        this.fee = fee;
}
//setters
public void setSno(int sno){
this.sno=sno;
}
public void setCourse(string course){
this.course=course;
}
public void setFee(string fee){
this.fee=fee;
}

//getters
public int getSno(int sno){
this.sno=sno;
}
public string setCourse(string course){
this.course=course;
}
public int getFee(int fee){
this.fee=fee;
}

@override
public void display(){
super.Student();
System.out.println("Student number:"+sno);
System.out.println("Course Name:"+course);
System.out.println("Fee:"+fee);
}
}

public class Inheritance{
public  static void main(string[] args){
Student s1=new Student();
System.out.println("Student1- non parametrized constructor")
s1.display();
System.out.println();
Student s2=new student("Charitha",153,55,1,"Btech",46000);
System.out.println("Student2-parametrized constructor");
s2.display();
}
}

	




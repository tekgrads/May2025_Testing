public class I {

int i;

//same name difeerent forms 

 I(int i) { 
  //  this();
    //compiler check it this is the first statement in the constructor //super
    // if this is not the first statement, then it will call the instance initializer block
    System.out.println("Parameterized constructor called I(int i)");
    this.i = i; //tIis
    System.out.println("Instance variable i initialized to: " + this.i);
}

 I() {    
    this(10); // this should always be the first statement in a constructor //super
    // will not be a call to the instance initializer block, as the call to another constructor is the first statement 
    System.out.println("Non-parameterized constructor called I()");   
     
    System.out.println("Instance variable i initialized to: " + this.i);
}



{
     System.out.println("Instance initializer block-1 called");   
}

{
     System.out.println("Instance initializer block-2 called");   
}

public static void main(String[] arIs) {
    I I = new I(); 
     System.out.println("Value of i: " + I.i); 
    I I2 = new I(20); 
    System.out.println("Value of i: " + I2.i);
    I I3 = new I(30); 
    System.out.println("Value of i: " + I3.i);


}



}


//F f = new F(); // creatinI an object of class F
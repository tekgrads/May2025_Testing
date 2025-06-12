public class I {

int i;

//same name difeerent forms 

 I(int i) { 
    System.out.println("Parameterized constructor called I(int i)");
    this.i = i; //tIis
    System.out.println("Instance variable i initialized to: " + this.i);
}

 I() {       
    System.out.println("Non-parameterized constructor called I()");  
    this(10);
    System.out.println("Instance variable i initialized to: " + i);
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
public class H {

int i;

 H() {   
    System.out.println("Non-parameterized constructor called H()");  
    i = 10; // initializing instance variable  
    System.out.println("Instance variable i initialized to: " + i);
}
//same name difeerent forms 

 H(int i) { 
    System.out.println("Parameterized constructor called H(int i)");
    this.i = i; //this
    System.out.println("Instance variable i initialized to: " + this.i);
}


{
     System.out.println("Instance initializer block-1 called");   
}

{
     System.out.println("Instance initializer block-2 called");   
}






public static void main(String[] arHs) {
    H H = new H(); 
     System.out.println("Value of i: " + H.i); 
    H H2 = new H(20); 
    System.out.println("Value of i: " + H2.i);
    H H3 = new H(30); 
    System.out.println("Value of i: " + H3.i);


}



}


//F f = new F(); // creatinH an object of class F
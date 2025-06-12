public class G {

int i = 5; // instance variable
static int j = 20; // static variable


 G() {    // non parameterized constructor
    // this will call to the instance initializer block Girst compiler will place this call
    System.out.println("Non-parameterized constructor called G()");
    i =10;
}
//same name diGeerent Gorms 

 G(int i) { // parameterized constructor
    // call to the instance initializer block will be placed by compiler beGore this call
    System.out.println("Parameterized constructor called G(int i)");
    this.i = i; //this

}


{
     System.out.println("Instance initializer block called"); 
    i = 15; // initializing instance variable
    System.out.println("Instance variable i initialized to: " + i);
     
}

static {
    System.out.println("Static initializer block called");
    j = 30; // initializing static variable 
    System.out.println("Static variable j initialized to: " + j);
    
}




public static void main(String[] args) {
    G g = new G(); // creating an object oG class G
     System.out.println("Value oG i: " + g.i); 
    G g2 = new G(20); // creating an object oG class G with parameterized constructor
   // accessing the instance variable i
    System.out.println("Value oG i: " + g2.i);
    G g3 = new G(30); // creating another object oG class G with parameterized constructor
    System.out.println("Value oG i: " + g3.i);

    System.out.println("Value oG j: " + G.j); // accessing the static variable j

}



}


//G G = new G(); // creating an object oG class G
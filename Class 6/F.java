public class F {

int i ;

// F() { // non-parameterized constructor
   
// }

F() {    // non parameterized constructor

    System.out.println("Non-parameterized constructor called F()");
    i =10;
}

F(int i) { // parameterized constructor
    System.out.println("Parameterized constructor called F(int i)");
    this.i = i; //this
}



public static void main(String[] args) {
    F f = new F(); // creating an object of class F
     System.out.println("Value of i: " + f.i); 
    F f2 = new F(20); // creating an object of class F with parameterized constructor
   // accessing the instance variable i
    System.out.println("Value of i: " + f2.i);
    F f3 = new F(30); // creating another object of class F with parameterized constructor
    System.out.println("Value of i: " + f3.i);
}



}


//F f = new F(); // creating an object of class F

class InnerClasses {


    int a = 10; // instance variable
    static int b = 20; // static variable

    class A { //non static inner class
       static int c  = 30; // static variable in non-static inner class
        int d = 40; // instance variable in non-static inner class  
        void display() {
            System.out.println("Outer class variable a: " + a);
            System.out.println("Outer class static variable b: " + b);
        }   
    }

   static  class B{
        static int e = 30; // static variable in static inner class
        int f = 40; // instance variable in static inner class
        void display() {
            System.out.println("Outer class variable a: " + a);
            System.out.println("Outer class static variable b: " + b);
        }   
    }

    public static void main(String[] args) {
        class c {

        }
        System.out.println("InnerClasses.main() called");
         System.out.println("Outer class variable a: " + a);
    }


}
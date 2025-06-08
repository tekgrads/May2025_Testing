// Source code is decompiled from a .class file using FernFlower decompiler.
class F {

   static {
      System.out.println("SIB-1 in F");
   }

    static {
      System.out.println("SIB-2 in F");
   }
   
static int i =100;

}

class G {

      static int i = 200;   

    static {
      System.out.println("SIB-1 in G");
   }

   
   public static void main(String[] args) {
      System.out.println("Hello from G!");
      System.out.println("Value of i from class G: " + i);
      System.out.println("Value of i from class F: " + F.i);
    
   }

    static {
      System.out.println("SIB-2 in G");
   }


}


 

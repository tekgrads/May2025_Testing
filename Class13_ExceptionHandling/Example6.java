public class Example6 {

    public static void main(String[] args) {
        System.out.println("Main method Started");
        try {
            test();
        }catch(ArithmeticException e) {
            e.printStackTrace();
        }
      
        System.out.println("Main method Ended");
    }

    static void test() {
        System.out.println("Test method Started");
        // try{
        // int i = 1 / 0;
        // }catch(ArithmeticException e){  if u dont handle it here, handle in caller of test 
        //     e.printStackTrace();
        // }
        int i =1/0;
        System.out.println("Test Method Ended");
    }

}

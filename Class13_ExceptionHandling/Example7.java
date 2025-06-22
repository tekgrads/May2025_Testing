import java.io.File;

public class Example7 {

    public static void main(String[] args) throws InterruptedException  {
        System.out.println("Main method Started");
        test();
        // try {
        //     test();
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        System.out.println("Main method Ended");
    }

    static void test() throws InterruptedException {
        System.out.println("Test method Started");
        // try {
        //     Thread.sleep(100);
        // } catch(InterruptedException e) { if u dont handle here, handle it in main
        //     e.printStackTrace();
        // }
          Thread.sleep(100);
        System.out.println("Test Method Ended");
    }

}

package multiThreading;

public class Test2 {
	 public static void main(String[] args) {
		    System.out.println("main start");
		    Thread th1 = new Thread(); 
		    th1.start();
		    System.out.println("main end");
	   }
}

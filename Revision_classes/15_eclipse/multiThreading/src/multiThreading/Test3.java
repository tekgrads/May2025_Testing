package multiThreading;
// Approach 1
public class Test3 extends Thread {
@Override
public void run() {
	System.out.println("run start");
	System.out.println("run end");
}
public static void main(String[] args) {
	System.out.println("main start");
	Test3 th1 = new Test3();
	th1.start();
	System.out.println("main end");
}
}

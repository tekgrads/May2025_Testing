package multiThreading;

public class Test4 implements Runnable {
	@Override
	public void run() {
		System.out.println("run start");
		System.out.println("run end");	
	}
	public static void main(String[] args) {
		System.out.println("main start");
		Test4 tr = new Test4();
		Thread th1 = new Thread(tr);
		th1.start();
		System.out.println("main end");
	}
}

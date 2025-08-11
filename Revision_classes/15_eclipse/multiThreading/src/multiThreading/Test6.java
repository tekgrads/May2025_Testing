package multiThreading;


public class Test6 implements Runnable {
	@Override
	public void run() {
		for(int i = 0; i<= 20; i++) {
			System.out.println("run: "+ i);
		}
	}
	public static void main(String[] args) {
		System.out.println("main start");
		Test6 t1 = new Test6();
		Thread th1 = new Thread(t1);
		th1.start();
		for(int i = 20; i>=0; i--) {
			System.out.println("main: " + i);
		}
	}

}

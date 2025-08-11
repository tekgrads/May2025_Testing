package multiThreading;

	class Mythread10 extends Thread{
		@Override
		public void run() {
		System.out.println("run start");
		System.out.println("in run s3: " + getState());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("run end");
		}
	}
	public class Test13 {
		public static void main(String[] args) throws InterruptedException {
			System.out.println("main start");
			Mythread10 mt = new Mythread10();
			System.out.println("in main s1: " + mt.getState());
			mt.start();
			System.out.println("in main s2: " + mt.getState());
			Thread.sleep(1000);
			System.out.println("in main s4: " + mt.getState());
			Thread.sleep(3000);
			System.out.println("in main s5: " + mt.getState());
			System.out.println("main end");
		}
}

package multiThreading;
	class Mythread9 extends Thread{
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "run start");
			Mythread9 mt2 = new Mythread9();
			mt2.start(); // infinite loop
			//mt2.run();
			System.out.println("run end");
			
		}
	}
	public class Test12 {
		public static void main(String[] args) {
			System.out.println("main start");
			Mythread9 mt1 = new Mythread9();
			mt1.start();
			System.out.println("main end");
		}
}

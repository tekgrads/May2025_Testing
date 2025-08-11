package multiThreading;

	class Mythread7 extends Thread{
		@Override
		public void run() {
			System.out.println("Mythread7 run method start");
			Mythread8 mt2 = new Mythread8();
			mt2.start();
			System.out.println("Mythread7 run method end");
		}
	}
	class Mythread8 extends Thread{
		@Override
		public void run() {
			System.out.println("mythread8 run method start");
			System.out.println("mythread8 run method end");
		}
	}
	public class Test11 {
		public static void main(String[] args) {
			Mythread7 mt1 = new Mythread7();
			mt1.start();
		}
}

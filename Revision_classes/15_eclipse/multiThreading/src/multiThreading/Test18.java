package multiThreading;
//yield
	class Mythread14 extends Thread{
		@Override
		public void run() {
			for(int i = 0; i <= 10; i++) {
				System.out.println("run: " + i);
			//	Thread.yield();
			}
		}
	}
	public class Test18 {
		public static void main(String[] args) {
			Mythread14 mt = new Mythread14();
			mt.start();
			mt.setPriority(10);
			
			for(int i = 0; i <= 10; i++) {
				System.out.println("main: " + i);
				Thread.yield();

			}
		}

}

package multiThreading;
//sleep
	class Mythread15 extends Thread{
		@Override
		public void run() {
			for(int i = 0; i <= 10; i++) {
				System.out.println("run: " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	public class Test19 {
		public static void main(String[] args) throws Exception{
			Mythread14 mt = new Mythread14();
			mt.start();
			for(int i = 0; i <= 10; i++) {
				System.out.println("main: " + i);
			//	Thread.sleep(1000);

			}
		}
}

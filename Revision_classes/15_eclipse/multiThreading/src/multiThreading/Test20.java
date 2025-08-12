package multiThreading;
	//join:-  one thread waits for other thread to complete
	class Mythread16 extends Thread{
		static Thread mt;
		@Override
		public void run() {
			try {
				mt.join();         // child waiting for main
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			for(int i = 0; i <= 10; i++) {
				System.out.println("run: " + i);
			}
			
		}
	}
	public class Test20 {
		public static void main(String[] args) throws Exception{
			System.out.println("main start");
			Mythread16 t1 = new Mythread16();
			Mythread16.mt = Thread.currentThread();
			 t1.start();
			 t1.join();   // main waiting for child
		//	 t1.join(100);
			for(int i = 0; i <= 10; i++) {
				System.out.println("main: " + i);
			}

			}
}

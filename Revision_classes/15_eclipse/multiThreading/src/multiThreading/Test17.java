package multiThreading;
	//Daemon thread
/*	
	class Mythread13 extends Thread{
		
	}
	public class Test17 {
		public static void main(String[] args) {
			System.out.println(Thread.currentThread().isDaemon());
		//	Thread.currentThread().setDaemon(true);// IllegalThreadStateException
			Mythread13 mt = new Mythread13();
			System.out.println(mt.isDaemon());
			mt.setDaemon(true);
			System.out.println(mt.isDaemon());
			
		}
}
	*/
	 class Mythread13 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i <= 10; i++) {
			System.out.println("run: " + i);
		}
	}
}
public class Test17 {
	public static void main(String[] args) {
		System.out.println("main thread start");
		Mythread13 mt = new  Mythread13();
		mt.setDaemon(true);
		mt.start();
		System.out.println("main thread end");
	}

}


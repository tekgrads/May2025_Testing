package multiThreading;

	class Addition1{
		private static int x; 
		private static int y;
	//	static void add(int x , int y) {
		static synchronized void add(int x , int y) {
			Addition1.x = x;
			Addition1.y = y;
			// calling sleep 
		/*	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		*/	
		int res = x + y;
		System.out.println(Thread.currentThread().getName() + " Result : "+ res);
		}	
	}
	class Thread3 extends Thread{
		@Override
		public void run() {
			Addition1.add(50, 60);
		}
	}
	class Thread4 extends Thread{
		@Override
		public void run() {
			Addition1.add(70, 80);
		}
	}

	public class Test22 {
		public static void main(String[] args) {
			Addition a = new Addition();
			Thread3 t1 = new Thread3();
			Thread4 t2 = new Thread4();
			t1.start();
			t2.start();
		}
}

package multiThreading;
	class Addition{
		private int x; 
		private int y;
	//	void add(int x , int y) {
		synchronized void add(int x , int y) {
			this.x = x;
			this.y = y;
			// calling sleep 
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		int res = this.x + this.y;
		System.out.println(Thread.currentThread().getName() + " Result : "+ res);
		}	
	}
	class Thread1 extends Thread{
		private Addition a;
		public Thread1(Addition a){
			this.a = a;
		}
		@Override
		public void run() {
			a.add(50, 60);
		}
	}
	class Thread2 extends Thread{
		private Addition a;
		public Thread2(Addition a){
			this.a = a;
		}
		@Override
		public void run() {
			a.add(70, 80);
		}
	}

	public class Test21 {
		public static void main(String[] args) {
			Addition a = new Addition();
			Thread1 t1 = new Thread1(a);
			Thread2 t2 = new Thread2(a);
			t1.start();
			t2.start();
		}
}

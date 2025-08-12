package multiThreading;
	//synchronized block
	class DisplayNumbers{
		synchronized void printNum() {
		//void printNum(){
			String name = Thread.currentThread().getName();
			System.out.println(name+ " started");
			for(int i = 0; i <=20; i++) {
				System.out.println(name + "run: "+ i);
			}
			for(int i = 30; i <=50; i++) {
				System.out.println(name + "run: "+ i);
			}
		/*	synchronized (this) {
				for(int i = 30; i <=50; i++) {
					System.out.println(name + "run: "+ i);
				}
			}
			*/
			System.out.println(name + " end");
		}
	}
	class Thread5 extends Thread{
		private DisplayNumbers dn;
		public Thread5(DisplayNumbers dn) {
			this.dn = dn;
		}
		@Override
		public void run() {
			dn.printNum();
		}
	}
	class Thread6 extends Thread{
		private DisplayNumbers dn;
		public Thread6(DisplayNumbers dn) {
			this.dn = dn;
		}
		@Override
		public void run() {
			dn.printNum();
		}
	}
	public class Test23 {
		public static void main(String[] args) {
			DisplayNumbers d1 = new DisplayNumbers();
			Thread5 t1 = new Thread5(d1);
			Thread6 t2 = new Thread6(d1);
			t1.start();
			t2.start();
		}
}

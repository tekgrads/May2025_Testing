package multiThreading;

	class PrintNumbers{
		synchronized void printnum1() {
			for(int i = 1; i<= 10; i++) {
				System.out.println(Thread.currentThread().getName()+ "run: " + i );
			}
		}
		 void printnum2() {
			for(int i = 31; i<= 40; i++) {
				System.out.println(Thread.currentThread().getName()+ "run: " + i );
			}
		}
	}
	class Thread7  extends Thread{
		private PrintNumbers pn;
		public Thread7(PrintNumbers pn) {
			this.pn = pn;
		}
		@Override
		public void run() {
			pn.printnum1();
		}
	}
	class Thread8  extends Thread{
		private PrintNumbers pn;
		public Thread8(PrintNumbers pn) {
			this.pn = pn;
		}
		@Override
		public void run() {
			pn.printnum2();
		}
	}
	public class Test24 {
		public static void main(String[] args) {
			PrintNumbers p1 = new PrintNumbers();
			Thread7 t1 = new Thread7(p1);
			Thread8 t2 = new Thread8(p1);
			t1.start();
			t2.start();
		}

	
}

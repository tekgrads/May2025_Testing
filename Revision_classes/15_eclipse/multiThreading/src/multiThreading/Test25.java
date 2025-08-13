package multiThreading;
//Deadlock
	class FirstClass{
		synchronized void m1(SecondClass sc) {
			String name = Thread.currentThread().getName();
			System.out.println(name + "is started by locking fc object");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println( name + " is trying to call sc.m4()");
			sc.m4();
			System.out.println( name + " end");
		}
		
		synchronized void m2() {
	//	void m2() {
			System.out.println("FC.m2 is executed");
		}

		
	}

	class SecondClass{
		synchronized void m3(FirstClass fc) {
			String name = Thread.currentThread().getName();
		    System.out.println(name + " is started by locking sc object");
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		    System.out.println(name + "is trying to call fc.m2()");
		    fc.m2();
		    System.out.println( name + " end");
		}
		synchronized void  m4() {
			System.out.println("sc.m4 is executed");
		}
	}
	class FCThread extends Thread {
		

		private FirstClass fc;
		private SecondClass sc;

		
		public FCThread(FirstClass fc, SecondClass sc) {
			this.fc = fc;
			this.sc = sc;
		}

		@Override
		public void run() {
			fc.m1(sc);
		}
	}

	class SCThread extends Thread {
		private SecondClass sc;
		private FirstClass fc;

		public SCThread(SecondClass sc, FirstClass fc) {
			this.sc = sc;
			this.fc = fc;
		}

		@Override
		public void run() {
			sc.m3(fc);
		}
	}

	public class Test25 {
		public static void main(String[] args) {
			
			FirstClass 	fc = new FirstClass();
			SecondClass sc = new SecondClass();
			
			FCThread fct = new FCThread(fc, sc);
			SCThread sct = new SCThread(sc, fc);
			
			fct.start();
			sct.start();
			
		}
}

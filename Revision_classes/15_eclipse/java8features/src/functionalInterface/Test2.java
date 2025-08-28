package functionalInterface;
/*
class MyRunnable implements Runnable{
	@Override
	public void run() {
		for(int i = 0; i <= 10; i++) {
			System.out.println("run : " + i);
		}
	}
}
	public  class Test2 {
	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		Thread th = new Thread(mr);
		th.start();
		for(int i = 0; i<= 10; i++) {
			System.out.println("main" + i);
		}
	}
  }
*/
//Anonymous inner class

public class Test2{
	public static void main(String[] args) {
		Runnable r = new Runnable() {	
			@Override
			public void run() {
				for(int i = 0; i <= 10; i++) {
					System.out.println("run : " + i);
				}
				
			}
		};
		Thread th = new Thread(r);
		th.start();
		for(int i = 0; i<= 10; i++) {
			System.out.println("main" + i);
		}
	}
}


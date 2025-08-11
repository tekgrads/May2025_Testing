package multiThreading;
//print numbers 1-20 and 20 -1 by executing 2 tasks
public class Test5 extends Thread{	
	@Override
	public void run() {
		for(int i = 0; i<=20; i++) {
			System.out.println("run: " +i);
		}
	}
	public static void main(String[] args) {
		Test5 th1 = new Test5();
		th1.start();
		for(int i = 20; i >=0; i--) {
			System.out.println("main: "+i);
		}
	}
}

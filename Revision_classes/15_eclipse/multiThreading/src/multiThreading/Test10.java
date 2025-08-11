package multiThreading;
class Mythread6 extends Thread{
	@Override
	public void start() {
		System.out.println("start method is executed from mythread class" );
	//	super.start();
	}
	@Override
	public void run() {
		System.out.println("run method is executed from mythread class");
	}
	
}
public class Test10 {
	public static void main(String[] args) {
		System.out.println("main start");
		Mythread6 mt1 = new Mythread6();
		mt1.start();
		Mythread6 mt2 = new Mythread6();
		mt2.start();
		System.out.println("main end");
	}


}

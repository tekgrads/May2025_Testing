package multiThreading;
// print numbers 1 2 3 4...20  using two threads executing sequentially one thread printing odd number
// another thread printing even numbers
class printOddEven{
	private boolean printed;
	public synchronized void printOdd(int num) {
		if(printed) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(num + " ");
		printed = true;
		notify();
	}
	public synchronized void printEven(int num) {
		if(!printed) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(num + " ");
		printed = false;
		notify();
	}
	
}
class oddThread extends Thread{
	private printOddEven poe;
	public oddThread(printOddEven poe) {
		this.poe = poe;
	}
	@Override
	public void run() {
		for(int i = 1; i<= 20; i= i+2) {
			poe.printOdd(i);
		}
	}
}
class evenThread extends Thread{
	private printOddEven poe;
	public evenThread(printOddEven poe) {
		this.poe = poe;
	}
	@Override
	public void run() {
		for(int i = 2; i<= 20; i= i+2) {
			poe.printEven(i);
		}
	}
}
public class Test30 {
	public static void main(String[] args) {
		printOddEven p1 = new printOddEven();
		oddThread ot = new oddThread(p1); 
		evenThread et = new evenThread(p1); 
		ot.start();
		et.start();
		}

}

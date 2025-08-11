package multiThreading;
class Mythread4 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i <= 10; i++) {
			System.out.println(getName() + " run: " + i);
		}
	}
}
public class Test8 {
	public static void main(String[] args) {
		Mythread4 mt1 = new Mythread4();
		mt1.start();
		Mythread4 mt2 = new Mythread4();
		mt2.start();
		
		Mythread4 mt3 = new Mythread4();
		mt3.start();	
	}
}

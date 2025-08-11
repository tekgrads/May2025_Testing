package multiThreading;
class Mythread5 extends Thread{
	private int x;
	public Mythread5(int x) {
		this.x = x;
	}
	@Override
	public void run() {
		for(int i = 0; i<= x; i++)
		System.out.println(getName() + " run: " + i );
	}
}
public class Test9 {
	public static void main(String[] args) {
		Mythread5 mt1 = new Mythread5(10);
		mt1.start();
		Mythread5 mt2 = new Mythread5(15);
		mt2.start();
	}
}

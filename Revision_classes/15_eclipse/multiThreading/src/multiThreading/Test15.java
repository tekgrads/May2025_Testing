package multiThreading;

	class Mythread12 extends Thread{
		@Override
		public void run() {
			for(int i = 0; i<= 20; i++)
			System.out.println(Thread.currentThread().getName() + "  "+ i);
		}
	}
	public class Test15 {
		public static void main(String[] args) {
			Mythread12 mt1 = new Mythread12();
			Mythread12 mt2 = new Mythread12();
			System.out.println(mt1.getPriority());
			System.out.println(mt2.getPriority());
		//	mt1.start();
		//	mt2.start();
			mt1.setPriority(10);
			mt2.setPriority(2);
		//	mt1.start();
		//	mt2.start();
			
			// thread name
			System.out.println(mt1.getName());
			mt1.setName("child2");
			System.out.println(mt1.getName());
			//thread id
			System.out.println(mt1.getId());
			System.out.println(mt2.getId());
			
		}
}

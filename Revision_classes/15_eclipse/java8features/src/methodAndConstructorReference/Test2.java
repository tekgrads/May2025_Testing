package methodAndConstructorReference;
/*
public class Test2 {
	public static void main(String[] args) {
		Runnable r = () ->{
			for(int i = 0; i<= 10; i++) {
				System.out.println("run " + i);
			}
		};
		Thread th = new Thread(r);
		th.start();
		for(int i = 0; i<= 10; i++) {
			System.out.println("main " + i);
		}
	}

}
*/
public class Test2{
	public  void m1() {
		for(int i = 0; i<= 10; i++) {
			System.out.println("run " + i);
		}
	}
	
	public static void main(String[] args) {
		Test2 t = new Test2();
		Runnable r = t :: m1;   // object ref :: method name
		Thread th = new Thread(r);
		th.start();
		for(int i = 0; i<= 10; i++) {
			System.out.println("main " + i);
		}
	}
	
}
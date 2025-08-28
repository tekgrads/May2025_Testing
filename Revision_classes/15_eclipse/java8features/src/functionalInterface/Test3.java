package functionalInterface;

public class Test3 {
	public static void main(String[] args) {
		Runnable r = () -> {
			 for(int i = 0; i<= 10; i++) {
				 System.out.println("run:" + i);
			 }
		};
		Thread th = new Thread(r);
		th.start();
		for(int i = 0; i<= 10; i++) {
			 System.out.println("main:" + i);
		 }
		
	}

}

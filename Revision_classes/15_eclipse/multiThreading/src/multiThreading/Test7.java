package multiThreading;

class Mythread extends Thread{
	@Override
	public void run() {
	for(int i = 0; i<= 20; i++) {
		System.out.println("run: "+i);
	}
	}
}
public class Test7 {
   public static void main(String[] args) {
	
	Mythread th = new Mythread();
	/*
	//case1 - calling run directly
	th.run();
	
	//case2 - calling run 1st and start
	th.run();
	th.start();
	
	// case3 - calling start 1st and run
	th.start();
	th.run();
	
	//case4 - calling start 2 times(starting same thread twice)
	th.start();
//	th.start();
 */
	for(int i = 20; i >= 0; i--) {
		System.out.println("main: " + i);
	}
}
}


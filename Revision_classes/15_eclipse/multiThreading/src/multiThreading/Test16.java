package multiThreading;

public class Test16 {
	public static void main(String[] args) {
		Thread th1 = Thread.currentThread();
		ThreadGroup tg1 = th1.getThreadGroup();
	//	System.out.println(th1.getName());
	//	System.out.println(tg1.getName());
		Thread th2 = new Thread();
		Thread th3 = new Thread();
		System.out.println(th2.getThreadGroup().getName());
		ThreadGroup groupA = new ThreadGroup("groupA");
		Thread th4 = new Thread(groupA, "child1");
		Thread th5 = new Thread(groupA, "child2");
		System.out.println(th4.getName()+ "---" + th4.getThreadGroup().getName());
		System.out.println(th5.getName()+ "---" + th5.getThreadGroup().getName());
	}
}

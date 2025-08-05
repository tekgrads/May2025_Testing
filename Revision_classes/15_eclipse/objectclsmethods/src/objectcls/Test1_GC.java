package objectcls;

public class Test1_GC {
	public static void main(String[] args) {
		Ex_GC e1 = new Ex_GC();

		new Ex_GC();

		e1 = new Ex_GC();

		e1 = null;
		
		System.out.println();
		System.gc(); //Requesting JVM to run gc

		try{Thread.sleep(100);}//pausing main method execution to all gc to run
		catch(Exception e){ }
	}

}

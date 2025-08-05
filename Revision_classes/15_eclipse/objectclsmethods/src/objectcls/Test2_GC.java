package objectcls;

public class Test2_GC {
	public static void main(String[] args) {
		Ex_GC e1 = new Ex_GC();
		Ex_GC e2 = new Ex_GC();
		Ex_GC e3 = new Ex_GC();
		Ex_GC e4 = e3;
		

		e3 = new Ex_GC();

		e2 = e1;
		
		e1 = new Ex_GC();

		e2 = null;

		System.gc();
		try{Thread.sleep(1000);	}
		catch(Exception e){	}
	}
}



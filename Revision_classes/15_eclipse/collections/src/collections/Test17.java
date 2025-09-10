package collections;

import java.util.HashMap;
import java.util.WeakHashMap;

class Temp{
	String temp;

	@Override
	public String toString() {
		return "temp";
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("finalize is executed");
	}
	
}
public class Test17 {
	public static void main(String[] args) throws InterruptedException {
	//	HashMap m = new HashMap();
		WeakHashMap  m = new WeakHashMap();
		Temp t = new Temp();
		m.put(t, "abc");
		System.out.println(m);
		t = null; 
		System.gc();
		Thread.sleep(5000);
		System.out.println(m);
	}
}



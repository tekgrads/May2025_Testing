package collections;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class Test16 {
	public static void main(String[] args) {
	//	HashMap m = new HashMap();
		IdentityHashMap m = new IdentityHashMap();
		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);
		m.put(i1, "hyd");
		m.put(i2, "tekgrads");
		System.out.println(m);
	}

}

package concurrentCollections;

import java.util.concurrent.ConcurrentHashMap;

public class Test2 {
	public static void main(String[] args) {
		ConcurrentHashMap m = new ConcurrentHashMap();
		m.put(101, "ABC");
	//	m.put(101, "XYZ");
		System.out.println(m);
		m.putIfAbsent(101, "PQR");
		System.out.println(m);
		m.remove(101, "abc");
		System.out.println(m);
		m.remove(101, "ABC");
		System.out.println(m);
		m.put(101, "Raju");
		System.out.println(m);
		m.replace(101, "Raju", "RAM");
		System.out.println(m);
		
	}

}

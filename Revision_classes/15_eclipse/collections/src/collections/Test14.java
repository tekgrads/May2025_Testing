package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test14 {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("ram", 700);
		hm.put("sita", 900);
		hm.put("ramya", 200);
		hm.put("swetha", 500);
		System.out.println(hm);
		System.out.println(hm.put("ram", 1000));
		System.out.println(hm.put("abc", 123));
		System.out.println(hm);
	
		Set<String> s = hm.keySet();
		System.out.println(s);
		
		Collection<Integer> c = hm.values();
		System.out.println(c);
		
		Set s1 = hm.entrySet();
		System.out.println(s1);
		
		Iterator itr = s1.iterator();
		while(itr.hasNext()) {
			Map.Entry<String, Integer> m1 = (Entry<String, Integer>) itr.next();
			System.out.println(m1.getKey() + "-----" + m1.getValue());
			if(m1.getKey() == "sita") {
				m1.setValue(999);
			}
		}
		System.out.println(hm);
		
	}

}

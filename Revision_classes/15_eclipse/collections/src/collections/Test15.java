package collections;

import java.util.LinkedHashMap;

public class Test15 {
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		lhm.put("ram", 700);
		lhm.put("sita", 900);
		lhm.put("ramya", 200);
		lhm.put("swetha", 500);
		System.out.println(lhm);
	}

}

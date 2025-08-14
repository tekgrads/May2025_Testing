package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test1 {
	public static void main(String[] args) {
		String[] str = new String[10];
		str[0] = "abc";
		str[1] = "xyz";
	//	str[2] = 10;
	//	str[3] = true;
		str[4] = "pqr";
		String s = str[0];
		
		ArrayList al = new ArrayList();
		al.add("abc");
		al.add(10);
		al.add(true);
		al.add(10.5);
		al.add('c');
		String s1 = (String) al.get(0);
		int i = (int) al.get(1);
		
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("abc");
	//	al1.add(10);
//		al1.add(true);
//		al1.add(10.5);
//		al1.add('c');
		String s2 = al1.get(0);
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		List<Integer> al3 = new ArrayList<Integer>();
		Collection<Integer> al4 = new ArrayList<Integer>();
	//	ArrayList<int> al5 = new ArrayList<int>();
		
				
	}

}

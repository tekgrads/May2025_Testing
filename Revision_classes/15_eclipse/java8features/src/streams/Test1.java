package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(0);
		al.add(10);
		al.add(20);
		al.add(5);
		al.add(15);
		al.add(25);
		System.out.println(al);
		// without streams
		
	/*	List<Integer> l = new ArrayList<Integer>();
		
	    for(Integer i : al) {
			if(i % 2 == 0) {
				l.add(i);
			}
		}
	
		System.out.println(l);
		*/
		
		// with streams
		
		List<Integer> l = al.stream().filter(I -> I % 2 == 0).collect(Collectors.toList());
		System.out.println(l);
		
		List<Integer> l1 = al.stream().map(I -> I * 2).collect(Collectors.toList());
		System.out.println(l1);
		
		List<Integer> l2 = al.stream().filter(I -> I % 2 == 1) .map(I -> I * 3).collect(Collectors.toList());
		System.out.println(l2);
		
	}

}

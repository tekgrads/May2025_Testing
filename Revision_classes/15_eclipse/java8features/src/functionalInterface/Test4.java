package functionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
public class Test4 {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(0);
		al.add(15);
		al.add(5);
		al.add(20);
		System.out.println("Before sorting: " + al );
		Collections.sort(al, new MyComparator());
		System.out.println("After sorting: " + al);
	}

}
class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer I1, Integer I2) {
		return (I1 >I2) ? -1 : (I1< I2)? 1 :0;
	//	condition ? true: false
	}
	
}
*/
// with lambda expression
public class Test4 {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(0);
		al.add(15);
		al.add(5);
		al.add(20);
		System.out.println("Before sorting: " + al );
		Collections.sort(al,(I1, I2)-> I1 > I2 ? -1 : I1 < I2 ? 1 : 0);
		System.out.println("After sorting: " + al);
	}

}


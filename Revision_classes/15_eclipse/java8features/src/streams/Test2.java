package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
  public static void main(String[] args) {
	ArrayList<Integer> al = new ArrayList<Integer>();
	al.add(0);
	al.add(10);
	al.add(20);
	al.add(5);
	al.add(15);
	al.add(25);
	System.out.println(al);
	List<Integer> l1 = al.stream().sorted().collect(Collectors.toList());
	System.out.println(l1);
	
	List<Integer> l2 = al.stream().sorted((i1, i2) -> i2.compareTo(i1)).collect(Collectors.toList());
	System.out.println(l2);
	
	Integer min = al.stream().min((i1, i2) -> i1.compareTo(i2)).get();
	System.out.println("min value: " + min);
	
	Integer max = al.stream().max((i1, i2) -> i1.compareTo(i2)).get();
	System.out.println("max value: " + max);
	
	al.stream().forEach(i -> System.out.println(i));
	
}

}

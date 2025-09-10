package collections;

import java.util.Comparator;
import java.util.TreeSet;

//class Employee implements Comparable {
	class Employee  {
	int eid;
	String name;
	public Employee(int eid, String name) {
		this.eid = eid;
		this.name = name;
	}
	@Override
	public String toString() {
		return "eid: " + eid + " name: " + name;
	}
/*	@Override
	public int compareTo(Object o) {
		int eid1 = this.eid;
		Employee e = (Employee)o;
		int eid2 = e.eid;
		if(eid1 < eid2) {
			return 1;
		}
		else if(eid1 > eid2) {
			return -1;
		}
		return 0;
	}
	*/
	
}
class myComparator1 implements Comparator{
	public int compare(Object o1, Object o2) {
		Employee e1 = (Employee) o1;
		Employee e2 = (Employee) o2;
//		String s1 = e1.name;
//		String s2 = e2.name;
//		return s1.compareTo(s2);
		return (e1.name).compareTo(e2.name);
	}
}
public class Test13 {
	public static void main(String[] args) {
		TreeSet<Employee> ts = new TreeSet<Employee>();
		Employee e1 = new Employee(102, "Abc");
		Employee e2 = new Employee(104, "Xyz");
		Employee e3 = new Employee(103, "Pqr");
		Employee e4 = new Employee(105, "Klm");
		Employee e5 = new Employee(101, "Ram");
/*		ts.add(e1);
		ts.add(e2);
		ts.add(e3);
		ts.add(e4);
		ts.add(e5);
		System.out.println(ts);
		*/
		System.out.println();
		TreeSet<Employee> ts1 = new TreeSet<Employee>(new myComparator1());
		ts1.add(e1);
		ts1.add(e2);
		ts1.add(e3);
		ts1.add(e4);
		ts1.add(e5);
		System.out.println(ts1);
		
	}

}
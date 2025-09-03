package collections;

import java.util.HashSet;

class Student{
	Integer sno;
	Integer marks;
	Student(Integer sno, Integer marks){
		this.sno = sno;
		this.marks = marks;
	}
	@Override
	public int hashCode() {
	return	sno.hashCode() + marks.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student s) {
			return this.sno == s.sno && this.marks == s.marks;
		}
		return false;
	}
	@Override
	public String toString() {
		return "sno=" + sno + ", marks=" + marks ;
	}	
	
}
public class Test9 {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		Student s1 = new Student(10, 56);
		Student s2 = new Student(56, 10);
		Student s3 = new Student(11, 100);
		Student s4 = new Student(12, 35);
		Student s5 = new Student(10, 56);
		System.out.println("hashcode of s1 is " + s1.hashCode());
		System.out.println("Adding s1: " + hs.add(s1));
		System.out.println();
		System.out.println("hashcode of s2 is " + s2.hashCode() );
		System.out.println("Adding s2: " + hs.add(s2));
		System.out.println();
		System.out.println("hashcode of s3 is " + s3.hashCode());
		System.out.println("Adding s3: " + hs.add(s3));
		System.out.println();
		System.out.println("hashcode of s4 is " + s4.hashCode());
		System.out.println("Adding s4: " + hs.add(s4));
		System.out.println();
		System.out.println("hashcode of s5 is " + s5.hashCode());
		System.out.println("Adding s5: " + hs.add(s5));
		System.out.println();
		
		System.out.println(hs);
		System.out.println(hs.size());
		
		
	}

}

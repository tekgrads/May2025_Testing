package stringHandling;
//swapping two string without third variable
public class Test7 {
	public static void main(String[] args) {
		String s1 = "abc"; // 3
		String s2 = "hello"; // 5
		System.out.println("s1: " + s1);
		System.out.println("s2: " +s2);
		s1 = s1 + s2; //abchello // length is 8
		s2 = s1.substring(0, s1.length() - s2.length());  //(0 , 8 - 5 )
		s1 = s1.substring(s2.length());
		System.out.println("s1: " + s1);
		System.out.println("s2: " +s2);
	}

}

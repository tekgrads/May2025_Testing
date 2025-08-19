package stringHandling;
// reverse a string  using recursion algorithm
public class Test6 {
	public static void main(String[] args) {
		String s1 = "hello";
		System.out.println("initial: " + s1);
		s1 = reverse(s1);
		System.out.println("final: " + s1);
	}

	private static String reverse(String str) {
		if(str.length() == 1) {
			return str;
		}
		return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length()-1));
	}

	

}

package stringHandling;
// find the length of a string without using length()
public class Test8 {
	public static void main(String[] args) {
		String s1 = "hello";
		int i = (s1 + "a").lastIndexOf("a");
		System.out.println(i);
		System.out.println(s1);
	}

}

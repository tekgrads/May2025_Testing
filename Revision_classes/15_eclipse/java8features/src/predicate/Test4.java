package predicate;

import java.util.function.Predicate;

// string starts with letter k
/*
public class Test4 {
	public static void main(String[] args) {
		String[] s = {"kite", "Orange", "key", "camera" };
		Predicate<String> startsWithK = s1 -> s1.startsWith("k");
		System.out.println("names starts with k are:");
		for(String s1: s) {
			if(startsWithK.test(s1)) {
				System.out.println(s1);
			}
		}

	}

}
*/
// Example to remove null values and empty strings
public class Test4{
	public static void main(String[] args) {
		String[] s = {"java", "null", "", "hyd", "Tekgrads"};
		Predicate<String> removeValues = s1 -> s1.length()!= 0 && s1 != "null";
		System.out.println("Result after removing");
		for(String s1 : s) {
			if(removeValues.test(s1)) {
				System.out.println(s1);
			}
		}
 	}
}


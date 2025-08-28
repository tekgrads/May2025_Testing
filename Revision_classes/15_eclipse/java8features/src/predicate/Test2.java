package predicate;

import java.util.function.Predicate;
//length of string >5 or not
public class Test2 {
	public static void main(String[] args) {
		Predicate<String> p = s -> s.length()>5;
		System.out.println(p.test("Java"));
		System.out.println(p.test("Tekgrads"));
	}

}

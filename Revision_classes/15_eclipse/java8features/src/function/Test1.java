package function;

import java.util.function.Function;

public class Test1 {
	public static void main(String[] args) {
		Function<String, Integer> f = s ->s.length();
		System.out.println(f.apply("Hyderabad"));
		System.out.println(f.apply("Tekgrads"));
	}

}

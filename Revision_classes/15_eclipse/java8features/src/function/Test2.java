package function;

import java.util.function.Function;

public class Test2 {
	public static void main(String[] args) {
		Function<String, String> f = s -> s.replace(" ", "");
		System.out.println(f.apply("core java"));
		System.out.println(f.apply("Tekgrads  Hyderabad"));
	}

}
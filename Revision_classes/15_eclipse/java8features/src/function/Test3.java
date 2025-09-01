package function;

import java.util.function.Function;

public class Test3 {
	public static void main(String[] args) {
		Function<String, String> f1 = s -> s.toUpperCase();
		Function<String, String> f2 = s -> s.substring(4,9);
		System.out.println(f1.apply("telangana"));
		System.out.println(f2.apply("telangana"));
		
		System.out.println(f1.andThen(f2).apply("hyderabad"));
		
		System.out.println(f2.andThen(f1).apply("hyderabad"));
		
 	}
 	

}

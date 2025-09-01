package bifunctionalInterfaces;

import java.util.function.BiFunction;

public class Test2 {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> f = (a , b) -> a * b;
		System.out.println(f.apply(15, 25));
		System.out.println(f.apply(30, 13));
	}
	

}

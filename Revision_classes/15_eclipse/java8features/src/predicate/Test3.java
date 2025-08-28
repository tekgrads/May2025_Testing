package predicate;

import java.util.function.Predicate;

//predicate joining
public class Test3 {
	public static void main(String[] args) {
		int[] x = {0, 5, 10, 15, 20, 25,30};
		Predicate<Integer> p1 = I -> I > 10;
		Predicate<Integer> p2 = I -> I%2 == 0;
	//	System.out.println("The no's greater than 10 are:");
	//	m1(p1, x);
	//	System.out.println("The even no's are: ");
	//	m1(p2, x);
		System.out.println("The number not greater than 10");
		m1(p1.negate(), x);
		System.out.println("The number > 10 or even are :");
		m1(p1.or(p2), x);
		System.out.println("The number > 10 and even are :");
		m1(p1.and(p2), x);
	
	}

	public static void m1(Predicate<Integer> P, int[] x) {
		for(int x1 : x) {
			if(P.test(x1)) {
				System.out.println(x1);
			}
		}
	}

}
// for(datatype of array ref.var name : array name){ }

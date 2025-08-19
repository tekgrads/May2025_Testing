package stringHandling;

public class Test1 {
	public static void main(String[] args) {
	//	System.out.println(abc);
		System.out.println("abc");
		char[] ca = {'j','a','v','a'};
		System.out.println(ca);
		System.out.println();
		String s1 = "java";
		System.out.println(s1);
		s1.concat("Tekgrads");
		System.out.println("s1:" + s1);
		String s2 = s1.concat("Tekgrads");
		System.out.println(s2);
		String s3 = s2.concat("Hyd");
		System.out.println(s3);
		
		StringBuffer sb1 = new StringBuffer("Tekgrads");
		System.out.println(sb1);
		sb1.append(" Hyderabad");
		System.out.println("sb1:" + sb1);
		
		StringBuilder sb2 = new StringBuilder("java");
		System.out.println(sb2);
		sb2.append("Developer");
		System.out.println("sb2:" +sb2);
		
	}

}

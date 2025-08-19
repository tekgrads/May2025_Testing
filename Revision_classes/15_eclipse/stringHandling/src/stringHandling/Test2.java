package stringHandling;

public class Test2 {
	public static void main(String[] args) {
		String s1 = "abc";
	//	StringBuffer sb1 = "abc";
		//StringBuilder sb2 = "abc";
		String 			s3	= "Raju1";
		StringBuffer	sb3 = new StringBuffer("Raju2"); 
		StringBuilder	sb4 = new StringBuilder("Raju3");
    //=======================================================================		
		CharSequence cs1 = s3;
		CharSequence cs2 = sb3;
		CharSequence cs3 = sb4;
			
		m1(s3);
		m1(sb3);
		m1(sb4);
	}
	static void m1(CharSequence cs) {
		System.out.println(cs);
		
	//	cs.concat("xyz"); //String specific method, not allowed to call by using cs
	//	cs.append("xyz"); //SBuffer specific method, not allowed to call by using cs
		
		char ch = cs.charAt(4); //allowed, this CS specific method common to S, SB and SB
		System.out.println(ch);
	}

}

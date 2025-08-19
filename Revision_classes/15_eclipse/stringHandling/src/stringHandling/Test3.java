package stringHandling;

public class Test3 {
	public static void main(String[] args) {
		String s1 = "Tekgrads";
		String s2 =  new String("Hyd");
	//	String Pooling and 'String Constant Pooled Area' (SCPA)
		
		String s3 = "xyz";					
	//	String s3 = "abc";					
					
		String s4 = "xyz";					
		
		String s5 = new String("Telangana");	
		String s6 = new String("Telangana"); 
		
		System.out.println(s3 == s4); 		
		System.out.println(s5 == s6); 		
		
	
		String s7 = "XYZ";					
		System.out.println(s3 == s7);		
		
		String s8 = "Hyderabad";					
		String s9 = new String("Hyderabad");	
		System.out.println(s8 == s9);		
		
		
		String s10 = new String("ABC");		
		String s11 = "ABC";				
		System.out.println(s10 == s11);		
	
		String s12 = "a";					
		String s13 = "b";					
		String s14 = s12 + s13;							
		String s15 = "ab";
		String s16 = s12 + "b";
		System.out.println(s14 == s15); 	
		System.out.println(s15 == s16); 	
		
	
		
		String s17 = "b" + "c";	//=>"bc"	
		String s18 = "bc";					
		System.out.println(s17 == s18);		
		
	
	}

}

package stringHandling;

public class Test5 {
public static void main(String[] args) {
		
		StringBuilder sb1 = new StringBuilder();
		System.out.println("sb1: "+ sb1);
		System.out.println("sb1: "+ sb1.length());
		System.out.println("sb1: "+ sb1.capacity());
		System.out.println();
		
		StringBuilder sb2 = new StringBuilder(5); 
		System.out.println("sb2: "+ sb2);
		System.out.println("sb2: "+ sb2.length());
		System.out.println("sb2: "+ sb2.capacity());
		System.out.println();	
		
		StringBuilder sb3 = new StringBuilder("Ram");
		System.out.println("sb3: "+ sb3);
		System.out.println("sb3: "+ sb3.length());
		System.out.println("sb3: "+ sb3.capacity());
		System.out.println(); 
		
		StringBuilder sb4 = new StringBuilder(sb3);
	//	StringBuilder sb4 = new StringBuilder("Ramu");
		System.out.println("sb4: "+ sb4);
		System.out.println("sb4: "+ sb4.length());
		System.out.println("sb4: "+ sb4.capacity());
		System.out.println();
		
		sb3.append("Tekgrads");
		System.out.println("sb3: "+ sb3);
		System.out.println("sb3: "+ sb3.length());
		System.out.println("sb3: "+ sb3.capacity());
		System.out.println(); 
		
		System.out.println("sb4: "+ sb4);

	//	StringBuilder sb5 = new StringBuilder(null); //no CE, String param is matched
													 //RE: NPE

				
	}

}

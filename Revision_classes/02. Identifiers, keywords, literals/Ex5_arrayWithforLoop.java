class Ex5_arrayWithforLoop {

	public static void main(String[] args) {

		int[] ia1 = {3, 4, 5, 6, 7};
		int[] ia2 = {3, 4, 5, 6, 7,8, 9};
/*
		for(int i=0;  i<5; i++) { 
			System.out.println(ia[i]);	
		}	
		
		for(int i=0;  i<7; i++) { 
			System.out.println(ia[i]);	
		}		
		*/
	//	System.out.println(ia.length);	
		for(int i=0; i<ia1.length; i++) { 
			System.out.println(ia1[i]);	
		}	
		System.out.println();	
		for(int i=0; i<ia2.length; i++) { 
			System.out.println(ia2[i]);	
		}	
	}	
}	
class Ex4_array {
	public static void main(String[] args) {

		int[] ia = {10, 20, 30, 40, 50};
	
		
		System.out.println("ia   : "+ ia);		// memory location
		System.out.println("ia[0]: "+ ia[0]);	//10
		System.out.println("ia[1]: "+ ia[1]);	//20
		System.out.println("ia[2]: "+ ia[2]);	//30
		System.out.println("ia[3]: "+ ia[3]);	//40
		System.out.println("ia[4]: "+ ia[4]);	//50
		ia[1] = 15;
		System.out.println("ia[1]: "+ ia[1]);	//15
		ia[3] = ia[0] + ia[1];
		System.out.println("ia[3]: "+ ia[3]);	//25
     //  System.out.println("ia[5]: "+ ia[5]);	  
		System.out.println("ia[-1]: "+ ia[-1]); 
	}
}


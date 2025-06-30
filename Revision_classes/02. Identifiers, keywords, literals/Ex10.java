class Ex10 {

	  static 	int	i1 = 5;       
     static  double	d1 = 6.7;
		char	ch = 'a';
		String	s1 = "Tekgrads";		

		public static void main(String[] args) {
			
			Ex9  e1 = new Ex9();	    
			System.out.println(Ex10.i1);
			
			//printing object
			System.out.println(e1);		//adress classname@hashcode	
			
			//reading and printing object values
			System.out.println(e1.i1);	 //  Ex10.i1
			System.out.println(e1.d1);		
			System.out.println(e1.ch);		
			System.out.println(e1.s1);		
			
		}
	}
class Example {
	   static int a = 10;
	   int x = 20;
	}
	/*
	class Sample {

		public static void main(String[] args) {
			Example e1 = new Example(); // Has - A relation
			System.out.println(e1.a);
			System.out.println(e1.x);
		}
	}
	*/
	
	class Sample extends Example {	
                                  
		public static void main(String[] args) {  // is - a relation
			Sample s1 = new Sample(); 
			System.out.println(s1.a);
			System.out.println(s1.x);
		}
	    
	}
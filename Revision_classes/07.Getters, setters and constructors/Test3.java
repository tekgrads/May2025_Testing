	class Example {
		Example(){
                   System.out.println("No-param constructor");
		}

		Example(int i){
	 	  System.out.println("Int-param constructor");
		}
		
		Example(int i, int j){
	 	  System.out.println("Int-param constructor");
		}
		
		Example(String s, int i){
	 	  System.out.println("Int-param constructor");
		}
		
		Example( int i, String s){
	 	  System.out.println("Int-param constructor");
		}

		Example(String s){
	 	  System.out.println("String-param constructor");
		}
	}
	class Test3 {
	   public static void main(String[] args) {
		Example e1 = new Example();	
		Example e2 = new Example("Hari");	
		Example e3 = new Example(10);	
	   }
	}

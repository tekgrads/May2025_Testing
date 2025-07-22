class Example {
		Example(String s){
			System.out.println("String param");
		}

		Example(Integer io){
			System.out.println("Integer param");
		}
	}

	class Test3{
		public static void main(String[] args) {
			Example e1 = new Example("a"); 

			Example e2 = new Example(101);

			Example e3 = new Example(null); 
			
			Example e4 = new Example((String)null); 

			Example e5 = new Example((Integer)null); 
		}
	}
class Example {
		Example(){
		   this(10);
		   System.out.println("No-arg constructor");
		 //  super(); 
		 //this(10);
		}

		Example(int a){
		   this("abc");
		   System.out.println("int-arg constructor");
		}

		Example(String str){

		   System.out.println("String-arg constructor");
		}
}
	class Test4 {
		public static void main(String[] args){
			Example e1 = new Example();
					

			Example e2 = new Example(5);
				

			Example e3 = new Example("abc");
					
		}
	}
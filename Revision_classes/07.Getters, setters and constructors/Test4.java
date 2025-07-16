/*
class Example{
      public static void main(String[] args) {
         System.out.println("In main");
          Example e = new Example();
       }
}

class Example{
		Example(){
				System.out.println("In no-arg constructor");
					}
		public static void main(String[] args) {
				System.out.println("In main");
				Example e = new Example();
				}
}

class Example{
		Example(){
	     System.out.println("In no-arg constructor");
	  }
	Example(int x){
	System.out.println("In int-arg constructor");
	}
		public static void main(String[] args) {
		System.out.println("In main");
		Example e = new Example();
		}
}
*/
class Example{
			Example(int a){
			System.out.println("In int-arg constructor");
			}
			public static void main(String[] args) {
			System.out.println("In main");
			Example e = new Example();
			}
}



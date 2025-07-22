class Example {
		Example(long l, double d){
			System.out.println("l,d param");
		}

		Example(double d, long l){
			System.out.println("d,l param");
		}
	}

	class Test2{
		public static void main(String[] args) {
			Example e1 = new Example(5L, 6.7); 

			Example e2 = new Example(6.7, 5L); 

			Example e3 = new Example(6, 5); 
		}
	}

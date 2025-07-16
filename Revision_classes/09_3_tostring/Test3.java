	class Example { 
		private int x;
		 Example(int p){
			x = p;
		}
	}

	class Test3 {
		public static void main(String[] args) {
			Example e1 = new Example(101);
			String  s1 = new String("Tekgrads");

			System.out.println(e1); 
			System.out.println(s1); 
		}
	}
  class Example {

	private int x;
	private int y;

	Example() {
		x = 10;	  
		y = 20;
	}

	//param constructor
	Example(int x, int y) {
		this.x = x;	
		this.y = y;	
	}
	
	void display(){
		System.out.println(x + "  " + y);
	}
  }

  class Test1 {
	public static void main(String[] args) {
		Example e1 = new Example();
		Example e2 = new Example();
		e1.display(); //10 20
		e2.display(); //10 20

		
		Example e3 = new Example(15, 16);
		Example e4 = new Example(30, 40);
		Example e5 = new Example(26, 18);
		e3.display(); //15 16
		e4.display(); //30 40
		e5.display(); //26 18
	}	
  }
  class Example {
	private int x;
	private int y;

	public Example(int x, int y) {
	   this.x = x;
	   this.y = y;
	}

	void display(){
		System.out.println(x + " " + y);
	}
  }

  class Test2 {
	public static void main(String[] args) {
		
		Example e1 = new Example();  
		e1.display();	 

	}			
  }

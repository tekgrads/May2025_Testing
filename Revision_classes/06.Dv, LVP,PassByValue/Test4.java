class Test4{
	int x = 10;
	
	void m1() {
		int  x = 50;
		System.out.println(x);
	//	System.out.println(Test4.x);
		System.out.println(this.x);
		
		 x = 60;
		 this.x = 70;
		 System.out.println(x);
		 System.out.println(this.x);
		
	}
	public static void main(String[] args) {
		
		Test4 t1 = new Test4();
		t1.m1();
    //	System.out.println(this.x);
	//	System.out.println(t1.x);
	}
}
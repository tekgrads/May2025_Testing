class  Test1_final
{
	static int a = 15;
	final static int b = 16;
	int x = 30;
	final int y = 40;
	static void m1(int p, final int q) {
		 p  = 21;
		 q = 22;
		System.out.println(p + "  " + q);
		int r = 50;
		final int s = 52;
		 a = 16;
		// b = 17;
	  r = 60;
//	  s = 70;
     final int m;
	 m = 90;
	
	}
	public static void main(String[] args) { 
		m1(10,20);
		Test1_final t = new Test1_final();
		t.x = 32;
	//	t.y = 42;
		}
}

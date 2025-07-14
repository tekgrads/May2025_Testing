class A{
	static int a = 10;
			  int x = 20;
}

class B extends A{

	public static void main(String[] args){
		System.out.println(a); 
		System.out.println(B.a);

	//	System.out.println(x);
	//	System.out.println(B.x);

		B b1 = new B();
		System.out.println(b1.x);
		System.out.println(b1.a);
	}
}
class C extends A{  
	
	static void m1(){
		System.out.println( a );	
//		System.out.println( x );  	
	
		System.out.println(B.a);
	//	System.out.println(B.x); 
	


		B b1 = new B();           // Has a relation
		System.out.println( b1.a );
		System.out.println( b1.x );
		
		B b2 = null;
		System.out.println( b2.a );
	//	System.out.println( b2.x );
/*
		System.out.println( this.a );
		System.out.println( super.a );

		System.out.println( this.x );
		System.out.println( super.x );
		*/
     }
	 void m2(){		
		System.out.println( a );	
		System.out.println( x );  	
	
		System.out.println(B.a);
//		System.out.println(B.x); 

		B b1 = new B();
		System.out.println( b1.a );
		System.out.println( b1.x );

		B b2 = null;
		 
		System.out.println( b2.a );
	//	System.out.println( b2.x );

		System.out.println( this.a );
		System.out.println( super.a );

		System.out.println( this.x );
		System.out.println( super.x );
	}
}	 
class Test5  extends Object{
     void m3() {
       
	//	System.out.println(a);					
//		System.out.println(x);				

		System.out.println(B.a);
//		System.out.println(B.x);         

		System.out.println(new B().a);
		System.out.println (new B().x);

		System.out.println(this.a);
		System.out.println(super.a);

		System.out.println(this.x);
		System.out.println(super.x);
	}


	public static void main(String[] args){
			C c1 = new C();
		 Test5 t1 = new Test5();
		//	c1.m1();
		//	c1.m2();
			t1.m3();
	
	}
}
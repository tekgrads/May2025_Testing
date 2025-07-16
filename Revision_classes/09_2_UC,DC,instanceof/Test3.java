class A{ 
	int x = 10;
}
class B extends A{
	int y = 20;
}
class C extends B{
	int z = 30;
}
class D { }

class Test3{
	public static void main(String[] args) {
		//Upcasting
		A a = new B();

		//Downcasting
		B b = (B)a;
		
		Object o1 = new Object();
		Object o2 = new A();
		Object o3 = new B();
		Object o4 = new C();
		Object o5 = new D();

//		A a1 = new Object();
		A a2 = new A();
		A a3 = new B();
		A a4 = new C();
//	 	A a5 = new D();

//		B b1 = new Object();
//		B b2 = new A();
		B b3 = new B();
		B b4 = new C();
//		B b5 = new D();

// 		C c1 = new Object();
//		C c2 = new A();
//		C c3 = new B();
		C c4 = new C();
//		C c5 = new D();

		A a51 = new B();
		System.out.println(a51.x);
//		System.out.println(a51.y);

		A	a6 = new B();
//		B	b52 = a6;
		B	b5 = (B)a6;
//		C	c5 = (C)a6;
//		D	d5 = (D)a6;

		//Identify CE and RE in below stmts
		A	a7 = new C();
		B	b6 = (B)a7;
		C	c6 = (C)a7;
//		D	d6 = (D)a7;

		//Identify CE and RE in below stmts
		Object	obj7 = new B();
		A	a71	= (A)obj7;
		B	b7	= (B)obj7;
//		C	c7	= (C)obj7;
//		D	d7	= (D)obj7;
	
		//Identify CE and RE in below stmts
		A	a8 = new C();
		C   c8 = (C)a8;       
//		C   c9 = (B)a8;      
// 		C   c10 = (A)a8;
		

//Can we use multiple cast operators in single expression?
	//Identify any CE or RE in below stmts?
		A a11 = new C();
		
		B b11 = (B)(A)(C)(B)a11;
	//	B b12 = (C)(A)(D)(C)(B)a11;
	//	B b14 = (B)(A)(Object)(D)(Object)(C)(B)a11;
		
		//Is casting required in below stmt?
		B		b13		= new B();
		Object  o6		= b13;
		Object  o7		= (Object)b13;

	//Is casting required in below stmt?
		m1(b13);
		m1((A)b13);
		m1((Object)b13);
		m1((A)(B)(Object)b13);
 		System.out.println();


		
		A a21 = new B();					//<- Upcasting, LC and RP
		System.out.println(a21.x);
 //		System.out.println(a21.y);			//<- Problem, Solution
 		System.out.println();

		B b21 = (B)a21;						//<- Downcasting, for accessing CC mems
		System.out.println(b21.x);
		System.out.println(b21.y);
 		System.out.println();

//		C c21 = (C)a21;							//<- Problem -> CCE, solution

		if(a21 instanceof C){					//<- instanceof -> only checking  
			C c22 = (C)a21;						//for conversion we must use cast operator		
			System.out.println(c22.x);			//to avoid CCE we must do casting inside 
			System.out.println(c22.y);			//instanceof operator if condition
			System.out.println(c22.z);
		}
		System.out.println();
	
		//Identify CE and output in below statements?
		A a22 = new B();	
		System.out.println(a22 instanceof Object);	
		System.out.println(a22 instanceof A);
		System.out.println(a22 instanceof B);
		System.out.println(a22 instanceof C);
//		System.out.println(a22 instanceof D);                                
		System.out.println();  
	
		Object a23 = new B();	
		System.out.println(a23 instanceof Object);	
		System.out.println(a23 instanceof A);
		System.out.println(a23 instanceof B);
		System.out.println(a23 instanceof C);
		System.out.println(a23 instanceof D);  
		System.out.println();  

		System.out.println( a23 instanceof  B);
//		System.out.println( B instanceof  a23);

		System.out.println();

	}

	static void m1(Object obj){
		System.out.println("Object-param method is executed with obj: "+ obj);
	}
	
	static void m1(A a1){
		System.out.println("A-param method is executed with a1 : "+ a1);
	}
	
	static void m1(B b1){
		System.out.println("B-param method is executed with b1 : "+ b1);
	}
}
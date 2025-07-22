class Example{}
class Sample extends Example{}
class Test{}
class A{
	void m1(Example e){				
	    System.out.println("Example param");		
	}												
													
	void m1(Test s){				
	    System.out.println("Test param");		
	}						
}
class Test12_MOVL_TC6_2{
	public static void main(String[] args){   													
		A a = new A();               
		a.m1(new Example());	         //ex param             													
		a.m1(new Sample());            // ex param               													
		a.m1(new Test());                    // test param                       												
		//a.m1(null);      	// ae as both ex and test are siblings compiler doesnot know which method to choose
		
		a.m1((Sample)null);	 // to avoid ambigious error(ae) cast the null value   ex param
		a.m1((Test)null);         // test param                    
                                                                      													
		a.m1("abc");    //error
		
/**/
	}                                                                
}                   
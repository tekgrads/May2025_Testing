class Example{}
class Sample extends Example{}

class A{
	void m1(Example e){				
	    System.out.println("Example param");		
	}												
													
	void m1(Sample s){				
	    System.out.println("Sample param");		
	}						
}

class Test8{
	public static void main(String[] args){   													
		A a = new A();                                      													
		a.m1(new Example());	       // ex param               													
		a.m1(new Sample());           //sa param               													
		a.m1(null);                           // sa param
		
		System.out.println();                													
//		a.m1("abc");                                        
                                                       				
		Example e1 = new Example(); 		
		Example e2 = new Sample();			     
		Sample   s1  = new Sample();			      
		Example e3 = null;				              
		Sample   s2  = null;			                  
                                                                     
		a.m1(e1);	//ex param
		a.m1(e2);	// 	ex param
		a.m1(s1);   //sa param
		System.out.println();   
		a.m1(e3);	// ex param
		a.m1(s2);      // sa param                         
		System.out.println();   
		a.m1(null);	        //  sa param                
		a.m1(new Sample());	  // sa param                        

	}                                                                
}
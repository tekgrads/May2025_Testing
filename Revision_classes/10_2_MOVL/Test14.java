class Example {
     	void add(int a , int b)	{
			System.out.println("Example int, int");
		}	

     	void add(String a, float b) {
			System.out.println("Example String, float");
		}

     	int add(String s1 , String s2)	{
			System.out.println("Example String, String");
			return 10;	
		}
}

class Sample extends Example{
     	void add(int x , int y)  	{
			System.out.println("Sample int, int");
		}	
     	float add(float a , int b){
			System.out.println("Sample float, int");
			return a + b; 
		}

     	String add(String s1 , double d){
			System.out.println("Sample String, double");
			return s1 + d;	
		}
}

class Test14{
	public static void main(String[] args)	{
	/*	Sample s = new Sample();
		s.add(10, 20);				// sa int int 
		s.add("abc", 20);		//	ex string float
		s.add("abc", "xyz");		//ex str str
		s.add("10", 20.0);			//	sa str double
	//	s.add(10, 20.0f);			 
		System.out.println();
*/
		Example e = new Sample();
		e.add(10, 20);				//sa int,int
		e.add("abc", 20);		//ex str,float	
		e.add("abc", "xyz");			//ex str, str
//		e.add("10", 20.0);		   if  method is avaiable in both subclass and super class , if super class reference is pointing to subclass then method
                                             // is executed from sub class , if method is not available in super class and avaible only in sub class
	}                                       // compiler will throw error
}
class CalleeImpl{
	public void foo(Object o) {
		   System.out.println("Object parameter");
	} 
	public void foo(String s){
		System.out.println("String parameter");
	}
	public void foo(Integer i){
		System.out.println("Integer parameter");
	}
}
public class Test2{
	public static void main(String[] args){
		CalleeImpl cl = new CalleeImpl();

		Object ob1	= new Object();
		Object ob2	= "abc";
		Object ob3	= 7279;

		cl.foo(ob1);  // obj param
		cl.foo(ob2);  // obj param
		cl.foo(ob3);  // obj  param  // all are obj type

		System.out.println();
		cl.foo("Hyd");  // str param
		cl.foo(7279);   // int param

		System.out.println();
		cl.foo((String)ob2);  // str param
		cl.foo((Integer)ob3);  // int pram

		System.out.println();
//		cl.foo((String)ob1);  
//		cl.foo((Integer)ob1);  
		cl.foo((Integer)ob2);  
		cl.foo((String)ob3); 

		Integer io1 = 7279;
//	cl.foo((String)io1);  // error


	}
}
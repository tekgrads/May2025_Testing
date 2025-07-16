class A
{
	int x = 10;
}

class B extends A
{
	int y = 20;
}

class C extends B
{
	int z = 30;
}
class D
{
}
class Example {
        static void m1( Object obj ){
			if( obj instanceof A ){
					System.out.println("A obj");
				//	A a1 = obj;
					A a1 = (A)obj;
					System.out.println( a1.x );
			}
			
			else if( obj instanceof B){
					System.out.println("B obj");
					B b1 = (B)obj;
					System.out.println( b1.x );
					System.out.println( b1.y );
				}
				
			else if( obj instanceof C ) {
					System.out.println("C obj");
					C c1 = (C) obj;
					System.out.println( c1.x );
					System.out.println( c1.y );
					System.out.println( c1.z );
			}
				
		}
}

class Test5 {
public static  void main(String[] args){
				Example.m1( new A() );
				Example.m1( new B() );
				Example.m1( new C() );
				Example.m1( new D() );
				Example.m1( new String() );
				Example.m1( new Object() );
    }
}








class A{
	void m1(int a){
		System.out.println("int-param");
	}
	void m1(char ch){
		System.out.println("char-param");
	}
}

class Test1{
	public static void main(String[] args) {

		A a1 = new A();
		a1.m1(99);				 // int	
		a1.m1('c');               // char
		a1.m1((char)500000000);   // char
		a1.m1((int)'d');                 // int 
		//a1.m1((int)true);          // CE

		System.out.println();
		int		i1 = 97; 	
		int		i2 = 'a';
		char	ch1 = 98;  
		char	ch2 = 'b';

		a1.m1(i1);	 //int param
		a1.m1(i2);   // char param
		a1.m1(ch1);	// char 
		a1.m1(ch2);    // char

		System.out.println();
		a1.m1((char) i1);  //  char
		a1.m1((int) ch1);   // int 

		System.out.println();
		a1.m1( i1 + i2 );     // int param
		a1.m1( ch1 + ch2 );  // int param

		System.out.println();
		a1.m1( 10 + 'a' );    // int 
		a1.m1( 'a' + 'b' );    // int 
		a1.m1( (char)('a' + 'b'));   // char 
		a1.m1( (char)'a' + 'b');     //  int
//		a1.m1( 5 + true );	          // error 

		System.out.println();
		a1.m1( m2() );  // int
		a1.m1( m3() );   // char

	}

	static int m2(){
			return 'a';
	}
	static char m3(){
		return 97;
	} 
 }

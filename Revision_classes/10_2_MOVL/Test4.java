class Test4{

	static void m1(byte b){
		System.out.println("byte-arg");
	}

	static void m1(short b){
		System.out.println("short-arg");
	}

	static void m1(char ch){
		System.out.println("char-arg");
	}

	static void m1(int i){
		System.out.println("int-arg");
	}
	public static void main(String[] args) {
		byte	b1 = 10;
		short	s1 = 15;
		char	c1 = 97;
		int		i1 = 20;

		m1( b1 ); m1( s1 ); m1( c1 ); m1( i1 ); System.out.println();

		m1( 10 ); m1( 15 ); m1( 97 ); m1( 20 ); System.out.println();  // all are calling int arg as the values are int type to call diff methods cast them

		m1( (byte)10 ); m1( (short)15 ); m1( (char)97 ); m1( 20 ); 
	}
}
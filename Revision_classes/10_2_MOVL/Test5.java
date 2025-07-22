class Test5{

	static void m1(float b){
		System.out.println("float-param");
		}
	static void m2(char b){
		System.out.println("char-param");
		}
	static void m3(double b){
		System.out.println("double-param");
		}

	public static void main(String[] args) {

		m1(10);            
		m1('a');          
		m1(45L);         
	//	m1(4.5);          
		System.out.println();

//		m2(10);          
		m2('a');          
//		m2("a");       
		m2((char)10);    
		System.out.println();

		m3(10);           
		m3('a');            
		m3(54L);         
		m3(47.043F);    
		m3(568.954);     
//		m3(true);            
//		m3("a");           
/**/
	}
}

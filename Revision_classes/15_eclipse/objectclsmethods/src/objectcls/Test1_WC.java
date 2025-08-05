package objectcls;

public class Test1_WC {
	public static void main(String[] args) {
		
		int i1 = 50;					//PDT int 
		
		//converting PV -> WCO	
		Integer io1 = Integer.valueOf(50);	
		System.out.println(io1);
		
		Double d1	= Double.valueOf(10.5);
		System.out.println(d1);
		
		Character c1	= Character.valueOf('a');
        System.out.println(c1);
        
	//	Byte b1 = Byte.valueOf(5);
	
//		Short s1 = Short.valueOf(5);

		
//		Character c12 = Character.valueOf(97);
	//============================================================

		Byte b1 = Byte.valueOf((byte)5);
		
		Short S2 = Short.valueOf((short)5);
	
		Character c12 = Character.valueOf((char)97);
	
		//Autoboxing
		
		int i2 = 20;
		Integer io2 = i2;  // Integer.valueOf(20)
		System.out.println(io2);
	}

}

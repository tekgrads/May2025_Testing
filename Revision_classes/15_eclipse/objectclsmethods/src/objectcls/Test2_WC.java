package objectcls;

public class Test2_WC {
	public static void main(String[] args) {
		//converting PV to WCO (storing PV in WCO)
		Integer io = Integer.valueOf(50);

		//converting WCO to PV (retrieving PV from WCO)
		byte 	b1 = io.byteValue(); // datatypeValue()
		short 	s1 = io.shortValue();
		int 	i1 = io.intValue();
		long 	l1 = io.longValue();
		float 	f1 = io.floatValue();
		double 	d1 = io.doubleValue();
		
		System.out.println(b1);
		System.out.println(s1);
		System.out.println(i1);
		System.out.println(l1);
		System.out.println(f1);
		System.out.println(d1);
		
	//=====================================================================	
		Byte b11 = Byte.valueOf((byte)10);
		byte b12 = b11.byteValue();
		
		Double d2 = Double.valueOf(10.5);
		double d3 = d2.doubleValue();
		
		Character ch1 = Character.valueOf('a');
		char      ch2 = ch1.charValue();

		Boolean   bo1 = Boolean.valueOf(true);
		boolean   bo2 = bo1.booleanValue();
		//Auto Unboxing 
		Integer io1 = 10;
		int i = io1; // int i  =io1. intValue();
		System.out.println(i);
		
	}
}

package methodAndConstructorReference;

class Sample{
	Sample(){
		System.out.println("Sample constructor execution And obj creation");
	}
}
interface I2{
	public Sample get();
}
/*
public class Test3 {
	public static void main(String[] args) {
	   I2 i2 = () ->{
		   Sample s = new Sample();
		   return s;
		   
	   };
	   i2.get();
	 
	}

}
*/
public class Test3{
	public static void main(String[] args) {
		I2 i2 = Sample :: new;     // classname :: new 
		i2.get();
	}
}

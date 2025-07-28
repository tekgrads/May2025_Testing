abstract class Bus
{
    abstract	void engine();
	void breaks(){
		System.out.println("Bus has breaks");
	}
	void wheels(){
		System.out.println("Bus has 6 wheels");
	}
}

class Volvo extends Bus
{
	void engine(){
		System.out.println("Volvo engine capacity 110 KMPH");
	}
}
class Redbus extends Bus
{
	void engine(){
		System.out.println("Redbus engine capacity 70 KMPH");
	}
}

class Driver
{
	void drive(Bus b) {
	b.engine();
	b.wheels();
	b.breaks();
	}
}

class  Test1_BusDepo
{
	public static void main(String[] args) 
	{
		Driver d = new Driver();
		d.drive(new Volvo());
		
	/*	Bus b = new Volvo();
		b.engine();
	b.wheels();
	b.breaks();
	*/
	}
}


class A
{
	A(){
		this(10);
	}
	A(int x){
		this("abc");
	}
	A(String s){
		//this(10);
	}
}

class  Test6
{
	public static void main(String[] args) 
	{
		A a = new A();
	}
}

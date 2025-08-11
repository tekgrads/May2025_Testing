package multiThreading;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("Test main start");
		
		Example1.m1();	//task1
		Example1.m2();	//task2
		Example1.m3();	//task3
		
		System.out.println("Test main end");
	}
}

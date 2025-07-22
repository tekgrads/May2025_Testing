//The complete algorithm for searching for a method definition
	//ST -> STW -> AB -> ABW ->  Sametype -> sametype wideninng-> AutoBoxing -> autoboxing widening
		//STVA -> STWVA      ->SameType var arg -> SameTypewidening var arg -> AutoBoxing var arg ->autoboxing widening vararg
		 //->ABVA -> ABWVA -> CE: c f s
	//CE: a e

//If we donot have 
	//[same type or widening or AB or ABW] all 4 combinations 
//if we have only
	//[stva/stwva] and [ABva/ABwva] combinations
//compiler will throw CE: ambigious error


class Test7{

	static void m1(int a){
		System.out.println("int-param");
	}
	static void m1(long a){
		System.out.println("long-param");
	}
	static void m1(float f){
		System.out.println("float-param");
	}
	static void m1(double d){
		System.out.println("double-param");
	}
	static void m1(Integer io){
		System.out.println("Integer-param");
	}
	static void m1(Long lo){
		System.out.println("Long-param");
	}
	static void m1(Number io){
		System.out.println("Number-param");
	}
	static void m1(Object o){
		System.out.println("Object-param");
	} */
	static void m1(int... i){
		System.out.println("int var arg-param");
	}
	static void m1(long... i){
		System.out.println("long var arg-param");
	}
	static void m1(float... i){
		System.out.println("float var arg-param");
	}
	static void m1(double... i){
		System.out.println("double var arg-param");
	} 
	static void m1(Integer... i){
		System.out.println("Integer var arg-param");
	}
	static void m1(Long... i){
		System.out.println("Long var arg-param");
	}
	static void m1(Number... i){
		System.out.println("Number var arg-param");
	}
	static void m1(Object... i){
		System.out.println("Object var arg-param");
	}

	public static void main(String[] args) {
		m1(5);
	}
}
/*
If we dont have sametype or widenig or auto boxing or its widening and if we have only same type or widening var arg and autiboxing 
 and wideinig var arg compile will throw ambiguous error
 */
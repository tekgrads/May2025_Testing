package com.tekgrads;

public class Example20 {

	public static void main(String[] args) {
		Test<Integer, String, Integer> t = new Test<>(1,"Test");
		t.checkDataType();
		System.out.println(t.returnAnyDataType("Integer"));
		System.out.println("----------------------");
		Test<String, String, String> t2 = new Test<>("One","Two");
		t2.checkDataType();
		System.out.println(t.returnAnyDataType("String"));
	}

}


class Test<T,K,P> {
	
	T i;
	K j;
	
	
	public Test(T i, K j) {		
		this.i = i;
		this.j = j;
	}
	
	void checkDataType() {
		System.out.println("i type is "+ i.getClass().getTypeName());
		System.out.println("j type is "+ j.getClass().getTypeName());
	}
		
	P returnAnyDataType(String type) {
	    if (type.equals("Integer")) {
	        return (P) Integer.valueOf(1);
	    } else if (type.equals("String")) {
	        return (P) "test";
	    }
	    return null;
	}
		
}

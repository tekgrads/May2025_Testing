class  Company {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();

		//initializing e1 instance with the object  values
		e1.eno		= 101;
		e1.ename	= "E1";
		e1.dept		= "HR";
		e1.sal		= 6000;
	 
		//initializing e2 instance with the object  values
		e2.eno		= 102;
		e2.ename	= "E2";
		e2.dept		= "Sales";                 
		e2.sal		= 4500;
	 
		//initializing e3 instance with the object values
		e3.eno		= 103;
		e3.ename	= "E3";
		e3.dept		= "Developer";
		e3.sal		= 4000;
	 
		System.out.println("e1 object details");
		System.out.println("-------------------------");
		System.out.println("e1.eno:  "	+ e1.eno);
		System.out.println("e1.ename: "	+ e1.ename);
		System.out.println("e1.dept: "	+ e1.dept);
		System.out.println("e1.sal: "	+ e1.sal);
        System.out.println();
		System.out.println("e2 object details");
		System.out.println("-------------------------");
		System.out.println("e2.eno: "	+ e2.eno);
		System.out.println("e2.ename: "	+ e2.ename);
		System.out.println("e2.dept: "	+ e2.dept);
		System.out.println("e2.sal: "	+ e2.sal);
        System.out.println();
		System.out.println("e3 object details");
		System.out.println("-------------------------");
		System.out.println("e3.eno: "	+ e3.eno);
		System.out.println("e3.ename: "	+ e3.ename);
		System.out.println("e3.dept: "	+ e3.dept);
		System.out.println("e3.sal: "	+ e3.sal);

	}
}
class Student {
		int sno;
		String sname;
	}
	class Employee {
		int eno;
		String ename;
	}
	class Test1 {
	  public static void main(String[] args) {
               Student s1 = new Student();    
	       Employee e1 = new Employee();

	       System.out.println(s1.toString()); 
	       System.out.println(s1); 
	       System.out.println(e1.toString()); 
	  }
	}


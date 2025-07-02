class  Student
{
	int sno;
	String sname;
	String course;
	double fee;
	void listen(){
		System.out.println(sname + " is listening " +course + " classes" );
	      }
	void read(){
		System.out.println(sname + " is reading " +course + " notes");
	      }
	void write(){
		System.out.println(sname + " is writing " +course + " notes");
	      }
		   
	      void display(){
			  System.out.println();
			       System.out.println("sno: " + sno);
			       System.out.println("sname: " + sname);
			       System.out.println("course: " + course);
			       System.out.println("fee: " + fee);
		  }
}
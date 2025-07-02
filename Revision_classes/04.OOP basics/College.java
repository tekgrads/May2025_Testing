class College 
{
	public static void main(String[] args) 
	{
		
       Student s1 = new Student();
	   s1.sno = 101;
	   s1.sname = "Hari";
	   s1.course = "Core java";
	   s1.fee = 5000;
	   s1.listen();
	   s1.read();
	   s1.write();
	   s1.display();
	}
}


/*

class Ex{                              
                   Ex(){  }
                   void m1(){  }
                  } 


class Ex{                              
                   Ex(final Ex this){}
                   void m1(final Example this){}
                  }

 class Ex{                              
                  int x = 10;
                   void m1(){
                        sop(x); // this.x
                        }
                  } 
class Ex{                              
                  int x = 10;
                   void m1(Ex this){
                        sop(this.x);
                        }
                  } 
				  
				  
				  
	class Ex
	{
		int x = 10;
		void m1(){
			Sop(x);
			x = 20;
	   }	
	psvm(S[] args) {
		Ex e1 = new Ex();
		e1.x = 15;
		e1.m1();   //
		sop(e1.x); // 
	}
	*/
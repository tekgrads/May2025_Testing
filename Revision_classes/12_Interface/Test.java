		interface Example {

	
		    
			int a = 10;		// public static final int a = 10;
			void m1();		// public abstract void m1();
			class A { }		// public static class A { }

			default void m2(){ }	         // public default void m2(){ }
			static void m3(){ }	           // public static void m3() { }
			
			private static void m4(){ }        // private static void m4(){ }
			private void m5(){ }	            // private void m5(){ }

		
			static int i1 = 10;
			int i2 = 10;
			//static { }
			//{ }
			//Example(){ }
			//void m6(){ }
			default void m6(){ } // public default
			static void m7(){ } //allowed from Java 8v
			public static void main(String[] args) { }

			//private void m7();
			void m8(); //=> public
			//protected void m9(); 
			public void m10(); 

			//private default void m11(){ }
			default void m12(){ } //=>public 
			//protected default void m13(){ }
			public default void m14(){ }  

		
			//    int x;

		} 

		class Test {
			public static void main(String[] args) {

				Example e1;
		   
				//e1 = new Example();

			}
		}

		   

			//final interface Test06 {  }
			abstract interface Test07 {  }
			


			//   empty interface is allowed, 
			//and this interface is technically called as 
			//     marker interface 
			//An empty interface that is meant for only provding type 
			//    to its implementation class is called marker interface)

			interface Sample {
				
			}


		//R #7:
		    interface Abc extends Sample { }
		    //interface Bbc implements Sample { }

		    //class Cbc extends Sample {  }
		    class Dbc implements Sample {  }

		   interface A  {
		      void m1();
		   }

		
		  //class B implements A {  }
		  abstract class C implements A {  }

		
		   //class D implements A {  
		   //	void m1(){ }
		   //}

		class E implements A {  
			public void m1(){ }
		}

		class Example {
			private int x;

			Example(){
			   x = 50;
			   System.out.println("no-param constructor");
			}

			Example(int x){
			   this.x = x; 
			   System.out.println("int-param constructor");
			}

			Example(Integer io){
			   this.x = io.intValue(); 	
  			   System.out.println("Integer-param constructor");
			}

			Example(String s){
			   this.x = Integer.parseInt(s);	
			   System.out.println("String-param constructor");
			}

			@Override
			public String toString(){
				return "x: "+x;
			}
		}
	/*	
		class Test1 {
			public static void main(String[] args) {

				

				Example e1 = new Example(); //no-param construor
				System.out.println(e1); 

				Example e2 = new Example("70"); //String-param constructor
				System.out.println(e2); //x: 70
				
			}
		}
	*/	
class Test1{
			public static void main(String[] args) {

				Example e1 = new Example(60); //int-param
				System.out.println(e1); //x: 60

				Example e2 = new Example('a'); //int-param constructor
				System.out.println(e2); //x: 97

				Example e3 = new Example(10.5); //CE: c f s constructor Example(double)
				System.out.println(e3); 
			}
		}
		
		
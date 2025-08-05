package objectcls;

public class Ex_GC {
		private int x ;

		Ex_GC(){
			x = 10;
			System.out.println("Ex constructor "+ this);
		}

		@Override
		protected void finalize() {
			System.out.println("In finalize: "+ this);
		}

	
}

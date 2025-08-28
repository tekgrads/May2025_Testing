package functionalInterface;

	@FunctionalInterface
	public interface P {
		void m1();
		//void m2();

	}
	// functional interface w.r.t inheritance

	// case1
	@FunctionalInterface
	interface Q{
		void m1();
	}
	@FunctionalInterface
	interface R extends Q{
		
	}

	//case2
	@FunctionalInterface
	interface Q1{
		void m1();
	}
	@FunctionalInterface
	interface R1 extends Q1{
		void m1();
	}

	// case3 

	@FunctionalInterface
	interface Q2{
		void m1();
	}
	@FunctionalInterface
	interface R2 extends Q2{
	//	void m2();

}

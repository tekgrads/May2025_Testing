class Wrapper_Ex {
    public static void main(String[] args) {
        int a = 10; // primitive type
        System.out.println("Primitive int a: " + a);
        Integer wrapperA = new Integer(a);
        System.out.println("Wrapped Integer: " + wrapperA);

        int againPrimitiveA = wrapperA.intValue();
        System.out.println("againPrimitiveA Integer: " + againPrimitiveA);

        int b = 10;
        System.out.println("primitve b: " + b);
        Integer wrapperB = b;
          System.out.println("wrapperB : " + wrapperB);
        int againPrimitiveB = wrapperB; // Auto-unboxing
        System.out.println("againPrimitiveB Integer: " + againPrimitiveB);
        Integer wrapperC = 20; // Auto-boxing
        Number num = (Number)wrapperC; // Upcasting
        System.out.println("wrapperC: " + num);
        Byte byteWrapper = 10; // Auto-boxing
        Integer intWrapper = (Integer)byteWrapper; // Auto-unboxing
    }
}   
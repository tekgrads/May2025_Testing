abstract class Example {
    abstract void m1();
    abstract int m2();
    abstract void m3(String s);
    abstract void m4() throws Exception;
//    public abstract Employee m5(String name);
    private abstract static void m6();    
    protected   abstract   final void m7(); 
}

class Sample extends Example {
    void m1() { }
    int m2() { return 5; }
    void m3(String s) { }
    void m4() throws Exception { }
 //   public Employee m5(String name) { return new Employee(); }
}









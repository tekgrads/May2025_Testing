package com.tekgrads;

public class FinalizeExample {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() method called for object: " + this);
    }

    public static void main(String[] args) {
        FinalizeExample obj1 = new FinalizeExample();
        FinalizeExample obj2 = new FinalizeExample();

        obj1 = null;
        obj2 = null;

        // Suggest to JVM to run Garbage Collector
        System.gc();

        System.out.println("End of main method");
    }
}

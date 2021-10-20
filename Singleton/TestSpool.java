public class TestSpool {
    public TestSpool() {
        PrintSpooler spl1 = PrintSpooler.getSpooler ();
        spl1.print ("Printing data-1");
        PrintSpooler spl2 = PrintSpooler.getSpooler ();
        spl2.print ("Printing data-2");
        if (spl1 == spl2)
           System.out.println("The same instance");
        System.out.println("spl1:" + spl1);
        System.out.println("spl2:" + spl2);
    }
    static public void main(String argv[]) {
        new TestSpool();
    }
}

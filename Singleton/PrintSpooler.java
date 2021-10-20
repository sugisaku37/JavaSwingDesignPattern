
public class PrintSpooler {
    private static PrintSpooler spooler;
    private PrintSpooler() {
    }
    public static synchronized PrintSpooler getSpooler() {
        if (spooler == null)
            spooler =  new PrintSpooler();
        return spooler;
    }
    public void print(String s) {
        System.out.println(s);
    }
}

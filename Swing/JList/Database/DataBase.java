/** This class simulates a database lookup */
import java.util.*;

public class DataBase implements Enumeration {
    Vector data; 
    int index;
    int lastKey;

    public DataBase(String datafile) {
        data = new Vector();
        InputFile f = new InputFile(datafile);
        String  s = f.readLine();
        while (s != null) {
            data.addElement (s);
            s = f.readLine();
        }
        index = 0;
        lastKey = 0;
    }
    public boolean hasMoreElements() {
        return index < data.size ();
    }
    public Object nextElement() {
        String s = (String)data.elementAt (index);
        lastKey = index++;
        int i = s.indexOf (",");
        return s.substring (0, i);
    }
    public String getPhone(int key) {
        String s = (String)data.elementAt (key);
        int i = s.indexOf (",");
        return s.substring (i+1).trim();
    }
    public String getName(int key) {
        String s = (String)data.elementAt (key);
        int i = s.indexOf (",");
        return s.substring (0, i);

    }
    public int getKey() {
        return lastKey;
    }
}

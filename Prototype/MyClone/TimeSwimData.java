import java.util.*;
import java.io.*;

public class TimeSwimData extends SwimData {
    protected Vector swimmers;

    public TimeSwimData(String filename) {
        String s = "";
        swimmers = new Vector();
        InputFile f = new InputFile(filename);
        s= f.readLine();
        while (s != null) {
            swimmers.addElement(new Swimmer(s));
            s= f.readLine();
        }
        f.close();
    }
    //-------------------------------------------
    public TimeSwimData(Vector sw) {
        //this constructor copies vector as clone
        swimmers  = new Vector();
        for (int i=0; i < sw.size (); i++) {
            swimmers.add (sw.elementAt (i));
        }
    }
    //-------------------------------------------
    public SwimData myClone() {
        return new TimeSwimData(swimmers);
    }
    //-------------------------------------------
    public int size() {
        return swimmers.size();
    }
    //-------------------------------------------
    public String getName(int i) {
        Swimmer sw = getSwimmer(i);
        if (sw != null)
            return sw.getName ();
        else
            return "";
    }
    //-------------------------------------------
    public Swimmer getSwimmer(int i) {
        Swimmer sw;

        if ( (i >= 0) && (i<swimmers.size()) ) {
            sw =  (Swimmer)swimmers.elementAt(i);
            return sw;
        } else
            return null;
    }
    //-------------------------------------------
    public void sort() {
        Swimmer sw;
        int i, j;
        int max = swimmers.size();
        Swimmer sd[] = new Swimmer[max];
        for ( i =0; i< max; i++)
            sd[i] = (Swimmer)swimmers.elementAt(i);
        for (i =0; i< max; i++) {
            for (j = i; j <max; j++) {
                if (sd[i].getTime() > sd[j].getTime()) {
                    sw= sd[i];
                    sd[i] = sd[j];
                    sd[j]= sw;
                }
            }
        }    

        swimmers.removeAllElements();
        for (i = 0; i < max; i++)
            swimmers.addElement(sd[i]);
    }

}



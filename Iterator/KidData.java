import java.util.*;
public class KidData {
    private Vector kids;    
    private Hashtable clubs;
//------------------------------------------   
    public KidData(String filename) {
        kids = new Vector();
        clubs = new Hashtable();
        InputFile f = new InputFile(filename);
        String s = f.readLine();
        while (s != null) {
            if (s.trim().length() > 0) {
                Kid k = new Kid(s);
                kids.addElement(k);
                clubs.put (k.getClub (), k.getClub ());
            }
            s = f.readLine();
        }
    }
    //---------------------------------
    public String[] getClubs() {
        String s[] = new String[clubs.size ()]; 
        Enumeration enum = clubs.elements ();
        int max = clubs.size();
        for (int i=0; i < max; i++)
            s[i] = (String)enum.nextElement ();
        for (int i=0; i<max; i++) {
            for (int j=i; j<max; j++) {
                if ((s[i].compareTo (s[j]) > 0)) {
                    String tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
                }

            }
        }
        return s;

    }
    //--------------------------------
    public Kid[] getData() {
        Kid[] kd = new Kid[kids.size()];
        for (int i=0; i< kids.size(); i++)
            kd[i] = (Kid)kids.elementAt(i);
        return kd;
    }
    //--------------------------------
    public Enumeration elements() {
        return kids.elements();
    }
    //-------------------------------
    public Enumeration kidsInClub(String club) {
        return new KidClub(this, club);                                       
    }
    //--------------------------------

    public int size() {
        return kids.size();
    }
    //--------------------------------
    public Kid getKid(int i) {
        return(Kid)kids.elementAt(i);
    }
    //--------------------------------

}


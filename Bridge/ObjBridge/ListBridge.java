import java.awt.*;
import java.util.*;
import javax.swing.*;

//this is the Implementor class
//that decides which class to return
public class ListBridge extends Bridger {
    protected VisList list;

    public ListBridge(VisList jlist) {
        setLayout(new BorderLayout());
        list = jlist;
        add("Center", (JComponent)list); 
    }  
    public void addData(Vector v) {
        for (int i = 0; i < v.size(); i++) {
            String s = (String)v.elementAt (i);
            list.addLine (s);
        }
    }
}

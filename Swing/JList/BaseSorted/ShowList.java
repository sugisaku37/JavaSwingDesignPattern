import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;


/** Simple sorted array used as data for JList*/
public class ShowList extends JxFrame {
    String names[];

    public ShowList() {
        super("List of names");
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        jp.setLayout(new BorderLayout());
        
        //create the array
        names = new String[5];
        int i = 0;
        names[i++] = ("Dave");
        names[i++] = ("Charlie");
        names[i++] = ("Adam");
        names[i++] = ("Edward");
        names[i++] = ("Barry");
        
        //sort the array
        Arrays.sort (names);

        //create the list and add it
        JList nList = new JList(names);
        JScrollPane sc = new JScrollPane();
        sc.getViewport().add (nList);
        jp.add ("Center", sc);
        
        setSize(new Dimension(150, 150));
        setVisible(true);        
    }
    static public void main(String argv[]) {
        new ShowList();
    }
}

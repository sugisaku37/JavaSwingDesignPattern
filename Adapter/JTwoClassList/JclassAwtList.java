import java.awt.*;
import java.awt.event.*;
import java.util.*;
//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.border.*;

//this is a simple adapter class to
//convert List awt methods to Swing methods

public class JclassAwtList extends JList
implements ListSelectionListener, AwtList {
    private JListData listContents;
//-----------------------------------------
    public JclassAwtList(int rows) {
        listContents = new JListData();
        setModel(listContents);
        setPrototypeCellValue("Abcdefg Hijkmnop");     
    }
//-----------------------------------------
    public void add(String s) {
        listContents.addElement(s);
    }
//-----------------------------------------
    public void remove(String s) {
        listContents.removeElement(s);
    }
//-----------------------------------------
    public String[] getSelectedItems() {
        Object[] obj = getSelectedValues();
        String[] s = new String[obj.length];
        for (int i =0; i<obj.length; i++)
            s[i] = obj[i].toString();
        return s;
    }
//-----------------------------------------
    public void valueChanged(ListSelectionEvent e) {
    }

}


import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ListFrame extends JFrame
implements Observer {
    private JList list;
    private JPanel p;
    private JScrollPane lsp;
    private JListData listData;

    public ListFrame(Subject s) {
        super("Color List");
        //put panel into the frmae
        p = new JPanel(true);     
        getContentPane().add("Center",  p);
        p.setLayout(new BorderLayout());
        //Tell the Subject we are interested
        s.registerInterest(this);    

        //Create the list
        listData = new JListData();  //the list model
        list = new JList(listData);  //the visual list
        lsp = new JScrollPane();     //the scroller
        lsp.getViewport().add(list);
        p.add("Center", lsp);
        lsp.setPreferredSize(new Dimension(100,100));
        setBounds(250, 100, 100, 100);
        setVisible(true);
    }
    //--------------------------------
    public void sendNotify(String s) {
        listData.addElement(s);
    }
}

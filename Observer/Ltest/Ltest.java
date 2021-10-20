import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.applet.*;
import java.net.*;

public class Ltest extends JxFrame            
   implements ActionListener
{
   JList list;
   JScrollPane lsp;
   JButton ok;
   JListData listdata;     
   
   public Ltest()
   {
   super("List test");

   JPanel p = new JPanel(true);
   p.setLayout(new BorderLayout());
	getContentPane().add("Center", p);
   listdata = new JListData();
   listdata.addElement("one");
   list = new JList(listdata);
   

    lsp = new JScrollPane();
    lsp.getViewport().add(list);
    p.add("Center", lsp);
    lsp.setPreferredSize(new Dimension(100,100));

   ok = new JButton("Add");
   JPanel p1 = new JPanel(true);
   p.add("South", p1);
   p1.add(ok);
   ok.addActionListener(this);

   setBounds(100,100,200,200);
   setVisible(true);
   }
   //------------------------------------
   public void actionPerformed(ActionEvent e)
   {
    listdata.addElement("foo");
    }
   //------------------------------------
   static public void main(String argv[])
   {
      new Ltest();
   }
} 



import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
//-----------------------------------
public class IterDemo extends JxFrame
   implements ActionListener
{
   JawtList kidList, kidClubList;
   JComboBox clubs;
   JButton get;
   KidData kdata;

   public IterDemo()
   {
      super("Filtered Enumeration demo");
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout(new GridLayout(1,2));
      JPanel left = new JPanel();
      JPanel right = new JPanel();
      jp.add(left);
      jp.add(right);
      left.setBorder(new EmptyBorder(5,5,5,5));
      right.setBorder(new EmptyBorder(5,5,5,5));
      kidList = new JawtList(20);
      left.setLayout(new BorderLayout());
      left.add("Center", kidList);

      right.setLayout(new BorderLayout());
      
      get = new JButton("Get");
      get.addActionListener(this);
      JPanel rtop = new JPanel();
      right.add ("North", rtop);
      
      kdata = new KidData ("50free.txt");   
      fillKidList();
      clubs = new JComboBox(kdata.getClubs ());
      
      rtop.add(clubs);
      rtop.add(get);
      kidClubList = new JawtList(20);
      right.add("Center",kidClubList);
      
      setSize(new Dimension(400,300));
      setVisible(true);
   }
   //---------------------------------------
   private void fillKidList()
   {
      Enumeration ekid = kdata.elements();
      while (ekid.hasMoreElements())
         {
         Kid k =(Kid)ekid.nextElement();
         kidList.add(k.getFrname()+" "+k.getLname());
         }
   }
   //---------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      String club = (String)clubs.getSelectedItem();
      kidClubList.clear ();
      if(club.trim().length() > 0)
      {
         Enumeration eclub = kdata.kidsInClub(club);
         while(eclub.hasMoreElements())
         {
         Kid k =(Kid)eclub.nextElement();
         kidClubList.add(k.getFrname()+" "+k.getLname());
         }
      }
   }
   //---------------------------------------
   static public void main(String argv[])
   {
      new IterDemo();
   }
}

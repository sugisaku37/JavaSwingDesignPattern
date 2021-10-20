//Demonstratiob of simple Two-list program
//using JFC controls

import java.awt.*;
import java.awt.event.*;
//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.border.*;


public class JTwoList extends JFrame
   implements ActionListener
{
   private JButton add, moveRight, moveLeft;
   private JawtList leftList, rightList;
   private TextField txt;

   public JTwoList()
   {
      super("Two Lists");
      setLF();          //set look and feel
      setCloseClick();  //Window exits on close-click
      setGUI();
   }
   //--------------------------------------------
   private void setGUI()
   {
      getContentPane().setLayout(new GridLayout(1,2));  //two columns
      setBackground(Color.lightGray);
      JPanel pLeft = new JPanel();
      JPanel pRight = new JPanel();
      getContentPane().add(pLeft);
      getContentPane().add(pRight);
      pLeft.setLayout(new BorderLayout());
      
      JPanel pTop = new JPanel();
      pLeft.add("North", pTop);
      txt = new TextField(15);
      pTop.add(txt);
      add = new JButton("Insert");
      add.setMargin(new Insets(0,0,0,0));

      pTop.add(add);
      
      JPanel rBorder = new JPanel();
      rBorder.setLayout(new GridLayout(2,1));
      moveRight = new JButton("Add --->");
      moveLeft = new JButton("<--- Remove");
      
      JPanel rbTop = new JPanel();
      rbTop.add(moveRight);
      rBorder.add(rbTop);
      
      JPanel rbBot = new JPanel();
      rbBot.add(moveLeft);
      rBorder.add(rbBot);
      pLeft.add("East", rBorder);

      leftList = new JawtList(15);
      pLeft.add("Center", leftList);

      rightList = new JawtList(15);
      pRight.setLayout(new BorderLayout());
      pRight.add("Center", rightList);
      
      //Add button action listenes
      add.addActionListener(this);
      moveRight.addActionListener(this);
      moveLeft.addActionListener(this);

      setSize(new Dimension(400, 300));
      setVisible(true);
   }
   //-----------------------------------------  
   private void setCloseClick()
   {
      //create window listener to respond to window close click
      addWindowListener(new WindowAdapter() 
       {
	    public void windowClosing(WindowEvent e) {System.exit(0);}
	    });
   }
   //------------------------------------------
   private void setLF()
   {
   // Force SwingApp to come up in the System L&F
	String laf = UIManager.getSystemLookAndFeelClassName();
	try {
       UIManager.setLookAndFeel(laf);
   	 }
       catch (UnsupportedLookAndFeelException exc) 
         {System.err.println("Warning: UnsupportedLookAndFeel: " + laf);}
       catch (Exception exc) {System.err.println("Error loading " + laf + ": " + exc);
	   }
   }

   //---------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      JButton b = (JButton)e.getSource();
      if(b == add)
         addName();
      if(b == moveRight)
         moveNameRight();
      if(b == moveLeft)
         moveNameLeft();
   }
   //--------------------------------------------
   private void addName()
   {
      if (txt.getText().length() > 0) 
         {
         leftList.add(txt.getText());
         txt.setText("");
         }
   }
   //--------------------------------------------
   private void moveNameRight()
   {
     String sel[] = leftList.getSelectedItems();
     
     if (sel != null)        
     {
     rightList.add(sel[0]);
     leftList.remove(sel[0]);
     }
   }
   //--------------------------------------------
   public void moveNameLeft()
   {
    String sel[] = rightList.getSelectedItems();
     if (sel != null)        
     {
     leftList.add(sel[0]);
     rightList.remove(sel[0]);
     }
   }
   //--------------------------------------------
   static public void main(String argv[])
   {
      new JTwoList();
   }
}


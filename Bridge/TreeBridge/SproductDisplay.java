import java.awt.*;
import java.awt.event.*;
import java.util.*;
//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.border.*;


public class SproductDisplay extends JFrame
{
   public SproductDisplay()
   {
      super("The Java Factory-- Products");
      setLF();             //set look and feel
      setCloseClick();     //set close on window close click
      InputFile f = new InputFile("products.txt");
      Vector prod = new Vector();
      //read in product list
      String s = f.readLine();
      while(s != null)
      {
         prod.addElement(s);
         s = f.readLine();
      }
      JPanel p = new JPanel();
      getContentPane().add(p);
      p.setLayout(new GridLayout(1,2));
      
      JPanel pleft = new JPanel();
      JPanel pright = new JPanel();
      p.add(pleft);
      p.add(pright);
      pleft.setLayout(new BorderLayout());
      pright.setLayout(new BorderLayout());
      
      //add in customer view as list box
      ListBridge lList = new SortBridge(ListBridge.LIST);
      lList.addData (prod);
      pleft.add("North", new JLabel("Customer view"));
      pleft.add("Center", lList);
      
      //add in executive view as table
      ListBridge lTable = new SortBridge(ListBridge.TABLE);
      lTable.addData (prod);
      pright.add("North", new JLabel("Executive view"));
      pright.add("Center", lTable);
      
      
      setSize(new Dimension(400,300));
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

   static public void main(String argv[])
   {
      new SproductDisplay();
   }
}

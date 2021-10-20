import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class SimpleJFC2 extends JxFrame
   implements ActionListener
{
   JButton ok, quit;
   JPanel jp;
   Color color;

   public SimpleJFC2()
   {
    super("Simple JFC Program");
    color = Color.yellow;
    setGUI();
   }
   //-------------------------------------------
   private void setGUI()
   {
    jp = new JPanel();
    getContentPane().add(jp);
    //create and add buttons
    ok = new JButton("OK",new ImageIcon("color.gif"));
    ok.setRolloverIcon(new ImageIcon("overColor.gif"));
    ok.setToolTipText("Change background color");
    quit = new JButton("Quit", new ImageIcon("exit.gif")); 
    quit.setToolTipText("Exit from program");
    ok.addActionListener(this);
    quit.addActionListener(this);
    
    jp.add(ok);
    jp.add(quit);

    setSize(new Dimension(250,100));
    setVisible(true);
   }
   //-------------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      Object obj = e.getSource();
      if(obj == ok)
         switchColors();
      if(obj == quit)
         System.exit(0);
   }
   //------------------------------------------
   private void switchColors()
   {
      if(color == Color.green)
         color = Color.yellow;
      else
         color = Color.green;
      jp.setBackground(color);
      repaint();
   }
   //-------------------------------------------
   static public void main(String[] argv)
   {
      new SimpleJFC2();
   }
}

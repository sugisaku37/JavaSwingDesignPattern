import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;

public class HelpChain extends JxFrame {

   private JButton btNew, btFile, btQuit;
   private JCheckBox ckText, ckBinary;
   private Chain chain;
   private Key_Adapter helpKey;
//-------------------------------------------
   public HelpChain() {
      super("Help demo");
      setGUI();         //create buttons and check boxes
      setupChain();     //create chain og responsibility
      setSize(new Dimension(200,150));
      setVisible(true);
   }
//-------------------------------------------
   private void setGUI() {
      JPanel jp = new JPanel();      
   getContentPane().add(jp);
   jp.setLayout(new GridLayout(1,2));
   Box left = new Box(BoxLayout.Y_AXIS );
   Box right = new Box(BoxLayout.Y_AXIS );
   jp.add(left);
   jp.add(right);
   btNew  = new JButton("New");
   btFile = new JButton("File");
   btQuit = new JButton("Quit");
   left.add(btNew);
   left.add(Box.createVerticalStrut (5));
   left.add(btFile);
   left.add(Box.createVerticalStrut (5));
   left.add(btQuit);

   JCheckBox ckText = new JCheckBox("Text files");
   JCheckBox ckBinary = new JCheckBox("Binary files");
   right.add(ckText);
   right.add(Box.createVerticalStrut (5));
   right.add(ckBinary);
   helpKey = new Key_Adapter();
   addKeyListener(helpKey);
   }
//-------------------------------------------
   private void setupChain() {
      chain = new FileNewHelp(this);
      FileHelp fhelp = new FileHelp(this);
      chain.addChain(fhelp);
      ButtonHelp bhelp = new ButtonHelp(this);
      fhelp.addChain(bhelp);
      ControlHelp chelp = new ControlHelp(this);
      bhelp.addChain (chelp);
      WindowHelp whelp = new WindowHelp(this);
      chelp.addChain (whelp);

   }
//-------------------------------------------
   static public void main(String argv[]) {
      new HelpChain();
   }
   //===================================
   //  inner class for key strokes
   class Key_Adapter extends KeyAdapter {
      public void keyPressed(KeyEvent e) {
 
         if(e.getKeyCode () == KeyEvent.VK_F1) {
            chain.sendToChain((JComponent)getFocusOwner());
         }
      }
   }
}

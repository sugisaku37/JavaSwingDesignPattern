import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;


public class Sender extends JPanel 
   implements Chain, ActionListener
{
   private Chain nextChain;
   private JTextField tx;
   private JButton send;
//----------------------------------
   public Sender()
   {
      setLayout(new GridLayout(2,1));
      JPanel tp = new JPanel();
      JPanel bp = new JPanel();
      add(tp);
      add(bp);
      tx = new JTextField(10);
      tp.add(tx);
      send = new JButton("Send");
      bp.add(send);
      send.addActionListener(this);
      setBorder(new TitledBorder("Send commands"));
   }
//----------------------------------
public void actionPerformed(ActionEvent e)
{
   String file = tx.getText();
   if  ((file.length() >0) && (nextChain != null))
       nextChain.sendToChain(file);
}
//----------------------------------
public void addChain(Chain c)
{
   nextChain = c;
}
//----------------------------------
public void sendToChain(String mesg){} //this one does nothing
//----------------------------------
public Chain getChain()
{
   return nextChain;
}

}

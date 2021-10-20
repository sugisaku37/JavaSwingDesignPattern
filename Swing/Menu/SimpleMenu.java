import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class SimpleMenu extends JxFrame
{
   public SimpleMenu()
   {
   super("Simple Menu");
   JMenuBar mbar = new JMenuBar();
   setJMenuBar(mbar);
   JMenu mFile = new JMenu("File");
   mbar.add(mFile);
   JMenuItem open = new JMenuItem("Open");
   JMenuItem exit = new JMenuItem("Exit");
   mFile.add(open);
   mFile.addSeparator();
   mFile.add(exit);
   setSize(100,200);
   setVisible(true);
   }
   static public void main(String argv[])
   {
      new SimpleMenu();
   }
}

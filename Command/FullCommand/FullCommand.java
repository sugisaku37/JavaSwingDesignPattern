import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//In this version, we fully decouple the Commands from
//the men and Button subclasses.
// the Command objects are external classes
//and we pass them copies of the Frame instance 
//in their constructor
public class FullCommand extends JxFrame
   implements ActionListener
{
   JMenu mnuFile;
   CmdMenu  mnuOpen, mnuExit;
   CmdButton btnRed;
   JPanel p, jp;
   JxFrame fr;
   //-----------------------------------------
   public FullCommand()
   {
      super("Frame with external commands");
      fr = this;     //save frame object
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      JMenuBar mbar = new JMenuBar();
      setJMenuBar(mbar);

      mnuFile = new JMenu("File", true);
      mbar.add(mnuFile);

      mnuOpen = new CmdMenu("Open...", this);
      mnuFile.add(mnuOpen);
      
      mnuOpen.setCommand (new FileCommand(this));
      mnuExit = new CmdMenu("Exit", this);
      mnuExit.setCommand (new ExitCommand());
      
      mnuFile.add(mnuExit);


      mnuOpen.addActionListener(this);
      mnuExit.addActionListener(this);
      
      btnRed = new CmdButton("Red", this);
      btnRed.setCommand (new RedCommand(this, jp));
  
      jp.add(btnRed);

      btnRed.addActionListener(this);
      setBounds(100,100,200,100);
      setVisible(true);
   }
   //-----------------------------------------
   public void actionPerformed(ActionEvent e)   {
      CommandHolder obj = (CommandHolder)e.getSource();
      obj.getCommand().execute();
   }
   //-----------------------------------------
   static public void main(String argv[])
   {
      new FullCommand();
   }
}



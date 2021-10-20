import java.awt.*;
import java.awt.event.*;

//implements separate inner Command classes as extensions of
//Button and Menu items

public class InnerCommand extends Frame
   implements ActionListener
{
   Menu mnuFile;
   FileOpenCommand mnuOpen;
   FileExitCommand mnuExit;
   BtnRedCommand btnRed;
   Panel p;
   Frame fr;
   //-----------------------------------------
   public InnerCommand()
   {
      super("Frame with commands");
      fr = this;     //save frame object
      MenuBar mbar = new MenuBar();
      setMenuBar(mbar);

      mnuFile = new Menu("File", true);
      mbar.add(mnuFile);

      mnuOpen = new FileOpenCommand("Open...");
      mnuFile.add(mnuOpen);
      mnuExit = new FileExitCommand("Exit");
      mnuFile.add(mnuExit);

      mnuOpen.addActionListener(this);
      mnuExit.addActionListener(this);
      
      btnRed = new BtnRedCommand("Red");
      p = new Panel();
      add(p);
      p.add(btnRed);

      btnRed.addActionListener(this);
      setBounds(100,100,200,100);
      setVisible(true);
   }
   //-----------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      Command obj = (Command)e.getSource();
      obj.execute();
   }
   //-----------------------------------------
   static public void main(String argv[])
   {
      new InnerCommand();
   }
   //====----====-----inner class----=====----
   class BtnRedCommand extends Button implements Command
   {
      public BtnRedCommand(String caption)
      {
         super(caption);
      }
      public void execute()
      {
         p.setBackground(Color.red);
      }
   }
   //------------------------------------------
   class FileOpenCommand extends MenuItem implements Command
   {
      public FileOpenCommand(String caption)
      {
         super(caption);
      }
      public void execute()
      {
         FileDialog fDlg=new FileDialog(fr,"Open file");
         fDlg.show();
      }
   }
   //-------------------------------------------
   class FileExitCommand extends MenuItem implements Command
   {
      public FileExitCommand(String caption)
      {
         super(caption);
      }
      public void execute()
      {
         System.exit(0);
      }
   }
}
//==========================================



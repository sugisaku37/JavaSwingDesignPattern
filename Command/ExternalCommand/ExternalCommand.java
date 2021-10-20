import java.awt.*;
import java.awt.event.*;
//In this version, the Command objects are external classes
//and we pass them copies of the Frame instance 
//in their constructor
public class ExternalCommand extends Frame
   implements ActionListener
{
   Menu mnuFile;
   FileOpenCommand mnuOpen;
   FileExitCommand mnuExit;
   BtnRedCommand btnRed;
   Panel p;
   //-----------------------------------------
   public ExternalCommand()
   {
      super("Frame with external commands");
      MenuBar mbar = new MenuBar();
      setMenuBar(mbar);

      mnuFile = new Menu("File", true);
      mbar.add(mnuFile);

      mnuOpen = new FileOpenCommand("Open...", this);
      mnuFile.add(mnuOpen);
      mnuExit = new FileExitCommand("Exit");
      mnuFile.add(mnuExit);

      mnuOpen.addActionListener(this);
      mnuExit.addActionListener(this);
      
      p = new Panel();
      add(p);
      btnRed = new BtnRedCommand("Red", p);
      
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
      new ExternalCommand();
   }
}
//==========================================
class BtnRedCommand extends Button implements Command
   {
   Panel p;
      public BtnRedCommand(String caption, Panel pnl)
      {
         super(caption);
         p = pnl;
      }
      public void execute()
      {
         p.setBackground(Color.red);
      }
   }
   //------------------------------------------
   class FileOpenCommand extends MenuItem implements Command
   {
      Frame fr;
      public FileOpenCommand(String caption, Frame frm)
      {
         super(caption);
         fr = frm;
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




import java.awt.*;
import java.awt.event.*;
 //creates separate inner class Command objects
//for each item: all as ActionListeners
public class ActionCommand extends Frame
{
   Menu mnuFile;
   MenuItem mnuOpen, mnuExit;
   Button btnRed;
   Panel p;
   Frame fr;
   //-----------------------------------------
   public ActionCommand()
   {
      super("Frame without commands");
      fr = this;        //save copy of this frame
      MenuBar mbar = new MenuBar();
      setMenuBar(mbar);

      mnuFile = new Menu("File", true);
      mbar.add(mnuFile);

      mnuOpen = new MenuItem("Open...");
      mnuFile.add(mnuOpen);
      mnuExit = new MenuItem("Exit");
      mnuFile.add(mnuExit);

      mnuOpen.addActionListener(new FileOpen());
      mnuExit.addActionListener(new FileExit());
      
      btnRed=new Button("Red");
      p = new Panel();
      add(p);
      p.add(btnRed);

      btnRed.addActionListener(new BtnRed());
      setBounds(100,100,200,100);
      setVisible(true);
   }
   
   //-----------------------------------------
   private void exitClicked()
   {
      System.exit(0);
   }
   //-----------------------------------------
   static public void main(String argv[])
   {
      new ActionCommand();
   }
   //=====----====--inner classes---=====----
   class FileOpen implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         FileDialog fDlg = new FileDialog(fr, "Open a file", FileDialog.LOAD);
         fDlg.show();
      }
   }
   //-------------------------------------
   class BtnRed implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
          p.setBackground(Color.red);
      }
   }
   //-------------------------------------
   class FileExit implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
}
//=====================================



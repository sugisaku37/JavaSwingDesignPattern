import java.awt.*;
import javax.swing.*;

public class FileNewHelp extends HelpWindow {
   String title;
   int icon;
   JFrame frame;

   public FileNewHelp(JFrame f) {
      mesg = "Select to create new file";
      title ="New file help";
      icon = JOptionPane.DEFAULT_OPTION ;
      frame = f;
   }
   public void sendToChain(Component c) {
      if (c instanceof JButton) {
         JButton b = (JButton)c;
         if(b.getText().equals("New"))
            JOptionPane.showMessageDialog(frame, mesg, title, icon);
         else
            sendChain(c);
      }
      else
         sendChain(c);
   }
}

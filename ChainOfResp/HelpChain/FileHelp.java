import java.awt.*;
import javax.swing.*;

public class FileHelp extends HelpWindow {
   String title;
   int icon;
   JFrame frame;

   public FileHelp(JFrame f) {
      mesg = "Select to open a file";
      title ="File button help";
      icon = JOptionPane.DEFAULT_OPTION ;
      frame = f;
   }
   public void sendToChain(Component c) {
      if (c instanceof JButton) {
         JButton b = (JButton)c;
         if( b.getText().equals("File"))
            JOptionPane.showMessageDialog(frame, mesg, title, icon);
         else
            sendChain(c);
      }
      else
         sendChain(c);
   }
}

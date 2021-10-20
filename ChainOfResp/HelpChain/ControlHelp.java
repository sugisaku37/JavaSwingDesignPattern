import java.awt.*;
import javax.swing.*;

public class ControlHelp extends HelpWindow {
   String title;
   int icon;
   JFrame frame;

   public ControlHelp(JFrame f) {
      mesg = "Select any control to activate it";
      title ="Control help";
      icon = JOptionPane.DEFAULT_OPTION ;
      frame = f;
   }
   public void sendToChain(Component c) {
      if (! (c.getClass().isAssignableFrom(JComponent.class)))
         JOptionPane.showMessageDialog(frame, mesg, title, icon);
      else
         sendChain(c);
    }
}

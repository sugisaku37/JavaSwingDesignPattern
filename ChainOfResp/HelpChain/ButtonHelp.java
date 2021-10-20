import java.awt.*;
import javax.swing.*;

public class ButtonHelp extends HelpWindow {
   String title;
   int icon;
   JFrame frame;

   public ButtonHelp(JFrame f) {
      mesg = "Click on any button to activate it";
      title ="Button help";
      icon = JOptionPane.DEFAULT_OPTION ;
      frame = f;
   }
   public void sendToChain(Component c) {
      
      if (c instanceof JButton) 
            JOptionPane.showMessageDialog(frame, mesg, title, icon);
         else  
         {
            
            sendChain(c);
         }
   }
}

import javax.swing.*;

public class WindowHelp extends HelpWindow {
   String message, title;
   int icon;
   JFrame frame;

   public WindowHelp(JFrame f) {
      mesg = "Help for ChainDemo";
      title ="ChainDemo Help";
      icon = JOptionPane.DEFAULT_OPTION ;
      frame = f;
   }
   public void sendToChain(JComponent c) {
        JOptionPane.showMessageDialog(frame, mesg, title, icon);
   }
}

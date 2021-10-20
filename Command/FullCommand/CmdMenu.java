import java.awt.*;  
import javax.swing.*;

public class CmdMenu extends JMenuItem implements CommandHolder {
   private Command menuCommand;
   private JFrame frame;
//-----------------------
   public CmdMenu(String name, JFrame frm) {
      super(name);
      frame = frm;
   }
//-----------------------
   public void setCommand(Command comd) {
      menuCommand = comd;
   }
//-----------------------
   public Command getCommand() {
      return menuCommand;
   }
}

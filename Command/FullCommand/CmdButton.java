import java.awt.*;       
import javax.swing.*;

public class CmdButton extends JButton implements CommandHolder {
        private Command btnCommand;
        private JFrame frame;
  
  public CmdButton(String name, JFrame fr) {
     super(name);
     frame = fr;
  }
  public void setCommand(Command comd) {
      btnCommand = comd;
   }
   public Command getCommand() {
      return btnCommand;
   }


}

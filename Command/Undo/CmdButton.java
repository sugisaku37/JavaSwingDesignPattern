import java.awt.*;       
import javax.swing.*;

public class CmdButton extends JButton implements CommandHolder {
        private Command btnCommand;
        
  public CmdButton(String name) {
     super(name);
  }
  public void setCommand(Command comd) {
      btnCommand = comd;
   }
   public Command getCommand() {
      return btnCommand;
   }
}

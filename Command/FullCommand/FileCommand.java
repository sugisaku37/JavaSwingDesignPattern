import java.awt.*;
import javax.swing.*;

public class FileCommand implements Command {
   JFrame frame;

   public FileCommand(JFrame fr) {
      frame = fr;
   }
//------------------------------
   public void execute() {
      FileDialog fDlg = new FileDialog(frame, "Open file");
      fDlg.show();
   }
}

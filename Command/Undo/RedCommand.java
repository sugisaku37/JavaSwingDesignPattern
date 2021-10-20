import java.awt.*;
import javax.swing.*;

public class RedCommand extends DrawCommand {
   public RedCommand(JPanel p1) {
      super(p1);
      x = 0;
      y = 0;
      dx = 20;
      dy = 0;
      color = Color.red;
   }
}

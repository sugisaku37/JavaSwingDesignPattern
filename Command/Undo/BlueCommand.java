import java.awt.*;
import javax.swing.*;

public class BlueCommand extends DrawCommand {
   public BlueCommand(JPanel p1) {
      super(p1);
      y = 0;
      dx = -20;
      dy = 0;
      color = Color.blue;
   }
   public void setX(JPanel p1) {
      Dimension sz = p1.getSize();
      x = sz.width;
   }
}

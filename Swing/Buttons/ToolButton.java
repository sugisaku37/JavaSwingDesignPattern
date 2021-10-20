import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class ToolButton extends JButton
{
   public ToolButton(Icon img)
   {
      super(img);
      setMargin(new Insets(0,0,0,0));
      setSize(25,25);
   }
}


import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class ActionToolBar extends JToolBar
{
   public ActionToolBar()
   {
   setFloatable(false);
   }
   public void add(Action act, String tip)
   {
      JButton button = super.add(act);
      button.setText("");
      button.setToolTipText(tip);
      button.setMargin(new Insets(0,0,0,0));
   }
}

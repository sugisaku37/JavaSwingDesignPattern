import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ClearButton extends JButton implements Command
{
   Mediator med;

   public ClearButton(ActionListener act, Mediator md)
   {
      super("Clear");
      addActionListener(act);
      med = md;
      med.registerClear(this);
   }
   public void execute()
   {
      med.clear();
   }
}

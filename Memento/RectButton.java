import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class RectButton extends JToggleButton implements Command
{
   Mediator med;

  public RectButton(ActionListener act, Mediator md)
  {
  super("R");
  setToolTipText("Draw rectangle");
  addActionListener(act);
  med = md;
  med.registerRectButton(this);
  }
//-------------------------------------------
  public void execute()
  {
     if (isSelected()) 
        {
        med.startRectangle();
        }
  }
  
}


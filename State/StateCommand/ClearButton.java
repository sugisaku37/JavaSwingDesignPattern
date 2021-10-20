import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class ClearButton extends JButton implements Command
{
   Mediator med;

  public ClearButton(ActionListener act, Mediator md)
  {
  super("C");
  setMargin(new Insets(5,12,5,12));
  
  setToolTipText("Clear");
  addActionListener(act);
  med = md;
  }
  //-------------------------------------------
  public void execute()
  {
     med.clear();
  }     
}


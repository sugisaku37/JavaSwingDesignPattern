
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class PickButton extends JToggleButton implements Command
{
   Mediator med;
   StateManager stateMgr;

  public PickButton(ActionListener act, Mediator md, StateManager stmgr)
  {
  super(new ImageIcon("arrow.gif"));
  stateMgr = stmgr;
  setSize(new Dimension(35,35));
  setBorderPainted(true);
  setMargin(new Insets(0,0,0,0));
  setToolTipText("Select drawing element");
  addActionListener(act);
  med = md;
  med.registerArrowButton(this);
  }
//-------------------------------------------
  public void execute()
  {
     stateMgr.setState (new ArrowState(med));
     med.startArrow();
  }
  
}


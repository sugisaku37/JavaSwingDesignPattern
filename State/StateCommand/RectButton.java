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
   StateManager stateMgr;

  public RectButton(ActionListener act, Mediator md, StateManager stmgr)
  {
  super(" ");
  stateMgr = stmgr;
  setSize(new Dimension(35,35));
  setBorderPainted(true);
  setMargin(new Insets(5,12,5,12));
  setToolTipText("Draw rectangle");
  addActionListener(act);
  med = md;
  med.registerRectButton(this);
  }
//--------------------------------
  public Dimension getPreferredSize()
  {
     return new Dimension(35,35);
  }
//--------------------------------
  public void paint(Graphics g)
  {
     super.paint(g);
     int h = getHeight();
     int w = getWidth();
     g.setColor(Color.black);
     g.drawRect(4,4,w-8,h-8);
  }
//-------------------------------------------
  public void execute()
  {
     stateMgr.setState (new RectState(med));
        med.startRectangle();
  }
  
}


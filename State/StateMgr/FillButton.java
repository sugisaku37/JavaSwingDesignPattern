
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class FillButton extends JToggleButton implements Command
{
   Mediator med;

  public FillButton(ActionListener act, Mediator md)
  {
  super(" ");
  setSize(new Dimension(35,35));
  setBorderPainted(true);
  setMargin(new Insets(5,12,5,12));

  setToolTipText("Fill rectangle");
  addActionListener(act);
  med = md;
  med.registerFillButton(this);
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
     g.setColor(Color.red);
     g.fillRect(4, 10, w-8, h-14);
  }
//-------------------------------------------
  public void execute()
  {
     if (isSelected()) 
        {
        med.startFill();
        }
  }
  
}


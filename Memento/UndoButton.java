
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class UndoButton extends JButton implements Command
{
   Mediator med;

  public UndoButton(ActionListener act, Mediator md)
  {
  super("U");
  setToolTipText("Undo");
  addActionListener(act);
  med = md;
  }
  //-------------------------------------------
  public void execute()
  {
     med.undo();
  }     
}


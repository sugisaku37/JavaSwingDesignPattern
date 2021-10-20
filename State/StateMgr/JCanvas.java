import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class JCanvas extends JPanel
{
   Mediator med;
   public JCanvas(Mediator md)
   {
      med = md;
      med.registerCanvas(this);
      setBackground(Color.white);
   }
   public void paint(Graphics g)
   {
      super.paint(g);
      med.reDraw(g);
   }
}

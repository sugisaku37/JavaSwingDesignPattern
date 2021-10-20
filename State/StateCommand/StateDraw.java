import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;


public class StateDraw extends JxFrame
   implements ActionListener
{
   JToolBar tbar;
   Mediator med;
   StateManager stMgr;
//-------------------------------------------
 public StateDraw()
 {
    super("State Drawing");
    JPanel jp = new JPanel();
    getContentPane().add(jp);
    med = new Mediator();
    stMgr = new StateManager(med);

    jp.setLayout(new BorderLayout());
    tbar = new JToolBar();
    tbar.setFloatable(false);
    jp.add("North", tbar);
    PickButton pick = new PickButton(this, med, stMgr);
    tbar.add(pick);
    tbar.addSeparator();
    RectButton rect = new RectButton(this, med, stMgr);
    tbar.add(rect);
    FillButton fill = new FillButton(this,med, stMgr);
    tbar.add(fill);
    CircleButton circ = new CircleButton(this, med, stMgr);
    tbar.add(circ);
    tbar.addSeparator();
    ClearButton clr = new ClearButton(this, med);
    tbar.add(clr);

    JCanvas canvas = new JCanvas(med);
    jp.add("Center", canvas);
    
    MouseApp map = new MouseApp(stMgr, this);
    canvas.addMouseListener(map);
    MouseMoveApp mvap = new MouseMoveApp(stMgr);
    canvas.addMouseMotionListener(mvap);
    setSize(new Dimension(400,300));
    setVisible(true);
    
 }
 
 //-------------------------------------------
 public void actionPerformed(ActionEvent e)
 {
    Command comd = (Command)e.getSource();
     comd.execute();
     repaint();
 }
 //-------------------------------------------
static public void main(String[] argv)
{
   new StateDraw();
}
}
//==============================
class MouseApp extends MouseAdapter
{
   StateManager stMgr;
   JFrame jframe;
   public MouseApp(StateManager stmgr, JFrame jfrm)
   {
      super();
      stMgr = stmgr;
      jframe=  jfrm;
   }
   public void mousePressed(MouseEvent e)
   {
      stMgr.mouseDown(e.getX(), e.getY());
      jframe.repaint();
   }
   public void mouseReleased(MouseEvent e)
   {
      stMgr.mouseUp(e.getX(), e.getY());
   }
}
//-------------------------------------------
class MouseMoveApp extends MouseMotionAdapter
{
   StateManager stMgr;
   public MouseMoveApp(StateManager stmgr)
   {
      super();
      stMgr = stmgr;
   }
   public void mouseDragged(MouseEvent e)
   {
      stMgr.mouseDrag(e.getX(), e.getY());
   }
}

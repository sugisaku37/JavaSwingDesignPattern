import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Undo extends JxFrame 
   implements ActionListener {
   
   CmdButton btRed, btBlue, btUndo;
   UndoCommand u_cmd;
   BlueCommand blue_command;
   RedCommand red_command;

   public Undo() {
      super("Undo Commands");
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout(new BorderLayout());
      JPanel bp = new JPanel();
      jp.add("South", bp);
      PaintPanel cp = new PaintPanel();
      jp.add("Center", cp);

      btRed = new CmdButton("Red");
      red_command = new RedCommand(cp);
      btRed.setCommand (red_command);
      btRed.addActionListener (this);

      btBlue = new CmdButton("Blue");
      blue_command = new BlueCommand(cp);
      btBlue.setCommand (blue_command);
      btBlue.addActionListener (this);

      btUndo = new CmdButton("Undo");
      u_cmd = new UndoCommand();
      btUndo.setCommand (u_cmd);
      btUndo.addActionListener (this);

      bp.add(btRed);
      bp.add(btUndo);
      bp.add(btBlue);
      setSize(new Dimension(300, 300));
      setVisible(true);
      blue_command.setX(cp);
   }
   public void actionPerformed(ActionEvent e) {
      CommandHolder cmdh = (CommandHolder)e.getSource ();
      Command cmd = cmdh.getCommand ();
      u_cmd.add (cmd);  //add to list
      cmd.execute ();   //and execute
   }
   
   static public void main(String argv[]) {
      new Undo();
   }
   //============================
   public class PaintPanel extends JPanel {
      public void paint(Graphics g) {
       Dimension sz = getSize();
       g.setColor(Color.lightGray );
       g.fillRect (0, 0, sz.width , sz.height );
       red_command.draw(g);
       blue_command.draw(g);
    }
   }
}

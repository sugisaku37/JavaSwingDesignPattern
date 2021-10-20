import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Details extends JDialog implements ActionListener {

  public Details(Frame owner, String name, String phone) {
      super(owner, false);
      
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout (new BorderLayout());
      Box jcent = new Box(BoxLayout.Y_AXIS);
      jp.add("Center", jcent);
      
      jcent.add("Center", new TextField(name));
      jcent.add("Center", new TextField(phone));
      JButton OK = new JButton("OK");
      OK.addActionListener (this);
      JPanel jbot = new JPanel();
      jp.add("South", jbot);
      jbot.add(OK);
      setSize(new Dimension(200, 100));
      setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
      setVisible(false);
  }
}

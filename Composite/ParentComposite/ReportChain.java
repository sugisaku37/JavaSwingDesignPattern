import java.awt.*;
import javax.swing.*;

public class ReportChain extends JFrame {
   
   JawtList list;

   public ReportChain(Employee emp) {
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout(new BorderLayout());
      list = new JawtList(20);
      jp.add("Center", list);
      list.add (emp.getName ());
      while(emp.getParent () != null) {
         emp = emp.getParent ();
         list.add (emp.getName ());
      }
      setSize(new Dimension(100,200));
      setVisible(true);

   }
}

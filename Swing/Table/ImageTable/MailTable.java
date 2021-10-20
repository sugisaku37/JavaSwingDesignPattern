import java.awt.*;
import javax.swing.*;

public class MailTable extends JxFrame {
    Ftable ftable;  
    Mediator med;
    JTextField tx;

    public MailTable() {
        super("Mail table");
       JPanel jp = new JPanel();
       jp.setLayout (new BorderLayout());
       getContentPane().add(jp);
       JPanel tp = new JPanel();
       tx = new JTextField(20);
       
       med = new Mediator(tx);
       ftable = new Ftable(med);
       med.setTable (ftable);
       ftable.setShowGrid (false);
       
       JScrollPane js = new JScrollPane(ftable);
       ftable.setPreferredScrollableViewportSize (new Dimension(200,150));
       jp.add("North", tp);
       tp.add(tx);
       jp.add ("Center", js);
       setSize(new Dimension(300,200));
       setVisible(true); 

    }
    static public void main(String[] arv) {
        new MailTable();
    }
}

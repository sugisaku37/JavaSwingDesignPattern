import java.awt.event.*;
import javax.swing.*;
public class WindAp extends WindowAdapter {
    JFrame fr;
    public WindAp(JFrame f) {
        fr = f;           //copy Jframe instance
    }
    public void windowClosing(WindowEvent e) {
        fr.setVisible(false);   //hide window
    }
}


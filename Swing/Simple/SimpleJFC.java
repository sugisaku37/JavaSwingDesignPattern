import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class SimpleJFC extends JxFrame
implements ActionListener {
    private JButton ok, quit;
    private Color color;
    private JPanel jp;

    public SimpleJFC() {
        super("Simple JFC Program");
        color = Color.yellow;
        setGUI();
    }
    //-------------------------------------------
    private void setGUI() {
        jp = new JPanel();
        getContentPane().add(jp);
        
        //create and add buttons
        ok = new JButton("OK");
        quit = new JButton("Quit"); 
        ok.addActionListener(this);
        quit.addActionListener(this);

        jp.add(ok);
        jp.add(quit);

        setSize(new Dimension(250,100));
        setVisible(true);
    }
    //-------------------------------------------
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == ok)
            switchColors();
        if (obj == quit)
            System.exit(0);
    }
    //------------------------------------------
    private void switchColors() {
        if (color == Color.green)
            color = Color.yellow;
        else
            color = Color.green;
        jp.setBackground(color);
        repaint();
    }
    //-------------------------------------------
    static public void main(String[] argv) {
        new SimpleJFC();
    }
}

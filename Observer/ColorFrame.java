import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class ColorFrame extends JFrame
implements Observer {
    private Color color;
    private String color_name="black";
    private Font font;

    private JPanel p = new JPanel(true);
    public ColorFrame(Subject s) {
        super("Colors");
        getContentPane().add("Center",  p);
        s.registerInterest(this);
        setBounds(100, 100, 100, 100);
        font = new Font("Sans Serif", Font.BOLD, 14);
        setVisible(true);
    }
    public void sendNotify(String s) {
        color_name = s;
        if (s.equalsIgnoreCase ("RED"))
            color = Color.red;
        if (s.equalsIgnoreCase ("BLUE"))
            color =Color.blue;
        if (s.equalsIgnoreCase ("GREEN"))
            color = Color.green;
        setBackground(color);
    }
    public void paint(Graphics g) {

        g.setFont(font);
        g.drawString(color_name, 20, 50);
    }
}


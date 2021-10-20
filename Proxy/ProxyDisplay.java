import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;

import java.awt.*; 
public class ProxyDisplay extends JxFrame {
    public ProxyDisplay() {
        super("Display proxied image");
        JPanel p = new JPanel();
        getContentPane().add(p);
        p.setLayout(new BorderLayout());
        ImageProxy image = new ImageProxy("elliott.jpg",
                                           321, 271);
        p.add("Center", image);
        p.add("North", new Label("    "));
        p.add("West", new Label("  "));
        setSize(370, 350);
        setVisible(true);
    }
//------------------------------------
    static public void main(String[] argv) {
        new ProxyDisplay();
    }
}


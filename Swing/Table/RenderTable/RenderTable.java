
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class RenderTable extends JxFrame {
    public RenderTable() {
        super("Model table");
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        JTable table = new JTable(new MusicModel(4, 3));
        JScrollPane sp = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(250,170));
        table.setDefaultRenderer(String.class, new OurRenderer());
        jp.add(sp);

        setSize(300,200);
        setVisible(true);
    }
    static public void main(String argv[]) {
        new RenderTable();
    }
}



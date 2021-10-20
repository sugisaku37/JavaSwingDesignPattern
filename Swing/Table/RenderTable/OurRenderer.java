
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class OurRenderer extends JLabel 
  implements TableCellRenderer {
    Font bold, plain;
    public OurRenderer() {
        super();
        setOpaque(true);
        setBackground(Color.white);
        bold = new Font("SansSerif", Font.BOLD, 12);
        plain = new Font("SansSerif", Font.PLAIN, 12);
        setFont(plain);
    }
    public Component getTableCellRendererComponent(JTable jt, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        setText((String)value);
        //render column1, row 1 in red, bold
        //all others in black, plain
        if (row ==1 && column==1) {
            setFont(bold);
            setForeground(Color.red);
        } else {
            setFont(plain);
            setForeground(Color.black);
        }
        return this;
    }
}


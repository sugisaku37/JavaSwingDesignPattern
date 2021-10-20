import javax.swing.*;
import javax.swing.table.*;
import java.net.*;
import java.awt.*;

public class MyRenderer extends DefaultTableCellRenderer {
    private Mediator md;

    public MyRenderer(Mediator med) {
        setHorizontalAlignment(JLabel.LEADING);
        md = med;
    }
 //--------------------------------
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int col) {
        if (hasFocus) {
            setBackground(Color.lightGray );
            md.tableClicked ();
        } else
            setBackground(new Color(0xffffce));
        if (value != null) {
            Mail ml = (Mail) value;
            String title = ml.getLabel ();
            setText(title); 
            setIcon(ml.getIcon ());   
        }
        return this;

    }
}

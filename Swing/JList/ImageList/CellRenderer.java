import javax.swing.*;
import java.awt.*;

public class CellRenderer extends JLabel implements ListCellRenderer {

    public Component getListCellRendererComponent(JList list, 
              Object value, int index, boolean isSelected, 
              boolean hasFocus) {
        Person p = (Person)value; //get the person
        setText(p.getName ());  //display name
        setIcon(p.getIcon ());  //and image
        if(isSelected)
             setBackground(Color.lightGray );
        else
            setBackground(Color.white );
        return this;
    }
}

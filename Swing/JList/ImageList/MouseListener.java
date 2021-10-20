import java.awt.event.*;
import javax.swing.*;

public class MouseListener extends MouseAdapter {
    private JList nList;
                                   
    SortedModel lData;
    JFrame jxf;

    public MouseListener(JList list, SortedModel ldata, JFrame jf) {
        nList = list;
        jxf = jf;
        lData = ldata;
    }
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount () == 2) {
            int index = nList.locationToIndex (e.getPoint());    
            Person p = (Person)lData.get (index);
            Details details = new Details(jxf,  p.getFrname ()+" "+p.getLname (), p.getPhone());
            details.setVisible(true);
        }
    }
}

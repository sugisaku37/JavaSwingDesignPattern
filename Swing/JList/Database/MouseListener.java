import java.awt.event.*;
import javax.swing.*;

public class MouseListener extends MouseAdapter {
    private JList nList;
    private DataBase db;                                
    SortedModel lData;
    JFrame jxf;

    public MouseListener(JList list, SortedModel ldata, 
                         DataBase dbase, JFrame jf) {
        nList = list;
        db = dbase;
        jxf = jf;
        lData = ldata;
    }
    //
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount () == 2) {
        //mouse double clicked- 
        //get database key for this person    
            int index = nList.locationToIndex (e.getPoint());    
            int key = lData.getKey (index);
        //display pop up dialog box
            Details details = new Details(jxf, 
                  db.getName (key), db.getPhone (key));
            details.setVisible(true);
        }
    }
}

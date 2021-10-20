import java.awt.*;
import javax.swing.*;

public class Mediator {
    Ftable ftable;
    JTextField txt;
    int tableRow, tableColumn;
    FolderModel fmodel;

    public Mediator ( JTextField tx) {
        txt = tx;
    }
    public void setTable(Ftable tbl) {
        ftable = tbl;
    }
    //--------------------------------
    public void tableClicked() {
        int row = ftable.getSelectedRow ();
        int col = ftable.getSelectedColumn ();
//don't refresh if not changed
        if ((row != tableRow) || (col != tableColumn)) {
            tableRow = row;
            tableColumn = col;
            fmodel = ftable.getTableModel ();
            Mail ml =  fmodel.getDoc(row, col);
            txt.setText (ml.getLabel ());

       }
    }
} 

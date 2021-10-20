import java.awt.*;
import java.awt.event.*;

import java.util.*;
//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.border.*;


public class Ftable extends JTable {
   FolderModel fmodel;
   TableCellRenderer rend;

   public Ftable(Mediator med) {
      fmodel = new FolderModel(3);
      rend = new MyRenderer(med);
      setModel(fmodel);
      setCellSelectionEnabled(true);

      setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      ListSelectionModel lsm =  getSelectionModel();
      lsm.addListSelectionListener (new TableSelectionListener(med));

      setRowHeight(30);
      setDefaultRenderer(Mail.class, rend);

   }
   public void addDoc(Mail doc) {
      fmodel.addCell (doc);
   }
   public FolderModel getTableModel(){
      return fmodel;
   }
   public void clear() {
      fmodel.clear ();

   }
   public TableCellRenderer getCellRenderer(int row, int column) {
      return rend;
   }
}

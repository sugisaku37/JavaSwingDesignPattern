import javax.swing.*;
import javax.swing.event.*;

public class TableSelectionListener implements ListSelectionListener {
   
   private Mediator md;

   public TableSelectionListener(Mediator med) {
      md= med;
   }
   public void valueChanged(ListSelectionEvent e) {
      ListSelectionModel lsm =
         (ListSelectionModel)e.getSource();
      if( ! lsm.isSelectionEmpty ())
        md.tableClicked();
   }
}

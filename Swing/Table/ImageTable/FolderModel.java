import java.awt.event.*;
import java.util.*;
import java.awt.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.net.*;

public class FolderModel extends AbstractTableModel {

   private Vector tableData;
   private int rowCount, colCount;
  
   //-------------------------------------
   public FolderModel(int colCnt) {
      rowCount = 0;
      colCount = colCnt;
      tableData= new Vector();    //Mail objects
      addCell (new NewMail("Fred"));
      addCell (new SentMail("Gerrie"));
      addCell (new SoundMail("Milt"));
      addCell (new SoundMail("Mick"));
      addCell (new NewMail("Sara"));
      addCell (new SentMail("Alan"));
      addCell (new NewMail("Roy"));
      addCell (new SentMail("Sam"));
      addCell (new SoundMail("Igor"));
      
   }
   public Mail getDoc(int row, int column) {
      int index = 0;
     
      if(row == 0)
         index= column;
      else 
         index = (row)*3 + column;

      return (Mail)tableData.elementAt (index);
   }

   public String getColumnName(int col) {
      return "";
   }
   public Class getColumnClass(int col) {
    return Mail.class;
   }
   public int getRowCount() {
      return rowCount;
   }
   public int getColumnCount() {
      return colCount;
   }
   public boolean isCellEditable(int row, int col) {
      return false;
   }
   public void addCell(Mail ml) {
      JLabel lb =  null;

      tableData.addElement (ml);
      rowCount = tableData.size() / colCount;
      fireTableDataChanged();
      if ((tableData.size() % colCount) >0) {
         rowCount++;
      }
   }
   //--------------------------------------------
   public Object getValueAt(int row, int col) {
      int posn = (row) *colCount + col;

      if (posn < tableData.size ()) {
         Mail ml = (Mail) tableData.elementAt(posn);
         return ml;
      } else
         return null;
   }
   public void clear() {
      tableData = new Vector();
      rowCount = 0;
      colCount = 3;
      fireTableDataChanged();

   }

} 

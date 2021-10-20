
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class ProductTable extends JScrollPane
   implements VisList
{
   JTable table;
   ProdModel model;

   public ProductTable() {
      model = new ProdModel();   
      table = new JTable(model);
      getViewport().add(table);
   }
   //-----------------------------------------
   public void addLine(String s) {
      int index = s.indexOf("--");  //separate qty from name
      if (index > 0) {
         model.addProductName(s.substring(0, index));
         model.addQuantity(s.substring(index+2).trim());
        }
      else
        model.addProductName(s);

   }
   //--------------------------------
   public void removeLine(int index) {
   }
}
//===========================================
class ProdModel implements TableModel
{
   int rows, columns;
   Vector prodNames, quantities;

   public ProdModel()
   {
      columns = 2;
      prodNames = new Vector();
      quantities =  new Vector();
      
   }
   public void addProductName(String s) {
      prodNames.addElement (s);
   }
   public void addQuantity(String s) {
      quantities.addElement (s);
   }
   public int getColumnCount()
   {
      return columns;
   }
   public int getRowCount()
   {
      return prodNames.size ();
   }
   public Object getValueAt(int r, int c)
   {
      switch (c)
      {
      case 0:
         return prodNames.elementAt(r);
         
      case 1:
         return quantities.elementAt(r);
         
      default:
         return prodNames.elementAt(r);

      }
         
   }
   public Class getColumnClass(int c)
   {
      return (new String("")).getClass();
   }
   public boolean isCellEditable(int r, int c){return false;}
   public String getColumnName(int c){return "";}
   public void setValueAt(Object obj, int r, int c){}
   public void addTableModelListener(TableModelListener tbm){}
   public void removeTableModelListener(TableModelListener tbm){}
}

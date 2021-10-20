import java.awt.*;
import java.util.*;
import javax.swing.*;

//this is the Implementor class
//that decides which class to return
public class ListBridge extends Bridger {
   
  public static final int LIST=1, TABLE=2, TREE=3;
  protected VisList list;

  public ListBridge(int type) {
     setLayout(new BorderLayout());
      switch (type) {
      case LIST:
         list =  new ProductList();
         add("Center", (JComponent)list);
         break;
      case TABLE:
         list = new ProductTable();
         add("Center", (JComponent)list);
          break;
      case TREE:
         list = new ProductTree();
         add("Center", (JComponent)list);
          break;
      default:
         list = null;
      }
      
   }  
  public void addData(Vector v) {
     for(int i=0; i<v.size(); i++) {
        String s = (String)v.elementAt (i);
        list.addLine (s);
     }
  }

}

import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;

public class ProductTree extends JScrollPane
   implements VisList
{
   JTree tree;
   DefaultMutableTreeNode root;

  public ProductTree() {
     root = new DefaultMutableTreeNode("Products");

     tree = new JTree(root);
     getViewport().add(tree);
     }
   //-------------------------------------
   private void splitAdd(String s) {
      
      //take each string apart and keep only
      //the product names, discarding the quntities

      int index = s.indexOf("--");  //separate qty from name
                  
      if(index > 0) {
         DefaultMutableTreeNode base = 
            new DefaultMutableTreeNode(s.substring(0, index));
         root.add(base);
         base.add(new DefaultMutableTreeNode(s.substring(index + 2).trim()));
      }
         
      else
      {
       DefaultMutableTreeNode base = 
            new DefaultMutableTreeNode(s);
         root.add(base);
      }
   }
   //-------------------------------------
   public void addLine(String s) {
 
      splitAdd(s);
      super.validate();
   }
   //-------------------------------------
   public void removeLine(int index) {
   }
}

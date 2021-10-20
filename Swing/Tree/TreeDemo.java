import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class TreeDemo extends JxFrame {
    private DefaultMutableTreeNode root;
    public TreeDemo() {
        super("Tree Demo");
        JPanel jp = new JPanel();   // create interior panel      
        jp.setLayout(new BorderLayout());
        getContentPane().add(jp);

        //create scroll pane
        JScrollPane sp =  new JScrollPane();
        jp.add("Center", sp);

        //create root node
        root = new DefaultMutableTreeNode("Foods");
        JTree tree = new JTree(root);    //create tree
        sp.getViewport().add(tree);      //add to scroller

        //create 3 nodes, each with three sub nodes
        addNodes("Meats", "Beef", "Chicken", "Pork");
        addNodes("Vegies", "Broccoli", "Carrots", "Peas");
        addNodes("Desserts","Charlotte Russe", "Bananas Flambe","Peach Melba"); 

        setSize(200, 300);
        setVisible(true);
    }
    //----------------------------------------
    private void addNodes(String b, String n1, String n2, String n3) {
        DefaultMutableTreeNode base = 
        new DefaultMutableTreeNode(b);
        root.add(base);
        base.add(new DefaultMutableTreeNode(n1));
        base.add(new DefaultMutableTreeNode(n2));
        base.add(new DefaultMutableTreeNode(n3));      
    }
    //----------------------------------------
    static public void main(String[] argv) {
        new TreeDemo();
    }
}

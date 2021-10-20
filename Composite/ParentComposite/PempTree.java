import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;


public class PempTree extends JxFrame
   implements TreeSelectionListener, ActionListener
{
   Employee prez, marketVP, prodVP;
   Employee salesMgr, advMgr;
   Employee prodMgr, shipMgr;

   JScrollPane sp;
   JPanel treePanel;
   JTree tree;
   DefaultMutableTreeNode troot;
   JLabel cost;
   JButton parent;
   String selectedTerm;
   
   public PempTree()
      {
         super("Employee tree");
         makeEmployees();
         setGUI();
      }
   //--------------------------------------
      private void setGUI()
      {
         treePanel = new JPanel();
         getContentPane().add(treePanel);
         treePanel.setLayout(new BorderLayout());
         
         sp = new JScrollPane();
         treePanel.add("Center", sp);
         
         JPanel bp = new JPanel();
         treePanel.add("South", bp);
         bp.add("South", cost = new JLabel("          "));
         parent = new JButton("P");
         bp.add("South", parent);           
         parent.addActionListener (this);
                                         
         treePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
         troot = new DefaultMutableTreeNode(prez.getName());
         tree= new JTree(troot);
         tree.setBackground(Color.lightGray);
         loadTree(prez);
         /* Put the Tree in a scroller. */
         
         sp.getViewport().add(tree);
         setSize(new Dimension(200, 300));
         setVisible(true);

      }
      //------------------------------------
      //------------------------------------
      public void loadTree(Employee topDog)
       {
         DefaultMutableTreeNode troot;
         troot = new DefaultMutableTreeNode(topDog.getName());
         treePanel.remove(tree);
         tree= new JTree(troot);
         tree.addTreeSelectionListener(this);
         sp.getViewport().add(tree);
         
         addNodes(troot, topDog);
         tree.expandRow(0);
         repaint();
      }
      //--------------------------------------
      private void addNodes(DefaultMutableTreeNode pnode, Employee emp)
      {
      DefaultMutableTreeNode node;

      Enumeration e = emp.subordinates();
      if(e != null) {
        while(e.hasMoreElements())
            {
            Employee newEmp = (Employee)e.nextElement();
            node = new DefaultMutableTreeNode(newEmp.getName());
            pnode.add(node);
            addNodes(node, newEmp);
            }
         }
      }
      //--------------------------------------
      private void makeEmployees()
      {
      prez = new Boss("CEO", 200000);
      prez.add(marketVP = new Boss(prez, "Marketing VP", 100000));
      prez.add(prodVP = new Boss(prez, "Production VP", 100000));

      marketVP.add(salesMgr = new Boss(marketVP, "Sales Mgr", 50000));
      marketVP.add(advMgr = new Boss(marketVP, "Advt Mgr", 50000));

      for (int i=0; i<5; i++) 
         salesMgr .add(new Employee(salesMgr, "Sales "+new Integer(i).toString(), 30000.0F +(float)(Math.random()-0.5)*10000));
      advMgr.add(new Employee(advMgr, "Secy", 20000));

      prodVP.add(prodMgr = new Boss(prodVP, "Prod Mgr", 40000));
      prodVP.add(shipMgr = new Boss(prodVP, "Ship Mgr", 35000));
      for (int i = 0; i < 4; i++)
        prodMgr.add( new Employee(prodMgr, "Manuf "+new Integer(i).toString(), 25000.0F +(float)(Math.random()-0.5)*5000));
      for (int i = 0; i < 3; i++)
        shipMgr.add( new Employee(shipMgr, "ShipClrk "+new Integer(i).toString(), 20000.0F +(float)(Math.random()-0.5)*5000));
        
      }                            
      //--------------------------------------
      public void valueChanged(TreeSelectionEvent evt)
      {
       TreePath path = evt.getPath();
       selectedTerm = path.getLastPathComponent().toString();

       Employee emp = prez.getChild(selectedTerm);
       if(emp != null)
          cost.setText(new Float(emp.getSalaries()).toString());
      }
      //--------------------------------------
      public void actionPerformed(ActionEvent e) {
       
       if(selectedTerm.length() >0) {
       
       Employee emp = prez.getChild(selectedTerm);
       ReportChain chn = new ReportChain(emp);  
       }
      }
      //--------------------------------------
      static public void main(String argv[])
      {
         new PempTree();
      }
}

import java .awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

//This program illustrates the 

public class WealthBuilder extends JxFrame 
  implements ListSelectionListener, ActionListener {
    private JawtList stockList;         //list of funds
    private JButton plot;               //plot command button
    private JPanel choicePanel;         //right panel
    private MultiChoice mchoice;        //ui for right panel
    private Vector bonds, stocks, mutuals;   //3 lists of investments
    private ChoiceFactory cfact;        //the factory
    
    public WealthBuilder() {
        super("Wealth Builder");     //frame title bar
        setGUI();                    //set up display
        buildStockLists();           //create stock lists
        cfact = new ChoiceFactory(); //create builder-factory
    }
    //----------------------------------
    private void setGUI() {
        JPanel jp = new JPanel();
        getContentPane().add (jp);
        jp.setLayout(new BorderLayout());
        JPanel p = new JPanel();
        jp.add("Center", p);
        
        //center contains left and right panels
        p.setLayout(new GridLayout(1,2));
        stockList= new JawtList(10);              //left is list of stocks
        stockList.addListSelectionListener(this);
        p.add(stockList);
        stockList.add("Stocks");
        stockList.add("Bonds");
        stockList.add("Mutual Funds");
        stockList.addListSelectionListener(this);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.lightGray);    
        jp.add("South", p1);
        plot = new JButton("Plot");         
        plot.setEnabled(false);        //disabled until stock picked
        plot.addActionListener(this);
        p1.add(plot);
        //right is empty at first
        choicePanel = new JPanel();
        choicePanel.setBackground(Color.lightGray);
        p.add(choicePanel);

        setBounds(100, 100, 300, 200);
        setVisible(true);
    }
    //----------------------------------
    public void valueChanged(ListSelectionEvent e) {
        //click on list box happens here
        stockList_Click();
    }
    //----------------------------------
    public void actionPerformed(ActionEvent ev) {
        //click on "plot" button sent here
        PlDialog pl = new PlDialog(this, mchoice);
        pl.show();
    }
    //----------------------------------
    private void stockList_Click() {
        Vector v = null;
        int index = stockList.getSelectedIndex();
        choicePanel.removeAll();  //remove previous ui panel

        //this just switches between 3 different Vectors
        //and passes the one you select to the Builder pattern
        switch (index) {
        case 0:
            v = stocks;  break;
        case 1:
            v = bonds;   break;
        case 2:
            v = mutuals;  
        }
        mchoice = cfact.getChoiceUI(v);    //get one of the UIs
        choicePanel.add(mchoice.getUI());    //insert in right panel
        choicePanel.validate();         //re-layout and display
        choicePanel.repaint ();
        plot.setEnabled(true);          //allow plots
    }
    //----------------------------------
    private void buildStockLists() {
        //arbitrary list of stock, bond and fund holdings
        bonds = new Vector();
        bonds.addElement("CT State GO 2012");
        bonds.addElement("New York GO 2005");
        bonds.addElement("GE Corp Bonds");

        stocks = new Vector();
        stocks.addElement("Cisco");
        stocks.addElement("Coca Cola");
        stocks.addElement("General Electric");
        stocks.addElement("Harley Davidson");
        stocks.addElement("IBM");
        stocks.addElement("Harley Davidson");

        mutuals = new Vector();
        mutuals.addElement("Fidelity Magellan");
        mutuals.addElement("T Rowe Price");
        mutuals.addElement("Vanguard PrimeCap");
        mutuals.addElement("Lindner Fund");

    }
    //----------------------------------
    static public void main(String[] argv) {
        new WealthBuilder();
    }
}        


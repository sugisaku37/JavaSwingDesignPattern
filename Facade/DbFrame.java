import java.net.URL;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class DbFrame extends Frame
implements ActionListener, ItemListener {
    Database db;
    java.awt.List tables, columns, data;
    TextArea query;
    Button search, quit;
    public DbFrame() {
        super("Database demonstration");
        setGUI();

        db = new Database("sun.jdbc.odbc.JdbcOdbcDriver");
        db.open("jdbc:odbc:Grocery prices", null);
        
        String tnames[] = db.getTableNames();
        loadList(tables, tnames);

        String queryText ="SELECT DISTINCTROW FoodName, StoreName, Price "+
                          "FROM (Food INNER JOIN FoodPrice ON Food.FoodKey = FoodPrice.FoodKey) " +
                          "INNER JOIN Stores ON FoodPrice.StoreKey = Stores.StoreKey "+
                          "WHERE (((Food.FoodName)=\'Oranges\')) ORDER BY FoodPrice.Price;";

        query.setText(queryText);
    }
    //------------------------------------
    private void setGUI() {
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        Panel pn = new Panel();
        add("North", pn);
        pn.setLayout(new GridLayout(1,3));
        pn.add(new Label("Tables"));
        pn.add(new Label("Columns"));
        pn.add(new Label("Data"));
        Panel pc = new Panel();
        add("Center", pc);
        pc.setLayout(new GridLayout(1,3));
        pc.add(tables = new java.awt.List(15));
        pc.add(columns = new java.awt.List(15));
        pc.add(data = new java.awt.List(15));
        tables.addItemListener(this);
        columns.addItemListener(this);

        Panel ps = new Panel();
        add("South", ps);
        ps.add(query = new TextArea("", 3,40));
        addPanel(ps, search = new Button("Run Query"));
        addPanel(ps, quit = new Button("Quit"));
        search.addActionListener(this);
        quit.addActionListener(this);
        setBounds(100, 100, 500, 300);
        setVisible(true);
    }
    //------------------------------------
    private void addPanel(Panel ps, Component c) {
        Panel p = new Panel();
        ps.add(p);
        p.add(c);
    }
    //------------------------------------
    private void loadList(java.awt.List list, String[] s) {
        list.removeAll();
        for (int i=0; i< s.length; i++)
            list.add(s[i]);
    }
    //------------------------------------
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == quit)
            System.exit(0);
        if (obj == search)
            clickedSearch();
    }
    //------------------------------------
    public void itemStateChanged(ItemEvent e) {
        Object obj = e.getSource();
        if (obj == tables)
            showColumns();
        if (obj == columns)
            showData();
    }
    //------------------------------------
    private void showColumns() {
        String cnames[] = db.getColumnNames(tables.getSelectedItem());
        loadList(columns, cnames);
    }
    //------------------------------------
    private void showData() {
        String colname = columns.getSelectedItem();
        String colval = db.getColumnValue(tables.getSelectedItem(), colname);
        data.setVisible(false);
        data.removeAll();
        data.setVisible(true);

        colval = db.getNextValue(columns.getSelectedItem());

        while (colval.length()>0) {
            data.add(colval);
            colval = db.getNextValue(columns.getSelectedItem());
        }
    }
    //------------------------------------
    private void clickedSearch() {
        Results rs = db.execute(query.getText());
        columns.removeAll();
        QueryDialog q = new QueryDialog(this, rs);
        q.show();
    }
    //------------------------------------
    static public void main(String argv[]) {
        new DbFrame();
    }
}


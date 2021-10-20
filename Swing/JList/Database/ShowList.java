import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class ShowList extends JxFrame implements ActionListener {
    DataBase db;
    SortedModel ldata = new SortedModel();
    JButton next;
    int index;
    
    public ShowList() {
        super("Database list of names");
        
        db = new DataBase("names.txt");
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        jp.setLayout(new BorderLayout());
                
        JList nList = new JList(ldata);
        JScrollPane sc = new JScrollPane();
        sc.getViewport().setView(nList);
        jp.add ("Center", sc);
        next = new JButton("Next");
        JPanel bot = new JPanel();
        jp.add("South", bot);
        bot.add(next);
        next.addActionListener (this);

        nList.addMouseListener(new MouseListener(nList, ldata, db, this));
        setSize(new Dimension(300,200));
        setVisible(true);
        index = 0;
        
    }
    public void actionPerformed(ActionEvent evt) {
        if(db.hasMoreElements())
            ldata.addElement ((String)db.nextElement(), db.getKey());
                                                                   
    }
    static public void main(String argv[]) {
        new ShowList();
    }
}

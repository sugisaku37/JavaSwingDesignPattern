import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class ShowList extends JxFrame implements ActionListener {
    JButton next;
    int index;
    
    public ShowList() {
        super("Image names");
        
        SortedModel ldata = new SortedModel("Names.txt");
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        jp.setLayout(new BorderLayout());
                
        JList nList = new JList(ldata);
        nList.setCellRenderer (new CellRenderer());
        JScrollPane sc = new JScrollPane();
        sc.getViewport().setView(nList);
        jp.add ("Center", sc);
        next = new JButton("Next");
        JPanel bot = new JPanel();
        jp.add("South", bot);
        bot.add(next);
        next.addActionListener (this);

        nList.addMouseListener(new MouseListener(nList, ldata, this));
        nList.setCellRenderer (new CellRenderer());
        setSize(new Dimension(300,200));
        setVisible(true);
        index = 0;
        
    }
    public void actionPerformed(ActionEvent evt) {
        
                                                                   
    }
    static public void main(String argv[]) {
        new ShowList();
    }
}

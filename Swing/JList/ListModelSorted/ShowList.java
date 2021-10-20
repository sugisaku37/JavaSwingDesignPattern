import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class ShowList extends JxFrame implements ActionListener {
    String names[]= {"Dave", "Charlie", "Adam", "Edward", "Barry"};
    JButton next;
    SortedModel ldata;
    int index;

    public ShowList() {
        super("List of names");
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        jp.setLayout(new BorderLayout());
                        
        //create the ListModel
        ldata = new SortedModel();
        JList nList = new JList(ldata);
        JScrollPane sc = new JScrollPane();

        sc.getViewport().setView(nList);
        jp.add ("Center", sc);
        
        //add in Next button
        next = new JButton("Next");
        JPanel bot = new JPanel();
        jp.add("South", bot);
        bot.add(next);
        next.addActionListener (this);
        setSize(new Dimension(200,175));
        setVisible(true);
        index = 0;
        
    }
    public void actionPerformed(ActionEvent evt) {
        if(index < names.length)
            ldata.addElement (names[index++]);

    }
    static public void main(String argv[]) {
        new ShowList();
    }
}

import java.awt.*;
import java.awt.event.*;

public class SwimInfo extends Frame
implements ActionListener {
    SwimData sdata, sxdata = null;
    List swList, cloneList;
    Button clone, refresh, quit;
    Swimmer sw;

    public SwimInfo() {
        super("Prototype example");
        sdata = new TimeSwimData("swimmers.txt");

        setGUI();
        loadswList();
    }
    //-----------------------------------
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == clone)
            cloneAndLoad();
        if (obj == refresh)
            loadswList();
        if (obj == quit)
            System.exit(0);
    }
    //-----------------------------------
    private void cloneAndLoad() {
        sxdata = sdata.myClone();
        sxdata.sort ();
        cloneList.removeAll();
        //now print out sorted values from clone
        for (int i=0; i< sxdata.size(); i++) {
            sw = sxdata.getSwimmer(i);
            cloneList.add(sw.getName()+" "+sw.getTime());
        }
    }
    //-----------------------------------
    private void loadswList() {
        swList.removeAll();
        for (int i=0; i< sdata.size(); i++) {
            sw = sdata.getSwimmer(i);
            swList.add(sw.getName()+" "+sw.getTime());
        }
    }
    //-----------------------------------

    private void setGUI() {
        setLayout(new GridLayout(1,3));
        setBackground(Color.lightGray);
        swList = new List(15);
        cloneList = new List(15);
        Panel cp = new Panel();
        add(swList);
        add(cp);
        add(cloneList);
        clone = new Button("Clone -->");
        refresh = new Button("<--Refresh");
        quit = new Button("Quit");
        cp.setLayout(new GridLayout(3,1));
        Panel p1 = new Panel();
        cp.add(p1);
        p1.add(clone);
        Panel p2 = new Panel();
        cp.add(p2);
        p2.add(refresh);
        Panel p3 = new Panel();
        cp.add(p3);
        p3.add(quit);
        clone.addActionListener(this);
        refresh.addActionListener(this);
        quit.addActionListener(this);
        setBounds( 100,100,500,400);
        setVisible(true);
    }
    //-----------------------------------
    static public void main(String argv[]) {
        new SwimInfo();
    }
}


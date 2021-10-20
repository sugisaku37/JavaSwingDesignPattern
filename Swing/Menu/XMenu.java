//demonstrates use of the Action object
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class XMenu extends JxFrame {
    JPanel jp;            
    JMenuItem menuitem;
    JToolBar toolbar;

    public XMenu() {
        super("Extended Menu");
        JMenuBar mbar = new JMenuBar();  //set up  menu bar
        setJMenuBar(mbar);

        //Add File menu
        JMenu mFile = new JMenu("File");
        mbar.add(mFile);

        //create two Action Objects
        Action open = new FileButton("Open", new ImageIcon("open.gif"), this);
        mFile.add(open);

        Action exit = new ExitButton("Exit", new ImageIcon("exit.gif"));
        mFile.addSeparator();
        mFile.add(exit);

        //now create toolbar that fixes up the buttons as you add them
        toolbar = new JToolBar();
        getContentPane().add(jp = new JPanel());
        jp.setLayout(new BorderLayout());
        jp.add("North", toolbar);

        //add the two action objects
        toolbar.add(open);
        toolbar.addSeparator();
        toolbar.add(exit);
        setSize(300, 200);
        setVisible(true);
    }
    //-----------------------------------
    static public void main(String argv[]) {
        new XMenu();
    }
}

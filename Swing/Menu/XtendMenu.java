//demonstrates use of the Action object
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class XtendMenu extends JxFrame {
    JPanel jp;            
    JMenuItem menuitem;
    ActionToolBar toolbar;

    public XtendMenu() {
        super("Extended Menu");
        JMenuBar mbar = new JMenuBar();  //set up  menu bar
        setJMenuBar(mbar);

        //Add File menu
        JMenu mFile = new JMenu("File");
        mbar.add(mFile);

        //create two Action Objects
        Action open = new FileButton("Open", new ImageIcon("open.gif"), this);
        menuitem = mFile.add(open);
        menuitem.setIcon(null);

        Action exit = new ExitButton("Exit", new ImageIcon("exit.gif"));
        mFile.addSeparator();
        menuitem = mFile.add(exit);
        menuitem.setIcon(null);
        //exit.setEnabled(false);  //--used to test disable

        //now create toolbar that fixes up the buttons as you add them
        toolbar = new ActionToolBar();
        getContentPane().add(jp = new JPanel());
        jp.setLayout(new BorderLayout());
        jp.add("North", toolbar);

        //add the two action objects
        toolbar.add(open, "Open a file");
        toolbar.addSeparator();
        toolbar.addSeparator();
        toolbar.addSeparator();
        toolbar.add(exit, "Exit from program");
        setSize(300, 200);
        setVisible(true);
    }
    //-----------------------------------
    static public void main(String argv[]) {
        new XtendMenu();
    }
}

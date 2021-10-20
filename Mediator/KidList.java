import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class KidList extends JawtList
implements ListSelectionListener {
    private KidData kdata;
    private Mediator med;

    public KidList(Mediator md) {
        super(20);
        kdata = new KidData ("50free.txt");
        fillKidList();
        med = md;
        med.registerKidList(this);
        addListSelectionListener(this);
    }
    //----------------------------------
    public void valueChanged(ListSelectionEvent ls) {
        JList obj = (JList)ls.getSource();
        if (obj.getSelectedIndex() >= 0)
            med.select();
    }
    //----------------------------------
    private void fillKidList() {
        Enumeration ekid = kdata.elements();
        while (ekid.hasMoreElements()) {
            Kid k =(Kid)ekid.nextElement();
            add(k.getFrname()+" "+k.getLname());
        }
    }
}


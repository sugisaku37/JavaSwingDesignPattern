import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class JListData extends AbstractListModel {
    private Vector data;
    public JListData() {
        data = new Vector();
    }
    public int getSize() {
        return data.size();
    }
    public Object getElementAt(int index) {
        return data.elementAt(index);
    }
    public void addElement(String s) {
        data.addElement(s);
        fireIntervalAdded(this, data.size()-1, data.size());
    }
}

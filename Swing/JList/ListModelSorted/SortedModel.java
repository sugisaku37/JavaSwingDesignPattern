import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class SortedModel extends DefaultListModel {
    private String[] dataList;
    public void addElement(Object obj) {
        //add to the internal Vector
        super.addElement(obj);
        //copy into the array
        dataList = new String[size()];
        for(int i = 0; i < size(); i++) {
            dataList[i] = (String)elementAt(i);
        }
        //sort the data and copy it back
        Arrays.sort(dataList); // sort the data
        clear();  //clear out the Vector

        //reload the sorted data
        for(int i = 0; i < dataList.length; i++)
            super.addElement(dataList[i]);

        //tell JList to repaint
        fireContentsChanged(this, 0, size());
    }
}

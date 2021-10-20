import javax.swing.*;
import java.util.*;

public class SortedModel extends DefaultListModel {
  private Person[] dataList;
  
  public void addElement(Object obj, int key) {
    Person per = new Person((String) obj, key);
    super.addElement(per);
    dataList = new Person[size()];
    for(int i=0; i< size(); i++) {
        dataList[i] = (Person)elementAt(i);
    }
    Arrays.sort (dataList);
    clear();
    for(int i  =0; i < dataList.length; i++)
         super.addElement(dataList[i]);
    fireContentsChanged(this, 0, size());
  }
  public Object getElementAt(int index) {
      Person p = dataList[index];
      return p.getFrname ()+" "+p.getLname ();
  }
  public Object get(int index) {
      return getElementAt(index);
  }
  public int getKey(int index) {
    Person p = dataList[index];
    return p.getKey ();
  }
}

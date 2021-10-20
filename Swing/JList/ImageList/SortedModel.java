import javax.swing.*;
import java.util.*;

public class SortedModel extends DefaultListModel {
  private Person[] dataList;

  public SortedModel(String filename) {
      InputFile f = new InputFile(filename);
      String s = f.readLine();
      int i=0;
      while (s != null) {
          addElement(s, i++);
          s =f.readLine();
      }
      f.close();
  }
  
  public void addElement(Object obj, int key) {
    Person per = new Person((String)obj, key);
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
      return p;
  }
  public Object get(int index) {
      return dataList[index];
  }
  public int getKey(int index) {
    Person p = dataList[index];
    return p.getKey ();
  }
}

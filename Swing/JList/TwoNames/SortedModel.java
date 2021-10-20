import javax.swing.*;
import java.util.*;
/** Data model which uses and sortds Person objects*/
public class SortedModel extends DefaultListModel {
  private Person[] dataList;
  
  public void addElement(Object obj) {
    Person per = new Person((String) obj);
    super.addElement(per);
    dataList = new Person[size()];
    //copy the Persons into an array
    for(int i=0; i< size(); i++) {
        dataList[i] = (Person)elementAt(i);
    }
    //sort them
    Arrays.sort (dataList);
    //and put them back
    clear();
    for(int i  =0; i < dataList.length; i++)
         super.addElement(dataList[i]);
    fireContentsChanged(this, 0, size());
  }
  public Object getElementAt(int index) {
      //returns both names as a string
      Person p = dataList[index];
      return p.getName();
  }
  public Object get(int index) {
      return getElementAt(index);
  }
}

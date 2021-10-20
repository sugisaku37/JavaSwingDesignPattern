import java.awt.*;
import java.util.*;
import javax.swing.*;

//this is the Implementor class
//that decides which class to return
public class SortBridge extends ListBridge {
   
  public static final int LIST=1, TABLE=2;
  
  public SortBridge(int type) {
     super(type);
    }
//-------------------------------------      
  public void addData(Vector v) {
     Vector sv = sortData(v);
     
     for(int i=0; i < sv.size(); i++) {
      String s = (String)sv.elementAt (i);
      list.addLine (s);
     }
  }
//-------------------------------------
  private Vector sortData(Vector v) {
     String s[] = new String[v.size()];
     for(int i=0; i<v.size(); i++)
        s[i] = (String)v.elementAt (i);
     for(int i=0; i<v.size(); i++) {
        for(int j=i; j<v.size(); j++) {
           if(s[i].compareTo (s[j])>0) {
              String tmp = s[i];
              s[i] = s[j];
              s[j] = tmp;
           }
        }
     }
      Vector v1 = new Vector();
      for (int i = 0; i < v.size(); i++) {
         v1.addElement(s[i]);
      }
      return v1;
  }

}

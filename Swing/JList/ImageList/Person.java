import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Person implements Comparable {
  
  protected String frname, lname;
  private String image;
  protected int key;
  ImageIcon icon;
  
  String phone;

  public Person(String dataline, int nameKey) {
    StringTokenizer tok = new StringTokenizer(dataline, ",");
    String name = (String)tok.nextElement ();
    int i = name.indexOf (" ");
    frname = name.substring (0, i).trim();
    lname = name.substring (i).trim();
    phone = (String)tok.nextElement ();
    image = ((String)tok.nextElement ()).trim();
    icon = new ImageIcon("images/"+image);
    key = nameKey;
  }
  public int getKey() {
      return key;
  }
  public String getPhone() {
      return phone;
  }
  public int compareTo(Object obj) {
      Person to = (Person)obj;
      return lname.compareTo (to.getLname ());
  }
  public String getLname() {
      return lname;
  }
  public String getFrname() {
      return frname;
  }
  public String getName() {
      return getFrname()+" "+getLname(); 
  }
  public ImageIcon getIcon() {
      return icon;
  }
}

public class Person implements Comparable {
  
  private String frname, lname;
  private int key;

  public Person(String name, int nameKey) {
    int i = name.indexOf (" ");
    frname = name.substring (0, i).trim();
    lname = name.substring (i).trim();
    key = nameKey;
  }
  public int getKey() {
      return key;
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
}

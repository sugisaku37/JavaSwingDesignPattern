public class Person implements Comparable {
  
  private String frname, lname;

  public Person(String name) {
    int i = name.indexOf (" ");
    frname = name.substring (0, i).trim();
    lname = name.substring (i).trim();
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
}

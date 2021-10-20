import java.util.*;

public abstract class AbstractEmployee {
   protected String name;
   protected float salary;
   protected Employee parent = null;
   protected boolean leaf = true;
 
 public abstract float getSalary();
 public abstract String getName();
 public abstract boolean add(Employee e);
 public abstract void remove(Employee e);
 public abstract Enumeration subordinates();
 public abstract Employee getChild(String s);
 public abstract float getSalaries();  
 public boolean isLeaf() {return leaf;}
 
}

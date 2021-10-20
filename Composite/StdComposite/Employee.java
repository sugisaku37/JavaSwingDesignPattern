import java.util.*;

public class Employee extends AbstractEmployee {
    public Employee(String _name, long _salary) {
        name = _name;
        salary = _salary;
        leaf = true;
    }
    //--------------------------------------
    public Employee(Employee _parent, String _name, long _salary) {
        name = _name;
        salary = _salary;
        parent = _parent;
        leaf = true;
    }
    //--------------------------------------
    public long getSalary() {
        return salary;
    }
    //--------------------------------------
    public String getName() {
        return name;
    }
    //--------------------------------------
    public boolean add(Employee e) throws NoSuchElementException {
        throw new NoSuchElementException("No subordinates");    
    }
    //--------------------------------------
    public void remove(Employee e) throws NoSuchElementException {
        throw new NoSuchElementException("No subordinates"); 
    }
    //--------------------------------------
    public Enumeration subordinates () {
        Vector v = new Vector();
        return v.elements ();      
    }
    //--------------------------------------
    public Employee getChild(String s) throws NoSuchElementException {
        throw new NoSuchElementException("No children");
    }

    //--------------------------------------
    public long getSalaries() {
        return salary;
    }
    //--------------------------------------
    public Employee getParent() {
        return parent;
    }
}

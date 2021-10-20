import java.util.*;

public class Employee {
    private String name;
    private long salary;
    private Vector subordinates;
    private Employee parent = null;
//--------------------------------------
    public Employee(String _name, long _salary) {
        name = _name;
        salary = _salary;
        subordinates = new Vector();
    }
    //--------------------------------------
    public Employee(Employee _parent, String _name, long _salary) {
        name = _name;
        salary = _salary;
        parent = _parent;
        subordinates = new Vector();
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
    public void add(Employee e) {
        subordinates.addElement(e);   
    }
    //--------------------------------------
    public void remove(Employee e) {
        subordinates.removeElement(e);
    }
    //--------------------------------------
    public Enumeration elements() {
        return subordinates.elements();
    }
    //--------------------------------------
    public Employee getChild(String s) {
        Employee newEmp = null;

        if (getName().equals(s))
            return this;
        else {
            boolean found = false;
            Enumeration e = elements();
            while (e.hasMoreElements() && (! found)) {
                newEmp = (Employee)e.nextElement();
                found = newEmp.getName().equals(s);
                if (! found) {
                    newEmp = newEmp.getChild(s);
                    found =(newEmp != null);
                }
            }
            if (found)
                return newEmp;
            else
                return null;
        }
    }

    //--------------------------------------
    public float getSalaries() {
        float sum = salary;
        for (int i = 0; i < subordinates.size(); i++) {
            sum += ((Employee)subordinates.elementAt(i)).getSalaries();
        }
        return sum;
    }
}

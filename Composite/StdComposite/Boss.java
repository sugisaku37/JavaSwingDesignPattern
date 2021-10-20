import java.util.*;

public class Boss extends Employee {
    Vector employees; 

    public Boss(String _name, long _salary) {
        super(_name, _salary);
        leaf = false;
        employees = new Vector();
    }
//--------------------------------------
    public Boss(Employee _parent, String _name, long _salary) {
        super(_parent, _name, _salary);
        leaf = false;
        employees = new Vector();
    }
    //--------------------------------------
    public Boss(Employee emp) {
        //promotes an employee position to a Boss
        //and thus allows it to have employees
        super(emp.getName (), emp.getSalary());
        employees = new Vector();
        leaf = false;
    }
    //--------------------------------------
    public boolean add(Employee e) throws NoSuchElementException {
        employees.add(e); 
        return true;
    }
    //--------------------------------------
    public void remove(Employee e) throws NoSuchElementException {
        employees.removeElement(e);
    }
    //--------------------------------------
    public Enumeration subordinates () {
        return employees.elements ();
    }
    //--------------------------------------
    public Employee getChild(String s) throws NoSuchElementException {

        Employee newEmp = null;

        if (getName().equals(s))
            return this;
        else {
            boolean found = false;
            Enumeration e = subordinates();
            while (e.hasMoreElements() && (! found)) {
                newEmp = (Employee)e.nextElement();
                found = newEmp.getName().equals(s);
                if (! found) {
                    if (! newEmp.isLeaf ()) {
                        newEmp = newEmp.getChild(s);
                    } else
                        newEmp = null;
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
    public long getSalaries() {
        long sum = salary;
        for (int i = 0; i < employees.size(); i++) {
            sum += ((Employee)employees.elementAt(i)).getSalaries();
        }
        return sum;
    }


}

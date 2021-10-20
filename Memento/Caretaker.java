import java.util.*;

public class Caretaker {
    private Vector undoList;
    private Vector drawings;

    public Caretaker(Vector drw) {
        undoList = new Vector();
        drawings =  drw;
    }
//------------------------------------  
    public void rememberPosition(VisRectangle rect) {
        Memento m = new Memento(rect);
        undoList.addElement(m);
    }
    //------------------------------------
    public void clear(Vector drw) {
        undoList = new Vector();
        drawings = drw;
    }
    //------------------------------------
    public void addElement(Object obj) {
        undoList.addElement (obj);
    }
    //------------------------------------
    private void remove(Integer obj) {
        Object drawObj = drawings.lastElement();
        drawings.removeElement(drawObj);
    }
    //------------------------------------
    private void remove(Memento obj) {
        Memento m = obj;
        m.restore();     //and restore the old position
    }
    //------------------------------------
    public void undo() {
        if (undoList.size() > 0) {
            //get last element in undo list
            Object obj = undoList.lastElement();
            undoList.removeElement(obj);   //and remove it
            if (obj instanceof Integer)
                remove((Integer)obj);         //remove Integer or Memento
            else
                remove((Memento)obj);

        }
    }
}


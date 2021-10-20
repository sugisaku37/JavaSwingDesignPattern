import java.awt.*;
import java.util.*;
//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class Mediator {
    boolean startRect;
    boolean rectSelected;
    Vector drawings;

    RectButton rect;
    JPanel canvas;
    VisRectangle selectedRectangle;
    private Caretaker caretaker;

    public Mediator() {
        startRect = false;
        rectSelected = false;
        drawings = new Vector();
        caretaker =  new Caretaker(drawings);

    }
//-------------------------------------------
    public void startRectangle() {
        startRect = true;
    }
//-------------------------------------------
    public void createRect(int x, int y) {
        unpick();   //make sure no rectangle is selected
        if (startRect) {  //if rect button is depressed
            Integer count = new Integer(drawings.size());
            caretaker.addElement(count);   //Save previous drawing list size
            VisRectangle v = new VisRectangle(x, y);
            drawings.addElement(v);       //add new element to list
            startRect = false;            //done with this rectangle
            rect.setSelected(false);      //unclick button
            canvas.repaint();
        } else
            pickRect(x, y); //if not pressed look for rect to select
    }
//------------------------------------------
    public void registerRectButton(RectButton rb) {
        rect = rb;
    }
//-------------------------------------------
    public void registerCanvas(JPanel p) {
        canvas = p;
    }
//-------------------------------------------
    private void unpick() {
        rectSelected = false;
        if (selectedRectangle != null) {
            selectedRectangle.setSelected(false);
            selectedRectangle = null;
            repaint();
        }
    }
//-------------------------------------------
    public void rememberPosition() {
        if (rectSelected) {
            Memento m = new Memento(selectedRectangle);
            caretaker.addElement(m);
            repaint();
        }
    }
//-------------------------------------------
    public void pickRect(int x, int y) {
        //save current selected rectangle to avoid double save of undo
        VisRectangle lastPick = selectedRectangle;
        unpick();
        for (int i=0; i<drawings.size(); i++) {
            VisRectangle v = (VisRectangle)drawings.elementAt(i);
            if (v.contains(x,y)) {    //did click inside a rectangle
                selectedRectangle = v; //save it
                rectSelected = true;
                if (selectedRectangle != lastPick)  //but don't save twice
                    caretaker.rememberPosition(selectedRectangle);

                v.setSelected(true);   //turn on handles
                repaint();             //and redraw
            }
        }
    }                   
//-------------------------------------------
    public void clear() {
        drawings = new Vector();
        caretaker.clear (drawings);

        rectSelected = false;
        selectedRectangle = null;
        repaint();
    }
//-------------------------------------------
    private void repaint() {
        canvas.repaint();
    }
//-------------------------------------------
    public void drag(int x, int y) {
        if (rectSelected) {
            if (selectedRectangle.contains(x, y)) {
                selectedRectangle.move(x,y);
                repaint();
            }
        }
    }
//-------------------------------------------
    public void reDraw(Graphics g) {
        g.setColor(Color.black);
        for (int i=0; i< drawings.size(); i++) {
            VisRectangle v = (VisRectangle)drawings.elementAt(i);
            v.draw(g);
        }
    }
//-------------------------------------------
    public void undo() {
        caretaker.undo ();
        repaint();
    }
//-------------------------------------------
    public void removeDrawing(Object drawObj) {
        drawings.removeElement(drawObj);
        repaint();
    }
}

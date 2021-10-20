import java.awt.*;
import java.util.*;
//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class Mediator {
    private boolean startRect;
    private boolean dSelected;
    private Vector drawings;
    private RectButton rectButton;
    private FillButton fillButton;
    private CircleButton circButton;
    private PickButton arrowButton;
    private JPanel canvas;
    private Drawing selectedDrawing;
    private StateManager stMgr;

    public Mediator() {
        startRect = false;
        dSelected = false;
        drawings = new Vector();
        stMgr = new StateManager(this);
    }
//-------------------------------------------
    public void startRectangle() {
        stMgr.setRect();
        arrowButton.setSelected(false);
        circButton.setSelected(false);
        fillButton.setSelected(false);
    }
//---------------------------------------------
    public void startCircle() {
        stMgr.setCircle();
        rectButton.setSelected(false);
        arrowButton.setSelected(false);
        fillButton.setSelected(false);
    }
//---------------------------------------------
    public void startFill() {
        stMgr.setFill();
        rectButton.setSelected(false);
        circButton.setSelected(false);
        arrowButton.setSelected(false);
        stMgr.select(selectedDrawing, Color.red);
        repaint();
    }
//---------------------------------------------
    public void startArrow() {
        stMgr.setArrow();
        rectButton.setSelected(false);
        circButton.setSelected(false);
        fillButton.setSelected(false);
    }
//---------------------------------------------
    public Drawing getSelected() {
        return selectedDrawing;
    }
//---------------------------------------------
    public void fillSelected() {
        if (dSelected) {
            selectedDrawing.setFill(Color.red);
        }
    }
//---------------------------------------------
    public Vector getDrawings() {
        return drawings;
    }
//-------------------------------------------
    public void addDrawing(Drawing d) {
        drawings.addElement(d);
    }
//-------------------------------------------
    public void registerRectButton(RectButton rb) {
        rectButton = rb;
    }
    public void registerCircleButton(CircleButton cb) {
        circButton = cb;
    }
    public void registerArrowButton(PickButton ab) {
        arrowButton = ab;
    }
    public void registerFillButton(FillButton fb) {
        fillButton = fb;
    }
//-------------------------------------------
    public void registerCanvas(JPanel p) {
        canvas = p;
    }
//-------------------------------------------
    public void mouseDown(int x, int y) {
        stMgr.mouseDown(x, y);
        repaint();
    }
//-------------------------------------------
    public void mouseUp(int x, int y) {
        stMgr.mouseUp(x, y);
    }
//-------------------------------------------
    public void unpick() {
        dSelected = false;
        if (selectedDrawing != null) {
            selectedDrawing.setSelected(false);
            selectedDrawing = null;
            repaint();
        }
    }
//-------------------------------------------
    public void setSelected(Drawing d) {
        if (d!=null) {
            dSelected = true;
            selectedDrawing = d;
            d.setSelected(true);
            repaint();
        }
    }
//-------------------------------------------
    public void pickRect(int x, int y) {

    }                   
//-------------------------------------------
    public void clear() {
        drawings = new Vector();
        dSelected = false;
        selectedDrawing = null;
        repaint();
    }
//-------------------------------------------
    private void repaint() {
        canvas.repaint();
    }
//-------------------------------------------
    public void mouseDrag(int x, int y) {
        stMgr.mouseDrag(x, y);
    }
//-------------------------------------------
    public void reDraw(Graphics g) {
        g.setColor(Color.black);
        for (int i=0; i< drawings.size(); i++) {
            Drawing v = (Drawing)drawings.elementAt(i);
            v.draw(g);
        }
    }
}

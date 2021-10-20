import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
 
public class TriangleDrawing extends JxFrame {
    private StdTriangle t, t1;
    private IsocelesTriangle it;

    public TriangleDrawing() {
        super("Draw triangles");
        TPanel tp = new TPanel();
        t = new StdTriangle(new Point(10,10), new Point(150,50), new Point(100, 75));
        it = new IsocelesTriangle(new Point(150,100), new Point(240,40), new Point(175, 150));
        t1 = new StdTriangle(new Point(150,100), new Point(240,40), new Point(175, 150));
        tp.addTriangle(t);
        //tp.addTriangle(it);
         tp.addTriangle(t1);

        getContentPane().add(tp);
        setSize(300, 200);
        setBackground(Color.white);
        setVisible(true);
    }
    static public void main(String[] arg) {
        new TriangleDrawing();
    }
}



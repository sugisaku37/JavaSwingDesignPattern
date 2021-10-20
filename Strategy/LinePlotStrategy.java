import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;

public class LinePlotStrategy extends PlotStrategy {
    private LinePlotPanel lp;

//--------------------------------------
    public LinePlotStrategy() {
        super("Line plot");
        lp = new LinePlotPanel();
        getContentPane().add(lp);
    }
//--------------------------------------
    public void plot(float[] xp, float[] yp) {
        x = xp;  y = yp;        //copy in data
        findBounds();           //sets maxes and mins
        setSize(width, height);
        setVisible(true);
        setBackground(Color.white);
        lp.setBounds(minX, minY, maxX, maxY);
        lp.plot(xp, yp, color); //set up plot data
     }
}

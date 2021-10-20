import java.awt.*;
import java.util.*;
import javax.swing.*;

public class TPanel extends JPanel {
    private Vector triangles;
    public TPanel() {
        triangles = new Vector();
    }
    public void addTriangle(Triangle t) {
        triangles.addElement(t);
    }
    public void paint(Graphics g) {
        for (int i = 0; i < triangles.size(); i++) {
            Triangle tngl = (Triangle)triangles.elementAt(i);
            tngl.draw(g);
        }
    }
}

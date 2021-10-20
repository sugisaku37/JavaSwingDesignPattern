import java.awt.*;
public class StdTriangle extends Triangle {
    public StdTriangle(Point a, Point b, Point c) {
        super(a, b, c);
    }
    public Point draw2ndLine(Graphics g, Point a, Point b) {
        g.drawLine(a.x, a.y, b.x, b.y);
        return  b;
    }
}

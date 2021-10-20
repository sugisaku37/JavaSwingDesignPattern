import java.awt.*;

public class VisRectangle {
    int x, y, w, h;    //package protected
    private Rectangle rect;
    private boolean selected;

    public VisRectangle(int xpt, int ypt) {
        x = xpt;   y = ypt;
        w = 40;    h = 30;
        saveAsRect();
    }
    //-------------------------------------------
    public void setSelected(boolean b) {
        selected = b;
    }
    //-------------------------------------------
    private void saveAsRect() {
        rect = new Rectangle(x-w/2, y-h/2, w, h);
    }
    //-------------------------------------------
    public void draw(Graphics g) {
        g.drawRect(x, y, w, h);
        if (selected) {
            g.fillRect(x+w/2, y-2, 4, 4);
            g.fillRect(x-2, y+h/2, 4, 4);
            g.fillRect(x+w/2, y+h-2, 4, 4);
            g.fillRect(x+w-2, y+h/2, 4, 4);
        }
    }
    //-------------------------------------------
    public boolean contains(int x, int y) {
        return rect.contains(x, y);
    }
    //-------------------------------------------
    public void move(int xpt, int ypt) {
        x = xpt; y = ypt;
        saveAsRect();
    }
}



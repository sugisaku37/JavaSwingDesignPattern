public class Memento {
    VisRectangle rect;
    private int x, y, w, h;
    public Memento(VisRectangle r) {
        rect = r;
        x = rect.x;  y = rect.y;
        w = rect.w;  h = rect.h;
    }
    //-------------------------------------------
    public void restore() {
        //restore the internal state of
        //the specified rectangle
        rect.x = x;  rect.y = y;
        rect.h = h;  rect.w = w;
    }
}

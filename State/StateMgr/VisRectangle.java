import java.awt.*;

public class VisRectangle extends Drawing
{
 
  public VisRectangle(int xpt, int ypt)
  {
     x = xpt;   y = ypt;
     w = 40;    h = 30;
     saveAsRect();
  }
  //-------------------------------------------
  public void draw(Graphics g)
  {
     g.drawRect(x, y, w, h);
     if(filled)
     {
        g.setColor(fillColor);
        g.fillRect(x,y,w,h);
     }
     if (selected)
     {
        g.setColor(Color.black);
        g.fillRect(x+w/2, y-2, 4, 4);
        g.fillRect(x-2, y+h/2, 4, 4);
        g.fillRect(x+w/2, y+h-2, 4, 4);
        g.fillRect(x+w-2, y+h/2, 4, 4);
     }
  }
}

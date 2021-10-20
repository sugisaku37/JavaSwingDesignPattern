import java.awt.*;

public class VisCircle extends Drawing
{
 
  public VisCircle(int xpt, int ypt)
  {
     x = xpt;   y = ypt;
     w = 40;    h = 30;
     saveAsRect();
  }
  //-------------------------------------------
  public void draw(Graphics g)
  {
     g.drawArc(x, y, w, h, 0, 360);
     if(filled)
      {
      g.setColor(fillColor);
      g.fillArc(x, y, w, h, 0 ,360);
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

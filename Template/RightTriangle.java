import java.awt.*;
public class RightTriangle extends Triangle
{
   
    //this is a dummy class used to generate the
    //class diagram only.
    
   int newcx, newcy;
   int incr;

   public RightTriangle(Point a, Point b, Point c) {
       super(a,b,c);

   }
   public Point draw2ndLine(Graphics g, Point a, Point b){
       return a;
   }

}



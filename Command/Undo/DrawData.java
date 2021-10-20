public class DrawData {
   private int x, y, dx, dy;

   public DrawData(int xx, int yy, int dxx, int dyy) {
      x = xx; y = yy;
      dx = dxx; dy = dyy;
   }
   public int getX() { return x;}
   public int getY() {return y;}
   public int getDx() {return dx; }
   public int getDy() {return dy; }

}

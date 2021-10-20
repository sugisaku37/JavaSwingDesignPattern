import java.net.URL;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

class QueryDialog extends Dialog
   implements ActionListener
{
   Results results;
   Button ok;
   TextPanel pc;
   Vector tables;

   public QueryDialog(Frame f, Results r)
   {
   super(f, "Query Result");
   results = r;
   setLayout(new BorderLayout());
   ok = new Button("OK");
   Panel p = new Panel();
   add("South", p);
   p.add(ok);
   ok.addActionListener(this);

   pc = new TextPanel();
   pc.setBackground(Color.white);
   add("Center", pc);
   makeTables();
   setBounds(100, 100, 500, 300);
   setVisible(true);
   repaint();
   }
   //-------------------------------------
   private void makeTables()
   {
      tables = new Vector();
      String t[] = results.getMetaData();
      tables.addElement( t);
      while (results.hasMoreElements()) 
         {
         tables.addElement(results.nextElement());
         }
   }
      //-------------------------------------
   public void actionPerformed(ActionEvent e)
   {
      setVisible(false);
   }
   //-------------------------------------
   class TextPanel extends Panel
      {
      public void paint(Graphics g)
      {
      String s[];
      int x=0;
      int y =g.getFontMetrics().getHeight();
      int deltaX = (int)1.5f*(g.getFontMetrics().stringWidth("wwwwwwwwwwwwww"));
      for (int i=0; i< tables.size(); i++) 
         {
         s  = (String[])tables.elementAt(i);
         for (int j =0; j< s.length; j++) 
         {
            String st= s[j];
            g.drawString(st, x, y);
            x += deltaX;
         }
         x = 0;
         y += g.getFontMetrics().getHeight();
         if (i == 0) y += g.getFontMetrics().getHeight();
      }
      }

   }
}

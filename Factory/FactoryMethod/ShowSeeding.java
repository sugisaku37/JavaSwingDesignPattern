import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class ShowSeeding extends JxFrame
   implements ListSelectionListener { 
   
   JawtList evList, swList;
   Vector events;

   public ShowSeeding() {
   
   super("Factory Method Seeding");
   events =  new Vector();

   JPanel jp = new JPanel();
   getContentPane().add(jp);
   jp.setLayout(new GridLayout(1,2));
   
   evList = new JawtList(20);
   swList = new JawtList(20);
   jp.add(evList);
   jp.add(swList);
   evList.addListSelectionListener(this);

   events.addElement(new TimedFinalEvent("500free.txt", 6));
   evList.add("500 Free");
   events.addElement(new PrelimEvent("100free.txt", 6));
   evList.add("100 Free");
   
   setSize(new Dimension(400,200));
   setVisible(true);

   }
//-----------------------------------------
   public void valueChanged(ListSelectionEvent e)
   {
      swList.clear();
      int index = evList.getSelectedIndex();
      System.out.println("index="+index);
      Event ev = (Event)events.elementAt(index);
      Seeding sd = ev.getSeeding();
      Enumeration Enumeration = sd.getSwimmers();
      while(Enumeration.hasMoreElements())
      {
         Swimmer sw = (Swimmer) Enumeration.nextElement();
         swList.add(sw.getHeat()+" "+sw.getLane()+" "+sw.getName()+" "+sw.getTime());
      }
   }
   //----------------------------------------   
   static public void main(String argv[]) {
      new ShowSeeding();
   }

}

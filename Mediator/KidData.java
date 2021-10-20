import java.util.*;
public class KidData
{
   Vector kids;
//------------------------------------------   
   public KidData(String filename)
   {
      kids = new Vector();
      InputFile f = new InputFile(filename);
      String s = f.readLine();
      while(s != null)
      {
         if(s.trim().length() > 0)
         {
         Kid k = new Kid(s);
         kids.addElement(k);
         }
         s = f.readLine();
      }
   }
   //--------------------------------
   public Kid[] getData()
   {
      Kid[] kd = new Kid[kids.size()];
      for(int i=0; i< kids.size(); i++)
         kd[i] = (Kid)kids.elementAt(i);
   return kd;
   }
   //--------------------------------
   public Enumeration elements()
   {
      return kids.elements();
   }
   //-------------------------------
   public int size()
   {
      return kids.size();
   }
   //--------------------------------
   public Kid getKid(int i)
   {
      return (Kid)kids.elementAt(i);
   }
   //--------------------------------
  
}


import java.util.*;

public class SexSwimData extends SwimData {
   
   SwimData swimdata;
   boolean female;
   Vector sexData;

   public SexSwimData(SwimData sd) {
     swimdata=sd.deepClone ();
     female = true;
   }
   //------------------------------
   public void setFemale(boolean f) {
      female = f;
   }
   //------------------------------
   public void sort() {
      sexData = new Vector();
      for (int i=0; i<swimdata.size (); i++) {
         Swimmer sw = swimdata.getSwimmer (i);
         if (sw.isFemale () == female ) {
            sexData.addElement (sw);
         }
      }
   }   
   //------------------------------
   public int size() {
      return sexData.size ();
   }
   //-------------------------------------------
   public String getName(int i)
   {  
      Swimmer sw = getSwimmer(i);
      if(sw != null)
         return sw.getName () +" "+sw.getTime ();
      else
         return "";

   }
   //-------------------------------------------
   public Swimmer getSwimmer(int i)
   {
      if ( (i >= 0) && (i < sexData.size()) ) {
         Swimmer sw = (Swimmer)sexData.elementAt(i);
         return sw;
      }
      else
         return null;
   }

   //------------------------------
   public void swapSex() {
      female =  ! female;
      sort();
   }
}


import java.util.*;

public class AgeSwimData extends SexSwimData {
   
   SwimData swimdata;
   Vector ageData;
   boolean female;
   int age8, age9, age10;  //limited set of counters

   public AgeSwimData(SwimData sd) {
     super(sd);
     swimdata = sd.deepClone ();
   }
   //------------------------------
   public void sort() {
      ageData = new Vector();
      age8=0; age9=0; age10=0;

      //count the number of swimmers in each of 3 age groups
      //note this can be made much more general
      for (int i=0; i < swimdata.size (); i++) {
         Swimmer sw = swimdata.getSwimmer (i);
         switch(sw.getAge ()) {
         case 8: age8++;
            break;
         case 9: age9++;
            break;
         case 10: age10++;
         }
      }
      
       ageData.addElement (makeXs(age8, 8));
       ageData.addElement (makeXs(age9, 9));
       ageData.addElement (makeXs(age10, 10));
   }   
   //------------------------------
   private String makeXs(int a, int age) {
      String ag = new Integer(age).toString() +" ";
      for(int i=0; i< a; i++)
         ag +="X";
      return ag;
   }                            
   //------------------------------
   public void setFemale(boolean f) {
   }
//------------------------------
   public int size() {
      return ageData.size ();
   }
   //-------------------------------------------
   public String getName(int i)
   {  
      if(i<ageData.size())
         return (String)ageData.elementAt(i);
      else
         return "";
   }
   
}


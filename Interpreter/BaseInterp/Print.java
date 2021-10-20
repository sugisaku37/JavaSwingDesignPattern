import java.util.*;
public class Print extends Verb
{
   Kid[] kids;
   
 public Print(String s)
{
   super(s);
   value = PRINT;
}

//-----------------------------------
public void execute()
{
   String pline;

   kids = data.getData();
   ptable.clear();

   for (int i=0; i < kids.length; i++) 
   {
      pline = "";    //line in output list
      for (int j = 0; j < args.size(); j++)
      {
         
         ParseVar v = (ParseVar)args.elementAt(j);
         if(v instanceof MultVar)
         {  
            MultVar mv = (MultVar)v;
            Vector vlist = mv.getVector();
            for(int k=0; k < vlist.size(); k++)
            {
            ParseVar pv = (ParseVar)vlist.elementAt(k);
            pline+= kids[i].getData(pv.getValue()) + "   ";
            }
         }
         else
         {
            pline+= kids[i].getData(v.getValue()) + "   ";
         }
      }
      ptable.add(pline);
   }
   ptable.validate();
   ptable.repaint();
}
//-----------------------------------

}

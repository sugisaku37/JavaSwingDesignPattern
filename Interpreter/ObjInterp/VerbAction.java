import java.util.*;

public class VerbAction extends InterpChain {
   Vector actionList;

public VerbAction(Vector aList) {
   actionList = aList;
}
public boolean interpret() {
 //move top verb to action list
     if(stk.top().getType() == ParseObject.VERB)
     {
      actionList.addElement(stk.pop());
      return true;
     }
     else
       return false;
  }

}
 

public class VerbMultvarParse extends InterpChain {

public boolean interpret() {
//reduce Verb MultVar to Verb containing vars
     if (topStack(ParseObject.MULTVAR, ParseObject.VERB)) 
        {
        addArgsToVerb();
         return true;
       }
    else
       return false;
  }

}
 
 
 
 
    

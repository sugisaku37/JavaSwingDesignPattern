public class VarMultvarParse extends InterpChain {

public boolean interpret() {
if(topStack(ParseObject.VAR, ParseObject.MULTVAR))
      {
     //reduce (Multvar Var) to Multvar
        ParseVar v = (ParseVar)stk.pop();
        MultVar mv = (MultVar)stk.pop();
        mv.add(v);
        stk.push(mv);
        return true;
       }
    else
       return false;
  }

}


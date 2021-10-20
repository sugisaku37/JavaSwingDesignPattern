public class MultvarVarParse extends InterpChain {

protected boolean parse() {
  //reduce MULTVAR VAR to MULTVAR
    if(topStack(ParseObject.MULTVAR, ParseObject.VAR))
      {
       MultVar mv =  new MultVar();
       MultVar mvo = (MultVar)stk.pop();
       ParseVar v = (ParseVar)stk.pop();
       mv.add(v);
       Vector mvec = mvo.getVector();
       for (int i = 0; i< mvec.size(); i++)
          mv.add((ParseVar)mvec.elementAt(i));
       stk.push(mv);
       return true;
       }
    else
       return false;
  }

}

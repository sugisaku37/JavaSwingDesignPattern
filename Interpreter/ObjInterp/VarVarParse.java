public class VarVarParse extends InterpChain {

    public boolean interpret() {
        if (topStack(ParseObject.VAR, ParseObject.VAR)) {
            //reduce (Var Var) to Multvar
            ParseVar v = (ParseVar)stk.pop();
            ParseVar v1 = (ParseVar)stk.pop();
            MultVar mv = new MultVar(v1, v);
            stk.push(mv);
            return true;
        } else
            return false;
    }
}

import java.util.*;
//parent class for parsing all
//of the stack configurations.
//The parse method is extended in each subclass.

public abstract class InterpChain implements Chain {

    private Chain nextChain;
    Stack stk;
//------------------------------------------
    public void addChain(Chain c) {
        nextChain = c;    //next in chain of resp
    }
//------------------------------------------
    public abstract boolean interpret();
//------------------------------------------
    public Chain getChain() {
        return nextChain;
    }          
//------------------------------------------
    public void sendToChain(Stack stack) {
        stk = stack;
        if (! interpret())  //interpret stack
            //Otherwise, pass request along chain
            nextChain.sendToChain(stk);
    }
//------------------------------------------
    protected void addArgsToVerb() {
        ParseObject v = stk.pop();
        ParseVerb verb = (ParseVerb)stk.pop();
        verb.addArgs(v);
        stk.push(verb);
    }
//----------------------------------------
    protected boolean topStack(int c1, int c2) {
        return(stk.top().getType() == c1) &&
        (stk.nextTop().getType()== c2);
    }  
}

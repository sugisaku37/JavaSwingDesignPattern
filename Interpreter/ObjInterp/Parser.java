import java.util.*;

public class Parser implements Command {
    private Stack stk;
    private Vector actionList;
    private KidData kdata;
    private Data data;
    private JawtList ptable;
    private Chain chain;

    public Parser(String line) {
        stk = new Stack();
        actionList = new Vector();    //actions accumulate here

        buildStack(line);
        buildChain();  //construct interpreter chain
    }           
    //----------------------------------------
    private void buildStack(String line) {
        //parse input tokens and build stack
        StringTokenizer tok = new StringTokenizer(line);
        while (tok.hasMoreElements()) {
            ParseObject token = tokenize(tok.nextToken());
            if (token != null)
                stk.push(token);
        }   
    }
    //----------------------------------------
    private void buildChain() {
        chain = new VarVarParse(); //start of chain
        VarMultvarParse vmvp = new VarMultvarParse();
        chain.addChain (vmvp);
        MultvarVarParse mvvp = new MultvarVarParse();
        vmvp.addChain(mvvp);  
        VerbMultvarParse vrvp = new VerbMultvarParse();
        mvvp.addChain(vrvp);
        VerbVarParse vvp = new VerbVarParse();
        vrvp.addChain(vvp);
        VerbAction va =  new VerbAction(actionList);
        vvp.addChain(va);
    }
    //----------------------------------------
    public void setData(KidData k, JawtList pt) {
        data = new Data(k.getData());
        ptable = pt;
    }
    //----------------------------------------
    //executes parse and interpretation of command line
    public void execute() {

        while (stk.hasMoreElements()) {
            chain.sendToChain (stk); 
        }
        //now execute the verbs
        for (int i =0; i< actionList.size() ; i++) {
            Verb v = (Verb)actionList.elementAt(i);
            v.setData(data, ptable);
            v.execute();
        }
    }
    //--------------------------------------
    protected ParseObject tokenize(String s) {
        ParseObject obj = getVerb(s);
        if (obj == null)
            obj = getVar(s);
        return obj;
    }
    //----------------------------------------
    protected ParseVerb getVerb(String s) {
        ParseVerb v;
        v = new ParseVerb(s);
        if (v.isLegal())
            return v.getVerb(s);
        else
            return null;
    }
//----------------------------------------
    protected ParseVar getVar(String s) {
        ParseVar v;
        v = new ParseVar(s);
        if (v.isLegal())
            return v;
        else
            return null;
    }
}

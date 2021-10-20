public class VerbVarParse extends InterpChain {

    public boolean interpret() {
        //reduce Verb Var to Verb containing vars
        if (topStack(ParseObject.VAR, ParseObject.VERB)) {
            addArgsToVerb();
            return true;
        }

        else
            return false;
    }

}


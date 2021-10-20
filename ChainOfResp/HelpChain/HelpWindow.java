import java.awt.*;
import javax.swing.*;

public class HelpWindow implements Chain {
    protected Chain nextChain;
    protected String mesg;

    public HelpWindow() {
        mesg ="";
    }
//-----------------------------------------
    public void addChain(Chain c) {
        nextChain = c;
    }
    public Chain getChain() {
        return this;
    } 
    public void sendToChain(Component c) {
        sendChain(c);
    }
//-----------------------------------------
    protected void sendChain (Component c) {
        if (nextChain != null) {
            nextChain.sendToChain(c);
        }
    }
}


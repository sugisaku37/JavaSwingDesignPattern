import java.awt.*;
import javax.swing.*;

public interface Chain {
public void addChain(Chain c);
public void sendToChain(Component c);
public Chain getChain();
}

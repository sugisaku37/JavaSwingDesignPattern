
import java.awt.*;
import javax.swing.*;

public class SentMail implements Mail {
    
    private String label;

    public SentMail(String mlabel) {
        label = mlabel;
    }
    public ImageIcon getIcon () {
        return new ImageIcon("images/sentmail.gif");
    }                  
    public String getText() {
        return "";
    }
    public String getLabel() {
        return label;
    }
}

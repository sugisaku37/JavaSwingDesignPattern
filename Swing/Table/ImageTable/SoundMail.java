import java.awt.*;
import javax.swing.*;

public class SoundMail implements Mail {
    
    private String label;

    public SoundMail(String mlabel) {
        label = mlabel;
    }
    public ImageIcon getIcon () {
        return new ImageIcon("images/soundmail.gif");
    }                  
    public String getText() {
        return "";
    }
    public String getLabel() {
        return label;
    }
}

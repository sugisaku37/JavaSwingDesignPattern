import java.awt.*;
import javax.swing.*;

public class NewMail implements Mail {   
    private String label;

    public NewMail(String mlabel) {
        label = mlabel;
    }
    public ImageIcon getIcon () {
        return new ImageIcon("images/mail.gif");
    }                  
    public String getText() {
        return "";
    }
    public String getLabel() {
        return label;
    }
}

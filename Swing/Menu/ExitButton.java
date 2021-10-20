import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class ExitButton extends ActionButton {

    JFrame fr;
    public ExitButton(String caption, Icon img) {
        super(caption, img);
    }
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

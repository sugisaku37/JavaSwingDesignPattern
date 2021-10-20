import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class FileButton extends ActionButton
{

   JFrame fr;
   public FileButton(String caption, Icon img, JFrame frm)
   {
     super(caption, img);
     fr = frm;
   }
   public void actionPerformed(ActionEvent e)
   {
      FileDialog fdlg = new FileDialog(fr, "Open File", FileDialog.LOAD);
      fdlg.show();
   }
}

import java.awt.*;
import java.awt.event.*;
import java.util.*;

//swing classes
import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;

public class JBarButton extends JButton implements Command
{
   Context context;

   public JBarButton(ActionListener act, Context ctx)
   {
   super("Bar graph");
   addActionListener(act);
   context = ctx;
   }
   public void execute()
   {
      context.readData("data.txt");
      context.setBarPlot();
      context.plot();
   }
}

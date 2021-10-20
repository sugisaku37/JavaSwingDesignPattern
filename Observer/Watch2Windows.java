import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.applet.*;
import java.net.*;

public class Watch2Windows extends JxFrame
implements ActionListener, ItemListener, Subject {
    private JButton close;
    private JRadioButton red, green, blue;
    private Vector observers;
    private ColorFrame cframe;
    private ListFrame lframe;
//------------------------------------------
    public Watch2Windows() {
        super("Change 2 other frames");
        observers = new Vector();           //list of observing frames

        JPanel p = new JPanel(true);        //add panel to content pane
        p.setLayout(new BorderLayout());
        getContentPane().add("Center", p);

        Box box = new Box(BoxLayout.Y_AXIS);   //vertical box layout
        p.add("Center", box);               
        box.add(red = new JRadioButton("Red"));      //and 3 radio buttons
        box.add(green = new JRadioButton("Green"));
        box.add(blue = new JRadioButton("Blue"));

        blue.addItemListener(this);         //listen for clicks
        red.addItemListener(this);          //on radion buttons
        green.addItemListener(this);

        //make all part of same button group
        ButtonGroup bgr = new ButtonGroup();
        bgr.add(red);
        bgr.add(green);
        bgr.add(blue);

        //put a  Close button at the bottom of the frame
        JPanel p1 = new JPanel();
        p.add("South", p1);
        p1.add( close =new JButton("Close"));
        close.addActionListener(this);      //listen for clicks on it
        setBounds(200, 200, 200, 200);
        pack();
        //---------create observers---------
        cframe = new ColorFrame(this);
        lframe = new ListFrame(this);
        setVisible(true);
    }
    //-----------------------------------------  
    public void itemStateChanged(ItemEvent e) {
        //responds to radio button clicks
        //if the button is selected
        if (e.getStateChange() == ItemEvent.SELECTED)
            notifyObservers((JRadioButton)e.getSource());
    }
    //-----------------------------------------  
    private void notifyObservers(JRadioButton rad) {
        //sends text of selected button to all observers
        String color = rad.getText();
        for (int i=0; i< observers.size(); i++) {
            ((Observer)(observers.elementAt(i))).sendNotify(color);
        }
    }
    //-----------------------------------------  
    public void registerInterest(Observer obs) {
        //adds observer to list
        observers.addElement(obs);
    }
    //-----------------------------------------  
    public void actionPerformed(ActionEvent e) {
        //responds to close button
        Object obj = e.getSource();
        if (obj == close)
            System.exit(0);
    }
    //-----------------------------------------
    static public void main(String[] argv) {
        new Watch2Windows();
    }
}





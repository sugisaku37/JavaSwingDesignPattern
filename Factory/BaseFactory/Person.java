//Javatecture II  - Illustration of Factory pattern
//James W. Cooper
//This application puts up a user interface where you
//can enter a name and have the program split it into first and last names
import java.awt.*;
import java.awt.event.*;

public class Person extends Frame implements ActionListener {
   private TextField entryField; // user interface input field
   private TextField txFirstName, txLastName; // output fields
   private Button Compute, Clear;
   private Button Close; // control buttons
   NameFactory nfactory;
   Namer namer;

   public Person() {
      super("Name Divider");
      setGUI();
      nfactory = new NameFactory();
   }

   // ---------------------------------
   private void setGUI() {
      setLayout(new BorderLayout());
      setBackground(Color.lightGray);

      Panel p = new Panel();
      add("Center", p);
      p.setLayout(new GridLayout(2, 1)); // 2 areas in middle for entry and results

      // upper panel has entry field and label
      Panel p1 = new Panel();
      Panel p2 = new Panel();
      p.add(p1);
      p.add(p2);

      p1.add(new bLabel("Enter name:"));
      entryField = new TextField(30);
      p1.add(entryField);

      // lower panel has split names in two fields
      txFirstName = new TextField(25);
      txLastName = new TextField(25);
      p2.add(new bLabel("First name"));
      p2.add(txFirstName);
      p2.add(new bLabel("Last name"));
      p2.add(txLastName);

      // bottom border has 3 buttons in a Panel
      Panel pb = new Panel();
      add("South", pb);
      Compute = new Button("Compute");
      Clear = new Button("Clear");
      Close = new Button("Close");
      Compute.addActionListener(this);
      Clear.addActionListener(this);
      Close.addActionListener(this);

      pb.add(Compute); // add the buttons
      pb.add(Clear);
      pb.add(Close);
      setBounds(100, 100, 500, 300);
      setVisible(true);
      entryField.requestFocus();
   }

   // ---------------------------------
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if (obj == Clear) // clear the fields
         clearFields();
      if (obj == Close) // exit from he program
         System.exit(0);
      if (obj == Compute) // compute the name
         computeName();
   }

   // ---------------------------------
   private void computeName() {
      namer = nfactory.getNamer(entryField.getText());
      txFirstName.setText(namer.getFirst());
      txLastName.setText(namer.getLast());
   }

   // ---------------------------------
   private void clearFields() {
      // clear out all the text fields
      entryField.setText("");
      txFirstName.setText("");
      txLastName.setText("");
   }

   // ---------------------------------
   static public void main(String[] argv) {
      new Person();
   }
}

// =========================================
class bLabel extends Label {
   // this class creates blue labels
   public bLabel(String tx) {
      super(tx);
      setForeground(Color.blue);
   }
}
// =========================================

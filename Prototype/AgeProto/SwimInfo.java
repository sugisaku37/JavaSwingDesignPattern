import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class SwimInfo extends JxFrame
   implements ActionListener
{
   SwimData sdata, sxdata = null;
   JawtList swList, cloneList;
   JButton sort, ages, sex, quit;
   Swimmer sw;
   boolean female= false;

   public SwimInfo()
   {
    super("Prototype example");
    sdata = new TimeSwimData("swimmers.txt");
   
    setGUI();
    loadswList(sdata, swList);
   }
   //-----------------------------------
   public void actionPerformed(ActionEvent e)
   {
      Object obj = e.getSource();
      if(obj == sort)
         cloneAndLoad();
      if(obj == sex)
         loadSexList(sdata);
      if(obj == ages)    {
         if(sxdata == null)
            loadAgeList(sdata);
         else
            loadAgeList(sxdata);
      }

      if(obj == quit)
         System.exit(0);
   }
   //-----------------------------------
   private void cloneAndLoad()
   {
    sxdata = (SwimData)sdata.deepClone();
    //sxdata = (SwimData)sdata.clone();
    sxdata.sort();
    
    cloneList.removeAll();
    //now print out sorted values from clone
    loadswList(sxdata, cloneList);
   }
   //-----------------------------------
    private void loadSexList(SwimData sw) {
       sxdata = new SexSwimData(sw);
       female = ! female;
       sxdata.setFemale (female);

       sxdata.sort ();
       loadswList(sxdata, cloneList);
    }
    //-----------------------------------
    private void loadAgeList(SwimData sw) {
       AgeSwimData asd = new AgeSwimData(sw);
       asd.sort ();
       loadswList(asd, cloneList);
    }
   //-----------------------------------
   private void loadswList(SwimData sdata, JawtList ls)
   {
      String sw;
      ls.removeAll();
      
      for(int i=0; i< sdata.size(); i++)
      {
       sw = sdata.getName(i);
       ls.add(sw);
      }
   }
   //-----------------------------------

   private void setGUI()
   {
      setBackground(Color.lightGray);
      swList = new JawtList(15);
      cloneList = new JawtList(15);
      Box cp = new Box(BoxLayout.Y_AXIS);
      JPanel jp = new JPanel();
      getContentPane().add(jp);
      jp.setLayout(new GridLayout(1,3));
      jp.add(swList);
      JPanel pc = new JPanel();
      pc.setAlignmentX (1.0f);
      pc.add(cp);
      jp.add(pc);
      jp.add(cloneList);
      sort = new JButton("Sort");
      ages = new JButton("Ages");
      sex = new JButton("Sex");
      quit = new JButton("Quit");
                 
      
      cp.add(sort);
      cp.add(Box.createVerticalStrut(15));
      cp.add(sex);
      cp.add(Box.createVerticalStrut(15));
      cp.add(ages);
      cp.add(Box.createVerticalStrut(15));
      cp.add(quit);
      Dimension d = ages.getPreferredSize ();
      sort.setMinimumSize (d);
      sex.setMinimumSize (d);
      quit.setMinimumSize (d) ;
      
      sort.addActionListener(this);
      sex.addActionListener(this);
      ages.addActionListener (this);
      quit.addActionListener(this);
      
      setBounds( 100,100,500,400);
      setVisible(true);
   }
   //-----------------------------------
   static public void main(String argv[])
   {
      new SwimInfo();
   }
}


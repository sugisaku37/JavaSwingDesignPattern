import java.awt.*;
import java.awt.event.*;

//illustrates use of Abstract Factory pattern
public class Gardener extends Frame
implements ActionListener {
    private Checkbox vegie, annual, peren;
    private Button center, border, shade, quit;
    private Garden garden = null;
    private GardenPanel gardenPlot;
    private String borderPlant = "", centerPlant = "", shadePlant = "";

    public Gardener() {
        super("Garden planner");
        setGUI();
    }
    //----------------------------------
    private void setGUI() {
        setBackground(Color.lightGray);
        setLayout(new GridLayout(1,2));
        Panel left = new Panel();
        add(left);
        Panel right= new Panel();
        add(right);

        //create label and 3 radio buttons on left side
        left.setLayout(new GridLayout(4, 1));
        left.add(new Label("íÎâÄÇÃéÌóﬁ"));
        CheckboxGroup grp= new CheckboxGroup();
        vegie = new Checkbox("çÿâÄ", grp, false);
        annual = new Checkbox("àÍîNëêâÄ", grp, false);
        peren = new Checkbox("ëΩîNëêâÄ", grp, false);
        left.add(vegie);
        left.add(annual);
        left.add(peren);
        vegie.addItemListener(new VegieListener());
        peren.addItemListener(new PerenListener());
        annual.addItemListener(new AnnualListener());

        //now create right side
        right.setLayout(new GridLayout(2,1));
        gardenPlot = new GardenPanel();
        gardenPlot.setBackground(Color.white);
        Panel botRight = new Panel();

        right.add(gardenPlot);
        right.add(botRight);
        center = new Button("Central");
        border =  new Button("Border");
        shade = new Button("Shade");
        quit = new Button("Quit");
        botRight.add(center);
        center.addActionListener(this);
        botRight.add(border);
        border.addActionListener(this);
        botRight.add(shade);
        shade.addActionListener(this);
        botRight.add(quit);
        quit.addActionListener(this);
        setBounds(200,200, 400,300);
        setVisible(true);

    }

    //----------------------------------
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == center)
            setCenter();
        if (obj == border)
            setBorder();
        if (obj == shade)
            setShade();
        if (obj == quit)
            System.exit(0);
    }
    //----------------------------------
    private void setCenter() {
        if (garden != null) centerPlant = garden.getCenter().getName();
        gardenPlot.repaint();
    }
    private void setBorder() {
        if (garden != null) borderPlant = garden.getBorder().getName();
        gardenPlot.repaint();
    }
    private void setShade() {
        if (garden != null) shadePlant = garden.getShade().getName();
        gardenPlot.repaint();
    }
    private void clearPlants() {
        shadePlant=""; centerPlant=""; borderPlant = "";
        gardenPlot.repaint();
    }
    //----------------------------------
    static public void main(String argv[]) {
        new Gardener();
    }
//--------------------------------
    class GardenPanel extends Panel {
        public void paint (Graphics g) {
            Dimension sz=getSize();
            g.setColor(Color.lightGray);
            g.fillArc( 0, 0, 80, 80,0, 360);
            g.setColor(Color.black);
            g.drawRect(0,0, sz.width-1, sz.height-1);
            g.drawString(centerPlant, 100, 50);
            g.drawString( borderPlant, 75, 120);
            g.drawString(shadePlant, 10, 40);
        }
    }
    //-----------------------------
    class VegieListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            garden = new VegieGarden();
            clearPlants();
        }
    }
    //-----------------------------
    class PerenListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            garden = new PerennialGarden();
            clearPlants();
        }
    }
    //-----------------------------
    class AnnualListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            garden = new AnnualGarden();
            clearPlants();
        }
    }


}     //end of Gardener class


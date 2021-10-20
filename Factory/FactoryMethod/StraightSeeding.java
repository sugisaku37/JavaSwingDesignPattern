import java.util.*;

public class StraightSeeding extends Seeding {

    protected Vector swimmers;
    protected Swimmer[] asw;
    protected int numLanes;                      
    protected int[] lanes;
    protected int count;
    protected int numHeats;

    public StraightSeeding(Vector sw, int lanes) {
        swimmers = sw;
        numLanes = lanes;
        count = sw.size();
        calcLaneOrder();    
        seed();
    }
    //--------------------------------
    protected void seed() {
        //loads the asw array and sorts it
        sortUpwards();

        int lastHeat = count % numLanes;
        if (lastHeat < 3)
            lastHeat = 3;   //last heat must have 3 or more
        int lastLanes = count - lastHeat;
        numHeats = count / numLanes;
        if (lastLanes > 0)
            numHeats++;
        int heats = numHeats;


        //place heat and lane in each swimmer's object
        int j = 0;

        for (int i = 0; i < lastLanes; i++) {
            Swimmer sw = asw[i];

            sw.setLane(lanes[j++]);
            sw.setHeat(heats);
            if (j >= numLanes) {
                heats--;
                j=0;
            }
        }

        //Add in last partial heat
        if (j < numLanes)
            heats--;
        j = 0;
        for (int i = lastLanes-1; i<count; i++) {

            Swimmer sw = asw[i];
            sw.setLane(lanes[j++]);
            sw.setHeat(heats);     
        }
        //copy from array back into Vector

        swimmers = new Vector();
        for (int i=0; i< count; i++)
            swimmers.addElement(asw[i]);

    }
    //--------------------------------
    private void calcLaneOrder() {
        lanes = new int[numLanes];
        int mid = numLanes / 2;
        if (odd(numLanes))
            mid = mid + 1;       //start in middle lane
        int incr = 1;
        int ln = mid;
        for (int i=0; i< numLanes; i++) {
            lanes[i] = ln;

            ln = mid + incr;
            incr = - incr;
            if (incr > 0)
                incr=incr+1;
        }
    }
    //--------------------------------
    private boolean odd(int x) {
        return(((x / 2)*2) != x);
    }
    //--------------------------------
    protected void sortUpwards() {
        asw = new Swimmer[count];
        for (int i=0; i < count; i++)
            asw[i] = (Swimmer)swimmers.elementAt(i);
        for ( int i=0; i < count; i++) {
            for (int j = i; j < count; j++) {
                if (asw[i].getTime() > asw[j].getTime()) {
                    Swimmer swtemp = asw[i];
                    asw[i] = asw[j];
                    asw[j] = swtemp;
                }
            }
        }      
    }
    //--------------------------------
    public int getCount() {
        return swimmers.size();
    }

    public Enumeration getSwimmers() {
        return swimmers.elements();    
    }
    //----------------------------------
    public int getHeats() {
        return numHeats;
    }
}


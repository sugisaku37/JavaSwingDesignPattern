
public class TimedFinalEvent extends Event {

    public TimedFinalEvent(String filename, int lanes) {
        super(filename, lanes);
    }
    public  Seeding getSeeding() {
        return new StraightSeeding(swimmers, numLanes);
    }
    public boolean isPrelim() {
        return false;
    }
    public boolean isFinal() {
        return false;
    }
    public boolean isTimedFinal() {
        return true;
    }

}

public class PrelimEvent extends Event {


    public PrelimEvent(String filename, int lanes) {
        super(filename, lanes);
    }
    public  Seeding getSeeding() {
        return new CircleSeeding(swimmers, numLanes);
    }
    public boolean isPrelim() {
        return true;
    }
    public boolean isFinal() {
        return false;
    }
    public boolean isTimedFinal() {
        return false;
    }

}

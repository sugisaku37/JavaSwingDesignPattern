import java.io.*;
import java.util.*;

class Swimmer {
    String name;
    int age;
    String club;
    float time;
    boolean female;

    public Swimmer(String dataline) {
        StringTokenizer st = new StringTokenizer(dataline, ",");
        name = st.nextToken();
        age = new Integer(st.nextToken().trim()).intValue();
        club = st.nextToken().trim();
        time = new Float(st.nextToken().trim()).floatValue();
        String sx = st.nextToken().trim().toUpperCase();
        female = sx.equals("F");

    }
    public boolean isFemale() {
        return female;
    }
    public int getAge() {
        return age;
    }
    public float getTime() {
        return time;
    }
    public String getName() {
        return name;
    }
    public String getClub() {
        return club;
    }
}

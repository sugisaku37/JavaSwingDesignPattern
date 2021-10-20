
public class LastFirst extends Namer {
// extracts last name from first name 
// when separated by a comma
    public LastFirst(String s) {
        int i = s.indexOf(","); //find comma
        if (i > 0) {
            last = s.substring(0, i).trim();
            first = s.substring(i + 1).trim();
        } else {
            last = s;       //if no comma, 
            first = "";     //put all in last name
        }
    }
}


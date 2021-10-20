
public class FirstFirst
extends Namer {
    //extracts first name from last name 
    //when separated by a space
    public FirstFirst(String s) {
        int i = s.lastIndexOf(" "); //find sep space
        if (i>0) {
            first = s.substring(0, i).trim();
            last =s.substring(i+1).trim();
        } else {
            first = ""; // if no space
            last = s;   // put all in last name
        }
    }
}




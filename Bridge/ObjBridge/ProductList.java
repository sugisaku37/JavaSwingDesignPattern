import java.util.*;

public class ProductList extends JawtList
implements VisList {
    public ProductList() {
        super(10);     //sets up JawtList  
    }
    //-------------------------------------
    private void splitAdd(String s) {

        //take each string apart and keep only
        //the product names, discarding the quntities

        int index = s.indexOf("--");  //separate qty from name

        if (index > 0)
            super.add(s.substring(0, index));
        else
            super.add(s);
    }
    //-------------------------------------
    public void addLine(String s) {

        splitAdd(s);
        super.validate();
    }
    //-------------------------------------
    public void removeLine(int index) {
        String s = super.getElementAt(index);
        super.remove(s);
    }
}

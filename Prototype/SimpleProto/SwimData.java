import java.util.*;
import java.io.*;

//abstract class defining interface and deep clone routine
public abstract class SwimData implements Cloneable {
    public abstract int size();
    public abstract Swimmer getSwimmer(int i);
    public abstract String getName(int i);
    public abstract void sort();
    public Object cloneMe() throws CloneNotSupportedException {
      return  super.clone();
    }
}

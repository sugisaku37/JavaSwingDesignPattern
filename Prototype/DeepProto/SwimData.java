import java.util.*;
import java.io.*;

//abstract class defining interface and deep clone routine
public abstract class SwimData 
  implements Cloneable, Serializable {
    public abstract int size();
    public abstract Swimmer getSwimmer(int i);
    public abstract String getName(int i);
    public abstract void sort();
    public Object cloneMe() throws CloneNotSupportedException {
      return  super.clone();
    }
//-------------------------------------------
    public SwimData deepClone() {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();

            ObjectOutputStream out = new ObjectOutputStream(b);

            out.writeObject(this);
            ByteArrayInputStream bIn = new ByteArrayInputStream(b.toByteArray());

            ObjectInputStream oi = new ObjectInputStream(bIn);

            return((SwimData)oi.readObject());
        } catch (Exception e) {
            System.out.println("exception:"+e.getMessage());
            e.printStackTrace();
            return null;
        }

    }
}

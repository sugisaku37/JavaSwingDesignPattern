import java.util.*;

public class UndoCommand implements Command {
   Vector undoList;
   
   public UndoCommand(){
      undoList = new Vector();      //list of commands to undo
   }                 
   //-----------------------------
   public void add(Command cmd) {
      if(! (cmd instanceof UndoCommand))
         undoList.add(cmd);         //add commands into list
   }
   //-----------------------------
   public void execute() {
      int index = undoList.size () -1;
       
      if (index >=  0) {
         //get last command executed
         Command cmd =  (Command)undoList.elementAt (index);
         cmd.unDo ();               //undo it
         undoList.remove (index);   //and remove from list
      } 
   }
   //-----------------------------
   public void unDo() {    //does nothing
   }
}

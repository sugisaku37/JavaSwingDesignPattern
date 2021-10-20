import java.awt.*;

public class StateManager
{
 private State currentState;
 
 ArrowState aState;
 
 public StateManager(Mediator med)
 {
  aState = new ArrowState(med);
  currentState = aState;
 }
 public void setState(State state) {
    currentState = state;
 }
 public void mouseDown(int x, int y)
 {
    currentState.mouseDown(x, y);
 }
 public void mouseUp(int x, int y)
 {
    currentState.mouseUp(x, y);
 }
 public void mouseDrag(int x, int y)
 {
    currentState.mouseDrag(x, y);
 }
 public void select(Drawing d, Color c)
 {
    currentState.select(d, c);
 }
}

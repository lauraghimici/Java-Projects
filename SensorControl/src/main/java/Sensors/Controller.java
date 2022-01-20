package Sensors;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura
 */

 
class Observable {
  
   private List<Observer> observers = new ArrayList<Observer>();
 
   public void changeState(Object event) {
     
      notifyAllObservers(event);
   }
 
   public void register(Observer observer) {
      observers.add(observer);		
   }
 
   private void notifyAllObservers(Object event) {
      for (Observer observer : observers) {
         observer.update(event);
      }
   } 	
}
 
interface Observer {
   public abstract void update(Object event);
}

public class Controller extends Observable {
    
 
}

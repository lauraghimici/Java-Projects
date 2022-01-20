package Sensors;

import java.util.Random;

/**
 *
 * @author Laura
 */

public class Sensor implements Observer {
    
    private TYPE type ;
    private int value;
    private int lastValue=0;
    Controller controller = new Controller();
    
    public Sensor (TYPE type, Controller controller){
    this.type=type;
    this.controller=controller;
 
    }
    
    @Override
    public void update(Object event) {
      
        
        System.out.println("The "+type+" sensor is updated.");  
    }
     
    public void readValue(){
        
    Random rand = new Random();
    this.value=  rand.nextInt(50);
      if(lastValue!=value)
      {    
              System.out.println("The "+ type +" has changed. The new value is "+value+ ". ");
                controller.changeState("Changed!");
      }
      lastValue=value;
   
    
   
    }

    
}

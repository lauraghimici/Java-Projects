package ATC;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura
 */
public class ATC {

    private List<Aircraft> airCrafts;
    
    public ATC(){
     airCrafts= new ArrayList<>();
    
    }
    
    public void addAircraft(String id) {
        
        airCrafts.add(new Aircraft(id));
    }

    public void sendCommand(String airCraftId, AtcCommand cmd) {
         
        for(Aircraft airCr: airCrafts)
            if(airCr.getID().equals(airCraftId))
            {
               airCr.receiveAtcCommand(cmd);
            
            
            }
            
    }

    public void showAirCrafts() {
           for(Aircraft airCr: airCrafts)
              System.out.println(airCr.getID());


    }
    public List<Aircraft> getAircrafts(){
    
        return airCrafts;
    
    }
}


package ATC;

/**
 *
 * @author Laura
 */
public class TakeOffCommand extends AtcCommand {
  
    private int altitude;
    
    TakeOffCommand(int altitude){
    this.altitude=altitude;
    }
    
    @Override
    public int getAltitude(){
    
        return altitude;
    }
}

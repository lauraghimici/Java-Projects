package Parking;

import java.io.Serializable;

/**
 *  
 * @author Laura
 */
public class Car implements Serializable {
private static final long serialVersionUID = 123458;
    String plateNumber;
    int numberOfEntries=0;

    public Car(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    
    public String getPlateNumber(){
    return plateNumber;
    
    }

}

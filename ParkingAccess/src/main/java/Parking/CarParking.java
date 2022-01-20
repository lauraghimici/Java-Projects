package Parking;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**        
 *
 * @author Laura
 */
public class CarParking implements Serializable {
    
    private static final long serialVersionUID = 123456;
    private final List<ParkingSpot> parkingSpots;

    public CarParking(int numberOfParkingSpots) {

        parkingSpots = new ArrayList<>();

        for (int i = 0; i < numberOfParkingSpots; i++) {
            parkingSpots.add(new ParkingSpot());
        }

    }

    public boolean parkingSpotAvailability(Car car) {
        for (ParkingSpot pSpot : parkingSpots) {
            if (pSpot.isEmpty() == true) {
                pSpot.putCarInParkingSpot(car);
                return true;
            }
        }
        return false;

    }
    
    public void removeCarFromParking(Car car){
       for (ParkingSpot pSpot : parkingSpots) {
            if (pSpot.getCar().equals(car)) {
            pSpot.freeSpot();
                
            }
       
       }
     }
    
    public int usageCost(Car car) {

        for (ParkingSpot pSpot : parkingSpots) {
            if (pSpot.getCar().equals(car) && car!=null) {
              
                return LocalTime.now().plusMinutes(2).toSecondOfDay() - pSpot.getEntryTime().toLocalTime().toSecondOfDay();
            }

        }

        return 0;
    }
    
  public void displayCurrentParkedCars(){
      
    int countNumberOfTakenSpots = 0 ;
    
      for (ParkingSpot pSpot : parkingSpots)
          if(pSpot!=null)
          {
           LocalDateTime entryTime=pSpot.getEntryTime();  
           DateTimeFormatter myFormaentryTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
           
           System.out.println("The car "+pSpot.getCar().getPlateNumber()+ " entered at " +entryTime.format(myFormaentryTime)+ " for "+ usageCost(pSpot.getCar())+ " s with a total cost of "+ usageCost(pSpot.getCar())+" RON. ");
           
           countNumberOfTakenSpots++;
          
          }
      int numberOfAvailableSpots=parkingSpots.size()-countNumberOfTakenSpots;
      
      System.out.println("The number of available spots at the moment is: "+numberOfAvailableSpots );
              
  }
  
  public LocalDateTime getEntryTime(Car car){
  for (ParkingSpot pSpot : parkingSpots)
       if (pSpot.getCar().equals(car))
           return pSpot.getEntryTime();
  
  return null;
  }

}


class ParkingSpot implements Serializable {
private static final long serialVersionUID = 123459;
    private Car car;
    private LocalDateTime entryTime;
    private boolean empty = true;
    
    public void putCarInParkingSpot(Car car) {

        this.car = car;
        entryTime = LocalDateTime.now();
        empty = false;

    }
    public void freeSpot(){
        empty=true;
    }

    public boolean isEmpty() {

        return empty;

    }

    public Car getCar() {

        return this.car;

    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

}

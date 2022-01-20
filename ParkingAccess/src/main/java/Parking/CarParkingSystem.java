package Parking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**  
 *
 * @author Laura
 */
public class CarParkingSystem implements Serializable {

    private static final long serialVersionUID = 123457;
    private CarParking carParking;
    private List<CarParkingLog> carParkingLogs;
    private List<Car> uniqueCars = new ArrayList<>();
    
    CarParkingSystem(int numberOfParkingSpots) {
        this.carParking = new CarParking(numberOfParkingSpots);        
        carParkingLogs = readLogFromFile();
        if (carParkingLogs == null) {
            this.carParkingLogs = new ArrayList<>();
        }
    }
    public CarParking getCarParking(){
    return carParking;
    
    }
    
    public void enterCarPark(Car car) {
        
        if (carParking.parkingSpotAvailability(car) == true) {
            car.numberOfEntries++;
            System.out.println("Car entered the parking successfully!");
            carParkingLogs.add(new CarParkingLog(car, LocalDateTime.now()));
            saveLogToFile();
            for (Car uniqueCar : uniqueCars) {
                if (car.equals(uniqueCar)) {
                    uniqueCars.remove(uniqueCar);
                }
            }
            
        } else {
            System.out.println("No available parking spots at the moment.");
        }
        
    }
    
    public void exitCarPark(Car car) {
        
        if (carParking.usageCost(car) != 0) {
            carParking.removeCarFromParking(car);
            System.out.println("Total cost is " + carParking.usageCost(car) + " RON. Goodbye!");
            if (carParking.getEntryTime(car) != null) {
                for (CarParkingLog log : carParkingLogs) {
                    if (log.entryTime.equals(carParking.getEntryTime(car))) {
                        log.setLeavetime(LocalDateTime.now().plusSeconds(20));
                    }
                }
            }
            saveLogToFile();
            
        } else {
            
            System.out.println("The car is not parked here.");
        }
        
    }
    
    public void displayAllEntriesForCar(Car car) {
        int totalCost = 0;
        
        for (CarParkingLog log : carParkingLogs) {
            if (log.car.equals(car)) {
                LocalDateTime entryTime = log.entryTime;                
                DateTimeFormatter myFormaentryTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");    
                System.out.println("The car " + log.car.getPlateNumber() + " entered at " + log.entryTime.format(myFormaentryTime) + " for " + carParking.usageCost(log.car) + " s with a total cost of " + carParking.usageCost(log.car) + " RON. ");
                totalCost = totalCost +  carParking.usageCost(log.car);
                
            }
        }
        
        System.out.println("The total cost is: " + totalCost + " RON.");
        
    }
    
    public void displayUniqueEntries(Car car) {
        System.out.println("Unique Past Entries: ");
        for (Car uniqueCar : uniqueCars) {
            System.out.println("The car with the plate number " + car.getPlateNumber() + " entered the parkng for " + car.numberOfEntries + " times.");
        }        
        
    }
    
    private void saveLogToFile() {
        try {            
            try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\src\\ParkingLog.txt"))) {
                out.writeObject(carParkingLogs);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarParkingSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarParkingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    private List<CarParkingLog> readLogFromFile() {
        List<CarParkingLog> Logs = null;
        try {
            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\src\\ParkingLog.txt"));
            Logs = (List<CarParkingLog>) in.readObject();
            
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(CarParkingSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {            
            Logger.getLogger(CarParkingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Logs;
    }

    class CarParkingLog implements Serializable {

        private static final long serialVersionUID = 123459;
        private Car car;
        private LocalDateTime entryTime;
        private LocalDateTime leaveTime;
        
        public CarParkingLog(Car car, LocalDateTime entryTime) {
            this.car = car;
            this.entryTime = entryTime;
            
        }

        public void setLeavetime(LocalDateTime leaveTime) {
            
            this.leaveTime = leaveTime;
            
        }
        
    }
    
}

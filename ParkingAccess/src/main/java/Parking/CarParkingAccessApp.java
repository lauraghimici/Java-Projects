package Parking;

public class CarParkingAccessApp {

    public static void main(String[] args) {

        CarParkingSystem system = new CarParkingSystem(2);

        Car c1 = new Car("CJ 58 HGD");
        Car c2 = new Car("BN 10 KJF");
        Car c3 = new Car("AB 35 HFS");
        system.enterCarPark(c1);
        system.enterCarPark(c2);
        system.enterCarPark(c3);
       // system.displayAllEntriesForCar(c1);
        system.exitCarPark(c1);
        system.getCarParking().displayCurrentParkedCars();
        // System.out.println(system.carParking.parkingSpotAvailability(c3));
 
 
                     
    }
}

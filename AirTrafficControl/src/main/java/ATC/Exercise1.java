package ATC;

import java.util.List;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        
        
        ATC atc = new ATC();
        atc.addAircraft("100");
         
    List<Aircraft> aircrafts=atc.getAircrafts();
       aircrafts.get(0).start();
        
        Scanner scanner= new Scanner(System.in);  
          Scanner scanner2= new Scanner(System.in);
        String command1 = scanner.nextLine();
        int altitude = scanner2.nextInt();
      
        if(command1.equals("takeoff"))
        {   AtcCommand takeoff = new TakeOffCommand(altitude);
             aircrafts.get(0).receiveAtcCommand(takeoff);
             synchronized ( aircrafts.get(0)) {
            aircrafts.get(0).notify();
             }
        }
        
        else {System.out.println("The plane needs a takeoff command first!");}
        
        String command2 =scanner.nextLine();
        
        if(command2.equals("land"))
        {   AtcCommand land = new LandCommand();
             aircrafts.get(0).receiveAtcCommand(land);
              synchronized ( aircrafts.get(0)) {
            aircrafts.get(0).notify();
             }
            
        }
        else {System.out.println("The plane needs a landing command!");}
        
        
     
        
        
    }
}

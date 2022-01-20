package Sensors;

/**
 *
 * @author Laura
 */
public class Exercise2 {
     public static void main(String[] args) throws InterruptedException{
      
      Controller controller = new Controller();
      Sensor temperature = new Sensor(TYPE.TEMPERATURE,controller);   
      Sensor humidity = new Sensor(TYPE.HUMIDITY,controller);
      Sensor pressure = new Sensor(TYPE.PRESSURE,controller);
      controller.register(temperature);
      controller.register(humidity);
      controller.register(pressure);
      temperature.readValue();
      humidity.readValue();
      
      
      
     
     }
}

package ATC;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laura
 */
public class Aircraft extends Thread {

    private String id;
    private int altitude;
    private AtcCommand command;

    public Aircraft(String id) {
        this.id = id;
    }

    public String getID() {
        return id;

    }

    public void receiveAtcCommand(AtcCommand msg) {
        command = msg;
        if (msg instanceof TakeOffCommand) {
            altitude = msg.getAltitude();
        }
    }

    public void run() {

        synchronized (this) {
            try {
                System.out.println("The aircraft " + id + " is getting ready...");
                System.out.println("On Stand");

                synchronized (this) {
                    this.wait();
                }
                System.out.println("Taxing");

                Thread.sleep(10 * 1000);

                System.out.println("Taking Off");

                Thread.sleep(5 * 1000);

                System.out.println("Ascending");

                Thread.sleep(altitude * 10 * 1000);

                System.out.println("Cruising");

                Instant starts = Instant.now();

                synchronized (this) {
                    wait();

                }
                Instant ends = Instant.now();

                System.out.println("Descending");

                Thread.sleep(altitude * 10 * 1000);

                System.out.println("Landed");
                System.out.println("The time spent in Cruising is " + Duration.between(starts, ends).toSeconds() + " s.");
            } catch (InterruptedException ex) {
                Logger.getLogger(Aircraft.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

package util;

/**
 * Created by Chloe on 11/19/2017.
 */
import main.BigWhite;

import java.util.TimerTask;
import java.util.Date;

//public enum RESORT = {BIG WHITE, SILVERSTAR, SOLITUDE, WALNUTBEACH}
public class ScheduledTask extends TimerTask {

    Date now; // to display current time

    // Add your task here
    public void run() {
        now = new Date(); // initialize date
        System.out.println("Time is :" + now); // Display current time
        //RESORT.main();
        try {
            BigWhite.main();
            System.out.println("\n\nOne cycle complete\n\n");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

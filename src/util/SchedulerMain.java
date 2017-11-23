package util;

/**
 * Created by Chloe on 11/19/2017.
 */

import java.util.Timer;

public class SchedulerMain {
    public static void main(String args[]) throws InterruptedException {

        Timer time = new Timer(); // Instantiate Timer Object
        ScheduledTask st = new ScheduledTask(); // Instantiate ScheduledTask class
        time.schedule(st, 0, 30*60*1000); // schedule the task for every 1 hour, with no delay

        //for demo only.
//        for (int i = 0; i <= 5; i++) {
//            System.out.println("Execution in Main Thread...." + i);
//            Thread.sleep(2000);
//            if (i == 5) {
//                System.out.println("Application Terminates");
//                System.exit(0);
//            }
//        }
    }
}
package desktopscreenrecorder;


// this class implements a recording timer
public class RecordTimer {

    // the starting time 
    private static long startTime;
    // the stopping time
    private static long stopTime;

    // method to reset the time values
    public static void reset() {
        startTime = 0;
        stopTime = 0;
    }

    // method to start the timer
    public static void start() {
        startTime = System.currentTimeMillis();
    }

    // method to stop the timer
    public static void stop() {
        stopTime = System.currentTimeMillis();
    }

    // method to get the timer duration in miliseconds
    public static long getTimeInMilliSec() {
        return stopTime - startTime;
    }
    
     public static long getTimeInSec() {
        return (stopTime - startTime)/1000;
    }
     
      public static long getTimeInMin() {
        return (stopTime - startTime)/(60*1000);
    }
}

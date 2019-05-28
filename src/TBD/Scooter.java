package TBD;

import java.lang.reflect.Method;
import java.util.Timer;

public class Scooter {
	long startTime;
    public long startTimer() {
    	startTime =  System.currentTimeMillis();
		return startTime;    	
    }
    
    public long endTimer() {
    	long endTime =  System.currentTimeMillis();
    	long usedTime = (long) ((endTime-startTime)/1000.0);
    	System.out.println(usedTime);
		return usedTime;
    }
}

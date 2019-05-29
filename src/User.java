import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class User implements Serializable{
	private int qmId;
	private String name;
	private String emailAddr;
	private boolean banned = false;
	private int fine = 0;

	public  long[]  weekTime = new long[7];
	public long veryFirstTime;
	public long startTime;
    public  long onceTime;


	//今天使用的时间 加一下时间 一周时间

	public void firstTimer() {
    	this.veryFirstTime =  System.currentTimeMillis();  	
    }

	public long startTimer() {
    	this.startTime =  System.currentTimeMillis();
		return startTime;    	
    }
    
    public long endTimer() {
    	long endTime =  System.currentTimeMillis();
    	long usedTime = (long) ((endTime-startTime)/1000.0);
    	System.out.println("This is current usedTime."+usedTime);
		return usedTime;
    }

    public void totalTime(){
    	Date today = new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(today);
        int weekday=c.get(Calendar.DAY_OF_WEEK);

        long endTime =  System.currentTimeMillis();
    	long usedTime = (long) ((endTime-startTime)/1000.0);
    	System.out.println("This is current usedTime."+usedTime);

        long verytotalTime = (long) ((System.currentTimeMillis() - veryFirstTime)/1000.0);
        if(verytotalTime >= 604800){
        	weekTime[0] = 0;
        	weekTime[1] = 0;
        	weekTime[2] = 0;
        	weekTime[3] = 0;
        	weekTime[4] = 0;
        	weekTime[5] = 0;
        	weekTime[6] = 0;

        	weekTime[weekday-1] = usedTime;
            this.onceTime = usedTime;

            if(usedTime > 1800){
            	this.banned =true;
            }

        }else{

        	weekTime[weekday] = weekTime[weekday]+usedTime;
        	this.onceTime = usedTime;

        	if(usedTime > 1800){
            	this.banned =true;
            }

            if(weekTime[weekday]> 7200){
            	this.banned =true;
            }

        }
        
    }


	
	public long getOncetime(){
		return onceTime;
	}



	public User(int qmId, String name, String emailAddr) {
		this.qmId = qmId;
		this.name = name;
		this.emailAddr = emailAddr;
	}
	
	public int getQmId() {
		return qmId;
	}
	public void setQmId(int qmId) {
		this.qmId = qmId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public boolean isBanned() {
		return banned;
	}
	public void setBanned(boolean banned) {
		this.banned = banned;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public void payFine() {
		this.fine = 0;
		this.banned = false;
	}
	
	
	
	
	
	
	
	
	


}

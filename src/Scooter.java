
public class Scooter {
	private int scooterId;
	private boolean parked = false;
	private boolean broken = false;
	private Dock parkedDock;
	
	long startTime;
	
	
	public Scooter(int ID) {//1 to 15
		this.scooterId = ID;
	}
	
	
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
	

	
	
	public int getScooterId() {
		return scooterId;
	}

	public void setScooterId(int scooterId) {
		this.scooterId = scooterId;
	}


	public boolean isBroken() {
		return broken;
	}


	public void setBroken(boolean broken) {
		this.broken = broken;
	}


	public boolean isParked() {
		return parked;
	}


	public void setParked(boolean parked) {
		this.parked = parked;
	}
	
	public void parkScooter(Dock dock) {
		parkedDock = dock;
	}
	
	public Dock parkedAt() {
		return parkedDock;
	}
	
}

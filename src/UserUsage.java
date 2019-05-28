

public class UserUsage {
	private User user;
	private Scooter scooter;
	
	public UserUsage(User user) {
		this.user = user;
	}
	
	
	public void pickUpScooter(Dock dock) {
		if(user.isBanned() == false) {
			
			int i = 0;	//the initial NO.
			for(boolean b : dock.getLockState()) {
				if(b==true)
					break;
				i++;
			}
			Thread blink = new blinkBulb();
			blink.run();
			if(!((blinkBulb) blink).isDone()) {
				new TimeoutFrame();
			}
			else {
				Scooter s = new Scooter('B');
//				Scooter s = dock.getParkedScooter(i);
				scooter = s;
				scooter.startTimer();
				scooter.setParked(false);
				scooter.startTimer();
				dock.setLockState(false, i);
				new successfullyPicked(scooter);
			}
		}
		else {
			new BannedFrame();	
		}
	}
	public void returnScooter(Dock dock) {
		scooter.endTimer();
		scooter.setParked(true);
		scooter.parkScooter(dock);
		for(int i = 0; i<8; i++) {
			if(!dock.getThisLockState(i))
				dock.setParkedScooter(scooter, i);
		}
	}
	
	public void repairScooter() {
		scooter.setBroken(true);
	}
	
	public void payFine() {
		user.setFine(0);
	}
}

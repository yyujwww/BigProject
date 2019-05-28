
public class AdminUsage {
	
	
	public void initDock(Dock dock) {	//make all slot open 可以放在主类里面
		for(int i = 0; i<=7; i++) {
			dock.setLockState(false, i);
			dock.setParkedScooter(null, i);
		}
	}
	
//	public void initScooter() {	//可以放在主类里面，毕竟车应该不会动
//		char id = 'A';
//		for (int i = 0; i<15 ; i++) {
//			
//			//
//			id++;
//		}
//	}
	public void addMember() {//tbc
		
	}
	
	public void removeScooter(Scooter scooter) {
		if(scooter.isParked() == false)
			System.out.println("The scooter is not parked.");
		else if(scooter.isBroken() == false)
			System.out.println("The scooter is not broken, and it dose not require repairs.");
		else {
			scooter.setParked(false);
			repairScooter(scooter);
		}
		
	}
	public static void repairScooter(Scooter scooter) {
		//Repairing
		scooter.setBroken(false);
	}
	
	public Dock findScooter(Scooter scooter) {
		if(scooter.isParked() == false) {
			System.out.println("Scooter" + scooter.getScooterId() + "is on the way.");
			return null;
		}

		System.out.println("Scooter" + scooter.getScooterId() + "is in dock " + scooter.parkedAt()+".");
		return scooter.parkedAt();
		
	}
	
	
	/**
	 * 
	 * @param dock	dock parked at
	 * @param scooter	scooter to be parked
	 */
	public void placeScooter(Dock dock, Scooter scooter) { //admin park scooter
		int i = 1;
		while(dock.getThisLockState(i)) {
			i++;
		}
		dock.changeLockState(i);
		scooter.parkScooter(dock);
		scooter.setParked(true);
		System.out.println("The scooter " +scooter.getScooterId()+ " is successfully placed at solt " + i + ".");
	}
}

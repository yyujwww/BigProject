
public class SystemUsage {
	private Dock dockA;
	private Dock dockB;
	private Dock dockC;
	private Scooter[] scooter = new Scooter[15];
	
	public void initDocks() {
		this.dockA = new Dock('A',"Library");
		this.dockB = new Dock('B',"Information Teaching Laboratories");
		this.dockC = new Dock('C',"Village Shop");	
	}
	
	public void initScooter() {
		for(int i = 0 ; i<15 ; i++) {
			scooter[i] = new Scooter(i+1);
		}
	}
	
	public void firstParkScooter() {
		Dock[] docks = new Dock[]{dockA,dockB,dockC};
		for(int j=0;j<3;j++) {
			for(int i = 0; i<5 ; i++) {
				docks[j].changeLockState(i);
				scooter[i+j*5].parkScooter(docks[j]);
				scooter[i+j*5].setParked(true);
				docks[j].setParkedScooter(scooter[i+j*5], i);
			}
		}
//		for(int i = 0; i<5 ; i++) {
//			dockB.changeLockState(i);
//			scooter[i+5].parkScooter(dockB);
//			scooter[i+5].setParked(true);
//			dockB.setParkedScooter(scooter[i+5], i);
//		}
//		for(int i = 0; i<5 ; i++) {
//			dockC.changeLockState(i);
//			scooter[i+10].parkScooter(dockC);
//			scooter[i+10].setParked(true);
//			dockC.setParkedScooter(scooter[i+10], i);
//		}
		
	}

	public Dock getDockA() {
		return dockA;
	}

	public Dock getDockB() {
		return dockB;
	}

	public Dock getDockC() {
		return dockC;
	}


}

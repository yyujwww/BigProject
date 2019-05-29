
public class SystemUsage {
	private static Dock dockA;
	private static Dock dockB;
	private static Dock dockC;
	private static Scooter[] scooter = new Scooter[15];
	
	public SystemUsage() {
		dockA = new Dock('A',"Library");
		dockB = new Dock('B',"Information Teaching Laboratories");
		dockC = new Dock('C',"Village Shop");
		
		for(int i = 0 ; i<15 ; i++) {
			scooter[i] = new Scooter(i+1);
		}
		
		Dock[] docks = new Dock[]{dockA,dockB,dockC};
		for(int j=0;j<3;j++) {
			for(int i = 0; i<5 ; i++) {
				docks[j].changeLockState(i);
				scooter[i+j*5].parkScooter(docks[j]);
				scooter[i+j*5].setParked(true);
				docks[j].setParkedScooter(scooter[i+j*5], i);
			}
		}
	}
	
	
	public Scooter[] getScooters() {
		return scooter;
	}
	public static Dock[] getDocks() {
		Dock[] docks = new Dock[]{dockA,dockB,dockC};
		return docks;
	}
	public static Dock getDockA() {
		
		return dockA;
	}

	public static Dock getDockB() {
		return dockB;
	}

	public static Dock getDockC() {
		return dockC;
	}


}

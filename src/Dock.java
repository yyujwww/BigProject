
public class Dock {
	private char symbol;		//A B C
	private String dockName;
	private boolean[] lockState = new boolean[8];/* = {true,true,true,true,true,false,false,false}*/;	//InitLockState true=>hasAScooter
	private Scooter[] parkedScooter = new Scooter[8];
	
	
	public Dock(char symbol, String name){
		this.dockName = name;
		this.symbol = symbol;
	}
	
	
	public String getName() {
		return this.dockName;
	}
	
	public void setName(String name) {
		this.dockName = name;
	}
	
//	public void initDock(){
//		for(boolean state: lockState) {
//			state = false;
//		}
//	}
	public void setLockState(boolean setState, int i) {
		lockState[i] = setState;
	}
	
	public void changeLockState(int i) {		//pick up or bring back 
		boolean tempState = lockState[i];
		lockState[i] = !tempState;
	}
	
	public boolean[] getLockState() {
		return lockState;
	}

	public boolean getThisLockState(int i) {
		boolean currentLockState = lockState[i];
		return currentLockState;
	}

	
	public Scooter getParkedScooter(int i) {
		return parkedScooter[i];
	}

	public void setParkedScooter(Scooter scooter, int i) {
		parkedScooter[i] = scooter;
	}

	
	
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	

	
	
//	public int getParkedScooter(char scooter) {
//		for()
//		return parkedScooter[i+1];
//	}
	
	
}

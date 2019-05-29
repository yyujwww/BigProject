
public class Run {
	public	Run() {
		
	}
	
	public static void main(String[] args) {
		User u = new User(123456789,"yjw","123@123.com");
		new DataIO();
		DataIO.addUser(u);
		new SystemUsage();
		new HelloFrame().showFrame();;
	}
	

}

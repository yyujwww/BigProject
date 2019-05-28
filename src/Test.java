
public class Test {
	public static void main (String[] arg) {
		Dock dock = new Dock('A',"aaa");
		User user1 = new User(1,"a","b");
		UserUsage user1Usage = new UserUsage(user1);
		user1.setBanned(true);
		user1Usage.pickUpScooter(dock);
	}

}

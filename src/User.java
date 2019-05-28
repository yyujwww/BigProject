
public class User {
	private int qmId;
	private String name;
	private String emailAddr;
	private boolean banned = false;
	private int fine = 0;
	
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

import java.io.Serializable;

public class Admin implements Serializable {
	
	private String adminName = "Admin";
	private int id;
	private int[] PIN = {0,0,0,0,0,0};	//default pin
	
	public Admin(String name) {
		this.setAdminName(name);
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public int[] getPIN() {
		return PIN;
	}

	public void setPIN(int[] pIN) {
		PIN = pIN;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}

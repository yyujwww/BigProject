import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;



public class DataIO {
	
	
	private static ArrayList<Admin> adminList =new ArrayList();
	private static ArrayList<User> userList =new ArrayList();
	
    public DataIO(){						//read when started(new)
    	readObject();
    }

    public static void addUser(User user) {	//add user to list
    	userList.add(user);
    	saveObject();
    }
    
    public static void addAdmin(Admin admin) {	//add user to list
    	adminList.add(admin);
    	saveObject();
    }

    public static ArrayList<User> getAccList(){	//get user list not used
    	return userList;
    }
    
    public static int findAdmin(String s) {	//find a user by its QMId
		for (int i = 0; i < adminList.size(); i++) {
			if ((((Admin) adminList.get(i)).getId()+"").equals(s)) {
				return i;
			}
		}
		return -1;	// does not have this user
	}
	
	public static Admin getAdminByIndex(int n) {	//get user by the index number
		if(n>=adminList.size())
			return null;
		else{
			Admin admin = (Admin) adminList.get(n);
			return admin;
		}
		
	}
    
	public static int findUser(String s) {	//find a user by its QMId
		for (int i = 0; i < userList.size(); i++) {
			if ((((User) userList.get(i)).getQmId()+"").equals(s)) {
				return i;
			}
		}
		return -1;	// does not have this user
	}
	
	public static User getUserByIndex(int n) {	//get user by the index number
		if(n>=userList.size())
			return null;
		else{
			User user = (User) userList.get(n);
			return user;
		}
		
	}

	
	
    /**
     * Save file
     */
    public static void saveObject(){	//save all the 3 lists to the 3 files respectively
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("./userList.txt"));
            os.writeObject(userList);
            os.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("./adminList.txt"));
            os.writeObject(adminList);
            os.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }  
       
    }
    
    /**
     * read file
     */
    public static void readObject() {	//read and save to the 3 lists
        try {
            ObjectInputStream is = new ObjectInputStream(
            		new FileInputStream("./userList.txt"));
			ArrayList list = (ArrayList) is.readObject();
            for (Iterator itr = list.iterator(); itr.hasNext();) {
            	userList.add((User) itr.next());
            }
            is.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream is = new ObjectInputStream(
            		new FileInputStream("./adminList.txt"));
            @SuppressWarnings("unchecked")
			ArrayList list = (ArrayList) is.readObject();
            for (Iterator itr = list.iterator(); itr.hasNext();) {
                adminList.add((Admin) itr.next());
            }
            is.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
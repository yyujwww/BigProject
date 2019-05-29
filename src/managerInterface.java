import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class managerInterface {
	private int i = 0;
	private static String inputID;
	JFrame frame1;	//The initial frame for the manager.
	JFrame frame2;	//The frame to register the information of the users.
	JFrame emailFault;//The frame to remind the manager when he types a fault email address only.
	JFrame IDFault;//The frame to remind the manager when he types a fault ID only.
	JFrame fileExist;//The frame to remind the manager when the user had already registered.
	JFrame registerSucc;//Successfully registered frame.
	JFrame changeFineCond;
	JPanel p1;//Panel of the frame1.
	JPanel viewOfData;
	JButton P1;//Button of introduction.
	JButton P2;//Button of data view.
	JButton P3;//Button of register new users.
	JButton change;//Button of changing the information of the users.
	//JFrame registerFrame;//
	JButton search;
	JLabel newUser = new JLabel("new User:");
	JLabel fullName = new JLabel("Full Name:");
	JLabel QMID = new JLabel("QM ID:");
	JLabel QMEmail = new JLabel("QM e-mail: ");
	public JLabel input = new JLabel("Type the user ID you want to check or change:");
	JButton finish;//Press to finish the register.
	JButton back;//Press to back to the home page.
	JButton back2;
	public JTextField userFullName;
	public JTextField userQMEmail;
	public JTextField userQMID;
	public JTextField dataView;
	JPanel p2;//Panel of the frame2.
	GridLayout gridLayout2 = new GridLayout(4,2,10,10);
	//public ImageIcon pt3 = new ImageIcon("P3.jpg");
	//public ImageIcon pt2 = new ImageIcon("P2.jpg");
	//public ImageIcon pt1 = new ImageIcon("P1.jpg");
	static String fileName;
	User User = new User(0, null, null);

	public managerInterface() {
		frame1 = new JFrame();
		IDFault = new JFrame();
		p1 = new JPanel();
		p1.setLayout(null);
		P1 = new JButton("Scooter system");
		P1.setBounds(20,20,170,100);
		P2 = new JButton("Check message");
		P2.setBounds(50,200,300,400);
		P3 = new JButton("New account");
		P3.setBounds(450,200,300,400);//Set the bounds of the button.
		change = new JButton("CHANGE");
		change.setBounds(650,20,140,100);
		p1.add(P1);
		p1.add(P2);
		p1.add(P3);
		P2.addActionListener(new P2Listener());
		P3.addActionListener(new P3Listener());
		//change.addActionListener(new changeListener());
		frame1.getContentPane().add(p1);
		//frame1.setLayout(null);
		frame1.setSize(800,800);//800*800
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBackground(Color.white);
		frame1.setVisible(true);
		
		frame2 = new JFrame();
		finish = new JButton("FINISH");
		back = new JButton("BACK");
		userFullName = new JTextField(20);
		userQMEmail = new JTextField(20);
		userQMID = new JTextField(20);
		p2 = new JPanel();
		p2.setLayout(gridLayout2);
		p2.add(fullName);
		p2.add(userFullName);
		p2.add(QMID);
		p2.add(userQMID);
		p2.add(QMEmail);
		p2.add(userQMEmail);
		p2.add(finish);
		p2.add(back);
		finish.addActionListener(new finishListener());
		back.addActionListener(new backListener());
		frame2.getContentPane().add(BorderLayout.CENTER,p2);
		frame2.getContentPane().add(BorderLayout.NORTH,newUser);
		//frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(800,800);
		frame2.setVisible(false);
		
		emailFault = new JFrame();
		JLabel fault1 = new JLabel("Wrong format of the email address.");
		emailFault.add(fault1);
		//emailFault.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		emailFault.setSize(400,400);
		emailFault.setVisible(false);
		
		JLabel fault2 = new JLabel("Wrong format of the QM ID.");
		IDFault.add(fault2);
		//IDFault.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		IDFault.setSize(400,400);
		IDFault.setVisible(false);
		
		fileExist = new JFrame();
		JLabel exist = new JLabel("The user has already registered!");
		fileExist.add(exist);
		fileExist.setSize(400,400);
		fileExist.setVisible(false);
		registerSucc = new JFrame();
		JLabel succ = new JLabel("Successfully register!");
		registerSucc.add(succ);
		registerSucc.setSize(400,400);
		registerSucc.setVisible(false);
		
		changeFineCond = new JFrame();
		changeFineCond.setSize(800,800);
		changeFineCond.setVisible(false);
		dataView = new JTextField(9);
		search = new JButton("Search.");
		back2 = new JButton("Back");
		back2.addActionListener(new back2Listener());
		search.addActionListener(new searchListener());
		changeFineCond.getContentPane().add(BorderLayout.CENTER,search);
		changeFineCond.getContentPane().add(BorderLayout.NORTH,dataView);
		changeFineCond.getContentPane().add(BorderLayout.SOUTH,back2);
	}

//view data listener.
class P2Listener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		frame1.setVisible(false);
		changeFineCond.setVisible(true);
	}
}

//Register new users listener.
class P3Listener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		frame1.setVisible(false);
		frame2.setVisible(true);
	}
}

//Finish listener. And it will test/create a new text file for the user.
class finishListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		/*if(!isNumeric(userID) || userID.length() != 9)  {
			IDFault.setVisible(true);
		}
		*/
		if(!checkEmail(userQMEmail.getText())) {
			emailFault.setVisible(true);
			
		}
		else {
		File file = new File(userQMID.getText() + ".txt");
//		if(!file.exists()) {
			
			
			User.name = userFullName.getText();
			User.qmId = Integer.parseInt(userQMID.getText());
			System.out.println(i);
			LimitedDocument ld = new LimitedDocument(9);//鍙傛暟涓鸿兘杈撳叆鐨勬渶澶ч暱搴�
			ld.setAllowChar("0123456789");//鍙兘杈撳叆鐨勫瓧绗�
			userQMID.setDocument(ld);//杩愮敤鍒版枃鏈涓�
			User.emailAddr = userQMEmail.getText();
			User.banned = true;
//			System.out.println(User.name);
			i++;
//			try {
//				file.createNewFile();
//				try {
//					String str = System.getProperty("line.separator");
//					FileWriter fw = new FileWriter(userQMID.getText() + ".txt");
//					fw.write(userFullName.getText());
//					fw.write(str);
//					fw.write(userQMID.getText());
//					fw.write(str);
//					fw.write(userQMEmail.getText());
//					fw.write(str);
//					fw.write("Banned:false");
//					fw.close();
//				}
//				catch(IOException e) {
//					e.printStackTrace();
//				}
//				frame1.setVisible(true);
//				frame2.setVisible(false);
//				registerSucc.setVisible(true);
//			}
//			catch(IOException e){
//				e.printStackTrace();
//			}
//		}
			fileExist.setVisible(true);
		}
	}
}

//The listener of the back button.
class backListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		frame2.dispose();
		frame1.setVisible(true);
	}
}

class searchListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		readFileByLines(dataView.getText() + ".txt");
	}
}

public Boolean checkEmail(String Emailaddr) {//妫�鏌mail鏍煎紡鏄惁姝ｇ‘
	if(!Emailaddr.matches("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")) {
		return false;
		}
	else {return true;}
}

public static void createFail() {
	JFrame createFail = new JFrame();
	JLabel alreadyExist = new JLabel("This user has already registered!");
	createFail.add(alreadyExist);
	createFail.setSize(400,400);
	createFail.setVisible(true);
}

class back2Listener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		frame1.setVisible(true);
		changeFineCond.dispose();
	}
}

public String readFileByLines(String fileName) {
	managerInterface.fileName = fileName;
	JFrame notFound = new JFrame();
	notFound.setSize(400,400);
	notFound.setVisible(false);
	JLabel textNotFound = new JLabel("User not found!");
	notFound.add(textNotFound);
	JFrame found = new JFrame();
	found.setSize(400,400);
	found.setVisible(false);
	found.setLayout(new GridLayout(5,1));
	File file = new File(fileName);
	//JButton change = new JButton("change");
	String filePath = "cmd.exe /c notepad C:\\Users\\admin\\Desktop\\scooter system\\managerInterface" 
			+ "\\" + fileName;
	if(file.exists()) {
	BufferedReader reader = null;
	try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 0;
			JLabel[] messageInfor = new JLabel[5];
			String[] message = new String[5];
			while ((tempString = reader.readLine()) != null) {
				//鎶婂綋鍓嶈鍙锋樉绀哄嚭鏉�
				//System.out.println(tempString);
				message[line] = tempString;
				messageInfor[line] = new JLabel(message[line]);
				found.add(BorderLayout.CENTER,messageInfor[line]);
				line++;
				
			}
			found.setVisible(true);
			try {
				Process process = Runtime.getRuntime().exec(filePath);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			reader.close();
		} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (reader != null) {
					try {
							reader.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
	else {
		notFound.setVisible(true);
	}
	return fileName;
}

/*public class changeListener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		JFrame change = new JFrame();
		change.setSize(400,400);
		change.setVisible(true);
		JTextField input = new JTextField(20);
		JButton search = new JButton("search");
		search.addActionListener(new openListener());
		change.add(BorderLayout.NORTH,input);
		change.add(BorderLayout.CENTER,search);
		inputID = input.getText();
		System.out.println(inputID);
}
}

class openListener implements ActionListener{
	public void actionPerformed(ActionEvent event) {
		String filePath = "cmd.exe /c notepad C:\\Users\\admin\\Desktop\\scooter system\\managerInterface" 
								+ "\\" + inputID + ".txt";
		openFile(filePath);
	}
}
*/

public void openFile(String filePath) {
		try {
			Process process = Runtime.getRuntime().exec(filePath);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
}
}

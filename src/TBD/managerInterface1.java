package TBD;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class managerInterface1 {
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
	//JFrame registerFrame;//
	JButton search;
	JLabel NewUser = new JLabel("New User:");
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
	public ImageIcon pt3 = new ImageIcon("P3.jpg");
	public ImageIcon pt2 = new ImageIcon("P2.jpg");
	public ImageIcon pt1 = new ImageIcon("P1.jpg");
	static String fileName;

	public managerInterface1() {
		frame1 = new JFrame();
		IDFault = new JFrame();
		p1 = new JPanel();
		p1.setLayout(null);
		P1 = new JButton(pt1);
		P1.setBounds(20,20,170,100);
		P2 = new JButton(pt2);
		P2.setBounds(50,200,300,400);
		P3 = new JButton(pt3);
		P3.setBounds(450,200,300,400);//Set the bounds of the button.
		p1.add(P1);
		p1.add(P2);
		p1.add(P3);
		P2.addActionListener(new P2Listener());
		P3.addActionListener(new P3Listener());
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
		
		
		//???
		p2.add(back);
		finish.addActionListener(new finishListener());
		back.addActionListener(new backListener());
		frame2.getContentPane().add(BorderLayout.CENTER,p2);
		frame2.getContentPane().add(BorderLayout.NORTH,NewUser);
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
		/*
		String FullName = userFullName.getText();
		String userEmailAddr = userQMEmail.getText();
		String userID = userQMID.getText();
		*/
		registerSucc = new JFrame();
		JLabel succ = new JLabel("Successfully register!");
		registerSucc.add(succ);
		registerSucc.setSize(400,400);
		registerSucc.setVisible(false);
		
		changeFineCond = new JFrame();
		changeFineCond.setSize(800,800);
		changeFineCond.setVisible(false);
		dataView = new JTextField(9);
		//changeFineCond.add(dataView);
		search = new JButton("Search.");
		back2 = new JButton("Back");
		back2.addActionListener(new back2Listener());
		search.addActionListener(new searchListener());
		changeFineCond.getContentPane().add(BorderLayout.CENTER,search);
		changeFineCond.getContentPane().add(BorderLayout.NORTH,dataView);
		changeFineCond.getContentPane().add(BorderLayout.SOUTH,back2);
		//changeFineCond.getContentPane().add(BorderLayout.NORTH,input);
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
		if(!isEmail(userEmailAddr)) {
			emailFault.setVisible(true);
		}
		*/
		File file = new File(userQMID.getText() + ".txt");
		User newUser = new User();
//		newUser.fullName = userFullName.getText();
//		newUser.ID = userQMID.getText();
//		newUser.emailAddr = userQMEmail.getText();
		if(!file.exists()) {
			try {
				file.createNewFile();
				try {
					String str = System.getProperty("line.separator");
					FileWriter fw = new FileWriter(userQMID.getText() + ".txt");
					fw.write(userFullName.getText());
					fw.write(str);
					fw.write(userQMID.getText());
					fw.write(str);
					fw.write(userQMEmail.getText());
					fw.write(str);
					fw.write("CyclingCond:false");
					fw.write(str);
					fw.write("FineCond:true");
					fw.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				frame1.setVisible(true);
				frame2.setVisible(false);
				registerSucc.setVisible(true);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		else {
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
/*public static boolean isNumeric(String str){
    for (int i = str.length();--i>=0;){  
       if (!Character.isDigit(str.charAt(i))){
          return false;
         }     
    }
   return true;
}
*/

/*public static boolean isEmail(String string) {
	if (string == null)
		return false;
	String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	Pattern p;
	Matcher m;
	p = Pattern.compile(regEx1);
	m = p.matcher(string);
	if (m.matches())
		return true;
	else
		return false;
}
*/
//Method if create the duplicate text file.
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

public void readFileByLines(String fileName) {
	managerInterface1.fileName = fileName;
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
	if(file.exists()) {
	BufferedReader reader = null;
	try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 0;
			JLabel[] messageInfor = new JLabel[5];
			String[] message = new String[5];
			while ((tempString = reader.readLine()) != null) {
				//把当前行号显示出来
				System.out.println(tempString);
				message[line] = tempString;
				messageInfor[line] = new JLabel(message[line]);
				found.add(BorderLayout.CENTER,messageInfor[line]);
				line++;
			}
			found.setVisible(true);
			reader.close();
			JButton change = new JButton("press to change the value of fine condition.");
			found.add(BorderLayout.SOUTH,change);
			//change.addActionListener(new changeLisener());
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
}

/*class changeLisener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
		File file = new File(managerInterface1.fileName);
		BufferedReader reader = null;
		if(file.exists()) {
		try {
				reader = new BufferedReader(new FileReader(file));
				String tempString = null;
				int line = 0;
				JLabel[] messageInfor = new JLabel[5];
				String[] message = new String[5];
				while ((tempString = reader.readLine()) == "FineCond:true") {
					
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
			
		}
}
}
*/
}






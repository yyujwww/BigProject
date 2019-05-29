import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class UserFrame extends JFrame{
	private User user;

	private JFrame frame;
	private UserUsage uu;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Dock[] docks = SystemUsage.getDocks();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame window = new UserFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserFrame() {
		initialize();
	}
	
	public UserFrame(User user) {
		this.user = user;
		this.uu = new UserUsage(user);
		initialize();
	}
	
	public void showFrame() {
		UserFrame window = new UserFrame();
		window.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println(docks[0].getThisLockState(7));//???
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setResizable(false);
		frame.setBounds(100, 100, 652, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hello <dynamic>");
		lblNewLabel.setFont(new Font("Segoe Script", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 316, 92);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTotalTimeToday = new JLabel("Total time today:");
		lblTotalTimeToday.setFont(new Font("Segoe Script", Font.PLAIN, 18));
		lblTotalTimeToday.setBounds(358, 20, 280, 42);
		frame.getContentPane().add(lblTotalTimeToday);
		
		JLabel lblTimeThisTime = new JLabel("Time this time  : ");
		lblTimeThisTime.setFont(new Font("Segoe Script", Font.PLAIN, 18));
		lblTimeThisTime.setBounds(358, 72, 280, 42);
		frame.getContentPane().add(lblTimeThisTime);
		
		String[] dockSymbol = {"A","B","C"};
		JComboBox comboBox = new JComboBox(dockSymbol);
		comboBox.setFont(new Font("Segoe Print", Font.PLAIN, 22));
		comboBox.setBounds(442, 178, 54, 35);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Select a dock");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 20));
		lblNewLabel_1.setBounds(293, 171, 139, 51);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("PICK UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setBanned(true);
				if(!user.isBanned()){
					
					
					Dock thisDock = null;
					for(Dock d:docks) {
						if(d.getSymbol()==(char)comboBox.getSelectedItem()) {
							thisDock = d;
							break;
						}
					}
					uu.pickUpScooter(thisDock);
				}
				else {
					JOptionPane.showMessageDialog(null, "Sorry, you are banned.");
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		btnNewButton.setBounds(506, 179, 119, 35);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setForeground(SystemColor.menu);
		textField.setBounds(152, 112, 119, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setForeground(SystemColor.menu);
		textField_1.setColumns(10);
		textField_1.setBounds(152, 148, 119, 29);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setForeground(SystemColor.menu);
		textField_2.setColumns(10);
		textField_2.setBounds(152, 187, 119, 29);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("Dock A");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(43, 112, 99, 29);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblDockB = new JLabel("Dock B");
		lblDockB.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		lblDockB.setBounds(43, 148, 99, 29);
		frame.getContentPane().add(lblDockB);
		
		JLabel lblDock = new JLabel("Dock C");
		lblDock.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		lblDock.setBounds(43, 186, 99, 29);
		frame.getContentPane().add(lblDock);
	}
}

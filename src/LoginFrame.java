import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginFrame extends JFrame{

	private JFrame frmLogin;
	private JTextField txtInputToImmitate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 631, 192);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		txtInputToImmitate = new JTextField();
		txtInputToImmitate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(txtInputToImmitate.getText().length()>9) {
					e.consume();
				}
				if (!(c >= '0' && c <= '9')) {
					e.consume();
				}
			}
		});
		txtInputToImmitate.setBackground(SystemColor.textHighlightText);
		txtInputToImmitate.setFont(new Font("Yu Gothic UI Light", Font.ITALIC, 24));
		txtInputToImmitate.setHorizontalAlignment(SwingConstants.CENTER);
		txtInputToImmitate.setBounds(46, 45, 361, 59);
		frmLogin.getContentPane().add(txtInputToImmitate);
		txtInputToImmitate.setColumns(10);
		
		JButton btnNewButton = new JButton("Login!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sId = txtInputToImmitate.getText();
				int index = DataIO.findUser(sId);
				if(index!=-1) {
					User user = DataIO.getUserByIndex(index);
					if(!user.isBanned()) {

						new UserFrame(user);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Sorry, you are banned.");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "The user does not exist, please register.");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Segoe Script", Font.PLAIN, 22));
		btnNewButton.setBounds(417, 45, 158, 59);
		frmLogin.getContentPane().add(btnNewButton);
	}
}

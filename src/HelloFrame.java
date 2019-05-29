import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class HelloFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmHello;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HelloFrame window = new HelloFrame();
//					window.frmHello.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		HelloFrame window = new HelloFrame();
		window.frmHello.setVisible(true);
		
	}

	/**
	 * Create the application.
	 */
	public void showFrame() {
		HelloFrame window = new HelloFrame();
		window.frmHello.setVisible(true);
	}
	public HelloFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHello = new JFrame();
		frmHello.setResizable(false);
		frmHello.setTitle("Hello");
		frmHello.setBounds(100, 100, 649, 320);
		frmHello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHello.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("I\u2019m the Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Ink Free", Font.BOLD, 25));
		btnNewButton.setBounds(61, 96, 220, 81);
		frmHello.getContentPane().add(btnNewButton);
		
		JButton btnImTheUser = new JButton("I\u2019m the User");
		btnImTheUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginFrame().showFrame();
			}
		});
		btnImTheUser.setFont(new Font("Ink Free", Font.BOLD, 25));
		btnImTheUser.setBounds(363, 96, 220, 81);
		frmHello.getContentPane().add(btnImTheUser);
	}
}

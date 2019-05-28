import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class UserFrame {
	private User user;

	private JFrame frame;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setResizable(false);
		frame.setBounds(100, 100, 652, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  Hello " + user.getName());
		lblNewLabel.setFont(new Font("Segoe Script", Font.PLAIN, 24));
		lblNewLabel.setBounds(0, 10, 316, 92);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTotalTimeToday = new JLabel("Total time today:");
		lblTotalTimeToday.setFont(new Font("Segoe Script", Font.PLAIN, 18));
		lblTotalTimeToday.setBounds(358, 10, 280, 42);
		frame.getContentPane().add(lblTotalTimeToday);
		
		JLabel lblTimeThisTime = new JLabel("Time this time  : ");
		lblTimeThisTime.setFont(new Font("Segoe Script", Font.PLAIN, 18));
		lblTimeThisTime.setBounds(358, 62, 280, 42);
		frame.getContentPane().add(lblTimeThisTime);
	}
}

import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class blinkBulb extends Thread{
	public volatile boolean done = false;
	private static JFrame jf;
	private static JLabel timer = new JLabel("60");
	private static JButton pick = new JButton("PICK!");
	private static Icon on = new ImageIcon("Graphics//pix_light_on.jpg");
	private static Icon off = new ImageIcon("Graphics//pix_light_off.jpg");
	private static JLabel light = new JLabel(on);
//	private static JLabel lightOff = new JLabel(off);
	private static int i = 0;
	//private static final Font font1 = new Font("TimesRoman", Font.BOLD, 11);
	private static final Font font2 = new Font("TimesRoman", Font.BOLD, 20);
	
	public boolean isDone() {
		return done;
	}
	public static void on() {
		timer.setText((60-i/2)+"");
		light.setIcon(on);
//		jf.remove(lightOff);
//		lightOn();
		//do sth maybe a bulb graph
	}
	public static void off() {
		light.setIcon(off);
//		jf.remove(lightOn);
//		lightOff();
		//do sth
	}
	public static void lightOn() {
		light.setVisible(true);
		light.setBounds(0, 0, 288, 288);
		jf.add(light);
	}
//	public static void lightOff() {
//		lightOff.setVisible(true);
//		lightOff.setBounds(0, 0, 285, 285);
//		jf.add(lightOff);
//	}
//	
	public void run() {
		jf = new JFrame("Waiting");
		
		jf.setLayout(null);
		
		jf.setBounds(400, 150, 300, 460);
		
		lightOn();
		timer.setFont(font2);
		timer.setBounds(135, 310, 40, 40);
		timer.setVisible(true);
		jf.add(timer);
		pick.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						done = true;
					}
				});
		pick.setBounds(95, 355, 100, 60);
		pick.setFont(font2);
		jf.add(pick);
        jf.setVisible(true);
		
		for (i = 0; i < 120; i++) {
			if(!done) {
				try {
					on();
					Thread.sleep(250);
					off();
					Thread.sleep(250);
					
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
			else{
				jf.dispose();
			};
		}
		off();
	}
	
	public static void main(String[] arg) {
		Thread blink = new blinkBulb();
		blink.run();
	}
}

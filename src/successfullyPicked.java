import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class successfullyPicked extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public successfullyPicked(Scooter scooter){
		
		final JFrame jf = new JFrame("Successfully Picked!");
		jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel L1 = new JLabel("Pick up successfully! The scooter ID is "+ scooter.getScooterId()+". And the timer is activated.");
        L1.setVisible(true);
        L1.setBounds(30, 20, 400, 30);
        jf.add(L1);
        final Font font = new Font("TimesRoman", Font.BOLD, 11);
        L1.setFont(font);
        
        jf.setBounds(300,300,435,110); 
        jf.setVisible(true);
        jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置关闭方式 如果不设置的话 似乎关闭窗口之后不会退出程序
    }
    public static void main(String[] args) {//test
        new successfullyPicked(new Scooter('A'));        //创建窗口
    }
}

//import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BannedFrame extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BannedFrame(){
		
		final JFrame jf = new JFrame("Opps! You are banned.");
		jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel L1 = new JLabel("  Sorry, you are banned. If you want to use the scooter,");
        JLabel L2 = new JLabel("please pay the fine first. Thank you for your cooperation!");    //创建一个标签 并设置初始内容
        L1.setVisible(true);
        L2.setVisible(true);
        L1.setBounds(30, 20, 355, 20);
        L2.setBounds(30, 40, 355, 20);
        jf.add(L1);
        jf.add(L2);
        final Font font = new Font("TimesRoman", Font.BOLD, 11);
        L1.setFont(font);
        L2.setFont(font);
        
        jf.setBounds(300,300,375,120); //设置窗口的属性 窗口位置以及窗口的大小
        jf.setVisible(true);//设置窗口可见
        jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE); //设置关闭方式 如果不设置的话 似乎关闭窗口之后不会退出程序
    }
    public static void main(String[] args) {
        new BannedFrame();        //创建窗口
    }
	
}

package TBD;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		     // TODO Auto-generated method stub
	         JFrame f = new JFrame();
	         final Scooter scooter1 = new Scooter();//��ʱ���½�15������
	         f.setTitle("test");
	         f.setBounds(600, 300, 500, 400);
//	 		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		 JButton b1 = new JButton("��ʼ��ʱ");
	         b1.addActionListener(new ActionListener() {	        	         
				@Override
				public void actionPerformed(ActionEvent e) {
				 scooter1.startTimer();
				}
			});
	         
	         JButton b2 = new JButton("ֹͣ��ʱ");
	         f.setLayout(new BorderLayout());
	         f.add(b1,BorderLayout.NORTH);
	         f.add(b2,BorderLayout.SOUTH);
	         f.setVisible(true);
	         b2.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(scooter1.endTimer());
				}
			});
		 

	}

}

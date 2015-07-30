package workOut;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkOutFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkOutFrame frame1 = new WorkOutFrame();
					frame1.setVisible(true);
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WorkOutFrame() {
		setTitle("Work Out Record");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setForeground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        	
		JLabel lblIsTodayA = new JLabel("Is Today a Normal Work Out?");
		lblIsTodayA.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
		lblIsTodayA.setBounds(110, 83, 278, 45);
		contentPane.add(lblIsTodayA);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnYes.setBounds(40, 209, 117, 29);
		contentPane.add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(182, 209, 117, 29);
		contentPane.add(btnNo);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		btnQuit.setBounds(311, 209, 117, 29);
		contentPane.add(btnQuit);
	}
}

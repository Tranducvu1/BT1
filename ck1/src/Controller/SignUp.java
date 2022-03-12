package Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame {
	JFrame fc= new JFrame();
	JLabel lbsignup = new JLabel("SIGN UP");
	JLabel lbchoose1 = new JLabel("DO AN JAVA CUOI KI  SINH VIEN THUC HIEN DANG QUOC VIET");
	JLabel lbuser = new JLabel("USERNAME");
	JTextField tfusername = new JTextField(15);
	JLabel lbpassword = new JLabel("PASSWORD");
	//JTextField tfpassword = new JTextField(15);
	JPasswordField tfpassword  = new JPasswordField(10);
	JButton btforget = new JButton("Forgotten");
	JButton btsignup = new JButton("Log in");
	JButton btcreateacA = new JButton("Create Account");
	JLabel lbq = new JLabel("Rights");
	String gender[] = {"Admin"};
	JComboBox cbq = new JComboBox(gender);
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ps;
	public SignUp() {
		lbsignup.setLayout(null);
		lbsignup.setBounds(200,100,100,30);
		lbsignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbsignup.setForeground(Color.BLUE);
		fc.setLocation(500,200);
		fc.setLayout(null);
		fc.add(lbsignup);
		lbchoose1.setBounds(50,10,450,100);
		lbchoose1.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(lbchoose1);
		lbuser.setBounds(80,80,80,210);
		lbuser.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(lbuser);
		tfusername.setBounds(180,175,200,25);
		tfusername.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(tfusername);
		lbpassword.setBounds(80,120,80,210);
		lbpassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(lbpassword);
		tfpassword.setBounds(180,215,200,25);                   
		tfpassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(tfpassword);
		lbq.setBounds(90,250,100,20);
		lbq.setFont(new Font("Tahoma", Font.BOLD, 12));
		btforget.setBounds(60,280,100,25);
		btforget.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(btforget);
		btsignup.setBounds(180,280,100,25);
		btsignup.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(btsignup);
		btcreateacA.setBounds(300,280,150,25);
		btcreateacA.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(btcreateacA);
		btforget.setBackground(Color.PINK);
		btsignup.setBackground(Color.PINK);
		btcreateacA.setBackground(Color.PINK);
		
	
		    fc.pack();
			fc.setSize(500,400);
			fc.setVisible(true);
			
			 btsignup.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				String username= tfusername.getText();
				String password= new String (tfpassword.getText());
				String username1= tfusername.getText();
				String password1= new String (tfpassword.getText());
				StringBuilder sb = new StringBuilder();
		
			if (username.equals("")) {
			sb.append("Vui long nhập lại ");
			}
				
			if (password.equals("")) {
				sb.append("Vui lòng nhập lại");
				}
			if (sb.length()>0) {
			
		return ;
			}
			else 	 if (username1.equals("admin") && password1.endsWith("admin")) {
					//				JOptionPane.showMessageDialog( this,"successfull");
				 new informationhouse();//			new ();
									fc.dispose();
									JOptionPane.showMessageDialog(null, "Successfull");
							
									
								}
				else {
					JOptionPane.showMessageDialog(null, "Failed");	
					new Createaccount();
					fc.dispose();
				}}

					});
			
		

			btcreateacA.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new Createaccount();
					fc.dispose();
					
				}
			});
			btforget.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					new forgotpass();
					fc.dispose();
					
				}
			});
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUp();
	}
}

package Controller;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Model.ConnectDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SignUp extends JFrame {
	JFrame fc= new JFrame();
	JLabel lbsignup = new JLabel("SIGN UP");
//	JLabel lb = new JLabel("SIGN UP");
	
	JLabel lbuser = new JLabel("USERNAME");
	JTextField tfusername = new JTextField(15);
	JLabel lbpassword = new JLabel("PASSWORD");
	JTextField tfpassword = new JTextField(15);
	JButton btforget = new JButton("Forgotten");
	JButton btsignup = new JButton("Sign Up");
	JButton btcreateacA = new JButton("Create Account");
	JButton btcancel = new JButton("Cancel");
	JLabel lbq = new JLabel("QUYEN");
	String gender[] = {"Quản trị","Khách"};
	JComboBox cbq = new JComboBox(gender);
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ps;
	public SignUp() {
		lbsignup.setLayout(null);
		lbsignup.setBounds(750,120,100,30);
		lbsignup.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbsignup.setForeground(Color.BLUE);
		fc.setLocation(500,200);
		fc.setLayout(null);
	//	lb.setBounds(50,0,500,30);
	//	lb.setFont(new Font("Tahoma", Font.BOLD, 20));
	//	lb.setForeground(Color.BLUE);
		fc.add(lbsignup);
	
	//	lb.setBounds(750,120,100,20);
	//	lb.setFont(new Font("Tahoma", Font.BOLD, 12));
	//	fc.add(lb);
		lbuser.setBounds(450,120,80,210);
		lbuser.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(lbuser);
		tfusername.setBounds(550,213,300,30);
		tfusername.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(tfusername);
		lbpassword.setBounds(450,180,80,210);
		lbpassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(lbpassword);
		tfpassword.setBounds(550,270,300,30);
		tfpassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(tfpassword);
		lbq.setBounds(650,320,100,20);
		lbq.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(lbq);
		cbq.setBounds(750,320,100,20);
		cbq.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(cbq);
		btforget.setBounds(400,420,100,50);
		btforget.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(btforget);
		btsignup.setBounds(600,420,100,50);
		btsignup.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(btsignup);
		btcreateacA.setBounds(800,420,200,50);
		btcreateacA.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(btcreateacA);
		btcancel.setBounds(1100,420,100,50);
		btcancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		fc.add(btcancel);
	
		    fc.pack();
			fc.setSize(1500,600);
			fc.setVisible(true);
			btcancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					fc.dispose();
				}
			});
			 btsignup.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				String username= tfusername.getText();
				String password= new String (tfpassword.getText());
			
				StringBuilder sb = new StringBuilder();
		
			if (username.equals("")) {
			sb.append("Vui lòng nhập lại");
			}
				
			if (password.equals("")) {
				sb.append("Vui lòng nhập lại");
				}
			if (sb.length()>0) {
			
		return ;
			}
				if (username.equals("Vune") && password.endsWith("Vune")) {
	//				JOptionPane.showMessageDialog( this,"successfull");
					new choose();
					fc.dispose();
					JOptionPane.showMessageDialog(null, "Successfull");
			
					
				}else {
					JOptionPane.showMessageDialog(null, "Error");	
					new Createaccount();
					fc.dispose();
				}}	});
				
		

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

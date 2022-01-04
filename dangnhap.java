package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class dangnhap extends JFrame{
	Icon star;  
	JFrame b1;
	JFrame f = new JFrame("Quản lí nhà trọ");
	JLabel lbName = new JLabel("UserName");
	JTextField tfName = new JTextField(5);
	//Icon ic1=new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\codegame\\src\\codegame\\tranducvu.jpg"); 
	Icon ic1=new ImageIcon("D:\\game\\codegame\\a1.jpg");
	JLabel lbPass = new JLabel("Password");
	JTextField tfPass = new JTextField(5);
	JButton jbt1 = new JButton("Đăng nhâp");	
	public dangnhap() {
		f.setLocation(20,20);
		f.setLayout(new GridLayout(3,1));
		Container cont =  f.getContentPane();
		cont.add(lbName);
		cont.add(tfName);
		//b1.setIconImage((Image) ic1); 
		ic1=new ImageIcon("D:\\game\\codegame\\a1.jpg");  
		cont.add(lbPass);
		cont.add(tfPass);
		cont.add(jbt1);
		f.pack();
		f.setSize(150,150);
		f.setVisible(true);
	}	
	public static void main(String agrs[]) {
		//Frame frame = new Frame("Bang danh sach");
		//frame.setSize(800, 500);
	//dangnhap wd = new dangnhap();
		//JPanel pn1 = new JPanel();
		//frame.add(pn1);
		new dangnhap();
		//frame.setVisible(true);
		//wd.setSize(400,200);
		//wd.setLocationRelativeTo(null);
	//	wd.setVisible(true);
	}
}

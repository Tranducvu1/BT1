package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Model.ConnectDB;



public class Khachsan extends JFrame{

	
	JFrame lb = new JFrame("Information Room");
	JLabel IDR = new JLabel("ID Room");
	JTextField tfr = new JTextField(15);
	JLabel lbt = new JLabel("Ten");
	JTextField tft = new JTextField(15);
	JLabel lbns = new JLabel("Nam sinh");
	JTextField tfns = new JTextField(15);
	JLabel lbsdt = new JLabel("So dien thoai");
	JTextField tfsdt = new JTextField(15);
	JLabel lbmax = new JLabel("NGUOI TOI DA");
	JTextField tfmax = new JTextField(15);
	JLabel lbmember = new JLabel("NGUOI HIEN TAI");
	JTextField tfmember = new JTextField(15);
	JButton btnadd = new JButton ("Add");
	JButton btndelete = new JButton ("Delete");
	JButton btnnew = new JButton ("Reset");
	JButton btnupdate = new JButton ("Update");
	JButton btnsearch = new JButton ("Find");
	JButton btnSee = new JButton ("See");
	JButton btncancel = new JButton ("Cancel");
	JButton btnback = new JButton("Back");

	JButton btnexit = new JButton("Exit");
	JTextField tfsearch = new JTextField(10);
	JLabel lbtools = new JLabel("Tools");
	JLabel btnMenu = new JLabel("Meuu");
	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	JTable tbhouse = new JTable();
	JScrollPane sp = new JScrollPane(tbhouse);
	public Khachsan() {
		jframehouse();
		buttonhouse();
		tbhouse.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int row = tbhouse.getSelectedRow();
				tfr.setText((String)tbhouse.getValueAt(row, 0));
				tft.setText((String)tbhouse.getValueAt(row, 1));
				tfns.setText((String)tbhouse.getValueAt(row, 2));
				tfsdt.setText((String)tbhouse.getValueAt(row, 3));
				tfmax.setText((String)tbhouse.getValueAt(row, 4));
				tfmember.setText((String)tbhouse.getValueAt(row, 5));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	public void DisplayHouse() {
		ConnectDB conn = new ConnectDB();
	// trong sql thì phải dùng DefaultTableModel nếu k sẽ bị trùng dữ liệu
		rs=conn.List("Select * from informationhouse1");
		String column[] = {"IDROOM", "TEN","NAMSINH","SODIENTHOAI","NGUOI TOI DA","NGUOI HIEN TAI"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
       
		
        try {
			while (rs.next()) {
				Object data[]= {rs.getString("IDROOM"), rs.getString("TEN"),rs.getString("NAMSINH"),rs.getString("SODIENTHOAI"),rs.getString("MemberMax"),rs.getString("Member")};    
				
				
				tm.addRow(data);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbhouse.setModel(tm);
	}

	public void HouseFind() {
		ConnectDB conn = new ConnectDB();
		rs=conn.List("Select * from informationhouse1 where IDROOM = '"+tfr.getText()+"' or TEN = '"+tft.getText()+ "or NAMSINH = '"+tfns.getText()+"' or SDT = '"+tfsdt.getText()+"' or MemberMax = '"+tfmax.getText()+"' or Member = '"+tfmember.getText());
		String column[] = {"IDHouse", "Address House","HouseArea","Deposits","MemberMax","Member"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
        try {
			while (rs.next()) {
				Object data[]= {rs.getString("IDROOM"), rs.getString("TEN"),rs.getString("NAMSINH"),rs.getString("SODIENTHOAI"),rs.getString("MemberMax"),rs.getString("Member")};    
				
				tm.addRow(data);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbhouse.setModel(tm);
	}
	public void jframehouse() {
		JPanel pnid = new JPanel();
		pnid.add(IDR);
		pnid.add(tfr);
		pnid.add(lbt);
		pnid.add(tft);
		pnid.add(lbns);
		pnid.add(tfns);
		pnid.add(lbsdt);
		pnid.add(tfsdt);
		pnid.add(lbmax);
		pnid.add(tfmax);
		pnid.add(lbmember);
		pnid.add(tfmember);
		pnid.setLayout(new GridLayout(6,2));
		Border bd = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder tbdhouse= BorderFactory.createTitledBorder(bd, "Database");
		pnid.setBorder(tbdhouse);
		pnid.setBackground(Color.WHITE);
		
		JPanel pnbt = new JPanel();
		pnbt.add(btnadd);
		pnbt.add(btnupdate);
		pnbt.add(btndelete);
		pnbt.add(btnsearch);
		pnbt.add(btnnew);
		pnbt.add(btnSee);
		pnbt.add(btncancel);
		pnbt.add(btnback);
		pnbt.setLayout(new GridLayout(2,4));
		btncancel.setBackground(Color.YELLOW);
		btnback.setBackground(Color.YELLOW);
		btnsearch.setBackground(Color.YELLOW);
		btnupdate.setBackground(Color.YELLOW);
		btnnew.setBackground(Color.YELLOW);
		btndelete.setBackground(Color.YELLOW);
		btnadd.setBackground(Color.YELLOW);
		btnSee.setBackground(Color.YELLOW);
		JPanel pninfor = new JPanel();
		Border bdhouse = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder tbdcus= BorderFactory.createTitledBorder(bdhouse, "Information ROOM");
		pninfor.setBorder(tbdcus);
		pninfor.add(sp);
		pninfor.setBackground(Color.WHITE);
		lb.setLocation(200,100);
		
		Container cont5 = lb.getContentPane();
		cont5.add(pnid,BorderLayout.CENTER);
		cont5.add(pninfor,BorderLayout.EAST);
		cont5.add(pnbt,BorderLayout.SOUTH);
		DisplayHouse();
		lb.pack();
		lb.setSize(950,550);
		lb.setVisible(true);

		btnback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new SignUp();
				lb.dispose();
			}
		});
		btncancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			lb.dispose();
			}
		});
		ConnectDB conn = new ConnectDB();
		rs=conn.List("Select * from informationhouse1 where IDROOM = '"+tfr.getText()+"' or TEN = '"+tft.getText()+ "or NAMSINH = '"+tfns.getText()+"' or SDT = '"+tfsdt.getText()+"' or MemberMax = '"+tfmax.getText()+"' or Member = '"+tfmember.getText());
		String column[] = {"IDROOM", "TEN","NAMSINH","SDT","MemberMax","Member"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
        try {
			while (rs.next()) {
				Object data[]= {rs.getString("IDROOM"), rs.getString("TEN"),rs.getString("NAMSINH"),rs.getString("SODIENTHOAI"),rs.getString("MemberMax"),rs.getString("Member")};    
				
				tm.addRow(data);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbhouse.setModel(tm);
	}
	


	public void buttonhouse() {
		btnnew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Khachsan();
				lb.dispose();
			}
		});
		btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//thêm dữ liệu
				ConnectDB cn = new ConnectDB();
				try {
					int record1 = cn.executeDB("Insert into informationhouse1 values('"+tfr.getText()+"','"+tft.getText()+"','"+tfns.getText()+"','"+tfsdt.getText()+"','"+tfmax.getText()+"','"+tfmember.getText()+"')");
					if (record1>0) JOptionPane.showMessageDialog(null, "Insert Success");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DisplayHouse();
			}
		});
		btndelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn = new ConnectDB();
				try {
					int record1 = cn.executeDB("Delete from informationhouse1 where IDROOM = '"+tfr.getText()+"'");
					if (record1>0) JOptionPane.showMessageDialog(null, "Delete Success");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DisplayHouse();
			}
		});
		btnupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn = new ConnectDB();
				try {
					if(tft.getText().length() !=0) {
						int record1 = cn.executeDB("Update informationhouse1 set TEN = '"+tft.getText()+"' where IDROOM = '"+tfr.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfns.getText().length() !=0) {
						int record1 = cn.executeDB("Update informationhouse1 set NAMSINH = '"+tfns.getText()+"' where IDROOM = '"+tfr.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfsdt.getText().length() !=0) {
						int record1 = cn.executeDB("Update informationhouse1 set SODIENTHOAI = '"+tfsdt.getText()+"' where IDROOM = '"+tfr.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfmax.getText().length() !=0) {
						int record1 = cn.executeDB("Update informationhouse1 set MembernMax = '"+tfmax.getText()+"' where IDROOM = '"+tfr.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfmember.getText().length() !=0) {
						int record1 = cn.executeDB("Update informationhouse1 set Member = '"+tfmember.getText()+"' where IDROOM = '"+tfr.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				DisplayHouse();
			}
		});
		
		btnsearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				HouseFind();
			}
		});
	
		
		btnSee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				jtable2();
				lb.dispose();
			}
		});
	
		
	}
public void jtable2() {
	JFrame ftb = new JFrame();
	JTable tbhouse = new JTable();
	JScrollPane ctrl = new JScrollPane(tbhouse);
	JButton btnback = new JButton("Back");
	JButton btncancel = new JButton("Cancel");
	ftb.setLocation(200,100);
	
	JPanel pntb = new JPanel();
	ctrl.setPreferredSize(new Dimension(850, 450));
	Border bd2 = BorderFactory.createLineBorder(Color.CYAN);
	TitledBorder tbdll= BorderFactory.createTitledBorder(bd2, "Hotel");
	pntb.setBorder(tbdll);
	pntb.add(ctrl);
	
	btnback.setForeground(Color.RED);
	btncancel.setForeground(Color.RED);
	btnback.setBackground(Color.YELLOW);
	btncancel.setBackground(Color.YELLOW);
	JPanel pnbt = new JPanel();
	pnbt.add(btnback);
	pnbt.add(btncancel);
	Container conttb = ftb.getContentPane();
	conttb.add(pntb);
	conttb.add(pnbt, BorderLayout.SOUTH);
	ftb.setSize(900,500);
	ftb.setVisible(true);
	btncancel.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
				ftb.dispose();;
			
			}
	});
	btnback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			new Khachsan();
			ftb.dispose();
			}
		});
	ConnectDB conn = new ConnectDB();
	rs=conn.List("Select * from informationhouse1 where IDROOM = '"+tfr.getText()+"' or TEN = '"+tft.getText()+ "or NAMSINH = '"+tfns.getText()+"' or SDT = '"+tfsdt.getText()+"' or MemberMax = '"+tfmax.getText()+"' or Member = '"+tfmember.getText());
	String column[] = {"IDROOM", "TEN","NAMSINH","SDT","MemberMax","Member"};
    DefaultTableModel tm = new DefaultTableModel (column, 0);
    try {
		while (rs.next()) {
			Object data[]= {rs.getString("IDROOM"), rs.getString("TEN"),rs.getString("NAMSINH"),rs.getString("SODIENTHOAI"),rs.getString("MemberMax"),rs.getString("Member")};    
			
			tm.addRow(data);
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	tbhouse.setModel(tm);
}
}
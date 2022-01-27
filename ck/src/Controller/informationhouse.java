package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import Model.ConnectDB1;
 class informationhouse extends JFrame{
		JFrame f1 = new JFrame();
		JLabel lb = new JLabel("Information house");
		JLabel lbID = new JLabel("ID House");
		JTextField IDHouse = new JTextField(10);
		JLabel lbaddress = new JLabel("Address House");
		JTextField tfaddress = new JTextField(10);
		JLabel lbarea = new JLabel("House Area");
		JTextField HouseArea = new JTextField(10);
		JLabel lbdeposits = new JLabel("Deposits");
		JTextField tfdeposits = new JTextField(10);
		JButton btnadd = new JButton("See");
		JButton btnupdate = new JButton("Update");
		JButton btndel  = new JButton("Delete");
		JButton btnback = new JButton("repair");
		JLabel lbsearch = new JLabel("🔍Search");
		JButton btnsearch = new JButton("Search");
		JButton btnexit = new JButton("Exit");
		JTextField tfsearch = new JTextField(10);
		JLabel lbtools = new JLabel("Tools");
		JLabel btnMenu = new JLabel("Meuu");
		Connection conn;
		Statement stmt;
		ResultSet rs;
		PreparedStatement ps;
		
		

		public informationhouse() {
			JPanel jpnMain = new JPanel();
			jpnMain.setLayout(new BorderLayout());
			jpnMain.setLayout(new GridLayout(1,1));
			jpnMain.setSize(1400,1500);
			f1.setLayout(null);
			lb.setBounds(175,30,500,30);
			lb.setFont(new Font("Tahoma", Font.BOLD, 20));
			lb.setForeground(Color.BLUE);
			//ĐỔI MÀU CHỮ
			f1.add(lb);
			lbID.setBounds(40,80,500,30);
			lbID.setFont(new Font("Tahoma", Font.BOLD, 12));
			f1.add(lbID);
			IDHouse.setBounds(140,80,300,20);
			IDHouse.setFont(new Font("Tahoma", Font.BOLD, 12));
			f1.add(IDHouse);
			lbaddress.setBounds(40,120,500,30);
			lbaddress.setFont(new Font("Tahoma", Font.BOLD, 12));
			f1.add(lbaddress);
			tfaddress.setBounds(140,125,300,20);
			tfaddress.setFont(new Font("Tahoma", Font.BOLD, 12));
			f1.add(tfaddress);
			lbarea.setBounds(40,160,500,30);
			lbarea.setFont(new Font("Tahoma", Font.BOLD, 12));
			f1.add(lbarea);
			HouseArea.setBounds(140,165,300,20);
			HouseArea.setFont(new Font("Tahoma", Font.BOLD, 12));
			f1.add(HouseArea);
			lbdeposits.setBounds(40,200,300,30);
			lbdeposits.setFont(new Font("Tahoma", Font.BOLD, 12));
			f1.add(lbdeposits);
			tfdeposits.setBounds(140,205,300,30);
			tfdeposits.setFont(new Font("Tahoma", Font.BOLD, 12));
			f1.add(tfdeposits);
			btnadd.setBounds(55,450,80,34);
			btnadd .setFont(new Font("Tahoma", Font.BOLD, 12));
			f1.add(btnadd);
			btnupdate.setBounds(155,450,65,34);
			btnupdate.setFont(new Font("Tahoma", Font.BOLD, 10));
			f1.add(btnupdate);
			btndel.setBounds(235,450,95,34);
			btndel.setFont(new Font("Tahoma", Font.BOLD, 10));
			f1.add(btndel);
			btnback.setBounds(350,450,85,34);
			btnback.setFont(new Font("Tahoma", Font.BOLD, 10));
			f1.add(btnback);
			lbsearch.setBounds(60,300,100,30);
			lbsearch.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbsearch.setForeground(Color.RED);
			f1.add(lbsearch);
			btnsearch.setBounds(70,350,75,34);
			btnsearch.setFont(new Font("Tahoma", Font.BOLD, 10));
			f1.add(btnsearch);
			tfsearch.setBounds(200,355,240,30);
			tfsearch.setFont(new Font("Tahoma", Font.BOLD, 10));
			f1.add(tfsearch);
			lbtools.setBounds(60,400,100,30);
			lbtools.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbsearch.setForeground(Color.BLUE);
			f1.add(lbtools);
				f1.add(btnexit);
				btnback.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						f1.dispose();
						new choose();
					}
				});
				f1.add(jpnMain);
			f1.pack();
			f1.setSize(1200,700);
		f1.setVisible(true);
		JPanel jpn2 = new JPanel();
		jpnMain.add(jpn2,BorderLayout.NORTH);
		Border bd = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder bdt2 = BorderFactory.createTitledBorder(bd, "Database ");
		jpn2.setBorder(bdt2);
		DefaultTableModel dm=new DefaultTableModel();
	dm.addColumn("IDHouse ");
		dm.addColumn("AddressHouse");
		dm.addColumn("HouseArea");
		dm.addColumn("Deposits");
		JTable jtb = new JTable(dm);
		dm.addRow(new String[]{"214A","213 Tran Hung Dao","2.600","5.000.000"});
		JScrollPane sc =new JScrollPane(jtb);
		jpn2.add(sc, BorderLayout.SOUTH);
			jtb.addMouseListener(new MouseListener() {

			//tfcmndland.setText((String)tbhouse.getValueAt(row, 4));
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
					
		
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

				int row = jtb.getSelectedRow();
				IDHouse.setText((String)jtb.getValueAt(row, 0));
				tfaddress.setText((String)jtb.getValueAt(row, 1));
				HouseArea.setText((String)jtb.getValueAt(row, 2));
				tfdeposits.setText((String)jtb.getValueAt(row, 3));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
				});
		f1.add(jpnMain);
		}
		public void DisplayHouse() {
			ConnectDB1 conn = new ConnectDB1();
		// trong sql thì phải dùng DefaultTableModel nếu k sẽ bị trùng dữ liệu
			rs=conn.ListHouse("Select * from inforhouse");
			String column[] = {"ID House", "Address House","House Area","Deposits"};
	        DefaultTableModel tm = new DefaultTableModel (column, 0);
	       
			
	        try {
				while (rs.next()) {
					Object data[]= {rs.getString("IDHouse"), rs.getString("AddressHouse"),rs.getString("HouseArea"),rs.getString("Deposits"),rs.getString("CMNDland")};    
					
					
					tm.addRow(data);
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	//	jtb.setModel(tm);
		
		
 
		btnadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					//thêm dữ liệu
					ConnectDB1 cn = new ConnectDB1();
					try {
						int record = cn.executeDB1("Insert into informationhouse1 values('"+IDHouse.getText()+"','"+tfaddress.getText()+"','"+HouseArea.getText()+"','"+tfdeposits.getText()+"')");
						if (record>0) JOptionPane.showMessageDialog(null, "Insert Success");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//DisplayHouse();
				}
			});
		btndel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB1 cn = new ConnectDB1();
				try {
					int record = cn.executeDB1("Delete from informationhouse1 where IDHouse = '"+IDHouse.getText()+"'");
					if (record>0) JOptionPane.showMessageDialog(null, "Delete Success");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			//	DisplayHouse();
			}
		});
		}
		
		
	




	public static void main(String[] args) {
		// TODO Auto-generated method stub
new informationhouse();
	}

}

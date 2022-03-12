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



public class tiennuoc extends JFrame{
	JFrame lb = new JFrame("Quan li dien nuoc");
	JLabel lbn = new JLabel("Mã vùng nước");
	JTextField tfn = new JTextField(15);
	JLabel lbt = new JLabel("Tên");
	JTextField tft = new JTextField(15);
	JLabel lbdc = new JLabel("Địa chỉ");
	JTextField tfdc = new JTextField(15);
	JLabel lbsdt = new JLabel("Số điện thoại");
	JTextField tfsdt = new JTextField(15);
	JLabel lbns = new JLabel("Năm sinh");
	JTextField tfns = new JTextField(15);
	JLabel lbd = new JLabel("Tiền nước ");
	JTextField tfd = new JTextField(15);
	JButton btnadd = new JButton ("Add");
	JButton btndelete = new JButton ("Delete");
	JButton btnnew = new JButton ("Reset");
	JButton btnupdate = new JButton ("Update");
	JButton btnsearch = new JButton ("Find");
	JButton btnSee = new JButton ("See");
	JButton btncancel = new JButton ("Cancel");
	JButton btnback = new JButton("Back");

	PreparedStatement ps;
	Connection conn;
	ResultSet rs;
	JTable tbhouse = new JTable();
	JScrollPane sp = new JScrollPane(tbhouse);
	public tiennuoc() {
		jframehouse();
		buttonhouse();
		tbhouse.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int row = tbhouse.getSelectedRow();
				tfn.setText((String)tbhouse.getValueAt(row, 0));
				tft.setText((String)tbhouse.getValueAt(row, 1));
				tfdc.setText((String)tbhouse.getValueAt(row, 2));
				tfsdt.setText((String)tbhouse.getValueAt(row, 3));
				tfns.setText((String)tbhouse.getValueAt(row, 4));
				tfd.setText((String)tbhouse.getValueAt(row, 5));
				
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
	public void Display() {
		ConnectDB conn = new ConnectDB();
		rs=conn.List("Select * from diennuoc");
		String column[] = {"Ma vung nuoc", "Ten  ","dia chi","so dien thoai","Nam sinh", "Tien nuoc"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
       
		
        try {
			while (rs.next()) {
				Object data[]= {rs.getString("MAVN"), rs.getString("TEN"),rs.getString("DIACHI"),rs.getString("SDT"),rs.getString("NAMSINH"),rs.getString("TIENNUOC")};    
				
				
				tm.addRow(data);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbhouse.setModel(tm);
	}
	
	public void Find() {
		ConnectDB cn = new ConnectDB();
	   rs=cn.List("Select * from diennuoc where MAVN = '"+tfn.getText()+"'");
	   String column[] = {"Ma vung nuoc", "Ten  ","dia chi","so dien thoai","Nam sinh", "Tien nuoc"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
        try {
			while (rs.next()) {
				Object data[]= {rs.getString("MAVN"), rs.getString("TEN"),rs.getString("DIACHI"),rs.getString("SDT"),rs.getString("NAMSINH"),rs.getString("TIENNUOC")};    
				
				
				tm.addRow(data);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbhouse.setModel(tm);
	}
	public void jframehouse() {
		JPanel a = new JPanel();
		a.add(lbn);
		a.add(tfn);
		a.add(lbt);
		a.add(tft);
		a.add(lbdc);
		a.add(tfdc);
		a.add(lbsdt);
		a.add(tfsdt);
		a.add(lbns);
		a.add(tfns);
		a.add(lbd);
		a.add(tfd);
		a.setLayout(new GridLayout(7,2));
		lbn.setForeground(Color.ORANGE);
		lbt.setForeground(Color.ORANGE);
		lbdc.setForeground(Color.ORANGE);
		lbsdt.setForeground(Color.ORANGE);
		lbns.setForeground(Color.ORANGE);
		lbd.setForeground(Color.ORANGE);
		Border bd = BorderFactory.createLineBorder(Color.CYAN);
		TitledBorder tbdhouse= BorderFactory.createTitledBorder(bd, "Database");
		a.setBorder(tbdhouse);
		a.setBackground(Color.WHITE);
		
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
		btncancel.setBackground(Color.ORANGE);
		btnback.setBackground(Color.ORANGE);
		btnsearch.setBackground(Color.ORANGE);
		btnupdate.setBackground(Color.ORANGE);
		btnnew.setBackground(Color.ORANGE);
		btndelete.setBackground(Color.ORANGE);
		btnadd.setBackground(Color.ORANGE);
		btnSee.setBackground(Color.ORANGE);
		JPanel pninfor = new JPanel();
		Border bdhouse = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder tbdcus= BorderFactory.createTitledBorder(bdhouse, "Quan li dien nuoc");
		pninfor.setBorder(tbdcus);
		pninfor.add(sp);
		pninfor.setBackground(Color.WHITE);
		lb.setLocation(200,100);
		
		Container cont5 = lb.getContentPane();
		cont5.add(a,BorderLayout.CENTER);
		cont5.add(pninfor,BorderLayout.EAST);
		cont5.add(pnbt,BorderLayout.SOUTH);
		Display();
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
		ConnectDB con = new ConnectDB();
			rs=con.List("Select * from diennuoc");
			   String column[] = {"Ma vung nuoc", "Ten  ","Đia chi","So dien thoai","Nam sinh", "Tien nuoc"};
	        DefaultTableModel tm = new DefaultTableModel (column, 0);
	       
			
	        try {
				while (rs.next()) {
					
					Object data[]= {rs.getString("MAVN"), rs.getString("TEN"),rs.getString("DIACHI"),rs.getString("SDT"),rs.getString("NAMSINH"),rs.getString("TIENNUOC")};      
					
					
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
				new tiennuoc();
				lb.dispose();
			}
		});
		btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				ConnectDB cn = new ConnectDB();
				try {
					int record = cn.executeDB("Insert into diennuoc values('"+tfn.getText()+"','"+tft.getText()+"','"+tfdc.getText()+"','"+tfsdt.getText()+"','"+tfns.getText()+"','"+tfd.getText()+"')");
					if (record>0) JOptionPane.showMessageDialog(null, "Insert Success");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Display();
			}
		});
		btndelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn = new ConnectDB();
				try {
					int record = cn.executeDB("Delete from diennuoc where MAVN = '"+tfn.getText()+"'");
					if (record>0) JOptionPane.showMessageDialog(null, "Delete Success");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Display();
			}
		});
		btnupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn = new ConnectDB();
				try {
					
					if(tft.getText().length() !=0) {
						int record1 = cn.executeDB("Update diennuoc set TEN = '"+tft.getText()+"' where MAVN = '"+tfn.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfdc.getText().length()!=0) {
						int record1 = cn.executeDB("Update diennuoc set  DIACHI = '"+tfdc.getText()+"' where MAVN = '"+tfn.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfsdt.getText().length()!=0) {
						int record1 = cn.executeDB("Update diennuoc set SDT = '"+tfsdt.getText()+"' where MAVN = '"+tfn.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfns.getText().length()!=0) {
						int record1 = cn.executeDB("Update diennuoc set NAMSINH = '"+tfns.getText()+"' where MAVN = '"+tfn.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					if(tfd.getText().length()!=0) {
						int record1 = cn.executeDB("Update diennuoc set TIENNUOC = '"+tfd.getText()+"' where MAVN = '"+tfn.getText()+"'");
						if (record1>0) ;
						else JOptionPane.showMessageDialog(null, "Failed");
					}
					
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				Display();
			}
		});
		
		btnsearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
	     Find();
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
	JFrame fa = new JFrame();
	JTable tbhouse = new JTable();
	JScrollPane ctrl = new JScrollPane(tbhouse);
	JButton btnback = new JButton("Back");
	JButton btncancel = new JButton("Cancel");
	fa.setLocation(200,100);
	
	JPanel pntb = new JPanel();
	ctrl.setPreferredSize(new Dimension(850, 450));
	Border bd2 = BorderFactory.createLineBorder(Color.CYAN);
	TitledBorder tbdll= BorderFactory.createTitledBorder(bd2, "quan ly");
	pntb.setBorder(tbdll);
	pntb.add(ctrl);

	JPanel pnbt = new JPanel();
	pnbt.add(btnback);
	pnbt.add(btncancel);
	Container conttb = fa.getContentPane();
	conttb.add(pntb);
	conttb.add(pnbt, BorderLayout.SOUTH);
	fa.setSize(900,500);
	fa.setVisible(true);
	btncancel.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
				fa.dispose();;
			
			}
	});
	btnback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			new tiennuoc();
			fa.dispose();
			}
		});

ConnectDB con = new ConnectDB();
rs=con.List("Select * from diennuoc");
String column[] = {"Mã vùng nước", "Tên  ","Đia chỉ","Số điện thoại","Năm sinh", "Tiền nước"};
DefaultTableModel tm = new DefaultTableModel (column, 0);


try {
	while (rs.next()) {
		
		Object data[]= {rs.getString("MAVN"), rs.getString("TEN"),rs.getString("DIACHI"),rs.getString("SDT"),rs.getString("NAMSINH"),rs.getString("TIENNUOC")};      
		
		
		
		tm.addRow(data);
	
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
tbhouse.setModel(tm);

}
public static void main(String[] args) {
	// TODO Auto-generated method stub
	new tiennuoc();
}
}
package Controller;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.xpath.XPathException;

import com.toedter.calendar.JDateChooser;

public class Customer  extends JFrame{
	JFrame f = new JFrame();
	JLabel lb = new JLabel("Information");
	JLabel lbcustomer = new JLabel("ID Customer");
	JTextField tfcustomer = new JTextField(10);
	JLabel lbname = new JLabel("Full name");
	JTextField tfname = new JTextField(10);
	JLabel lbaddress = new JLabel("Home Town");
	String[] address = {"An Giang", "Bà rịa – Vũng tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu","Bắc Ninh", "	Bến Tre", "	Bình Định"
, "	Bình Dương", "	Bình Phước", "	Bình Thuận", "	Cà Mau", "	Cần Thơ", "	Cao Bằng ", "	Đà Nẵng", "Đắk Lắk"
, "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội \r\n", "Hà Tĩnh\r\n", "Hải Dương\r\n"
, "Hải Phòng\r\n", "Hậu Giang\r\n", "Hòa Bình\r\n", "Hưng Yên\r\n", "Khánh Hòa\r\n", "Kiên Giang\r\n", "Kon Tum\r\n"
, "Lai Châu\r\n", "Lâm Đồng\r\n", "Lạng Sơn\r\n", "Lào Cai\r\n", "Long An\r\n", "Nam Định\r\n", "Nghệ An\r\n"
, "Ninh Bình\r\n", "Ninh Thuận\r\n", "Phú Thọ\r\n", "Phú Yên\r\n", "Quảng Bình\r\n", "Quảng Nam\r\n", "Quảng Ngãi\r\n"
, "Quảng Ninh\r\n", "Quảng Trị\r\n", "Sóc Trăng\r\n", "Sơn La\r\n", "Tây Ninh\r\n", "Thái Bình\r\n", "Thái Nguyên\r\n"
, "Thanh Hóa\r\n", "Thừa Thiên Huế\r\n", "Tiền Giang\r\n", "Thành phố Hồ Chí Minh\r\n", "Trà Vinh\r\n", "Tuyên Quang\r\n"
, "Vĩnh Long\r\n", "Vĩnh Phúc\r\n", "Yên Bái"};
	JComboBox jcbaddress = new JComboBox(address);
	JLabel lbbirthdayll = new JLabel ("Birthday");
	JDateChooser dcbirthdayll = new JDateChooser();
	JLabel lbsdt = new JLabel("Phone Number");
	JTextField tfsdt = new JTextField(15);
	JLabel lbsearch = new JLabel("🔍Search");
	JButton btnsearch = new JButton("Search");
	JButton btnexit = new JButton("Exit");
	JTextField tfsearch = new JTextField(10);
	JLabel lbtools = new JLabel("Tools");
	JLabel btnMenu = new JLabel("Meuu");
	JButton btnadd = new JButton("Add");
	JButton btnedit = new JButton("Edit");
	JButton btndel  = new JButton("Delete");
	JButton btnback = new JButton("Repair");
	public Customer() {
		JPanel jpnMain = new JPanel();
		jpnMain.setLayout(new BorderLayout());
		jpnMain.setLayout(new GridLayout(1,1));
		jpnMain.setSize(1400,1500);
		f.setLocation(500,200);
		f.setLayout(null);
		lb.setBounds(175,30,500,30);
		lb.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb.setForeground(Color.BLUE);
		//ĐỔI MÀU CHỮ
		f.add(lb);
		lbcustomer.setBounds(40,80,500,30);
		lbcustomer.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(lbcustomer);
		tfcustomer.setBounds(140,85,300,20);
		tfcustomer.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(tfcustomer);
		lbname.setBounds(40,120,500,30);
		lbname.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(lbname);
		 tfname .setBounds(140,125,300,20);
		 tfname .setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(tfname);
		lbaddress.setBounds(40,160,500,30);
		lbaddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(lbaddress);
		jcbaddress.setBounds(140,165,300,20);
		jcbaddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(jcbaddress);
		lbbirthdayll.setBounds(40,200,500,30);
		lbbirthdayll.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(lbbirthdayll);
		dcbirthdayll.setBounds(140,205,300,20);
		dcbirthdayll.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add( dcbirthdayll );
		lbsdt.setBounds(40,240,500,30);
		lbsdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(lbsdt);
		tfsdt.setBounds(140,245,300,20);
		tfsdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(tfsdt);
		   btnadd.setBounds(55,450,80,34);
			btnadd .setFont(new Font("Tahoma", Font.BOLD, 12));
			f.add(btnadd);
			btnedit.setBounds(155,450,65,34);
			btnedit.setFont(new Font("Tahoma", Font.BOLD, 10));
			f.add(btnedit);
			btndel.setBounds(235,450,95,34);
			btndel.setFont(new Font("Tahoma", Font.BOLD, 10));
			f.add(btndel);
			btnback.setBounds(350,450,85,34);
			btnback.setFont(new Font("Tahoma", Font.BOLD, 10));
			f.add(btnback);
			lbsearch.setBounds(60,300,100,30);
			lbsearch.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbsearch.setForeground(Color.RED);
			f.add(lbsearch);
			btnsearch.setBounds(70,350,75,34);
			btnsearch.setFont(new Font("Tahoma", Font.BOLD, 10));
			f.add(btnsearch);
			tfsearch.setBounds(200,355,240,30);
			tfsearch.setFont(new Font("Tahoma", Font.BOLD, 10));
			f.add(tfsearch);
			lbtools.setBounds(60,400,100,30);
			lbtools.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbsearch.setForeground(Color.BLUE);
			f.add(lbtools);
				f.add(btnexit);
				btnback.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						f.dispose();
						new choose();
					}
				});

				f.add(jpnMain);
				
		f.pack();
		f.setSize(1200,700);
		f.setVisible(true);
	
		JPanel jpn2 = new JPanel();
		jpnMain.add(jpn2,BorderLayout.NORTH);
		Border bd = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder bdt2 = BorderFactory.createTitledBorder(bd, "Database ");
		jpn2.setBorder(bdt2);
		//JPanel jp1 = new JPanel();
	//	jp1.setLayout(new FlowLayout(500, 100, 300));
		//jp1.setBounds(1500,420,5000,50);
		DefaultTableModel dm=new DefaultTableModel();
		dm.addColumn("ID customer ");
		dm.addColumn("Full name");
		dm.addColumn("Home town");
		dm.addColumn("Birthday");
		dm.addColumn("Phone number");
		JTable jtb = new JTable(dm);
		dm.addRow(new String[]{"214","Tran Duc Vu","Thua Thien Hue","26/07/2003","0345934782"});
		JScrollPane sc=new JScrollPane(jtb);
		jpn2.add(sc, BorderLayout.SOUTH);
		
		
		
		btnadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				        try {
				

				            }
				         catch (Exception e1) {
				            // TODO Auto-generated catch block
				            e1.printStackTrace();

				        }

				    }
				}	
		);
		
		jtb.addMouseListener(new MouseListener() {

			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			//	int row = jtb.getSelectedRow();
			//	String name = (String) jtb.getValueAt(row, 0);
			//	jtf1.setText(name);
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
		f.add(jpnMain);
	}
	
	
	 
	

	
public static void main(String[] args) {
	// TODO Auto-generated method stub
	new Customer();
}
}

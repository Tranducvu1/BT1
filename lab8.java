package Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class lab8 extends JFrame{ 
	public lab8() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container con = getContentPane();
		
		JPanel jpnMain = new JPanel();
		jpnMain.setLayout(new BorderLayout());
		jpnMain.setLayout(new GridLayout(4,0));
		
		// Panel 
		JPanel jpn1 = new JPanel();
		jpnMain.add(jpn1, BorderLayout.NORTH);
		Border border = BorderFactory.createLineBorder(Color.ORANGE);
		TitledBorder bdt1= BorderFactory.createTitledBorder(border, "Danh sach ");
		jpn1.setBorder(bdt1);
		jpn1.setLayout(new BorderLayout());
		
		
		JPanel leftPanel = new JPanel();
		jpn1.add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new GridLayout(9,1));
		
		JLabel jlb1 = new JLabel(" Ho va ten ");
		leftPanel.add(jlb1);
		JLabel jlb3 = new JLabel("Quê quán  ");
		leftPanel.add(jlb3);
		JLabel jlb2 = new JLabel(" Dia chi  ");
		leftPanel.add(jlb2);
		JLabel jlb4 = new JLabel(" CCCD ");
		leftPanel.add(jlb4);
		JLabel jlb5 = new JLabel(" So tien tro ");
		leftPanel.add(jlb5);
		//JLabel jlb6 = new JLabel(" Diem tin hoc dai cuong  ");
		//leftPanel.add(jlb6);
		//nhap 
		JPanel Center = new JPanel();
		jpn1.add(Center, BorderLayout.CENTER);
		Center.setLayout(new GridLayout(9,1));
		
		JTextField jtf1 = new JTextField(50);
		Center.add(jtf1);
	
		JTextField jtf2 = new JTextField(50);
		String[] h = {"An Giang", "Bà rịa – Vũng tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu","6	Bắc Ninh"
				, "	Bến Tre"
				, "	Bình Định"
				, "	Bình Dương"
				, "	Bình Phước"
				, "	Bình Thuận"
				, "	Cà Mau"
				, "	Cần Thơ"
				, "	Cao Bằng "
				, "	Đà Nẵng"
				, "Đắk Lắk"
				, "Đắk Nông"
				, "Điện Biên"
				, "19	Đồng Nai"
				, "20	Đồng Thápn"
				, "21	Gia Lai"
				, "22	Hà Giang", "23	Hà Nam"
				, "24	Hà Nội \r\n"
				, "25	Hà Tĩnh\r\n"
				, "26	Hải Dương\r\n"
				, "27	Hải Phòng\r\n"
				, "28	Hậu Giang\r\n"
				, "29	Hòa Bình\r\n"
				, "30	Hưng Yên\r\n"
				, "31	Khánh Hòa\r\n"
				, "32	Kiên Giang\r\n"
				, "33	Kon Tum\r\n"
				, "34	Lai Châu\r\n"
				, "35	Lâm Đồng\r\n"
				, "36	Lạng Sơn\r\n"
				, "37	Lào Cai\r\n"
				, "38	Long An\r\n"
				, "39	Nam Định\r\n"
				, "40	Nghệ An\r\n"
				, "41	Ninh Bình\r\n"
				, "42	Ninh Thuận\r\n"
				, "43	Phú Thọ\r\n"
				, "44	Phú Yên\r\n"
				, "45	Quảng Bình\r\n"
				, "46	Quảng Nam\r\n"
				, "47	Quảng Ngãi\r\n"
				, "48	Quảng Ninh\r\n"
				, "49	Quảng Trị\r\n"
				, "50	Sóc Trăng\r\n"
				, "51	Sơn La\r\n"
				, "52	Tây Ninh\r\n"
				, "53	Thái Bình\r\n"
				, "54	Thái Nguyên\r\n"
				, "55	Thanh Hóa\r\n"
				, "56	Thừa Thiên Huế\r\n"
				, "57	Tiền Giang\r\n"
				, "58	Thành phố Hồ Chí Minh\r\n"
				, "59	Trà Vinh\r\n"
				, "60	Tuyên Quang\r\n"
				, "61	Vĩnh Long\r\n"
				, "62	Vĩnh Phúc\r\n"
				, "63	Yên Bái"};
		JComboBox jcb = new JComboBox(h);
		Center.add(jcb);
		Center.add(jtf2);
			
		JPanel rightPanel = new JPanel();
		jpn1.add(rightPanel, BorderLayout.EAST);
		rightPanel.setLayout(new GridLayout(5,0));
		JTextField jtf3 = new JTextField(50);	
		Center.add(jtf3);
		
		JTextField jtf4 = new JTextField(50);
		Center.add(jtf4);
		
		//JTextField jtf6 = new JTextField(50);	
		//Center.add(jtf6);
		
		JLabel b3= new JLabel();
		b3.setVisible(true);
		JLabel b4= new JLabel();
		b4.setVisible(true);
		JLabel b5= new JLabel();
		b5.setVisible(true);
		JLabel b6= new JLabel();
		b5.setVisible(true);
		rightPanel.add(b3);
		rightPanel.add(b4);
		rightPanel.add(b5);
		rightPanel.add(b6);
		JButton jbt1 = new JButton("Them");		
		rightPanel.add(jbt1);
		JButton jbt2 = new JButton("Dong");		
		rightPanel.add(jbt2);
		JButton jbt3 = new JButton("Xoa");		
		rightPanel.add(jbt3);
		JButton jbt4 = new JButton("Tim kiem");		
		rightPanel.add(jbt4);
		jbt1.setSize(50, 50);
		jbt2.setSize(50, 50);
		jbt3.setSize(50, 50);
		JPanel jpn2 = new JPanel();
		jpnMain.add(jpn2,BorderLayout.SOUTH);
		Border bd = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder bdt2 = BorderFactory.createTitledBorder(bd, "Database ");
		jpn2.setBorder(bdt2);
		
		JPanel jp1 = new JPanel();

		jp1.setLayout(new FlowLayout(50, 100, 100));
		DefaultTableModel dm=new DefaultTableModel();
		dm.addColumn("Họ và tên ");
		dm.addColumn("Quê quán ");
		dm.addColumn("Dia chi");
		dm.addColumn("CCCD");
		dm.addColumn("Tien tro");

		
		JTable jtb = new JTable(dm);
		dm.addRow(new String[]{"Trần Đức Vũ","Thừa Thiên Huế","Tứ Hạ","123456789","1.000.000"});
		dm.addRow(new String[]{"Trịnh Công Toàn","Thừa Thiên Huế","Tứ Hạ","123456789","1.000.000"});
		dm.addRow(new String[]{"Dương Đăng Quang","Thừa Thiên Huế","Tứ Hạ","123456789","1.000.000"});
		JScrollPane sc=new JScrollPane(jtb);
		jpn2.add(sc, BorderLayout.CENTER);
		
		
		
		jbt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dm.addRow(new String [] {jtf1.getText(),(String)jcb.getSelectedItem(),jtf2.getText(),jtf3.getText(),jtf4.getText()});				
			}		
		});
		
		jtb.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = jtb.getSelectedRow();
				String name = (String) jtb.getValueAt(row, 0);
				jtf1.setText(name);
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
		jbt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dm.removeRow(getDefaultCloseOperation());				
			}
			
		});
		jbt3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
			}
			
		});
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null );
		
		
		con.add(jpnMain);
		
		
	}		
		public static void main(String agrs[]) throws Exception{
			//Frame frame = new Frame("Bang danh sach");
			//frame.setSize(800, 500);
		lab8 wd = new lab8();
			JPanel pn1 = new JPanel();
			//frame.add(pn1);
			
			//frame.setVisible(true);
			wd.setSize(400,200);
			wd.setLocationRelativeTo(null);
			wd.setVisible(true);
		}
	

		
}


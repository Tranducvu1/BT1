package Controller;
import java.awt.Container;
import java.awt.FlowLayout;
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

public class lanlord  extends JFrame{
	JFrame f = new JFrame();
	//JPanel jpnMain = new JPanel();
	JPanel jpn2 = new JPanel();
	JPanel jpnMain = new JPanel();
	JLabel lb = new JLabel("Information Lanlords");
	JLabel lblanlord = new JLabel("ID lanlord");
	JTextField tflanlord = new JTextField(10);
	JLabel lbname = new JLabel("Full name");
	JTextField tfname = new JTextField(10);
	JLabel lbbirthdayll = new JLabel ("Birthday");
	JDateChooser dcbirthdayll = new JDateChooser();
	JLabel lbsdt = new JLabel("Phone Number");
	JTextField tfsdt = new JTextField(15);
    JButton b1 = new JButton("ID lanlords");
    JButton b2 = new JButton("Full name");
    JButton b3 = new JButton("Birthday");
    JButton b4 = new JButton("Phone Number");
	JButton btnadd = new JButton("Add");
	JButton btnedit = new JButton("Edit");
	JButton btndel  = new JButton("Delete");
	JButton btnback = new JButton("Repair");
	JLabel lbsearch = new JLabel("🔍Search");
	JButton btnsearch = new JButton("Search");
	JButton btnexit = new JButton("Exit");
	JTextField tfsearch = new JTextField(10);
	JLabel lbtools = new JLabel("Tools");
	JLabel btnMenu = new JLabel("Meuu");
	public lanlord() {
		JPanel jpnMain = new JPanel();
		jpnMain.setLayout(new BorderLayout());
		jpnMain.setLayout(new GridLayout(1,1));
		jpnMain.setSize(1400,1500);
		f.setLocation(500,500);
		f.setLayout(null);
		lb.setBounds(175,30,500,30);
		lb.setFont(new Font("Tahoma", Font.BOLD, 20));
		lb.setForeground(Color.BLUE);
				//ĐỔI MÀU CHỮ
		
		f.add(lb);
		lblanlord.setBounds(40,80,500,30);
		lblanlord.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(lblanlord);
		tflanlord.setBounds(140,85,300,20);
		tflanlord.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(tflanlord);
		lbname.setBounds(40,120,500,30);
		lbname.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(lbname);
		 tfname .setBounds(140,125,300,20);
		 tfname .setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(tfname);
		lbbirthdayll.setBounds(40,160,500,30);
		lbbirthdayll.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(lbbirthdayll);
		dcbirthdayll.setBounds(140,165,300,20);
		dcbirthdayll.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(dcbirthdayll);
	    lbsdt.setBounds(40,200,500,20);
		lbsdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add(lbsdt);
        tfsdt.setBounds(140,205,300,20);
		tfsdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		f.add( tfsdt );
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
		//lbsearch.setBounds(360,240,85,34);
		//lbsearch.setFont(new Font("Tahoma", Font.BOLD, 10));
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
		DefaultTableModel dm=new DefaultTableModel();
		dm.addColumn("ID lanlord ");
		dm.addColumn("Full name");
		dm.addColumn("Birthday");
		dm.addColumn("Phone number");
		JTable jtb = new JTable(dm);
		dm.addRow(new String[]{"214 Tran Hung Dao","Tran Duc Vu","26/07/2003","123456789"});
		JScrollPane sc=new JScrollPane(jtb);
		jpn2.add(sc, BorderLayout.SOUTH);
		btnadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	dm.addRow(new String [] {jtf1.getText(),(String)jcb.getSelectedItem(),jtf2.getText(),jtf3.getText(),jtf4.getText()});				
			}		
		});
		
		jtb.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = jtb.getSelectedRow();
				String name = (String) jtb.getValueAt(row, 0);
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
		new lanlord();
	}
}

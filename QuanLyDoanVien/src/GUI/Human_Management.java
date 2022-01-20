package GUI;
import DBManage.ConnectDB;
import DBManage.ConnectDB_HumanManagement;
//  import com.toedter.calendar.JCalendar;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Human_Management extends JFrame {
    JFrame f = new JFrame("Human Management");
    JLabel lbID = new JLabel("ID");
    JTextField tfID = new JTextField(10);
    JLabel lbName = new JLabel("Name");
    JTextField tfName = new JTextField(10);
    JLabel lbBirth = new JLabel("Birthday");
    //  JCalendar calendar = new JCalendar();
//    JTextField tfBirthday = new JTextField(10);
    JLabel lbRate = new JLabel("Rate");
    JTextField tfRate = new JTextField(10);
    JLabel blDep = new JLabel("Department");
    String Depart[] = {"VKU","DTU","DUT"};
    JComboBox cbdepart = new JComboBox(Depart);
    JButton btSignUp = new JButton("SignUp");
    JButton btList = new JButton("List");

    JTable tbEmp;
    PreparedStatement ps;
    Connection conn;
    ResultSet rs;

    public Human_Management() {
        f.setLocation(1200,90);
        f.setLayout(new GridLayout(7,2));
        Container cont =  f.getContentPane();
        cont.add(lbID);
        cont.add(tfID);
        cont.add(lbName);
        cont.add(tfName);
        cont.add(lbBirth);
        //  cont.add(calendar);
//         cont.add(tfBirthday);
        cont.add(lbRate);
        cont.add(tfRate);
        cont.add(blDep);
        cont.add(cbdepart);
        cont.add(btSignUp);
        btSignUp.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
            try {
                //  Date selectedDate = (Date) calendar.getDate();
                //  java.sql.Date birthday = convertUtilToSql(selectedDate);
                ConnectDB_HumanManagement conn = new ConnectDB_HumanManagement();
  //             int record = conn.excuteDB("Insert INTO Employee VALUES('"+tfID.getText()+"','"+tfName.getText()+"','"+tfRate.getText()+"','"+birthday+"','"+cbdepart.getSelectedItem().toString()+"') ");
                // if (record > 0)
                //     JOptionPane.showMessageDialog(null, "Sucessfully!");
                // else
                //     JOptionPane.showMessageDialog(null, "Fail!");
            } catch (Exception e1){
                e1.printStackTrace();
            }
        }
    });
        cont.add(btList);
        btList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListEmployee hs = new ListEmployee();
                f.setVisible(false);
                hs.setVisible(true);
            }
        });
        DisplayAll();
        JScrollPane sp = new JScrollPane(tbEmp);
        cont.add(sp);
        f.add(tbEmp);
        f.pack();
        f.setSize(600,900);
        f.setVisible(true);

    }
    public void DisplayAll() {
        ConnectDB_HumanManagement conn = new ConnectDB_HumanManagement();
        rs = conn.ListHuman("Select * from Employee");
        String column[] = {"Id", "Name"," Birthday"," Rate"," Department"};
        DefaultTableModel tm = new DefaultTableModel (column, 0);
        try {
            while (rs.next()) {
                Object data[]= {rs.getString("Id"), rs.getString("Name"),rs.getString("Birthday"),rs.getString("Rate"), rs.getString("Department")};

                tbEmp = new JTable(tm);
                tm.addRow(data);

            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();

        }

    }
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
    public static void main(String[] args) {
        new Human_Management();
    }
}

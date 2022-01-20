package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import DBManage.ConnectDB;
public class FB_Login extends JFrame  {

        JFrame f = new JFrame("FormDemo");
        JLabel LbUser = new JLabel("Username");
        JTextField tfUserName = new JTextField(10);
        JLabel LbPass = new JLabel("Password");
        JPasswordField tfPassword = new JPasswordField(10);
        // ComboBox
        JLabel lbDepart = new JLabel("Department");
        String[] department = { "VKU", "DUT", "HCMUT", "HUST", "FPT" };
        JComboBox cboDepartment = new JComboBox(department);
        // CheckBox
        JCheckBox cbCS = new JCheckBox("Computer Science");
        JCheckBox cbEconomic = new JCheckBox("Economic");
        JRadioButton rbtMale = new JRadioButton("Male");
        JRadioButton rbtFeMale = new JRadioButton("FeMale");
        ButtonGroup br = new ButtonGroup();
        JButton btnSignUp = new JButton("Insert");
        JButton btnChange = new JButton("Update");
        JButton btnDelete = new JButton("Delete");
        JButton btnList = new JButton("List");
        CardLayout cl = new CardLayout();

        JTable tbAccount;
        PreparedStatement ps;
        Connection conn;
        ResultSet rs;

        public FB_Login() {
            // tao 1 container de add cac component vao
            f.setLocation(300, 300);
            f.setLayout(new GridLayout(7, 2));
            Container cont = f.getContentPane();

            cont.add(LbUser);
            cont.add(tfUserName);
            cont.add(LbPass);
            cont.add(tfPassword);
            br.add(rbtMale);
            br.add(rbtFeMale);
            cont.add(rbtMale);
            cont.add(rbtFeMale);
            cont.add(lbDepart);
            cont.add(cboDepartment);
            cont.add(cbCS);
            cont.add(cbEconomic);

            cont.add(btnSignUp);
            btnSignUp.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ConnectDB cn = new ConnectDB();
                    String gender = "";
                    if (rbtMale.isSelected())
                        gender = rbtMale.getText();
                    else
                        gender = rbtFeMale.getText();
                    String depart = cboDepartment.getSelectedItem().toString();
                    String faculty = "";
                    if (cbCS.isSelected())
                        faculty += cbCS.getText() + ";";
                    if (cbEconomic.isSelected())
                        faculty += cbEconomic.getText();
                    // int record = cn.excuteDB("Insert into NGUOIDUNG values
                    // ('"+tfUserName.getText()+"','"+tfPassword.getText()+"','"+gender+"','"+depart+"','"+faculty+"')");
                    // int record = cn.excuteDB("Insert Into NGUOIDUNG
                    // VALUES('"+tfUserName.getText()+"','"+tfPassword.getText()+"','"+gender+"')");
                    // int record = cn.excuteDB("Exec sp_AddAccount
                    // '"+tfUserName.getText()+"','"+tfPassword.getText()+"','"+gender+"'");
                    // int record = cn.excuteDB("Exec sp_AddAccount2
                    // '"+tfUserName.getText()+"','"+tfPassword.getText()+"','"+gender+"','"+depart+"','"+faculty+"'");
                    conn = cn.connectSQL();
                    try {
                        ps = conn.prepareStatement("Exec sp_AddAccount2 ?,?,?,?,?");
                        ps.setString(1, tfUserName.getText());
                        ps.setString(2, tfPassword.getText());
                        ps.setString(3, gender);
                        ps.setString(4, depart);
                        ps.setString(5, faculty);
                        int record = ps.executeUpdate();
                        if (record > 0)
                            JOptionPane.showMessageDialog(null, "Insert successfully!");
                        else
                            JOptionPane.showMessageDialog(null, "Insert fail!");
                    } catch (Exception e1) {
                        // TODO: handle exception
                        e1.printStackTrace();
                    }
                }
            });

            cont.add(btnChange);
            btnChange.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // ConnectDB cn = new ConnectDB();
                    // int record = cn.excuteDB("Update NGUOIDUNG Set PASSWORD =
                    // '"+tfPassword.getText()+"' WHERE USERNAME = '"+tfUserName.getText()+"'");
                    // if (record > 0) JOptionPane.showMessageDialog(null, "Change password
                    // successfully!");
                    // else JOptionPane.showMessageDialog(null, "Change fail!");
                    ConnectDB cn = new ConnectDB();
                    String gender = "";
                    if (rbtMale.isSelected())
                        gender = rbtMale.getText();
                    else
                        gender = rbtFeMale.getText();
                    String depart = cboDepartment.getSelectedItem().toString();
                    String faculty = "";
                    if (cbCS.isSelected())
                        faculty += cbCS.getText() + ";";
                    if (cbEconomic.isSelected())
                        faculty += cbEconomic.getText();
                    // int record = cn.excuteDB("Exec sp_UPDATEPass
                    // '"+tfUserName.getText()+"','"+tfPassword.getText()+"' ");
                    conn = cn.connectSQL();
                    try {
                        ps = conn.prepareStatement("Exec sp_UPDATE ?,?,?,?,?");
                        ps.setString(1, tfPassword.getText());
                        ps.setString(2, gender);
                        ps.setString(3, depart);
                        ps.setString(4, faculty);
                        ps.setString(5, tfUserName.getText());
                        int record = ps.executeUpdate();
                        if (record > 0)
                            JOptionPane.showMessageDialog(null, "Update sucessfully!");
                        else
                            JOptionPane.showMessageDialog(null, "Update fail!");
                    } catch (Exception e2) {
                        // TODO: handle exception
                        e2.printStackTrace();
                    }

                }
            });
            cont.add(btnDelete);
            btnDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ConnectDB cn = new ConnectDB();
                    // int record = cn.excuteDB("Delete From NGUOIDUNG where USERNAME =
                    // '"+tfUserName.getText()+"'");
                    conn = cn.connectSQL();
                    try {
                        ps = conn.prepareStatement("Exec sp_Delete ?");
                        ps.setString(1, tfUserName.getText());
                        int record = ps.executeUpdate();
                        if (record > 0)
                            JOptionPane.showMessageDialog(null, "Delete successfully!");
                        else
                            JOptionPane.showMessageDialog(null, "Delete fail!");
                    } catch (Exception e3) {
                        // TODO: handle exception
                        e3.printStackTrace();
                    }

                }
            });
            cont.add(btnList);
            btnList.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ConnectDB cn = new ConnectDB();

                    conn = cn.connectSQL();

                     String sql = "CREATE PROCEDURE st_list AS SELECT * FROM Account";
                    try {
                        ps = conn.prepareStatement("Exec sp_Select");
                        ResultSet rs = ps.executeQuery();
                        if (rs != null) {
                            while (rs.next()) {

                                // HIỂN THỊ RA TERMINAL
//                                System.out.println("Username :" + rs.getString("Username"));
//                                System.out.println("Gender :" + rs.getString("Gender"));
//                                System.out.println("Department :" + rs.getString("Department"));
//                                System.out.println("Faculty :" + rs.getString("Faculty"));

//                                 HIỂN THỊ LÊN GIAO DIỆN
                                for (int i = 1; i < 5; i++) {
                                    String username = rs.getString("Username");
                                    tfUserName.setText(username);
                                    String pass = rs.getString("Password");
                                    String gender = rs.getString("Gender");
                                    String department = rs.getString("Department");
                                    String faculty = rs.getString("Faculty");
                                }
                            }
                            rs.close();
                        }
                        ps.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
            DisplayAccount();
            JScrollPane sp = new JScrollPane(tbAccount);
            cont.add(sp);
            f.setSize(200, 200);
            f.pack();
            f.setVisible(true);
        }
        public void DisplayAccount(){
            ConnectDB conn = new ConnectDB();
            rs = conn.ListAccount("Exec sp_Select");
            String title[] = {"Username","Password","Gender","Department","Faculty"};
            DefaultTableModel tm = new DefaultTableModel(title,0);
            try {
                while (rs.next()){
                    Object data[] = {rs.getString("Username"),rs.getString("Password"), rs.getString("Gender"),rs.getString("Department"),rs.getString("Faculty")};
                    tbAccount = new JTable(tm);
                    tm.addRow(data);
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        public static void main(String[] args) {
            new FB_Login();
        }
}

package GUI;

import DBManage.ConnectDB;
import DBManage.ConnectDB_HumanManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListEmployee extends  JFrame {
    JFrame f = new JFrame("List Employee");
    JLabel lbListHign = new JLabel("List of Employees have highest salary");
    JButton btnHuman_Manage = new JButton("Human_Management");
    JTable tbHighSalary;
    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    public ListEmployee() {

        f.setLocation(500,200);
        f.setLayout(new GridLayout(2,1));
        f.add(lbListHign);
        f.add(btnHuman_Manage);
        btnHuman_Manage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Human_Management hm = new Human_Management();
                f.setVisible(false);
                hm.setVisible(true);
            }
        });
        DisplayRate();
        JScrollPane sp = new JScrollPane(tbHighSalary);
        f.add(sp);
        f.setSize(500,500);
        f.setVisible(true);

    }
    public void DisplayRate() {
        ConnectDB_HumanManagement conn = new ConnectDB_HumanManagement();
        rs= conn.ListHuman("SELECT *\r\n"
                + "FROM Employee\r\n"
                + "WHERE Rate = (SELECT MAX(Rate) FROM Employee);");
        String column[] = {"Id", "Name"," Birthday"," Rate"," Department"};
        DefaultTableModel listrate = new DefaultTableModel (column, 0);
        try {
            while (rs.next()) {
                Object data[]= {rs.getString("Id"), rs.getString("Name"),rs.getString("Birthday"),rs.getString("Rate"), rs.getString("Department")};

                tbHighSalary = new JTable(listrate);
                listrate.addRow(data);

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new ListEmployee();
    }
}

package GUI;

import DBManage.ConnectDB_QLDV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Quanhegiadinh extends JFrame {
    JFrame f = new JFrame("Quản lý đoàn viên - QUAN HỆ GIA ĐÌNH");
    JLabel LbQHGD = new JLabel("QUAN HỆ GIA ĐÌNH");
    JLabel LbMADV = new JLabel("Mã đoàn viên");
    JTextField tfMADV = new JTextField(10);

    JLabel LbNull = new JLabel("");
    JLabel LbNull1 = new JLabel("");
    JLabel LbNull2 = new JLabel("");
    JLabel LbNull3 = new JLabel("");
    JLabel LbNull4 = new JLabel("");
    JLabel LbNull5 = new JLabel("");
    JLabel LbNull6 = new JLabel("");
    JLabel LbNull7 = new JLabel("");
    JLabel LbNull8 = new JLabel("");
    JLabel LbNull9 = new JLabel("");
    JLabel LbNull10 = new JLabel("");
    JLabel LbNull11 = new JLabel("");

    JLabel LbHTBo = new JLabel("Họ tên bố");
    JLabel LbNSBo = new JLabel("Năm sinh bố");
    JLabel LbNNBo = new JLabel("Nghề nghiệp bố");
    JLabel LbHTMe = new JLabel("Họ tên mẹ");
    JLabel LbNSMe = new JLabel("Năm sinh mẹ");
    JLabel LbNNMe = new JLabel("Nghề nghiệp mẹ");
    JTextField tfHTBo = new JTextField(10);
    JTextField tfNSBo = new JTextField(10);
    JTextField tfNNBo = new JTextField(10);
    JTextField tfHTMe = new JTextField(10);
    JTextField tfNSMe = new JTextField(10);
    JTextField tfNNMe = new JTextField(10);

    JButton btnAdd = new JButton("Thêm");
    JButton btnUpdate = new JButton("Cập nhật");
    JButton btnDelete = new JButton("Xóa");

    JButton btnDoanvien = new JButton("ĐOÀN VIÊN");
    JButton btnDoanphi = new JButton("ĐOÀN PHÍ");
    JButton btnSearch = new JButton("Tìm kiếm");
//    JButton btnReload = new JButton("Reload");

    JTable tbQHGD;

    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    DefaultTableModel tm;

    private void TaoFrame(){
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocation(470,300);
        f.setSize(1140,400);
//        f.getContentPane().setBackground(new Color(00,00,00, 84));
        f.add(TaoPanel());
        // f.pack();
        f.setVisible(true);
    }
    private JPanel TaoPanel(){
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.add(MaDV_title(), BorderLayout.NORTH);
        panel.add(input(), BorderLayout.WEST);
        panel.add(table(), BorderLayout.CENTER);
        panel.add(button(), BorderLayout.SOUTH);
        return panel;
    }
    private JPanel MaDV_title(){
        JPanel panel = new JPanel(new GridLayout(1,6,1,1));
        panel.add(LbMADV);
        LbMADV.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfMADV);
        panel.add(LbNull);
        panel.add(LbNull1);
        panel.add(LbNull5);
        panel.add(LbQHGD);
        LbQHGD.setFont(new java.awt.Font("Segoe UI", 1, 13));
        panel.add(LbNull2);
        panel.add(LbNull3);
        panel.add(LbNull4);
        return panel;
    }
    private JPanel input(){
        JPanel panel = new JPanel(new GridLayout(7,3,2,2));
        panel.add(LbHTBo);
        LbHTBo.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfHTBo);
        panel.add(LbNull6);
        panel.add(LbNSBo);
        LbNSBo.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfNSBo);
        panel.add(LbNull7);
        panel.add(LbNNBo);
        LbNNBo.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfNNBo);
        panel.add(LbNull8);
        panel.add(LbHTMe);
        LbHTMe.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfHTMe);
        panel.add(LbNull9);
        panel.add(LbNSMe);
        LbNSMe.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfNSMe);
        panel.add(LbNull10);
        panel.add(LbNNMe);
        LbNNMe.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(tfNNMe);
        panel.add(LbNull11);
        panel.add(btnAdd);
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnAdd.setBackground(Color.green);
        btnAdd.setForeground(Color.WHITE);
        panel.add(btnUpdate);
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnUpdate.setBackground(Color.BLUE);
        btnUpdate.setForeground(Color.WHITE);
        panel.add(btnDelete);
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnDelete.setBackground(Color.RED);
        btnDelete.setForeground(Color.WHITE);
        return panel;
    }
    private JPanel table(){
        JPanel panel = new JPanel(new GridLayout(1,1,5,7));
        HienthiQHGD();
        JScrollPane sp = new JScrollPane(tbQHGD);
        panel.add(sp);
        return panel;
    }
    private JPanel button(){
        JPanel panel = new JPanel(new GridLayout(1,3,1,1));
//        panel.add(btnList);
        panel.add(btnDoanvien);
        btnDoanvien.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnDoanphi);
        btnDoanphi.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnSearch);
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12));
//        panel.add(btnReload);
//        btnReload.setFont(new java.awt.Font("Segoe UI", 1, 12));
        return panel;
    }
    public void HienthiQHGD(){
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        rs = cn.DanhsachDoanvien("SELECT * FROM QUANHEGIADINH");
        String column[] = {"Mã ĐV","Họ tên bố","Năm sinh bố","Nghề nghiệp bố","Họ tên mẹ","Năm sinh mẹ","Nghề nghiệp mẹ"};
        tm = new DefaultTableModel(column,0);

        try {
            while (rs.next()){
                Object data[] = {rs.getString("MaDV"),rs.getString("HoTenBo"),rs.getString("NamSinhBo"),rs.getString("NgheNghiepBo"),rs.getString("HoTenMe"),rs.getString("NamSinhMe"),rs.getString("NgheNghiepMe")};
                tm.addRow(data);
                tbQHGD = new JTable(tm);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Quanhegiadinh(){
        TaoFrame();

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
                conn = con_DV.connect_SQL();
                try {
                    ps = conn.prepareStatement("Exec sp_Them_qhgd ?,?,?,?,?,?,?");
                    ps.setString(1, tfMADV.getText());
                    ps.setString(2, tfHTBo.getText());
                    ps.setString(3, tfNSBo.getText());
                    ps.setString(4, tfNNBo.getText());
                    ps.setString(5, tfHTMe.getText());
                    ps.setString(6, tfNSMe.getText());
                    ps.setString(7, tfNNMe.getText());
                    int record = ps.executeUpdate();
                    if (record > 0)
                        JOptionPane.showMessageDialog(null, "Thêm thành công");
                    else
                        JOptionPane.showMessageDialog(null,"Thêm không thành công");
                } catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
                conn = con_DV.connect_SQL();
                try {
                    ps = conn.prepareStatement("Exec sp_Capnhat_qhgd1 ?,?,?,?,?,?,?");
                    ps.setString(1, tfHTBo.getText());
                    ps.setString(2, tfNSBo.getText());
                    ps.setString(3, tfNNBo.getText());
                    ps.setString(4, tfHTMe.getText());
                    ps.setString(5, tfNSMe.getText());
                    ps.setString(6, tfNNMe.getText());
                    ps.setString(7, tfMADV.getText());
                    int record = ps.executeUpdate();
                    if (record > 0)
                        JOptionPane.showMessageDialog(null, "Cập nhật thành công");
                    else
                        JOptionPane.showMessageDialog(null,"Cập nhật không thành công");
                } catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
                conn = con_DV.connect_SQL();
                try {
                    ps = conn.prepareStatement("Exec sp_Xoa_dhgd ?");
                    ps.setString(1, tfMADV.getText());
                    int record = ps.executeUpdate();
                    if (record > 0)
                        JOptionPane.showMessageDialog(null, "Xóa thành công");
                    else
                        JOptionPane.showMessageDialog(null,"Xóa không thành công");
                } catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        btnDoanvien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Doanvien();
                f.setVisible(false);
            }
        });
        btnDoanphi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Doanphi();
                f.setVisible(false);
            }
        });
//        btnReload.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new Quanhegiadinh();
//                f.setVisible(false);
//            }
//        });
    }

    public static void main(String[] args) {
        new Quanhegiadinh();
    }
}

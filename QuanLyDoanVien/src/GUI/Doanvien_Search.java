package GUI;

import DBManage.ConnectDB_QLDV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class Doanvien_Search extends JFrame {

    JFrame f = new JFrame("Quản lý đoàn viên - TÌM KIẾM ĐOÀN VIÊN");

    JLabel LbMaDV = new JLabel("            MaDV");
    JLabel LbMaSV = new JLabel("            MaSV");
    JLabel LbHoten = new JLabel("           Hoten");
    JLabel LbGioitinh = new JLabel("            Gioitinh");
    JLabel LbDiachi = new JLabel("            Diachi");
    JLabel LbTenchidoan = new JLabel("        Tenchidoan");
    JLabel LbNganhhoc = new JLabel("          Nganhhoc");
    JLabel LbChucvu = new JLabel("          Chucvu");

    JTextField tfMaDV = new JTextField(10);
    JTextField tfMaSV = new JTextField(10);
    JTextField tfHoten = new JTextField(10);
    JTextField tfGioitinh = new JTextField(10);
    JTextField tfDiachi = new JTextField(10);
    JTextField tfTenchidoan = new JTextField(10);
    JTextField tfNganhhoc = new JTextField(10);
    JTextField tfChucvu = new JTextField(10);

    JButton btnSearch = new JButton("Tìm kiếm");
    JButton btnDoanvien = new JButton("ĐOÀN VIÊN");
    JButton btnDoanphi = new JButton("ĐOÀN PHÍ");
    JButton btnQHGD = new JButton("QUAN HỆ GIA ĐÌNH");
//    JButton btnReload = new JButton("Reset");

    JTable tbSearch;

    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    private void TaoFrame(){
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocation(500,260);
        f.setSize(1000,450);
        f.add(TaoPanel());
        // f.pack();
        f.setVisible(true);
    }
    private JPanel TaoPanel() {
        JPanel panel = new JPanel(new BorderLayout(11,11));
        panel.add(input(), BorderLayout.NORTH);
        panel.add(table(), BorderLayout.CENTER);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.add(table(), BorderLayout.CENTER);
                panel.revalidate();
            }
        });
        panel.add(button(), BorderLayout.SOUTH);
        return panel;
    }
    private JPanel input(){
        JPanel panel = new JPanel(new GridLayout(2,9,2,2));
        panel.add(LbMaDV);
        LbMaDV.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbMaSV);
        LbMaSV.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbHoten);
        LbHoten.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbGioitinh);
        LbGioitinh.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbDiachi);
        LbDiachi.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbTenchidoan);
        LbTenchidoan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbNganhhoc);
        LbNganhhoc.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(LbChucvu);
        LbChucvu.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnSearch);
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnSearch.setBackground(Color.BLUE);
        btnSearch.setForeground(Color.WHITE);
        panel.add(tfMaDV);
        panel.add(tfMaSV);
        panel.add(tfHoten);
        panel.add(tfGioitinh);
        panel.add(tfDiachi);
        panel.add(tfTenchidoan);
        panel.add(tfNganhhoc);
        panel.add(tfChucvu);
        return panel;
    }
    private JPanel button() {
        JPanel panel = new JPanel(new GridLayout(1,3,2,2));
        panel.add(btnDoanvien);
        btnDoanvien.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnDoanphi);
        btnDoanphi.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnQHGD);
        btnQHGD.setFont(new java.awt.Font("Segoe UI", 1, 12));
//        panel.add(btnReload);
//        btnReload.setFont(new java.awt.Font("Segoe UI", 1, 12));
        return  panel;
    }
    // tạp panel cho table search
    private JPanel table() {
        JPanel panel = new JPanel(new GridLayout(1,1,5,5));
        BangTimkiem();
        JScrollPane sp = new JScrollPane(tbSearch);
        panel.add(sp);
        return  panel;
    }

    public void BangTimkiem()  {
        ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
        String col[] = {"MaDV", "MaSV", "HoTen","Ngaysinh", "Gioitinh","Diachi", "Tenchidoan", "Nganhhoc", "Chucvu"};
        DefaultTableModel tm1 = new DefaultTableModel(col, 0);
        DefaultTableModel tm = new DefaultTableModel(col,0);
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = con_DV.connect_SQL();
            // câu lệnh xem dữ liệu
            String sql = "SELECT * FROM DOANVIEN";
            // Nếu tìm kiếm theo MaDV
            if (tfMaDV.getText().length() > 0){
                sql = sql + " WHERE MADV like '%" + tfMaDV.getText() +"%' ";
            }
//            else if (tfMaDV.getText().length() > 0 && tfMaSV.getText().length() > 0 ){
//                sql = sql + " WHERE MADV like '%" + tfMaDV.getText() +"%' AND MASV like '%" +tfMaSV.getText()+"%' ";
//            }
//            else if (tfMaDV.getText().length() > 0 && tfMaSV.getText().length() > 0 && tfHoten.getText().length() > 0){
//                sql = sql + " WHERE MADV like '%" + tfMaDV.getText() +"%' AND MASV like '%" +tfMaSV.getText()+"%' AND Hoten like '%" +tfHoten.getText()+ "%' ";
//            }
            if (tfMaSV.getText().length() > 0){
                sql = sql + " WHERE MASV like '%" + tfMaSV.getText() +"%' ";
            }
            if (tfHoten.getText().length() > 0){
                sql = sql + " WHERE Hoten like N'%" + tfHoten.getText() +"%' ";
            }
            if (tfGioitinh.getText().length() > 0){
                sql = sql + " WHERE Gioitinh like N'%" + tfGioitinh.getText() +"%' ";
            }
            if (tfDiachi.getText().length() > 0){
                sql = sql + " WHERE Diachi like N'%" + tfDiachi.getText() +"%' ";
            }
            if (tfTenchidoan.getText().length() > 0){
                sql = sql + " WHERE Tenchidoan like '%" + tfTenchidoan.getText() +"%' ";
            }
            if (tfNganhhoc.getText().length() > 0){
                sql = sql + " WHERE Nganhhoc like '%" + tfNganhhoc.getText() +"%' ";
            }
            if (tfChucvu.getText().length() > 0){
                sql = sql + " WHERE Chucvu like N'%" + tfChucvu.getText() +"%' ";
            }
            // tạo đối tượng thực thi câu lệnh SELECT
            st = conn.createStatement();
            // Thực thi
            rs = st.executeQuery(sql);
            Vector data = null;
//            Object data[] = null;
            tm1.setRowCount(0);
            tm.setRowCount(0);
            // Nếu đoàn viên khong tồn tại
            if (rs.isBeforeFirst() ==  false){
                JOptionPane.showMessageDialog(this, "Đoàn viên không tồn tại");
                return;
            }
            // Trong khi chưa hết dữ liệu
            while (rs.next()){
//                data = new Object[]{rs.getString("MaDV")};
                data = new Vector();
                data.add(rs.getString("MaDV"));
                data.add(rs.getString("MaSV"));
                data.add(rs.getString("Hoten"));
                data.add(rs.getString("Ngaysinh"));
                data.add(rs.getString("Gioitinh"));
                data.add(rs.getString("Diachi"));
                data.add(rs.getString("Tenchidoan"));
                data.add(rs.getString("Nganhhoc"));
                data.add(rs.getString("Chucvu"));
                // thêm dòng vào table model
                tm1.addRow(data);
            }
            tbSearch = new JTable();
            tbSearch.setModel(tm1); // thêm dữ liệu vào table
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Doanvien_Search(){
        TaoFrame();
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
        btnQHGD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Quanhegiadinh();
                f.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new Doanvien_Search();
    }
}

package GUI;

import DBManage.ConnectDB_QLDV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doanvien_Table extends JFrame {
    JFrame f = new JFrame("Quản lý đoàn viên");
    JLabel LbBangDV = new JLabel("ĐOÀN VIÊN");
    JTable tbDV;
    JLabel LbBangDP = new JLabel("ĐOÀN PHÍ");
    JTable tbDP;
    JButton btnDoanvien = new JButton("ĐOÀN VIÊN");
    JButton btnDoanphi = new JButton("ĐOÀN PHÍ");
    JButton btnQHGD = new JButton("QUAN HỆ GIA ĐÌNH");

    Connection conn;
    ResultSet rs;
    DefaultTableModel tm;
    public  Doanvien_Table(){
        TaoJFrame();
        btnDoanvien.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Doanvien dv = new Doanvien();
                f.setVisible(false);
//                dv.setVisible(false);
            }
        });
        btnDoanphi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Doanphi dp = new Doanphi();
                f.setVisible(false);
            }
        });
    }
    private void TaoJFrame(){
        f.setLocation(480,250);
        f.setSize(1000,500);
        f.add(TaoJPanel());
        f.setVisible(true);
    }
    private  JPanel TaoJPanel(){
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.add(title_Table(), BorderLayout.NORTH);
        panel.add(button(), BorderLayout.SOUTH);
        return panel;
    }
    private JPanel title_Table(){
        JPanel panel = new JPanel((new GridLayout(4,1,2,2)));
        panel.add(LbBangDV);
        HienthiDoanvien();
        JScrollPane sp = new JScrollPane(tbDV);
        panel.add(sp);
        panel.add(LbBangDP);
        HienthiDoanphi();
        JScrollPane sp1 = new JScrollPane(tbDP);
        panel.add(sp1);
        return panel;
    }
    private JPanel button(){
        JPanel panel = new JPanel((new GridLayout(1,3,1,1)));
        panel.add(btnDoanvien);
        panel.add(btnDoanphi);
        panel.add(btnQHGD);
        return  panel;
    }
    public void HienthiDoanvien(){
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        rs = cn.DanhsachDoanvien("SELECT * FROM DOANVIEN");
        String column[] = {"MaDV","MaSV","Hoten","Ngaysinh","Gioitinh","Diachi","Tenchidoan","Nganhhoc","Chucvu"};
        tm = new DefaultTableModel(column,0);

        try{
            while (rs.next()){
                Object data[] = {rs.getString("MADV"),rs.getString("MASV"),rs.getString("Hoten"),rs.getString("Ngaysinh"),rs.getString("Gioitinh"),rs.getString("Diachi"),rs.getString("Tenchidoan"),rs.getString("Nganhhoc"),rs.getString("Chucvu")};
                tbDV = new JTable(tm);
                tm.addRow(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void HienthiDoanphi(){
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        rs = cn.DanhsachDoanvien("SELECT * FROM DOANPHI");
        String column[] = {"MaDV","Thang1","Thang2","Thang3","Thang4","Thang5","Thang6","Thang7","Thang8","Thang9","Thang10","Thang11","Thang12"};
        tm = new DefaultTableModel(column,0);

        try {
            while (rs.next()){
                Object data[] = {rs.getString("MaDV"),rs.getString("Thang1"),rs.getString("Thang2"),rs.getString("Thang3"),rs.getString("Thang4"),rs.getString("Thang5"),rs.getString("Thang6"),rs.getString("Thang7"),rs.getString("Thang8"),rs.getString("Thang9"),rs.getString("Thang10"),rs.getString("Thang11"),rs.getString("Thang12")};
                tm.addRow(data);
                tbDP = new JTable(tm);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Doanvien_Table();
    }
}

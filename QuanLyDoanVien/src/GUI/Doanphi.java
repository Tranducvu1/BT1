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

public class Doanphi extends JFrame {
    JFrame f = new JFrame("Quáº£n lÃ½ Ä‘oÃ n viÃªn - Ä�OÃ€N PHÃ�");
    JLabel LbDoanphi = new JLabel("Ä�Ã“NG Ä�OÃ€N PHÃ�");
    JLabel LbMADV = new JLabel("MÃ£ Ä‘oÃ n viÃªn");
    JTextField tfMADV = new JTextField(10);

    JLabel LbNull = new JLabel("");
    JLabel LbNull1 = new JLabel("");
    JLabel LbNull2 = new JLabel("");
    JLabel LbNull3 = new JLabel("");
    JLabel LbNull4 = new JLabel("");
    JLabel LbNull5 = new JLabel("");

    JLabel LbT1 = new JLabel("ThÃ¡ng 1");
    JLabel LbT2 = new JLabel("ThÃ¡ng 2");
    JLabel LbT3 = new JLabel("ThÃ¡ng 3");
    JLabel LbT4 = new JLabel("ThÃ¡ng 4");
    JLabel LbT5 = new JLabel("ThÃ¡ng 5");
    JLabel LbT6 = new JLabel("ThÃ¡ng 6");
    JLabel LbT7 = new JLabel("ThÃ¡ng 7");
    JLabel LbT8 = new JLabel("ThÃ¡ng 8");
    JLabel LbT9 = new JLabel("ThÃ¡ng 9");
    JLabel LbT10 = new JLabel("ThÃ¡ng 10");
    JLabel LbT11 = new JLabel("ThÃ¡ng 11");
    JLabel LbT12 = new JLabel("ThÃ¡ng 12");

    JRadioButton rbR1 = new JRadioButton("Rá»“i");
    JRadioButton rbR2 = new JRadioButton("Rá»“i");
    JRadioButton rbR3 = new JRadioButton("Rá»“i");
    JRadioButton rbR4 = new JRadioButton("Rá»“i");
    JRadioButton rbR5 = new JRadioButton("Rá»“i");
    JRadioButton rbR6 = new JRadioButton("Rá»“i");
    JRadioButton rbR7 = new JRadioButton("Rá»“i");
    JRadioButton rbR8 = new JRadioButton("Rá»“i");
    JRadioButton rbR9 = new JRadioButton("Rá»“i");
    JRadioButton rbR10 = new JRadioButton("Rá»“i");
    JRadioButton rbR11 = new JRadioButton("Rá»“i");
    JRadioButton rbR12 = new JRadioButton("Rá»“i");
    JRadioButton rbC1 = new JRadioButton("ChÆ°a");
    JRadioButton rbC2 = new JRadioButton("ChÆ°a");
    JRadioButton rbC3 = new JRadioButton("ChÆ°a");
    JRadioButton rbC4 = new JRadioButton("ChÆ°a");
    JRadioButton rbC5 = new JRadioButton("ChÆ°a");
    JRadioButton rbC6 = new JRadioButton("ChÆ°a");
    JRadioButton rbC7 = new JRadioButton("ChÆ°a");
    JRadioButton rbC8 = new JRadioButton("ChÆ°a");
    JRadioButton rbC9 = new JRadioButton("ChÆ°a");
    JRadioButton rbC10 = new JRadioButton("ChÆ°a");
    JRadioButton rbC11 = new JRadioButton("ChÆ°a");
    JRadioButton rbC12 = new JRadioButton("ChÆ°a");
    ButtonGroup bg1 = new ButtonGroup();
    ButtonGroup bg2 = new ButtonGroup();
    ButtonGroup bg3 = new ButtonGroup();
    ButtonGroup bg4 = new ButtonGroup();
    ButtonGroup bg5 = new ButtonGroup();
    ButtonGroup bg6 = new ButtonGroup();
    ButtonGroup bg7 = new ButtonGroup();
    ButtonGroup bg8 = new ButtonGroup();
    ButtonGroup bg9 = new ButtonGroup();
    ButtonGroup bg10 = new ButtonGroup();
    ButtonGroup bg11 = new ButtonGroup();
    ButtonGroup bg12 = new ButtonGroup();

    JButton btnXN = new JButton("XÃ¡c nháº­n");
    JButton btnUpdate = new JButton("Cáº­p nháº­t");
    JButton btnDelete = new JButton("XÃ³a");
    JButton btnDoanvien = new JButton("Ä�OÃ€N VIÃŠN");
    JButton btnQHGD = new JButton("QUAN Há»† GIA Ä�ÃŒNH");
    JButton btnSearch = new JButton("TÃ¬m kiáº¿m");
//    JButton btnReload = new JButton("Reload");

    JTable tbDoanphi;

    PreparedStatement ps;
    Connection conn;
    ResultSet rs;
    DefaultTableModel tm;
    private void TaoFrame(){
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocation(480,240);
        f.setFont(new java.awt.Font("Segoe UI", 1, 13));
        f.setSize(1000,500);
//        f.getContentPane().setBackground(new Color(00,00,00, 84));
        f.add(TaoPanel());
        // f.pack();
        f.setVisible(true);
    }
    private JPanel TaoPanel(){
        JPanel panel = new JPanel(new BorderLayout(11,11));
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
        panel.add(LbDoanphi);
        LbDoanphi.setFont(new java.awt.Font("Segoe UI", 1, 13));
        panel.add(LbNull2);
        panel.add(LbNull3);
        panel.add(LbNull4);
        return panel;
    }
    private JPanel input(){
        JPanel panel = new JPanel(new GridLayout(13,3,1,1));

        panel.add(LbT1);
        LbT1.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR1);
        rbR1.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC1);
        rbR2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg1.add(rbC1);
        bg1.add(rbR1);
        panel.add(LbT2);
        LbT2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR2);
        rbR2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC2);
        rbC2.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg2.add(rbC2);
        bg2.add(rbR2);
        panel.add(LbT3);
        LbT3.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR3);
        rbR3.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC3);
        rbC3.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg3.add(rbR3);
        bg3.add(rbC3);
        panel.add(LbT4);
        LbT4.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR4);
        rbR4.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC4);
        rbC4.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg4.add(rbR4);
        bg4.add(rbC4);
        panel.add(LbT5);
        LbT5.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR5);
        rbR5.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC5);
        rbC5.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg5.add(rbR5);
        bg5.add(rbC5);
        panel.add(LbT6);
        LbT6.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR6);
        rbR6.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC6);
        rbC6.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg6.add(rbR6);
        bg6.add(rbC6);
        panel.add(LbT7);
        LbT7.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR7);
        rbR7.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC7);
        rbC7.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg7.add(rbR7);
        bg7.add(rbC7);
        panel.add(LbT8);
        LbT8.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR8);
        rbR8.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC8);
        rbC8.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg8.add(rbR8);
        bg8.add(rbC8);
        panel.add(LbT9);
        LbT9.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR9);
        rbR9.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC9);
        rbC9.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg9.add(rbR9);
        bg9.add(rbC9);
        panel.add(LbT10);
        LbT10.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR10);
        rbR10.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC10);
        rbC10.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg10.add(rbR10);
        bg10.add(rbC10);
        panel.add(LbT11);
        LbT11.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR11);
        rbR11.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC11);
        rbC11.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg11.add(rbR11);
        bg11.add(rbC11);
        panel.add(LbT12);
        LbT12.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbR12);
        rbR12.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(rbC12);
        rbC12.setFont(new java.awt.Font("Segoe UI", 1, 12));
        bg12.add(rbR12);
        bg12.add(rbC12);
        panel.add(btnXN);
        btnXN.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnXN.setBackground(Color.green);
        btnXN.setForeground(Color.WHITE);
        panel.add(btnUpdate);
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12));
        btnUpdate.setBackground(Color.BLUE);
        btnUpdate.setForeground(Color.WHITE);
        panel.add(btnDelete);
        btnDelete.setBackground(Color.RED);
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12));

        return panel;
    }
    private JPanel table(){
        JPanel panel = new JPanel(new GridLayout(1,1,5,7));
        HienthiDoanphi();
        JScrollPane sp = new JScrollPane(tbDoanphi);
        panel.add(sp);
        return panel;
    }
    private JPanel button(){
        JPanel panel = new JPanel(new GridLayout(1,3,1,1));
//        panel.add(btnList);
        panel.add(btnDoanvien);
        btnDoanvien.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnQHGD);
        btnQHGD.setFont(new java.awt.Font("Segoe UI", 1, 12));
        panel.add(btnSearch);
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12));
//        panel.add(btnReload);
 //       btnReload.setFont(new java.awt.Font("Segoe UI", 1, 12));
        return panel;
    }
    public void HienthiDoanphi(){
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        rs = cn.DanhsachDoanvien("SELECT * FROM DOANPHI");
        String column[] = {"MÃ£ Ä�V","ThÃ¡ng1","ThÃ¡ng2","ThÃ¡ng3","ThÃ¡ng4","ThÃ¡ng5","ThÃ¡ng6","ThÃ¡ng7","ThÃ¡ng8","ThÃ¡ng9","ThÃ¡ng10","ThÃ¡ng11","ThÃ¡ng12"};
        tm = new DefaultTableModel(column,0);

        try {
            while (rs.next()){
                Object data[] = {rs.getString("MaDV"),rs.getString("Thang1"),rs.getString("Thang2"),rs.getString("Thang3"),rs.getString("Thang4"),rs.getString("Thang5"),rs.getString("Thang6"),rs.getString("Thang7"),rs.getString("Thang8"),rs.getString("Thang9"),rs.getString("Thang10"),rs.getString("Thang11"),rs.getString("Thang12")};
                tm.addRow(data);
                tbDoanphi = new JTable(tm);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public  Doanphi(){
        TaoFrame();
        btnXN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
                String thang1 ="";
                if (rbR1.isSelected())
                    thang1 = rbR1.getText();
                else
                    thang1 = rbC1.getText();
                String thang2 ="";
                if (rbR2.isSelected())
                    thang2 = rbR2.getText();
                else
                    thang2 = rbC2.getText();
                String thang3 ="";
                if (rbR3.isSelected())
                    thang3 = rbR3.getText();
                else
                    thang3 = rbC3.getText();
                String thang4 ="";
                if (rbR4.isSelected())
                    thang4 = rbR4.getText();
                else
                    thang4 = rbC4.getText();
                String thang5 ="";
                if (rbR5.isSelected())
                    thang5 = rbR5.getText();
                else
                    thang5 = rbC5.getText();
                String thang6 ="";
                if (rbR6.isSelected())
                    thang6 = rbR6.getText();
                else
                    thang6 = rbC6.getText();
                String thang7 ="";
                if (rbR7.isSelected())
                    thang7 = rbR7.getText();
                else
                    thang7 = rbC7.getText();
                String thang8 ="";
                if (rbR8.isSelected())
                    thang8 = rbR8.getText();
                else
                    thang8 = rbC8.getText();
                String thang9 ="";
                if (rbR9.isSelected())
                    thang9 = rbR9.getText();
                else
                    thang9 = rbC9.getText();
                String thang10 ="";
                if (rbR10.isSelected())
                    thang10 = rbR10.getText();
                else
                    thang10 = rbC10.getText();
                String thang11 ="";
                if (rbR11.isSelected())
                    thang11 = rbR11.getText();
                else
                    thang11 = rbC11.getText();
                String thang12 ="";
                if (rbR12.isSelected())
                    thang12 = rbR12.getText();
                else
                    thang12 = rbC12.getText();
                conn = con_DV.connect_SQL();
                try {
                    ps = conn.prepareStatement("Exec sp_Them_Doanphi ?,?,?,?,?,?,?,?,?,?,?,?,?");
                    ps.setString(1, tfMADV.getText());
                    ps.setString(2, thang1);
                    ps.setString(3, thang2);
                    ps.setString(4, thang3);
                    ps.setString(5, thang4);
                    ps.setString(6, thang5);
                    ps.setString(7, thang6);
                    ps.setString(8, thang7);
                    ps.setString(9, thang8);
                    ps.setString(10, thang9);
                    ps.setString(11, thang10);
                    ps.setString(12, thang11);
                    ps.setString(13, thang12);
                    int record = ps.executeUpdate();
                    if (record > 0)
                        JOptionPane.showMessageDialog(null, "ThÃªm thÃ nh cÃ´ng");
                    else
                        JOptionPane.showMessageDialog(null,"ThÃªm khÃ´ng thÃ nh cÃ´ng");
                } catch (Exception e1){
                    e1.printStackTrace();
                }
                new Doanphi();
                f.setVisible(false);
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
                String thang1 ="";if (rbR1.isSelected())
                    thang1 = rbR1.getText();
                else
                    thang1 = rbC1.getText();
                String thang2 ="";
                if (rbR2.isSelected())
                    thang2 = rbR2.getText();
                else
                    thang2 = rbC2.getText();
                String thang3 ="";
                if (rbR3.isSelected())
                    thang3 = rbR3.getText();
                else
                    thang3 = rbC3.getText();
                String thang4 ="";
                if (rbR4.isSelected())
                    thang4 = rbR4.getText();
                else
                    thang4 = rbC4.getText();
                String thang5 ="";
                if (rbR5.isSelected())
                    thang5 = rbR5.getText();
                else
                    thang5 = rbC5.getText();
                String thang6 ="";
                if (rbR6.isSelected())
                    thang6 = rbR6.getText();
                else
                    thang6 = rbC6.getText();
                String thang7 ="";
                if (rbR7.isSelected())
                    thang7 = rbR7.getText();
                else
                    thang7 = rbC7.getText();
                String thang8 ="";
                if (rbR8.isSelected())
                    thang8 = rbR8.getText();
                else
                    thang8 = rbC8.getText();
                String thang9 ="";
                if (rbR9.isSelected())
                    thang9 = rbR9.getText();
                else
                    thang9 = rbC9.getText();
                String thang10 ="";
                if (rbR10.isSelected())
                    thang10 = rbR10.getText();
                else
                    thang10 = rbC10.getText();
                String thang11 ="";
                if (rbR11.isSelected())
                    thang11 = rbR11.getText();
                else
                    thang11 = rbC11.getText();
                String thang12 ="";
                if (rbR12.isSelected())
                    thang12 = rbR12.getText();
                else
                    thang12 = rbC12.getText();
                conn = con_DV.connect_SQL();
                try {
                    ps = conn.prepareStatement("Exec sp_Capnhat_Doanphi1 ?,?,?,?,?,?,?,?,?,?,?,?,?");
                    ps.setString(1, thang1);
                    ps.setString(2, thang2);
                    ps.setString(3, thang3);
                    ps.setString(4, thang4);
                    ps.setString(5, thang5);
                    ps.setString(6, thang6);
                    ps.setString(7, thang7);
                    ps.setString(8, thang8);
                    ps.setString(9, thang9);
                    ps.setString(10, thang10);
                    ps.setString(11, thang11);
                    ps.setString(12, thang12);
                    ps.setString(13, tfMADV.getText());
                    int record = ps.executeUpdate();
                    if (record > 0)
                        JOptionPane.showMessageDialog(null, "Cáº­p nháº­t thÃ nh cÃ´ng");
                    else
                        JOptionPane.showMessageDialog(null,"Cáº­p nháº­t khÃ´ng thÃ nh cÃ´ng");
                } catch (Exception e1){
                    e1.printStackTrace();
                }
                new Doanphi();
                f.setVisible(false);
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
                conn = con_DV.connect_SQL();
                try {
                    ps = conn.prepareStatement("Exec sp_Xoa_Doanphi ?");
                    ps.setString(1, tfMADV.getText());
                    int record = ps.executeUpdate();
                    if (record > 0)
                        JOptionPane.showMessageDialog(null, "XÃ³a thÃ nh cÃ´ng");
                    else
                        JOptionPane.showMessageDialog(null,"XÃ³a khÃ´ng thÃ nh cÃ´ng");
                } catch (Exception e1){
                    e1.printStackTrace();
                }
                new Doanphi();
                f.setVisible(false);
            }
        });
        btnDoanvien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Doanvien();
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
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
//        btnReload.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
    }
    public static void main(String[] args) {
        new Doanphi();
    }
}

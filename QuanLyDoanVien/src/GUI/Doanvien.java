package GUI;

import DBManage.ConnectDB_QLDV;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Doanvien extends  JFrame{
        JFrame f = new JFrame("Quản lý đoàn viên - ĐOÀN VIÊN");
        JLabel LbQLDV = new JLabel("THÔNG TIN ĐOÀN VIÊN", SwingConstants.CENTER);

//        JLabel LbDoanvien = new JLabel("ĐOÀN VIÊN");
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

        JLabel LbMADV = new JLabel("    Mã đoàn viên");
        JTextField tfMADV = new JTextField(10);

        JLabel LbMASV = new JLabel("    Mã sinh viên");
        JTextField tfMASV = new JTextField(10);

        JLabel LbHoten = new JLabel("    Họ và tên");
        JTextField tfHoten = new JTextField(10);

        JLabel LbNgaysinh = new JLabel("    Ngày sinh");
        JTextField tfNgaysinh = new JTextField(10);

        JLabel LbGioitinh = new JLabel("    Giới tính");
        JRadioButton rbtnNam = new JRadioButton("Nam");
        JRadioButton rbtnNu = new JRadioButton("Nữ");
        ButtonGroup bG = new ButtonGroup();

        JLabel LbDiachi = new JLabel("    Địa chỉ");
        JTextField tfDiachi = new JTextField(10);

        JLabel LbTenchidoan = new JLabel("    Tên chi đoàn");
        JTextField tfTenchidoan = new JTextField(10);

        JLabel LbNganhhoc = new JLabel("    Ngành học");
        JCheckBox cbCNTT = new JCheckBox("CNTT");
        JCheckBox cbKinhte = new JCheckBox("Kinh tế");

        JLabel LbChucvu = new JLabel("    Chức vụ");
        String[] chucvu = {"Không","Bí thư chi đoàn","Phó bí thư"};
        JComboBox cboChucvu = new JComboBox(chucvu);

        JButton btnAdd = new JButton("Thêm");
        JButton btnUpdate = new JButton("Cập nhật");
        JButton btnDelete = new JButton("Xóa");

//        JButton btnDanhsach = new JButton("Danh sách");
        JButton btnDoanphi = new JButton("ĐOÀN PHÍ");
        JButton btnQHGD = new JButton("QUAN HỆ GIA ĐÌNH");
        JButton btnSearch = new JButton("Tìm kiếm");
        JButton btnReload = new JButton("Reload");

        JTable tbDoanvien;

        PreparedStatement ps;
        Connection conn = null;
        ResultSet rs;
        DefaultTableModel tm;

        private void TaoFrame(){
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setLocation(360,230);
            f.setSize(1300,500);
            f.add(TaoPanel());
           // f.pack();
            f.setVisible(true);
        }
        private JPanel TaoPanel() {
            JPanel panel = new JPanel(new BorderLayout(11,11));
            panel.add(title(),   BorderLayout.NORTH);
            panel.add(input(), BorderLayout.WEST);
            panel.add(table(), BorderLayout.CENTER);
            panel.add(button_QLDV(), BorderLayout.SOUTH);
            btnAdd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Them_DV();
                    panel.add(table(), BorderLayout.CENTER);
                    panel.revalidate();
                }
            });
            btnUpdate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Capnhat_DV();
                    panel.add(table(), BorderLayout.CENTER);
                    panel.revalidate();
                }
            });
            btnDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Xoa_DV();
                    panel.add(table(), BorderLayout.CENTER);
                    panel.revalidate();
                }
            });
            return panel;
        }
        private JPanel title(){
            JPanel panel = new JPanel(new GridLayout(1,3,1,1));
            panel.add(LbNull);
            panel.add(LbQLDV);
            LbQLDV.setFont(new java.awt.Font("Segoe UI", 1, 13));
            panel.add(LbNull1);
            // LbQLDV.setFont(new java.awt.Font("Segoe UI", 1, 13));
            return panel;
        }
        private JPanel input(){
            JPanel panel = new JPanel(new GridLayout(10,3,3,3));
            panel.add(LbMADV);
            LbMADV.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(tfMADV);
            panel.add(LbNull4);
            panel.add(LbMASV);
            LbMASV.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(tfMASV);
            panel.add(LbNull5);
            panel.add(LbHoten);
            LbHoten.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(tfHoten);
            panel.add(LbNull6);
            panel.add(LbNgaysinh);
            LbNgaysinh.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(tfNgaysinh);
            panel.add(LbNull7);
            panel.add(LbGioitinh);
            LbGioitinh.setFont(new java.awt.Font("Segoe UI", 1, 12));
            bG.add(rbtnNam);
            bG.add(rbtnNu);
            panel.add(rbtnNam);
            rbtnNam.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(rbtnNu);
            rbtnNu.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(LbDiachi);
            LbDiachi.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(tfDiachi);
            panel.add(LbNull8);
            panel.add(LbTenchidoan);
            LbTenchidoan.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(tfTenchidoan);
            panel.add(LbNull9);
            panel.add(LbNganhhoc);
            LbNganhhoc.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(cbCNTT);
            cbCNTT.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(cbKinhte);
            cbKinhte.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(LbChucvu);
            LbChucvu.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(cboChucvu);
            cboChucvu.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(LbNull10);
            panel.add(btnAdd);
            btnAdd.setBackground(Color.green);
            btnAdd.setForeground(Color.WHITE);
            btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(btnUpdate);
            btnUpdate.setBackground(Color.BLUE);
            btnUpdate.setForeground(Color.WHITE);
            btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12));
            panel.add(btnDelete);
            btnDelete.setBackground(Color.RED);
            btnDelete.setForeground(Color.WHITE);
            btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12));

            return panel;
        }
        public JPanel button_QLDV(){
            JPanel panel = new JPanel(new GridLayout(1,3,2,2));
//            panel.add(btnDanhsach);
            panel.add(btnDoanphi);
            btnDoanphi.setFont(new java.awt.Font("Segoe UI", 1, 12));
//            btnDoanphi.setBackground(Color.RED);
//            btnDoanphi.setForeground(Color.WHITE);
            panel.add(btnQHGD);
            btnQHGD.setFont(new java.awt.Font("Segoe UI", 1, 12));
//            btnQHGD.setBackground(new Color(255, 222, 0, 182));
//            btnQHGD.setForeground(Color.WHITE);
            panel.add(btnSearch);
            btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 12));
//            btnSearch.setBackground(Color.BLUE);
//            btnSearch.setForeground(Color.WHITE);
//            panel.add(btnReload);
//            btnReload.setFont(new java.awt.Font("Segoe UI", 1, 12));
//            btnReload.setBackground(Color.GREEN);
//            btnReload.setForeground(Color.WHITE);
            return panel;
        }
        public JPanel table() {
            JPanel panel = new JPanel(new GridLayout(1,1,5,5));
            HienthiDoanvien();
            JScrollPane sp = new JScrollPane(tbDoanvien);
            panel.add(sp);
            sp.setFont(new java.awt.Font("Segoe UI", 1, 12));
            return panel;
        }
    public void HienthiDoanvien() {
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        rs = cn.DanhsachDoanvien("SELECT * FROM DOANVIEN");
        String[] column = {"MaDV","MaSV","Hoten","Ngaysinh","Gioitinh","Diachi","Tenchidoan","Nganhhoc","Chucvu"};
        tm = new DefaultTableModel(column,0);
//        tm.setColumnIdentifiers(column);
        try{
            while (rs.next()){
                Object data[] = {rs.getString("MADV"),rs.getString("MASV"),rs.getString("Hoten"),rs.getString("Ngaysinh"),rs.getString("Gioitinh"),rs.getString("Diachi"),rs.getString("Tenchidoan"),rs.getString("Nganhhoc"),rs.getString("Chucvu")};
                tbDoanvien = new JTable(tm);
//                tbDoanvien.setFont(new java.awt.Font("Arial", 1, 12));
                tm.addRow(data);
            }
        } catch (SQLException e){
            e.printStackTrace();
          }
    }
    public void Them_DV() {
        ConnectDB_QLDV con_DV = new ConnectDB_QLDV();
        String gioitinh = "";
        if (rbtnNam.isSelected())
            gioitinh = rbtnNam.getText();
        else
            gioitinh = rbtnNu.getText();

        String nganhhoc = "";
        if (cbCNTT.isSelected())
            nganhhoc += cbCNTT.getText() + ";";
        if (cbKinhte.isSelected())
            nganhhoc += cbKinhte.getText();

        String chucvu = cboChucvu.getSelectedItem().toString();

        String ngaysinh = tfNgaysinh.getText();
        Date date = Date.valueOf(ngaysinh);

        conn = con_DV.connect_SQL();
        try {
            ps = conn.prepareStatement("Exec sp_ThemDoanvien ?,?,?,?,?,?,?,?,?");
            ps.setString(1, tfMADV.getText());
            ps.setString(2, tfMASV.getText());
            ps.setString(3, tfHoten.getText());
            ps.setString(4, String.valueOf(date));
            ps.setString(5, gioitinh);
            ps.setString(6, tfDiachi.getText());
            ps.setString(7, tfTenchidoan.getText());
            ps.setString(8, nganhhoc);
            ps.setString(9, chucvu);
            int record = ps.executeUpdate();
//                    if (record > 0)
//                        JOptionPane.showMessageDialog(null, "Thêm thành công");
//                    else
//                        JOptionPane.showMessageDialog(null,"Thêm không thành công");
        } catch (Exception e2){
            e2.printStackTrace();
        }
    }
    public void Capnhat_DV() {
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        String gioitinh = "";
        if (rbtnNam.isSelected())
            gioitinh = rbtnNam.getText();
        else
            gioitinh = rbtnNu.getText();

        String nganhhoc = "";
        if (cbCNTT.isSelected())
            nganhhoc += cbCNTT.getText() + ";";
        if (cbKinhte.isSelected())
            nganhhoc += cbKinhte.getText();

        String chucvu = cboChucvu.getSelectedItem().toString();

        String ngaysinh = tfNgaysinh.getText();
        Date date = Date.valueOf(ngaysinh);

        conn = cn.connect_SQL();
        try {
            ps = conn.prepareStatement("Exec sp_Update_Dv1 ?,?,?,?,?,?,?,?,?");
            ps.setString(1, tfMASV.getText());
            ps.setString(2, tfHoten.getText());
            ps.setString(3, String.valueOf(date));
            ps.setString(4, gioitinh);
            ps.setString(5, tfDiachi.getText());
            ps.setString(6, tfTenchidoan.getText());
            ps.setString(7, nganhhoc);
            ps.setString(8, chucvu);
            ps.setString(9, tfMADV.getText());
            int record = ps.executeUpdate();
//                    if (record > 0)
//                        JOptionPane.showMessageDialog(null, "Cập nhật thành công");
//                    else
//                        JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
    public void Xoa_DV() {
        ConnectDB_QLDV cn = new ConnectDB_QLDV();
        conn = cn.connect_SQL();
        try {
            ps = conn.prepareStatement("Exec sp_Delete_Dv ?");
            ps.setString(1, tfMADV.getText());
            int record = ps.executeUpdate();
//                    if (record > 0)
//                        JOptionPane.showMessageDialog(null, "Xóa thành công");
//                    else
//                        JOptionPane.showMessageDialog(null, "Xóa không thành công");
        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public Doanvien() {
        TaoFrame();


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
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Doanvien_Search();
                f.setVisible(false);
            }
        });
//        btnReload.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                dv.setVisible(false);
//            }
//        });

    }
        public static void main(String[] args) {
            new Doanvien();
        }
    }
//
////
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
// */
//package GUI;
//
//        import javax.swing.table.DefaultTableModel;
//        import java.sql.*;
//        import java.util.Vector;
//
//public class SearchForm extends javax.swing.JFrame {
//
//
//    public SearchForm() {
//        initComponents();
//    }
//    public void loadData(int thutu ,String tdn){
//
//        try {
//
//            Connect a = new Connect();
//            Connection conn = a.getConnection();
//            int number;
//            Statement st = conn.createStatement();
//            ResultSet rs = null;
//            String column = thutu == 1 ? " TenDangNhap ":" Pass ";
//            System.out.print(column);
//            rs = st.executeQuery(String.format("Select * from account where %s = '%s'",column,tdn));
//            ResultSetMetaData metaData = rs.getMetaData();
//            number = metaData.getColumnCount(); // tra ve so cot
//
//            while(rs.next()) {
//                for (int i = 1; i <= number; i++){
//                    System.out.println(rs.getString(i));
//                }
//            }
//            System.out.println(number);
//
//
//        } catch (Exception e) {
//            System.out.println(e.toString());
//        }
//    }
//
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">
//    private void initComponents() {
//
//        jTextField1 = new javax.swing.JTextField();
//        jButton1 = new javax.swing.JButton();
//        jTextField2 = new javax.swing.JTextField();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        jButton1.setText("Search");
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton1ActionPerformed(evt);
//            }
//        });
//
//        jTextField2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jTextField2ActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGap(33, 33, 33)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
//                                        .addComponent(jTextField1))
//                                .addGap(28, 28, 28)
//                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(70, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addGap(51, 51, 51)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addGap(26, 26, 26)
//                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addContainerGap(102, Short.MAX_VALUE))
//        );
//
//        pack();
//    }// </editor-fold>
//
//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
//        if (jTextField1.getText().length()>0)
//            loadData(1,jTextField1.getText());
//        else loadData(2,jTextField2.getText());
//    }
//
//    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
//        // TODO add your handling code here:
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SearchForm().setVisible(true);
//            }
//        });
//    }
//
//    // Variables declaration - do not modify
//    private javax.swing.JButton jButton1;
//    private javax.swing.JTextField jTextField1;
//    private javax.swing.JTextField jTextField2;
//    // End of variables declaration
//}
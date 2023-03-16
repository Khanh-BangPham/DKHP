
package views.NhanVienPDT;
import dao.*;
import entity.*;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sqlserver_connection.ConnectionHelper;
import utils.Weekdays;
/**
 *
 * @author PC
 */
public class LopTinChiView extends javax.swing.JPanel {
    private int manhom = 0;
    /**
     * Creates new form LopTinChiView
     */
    public void fillDataTable(List<LopTinChi> listltc){        
        DayLopDAO dldao = new DayLopDAO();
        GiangVienDAO gvdao = new GiangVienDAO();
        MonHocDAO mhdao = new MonHocDAO();
        int i = 1;
        DefaultTableModel model = (DefaultTableModel) tableLopTinChi.getModel();
        model.setRowCount(0);
        for(LopTinChi ltc : listltc){
            Object dataRow[] = new Object[12];
            dataRow[0] = i++;
            dataRow[1] = ltc.getMaLopTinChi();
            dataRow[2] = mhdao.getMonHocByID(ltc.getMaMonHoc()).getTenMonhoc();
            String data = "";
            int length = dldao.getListDayLopByMaLTC(ltc.getMaLopTinChi()).size();

            for(int index = 0; index < length; index++){            
                GiangVien gv = gvdao.getGiangVienByID(dldao.getListDayLopByMaLTC(ltc.getMaLopTinChi()).get(index).getMaGV());
                data = data + (gv.getHo() + " " + (gv.getTenDem() == null ? "" : gv.getTenDem()) + " " + gv.getTen()) + "; ";
            }
            dataRow[3] = data;
            dataRow[4] = ltc.getNamHoc();
            dataRow[5] = ltc.getHocKy();
            dataRow[6] = ltc.getThu();
            dataRow[7] = ltc.getTietBatDau();
            dataRow[8] = ltc.getPhong();
            dataRow[9] = ltc.getNgayBD();
            dataRow[10] = ltc.getNgayKT();
            dataRow[11] = ltc.getSoNhomTH();

            model.addRow(dataRow);
        }
        model.fireTableDataChanged();
    }
    public void fillComboBoxNamHoc(){
        NamHocDAO nhdao = new NamHocDAO();
        List<NamHoc> listnh = nhdao.getListNamHoc();
        comboNamHoc.removeAllItems();
        comboNamHoc.addItem("Năm Học");
        for(NamHoc nh : listnh){
            String elm = nh.getTenNamHoc();
            comboNamHoc.addItem(elm);
        }
    }
    public void fillComboBoxHocKy(){
        HocKyDAO hkdao = new HocKyDAO();
        List<HocKy> listhk = hkdao.getListHocKy();
        comboBoxHocKy.removeAllItems();
        comboBoxHocKy.addItem("Học Kỳ");
        for(HocKy hk : listhk){
            String elm = hk.getHocKy();
            comboBoxHocKy.addItem(elm);
        }
    }   
    public void fillComboBoxMonHoc(){
        MonHocDAO mhdao = new MonHocDAO();
        List<MonHoc> listmh = mhdao.getListMonHoc();
        comboBoxMonHoc.removeAllItems();
        comboBoxMonHoc.addItem("Môn học");
        for(MonHoc mh : listmh){
            String elm = mh.getTenMonhoc();
            comboBoxMonHoc.addItem(elm);
        }
    } 
    public void fillComboBoxGiangVien1(){
        GiangVienDAO gvdao = new GiangVienDAO();
        List<GiangVien> listgv = gvdao.getListGiangVien();
        comboBoxGiangVien1.removeAllItems();
        comboBoxGiangVien1.addItem("Giảng viên 1");
        for(GiangVien gv : listgv){
            String elm = gv.getHo() + " " + (gv.getTenDem() == null ? "" : gv.getTenDem()) + " " + gv.getTen();
            comboBoxGiangVien1.addItem(elm);
        }
    } 
    public void fillComboBoxGiangVien2(){
        GiangVienDAO gvdao = new GiangVienDAO();
        List<GiangVien> listgv = gvdao.getListGiangVien();
        comboBoxGiangVien2.removeAllItems();
        comboBoxGiangVien2.addItem("Giảng viên 2");
        for(GiangVien gv : listgv){
            String elm = gv.getHo() + " " + (gv.getTenDem() == null ? "" : gv.getTenDem()) + " " + gv.getTen();
            comboBoxGiangVien2.addItem(elm);
        }
    } 
    public void fillComboBoxSoNhomTH(){
        NhomDAO nhomdao = new NhomDAO();
        comboBoxSoNhomTH.removeAllItems();
        comboBoxSoNhomTH.addItem("Số Nhóm Thực Hành");
        for(int i = 1; i < nhomdao.getListNhom().size(); i++){
            comboBoxSoNhomTH.addItem(Integer.toString(i));
        }
    }  
    public void fillComboBoxThu(){
        Weekdays weekdays = new Weekdays();
        comboBoxThu.removeAllItems();
        comboBoxThu.addItem("Thứ trong tuần");
        for(String wd: weekdays.getWeekdays()){
            comboBoxThu.addItem(wd);
        }
    }     
    public void fillComboBoxThu1(){
        Weekdays weekdays = new Weekdays();
        comboBoxThu1.removeAllItems();
        comboBoxThu1.addItem("Thứ trong tuần");
        for(String wd: weekdays.getWeekdays()){
            comboBoxThu1.addItem(wd);
        }
    } 
    public LopTinChiView() {
        LopTinChiDAO ltcdao = new LopTinChiDAO();
        initComponents();
        fillComboBoxNamHoc();
        fillComboBoxHocKy();
        fillComboBoxMonHoc();
        fillComboBoxGiangVien1();
        fillComboBoxGiangVien2();
        fillComboBoxSoNhomTH();
        fillComboBoxThu();
        fillComboBoxThu1();
        fillDataTable(ltcdao.getListLopTinChi());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogNhom1 = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        txtNgayKetThuc1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtPhong1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtSlgtd = new javax.swing.JTextField();
        comboBoxThu1 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSaveNhom = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtNgayBatDau2 = new javax.swing.JTextField();
        txtTietBD2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNgayKetThuc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboNamHoc = new javax.swing.JComboBox<>();
        comboBoxHocKy = new javax.swing.JComboBox<>();
        txtMaLTC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPhong = new javax.swing.JTextField();
        txtNgayBatDau = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTietBD = new javax.swing.JTextField();
        comboBoxThu = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        comboBoxSoNhomTH = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        comboBoxGiangVien1 = new javax.swing.JComboBox<>();
        comboBoxMonHoc = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboBoxGiangVien2 = new javax.swing.JComboBox<>();
        btnNhom1 = new javax.swing.JButton();
        btnNhom2 = new javax.swing.JButton();
        btnNhom3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLopTinChi = new javax.swing.JTable();

        jDialogNhom1.setSize(new java.awt.Dimension(500, 450));

        jPanel6.setLayout(null);

        txtNgayKetThuc1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayKetThuc1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNgayKetThuc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayKetThuc1ActionPerformed(evt);
            }
        });
        jPanel6.add(txtNgayKetThuc1);
        txtNgayKetThuc1.setBounds(290, 60, 110, 40);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Thứ trong tuần");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(10, 130, 90, 40);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Phòng");
        jPanel6.add(jLabel18);
        jLabel18.setBounds(220, 200, 80, 40);

        txtPhong1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhong1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPhong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhong1ActionPerformed(evt);
            }
        });
        jPanel6.add(txtPhong1);
        txtPhong1.setBounds(300, 200, 100, 40);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Tiết bắt đầu");
        jPanel6.add(jLabel20);
        jLabel20.setBounds(10, 200, 90, 40);

        txtSlgtd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSlgtd.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSlgtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSlgtdActionPerformed(evt);
            }
        });
        jPanel6.add(txtSlgtd);
        txtSlgtd.setBounds(110, 260, 290, 40);

        comboBoxThu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(comboBoxThu1);
        comboBoxThu1.setBounds(110, 130, 290, 40);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("-");
        jPanel6.add(jLabel21);
        jLabel21.setBounds(240, 60, 30, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nhóm Thực Hành");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(7, 6, 430, 40);

        btnSaveNhom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSaveNhom.setText("Lưu");
        btnSaveNhom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNhomActionPerformed(evt);
            }
        });
        jPanel6.add(btnSaveNhom);
        btnSaveNhom.setBounds(180, 320, 100, 30);

        jLabel15.setText("Số lượng tối đa");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(10, 260, 90, 40);

        txtNgayBatDau2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayBatDau2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNgayBatDau2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayBatDau2ActionPerformed(evt);
            }
        });
        jPanel6.add(txtNgayBatDau2);
        txtNgayBatDau2.setBounds(110, 60, 110, 40);

        txtTietBD2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTietBD2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTietBD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTietBD2ActionPerformed(evt);
            }
        });
        jPanel6.add(txtTietBD2);
        txtTietBD2.setBounds(110, 200, 100, 40);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Thời hạn");

        javax.swing.GroupLayout jDialogNhom1Layout = new javax.swing.GroupLayout(jDialogNhom1.getContentPane());
        jDialogNhom1.getContentPane().setLayout(jDialogNhom1Layout);
        jDialogNhom1Layout.setHorizontalGroup(
            jDialogNhom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNhom1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(399, Short.MAX_VALUE))
            .addGroup(jDialogNhom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogNhom1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jDialogNhom1Layout.setVerticalGroup(
            jDialogNhom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogNhom1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
            .addGroup(jDialogNhom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogNhom1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lớp Tín Chỉ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã lớp tín chỉ");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(0, 10, 90, 40);

        txtNgayKetThuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayKetThuc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNgayKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayKetThucActionPerformed(evt);
            }
        });
        jPanel3.add(txtNgayKetThuc);
        txtNgayKetThuc.setBounds(260, 130, 110, 40);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Học Kỳ");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(220, 70, 70, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Thứ trong tuần");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(0, 190, 90, 40);

        comboNamHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboNamHoc);
        comboNamHoc.setBounds(110, 70, 110, 40);

        comboBoxHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxHocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxHocKyActionPerformed(evt);
            }
        });
        jPanel3.add(comboBoxHocKy);
        comboBoxHocKy.setBounds(290, 70, 80, 40);

        txtMaLTC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaLTC.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMaLTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaLTCActionPerformed(evt);
            }
        });
        jPanel3.add(txtMaLTC);
        txtMaLTC.setBounds(110, 10, 260, 40);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Năm Học");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(0, 70, 90, 40);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Phòng");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(190, 250, 80, 40);

        txtPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhongActionPerformed(evt);
            }
        });
        jPanel3.add(txtPhong);
        txtPhong.setBounds(270, 250, 100, 40);

        txtNgayBatDau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgayBatDau.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNgayBatDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayBatDauActionPerformed(evt);
            }
        });
        jPanel3.add(txtNgayBatDau);
        txtNgayBatDau.setBounds(110, 130, 110, 40);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Thời hạn");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(0, 130, 90, 40);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Tiết bắt đầu");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(0, 250, 90, 40);

        txtTietBD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTietBD.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTietBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTietBDActionPerformed(evt);
            }
        });
        jPanel3.add(txtTietBD);
        txtTietBD.setBounds(110, 250, 80, 40);

        comboBoxThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboBoxThu);
        comboBoxThu.setBounds(110, 190, 260, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("-");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(220, 130, 37, 40);

        jPanel4.setLayout(null);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Số nhóm TH");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(0, 190, 90, 40);

        comboBoxSoNhomTH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxSoNhomTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSoNhomTHActionPerformed(evt);
            }
        });
        jPanel4.add(comboBoxSoNhomTH);
        comboBoxSoNhomTH.setBounds(100, 190, 260, 40);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Giảng viên 1");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(0, 70, 90, 40);

        comboBoxGiangVien1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxGiangVien1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGiangVien1ActionPerformed(evt);
            }
        });
        jPanel4.add(comboBoxGiangVien1);
        comboBoxGiangVien1.setBounds(100, 70, 260, 40);

        comboBoxMonHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(comboBoxMonHoc);
        comboBoxMonHoc.setBounds(100, 10, 260, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Môn học");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(0, 10, 90, 40);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Giảng viên 2");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(0, 130, 90, 40);

        comboBoxGiangVien2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxGiangVien2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxGiangVien2ActionPerformed(evt);
            }
        });
        jPanel4.add(comboBoxGiangVien2);
        comboBoxGiangVien2.setBounds(100, 130, 260, 40);

        btnNhom1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnNhom1.setText("Nhóm 1");
        btnNhom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhom1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnNhom1);
        btnNhom1.setBounds(40, 263, 72, 30);

        btnNhom2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnNhom2.setText("Nhóm 2");
        btnNhom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhom2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnNhom2);
        btnNhom2.setBounds(160, 263, 72, 30);

        btnNhom3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnNhom3.setText("Nhóm 3");
        btnNhom3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhom3ActionPerformed(evt);
            }
        });
        jPanel4.add(btnNhom3);
        btnNhom3.setBounds(270, 263, 72, 30);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 10));

        btnInsert.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInsert.setText("Thêm");
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel5.add(btnInsert);

        btnEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel5.add(btnEdit);

        btnFind.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFind.setText("Tìm kiếm");
        btnFind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        jPanel5.add(btnFind);

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel5.add(btnDelete);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tableLopTinChi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null, null, null, null, null, null, null, null, null},
                {"2", null, null, null, null, null, null, null, null, null, null, null},
                {"3", null, null, null, null, null, null, null, null, null, null, null},
                {"4", null, null, null, null, null, null, null, null, null, null, null},
                {"5", null, null, null, null, null, null, null, null, null, null, null},
                {"6", null, null, null, null, null, null, null, null, null, null, null},
                {"7", null, null, null, null, null, null, null, null, null, null, null},
                {"8", null, null, null, null, null, null, null, null, null, null, null},
                {"9", null, null, null, null, null, null, null, null, null, null, null},
                {"10", null, null, null, null, null, null, null, null, null, null, null},
                {"11", null, null, null, null, null, null, null, null, null, null, null},
                {"12", null, null, null, null, null, null, null, null, null, null, null},
                {"13", null, null, null, null, null, null, null, null, null, null, null},
                {"14", null, null, null, null, null, null, null, null, null, null, null},
                {"15", null, null, null, null, null, null, null, null, null, null, null},
                {"16", null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã lớp tín chỉ", "Môn học", "Giảng viên", "Năm học", "Học kỳ", "Thứ", "Tiết bắt đầu", "Phòng", "Ngày bắt đầu", "Ngày kết thúc", "Số nhóm TH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableLopTinChi.setToolTipText("");
        tableLopTinChi.setRowHeight(40);
        tableLopTinChi.setShowGrid(true);
        tableLopTinChi.setVerifyInputWhenFocusTarget(false);
        tableLopTinChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLopTinChiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLopTinChi);
        if (tableLopTinChi.getColumnModel().getColumnCount() > 0) {
            tableLopTinChi.getColumnModel().getColumn(0).setHeaderValue("STT");
            tableLopTinChi.getColumnModel().getColumn(1).setHeaderValue("Mã lớp tín chỉ");
            tableLopTinChi.getColumnModel().getColumn(2).setHeaderValue("Môn học");
            tableLopTinChi.getColumnModel().getColumn(3).setHeaderValue("Giảng viên");
            tableLopTinChi.getColumnModel().getColumn(4).setHeaderValue("Năm học");
            tableLopTinChi.getColumnModel().getColumn(5).setHeaderValue("Học kỳ");
            tableLopTinChi.getColumnModel().getColumn(6).setHeaderValue("Thứ");
            tableLopTinChi.getColumnModel().getColumn(7).setHeaderValue("Tiết bắt đầu");
            tableLopTinChi.getColumnModel().getColumn(8).setHeaderValue("Phòng");
            tableLopTinChi.getColumnModel().getColumn(9).setHeaderValue("Ngày bắt đầu");
            tableLopTinChi.getColumnModel().getColumn(10).setHeaderValue("Ngày kết thúc");
            tableLopTinChi.getColumnModel().getColumn(11).setHeaderValue("Số nhóm TH");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
     public LopTinChi getModel(){
        LopTinChi ltc = new LopTinChi();
        MonHocDAO mhdao = new MonHocDAO();
        List<MonHoc> listmh = mhdao.getListMonHoc();
        ltc.setMaLopTinChi(txtMaLTC.getText().strip());
        ltc.setMaMonHoc(listmh.get(comboBoxMonHoc.getSelectedIndex()).getMaMonHoc());
        ltc.setHocKy(comboBoxHocKy.getSelectedItem().toString());
        ltc.setNamHoc(comboNamHoc.getSelectedItem().toString());
        ltc.setTietBatDau(Integer.parseInt(txtTietBD.getText().strip()));
        ltc.setPhong(txtPhong.getText().strip());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayBD = null;
        Date ngayKT = null;
        try {
            ngayBD = formatter.parse(txtNgayBatDau.getText().strip());
            ngayKT = formatter.parse(txtNgayKetThuc.getText().strip());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ltc.setNgayBD(ngayBD);
        ltc.setNgayKT(ngayKT);
        ltc.setThu(comboBoxThu.getSelectedIndex());

        ltc.setSoNhomTH(comboBoxSoNhomTH.getSelectedIndex());
        return ltc;
    }
    public void setModel(LopTinChi ltc){
        GiangVienDAO gvdao = new GiangVienDAO();
        DayLopDAO dldao = new DayLopDAO();
        MonHocDAO mhdao = new MonHocDAO();
        Weekdays weekdays = new Weekdays();
        txtMaLTC.setText(ltc.getMaLopTinChi());
        comboBoxMonHoc.setSelectedItem(mhdao.getMonHocByID(ltc.getMaMonHoc()).getTenMonhoc());
        comboNamHoc.setSelectedItem(ltc.getNamHoc());
        comboBoxHocKy.setSelectedItem(ltc.getHocKy());
        txtNgayBatDau.setText(ltc.getNgayBD().toString());
        txtNgayKetThuc.setText(ltc.getNgayKT().toString());
        comboBoxThu.setSelectedItem(weekdays.getWeekdayByID(ltc.getThu()));
        int length = dldao.getListDayLopByMaLTC(ltc.getMaLopTinChi()).size();
        GiangVien gv = null;
        String data = "";
        if(length == 1){
            gv = gvdao.getGiangVienByID(dldao.getListDayLopByMaLTC(ltc.getMaLopTinChi()).get(0).getMaGV());
            data = data + (gv.getHo() + " " + (gv.getTenDem() == null ? "" : gv.getTenDem()) + " " + gv.getTen()) + "; ";
            comboBoxGiangVien1.setSelectedItem(data);
            comboBoxGiangVien2.setSelectedIndex(0);
        } else {
            if(length == 2) {
                gv = gvdao.getGiangVienByID(dldao.getListDayLopByMaLTC(ltc.getMaLopTinChi()).get(0).getMaGV());
                data = gv.getHo() + " " + (gv.getTenDem() == null ? "" : gv.getTenDem()) + " " + gv.getTen();
                System.out.println("data = " + data);
                comboBoxGiangVien1.setSelectedItem(data);
                gv = gvdao.getGiangVienByID(dldao.getListDayLopByMaLTC(ltc.getMaLopTinChi()).get(1).getMaGV());
                data = gv.getHo() + " " + (gv.getTenDem() == null ? "" : gv.getTenDem()) + " " + gv.getTen();
                comboBoxGiangVien2.setSelectedItem(data);
            }
        }
        txtTietBD.setText(Integer.toString(ltc.getTietBatDau()));
        txtPhong.setText(ltc.getPhong());
        comboBoxSoNhomTH.setSelectedIndex(ltc.getSoNhomTH());
    }
    public void resetModel(){
        txtMaLTC.setText("");
        comboBoxMonHoc.setSelectedIndex(0);
        comboNamHoc.setSelectedIndex(0);
        comboBoxHocKy.setSelectedIndex(0);
        txtNgayBatDau.setText("");
        txtNgayKetThuc.setText("");
        comboBoxThu.setSelectedIndex(0);
        txtTietBD.setText("");
        txtPhong.setText("");
        comboBoxSoNhomTH.setSelectedIndex(0);
        comboBoxGiangVien1.setSelectedIndex(0);
        comboBoxGiangVien2.setSelectedIndex(0);

    }    
    private void txtNgayKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayKetThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayKetThucActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        LopTinChiDAO ltcdao = new LopTinChiDAO();
        List<LopTinChi> listltc = null;
        GiangVienDAO gvdao = new GiangVienDAO();
        List<GiangVien> listAllGv = gvdao.getListGiangVien();
        List<String> listMaGv = new ArrayList<>();
        listMaGv.add(listAllGv.get(comboBoxGiangVien1.getSelectedIndex()).getMaGV());
        if(comboBoxGiangVien2.getSelectedIndex() != 0){
            listMaGv.add(listAllGv.get(comboBoxGiangVien2.getSelectedIndex()).getMaGV());
        } else {
           listMaGv.add(null); 
        }
        LopTinChi ltc = getModel();
        try {
                if(ltcdao.addLopTinChiToDB(ltc, listMaGv ) > 0){
                    ltcdao = new LopTinChiDAO();
                    listltc = ltcdao.getListLopTinChi();
                    fillDataTable(listltc);
                    JOptionPane.showMessageDialog(this, "Thêm thành công lớp tín chỉ!");
                    resetModel();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm không thành công lớp tín chỉ!");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        LopTinChiDAO ltcdao = new LopTinChiDAO();
        List<LopTinChi> listltc = null;
        GiangVienDAO gvdao = new GiangVienDAO();
        List<GiangVien> listAllGv = gvdao.getListGiangVien();
        List<String> listMaGv = new ArrayList<>();
        listMaGv.add(listAllGv.get(comboBoxGiangVien1.getSelectedIndex()).getMaGV());
        if(comboBoxGiangVien2.getSelectedIndex() != 0){
            listMaGv.add(listAllGv.get(comboBoxGiangVien2.getSelectedIndex()).getMaGV());
        } else {
           listMaGv.add(null); 
        }
        LopTinChi ltc = getModel();
        try {
                if(ltcdao.editLopTinChiToDB(ltc, listMaGv ) > 0){
                    ltcdao = new LopTinChiDAO();
                    listltc = ltcdao.getListLopTinChi();
                    fillDataTable(listltc);
                    JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công lớp tín chỉ!");
                    resetModel();
                } else {
                    JOptionPane.showMessageDialog(this, "Chỉnh sửa không thành công lớp tín chỉ!");
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
//        SinhVienDAO svdao = new SinhVienDAO();
//        NganhDAO nganhdao = new NganhDAO();
//        List<SinhVien> listAllSv = svdao.getListSinhVien();
//        List<SinhVien> listFilteredSv = new ArrayList<SinhVien>();
//        txtNgaySinh.setText("");
//        comboNamHoc.setSelectedItem("Mã tỉnh - Tên tỉnh");
//        txtSoDienThoai1.setText("");
//        txtSoDienThoai2.setText("");
//        txtEmail1.setText("");
//        txtEmail2.setText("");
//        if( txtNgayKetThuc.getText().strip().equals("")
//            && txtHoVaTen.getText().strip().equals("")
//            && comboBoxMonHoc.getSelectedItem().toString().equals("Ngành học")
//            && txtLopKhoaHoc.getText().strip().equals("")
//            && comboBoxHocKy.getSelectedItem().equals("Phái")
//        ){
//            JOptionPane.showMessageDialog(this, "Nhập thông tin sinh viên để tìm kiếm!");
//            fillDataTable(svdao.getListSinhVien());
//        } else {
//            for(SinhVien sv: listAllSv){
//                String hovaten = sv.getHo() + " " + (sv.getTenDem() == null ? "" : sv.getTenDem() + " ") + sv.getTen();
//                if( (sv.getMaSV().contains(txtNgayKetThuc.getText().strip())
//                    && (hovaten.equals("") ? true : hovaten.contains(txtHoVaTen.getText().strip()))
//                    && (comboBoxMonHoc.getSelectedItem().toString().equals("Ngành học") ? true : nganhdao.getNganhByName(comboBoxMonHoc.getSelectedItem().toString()).getMaNganh() == sv.getMaNganh())
//                    && (sv.getLopKhoaHoc().contains(txtLopKhoaHoc.getText().strip()))
//                    && (sv.getChuongTrinhDaoTao().contains(txtChuongTrinhDaoTao.getText().strip()))
//                    && (sv.isNghiHoc() == txtNghiHoc.isSelected())
//                    && (sv.isPhai() == (comboBoxHocKy.getSelectedItem().equals("Nữ") ? false : true))
//                )){
//                    listFilteredSv.add(sv);
//                }
//            }
//            fillDataTable(listFilteredSv);
//        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        LopTinChiDAO ltcdao = new LopTinChiDAO();
        List<LopTinChi> listltc = null;
        LopTinChi ltc = getModel();
        int confirm = JOptionPane.showConfirmDialog(null,
            "Bạn có chắc chắn muốn xóa?", "Xóa!", JOptionPane.DEFAULT_OPTION);
        if(confirm == 0){
                if(ltcdao.delLopTinChiByID(ltc.getMaLopTinChi()) > 0){
                    ltcdao = new LopTinChiDAO();
                    listltc = ltcdao.getListLopTinChi();
                    fillDataTable(listltc);
                    JOptionPane.showMessageDialog(this, "Xóa thành công lớp tín chỉ!");
                    resetModel();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa không thành công lớp tín chỉ!");
                }            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void comboBoxSoNhomTHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSoNhomTHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSoNhomTHActionPerformed

    private void txtMaLTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaLTCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLTCActionPerformed

    private void txtPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhongActionPerformed

    private void comboBoxGiangVien1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGiangVien1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxGiangVien1ActionPerformed

    private void txtNgayBatDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayBatDauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayBatDauActionPerformed

    private void comboBoxHocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxHocKyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxHocKyActionPerformed

    private void comboBoxGiangVien2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxGiangVien2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxGiangVien2ActionPerformed

    private void txtTietBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTietBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTietBDActionPerformed

    private void btnNhom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhom1ActionPerformed
        // TODO add your handling code here:
        manhom = 1;
        jDialogNhom1.setLocationRelativeTo(null);
        jDialogNhom1.setVisible(true);
        jLabel7.setText("Nhóm 01");
    }//GEN-LAST:event_btnNhom1ActionPerformed

    private void tableLopTinChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLopTinChiMouseClicked
        // TODO add your handling code here:
        int stt = tableLopTinChi.rowAtPoint(evt.getPoint());
        String MaLTC = tableLopTinChi.getValueAt(stt, 1).toString();
        LopTinChiDAO ltcdao = new LopTinChiDAO();
        LopTinChi ltc = ltcdao.getLTCByID(MaLTC);
        setModel(ltc);
    }//GEN-LAST:event_tableLopTinChiMouseClicked

    private void txtNgayKetThuc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayKetThuc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayKetThuc1ActionPerformed

    private void txtPhong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhong1ActionPerformed

    private void txtSlgtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSlgtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSlgtdActionPerformed

    private void btnNhom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhom2ActionPerformed
        // TODO add your handling code here:
        manhom = 2;
        jDialogNhom1.setLocationRelativeTo(null);
        jDialogNhom1.setVisible(true);
        jLabel7.setText("Nhóm 02");
    }//GEN-LAST:event_btnNhom2ActionPerformed

    private void btnNhom3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhom3ActionPerformed
        // TODO add your handling code here:
        manhom = 3;
        jDialogNhom1.setLocationRelativeTo(null);
        jDialogNhom1.setVisible(true);
        jLabel7.setText("Nhóm 03");
    }//GEN-LAST:event_btnNhom3ActionPerformed

    private void btnSaveNhomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNhomActionPerformed
        // TODO add your handling code here:
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC ThemCTNhom @maNhom = ?, @maLopTC = ?, @slgToiDa = ?, @tietBatDau = ?, @ngayBatDau = ?, @ngayKetThuc = ?, @phong = ?, @thu = ?";
            stmt = connect.prepareStatement(SQL);
            stmt.setInt(1, manhom);
            stmt.setString(2, txtMaLTC.getText().strip());
            stmt.setInt(3, Integer.parseInt(txtSlgtd.getText()));
            stmt.setInt(4, Integer.parseInt(txtTietBD2.getText()));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date ngaybd = null;
            Date ngaykt = null;
            try {
                ngaybd = formatter.parse(txtNgayBatDau2.getText());
                ngaykt = formatter.parse(txtNgayKetThuc1.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
            stmt.setDate(5, new java.sql.Date(ngaybd.getTime()));
            stmt.setDate(6, new java.sql.Date(ngaykt.getTime()));
            stmt.setString(7, txtPhong1.getText().strip());
            stmt.setInt(8, comboBoxThu1.getSelectedIndex() + 1);
            if(stmt.executeUpdate() > 0){
                System.out.println("Insert's successed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Thêm không thành công Nhóm" + manhom);
        } finally{
            try {
                stmt.close();
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }        
        JOptionPane.showMessageDialog(this, "Thêm thành công Nhóm" + manhom);
    }//GEN-LAST:event_btnSaveNhomActionPerformed

    private void txtNgayBatDau2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayBatDau2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayBatDau2ActionPerformed

    private void txtTietBD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTietBD2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTietBD2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNhom1;
    private javax.swing.JButton btnNhom2;
    private javax.swing.JButton btnNhom3;
    private javax.swing.JButton btnSaveNhom;
    private javax.swing.JComboBox<String> comboBoxGiangVien1;
    private javax.swing.JComboBox<String> comboBoxGiangVien2;
    private javax.swing.JComboBox<String> comboBoxHocKy;
    private javax.swing.JComboBox<String> comboBoxMonHoc;
    private javax.swing.JComboBox<String> comboBoxSoNhomTH;
    private javax.swing.JComboBox<String> comboBoxThu;
    private javax.swing.JComboBox<String> comboBoxThu1;
    private javax.swing.JComboBox<String> comboNamHoc;
    private javax.swing.JDialog jDialogNhom1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableLopTinChi;
    private javax.swing.JTextField txtMaLTC;
    private javax.swing.JTextField txtNgayBatDau;
    private javax.swing.JTextField txtNgayBatDau2;
    private javax.swing.JTextField txtNgayKetThuc;
    private javax.swing.JTextField txtNgayKetThuc1;
    private javax.swing.JTextField txtPhong;
    private javax.swing.JTextField txtPhong1;
    private javax.swing.JTextField txtSlgtd;
    private javax.swing.JTextField txtTietBD;
    private javax.swing.JTextField txtTietBD2;
    // End of variables declaration//GEN-END:variables
}

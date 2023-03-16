/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views.NhanVienPDT;

import dao.NganhDAO;
import dao.QueQuanDAO;
import dao.SinhVienDAO;
import dao.TaiKhoanDAO;
import entity.Nganh;
import entity.QueQuan;
import entity.TaiKhoan;
import java.util.List;
import entity.SinhVien;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author PC
 */
public class SinhVienView extends javax.swing.JPanel {

    /**
     * Creates new form SinhVienView
     */
    public void fillDataTable(List<SinhVien> listsv){        
        QueQuanDAO qqdao = new QueQuanDAO();
        List<QueQuan> listqq = qqdao.getListQueQuan();
        int i = 1;
        DefaultTableModel model = (DefaultTableModel) tableSinhVien.getModel();
        model.setRowCount(0);
        for(SinhVien sv : listsv){
            Object dataRow[] = new Object[14];
            dataRow[0] = i++;
            dataRow[1] = sv.getMaSV();
            dataRow[2] = sv.getHo() + " " + (sv.getTenDem() == null ? "" : sv.getTenDem() + " ") + sv.getTen();
            dataRow[3] = sv.isPhai();
            dataRow[4] = sv.getNgaySinh();
            dataRow[5] = sv.getLopKhoaHoc();
            dataRow[6] = sv.getChuongTrinhDaoTao();
            dataRow[7] = sv.getSoDienThoai1();
            dataRow[8] = sv.getSoDienThoai2();
            dataRow[9] = sv.getEmail1();
            dataRow[10] = sv.getEmail2();
            dataRow[11] = sv.isNghiHoc();
            dataRow[12] = sv.getMaNganh();
            dataRow[13] = qqdao.getQueQuanByID(sv.getMaQQ()).getTenQQ();
            model.addRow(dataRow);
        }
        model.fireTableDataChanged();
    }
    public void fillComboBoxQuequan(){
        QueQuanDAO qqdao = new QueQuanDAO();
        List<QueQuan> listqq = qqdao.getListQueQuan();
        comboBoxMaQQ.removeAllItems();
        comboBoxMaQQ.addItem("Mã tỉnh - Tên tỉnh");
        for(QueQuan qq : listqq){
            String elm = qq.getMaQQ() + " " + qq.getTenQQ();
            comboBoxMaQQ.addItem(elm);
        }
    }
    public void fillComboBoxPhai(){
        comboBoxPhai.removeAllItems();
        comboBoxPhai.addItem("Phái");
        String elm = "Nam";
        comboBoxPhai.addItem(elm);
        elm = "Nữ";
        comboBoxPhai.addItem(elm);
    }
    public void fillComboBoxNganhHoc(){
        NganhDAO ndao = new NganhDAO();
        List<Nganh> listNganh = ndao.getListNganh();
        comboBoxNganhHoc.removeAllItems();
        comboBoxNganhHoc.addItem("Ngành học");
        for(Nganh nganh : listNganh){
            String elm = nganh.getTenNganh();
            comboBoxNganhHoc.addItem(elm);
        }
    }
    public SinhVienView() {
        SinhVienDAO svdao = new SinhVienDAO();
        List<SinhVien> listsv = svdao.getListSinhVien();        
        initComponents();
        resetModel();
        fillComboBoxQuequan();
        fillComboBoxPhai();
        fillComboBoxNganhHoc();
        fillDataTable(listsv);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNghiHoc = new javax.swing.JCheckBox();
        comboBoxMaQQ = new javax.swing.JComboBox<>();
        comboBoxPhai = new javax.swing.JComboBox<>();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        comboBoxNganhHoc = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtLopKhoaHoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSoDienThoai2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail2 = new javax.swing.JTextField();
        txtSoDienThoai1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtChuongTrinhDaoTao = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSinhVien = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sinh Viên");
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
        jLabel2.setText("Mã Sinh Viên");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(0, 10, 90, 40);

        txtMaSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaSV.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSVActionPerformed(evt);
            }
        });
        jPanel3.add(txtMaSV);
        txtMaSV.setBounds(110, 10, 260, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Họ và tên");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, 60, 90, 40);

        txtHoVaTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtHoVaTen);
        txtHoVaTen.setBounds(110, 60, 260, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ngành học");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(0, 160, 90, 40);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Phái");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(160, 260, 90, 40);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quê quán");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(0, 210, 90, 40);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nghỉ học");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(10, 260, 90, 40);

        txtNghiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNghiHocActionPerformed(evt);
            }
        });
        jPanel3.add(txtNghiHoc);
        txtNghiHoc.setBounds(110, 260, 30, 40);

        comboBoxMaQQ.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxMaQQ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboBoxMaQQ);
        comboBoxMaQQ.setBounds(110, 210, 260, 40);

        comboBoxPhai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxPhai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboBoxPhai);
        comboBoxPhai.setBounds(250, 260, 80, 40);

        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });
        jPanel3.add(txtNgaySinh);
        txtNgaySinh.setBounds(110, 110, 260, 40);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Ngày sinh");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(0, 110, 90, 40);

        comboBoxNganhHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboBoxNganhHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(comboBoxNganhHoc);
        comboBoxNganhHoc.setBounds(110, 160, 260, 40);

        jPanel4.setLayout(null);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Lớp khóa học");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(0, 10, 90, 40);

        txtLopKhoaHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(txtLopKhoaHoc);
        txtLopKhoaHoc.setBounds(100, 10, 260, 40);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Số điện thoại 2");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(0, 160, 90, 40);

        txtSoDienThoai2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(txtSoDienThoai2);
        txtSoDienThoai2.setBounds(100, 160, 260, 40);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Email 1");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(10, 210, 80, 40);

        txtEmail1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(txtEmail1);
        txtEmail1.setBounds(100, 210, 260, 40);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Email 2");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(10, 260, 80, 40);

        txtEmail2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(txtEmail2);
        txtEmail2.setBounds(100, 260, 260, 40);

        txtSoDienThoai1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(txtSoDienThoai1);
        txtSoDienThoai1.setBounds(100, 110, 260, 40);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Số điện thoại 1");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(0, 110, 90, 40);

        txtChuongTrinhDaoTao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(txtChuongTrinhDaoTao);
        txtChuongTrinhDaoTao.setBounds(100, 60, 260, 40);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("CTDT");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(0, 60, 90, 40);

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

        tableSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"2", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"3", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"4", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"5", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"6", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"7", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"8", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"9", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"10", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"11", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"12", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"13", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"14", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"15", null, null, null, null, null, null, null, null, null, null, null, null, null},
                {"16", null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sinh Viên", "Họ và tên", "Phái", "Ngày sinh", "Lớp khóa học", "Chương trình đào tạo", "Số điện thoại 1", "Số điện thoại 2", "Email 1", "Email 2", "Nghỉ học", "Ngành học", "Quê Quán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSinhVien.setToolTipText("");
        tableSinhVien.setRowHeight(40);
        tableSinhVien.setShowGrid(true);
        tableSinhVien.setVerifyInputWhenFocusTarget(false);
        tableSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSinhVien);

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

     public static boolean isValidDayFormat( String value) {
        String format = "yyyy-MM-dd";
        Locale locale = Locale.ENGLISH;
        LocalDateTime ldt = null;
        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

        try {
            ldt = LocalDateTime.parse(value, fomatter);
            String result = ldt.format(fomatter);
            return result.equals(value);
        } catch (DateTimeParseException e) {
            try {
                LocalDate ld = LocalDate.parse(value, fomatter);
                String result = ld.format(fomatter);
                return result.equals(value);
            } catch (DateTimeParseException exp) {
                try {
                    LocalTime lt = LocalTime.parse(value, fomatter);
                    String result = lt.format(fomatter);
                    return result.equals(value);
                } catch (DateTimeParseException e2) {
                    // Debugging purposes
                    //e2.printStackTrace();
                }
            }
        }
        return false;
    }
    
    public boolean isValidForm(){
        // Check id:
        if(txtMaSV.getText().strip().isEmpty()){
            JOptionPane.showMessageDialog(this, "Mã sinh viên không được để trống!");
            return false;
        } 
        // Check fullname:
        if(txtHoVaTen.getText().strip().isEmpty()){
            JOptionPane.showMessageDialog(this, "Họ và tên sinh viên không được để trống!");
            return false;
        } else {
            if(!txtHoVaTen.getText().strip().contains(" ")){
               JOptionPane.showMessageDialog(this, "Họ và tên sinh viên không hợp lệ!"); 
            }
        }
        // Check Ngay Sinh
        if(txtNgaySinh.getText().strip().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống!");
            return false;
        } else {
            if(!isValidDayFormat(txtNgaySinh.getText().strip())){
                JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng (yyyy-MM-dd)!");
                return false;                
            }
        }              
        
        if(comboBoxMaQQ.getSelectedItem().equals("Mã tỉnh - Tên tỉnh")){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn quê quán cho sinh viên!");
        }
        
        if(comboBoxNganhHoc.getSelectedItem().equals("Ngành học")){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn ngành học cho sinh viên!");
        }
        if(comboBoxPhai.getSelectedItem().equals("Phái")){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn phái cho sinh viên!");
        }
        // Check SDT 1
        Pattern sdtPattern = Pattern.compile("^\\d{10}$");
        Matcher sdtMatcher = null;
        if(txtSoDienThoai1.getText().strip().isEmpty()){
            JOptionPane.showMessageDialog(this, "Số điện thoại 1 không được để trống!");
            return false;
        } else {
            sdtMatcher = sdtPattern.matcher(txtSoDienThoai1.getText().strip());
            if(!sdtMatcher.find()){
                JOptionPane.showMessageDialog(this, "Số điện thoại 1 phải bao gồm 10 chữ số!");                
            }
        }
        // Check Email 1
        Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
        Matcher emailMatcher = null;
        if(txtEmail1.getText().strip().isEmpty()){
            JOptionPane.showMessageDialog(this, "Email 1 không được để trống!");
            return false;
        } else {
            emailMatcher = emailPattern.matcher(txtEmail1.getText().strip());
            if(!emailMatcher.find()){
                JOptionPane.showMessageDialog(this, "Email không đúng định dạng!");                
            }
        }        
        return true;
    }
    
    public SinhVien getModel(){
        SinhVien sv = new SinhVien();
        sv.setMaSV(txtMaSV.getText().strip());
        String ho, tenDem = "", ten;
        String[] hoVaTen = txtHoVaTen.getText().strip().split(" ");
        ho = hoVaTen[0];
        ten = hoVaTen[hoVaTen.length - 1];
        for(int i = 1; i <= hoVaTen.length - 2; i++){
            tenDem+=(hoVaTen[i] + " ");
        }
        sv.setHo(ho);
        sv.setTenDem(tenDem.strip());
        sv.setTen(ten);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh = null;
        try {
            ngaySinh = formatter.parse(txtNgaySinh.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        sv.setLopKhoaHoc(txtLopKhoaHoc.getText().strip());
        sv.setChuongTrinhDaoTao(txtChuongTrinhDaoTao.getText().strip());
        sv.setNgaySinh(ngaySinh);
        sv.setPhai(comboBoxPhai.getSelectedItem().toString().equals("Nam"));
        sv.setMaQQ(Integer.parseInt(comboBoxMaQQ.getSelectedItem().toString().split(" ")[0]));
        sv.setNghiHoc(txtNghiHoc.isSelected());
        sv.setSoDienThoai1(txtSoDienThoai1.getText().strip());
        sv.setSoDienThoai2(txtSoDienThoai2.getText().strip());   
        sv.setEmail1(txtEmail1.getText().strip());
        sv.setEmail2(txtEmail2.getText().strip());

        String tenNganh = comboBoxNganhHoc.getSelectedItem().toString();
        NganhDAO nganhdao = new NganhDAO();
        sv.setMaNganh(nganhdao.getNganhByName(tenNganh).getMaNganh());        
        return sv;
    }
    public void setModel(SinhVien sv){
        txtMaSV.setText(sv.getMaSV());
        txtHoVaTen.setText(sv.getHo() + " " + (sv.getTenDem() == null ? "" : sv.getTenDem() + " ") + sv.getTen());
        txtNgaySinh.setText(sv.getNgaySinh().toString());
        QueQuanDAO qqdao = new QueQuanDAO();
        List<QueQuan> listqq = qqdao.getListQueQuan();
        String elmQQ = null;
        for(QueQuan qq : listqq){
            if(qq.getMaQQ() == sv.getMaQQ()){
                elmQQ = qq.getMaQQ() + " " + qq.getTenQQ();
                comboBoxMaQQ.setSelectedItem(elmQQ);                
            }
        } 
        if(sv.isPhai()){
            comboBoxPhai.setSelectedItem("Nam");
        } else {
            comboBoxPhai.setSelectedItem("Nữ");
        }
        NganhDAO nganhdao = new NganhDAO();
        List<Nganh> listnganh = nganhdao.getListNganh();
        String elmNganh = null;
        for(Nganh nganh: listnganh){
            if(sv.getMaNganh() == nganh.getMaNganh()){
                elmNganh = nganh.getTenNganh();
                comboBoxNganhHoc.setSelectedItem(elmNganh);
            }
        }
        txtNghiHoc.setSelected(sv.isNghiHoc());
        txtLopKhoaHoc.setText(sv.getLopKhoaHoc());
        txtChuongTrinhDaoTao.setText(sv.getChuongTrinhDaoTao());
        txtSoDienThoai1.setText(sv.getSoDienThoai1());
        txtSoDienThoai2.setText(sv.getSoDienThoai2());
        txtEmail1.setText(sv.getEmail1());
        txtEmail2.setText(sv.getEmail2());
        txtNghiHoc.setSelected(sv.isNghiHoc());
    }
    public void resetModel(){
        txtMaSV.setText("");
        txtHoVaTen.setText("");
        txtNgaySinh.setText("");
        comboBoxPhai.setSelectedItem("Phái");
        comboBoxMaQQ.setSelectedItem("Mã tỉnh - Tên tỉnh");  
        comboBoxNganhHoc.setSelectedItem("Ngành học");
        txtNghiHoc.setSelected(false);
        txtLopKhoaHoc.setText("");
        txtChuongTrinhDaoTao.setText("");
        txtSoDienThoai1.setText("");
        txtSoDienThoai2.setText("");
        txtEmail1.setText("");
        txtEmail2.setText("");

    }    
    private void txtMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSVActionPerformed

    private void txtNghiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNghiHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNghiHocActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        SinhVienDAO svdao = new SinhVienDAO();
        TaiKhoanDAO tkdao = new TaiKhoanDAO();
        TaiKhoan tk = null;
        List<SinhVien> listsv = null;
        SinhVien sv = getModel();
        try {
            if(isValidForm()){
                tk = new TaiKhoan(sv.getMaSV(), "1", true, "SV");
                tkdao.createTaiKhoanToDB(tk);
                if(svdao.addSinhVienToDB(sv) > 0){
                    svdao = new SinhVienDAO();
                    listsv = svdao.getListSinhVien();
                    fillDataTable(listsv);
                    JOptionPane.showMessageDialog(this, "Thêm thành công Giảng viên!");
                    resetModel();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm không thành công Giảng viên!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        SinhVienDAO svdao = new SinhVienDAO();
        List<SinhVien> listsv = null;
        SinhVien gv = getModel();

        try {
            if(isValidForm()){
                if(svdao.editSinhVienToDB(gv) > 0){
                    svdao = new SinhVienDAO();
                    listsv = svdao.getListSinhVien();
                    fillDataTable(listsv);
                    JOptionPane.showMessageDialog(this, "Sửa thành công Giảng viên!");
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa không thành công Giảng viên!");
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        SinhVienDAO svdao = new SinhVienDAO();
        NganhDAO nganhdao = new NganhDAO();
        List<SinhVien> listAllSv = svdao.getListSinhVien();
        List<SinhVien> listFilteredSv = new ArrayList<SinhVien>();
        txtNgaySinh.setText("");
        comboBoxMaQQ.setSelectedItem("Mã tỉnh - Tên tỉnh");  
        txtSoDienThoai1.setText("");
        txtSoDienThoai2.setText("");
        txtEmail1.setText("");
        txtEmail2.setText("");
        if( txtMaSV.getText().strip().equals("") 
                && txtHoVaTen.getText().strip().equals("")
                && comboBoxNganhHoc.getSelectedItem().toString().equals("Ngành học")
                && txtLopKhoaHoc.getText().strip().equals("")
                && comboBoxPhai.getSelectedItem().equals("Phái")
        ){
            JOptionPane.showMessageDialog(this, "Nhập thông tin sinh viên để tìm kiếm!");
            fillDataTable(svdao.getListSinhVien());
        } else {
            for(SinhVien sv: listAllSv){
                 String hovaten = sv.getHo() + " " + (sv.getTenDem() == null ? "" : sv.getTenDem() + " ") + sv.getTen();
            if( (sv.getMaSV().contains(txtMaSV.getText().strip())
                && (hovaten.equals("") ? true : hovaten.contains(txtHoVaTen.getText().strip()))
                && (comboBoxNganhHoc.getSelectedItem().toString().equals("Ngành học") ? true : nganhdao.getNganhByName(comboBoxNganhHoc.getSelectedItem().toString()).getMaNganh() == sv.getMaNganh())
                && (sv.getLopKhoaHoc().contains(txtLopKhoaHoc.getText().strip()))
                && (sv.getChuongTrinhDaoTao().contains(txtChuongTrinhDaoTao.getText().strip()))
                && (sv.isNghiHoc() == txtNghiHoc.isSelected())
                && (sv.isPhai() == (comboBoxPhai.getSelectedItem().equals("Nữ") ? false : true))
            )){
              listFilteredSv.add(sv);  
            }
            }
            fillDataTable(listFilteredSv);
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        SinhVienDAO svdao = new SinhVienDAO();
        TaiKhoanDAO tkdao = new TaiKhoanDAO();
        int confirm = JOptionPane.showConfirmDialog(null,
            "Bạn có chắc chắn muốn xóa?", "Xóa!", JOptionPane.DEFAULT_OPTION);
        // 0=yes, 1=no, 2=cancel
        if(confirm == 0){
            if(svdao.checkSVDangKyByID(txtMaSV.getText().strip()) == -1){
                JOptionPane.showMessageDialog(this, "Sinh viên đã đăng ký lớp tín chỉ, không thể xóa!");
            } else {
                
                if(svdao.delSinhVienByID(txtMaSV.getText().strip()) > 0){
                    tkdao.deleteTaiKhoanToDB(txtMaSV.getText().strip());
                    JOptionPane.showMessageDialog(this, "Xóa thành công sinh viên!");
                    List<SinhVien> listsv = new SinhVienDAO().getListSinhVien();
                    fillDataTable(listsv);
                    resetModel();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa không thành công sinh viên!");
                }              
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tableSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSinhVienMouseClicked
        // TODO add your handling code here:
        int stt = tableSinhVien.rowAtPoint(evt.getPoint());
        String MaSV = tableSinhVien.getValueAt(stt, 1).toString();
        SinhVienDAO svdao = new SinhVienDAO();
        SinhVien sv = svdao.getSinhVienByID(MaSV);
        setModel(sv);
    }//GEN-LAST:event_tableSinhVienMouseClicked

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnInsert;
    private javax.swing.JComboBox<String> comboBoxMaQQ;
    private javax.swing.JComboBox<String> comboBoxNganhHoc;
    private javax.swing.JComboBox<String> comboBoxPhai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSinhVien;
    private javax.swing.JTextField txtChuongTrinhDaoTao;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtLopKhoaHoc;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JCheckBox txtNghiHoc;
    private javax.swing.JTextField txtSoDienThoai1;
    private javax.swing.JTextField txtSoDienThoai2;
    // End of variables declaration//GEN-END:variables
}

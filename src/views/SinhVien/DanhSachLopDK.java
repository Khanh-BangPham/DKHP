
package views.SinhVien;

import dao.CT_HocKy_NamHoc_DAO;
import entity.CT_HocKy_NamHoc;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import sqlserver_connection.ConnectionHelper;
import views.*;

/**
 *
 * @author Admin
 */
public class DanhSachLopDK extends javax.swing.JPanel {

    /**
     * Creates new form DanhSachMonDK
     */
    private static DangNhap dangNhap;

    public DanhSachLopDK(DangNhap dangNhap) {
        initComponents();
        this.dangNhap = dangNhap;
//        bieuTuongXoa();
        loadDSSVDK(new DangKyLTC(dangNhap).getTime());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbDSSVDK = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(802, 628));

        tbDSSVDK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Môn", "Tên Môn", "Nhóm", "STC", "Học Phí", "T/Gian BD", "T/Gian KT", "Thứ", "Tiết Bắt Đầu", "Phòng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDSSVDK.setAlignmentX(0.0F);
        tbDSSVDK.setAlignmentY(0.0F);
        tbDSSVDK.setRowHeight(55);
        tbDSSVDK.setShowGrid(true);
        jScrollPane1.setViewportView(tbDSSVDK);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Danh Sách Lớp Đã Đăng Ký");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 304, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDSSVDK;
    // End of variables declaration//GEN-END:variables

    
    public CT_HocKy_NamHoc getModelCurrentHKNH(){
        CT_HocKy_NamHoc curHKNH = new CT_HocKy_NamHoc_DAO().getCTHKNHCurrent();
        return curHKNH;
    }
    
   
    public void loadDSSVDK(int id) {
        MultiLineTableCellRenderer renderer = new MultiLineTableCellRenderer();
        tbDSSVDK.setDefaultRenderer(Object.class, renderer);
        DefaultTableModel model = (DefaultTableModel) tbDSSVDK.getModel();
        model.setRowCount(0);
        
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String query = "{CALL DSLOPSVDK(?, ?)}";
            CallableStatement stmt = connect.prepareCall(query);

            stmt.setString(1, dangNhap.getTaiKhoan());
            stmt.setInt(2, id);

            ResultSet result = stmt.executeQuery();
            String Thu;
            String tiet;

            int i = 1;

            while (result.next()) {
                
                String pTH =  result.getString("PTH")==null?"":result.getString("PTH");
                String ngayBDTH = result.getString("NBDTH")==null?"":result.getString("NBDTH");
                String ngayKTTH = result.getString("NKTTH")==null?"":result.getString("NKTTH");
                if(result.getInt("ThuTH") != 0)
                    Thu = Integer.toString(result.getInt("ThuLT")) + "\n\n"+ Integer.toString(result.getInt("ThuTH"));
                else
                    Thu = Integer.toString(result.getInt("ThuLT"));
                
                if(result.getInt("ThuTH") != 0)
                    tiet =Integer.toString(result.getInt("TBDLT")) + "\n\n"+ Integer.toString(result.getInt("TBDTH"));
                else
                    tiet = Integer.toString(result.getInt("TBDLT"));
                
                Object[] obj = {i++, result.getString("MaMH"), result.getString("TenMH"), result.getInt("MaNhom"), result.getInt("SoTinChi"),
                    result.getInt("GiaTien") * result.getInt("SoTinChi"),
                    result.getString("NBDLT") + "\n\n" + ngayBDTH, 
                    result.getString("NKTLT") + " \n\n" +  ngayKTTH,
                    Thu, 
                    tiet, 
                    result.getString("PLT") + "\n\n" +pTH};
                model.addRow(obj);

            }
            stmt.close();
            connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        model.fireTableDataChanged();
    }
    

    public void bieuTuongXoa() {

        tbDSSVDK.getColumnModel().getColumn(11).setCellRenderer(new DeleteRenderer());

        tbDSSVDK.getColumnModel().getColumn(11).setCellEditor(new DeleteEditor());

    }

    class DeleteRenderer extends DefaultTableCellRenderer {

        private final Icon icon = new ImageIcon("Image//delete.png");

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setIcon(icon);
            setHorizontalAlignment(JLabel.CENTER);
            return this;
        }
    }

    class DeleteEditor extends DefaultCellEditor {

        private final JButton button;
        private boolean clicked;

        public DeleteEditor() {
            super(new JTextField());
            button = new JButton(new ImageIcon("Image//delete.png"));
            button.addActionListener(e -> fireEditingStopped());
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            clicked = true;
            return button;
        }

//    public Object getCellEditorValue() {
//        if (clicked) {
//            // Xóa dữ liệu của hàng được chọn
//            DefaultTableModel model = (DefaultTableModel) table.getModel();
//            model.removeRow(row);
//        }
//        clicked = false;
//        return null;
//    }
        public boolean stopCellEditing() {
            clicked = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

}

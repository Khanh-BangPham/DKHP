package views.SinhVien;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import views.DangNhap;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import sqlserver_connection.ConnectionHelper;

/**
 *
 * @author Admin
 */
public class XemLichHoc extends javax.swing.JPanel {

    /**
     * Creates new form XemLichHoc
     */
    private static DangNhap dangNhap;
    private static HomeSinhVien homeSinhVien;
    private static DanhSachSinhVien dangSachSinhVien;

    public XemLichHoc(){
                initComponents();
    }
    
    public XemLichHoc(DangNhap dangNhap, HomeSinhVien homeSinhVien) {
        initComponents();
        this.dangNhap = dangNhap;
        this.homeSinhVien = homeSinhVien;
        dangSachSinhVien = new DanhSachSinhVien();
//        TableColumn buttonColumn = tbTKB.getColumnModel().getColumn(7);
//        buttonColumn.setCellRenderer(new ButtonColumn("Click me"));
////        tbTKB.getColumnModel().getColumn(7).setCellRenderer(new MyTableCellRenderer());
//        buttonColumn.setCellEditor(new ButtonColumn("Click me"));
//        buttonColumn.setResizable(true);

        dataTKB();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollTKB = new javax.swing.JScrollPane();
        tbTKB = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(802, 628));

        tbTKB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã MH", "Tên MH", "Nhóm", "Tiết BD", "Thứ", "Phòng", "Thời Gian", "DSSV"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTKB.setRowHeight(65);
        tbTKB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTKBMouseClicked(evt);
            }
        });
        jScrollTKB.setViewportView(tbTKB);
        if (tbTKB.getColumnModel().getColumnCount() > 0) {
            tbTKB.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollTKB, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollTKB, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbTKBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTKBMouseClicked
        int row = tbTKB.getSelectedRow();
        String id = tbTKB.getValueAt(row, 0).toString();
        int col = tbTKB.getSelectedColumn();
        System.out.println(col);
        if (col == 7) {
            System.out.println(""+id);
            jPanel1.removeAll();
            jPanel1.setLayout(new BorderLayout());
            jPanel1.add(new DanhSachSinhVien(id));
            jPanel1.revalidate();
            jPanel1.repaint();
        }
    }//GEN-LAST:event_tbTKBMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollTKB;
    private javax.swing.JTable tbTKB;
    // End of variables declaration//GEN-END:variables

    public void dataTKB() {
        MultiLineTableCellRenderer renderer = new MultiLineTableCellRenderer();
        tbTKB.setDefaultRenderer(Object.class, renderer);
        DefaultTableModel model = (DefaultTableModel) tbTKB.getModel();
        model.setRowCount(0);

        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String query = "{CALL DSLOPSVDK(?, ?)}";
            CallableStatement stmt = connect.prepareCall(query);

            stmt.setString(1, dangNhap.getTaiKhoan());
            stmt.setInt(2, new DangKyLTC(dangNhap).getCurrentIDHKNH());

            ResultSet result = stmt.executeQuery();
            String Thu;
            String tiet;
            String thoiGianTH;

            int i = 1;

            while (result.next()) {

                String pTH = result.getString("PTH") == null ? "" : result.getString("PTH");
                String ngayBDTH = result.getString("NBDTH") == null ? "" : result.getString("NBDTH");
                String ngayKTTH = result.getString("NKTTH") == null ? "" : result.getString("NKTTH");
                if (result.getInt("ThuTH") != 0) {
                    Thu = Integer.toString(result.getInt("ThuLT")) + "\n\n" + Integer.toString(result.getInt("ThuTH"));
                } else {
                    Thu = Integer.toString(result.getInt("ThuLT"));
                }

                if (result.getInt("ThuTH") != 0) {
                    tiet = Integer.toString(result.getInt("TBDLT")) + "\n\n" + Integer.toString(result.getInt("TBDTH"));
                } else {
                    tiet = Integer.toString(result.getInt("TBDLT"));
                }
                if(result.getString("NBDTH") != null && result.getString("NKTTH") != null)
                      thoiGianTH = ngayBDTH +"-->" +ngayKTTH;
                else
                    thoiGianTH = "";

                Object[] obj = {result.getString("MaMH"), result.getString("TenMH"), result.getInt("MaNhom"), 
                    tiet,
                    Thu,
                    result.getString("PLT") + "\n\n" + pTH,
                    result.getString("NBDLT")+ "-->" + result.getString("NKTLT") +"\n"+ thoiGianTH, 
                    
                };
                
                model.addRow(obj);

            }
            stmt.close();
            connect.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        model.fireTableDataChanged();
    }

}

class MultiLineTableCellRenderer extends JTextArea implements TableCellRenderer {

    public MultiLineTableCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        setSize(table.getColumnModel().getColumn(column).getWidth(),
                getPreferredSize().height);
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }
        return this;
    }

}

//class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
//
//    private JButton button;
//    private String label;
//
//    public ButtonColumn(String label) {
//        super();
//        this.label = label;
//        this.button = new JButton(label);
//        this.button.addActionListener(e -> {
//            // xử lý sự kiện khi người dùng nhấn vào button
//            fireEditingStopped();
//        });
//    }
//
//    // phương thức này trả về thành phần dùng để hiển thị giá trị của một ô trong cột
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        return button;
//    }
//
//    // phương thức này trả về thành phần dùng để chỉnh sửa giá trị của một ô trong cột
//    @Override
//    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//        return button;
//    }
//
//    // phương thức này trả về giá trị của ô đang chỉnh sửa
//    @Override
//    public Object getCellEditorValue() {
//        return label;
//    }
//}


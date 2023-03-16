package dao;

import entity.DangKy;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sqlserver_connection.ConnectionHelper;

public class DangKyDAO {

    public List<DangKy> getDangKyHocKy() {
        List<DangKy> listDK = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM DangKy";
            CallableStatement stmt = connect.prepareCall(SQL);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                String maSV = result.getString("MaSV");
                int id_ctn = result.getInt("IDCTN");

                DangKy dangKy = new DangKy(maSV, id_ctn);
                listDK.add(dangKy);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return listDK;
    }

    
    public DangKy getDangKyByMaSVAndIdCTN(String mSV) {
        DangKy dangKy = new DangKy();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM DangKy WHERE MaSV = ?";
            CallableStatement stmt = connect.prepareCall(SQL);
            stmt.setString(1, mSV);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                String maSV = result.getString("MaSV");
                int id_ctn = result.getInt("IDCTN");

                dangKy = new DangKy(maSV, id_ctn);

            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }
        return dangKy;
    }
    
    public void deleteDangKyBy(String maSV, String maMH, int maNhom, int tietBD, int thu, String ngayBD, String phong, int ct_hknh) {

        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "{CALL XoaLopDangKy(?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement stmt =  connect.prepareCall(SQL);
            stmt.setString(1, maSV);
            stmt.setString(2, maMH);
            stmt.setInt(3, maNhom);
            stmt.setInt(4, tietBD);
            stmt.setInt(5, thu);
            stmt.setString(6, ngayBD);
            stmt.setString(7, phong);
            stmt.setInt(8, ct_hknh);
//            stmt.addBatch();

            stmt.execute();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }
    }
    
    public void saveDangKy(String maSV, String maMH, int maNhom, int tietBD, int thu, String ngayBD, String phong, int ct_hknh){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String query = "{CALL LuuLopSVDK(?, ?, ?, ?, ?, ?, ?, ?)}";
            PreparedStatement stmt = (PreparedStatement) connect.prepareStatement(query);
            stmt.setString(1, maSV);
            stmt.setString(2, maMH);
            stmt.setInt(3, maNhom);
            stmt.setInt(4, tietBD);
            stmt.setInt(5, thu);
            stmt.setString(6, ngayBD);
            stmt.setString(7, phong);
            stmt.setInt(8, ct_hknh);
            stmt.addBatch();
            stmt.executeBatch();
            stmt.close();
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }

}


package dao;

import entity.CT_Nhom;
import entity.HocKy;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sqlserver_connection.ConnectionHelper;


public class CT_NhomDAO {
    
    public List<CT_Nhom> getListCT_Nhom() {
        List<CT_Nhom> listCTN = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM CT_Nhom";
            CallableStatement stmt = connect.prepareCall(SQL);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int id_ctn = result.getInt("IDCTN");
                int maNhom = result.getInt("MaNhom");
                String maLTC = result.getString("MaLopTC");
                int slTD = result.getInt("SoLuongTD");
                int slDK = result.getInt("SoLuongDaDK");
                int maPNCThucHanh = result.getInt("MaPNCThucHanh");
                CT_Nhom ctn = new CT_Nhom(id_ctn, maNhom, maLTC, slTD, slDK, maPNCThucHanh);
                listCTN.add(ctn);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return listCTN;
    }
    
    
    public CT_Nhom getCT_NhomByMaLopAndMaNhom(String malop, int mnhom) {
        CT_Nhom CTN = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM CT_Nhom WHERE ";
            CallableStatement stmt = connect.prepareCall(SQL);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int id_ctn = result.getInt("IDCTN");
                int maNhom = result.getInt("MaNhom");
                String maLTC = result.getString("MaLopTC");
                int slTD = result.getInt("SoLuongTD");
                int slDK = result.getInt("SoLuongDaDK");

                CTN = new CT_Nhom(id_ctn, maNhom, maLTC, slTD, slDK);
                
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return CTN;
    }

    public CT_Nhom getCT_NhomByID(int maCT_Nhom) {
        CT_Nhom CTN = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM CT_Nhom WHERE IDCTN = ?";
            CallableStatement cbsm = connect.prepareCall(SQL);
            cbsm.setInt(1, maCT_Nhom);
            ResultSet result = cbsm.executeQuery();
            while (result.next()) {

                int id_ctn = result.getInt("IDCTN");
                int maNhom = result.getInt("MaNhom");
                String maLTC = result.getString("MaLopTC");
                int slTD = result.getInt("SoLuongTD");
                int slDK = result.getInt("SoLuongDaDK");

                CTN = new CT_Nhom(id_ctn, maNhom, maLTC, slTD, slDK);
                
            }
            cbsm.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return CTN;
    }    
    
}

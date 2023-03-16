
package dao;

import entity.HocKy;
import entity.LopTinChi;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sqlserver_connection.ConnectionHelper;


public class HocKyDAO {
    
    public List<HocKy> getListHocKy() {
        List<HocKy> listHK = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM HocKy";
            Statement stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
            while (result.next()) {
                
                int maHK = result.getInt("MaHocKy");
                String tenhk = result.getString("TenHocKy");
                
                HocKy hocKy = new HocKy(maHK, tenhk);
                listHK.add(hocKy);                
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return listHK;
    }
    
    public HocKy getHocKyByID(int maHK){
        HocKy hk = new HocKy();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM HocKy WHERE MaHocKy = ?";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setInt(1, maHK);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while (result.next()) {
                int maHocKy = result.getInt("MaHocKy");
                String tenHocKy = result.getString("TenHocKy");
                
                hk = new HocKy(maHocKy, tenHocKy);
            }
            csmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hk;
    }
    public HocKy getHocKyByName(String tenHK){
        HocKy hk = new HocKy();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM HocKy WHERE TenHocKy = ?";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setString(1, tenHK);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while (result.next()) {
                int maHocKy = result.getInt("MaHocKy");
                String tenHocKy = result.getString("TenHocKy");
                
                hk = new HocKy(maHocKy, tenHocKy);
            }
            csmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hk;
    }    
    public HocKy getCurrentHocKy(int maHocKy) {
        HocKy hocKy = new HocKy();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM HocKy WHERE MaHocKy = ?";
            CallableStatement stmt = connect.prepareCall(SQL);
            stmt.setInt(1, maHocKy);
            
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maHK = result.getInt("MaHocKy");
                String tenhk = result.getString("TenHocKy");

                hocKy = new HocKy(maHK, tenhk);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return hocKy;
    }
        //Lay hoc bi chuan bi dang ky
    public HocKy getNextCurrentHocKy(int maHocKy) {
        HocKy hocKy = new HocKy();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM HocKy WHERE MaHocKy = ?";
            CallableStatement stmt = connect.prepareCall(SQL);
            stmt.setInt(1, maHocKy);
            
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maHK = result.getInt("MaHocKy");
                String tenhk = result.getString("TenHocKy");

                hocKy = new HocKy(maHK, tenhk);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return hocKy;
    }
}

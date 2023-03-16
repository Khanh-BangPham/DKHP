package dao;


import entity.MonHoc;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sqlserver_connection.ConnectionHelper;

public class MonHocDAO {

    public List<MonHoc> getListMonHoc() {
        List<MonHoc> listMH = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM MonHoc";
            Statement stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
            while (result.next()) {
                String maMH = result.getString("MaMH");
                String tenMH = result.getString("TenMH");
                int soTinChi = result.getInt("SoTinChi");
                MonHoc monHoc = new MonHoc(maMH, tenMH, soTinChi);
                listMH.add(monHoc);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return listMH;
    }
    public int addMonHocToDB(MonHoc mh){
       
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "INSERT INTO MonHoc(MaMH, TenMH, SoTinChi) "
                    + " values (?, ?, ?)";
            stmt = connect.prepareStatement(SQL);
            stmt.setString(1, mh.getMaMonHoc());
            stmt.setString(2, mh.getTenMonhoc());
            stmt.setInt(3, mh.getSoTicChi());          
            if(stmt.executeUpdate() > 0){
                System.out.println("Insert's successed!");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                stmt.close();
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return -1;
    }
        
    public MonHoc getMonHocByID(String maMonHoc){
    MonHoc mh = new MonHoc();
    ConnectionHelper connectionHelper = new ConnectionHelper();
    Connection connect = null; 
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC SelectMHByID @MaMH = ?";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setString(1, maMonHoc);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while(result.next()){
                String maMH = result.getString("MaMH");
                String tenMonHoc = result.getString("TenMH");
                int soTinChi = result.getInt("SoTinChi");
                mh = new MonHoc(maMH, tenMonHoc, soTinChi);
            }
            csmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return mh;    
    }
    public int editMonHocToDB(MonHoc mh){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC UpdateMHByID @MaMH = ?, @TenMH = ?, @SoTinChi = ?";
            

            stmt = connect.prepareStatement(SQL);
            stmt.setString(1, mh.getMaMonHoc());
            stmt.setString(2, mh.getTenMonhoc());
            stmt.setInt(3, mh.getSoTicChi());
            
            if(stmt.executeUpdate() > 0){
                System.out.println("Insert's successed!");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                stmt.close();
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return -1;       
    }
    public int delMonHocByID(String maMH){
        MonHoc mh = new MonHoc();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;     
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC DelMHByID @MaMH = ?";
            CallableStatement csmt = connect.prepareCall(SQL);  
            csmt.setString(1, maMH);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            csmt.close();
            result.close();
            return 1;
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return -1;
    }
    public int checkMonHocLopTinChiByID(String maMH){
        int check = -1;
        MonHoc mh = new MonHoc();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;     
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT COUNT(*) AS COUNT FROM LopTinChi WHERE MaMH = ?";
            CallableStatement csmt = connect.prepareCall(SQL);  
            csmt.setString(1, maMH);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while(result.next()){
                check = result.getInt("COUNT");                
            }
            csmt.close();
            result.close();
            if(check > 0) return -1;
            return 1;
        } catch (Exception e) { 
            e.printStackTrace();
        }     
    return -1;
    }
    
    public MonHoc getMonHocByName(String tenMH){
        MonHoc mh = new MonHoc();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;     
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM MonHoc WHERE TenMonHoc = ?";
            CallableStatement csmt = connect.prepareCall(SQL);  
            csmt.setString(1, tenMH);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while(result.next()){
                String maMH = result.getString("MaMH");
                String tenMonHoc = result.getString("TenMH");
                int soTinChi = result.getInt("SoTinChi");
                mh = new MonHoc(maMH, tenMonHoc, soTinChi);
            }
            csmt.close();
            result.close();
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return mh;
    }    
}

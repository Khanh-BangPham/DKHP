package dao;

import entity.NamHoc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import sqlserver_connection.ConnectionHelper;

public class NamHocDAO {

    public List<NamHoc> getListNamHoc() {
        List<NamHoc> listNH = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM NamHoc";
            CallableStatement stmt = connect.prepareCall(SQL);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maNH = result.getInt("maNamHoc");
                String tenNH = result.getString("TenNamHoc");

                NamHoc namHoc = new NamHoc(maNH, tenNH);
                listNH.add(namHoc);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return listNH;
    }

    public NamHoc getNamHocByID(int maNH) {
        NamHoc namHoc = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM NamHoc WHERE MaNamHoc = ?";
            CallableStatement stmt = connect.prepareCall(SQL);

            stmt.setInt(1, maNH);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maNamHoc = result.getInt("MaNamHoc");
                String tenNamHoc = result.getString("TenNamHoc");

                namHoc = new NamHoc(maNamHoc, tenNamHoc);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return namHoc;
    }
    public NamHoc getNamHocByName(String tenNH) {
        NamHoc namHoc = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM NamHoc WHERE TenNamHoc = ?";
            CallableStatement stmt = connect.prepareCall(SQL);

            stmt.setString(1, tenNH);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maNH = result.getInt("maNamHoc");
                String tenNamHoc = result.getString("TenNamHoc");

                namHoc = new NamHoc(maNH, tenNamHoc);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return namHoc;
    }

    public NamHoc getCurrentNamHoc(int maNamHoc) {
        NamHoc namHoc = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM NamHoc WHERE maNamHoc = ?";
            CallableStatement stmt = connect.prepareCall(SQL);

            stmt.setInt(1, maNamHoc);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maNH = result.getInt("maNamHoc");
                String tenNamHoc = result.getString("TenNamHoc");

                namHoc = new NamHoc(maNH, tenNamHoc);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return namHoc;
    }
    public NamHoc getLastNamHoc() {
        NamHoc namHoc = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM NamHoc WHERE maNamHoc = (SELECT MAX(MaNamHoc) FROM NamHoc)";
            CallableStatement stmt = connect.prepareCall(SQL);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maNH = result.getInt("maNamHoc");
                String tenNamHoc = result.getString("TenNamHoc");

                namHoc = new NamHoc(maNH, tenNamHoc);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return namHoc;
    }
     public int addNamHocToBD(String tenNH) {
        NamHoc namHoc = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "INSERT INTO NamHoc(TenNamHoc) VALUES (?)";
            PreparedStatement stmt = connect.prepareCall(SQL);

            stmt.setString(1, tenNH);

            if(stmt.executeUpdate() > 0){
                System.out.println("Insert's successed!");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return 1;
    }   
     public int delNamHocByIDToBD(int maNH) {
        NamHoc namHoc = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "DELETE FROM NamHoc WHERE MaNamHoc = ?";
            PreparedStatement stmt = connect.prepareCall(SQL);

            stmt.setInt(1, maNH);

            if(stmt.executeUpdate() > 0){
                System.out.println("Insert's successed!");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return 1;
    } 
    public NamHoc getNextCurrentNamHoc(int maNamHoc) {
        NamHoc namHoc = new NamHoc();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM NamHoc WHERE maNamHoc = ?";
            CallableStatement stmt = connect.prepareCall(SQL);

            stmt.setInt(1, maNamHoc);

            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maNH = result.getInt("maNamHoc");
                String tenNamHoc = result.getString("TenNamHoc");

                namHoc = new NamHoc(maNH, tenNamHoc);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return namHoc;
    }
}

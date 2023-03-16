package dao;

import entity.CT_HocKy_NamHoc;
import entity.HocKy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sqlserver_connection.ConnectionHelper;

public class CT_HocKy_NamHoc_DAO {

    public List<CT_HocKy_NamHoc> getListCT_HocKy_NamHoc() {
        List<CT_HocKy_NamHoc> listHKNH = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM CT_HocKy_NamHoc";
            CallableStatement stmt = connect.prepareCall(SQL);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maCT = result.getInt("ID_CTHKNH");
                int maHK = result.getInt("MaHocKy");
                int maNH = result.getInt("MaNamHoc");
                int idgtc = result.getInt("IDGTC");
                Date ngayBD = result.getDate("NgayBatDau");
                Date ngayKT = result.getDate("NgayKetThuc");
                CT_HocKy_NamHoc cthknh = new CT_HocKy_NamHoc(idgtc, maHK, maNH, idgtc, ngayBD, ngayKT);
                listHKNH.add(cthknh);

            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return listHKNH;
    }

    public CT_HocKy_NamHoc getCTHKNHCurrent() {
        CT_HocKy_NamHoc HKNH = new CT_HocKy_NamHoc();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM CT_HocKy_NamHoc  WHERE NgayBatDau <=  ? AND NgayKetThuc >= ?";
            CallableStatement stmt = connect.prepareCall(SQL);
            Date currentDate = new Date();
           stmt.setDate(1, new java.sql.Date(currentDate.getTime()));
           stmt.setDate(2, new java.sql.Date(currentDate.getTime()));
            
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maCT = result.getInt("ID_CTHKNH");
                int maHK = result.getInt("MaHocKy");
                int maNH = result.getInt("MaNamHoc");
                int idgtc = result.getInt("IDGTC");
                Date ngayBD = result.getDate("NgayBatDau");
                Date ngayKT = result.getDate("NgayKetThuc");

                HKNH = new CT_HocKy_NamHoc(maCT, maHK, maNH, idgtc, ngayBD, ngayKT);

            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return HKNH;
    }
    public CT_HocKy_NamHoc getNextCTHKNHCurrent() {
        CT_HocKy_NamHoc HKNH = new CT_HocKy_NamHoc();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM CT_HocKy_NamHoc  WHERE ? <= NgayBatDau";
            CallableStatement stmt = connect.prepareCall(SQL);
            Date currentDate = new Date();
           stmt.setDate(1, new java.sql.Date(currentDate.getTime()));
            
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maCT = result.getInt("ID_CTHKNH");
                int maHK = result.getInt("MaHocKy");
                int maNH = result.getInt("MaNamHoc");
                int idgtc = result.getInt("IDGTC");
                Date ngayBD = result.getDate("NgayBatDau");
                Date ngayKT = result.getDate("NgayKetThuc");

                HKNH = new CT_HocKy_NamHoc(maCT, maHK, maNH, idgtc, ngayBD, ngayKT);

            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return HKNH;
    }
        
    public CT_HocKy_NamHoc getCT_HocKy_NamHocByNH_HK(int maHocKy, int maNamHoc) {
        CT_HocKy_NamHoc HKNH = new CT_HocKy_NamHoc();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM CT_HocKy_NamHoc WHERE MaHocKy = ? AND MaNamHoc = ?";
            CallableStatement stmt = connect.prepareCall(SQL);
            stmt.setInt(1, maHocKy);
            stmt.setInt(2, maNamHoc);
            System.out.println(maHocKy + " " + maNamHoc);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maCT = result.getInt("ID_CTHKNH");
                int maHK = result.getInt("MaHocKy");
                int maNH = result.getInt("MaNamHoc");
                int idgtc = result.getInt("IDGTC");
                Date ngayBD = result.getDate("NgayBatDau");
                Date ngayKT = result.getDate("NgayKetThuc");

                HKNH = new CT_HocKy_NamHoc(maCT, maHK, maNH, idgtc, ngayBD, ngayKT);

            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return HKNH;
    }
    public CT_HocKy_NamHoc getCT_HocKy_NamHocByNameNH_HK(String tenHocKy, String tenNamHoc) {
        CT_HocKy_NamHoc HKNH = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * " +
            "FROM (SELECT * FROM HocKy WHERE TenHocKy = ?) AS HK," +
            " (SELECT * FROM NamHoc WHERE NamHoc.TenNamHoc = ?) AS NH," +
            " CT_HocKy_NamHoc" +
            " WHERE CT_HocKy_NamHoc.MaHocKy = HK.MaHocKy AND CT_HocKy_NamHoc.MaNamHoc = NH.MaNamHoc";
            CallableStatement stmt = connect.prepareCall(SQL);
            stmt.setString(1, tenHocKy);
            stmt.setString(2, tenNamHoc);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maCT = result.getInt("ID_CTHKNH");
                int maHK = result.getInt("MaHocKy");
                int maNH = result.getInt("MaNamHoc");
                int idgtc = result.getInt("IDGTC");
                Date ngayBD = result.getDate("NgayBatDau");
                Date ngayKT = result.getDate("NgayKetThuc");

                HKNH = new CT_HocKy_NamHoc(maCT, maHK, maNH, idgtc, ngayBD, ngayKT);

            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return HKNH;
    }        
    public CT_HocKy_NamHoc getCT_HocKy_NamHocByID(int idcthknh) {
        CT_HocKy_NamHoc HKNH = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM CT_HocKy_NamHoc WHERE ID_CTHKNH = ?";
            CallableStatement stmt = connect.prepareCall(SQL);
            stmt.setInt(1, idcthknh);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {

                int maCT = result.getInt("ID_CTHKNH");
                int maHK = result.getInt("MaHocKy");
                int maNH = result.getInt("MaNamHoc");
                int idgtc = result.getInt("IDGTC");
                Date ngayBD = result.getDate("NgayBatDau");
                Date ngayKT = result.getDate("NgayKetThuc");

                HKNH = new CT_HocKy_NamHoc(maCT, maHK, maNH, idgtc, ngayBD, ngayKT);

            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return HKNH;
    }    
    public int addCT_HocKy_NamHocToDB(CT_HocKy_NamHoc cthknh){

        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "INSERT INTO CT_HOCKY_NAMHOC (MaHocKy, MaNamHoc, IDGTC, NgayBatDau, NgayKetThuc) VALUES (?, ?, ?, ?, ?)";
            stmt = connect.prepareStatement(SQL);
            stmt.setInt(1, cthknh.getMaHocKy());
            stmt.setInt(2, cthknh.getMaNamHoc());
            stmt.setInt(3, cthknh.getIdgtc());
            stmt.setDate(4, new java.sql.Date(cthknh.getNgayBatDau().getTime()));
            stmt.setDate(5, new java.sql.Date(cthknh.getNgayKetThuc().getTime())); 
            if(stmt.executeUpdate() > 0){
                System.out.println("Insert's successed!");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
            
        } finally{
            try {
                stmt.close();
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return 1;
    }    
    public int editCT_HocKy_NamHocToDB(CT_HocKy_NamHoc cthknh){

        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "UPDATE CT_HOCKY_NAMHOC SET MaHocKy = ?, MaNamHoc = ?, IDGTC = ?, NgayBatDau = ?, NgayKetThuc = ? WHERE ID_CTHKNH = ?";
            stmt = connect.prepareStatement(SQL);
            stmt.setInt(1, cthknh.getMaHocKy());
            stmt.setInt(2, cthknh.getMaNamHoc());
            stmt.setInt(3, cthknh.getIdgtc());
            stmt.setDate(4, new java.sql.Date(cthknh.getNgayBatDau().getTime()));
            stmt.setDate(5, new java.sql.Date(cthknh.getNgayKetThuc().getTime())); 
            stmt.setInt(6, cthknh.getId_cthknh());
            if(stmt.executeUpdate() > 0){
                System.out.println("Insert's successed!");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
            
        } finally{
            try {
                stmt.close();
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return 1;
    }  
    public int delCT_HocKy_NamHocToDB(int idcthknh){

        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC DelHKNH @ID_CTHKNH = ?";
            stmt = connect.prepareStatement(SQL);
            stmt.setInt(1, idcthknh);
  
            if(stmt.executeUpdate() > 0){
                System.out.println("Insert's successed!");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
            
        } finally{
            try {
                stmt.close();
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return 1;
    }    
    public int checkCT_HocKy_NamHocAndLTC(int idcthknh){

        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        int rs = -1;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT COUNT(MaLopTC) AS RS " +
            "	FROM LopTinChi WHERE ID_CTHKNH = ?";
            stmt = connect.prepareStatement(SQL);
            stmt.setInt(1, idcthknh);
            
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                rs = result.getInt("RS");
                return rs;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
            
        } finally{
            try {
                stmt.close();
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    return rs;
    }    
}

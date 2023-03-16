
package dao;

import entity.LopTinChi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sqlserver_connection.ConnectionHelper;

public class LopTinChiDAO {
    public List<LopTinChi> getListLopTinChi() {
        List<LopTinChi> listLTC = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT MaLopTC, MaMH, TietBatDau, ThuTrongTuan, Phong, Phong_Ngay_Ca.NgayBatDau, Phong_Ngay_Ca.NgayKetThuc, TenHocKy, TenNamHoc, SoNhomTH" +
"                FROM LopTinChi " +
"                LEFT JOIN Phong_Ngay_Ca ON MaPNCLyThuyet = Phong_Ngay_Ca.MaPNC " +
"                LEFT JOIN CT_HocKy_NamHoc ON LopTinChi.ID_CTHKNH = CT_HocKy_NamHoc.ID_CTHKNH " +
"                LEFT JOIN NamHoc ON CT_HocKy_NamHoc.MaNamHoc = NamHoc.MaNamHoc " +
"                LEFT JOIN HocKy ON CT_HocKy_NamHoc.MaHocKy = HocKy.MaHocKy  ";
            CallableStatement cbmt = connect.prepareCall(SQL);
            cbmt.executeQuery();
            ResultSet result = cbmt.getResultSet();
            while (result.next()) {
                String maLopTC = result.getString("MaLopTC");
                String maMH = result.getString("MaMH");
                int tietBD = result.getInt("TietBatDau");
                int thu = result.getInt("ThuTrongTuan");
                int soNhomTH = result.getInt("SoNhomTH");
                String phong = result.getString("Phong");
                String hocKy = result.getString("TenHocKy");
                String namHoc = result.getString("TenNamHoc");
                Date ngayBD = result.getDate("NgayBatDau");
                Date ngayKT = result.getDate("NgayKetThuc");    
                listLTC.add(new LopTinChi(maLopTC, maMH, hocKy, namHoc, tietBD, phong, ngayBD, ngayKT, thu, soNhomTH)); 
            }
            cbmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return listLTC;
    }
    public LopTinChi getLTCByID(String maLTC) {
        LopTinChi ltc = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT MaLopTC, MaMH, TietBatDau, ThuTrongTuan, Phong, Phong_Ngay_Ca.NgayBatDau, Phong_Ngay_Ca.NgayKetThuc, TenHocKy, TenNamHoc, SoNhomTH " +
                "FROM LopTinChi " +
                "LEFT JOIN Phong_Ngay_Ca ON MaPNCLyThuyet = Phong_Ngay_Ca.MaPNC " +
                "LEFT JOIN CT_HocKy_NamHoc ON LopTinChi.ID_CTHKNH = CT_HocKy_NamHoc.ID_CTHKNH " +
                "LEFT JOIN NamHoc ON CT_HocKy_NamHoc.MaNamHoc = NamHoc.MaNamHoc " +
                "LEFT JOIN HocKy ON CT_HocKy_NamHoc.MaHocKy = HocKy.MaHocKy " +
                "WHERE MaLopTC = ?";
            CallableStatement cbmt = connect.prepareCall(SQL);
            cbmt.setString(1, maLTC);
            cbmt.executeQuery();
            ResultSet result = cbmt.getResultSet();
            while (result.next()) {
                String maLopTC = result.getString("MaLopTC");
                String maMH = result.getString("MaMH");
                int tietBD = result.getInt("TietBatDau");
                int thu = result.getInt("ThuTrongTuan");
                int soNhomTH = result.getInt("SoNhomTH");
                String phong = result.getString("Phong");
                String hocKy = result.getString("TenHocKy");
                String namHoc = result.getString("TenNamHoc");
                Date ngayBD = result.getDate("NgayBatDau");
                Date ngayKT = result.getDate("NgayKetThuc");    
                
                ltc = new LopTinChi(maLopTC, maMH, hocKy, namHoc, tietBD, phong, ngayBD, ngayKT, thu, soNhomTH);
            }
            cbmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return ltc;
    }
    public int addLopTinChiToDB(LopTinChi ltc, List<String> listMaGv){
        
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC InsertToLopTinChi @MaLopTC = ?, @MaMH = ?, @HocKy = ?, @NamHoc = ?, @TietBatDau = ?, @Thu = ?, @Phong = ?, @NgayBatDau = ?, @NgayKetThuc= ?, @SoNhomTH = ?, @MaGV1 = ?, @MaGV2 = ?";
            stmt = connect.prepareStatement(SQL);
            stmt.setString(1, ltc.getMaLopTinChi());
            stmt.setString(2, ltc.getMaMonHoc());
            stmt.setString(3, ltc.getHocKy());
            stmt.setString(4, ltc.getNamHoc());
            stmt.setInt(5, ltc.getTietBatDau());
            stmt.setInt(6, ltc.getThu());
            stmt.setString(7, ltc.getPhong());
            stmt.setDate(8, new java.sql.Date(ltc.getNgayBD().getTime()));
            stmt.setDate(9, new java.sql.Date(ltc.getNgayKT().getTime()));
            stmt.setInt(10, ltc.getSoNhomTH());
            stmt.setString(11, listMaGv.get(0)); 
            stmt.setString(12, listMaGv.get(1)); 
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
     public int editLopTinChiToDB(LopTinChi ltc, List<String> listMaGv){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC UpadteLopTinChi @MaLopTC = ?, @MaMH = ?, @HocKy = ?, @NamHoc = ?, @TietBatDau = ?, @Thu = ?, @Phong = ?, @NgayBatDau = ?, @NgayKetThuc= ?, @SoNhomTH = ? , @MaGV1 = ?, @MaGV2 = ?";
            stmt = connect.prepareStatement(SQL);
            stmt.setString(1, ltc.getMaLopTinChi());
            stmt.setString(2, ltc.getMaMonHoc());
            stmt.setString(3, ltc.getHocKy());
            stmt.setString(4, ltc.getNamHoc());
            stmt.setInt(5, ltc.getTietBatDau());
            stmt.setInt(6, ltc.getThu());
            stmt.setString(7, ltc.getPhong());
            stmt.setDate(8, new java.sql.Date(ltc.getNgayBD().getTime()));
            stmt.setDate(9, new java.sql.Date(ltc.getNgayKT().getTime()));
            stmt.setInt(10, ltc.getSoNhomTH());
            stmt.setString(11, listMaGv.get(0)); 
            stmt.setString(12, listMaGv.get(1)); 
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
    return 1;       
    }
    public int delLopTinChiByID(String MaLTC){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC DelLTCByID @MaLTC = ?";
            stmt = connect.prepareStatement(SQL);
            stmt.setString(1, MaLTC);
            if(stmt.executeUpdate() > 0){
                System.out.println("Deleted's successed!");
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
        public LopTinChi getLopTicChiByMaMH(String mMH) {
       LopTinChi LTC = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM LopTinChi WHERE MaMH = ?";
            CallableStatement stmt = connect.prepareCall(SQL);
            stmt.setString(1, mMH);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                String maLTC = result.getString("MaLopTC");
                String maMH = result.getString("MaMH");
                int id_ctn = result.getInt("ID_CTHKNH");
                
               LTC = new LopTinChi(maLTC, maMH, id_ctn);
               
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }

        return LTC;
    }
}

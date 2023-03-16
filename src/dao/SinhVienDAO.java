/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.GiangVien;
import sqlserver_connection.ConnectionHelper;
import java.sql.Connection;
import java.util.List;
import entity.SinhVien;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author PC
 */
public class SinhVienDAO {

    public SinhVienDAO() {
    }

    public List<SinhVien> getListSinhVien() {
        List<SinhVien> listSV = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM SinhVien";
            Statement stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
            while (result.next()) {
                String MaSV = result.getString("MaSV");
                String Ho = result.getString("Ho");
                String TenDem = result.getString("TenDem");
                String Ten = result.getString("Ten");
                boolean Phai = result.getBoolean("Phai");
                Date NgaySinh = result.getDate("NgaySinh");
                String LopKhoaHoc = result.getString("LopKhoaHoc");
                String ChuongTrinhDaoTao = result.getString("ChuongTrinhDaoTao");
                String SoDienThoai1 = result.getString("SoDienThoai_1");
                String SoDienThoai2 = result.getString("SoDienThoai_2");
                String Email1 = result.getString("Email_1");
                String Email2 = result.getString("Email_2");
                boolean NghiHoc = result.getBoolean("NghiHoc");
                int MaNganh = result.getInt("MaNganh");
                int MaQQ = result.getInt("MaQQ");
                
                SinhVien sv = new SinhVien(MaSV, Ho, TenDem, Ten, Phai, NgaySinh, LopKhoaHoc, ChuongTrinhDaoTao, SoDienThoai1, SoDienThoai2, Email1, Email2, NghiHoc, MaNganh, MaQQ);
                listSV.add(sv);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }
        
        return listSV;
    }
    public int addSinhVienToDB(SinhVien sv){
        
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "INSERT INTO SinhVien(MaSV, Ho, Tendem, Ten, Phai, NgaySinh, LopKhoaHoc, ChuongTrinhDaoTao, SoDienThoai_1, SoDienThoai_2, Email_1, Email_2, NghiHoc, MaNganh, MaQQ) "
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = connect.prepareStatement(SQL);
            stmt.setString(1, sv.getMaSV());
            stmt.setString(2, sv.getHo());
            stmt.setString(3, sv.getTenDem());
            stmt.setString(4, sv.getTen());
            stmt.setBoolean(5, sv.isPhai());
            stmt.setDate(6, new java.sql.Date(sv.getNgaySinh().getTime()));
            stmt.setString(7, sv.getLopKhoaHoc());
            stmt.setString(8, sv.getChuongTrinhDaoTao());
            stmt.setString(9, sv.getSoDienThoai1());
            stmt.setString(10, sv.getSoDienThoai2());
            stmt.setString(11, sv.getEmail1());
            stmt.setString(12, sv.getEmail2());
            stmt.setBoolean(13, sv.isNghiHoc());
            stmt.setInt(14, sv.getMaNganh());
            stmt.setInt(15, sv.getMaQQ());
            
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
    
    public SinhVien getSinhVienByID(String MaSinhVien){
    SinhVien sv = new SinhVien();
    ConnectionHelper connectionHelper = new ConnectionHelper();
    Connection connect = null; 
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC SelectSVByID @MaSV = ?";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setString(1, MaSinhVien);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while(result.next()){
                String maGV = result.getString("MaSV");
                String ho = result.getString("Ho");
                String tenDem = result.getString("Tendem");
                String ten = result.getString("Ten");
                Date ngaySinh = result.getDate("NgaySinh");
                boolean phai = result.getBoolean("Phai");
                String lopKhoaHoc = result.getString("LopKhoaHoc");
                String chuongTrinhDaoTao = result.getString("ChuongTrinhDaoTao");
                String soDienThoai1 = result.getString("SoDienThoai_1");
                String soDienThoai2 = result.getString("SoDienThoai_2");
                String email1 = result.getString("Email_1");
                String email2 = result.getString("Email_2");
                boolean nghiLam = result.getBoolean("NghiHoc");
                int maNganh = result.getInt("MaNganh");
                int maQQ = result.getInt("MaQQ");
                sv = new SinhVien(maGV, ho, tenDem, ten, phai, ngaySinh, lopKhoaHoc, chuongTrinhDaoTao, soDienThoai1, soDienThoai2, email1, email2, nghiLam, maNganh, maQQ);
            }
            csmt.close();   
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return sv;    
    }
    public int editSinhVienToDB(SinhVien sv){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC UpdateSVByID @MaSV = ?, @Ho = ?, @TenDem = ?, @Ten = ?, @Phai = ?, @NgaySinh = ?,"
            + " @LopKhoaHoc = ?, @ChuongTrinhDaoTao = ?, @SoDienThoai_1 = ?, @SoDienThoai_2 = ?, @Email_1 = ?, @Email_2 = ?,"
            + " @NghiHoc = ?, @MaNganh = ?, @MaQQ = ?";
            stmt = connect.prepareStatement(SQL);
            stmt.setString(1, sv.getMaSV());
            stmt.setString(2, sv.getHo());
            stmt.setString(3, sv.getTenDem());
            stmt.setString(4, sv.getTen());
            stmt.setBoolean(5, sv.isPhai());
            stmt.setDate(6, new java.sql.Date(sv.getNgaySinh().getTime()));
            stmt.setString(7, sv.getLopKhoaHoc());
            stmt.setString(8, sv.getChuongTrinhDaoTao());
            stmt.setString(9, sv.getSoDienThoai1());
            stmt.setString(10, sv.getSoDienThoai2());
            stmt.setString(11, sv.getEmail1());
            stmt.setString(12, sv.getEmail2());
            stmt.setBoolean(13, sv.isNghiHoc());
            stmt.setInt(14, sv.getMaNganh());
            stmt.setInt(15, sv.getMaQQ());
            
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
    public int delSinhVienByID(String maSV){
        SinhVien sv = new SinhVien();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;     
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC DelSVByID @MaSV = ?";
            CallableStatement csmt = connect.prepareCall(SQL);  
            csmt.setString(1, maSV);
            csmt.execute();
            return 1;
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return -1;
    }
    public int checkSVDangKyByID(String maSV){
        int check = -1;
        SinhVien sv = new SinhVien();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;     
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT COUNT(*) AS COUNT FROM DangKy WHERE MaSV = ?";
            CallableStatement csmt = connect.prepareCall(SQL);  
            csmt.setString(1, maSV);
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
        public void updateSinhVien(String maSV, String email, String sdt) {

        ConnectionHelper connectionHelper = new ConnectionHelper();
        CallableStatement stmt = null;
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();

            String query = "{CALL SuaSinhVien(?, ?, ?)}";

            stmt = connect.prepareCall(query);
            stmt.setString(1, maSV);
            stmt.setString(2, sdt);
            stmt.setString(3, email);
            boolean result = stmt.execute();

            stmt.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.GiangVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import sqlserver_connection.ConnectionHelper;

/**
 *
 * @author PC
 */
public class GiangVienDAO {

    public GiangVienDAO() {
    }
    public List<GiangVien> getListGiangVien() {
        List<GiangVien> listGV = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT MaGV, Ho, Ten, Tendem, NgaySinh, SoDienThoai_1, SoDienThoai_2, Email_1, Email_2, NghiLam, MaQQ, GhiChu, MaHocVi" 
                        + " FROM GiangVien AS GV";
            Statement stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
            while (result.next()) {
                String maGV = result.getString("MaGV");
                String ho = result.getString("Ho");
                String tenDem = result.getString("Tendem");
                String ten = result.getString("Ten");
                Date ngaySinh = result.getDate("NgaySinh");
                String soDienThoai1 = result.getString("SoDienThoai_1");
                String soDienThoai2 = result.getString("SoDienThoai_2");
                String email1 = result.getString("Email_1");
                String email2 = result.getString("Email_2");
                boolean nghiLam = result.getBoolean("NghiLam");
                int maQQ = result.getInt("MaQQ");
                String ghiChu = result.getString("GhiChu");
                String hocVi = result.getString("MaHocVi");
                GiangVien gv = new GiangVien(maGV, ho, tenDem, ten, ngaySinh, hocVi, nghiLam, soDienThoai1, soDienThoai2, email1, email2, ghiChu, maQQ);
                listGV.add(gv);
            }
            stmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }
        
        return listGV;
    }
    
    public int addGiangVienToDB(GiangVien gv){
        
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "INSERT INTO GiangVien(MaGV, Ho, Tendem, Ten, NgaySinh, SoDienThoai_1, SoDienThoai_2, Email_1, Email_2, NghiLam, MaQQ, GhiChu, MaHocVi) "
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = connect.prepareStatement(SQL);
            stmt.setString(1, gv.getMaGV());
            stmt.setString(2, gv.getHo());
            stmt.setString(3, gv.getTenDem());
            stmt.setString(4, gv.getTen());
            stmt.setDate(5, new java.sql.Date(gv.getNgaySinh().getTime()));
            stmt.setString(6, gv.getSoDienThoai1());
            stmt.setString(7, gv.getSoDienThoai2());
            stmt.setString(8, gv.getEmail1());
            stmt.setString(9, gv.getEmail2());
            stmt.setBoolean(10, gv.isNghiLam());
            stmt.setInt(11, gv.getmaQQ());
            stmt.setString(12, gv.getGhiChu());
            stmt.setString(13, gv.getMaHocVi());
            
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
    
    public GiangVien getGiangVienByID(String MaGiangVien){
    GiangVien gv = new GiangVien();
    ConnectionHelper connectionHelper = new ConnectionHelper();
    Connection connect = null; 
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC SelectGVByID @MaGV = ?";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setString(1, MaGiangVien);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while(result.next()){
                String maGV = result.getString("MaGV");
                String ho = result.getString("Ho");
                String tenDem = result.getString("Tendem");
                String ten = result.getString("Ten");
                Date ngaySinh = result.getDate("NgaySinh");
                String soDienThoai1 = result.getString("SoDienThoai_1");
                String soDienThoai2 = result.getString("SoDienThoai_2");
                String email1 = result.getString("Email_1");
                String email2 = result.getString("Email_2");
                boolean nghiLam = result.getBoolean("NghiLam");
                int maQQ = result.getInt("MaQQ");
                String ghiChu = result.getString("GhiChu");
                String hocVi = result.getString("MaHocVi");
                gv = new GiangVien(maGV, ho, tenDem, ten, ngaySinh, hocVi, nghiLam, soDienThoai1, soDienThoai2, email1, email2, ghiChu, maQQ);
                return gv;
            }
            csmt.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    return gv;    
    }
    public int editGiangVienToDB(GiangVien gv){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC UpdateGVByID @MaGV = ?, @Ho = ?, @Tendem = ?, @Ten = ?, @NgaySinh = ?, " +
            "@SoDienThoai_1 = ?, @SoDienThoai_2 = ?, @Email_1 = ?, @Email_2 = ?, @NghiLam = ?, @MaQQ = ?, " +
            "@GhiChu = ?, @MaHocVi = ?";
            

            stmt = connect.prepareStatement(SQL);
            stmt.setString(1, gv.getMaGV());
            stmt.setString(2, gv.getHo());
            stmt.setString(3, gv.getTenDem());
            stmt.setString(4, gv.getTen());
            stmt.setDate(5, new java.sql.Date(gv.getNgaySinh().getTime()));
            stmt.setString(6, gv.getSoDienThoai1());
            stmt.setString(7, gv.getSoDienThoai2());
            stmt.setString(8, gv.getEmail1());
            stmt.setString(9, gv.getEmail2());
            stmt.setBoolean(10, gv.isNghiLam());
            stmt.setInt(11, gv.getmaQQ());
            stmt.setString(12, gv.getGhiChu());
            stmt.setString(13, gv.getMaHocVi());
            
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
    public int delGiangVienByID(String maGV){
        GiangVien gv = new GiangVien();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;     
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC DelGVByID @MaGV = ?";
            CallableStatement csmt = connect.prepareCall(SQL);  
            csmt.setString(1, maGV);
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
}


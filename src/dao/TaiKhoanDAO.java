/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import sqlserver_connection.ConnectionHelper;
import java.sql.Connection;
import java.util.List;
import entity.TaiKhoan;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Types;
/**
 *
 * @author PC
 */
public class TaiKhoanDAO {

    public TaiKhoanDAO() {
    }
    
    public List<TaiKhoan> getListTaiKhoan(){
        List<TaiKhoan> listTK = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT TK.TaiKhoan, TK.MatKhau, TK.TrangThai, TK.MaChucVu"
                    + " FROM TaiKhoan AS TK";
            
            Statement stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
            while(result.next()){                
                String tenTaiKhoan = result.getString("TaiKhoan");
                String matKhau = result.getString("MatKhau");
                boolean trangThai = result.getBoolean("TrangThai");
                String maChucVu = result.getString("MaChucVu"); 
                TaiKhoan tk = new TaiKhoan(tenTaiKhoan, matKhau, trangThai, maChucVu);
                listTK.add(tk);
            }
            stmt.close();
            result.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }
        return listTK;
    }
    
    public int createTaiKhoanToDB(TaiKhoan tk){
        
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "INSERT INTO TaiKhoan(TaiKhoan, MatKhau, TrangThai, MaChucVu)" +
            " VALUES (?, ?, ?, ?)";
            stmt = connect.prepareStatement(SQL);
            stmt.setString(1, tk.getTenTaiKhoan());
            stmt.setString(2, tk.getMatKhau());
            stmt.setBoolean(3, tk.isTrangThai());
            stmt.setString(4, tk.getMaChucVu());
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
    public int deleteTaiKhoanToDB(String tenTK){
        
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        PreparedStatement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "DELETE FROM TaiKhoan" +
            " WHERE TaiKhoan = ?";
            stmt = connect.prepareStatement(SQL);
            stmt.setString(1, tenTK);
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
        public String getTaiKhoanByMa(String taiKhoan, String matKhau) {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        boolean flag = false;

        try {
            connect = connectionHelper.getConnection();
            String SQL = "{CALL CheckTaiKhoan(?, ?)}";

            CallableStatement stmt = connect.prepareCall(SQL);
            stmt.setString(1, taiKhoan);
            stmt.setString(2, matKhau);
            ResultSet result = stmt.executeQuery();
            
            
            while(result.next()){
                int TrangThai = result.getInt("TrangThai");
                String MaChucVu = result.getString("MaChucVu");
                if(TrangThai == 0)
                     return MaChucVu;
            }
                
            
            stmt.close();
            result.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connectionHelper.closeConnection(connect);
        }
        return "";
    }

    public boolean updateMatKhau(String pwd, String taiKhoan, String newpwd) {

        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();

            String query = "{CALL ThayDoiMatKhau(?, ?, ?, ?)}";
//                    Statement stmt = connect.createStatement();
            CallableStatement stmt = connect.prepareCall(query);
            stmt.setString(1, taiKhoan);
            stmt.setString(2, pwd);
            stmt.setString(3, newpwd);
            stmt.setInt(4, 0);
            stmt.registerOutParameter(4, Types.INTEGER);
            
            stmt.execute();
            int exc = stmt.getInt(4);
//            System.out.println(exc);
            
            if(exc > 0)
                return true;
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

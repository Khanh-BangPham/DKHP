/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChucVu;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sqlserver_connection.ConnectionHelper;

/**
 *
 * @author PC
 */
public class ChucVuDAO {
    public List<ChucVu> getListChucVu(){
        List<ChucVu> listCv = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        Statement stmt = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT MaChucVu, TenChucVu FROM ChucVu";
            
            stmt = connect.createStatement();
            ResultSet result = stmt.executeQuery(SQL);
                while (result.next()) {
                String maHocVi = result.getString("MaChucVu");
                String tenHocVi = result.getString("TenChucVu");

                ChucVu cv = new ChucVu(maHocVi, tenHocVi);
                listCv.add(cv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCv;
    }    
    public ChucVu getChucVuByID(String maCV){
        ChucVu Cv = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT MaChucVu, TenChucVu FROM ChucVu WHERE MaChucVu = ?";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setString(1, maCV);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while (result.next()) {
                String maChucVu = result.getString("MaChucVu");
                String tenChucVu = result.getString("TenChucVu");

                Cv = new ChucVu(maChucVu, tenChucVu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Cv;
    }       
}

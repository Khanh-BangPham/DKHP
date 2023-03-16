/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Phong_Ngay_Ca;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import sqlserver_connection.ConnectionHelper;

/**
 *
 * @author PC
 */
public class Phong_Ngay_Ca_DAO {
    public Phong_Ngay_Ca getPhong_Ngay_CaByID(int maPNC){
        Phong_Ngay_Ca pnc = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "SELECT * FROM Phong_Ngay_Ca WHERE MaPNC = ?";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setInt(1, maPNC);
            csmt.executeQuery();
            ResultSet result = csmt.getResultSet();
            while (result.next()) {
                int maP_N_C = result.getInt("MaPNC");
                int tietBD = result.getInt("TietBatDau");
                int thu = result.getInt("ThuTrongTuan");
                String phong = result.getString("Phong");
                Date ngayBD = result.getDate("NgayBatDau");
                Date ngayKT = result.getDate("NgayKetThuc");

                pnc = new Phong_Ngay_Ca(maP_N_C, tietBD, ngayBD, ngayKT, phong, thu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pnc;
    }     
    
    public int mergePhong_Ngay_CaLyThuyet(int tietBD, Date ngayBD, Date ngayKT, String phong, int thu){
        Phong_Ngay_Ca pnc = null;
        ConnectionHelper connectionHelper = new ConnectionHelper();
        Connection connect = null;
        try {
            connect = connectionHelper.getConnection();
            String SQL = "EXEC MergePhongNgayCa @TietBatDau = ?, @NgayBatDau = ?, @NgayKetThuc = ?, @Phong = ?, @ThuTrongTuan = ?";
            CallableStatement csmt = connect.prepareCall(SQL);
            csmt.setInt(1, tietBD);
            csmt.setDate(2, new java.sql.Date(ngayBD.getTime()));
            csmt.setDate(3, new java.sql.Date(ngayKT.getTime()));
            csmt.setString(4, phong);
            csmt.setInt(5, thu);
            return csmt.executeUpdate();  
        } catch (Exception e) {
            e.printStackTrace();

        }
        return -1;
    }     
}
